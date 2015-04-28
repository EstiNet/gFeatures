<?php

class Intro_Portfolio extends WP_Widget {

    function intro_portfolio() {
		$widget_ops = array('classname' => 'intro_portfolio_widget', 'description' => __( 'Show your portfolio built with Jetpack', 'intro') );
        parent::WP_Widget(false, $name = __('Intro FP: Portfolio', 'intro'), $widget_ops);
		$this->alt_option_name = 'intro_portfolio_widget';
		
		add_action( 'save_post', array($this, 'flush_widget_cache') );
		add_action( 'deleted_post', array($this, 'flush_widget_cache') );
		add_action( 'switch_theme', array($this, 'flush_widget_cache') );		
    }
	
	// widget form creation
	function form($instance) {
		$title     = isset( $instance['title'] ) ? esc_attr( $instance['title'] ) : '';
	?>

	<p>
	<label for="<?php echo $this->get_field_id('title'); ?>"><?php _e('Title', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('title'); ?>" name="<?php echo $this->get_field_name('title'); ?>" type="text" value="<?php echo $title; ?>" />
	</p>

	<?php
	}

	function update($new_instance, $old_instance) {
		$instance = $old_instance;
		$instance['title'] = strip_tags($new_instance['title']);
		$this->flush_widget_cache();

		$alloptions = wp_cache_get( 'alloptions', 'options' );
		if ( isset($alloptions['intro_portfolio']) )
			delete_option('intro_portfolio');		  
		  
		return $instance;
	}
	
	function flush_widget_cache() {
		wp_cache_delete('intro_portfolio', 'widget');
	}
	
	// display widget
	function widget($args, $instance) {
		$cache = array();
		if ( ! $this->is_preview() ) {
			$cache = wp_cache_get( 'intro_portfolio', 'widget' );
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
			'post_type' 		  => 'jetpack-portfolio',
			'posts_per_page'	  => 6
		) ) );

		echo $args['before_widget'];

		if ($r->have_posts()) :
		global $post;
?>
		<section id="portfolio">
			<div class="row">
				<div class="large-12 columns">

				<?php if ( $title ) echo $before_title . $title . $after_title; ?>
				

				<ul class="portfolio-nav">
				<?php //Create portfolio filter from custom taxonomies
					$hello = array(
						'taxonomy' => 'jetpack-portfolio-type',
					);
					$categories = get_categories($hello);
						echo '<li><a class="active" href="" data-filter="*">' . __('All', 'intro') . '</a></li>';
						foreach($categories as $category) { 
							echo '<li><a href="" data-filter=".' . strtolower($category->name) . '">' . $category->name . '</a></li>';
						}
				?>
				</ul>


				<div class="portfolio-filter">
					<?php while ( $r->have_posts() ) : $r->the_post(); ?>
						<?php //Filter for the portfolio items data-filters
							$terms = get_the_terms( $post->ID, 'jetpack-portfolio-type' );					
							if ( $terms && ! is_wp_error( $terms ) ) : 
								$filters = array();
								foreach ( $terms as $term ) {
									$filters[] = $term->name;
								}						
								$filter = join( " ", $filters );
							else :
								$filter = null;
							endif;
						?>					
						<figure class="project filtered <?php echo strtolower($filter); ?>">
							<?php if ( has_post_thumbnail() ) : ?>
								<?php the_post_thumbnail('intro-thumb'); ?>
							<?php endif; ?>
							<figcaption>
								<?php $url = wp_get_attachment_url( get_post_thumbnail_id($post->ID) ); ?>						
								<h5><?php the_title(); ?></h5>
								<a href="<?php echo esc_url($url); ?>" title="<?php the_title(); ?>"></a>
							</figcaption>
						</figure>
					<?php endwhile; ?>
				</div>	

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
			wp_cache_set( 'intro_portfolio', $cache, 'widget' );
		} else {
			ob_end_flush();
		}
	}
	
}