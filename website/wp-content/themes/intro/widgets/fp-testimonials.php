<?php

class Intro_Testimonials extends WP_Widget {

// constructor
    function intro_testimonials() {
		$widget_ops = array('classname' => 'intro_testimonials_widget', 'description' => __( 'Display testimonials from your clients.', 'intro') );
        parent::WP_Widget(false, $name = __('Intro FP: Testimonials', 'intro'), $widget_ops);
		$this->alt_option_name = 'intro_testimonials_widget';
		
		add_action( 'save_post', array($this, 'flush_widget_cache') );
		add_action( 'deleted_post', array($this, 'flush_widget_cache') );
		add_action( 'switch_theme', array($this, 'flush_widget_cache') );		
    }
	
	// widget form creation
	function form($instance) {

	// Check values
		$title     = isset( $instance['title'] ) ? esc_attr( $instance['title'] ) : '';
		$number    = isset( $instance['number'] ) ? intval( $instance['number'] ) : -1;
		$category   = isset( $instance['category '] ) ? esc_attr( $instance['category '] ) : '';
		$see_all   = isset( $instance['see_all'] ) ? esc_url_raw( $instance['see_all'] ) : '';				
	?>
	
	<p><?php _e('In order to display this widget, you must first add some testimonials from the dashboard. Add as many as you want and the theme will automatically display them all.', 'intro'); ?></p>

	<p>
	<label for="<?php echo $this->get_field_id('title'); ?>"><?php _e('Title', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('title'); ?>" name="<?php echo $this->get_field_name('title'); ?>" type="text" value="<?php echo $title; ?>" />
	</p>

	<p><label for="<?php echo $this->get_field_id( 'number' ); ?>"><?php _e( 'Number of testimonials to show (-1 shows all of them):', 'intro' ); ?></label>
	<input id="<?php echo $this->get_field_id( 'number' ); ?>" name="<?php echo $this->get_field_name( 'number' ); ?>" type="text" value="<?php echo $number; ?>" size="3" /></p>
    <p><label for="<?php echo $this->get_field_id('see_all'); ?>"><?php _e('Enter the URL for your testimonials page. Useful if you want to show here just a few testimonials, then send your visitors to a page that uses the testimonials page template.', 'intro'); ?></label>
	<input class="widefat custom_media_url" id="<?php echo $this->get_field_id( 'see_all' ); ?>" name="<?php echo $this->get_field_name( 'see_all' ); ?>" type="text" value="<?php echo $see_all; ?>" size="3" /></p>	
	<p><label for="<?php echo $this->get_field_id( 'category' ); ?>"><?php _e( 'Enter the slug for your category or leave empty to show all testimonials.', 'intro' ); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id( 'category' ); ?>" name="<?php echo $this->get_field_name( 'category' ); ?>" type="text" value="<?php echo $category; ?>" size="3" /></p>
	

	<?php
	}

	// update widget
	function update($new_instance, $old_instance) {
		$instance = $old_instance;
		$instance['title'] = strip_tags($new_instance['title']);
		$instance['number'] = strip_tags($new_instance['number']);
		$instance['see_all'] = esc_url_raw( $new_instance['see_all'] );	
		$instance['category'] = strip_tags($new_instance['category']);

		$this->flush_widget_cache();

		$alloptions = wp_cache_get( 'alloptions', 'options' );
		if ( isset($alloptions['intro_testimonials']) )
			delete_option('intro_testimonials');		  
		  
		return $instance;
	}
	
	function flush_widget_cache() {
		wp_cache_delete('intro_testimonials', 'widget');
	}
	
	// display widget
	function widget($args, $instance) {
		$cache = array();
		if ( ! $this->is_preview() ) {
			$cache = wp_cache_get( 'intro_testimonials', 'widget' );
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

		$title = ( ! empty( $instance['title'] ) ) ? $instance['title'] : __( 'What our clients say', 'intro' );

		$title = apply_filters( 'widget_title', $title, $instance, $this->id_base );
		$see_all = isset( $instance['see_all'] ) ? esc_url($instance['see_all']) : '';
		$number = ( ! empty( $instance['number'] ) ) ? intval( $instance['number'] ) : -1;
		if ( ! $number )
			$number = -1;			
		$category = isset( $instance['category'] ) ? esc_attr($instance['category']) : '';

		$r = new WP_Query( apply_filters( 'widget_posts_args', array(
			'no_found_rows'       => true,
			'post_status'         => 'publish',
			'post_type' 		  => 'testimonials',
			'posts_per_page'	  => $number,
			'category_name'		  => $category			
		) ) );

		echo $args['before_widget'];

		if ($r->have_posts()) :
?>
		<section id="testimonials" class="testimonials-area">
			<div class="row">
				<div class="large-12 columns">
				<?php if ( $title ) echo $before_title . $title . $after_title; ?>
				<?php while ( $r->have_posts() ) : $r->the_post(); ?>
					<?php $function = get_post_meta( get_the_ID(), 'wpcf-client-function', true ); ?>
					<?php $photo = get_post_meta( get_the_ID(), 'wpcf-client-photo', true ); ?>
					<div class="testimonial large-6 medium-12 columns">
						<?php if ($photo != '') : ?>
							<img class="avatar" src="<?php echo esc_url($photo); ?>" alt="<?php the_title(); ?>">
						<?php endif; ?>						
						<div class="testimonial-body"><?php the_content(); ?></div>
						<h4 class="client-name"><?php the_title(); ?></h4>
						<?php if ($function != '') : ?>
							<span class="client-function"><?php echo esc_html($function); ?></span>
						<?php endif; ?>						
					</div>
				<?php endwhile; ?>
			</div>
			<?php if ($see_all != '') : ?>
				<a href="<?php echo esc_url($see_all); ?>" class="see-all"><?php echo __('See all our testimonials', 'intro'); ?></a>
			<?php endif; ?>	
			</div>		
		</section>		
	<?php
		// Reset the global $the_post as this query will have stomped on it
		wp_reset_postdata();

		endif;

		echo $args['after_widget'];

		if ( ! $this->is_preview() ) {
			$cache[ $args['widget_id'] ] = ob_get_flush();
			wp_cache_set( 'intro_testimonials', $cache, 'widget' );
		} else {
			ob_end_flush();
		}
	}
	
}