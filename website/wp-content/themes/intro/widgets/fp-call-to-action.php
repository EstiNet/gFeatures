<?php

class Intro_Action extends WP_Widget {

// constructor
    function intro_action() {
		$widget_ops = array('classname' => 'intro_action_widget', 'description' => __( 'Display a call to action block.', 'intro') );
        parent::WP_Widget(false, $name = __('Intro FP: Call to action', 'intro'), $widget_ops);
		$this->alt_option_name = 'intro_action_widget';
		
		add_action( 'save_post', array($this, 'flush_widget_cache') );
		add_action( 'deleted_post', array($this, 'flush_widget_cache') );
		add_action( 'switch_theme', array($this, 'flush_widget_cache') );		
    }
	
	// widget form creation
	function form($instance) {

	// Check values
		$action_text 		= isset( $instance['action_text'] ) ? esc_textarea( $instance['action_text'] ) : '';
		$action_btn_link 	= isset( $instance['action_btn_link'] ) ? esc_url( $instance['action_btn_link'] ) : '';
		$action_btn_text 	= isset( $instance['action_btn_text'] ) ? esc_html( $instance['action_btn_text'] ) : '';
	?>

	<p>
	<label for="<?php echo $this->get_field_id('action_text'); ?>"><?php _e('Enter your call to action.', 'intro'); ?></label>
	<textarea class="widefat" id="<?php echo $this->get_field_id('action_text'); ?>" name="<?php echo $this->get_field_name('action_text'); ?>"><?php echo $action_text; ?></textarea>
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('action_btn_link'); ?>"><?php _e('Link for the button', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('action_btn_link'); ?>" name="<?php echo $this->get_field_name('action_btn_link'); ?>" type="text" value="<?php echo $action_btn_link; ?>" />
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('action_btn_text'); ?>"><?php _e('Title for the button', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('action_btn_text'); ?>" name="<?php echo $this->get_field_name('action_btn_text'); ?>" type="text" value="<?php echo $action_btn_text; ?>" />
	</p>
	<?php
	}

	// update widget
	function update($new_instance, $old_instance) {
		$instance = $old_instance;
		$instance['action_text'] 	 = strip_tags($new_instance['action_text']);
		$instance['action_btn_link'] = esc_url_raw($new_instance['action_btn_link']);
		$instance['action_btn_text'] = strip_tags($new_instance['action_btn_text']);
		$this->flush_widget_cache();

		$alloptions = wp_cache_get( 'alloptions', 'options' );
		if ( isset($alloptions['intro_action']) )
			delete_option('intro_action');		  
		  
		return $instance;
	}
	
	function flush_widget_cache() {
		wp_cache_delete('intro_action', 'widget');
	}
	
	// display widget
	function widget($args, $instance) {
		$cache = array();
		if ( ! $this->is_preview() ) {
			$cache = wp_cache_get( 'intro_action', 'widget' );
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

		$action_text 	 = isset( $instance['action_text'] ) ? esc_textarea($instance['action_text']) : '';
		$action_btn_link = isset( $instance['action_btn_link'] ) ? esc_url($instance['action_btn_link']) : '';
		$action_btn_text = isset( $instance['action_btn_text'] ) ? esc_html($instance['action_btn_text']) : '';

		echo $args['before_widget'];

?>

	<section id="banner">
		<div class="row">
			<div class="large-9 columns">
				<h3>				
					<?php if ($action_text !='') : ?>				
							<?php echo $action_text; ?>
					<?php endif; ?>
				</h3>
			</div>
			<div class="large-3	columns">
				<a href="<?php echo esc_url($action_btn_link); ?>" class="button dark rounded"><?php echo esc_html($action_btn_text); ?></a>
			</div>
		</div><!--.row-->
	</section><!--#banner-->


	<?php

		echo $args['after_widget'];

		if ( ! $this->is_preview() ) {
			$cache[ $args['widget_id'] ] = ob_get_flush();
			wp_cache_set( 'intro_action', $cache, 'widget' );
		} else {
			ob_end_flush();
		}
	}
	
}