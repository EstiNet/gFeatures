<?php

class Intro_Services extends WP_Widget {

// constructor
    function intro_services() {
		$widget_ops = array('classname' => 'intro_services_widget', 'description' => __( 'Show what services you are able to provide.', 'intro') );
        parent::WP_Widget(false, $name = __('Intro FP: Services', 'intro'), $widget_ops);
		$this->alt_option_name = 'intro_services_widget';
		
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

	<p><?php _e('In order to display this widget, you must first add some services from the dashboard. Add as many as you want and the theme will automatically display them all.', 'intro'); ?></p>
	<p>
	<label for="<?php echo $this->get_field_id('title'); ?>"><?php _e('Title', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('title'); ?>" name="<?php echo $this->get_field_name('title'); ?>" type="text" value="<?php echo $title; ?>" />
	</p>

	<p><label for="<?php echo $this->get_field_id( 'number' ); ?>"><?php _e( 'Number of services to show (-1 shows all of them):', 'intro' ); ?></label>
	<input id="<?php echo $this->get_field_id( 'number' ); ?>" name="<?php echo $this->get_field_name( 'number' ); ?>" type="text" value="<?php echo $number; ?>" size="3" /></p>

    <p><label for="<?php echo $this->get_field_id('see_all'); ?>"><?php _e('Enter an URL here if you want to section to link somewhere.', 'intro'); ?></label>
	<input class="widefat custom_media_url" id="<?php echo $this->get_field_id( 'see_all' ); ?>" name="<?php echo $this->get_field_name( 'see_all' ); ?>" type="text" value="<?php echo $see_all; ?>" size="3" /></p>	
	<p><label for="<?php echo $this->get_field_id( 'category' ); ?>"><?php _e( 'Enter the slug for your category or leave empty to show all services.', 'intro' ); ?></label>
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
		if ( isset($alloptions['intro_services']) )
			delete_option('intro_services');		  
		  
		return $instance;
	}
	
	function flush_widget_cache() {
		wp_cache_delete('intro_services', 'widget');
	}
	
	// display widget
	function widget($args, $instance) {
		$cache = array();
		if ( ! $this->is_preview() ) {
			$cache = wp_cache_get( 'intro_services', 'widget' );
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

		$title = ( ! empty( $instance['title'] ) ) ? $instance['title'] : __( 'Our Services', 'intro' );

		/** This filter is documented in wp-includes/default-widgets.php */
		$title = apply_filters( 'widget_title', $title, $instance, $this->id_base );
		$see_all = isset( $instance['see_all'] ) ? esc_url($instance['see_all']) : '';
		$number = ( ! empty( $instance['number'] ) ) ? intval( $instance['number'] ) : -1;
		if ( ! $number )
			$number = -1;				
		$category = isset( $instance['category'] ) ? esc_attr($instance['category']) : '';

		$r = new WP_Query( apply_filters( 'widget_posts_args', array(
			'no_found_rows'       => true,
			'post_status'         => 'publish',
			'post_type' 		  => 'services',
			'posts_per_page'	  => $number,
			'category_name'		  => $category			
		) ) );

		echo $args['before_widget'];

		if ($r->have_posts()) :
?>
		<section id="services" class="section">
			<?php if ( $title ) echo $before_title . $title . $after_title; ?>

			<div class="row">
				<div class="large-12 columns">				
					<div class="row">
					<?php while ( $r->have_posts() ) : $r->the_post(); ?>
						<?php $icon = get_post_meta( get_the_ID(), 'wpcf-service-icon', true ); ?>
						<?php $link = get_post_meta( get_the_ID(), 'wpcf-service-link', true ); ?>
						<div class="large-4 medium-6 small-12 columns">
							<div class="feature">
								<?php if ($icon) : ?>			
									<div class="icon-bg">
											<span class="icon-3x"><?php echo '<i class="fa ' . esc_html($icon) . '"></i>'; ?></span>
									</div>
								<?php endif; ?>							
								<div class="info">
									<h5>
										<?php if ($link) : ?>
											<a href="<?php echo esc_url($link); ?>"><?php the_title(); ?></a>
										<?php else : ?>
											<?php the_title(); ?>
										<?php endif; ?>
									</h5>
									<?php the_content(); ?>
								</div><!--.info-->	
							</div>
						</div>
					<?php endwhile; ?>
					</div>
				</div>
				<?php if ($see_all != '') : ?>
					<a href="<?php echo esc_url($see_all); ?>" class="see-all"><?php echo __('See all our services', 'intro'); ?></a>
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
			wp_cache_set( 'intro_services', $cache, 'widget' );
		} else {
			ob_end_flush();
		}
	}
	
}