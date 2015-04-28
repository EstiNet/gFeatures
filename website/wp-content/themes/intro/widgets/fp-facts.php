<?php

class Intro_Facts extends WP_Widget {

// constructor
    function intro_facts() {
		$widget_ops = array('classname' => 'intro_facts_widget', 'description' => __( 'Show your visitors some facts about your company.', 'intro') );
        parent::WP_Widget(false, $name = __('Intro FP: Facts', 'intro'), $widget_ops);
		$this->alt_option_name = 'intro_facts_widget';
		
		add_action( 'save_post', array($this, 'flush_widget_cache') );
		add_action( 'deleted_post', array($this, 'flush_widget_cache') );
		add_action( 'switch_theme', array($this, 'flush_widget_cache') );		
    }
	
	// widget form creation
	function form($instance) {

	// Check values
		$title     		= isset( $instance['title'] ) ? esc_attr( $instance['title'] ) : '';
		$fact_one   	= isset( $instance['fact_one'] ) ? esc_html( $instance['fact_one'] ) : '';
		$fact_one_max   = isset( $instance['fact_one_max'] ) ? absint( $instance['fact_one_max'] ) : '';
		$fact_one_icon  = isset( $instance['fact_one_icon'] ) ? esc_html( $instance['fact_one_icon'] ) : '';		
		$fact_two   	= isset( $instance['fact_two'] ) ? esc_attr( $instance['fact_two'] ) : '';
		$fact_two_max   = isset( $instance['fact_two_max'] ) ? absint( $instance['fact_two_max'] ) : '';
		$fact_two_icon  = isset( $instance['fact_two_icon'] ) ? esc_html( $instance['fact_two_icon'] ) : '';
		$fact_three   	= isset( $instance['fact_three'] ) ? esc_attr( $instance['fact_three'] ) : '';
		$fact_three_max = isset( $instance['fact_three_max'] ) ? absint( $instance['fact_three_max'] ) : '';
		$fact_three_icon  = isset( $instance['fact_three_icon'] ) ? esc_html( $instance['fact_three_icon'] ) : '';
		$fact_four   	= isset( $instance['fact_four'] ) ? esc_attr( $instance['fact_four'] ) : '';		
		$fact_four_max  = isset( $instance['fact_four_max'] ) ? absint( $instance['fact_four_max'] ) : '';
		$fact_four_icon  = isset( $instance['fact_four_icon'] ) ? esc_html( $instance['fact_four_icon'] ) : '';	
	?>

	<p>
	<label for="<?php echo $this->get_field_id('title'); ?>"><?php _e('Title', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('title'); ?>" name="<?php echo $this->get_field_name('title'); ?>" type="text" value="<?php echo $title; ?>" />
	</p>

	<!-- fact one -->
	<p>
	<label for="<?php echo $this->get_field_id('fact_one'); ?>"><?php _e('First fact name', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_one'); ?>" name="<?php echo $this->get_field_name('fact_one'); ?>" type="text" value="<?php echo $fact_one; ?>" />
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('fact_one_max'); ?>"><?php _e('First fact value', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_one_max'); ?>" name="<?php echo $this->get_field_name('fact_one_max'); ?>" type="text" value="<?php echo $fact_one_max; ?>" />
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('fact_one_icon'); ?>"><?php _e('First fact icon', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_one_icon'); ?>" name="<?php echo $this->get_field_name('fact_one_icon'); ?>" type="text" value="<?php echo $fact_one_icon; ?>" />
	</p>

	<!-- fact two -->
	<p>
	<label for="<?php echo $this->get_field_id('fact_two'); ?>"><?php _e('Second fact name', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_two'); ?>" name="<?php echo $this->get_field_name('fact_two'); ?>" type="text" value="<?php echo $fact_two; ?>" />
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('fact_two_max'); ?>"><?php _e('Second fact value', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_two_max'); ?>" name="<?php echo $this->get_field_name('fact_two_max'); ?>" type="text" value="<?php echo $fact_two_max; ?>" />
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('fact_two_icon'); ?>"><?php _e('Second fact icon', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_two_icon'); ?>" name="<?php echo $this->get_field_name('fact_two_icon'); ?>" type="text" value="<?php echo $fact_two_icon; ?>" />
	</p>	

	<!-- fact three -->
	<p>
	<label for="<?php echo $this->get_field_id('fact_three'); ?>"><?php _e('Third fact name', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_three'); ?>" name="<?php echo $this->get_field_name('fact_three'); ?>" type="text" value="<?php echo $fact_three; ?>" />
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('fact_three_max'); ?>"><?php _e('Third fact value', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_three_max'); ?>" name="<?php echo $this->get_field_name('fact_three_max'); ?>" type="text" value="<?php echo $fact_three_max; ?>" />
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('fact_three_icon'); ?>"><?php _e('Third fact icon', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_three_icon'); ?>" name="<?php echo $this->get_field_name('fact_three_icon'); ?>" type="text" value="<?php echo $fact_three_icon; ?>" />
	</p>	

	<!-- fact four -->
	<p>
	<label for="<?php echo $this->get_field_id('fact_four'); ?>"><?php _e('Fourth fact name', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_four'); ?>" name="<?php echo $this->get_field_name('fact_four'); ?>" type="text" value="<?php echo $fact_four; ?>" />
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('fact_four_max'); ?>"><?php _e('Fourth fact value', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_four_max'); ?>" name="<?php echo $this->get_field_name('fact_four_max'); ?>" type="text" value="<?php echo $fact_four_max; ?>" />
	</p>

	<p>
	<label for="<?php echo $this->get_field_id('fact_four_icon'); ?>"><?php _e('Fourth fact icon', 'intro'); ?></label>
	<input class="widefat" id="<?php echo $this->get_field_id('fact_four_icon'); ?>" name="<?php echo $this->get_field_name('fact_four_icon'); ?>" type="text" value="<?php echo $fact_four_icon; ?>" />
	</p>							

	<?php
	}

	// update widget
	function update($new_instance, $old_instance) {
		$instance = $old_instance;
		$instance['title'] 			= strip_tags($new_instance['title']);
		$instance['fact_one'] 		= strip_tags($new_instance['fact_one']);
		$instance['fact_one_max'] 	= intval($new_instance['fact_one_max']);
		$instance['fact_one_icon'] 	= strip_tags($new_instance['fact_one_icon']);
		$instance['fact_two'] 		= strip_tags($new_instance['fact_two']);
		$instance['fact_two_max'] 	= intval($new_instance['fact_two_max']);
		$instance['fact_two_icon'] 	= strip_tags($new_instance['fact_two_icon']);
		$instance['fact_three'] 	= strip_tags($new_instance['fact_three']);
		$instance['fact_three_max']	= intval($new_instance['fact_three_max']);
		$instance['fact_three_icon']= strip_tags($new_instance['fact_three_icon']);
		$instance['fact_four'] 		= strip_tags($new_instance['fact_four']);
		$instance['fact_four_max'] 	= intval($new_instance['fact_four_max']);
		$instance['fact_four_icon'] = strip_tags($new_instance['fact_four_icon']);
		$this->flush_widget_cache();

		$alloptions = wp_cache_get( 'alloptions', 'options' );
		if ( isset($alloptions['intro_facts']) )
			delete_option('intro_facts');		  
		  
		return $instance;
	}
	
	function flush_widget_cache() {
		wp_cache_delete('intro_facts', 'widget');
	}
	
	// display widget
	function widget($args, $instance) {
		$cache = array();
		if ( ! $this->is_preview() ) {
			$cache = wp_cache_get( 'intro_facts', 'widget' );
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

		$title 			= ( ! empty( $instance['title'] ) ) ? $instance['title'] : '';
		$title 			= apply_filters( 'widget_title', $title, $instance, $this->id_base );
		$fact_one   	= isset( $instance['fact_one'] ) ? esc_html( $instance['fact_one'] ) : '';
		$fact_one_max  	= isset( $instance['fact_one_max'] ) ? absint( $instance['fact_one_max'] ) : '';
		$fact_one_icon  = isset( $instance['fact_one_icon'] ) ? esc_html( $instance['fact_one_icon'] ) : '';
		$fact_two   	= isset( $instance['fact_two'] ) ? esc_attr( $instance['fact_two'] ) : '';
		$fact_two_max  	= isset( $instance['fact_two_max'] ) ? absint( $instance['fact_two_max'] ) : '';
		$fact_two_icon  = isset( $instance['fact_two_icon'] ) ? esc_html( $instance['fact_two_icon'] ) : '';
		$fact_three   	= isset( $instance['fact_three'] ) ? esc_attr( $instance['fact_three'] ) : '';
		$fact_three_max	= isset( $instance['fact_three_max'] ) ? absint( $instance['fact_three_max'] ) : '';
		$fact_three_icon= isset( $instance['fact_three_icon'] ) ? esc_html( $instance['fact_three_icon'] ) : '';
		$fact_four   	= isset( $instance['fact_four'] ) ? esc_attr( $instance['fact_four'] ) : '';		
		$fact_four_max 	= isset( $instance['fact_four_max'] ) ? absint( $instance['fact_four_max'] ) : '';
		$fact_four_icon = isset( $instance['fact_four_icon'] ) ? esc_html( $instance['fact_four_icon'] ) : '';		

		echo $args['before_widget'];
?>
		<section id="facts">
			<div class="row">
				<div class="large-12 columns">
					<?php if ( $title ) echo $before_title . $title . $after_title; ?>
					<?php if ($fact_one !='') : ?>
						<div class="fact large-3 medium-3 small-12 columns text-center">
							<h6><?php echo esc_html($fact_one); ?></h6>
							<?php if ($fact_one_icon !='') : ?>
								<div class="icon-3x icon-round"><i class="fa <?php echo $fact_one_icon; ?>"></i></div>
							<?php endif; ?>
							<span class="counter"><?php echo absint($fact_one_max); ?></span>
						</div>
					<?php endif; ?>
					<?php if ($fact_two !='') : ?>
						<div class="fact large-3 medium-3 small-12 columns text-center">
							<h6><?php echo esc_html($fact_two); ?></h6>
							<?php if ($fact_two_icon !='') : ?>
								<div class="icon-3x icon-round"><i class="fa <?php echo $fact_two_icon; ?>"></i></div>
							<?php endif; ?>
							<span class="counter"><?php echo absint($fact_two_max); ?></span>
						</div>
					<?php endif; ?>
					<?php if ($fact_three !='') : ?>
						<div class="fact large-3 medium-3 small-12 columns text-center">
							<h6><?php echo esc_html($fact_three); ?></h6>
							<?php if ($fact_three_icon !='') : ?>
								<div class="icon-3x icon-round"><i class="fa <?php echo $fact_three_icon; ?>"></i></div>
							<?php endif; ?>
							<span class="counter"><?php echo absint($fact_three_max); ?></span>
						</div>
					<?php endif; ?>
					<?php if ($fact_four !='') : ?>
						<div class="fact large-3 medium-3 small-12 columns text-center">
							<h6><?php echo esc_html($fact_four); ?></h6>
							<?php if ($fact_four_icon !='') : ?>
								<div class="icon-3x icon-round"><i class="fa <?php echo $fact_four_icon; ?>"></i></div>
							<?php endif; ?>
							<span class="counter"><?php echo absint($fact_four_max); ?></span>
						</div>
					<?php endif; ?>																			
				</div>
			</div>								
		</section>				
	<?php
		echo $args['after_widget'];

		if ( ! $this->is_preview() ) {
			$cache[ $args['widget_id'] ] = ob_get_flush();
			wp_cache_set( 'intro_facts', $cache, 'widget' );
		} else {
			ob_end_flush();
		}
	}
	
}