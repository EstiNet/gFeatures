<?php

class Intro_About extends WP_Widget {

	public function __construct() {
		$widget_ops = array('classname' => 'intro_service', 'description' => __( 'Show some info about your company.', 'intro'));
		$control_ops = array('width' => 400, 'height' => 350);
		parent::__construct('intro_service_widget', __( 'Intro: About us', 'intro'), $widget_ops, $control_ops);
	}

	public function widget( $args, $instance ) {

		$title 		= apply_filters( 'widget_title', empty( $instance['title'] ) ? '' : $instance['title'], $instance, $this->id_base );
		$text 		= apply_filters( 'intro_about', empty( $instance['text'] ) ? '' : $instance['text'], $instance );
		$image_uri 	= isset( $instance['image_uri'] ) ? esc_url($instance['image_uri']) : '';	

		extract($args);

		echo $args['before_widget'];
		?>
		<section id="about">
			<div class="row">
				<div class="large-12 columns">
					<?php if ( $title ) echo $before_title .  $title . $after_title; ?>
					<div class="row">		
						<div class="large-8 columns">					
							<?php echo wpautop($text); ?>
						</div>
						<div class="large-4 columns">
							<img class="rounded" src="<?php echo esc_url($image_uri); ?>" />
						</div>				
					</div><!--.row-->
				</div><!--.large-12.colimns-->
			</div><!--.row-->
		</section><!--#about-->				

		<?php
		echo $args['after_widget'];
	}

	public function update( $new_instance, $old_instance ) {
		$instance = $old_instance;
		$instance['title'] 	  = strip_tags($new_instance['title']);
		if ( current_user_can('unfiltered_html') )
			$instance['text'] =  $new_instance['text'];
		else
			$instance['text'] = stripslashes( wp_filter_post_kses( addslashes($new_instance['text']) ) ); // wp_filter_post_kses() expects slashed
		return $instance;
	    $instance['image_uri']= esc_url_raw( $new_instance['image_uri'] );	

	}

	public function form( $instance ) {
		$instance 			= wp_parse_args( (array) $instance, array( 'title' => '', 'text' => '' ) );
		$title 				= strip_tags($instance['title']);
		$text 				= esc_textarea($instance['text']);
		$image_uri  		= isset( $instance['image_uri'] ) ? esc_url_raw( $instance['image_uri'] ) : '';		
?>
		<p><label for="<?php echo $this->get_field_id('title'); ?>"><?php _e('Title:', 'intro'); ?></label>
		<input class="widefat" id="<?php echo $this->get_field_id('title'); ?>" name="<?php echo $this->get_field_name('title'); ?>" type="text" value="<?php echo esc_attr($title); ?>" /></p>

		<p><label for="<?php echo $this->get_field_id('text'); ?>"><?php _e('Add your text here:', 'intro'); ?></label>
		<textarea class="widefat" rows="16" cols="20" id="<?php echo $this->get_field_id('text'); ?>" name="<?php echo $this->get_field_name('text'); ?>"><?php echo $text; ?></textarea></p>

		<p><label for="<?php echo $this->get_field_id('image_uri'); ?>"><?php _e('Add a link for an image here:', 'intro'); ?></label>
		<input class="widefat" id="<?php echo $this->get_field_id('image_uri'); ?>" name="<?php echo $this->get_field_name('image_uri'); ?>" type="text" value="<?php echo $image_uri; ?>" /></p>

<?php
	}
}