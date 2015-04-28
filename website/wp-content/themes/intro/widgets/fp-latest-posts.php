<?php

class Intro_Posts extends WP_Widget {

// constructor
    function intro_posts() {
		$widget_ops = array('classname' => 'intro_posts_widget', 'description' => __( 'Show the latest posts from your blog.', 'intro') );
        parent::WP_Widget(false, $name = __('Intro FP: Latest posts', 'intro'), $widget_ops);
		$this->alt_option_name = 'intro_posts_widget';
		
		add_action( 'save_post', array($this, 'flush_widget_cache') );
		add_action( 'deleted_post', array($this, 'flush_widget_cache') );
		add_action( 'switch_theme', array($this, 'flush_widget_cache') );		
    }
	
	// widget form creation
	function form($instance) {

	// Check values
		$title     = isset( $instance['title'] ) ? esc_attr( $instance['title'] ) : '';
	?>

	<p>
	<label for="<?php echo $this->get_field_id('title'); ?>"><?php _e('Title', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('title'); ?>" name="<?php echo $this->get_field_name('title'); ?>" type="text" value="<?php echo $title; ?>" />
	</p>

	<?php
	}

	// update widget
	function update($new_instance, $old_instance) {
		$instance = $old_instance;
		$instance['title'] = strip_tags($new_instance['title']);
		$this->flush_widget_cache();

		$alloptions = wp_cache_get( 'alloptions', 'options' );
		if ( isset($alloptions['intro_posts']) )
			delete_option('intro_posts');		  
		  
		return $instance;
	}
	
	function flush_widget_cache() {
		wp_cache_delete('intro_posts', 'widget');
	}
	
	// display widget
	function widget($args, $instance) {
		$cache = array();
		if ( ! $this->is_preview() ) {
			$cache = wp_cache_get( 'intro_posts', 'widget' );
		}

		if ( ! is_array( $cache ) ) {
			$cache = array();
		}

		if ( ! isset( $args['widget_id'] ) ) {
			$args['widget_id'] = $this->id;
		}

		if ( isset( $cache[ $args['widget_id'] ] ) ) {
			echo $cache[ $args['widget_id'] ];
			return;
		}

		ob_start();
		extract($args);

		$title = ( ! empty( $instance['title'] ) ) ? $instance['title'] : '';

		$title = apply_filters( 'widget_title', $title, $instance, $this->id_base );

		$r = new WP_Query( apply_filters( 'widget_posts_args', array(
			'no_found_rows'       => true,
			'post_status'         => 'publish',
			'posts_per_page'	  => 3
		) ) );

		echo $args['before_widget'];
		if ($r->have_posts()) :
?>
<section id="blog">
	<div class="row">
		<div class="large-12 columns">
				<?php if ( $title ) echo $before_title . $title . $after_title; ?>
				<div class="row">
					<?php while ( $r->have_posts() ) : $r->the_post(); ?>
						<div class="large-4 medium-6 small-12 columns">
							<article class="post">
								<a href="<?php the_permalink(); ?>" title="<?php the_title(); ?>">
									<?php if ( has_post_thumbnail() ) : ?>
									<div class="entry-image">
										<?php the_post_thumbnail('intro-thumb'); ?>
									</div>
									<?php endif; ?>	
									<div class="entry-info">
										<?php the_title( sprintf( '<h5 class="entry-title">'), '</h5>' ); ?>
									</div>
								</a>
							</article>
						</div>
					<?php endwhile; ?>
				</div>
				<a href="<?php echo get_permalink( get_option( 'page_for_posts' ) ); ?>" class="view-blog button dark solid rounded full"><?php echo __('See all posts', 'intro'); ?></a>
		</div>
	</div>			
</section>
	<?php
		echo $args['after_widget'];
		// Reset the global $the_post as this query will have stomped on it
		wp_reset_postdata();

		endif;

		if ( ! $this->is_preview() ) {
			$cache[ $args['widget_id'] ] = ob_get_flush();
			wp_cache_set( 'intro_posts', $cache, 'widget' );
		} else {
			ob_end_flush();
		}
	}
	
}