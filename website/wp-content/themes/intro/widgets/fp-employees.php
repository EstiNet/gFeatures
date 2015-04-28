<?php

class Intro_Employees extends WP_Widget {

// constructor
    function intro_employees() {
		$widget_ops = array('classname' => 'intro_employees_widget', 'description' => __( 'Display your team members in a stylish way.', 'intro') );
        parent::WP_Widget(false, $name = __('Intro FP: Employees', 'intro'), $widget_ops);
		$this->alt_option_name = 'intro_employees_widget';
		
		add_action( 'save_post', array($this, 'flush_widget_cache') );
		add_action( 'deleted_post', array($this, 'flush_widget_cache') );
		add_action( 'switch_theme', array($this, 'flush_widget_cache') );		
    }
	
	// widget form creation
	function form($instance) {

	// Check values
		$title     = isset( $instance['title'] ) ? esc_attr( $instance['title'] ) : '';
		$number    = isset( $instance['number'] ) ? intval( $instance['number'] ) : -1;
		$category  = isset( $instance['category '] ) ? esc_attr( $instance['category '] ) : '';
		$see_all   = isset( $instance['see_all'] ) ? esc_url_raw( $instance['see_all'] ) : '';		
	?>

	<p><?php _e('In order to display this widget, you must first add some employees from the dashboard. Add as many as you want and the theme will automatically display them all.', 'intro'); ?></p>
	<p>
	<label for="<?php echo $this->get_field_id('title'); ?>"><?php _e('Title', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('title'); ?>" name="<?php echo $this->get_field_name('title'); ?>" type="text" value="<?php echo $title; ?>" />
	</p>
	<p><label for="<?php echo $this->get_field_id( 'number' ); ?>"><?php _e( 'Number of employees to show (-1 shows all of them):', 'intro' ); ?></label>
	<input id="<?php echo $this->get_field_id( 'number' ); ?>" name="<?php echo $this->get_field_name( 'number' ); ?>" type="text" value="<?php echo $number; ?>" size="3" /></p>
    <p><label for="<?php echo $this->get_field_id('see_all'); ?>"><?php _e('Enter an URL here if you want to section to link somewhere.', 'intro'); ?></label>
	<input class="widefat custom_media_url" id="<?php echo $this->get_field_id( 'see_all' ); ?>" name="<?php echo $this->get_field_name( 'see_all' ); ?>" type="text" value="<?php echo $see_all; ?>" size="3" /></p>	
	<p><label for="<?php echo $this->get_field_id( 'category' ); ?>"><?php _e( 'Enter the slug for your category or leave empty to show all employees.', 'intro' ); ?></label>
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
		if ( isset($alloptions['intro_employees']) )
			delete_option('intro_employees');		  
		  
		return $instance;
	}
	
	function flush_widget_cache() {
		wp_cache_delete('intro_employees', 'widget');
	}
	
	// display widget
	function widget($args, $instance) {
		$cache = array();
		if ( ! $this->is_preview() ) {
			$cache = wp_cache_get( 'intro_employees', 'widget' );
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

		$title = ( ! empty( $instance['title'] ) ) ? $instance['title'] : __( 'Our Employees', 'intro' );

		$title = apply_filters( 'widget_title', $title, $instance, $this->id_base );
		$see_all = isset( $instance['see_all'] ) ? esc_url($instance['see_all']) : '';
		$number = ( ! empty( $instance['number'] ) ) ? intval( $instance['number'] ) : -1;
		if ( ! $number )
			$number = -1;			
		$category = isset( $instance['category'] ) ? esc_attr($instance['category']) : '';

		$r = new WP_Query( apply_filters( 'widget_posts_args', array(
			'no_found_rows'       => true,
			'post_status'         => 'publish',
			'post_type' 		  => 'employees',
			'posts_per_page'	  => $number,
			'category_name'		  => $category			
		) ) );

		echo $args['before_widget'];

		if ($r->have_posts()) :
?>

		<section id="team">
			<div class="row">
				<div class="large-12 columns">
				<?php if ( $title ) echo $before_title . $title . $after_title; ?>
				<div class="row">
				<?php while ( $r->have_posts() ) : $r->the_post(); ?>
					<?php //Get the custom field values
						$photo 	  = get_post_meta( get_the_ID(), 'wpcf-photo', true );
						$position = get_post_meta( get_the_ID(), 'wpcf-position', true );
						$facebook = get_post_meta( get_the_ID(), 'wpcf-facebook', true );
						$twitter  = get_post_meta( get_the_ID(), 'wpcf-twitter', true );
						$google   = get_post_meta( get_the_ID(), 'wpcf-google-plus', true );
					?>

				<div class="large-4 medium-6 small-12 columns">
					<div class="team-member">
						<?php if ($photo != '') : ?>
							<div class="photo">
								<img src="<?php echo esc_url($photo); ?>" alt="<?php the_title(); ?>">
							</div>
						<?php endif; ?>
						<div class="info">
							<h4><?php the_title(); ?></h4>
							<?php if ($position != '') : ?>
								<h6><?php echo esc_html($position); ?></h6>
							<?php endif; ?>
							<div class="share-social">
								<ul>
									<?php if ($facebook != '') : ?>
										<li><a class="facebook" href="<?php echo esc_url($facebook); ?>" target="_blank"><i class="fa fa-facebook"></i></a></li>
									<?php endif; ?>
									<?php if ($twitter != '') : ?>
										<li><a class="twitter" href="<?php echo esc_url($twitter); ?>" target="_blank"><i class="fa fa-twitter"></i></a></li>
									<?php endif; ?>
									<?php if ($google != '') : ?>
										<li><a class="google" href="<?php echo esc_url($google); ?>" target="_blank"><i class="fa fa-google-plus"></i></a></li>
									<?php endif; ?>
								</ul>
							</div>
						</div><!--.info-->
					</div>
				</div><!--.large-4.columns-->
				<?php endwhile; ?>
			</div>	
			</div>
			<?php if ($see_all != '') : ?>
				<a href="<?php echo esc_url($see_all); ?>" class="all-news"><?php echo __('See all our employees', 'intro'); ?></a>
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
			wp_cache_set( 'intro_employees', $cache, 'widget' );
		} else {
			ob_end_flush();
		}
	}
	
}