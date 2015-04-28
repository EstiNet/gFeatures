<?php
/**
 * A unique identifier is defined to store the options in the database and reference them from the theme.
 * By default it uses the theme name, in lowercase and without spaces, but this can be changed if needed.
 * If the identifier changes, it'll appear as if the options have been reset.
 */

function optionsframework_option_name() {

	// This gets the theme name from the stylesheet
	$themename = wp_get_theme();
	$themename = preg_replace("/\W/", "_", strtolower($themename) );

	$optionsframework_settings = get_option( 'optionsframework' );
	$optionsframework_settings['id'] = $themename;
	update_option( 'optionsframework', $optionsframework_settings );
}

/**
 * Defines an array of options that will be used to generate the settings page and be saved in the database.
 * When creating the 'id' fields, make sure to use all lowercase and no spaces.
 *
 * If you are making your theme translatable, you should replace 'options_framework_theme'
 * with the actual text domain for your theme.  Read more:
 * http://codex.wordpress.org/Function_Reference/load_theme_textdomain
 */

function optionsframework_options() {

	// If using image radio buttons, define a directory path
	$set_year = date('Y');
	$options = array();

	/* General Settings */	
	
	$options[] = array('name' => __('General Settings', 'honma'), 'type' => 'heading');
	$options[] = array('name' => __('Header Logo Text', 'honma'), 'desc' => __('', 'honma'), 'id' => 'header_logo_text1', 'std' => get_bloginfo('name'), 'type' => 'text');	
	$options[] = array('name' => __('Header Logo Text 2', 'honma'), 'desc' => __('', 'honma'), 'id' => 'header_logo_text2', 'std' => 'Theme', 'type' => 'text');			
	$options[] = array('name' => __('Header Logo Image', 'honma'), 'desc' => __('', 'honma'), 'id' => 'logo_image', 'type' => 'upload');	
	$options[] = array('name' => __('Fav Icon URL', 'honma'), 'desc' => __('', 'honma'), 'id' => 'fav_icon', 'type' => 'upload');
	$options[] = array('name' => __('Web Clip Icon URL', 'honma'), 'desc' => __('', 'honma'), 'id' => 'web_clip', 'type' => 'upload');
	$options[] = array('name' => __('Footer copyright text left', 'honma'), 'desc' => __('', 'honma'), 'id' => 'footer_text_left', 'std' => 'Copyright &copy; '.$set_year.' '.get_bloginfo('name'), 'type' => 'text');		

	/* Home Page */	
			
	$options[] = array('name' => __('Home Page', 'honma'), 'type' => 'heading');	
	
	$options[] = array('name' => __('Header Image', 'honma'), 'desc' => __('', 'honma'), 'id' => 'header_image', 'type' => 'upload');
	
	$options[] = array('name' => __('Top Title 1', 'honma'), 'desc' => __('', 'honma'), 'id' => 'top_title1', 'type' => 'text', 'std' => 'Responsive');	
	$options[] = array('name' => __('Top Title 2', 'honma'), 'desc' => __('', 'honma'),'id' => 'top_title2', 'type' => 'text', 'std' => 'Theme');		
	$options[] = array('name' => __('Top Subtitle', 'honma'), 'desc' => __('', 'honma'), 'id' => 'top_subtitle', 'type' => 'text', 'std' => 'Simply dummy text of the printing and typesetting industry test of the printing');	
	
	$options[] = array('name' => __('Bar Box Title', 'honma'), 'desc' => __('', 'honma'), 'id' => 'bar_box_title', 'type' => 'text','std' => 'Simply dummy text of the printing and typesetting industry test of the printing');	
	$options[] = array('name' => __('Bar Box Button Text', 'honma'), 'desc' => __('', 'honma'), 'id' => 'bar_box_button_text', 'type' => 'text','std' => 'get started');	
	$options[] = array('name' => __('Bar Box Button Link', 'honma'), 'desc' => __('', 'honma'), 'id' => 'bar_box_button_link', 'std' => esc_url(home_url()) , 'type' => 'text');	
	
	$options[] = array('name' => __('4 Box Title', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_title_4', 'type' => 'text', 'std' => 'What We Do');	
		
	$options[] = array('name' => __('Box 1 Title', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_1_title', 'type' => 'text', 'std' => 'Simply dummy tetxt');	
	$options[] = array('name' => __('Box 1 Description', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_1_description', 'type' => 'textarea', 'std' => 'Is simply dummy tetxt of the printing and typesetting industry.Is simply dummy tetxt of the printing and typesetting industry.Is simply dummy tetxt of the printing and typesetting industry.');		
	$options[] = array('name' => __('Box 1 Link', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_1_link', 'type' => 'text', 'std' => esc_url(home_url()));
	$options[] = array('name' => __('Box 1 Image', 'honma'), 'desc' => __('Recommended image sizes 255 X 255', 'honma'), 'id' => 'box_1_image', 'type' => 'upload');	

	$options[] = array('name' => __('Box 2 Title', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_2_title', 'type' => 'text', 'std' => 'Simply dummy tetxt');	
	$options[] = array('name' => __('Box 2 Description', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_2_description', 'type' => 'textarea', 'std' => 'Is simply dummy tetxt of the printing and typesetting industry.Is simply dummy tetxt of the printing and typesetting industry.Is simply dummy tetxt of the printing and typesetting industry.');	
	$options[] = array('name' => __('Box 2 Link', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_2_link', 'type' => 'text', 'std' => esc_url(home_url()));
	$options[] = array('name' => __('Box 2 Image', 'honma'), 'desc' => __('Recommended image sizes 255 X 255', 'honma'), 'id' => 'box_2_image', 'type' => 'upload');	

	$options[] = array('name' => __('Box 3 Title', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_3_title', 'type' => 'text', 'std' => 'Simply dummy tetxt');	
	$options[] = array('name' => __('Box 3 Description', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_3_description', 'type' => 'textarea', 'std' => 'Is simply dummy tetxt of the printing and typesetting industry.Is simply dummy tetxt of the printing and typesetting industry.Is simply dummy tetxt of the printing and typesetting industry.');	
	$options[] = array('name' => __('Box 3 Link', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_3_link', 'type' => 'text', 'std' => esc_url(home_url()));
	$options[] = array('name' => __('Box 3 Image', 'honma'), 'desc' => __('Recommended image sizes 255 X 255', 'honma'), 'id' => 'box_3_image', 'type' => 'upload');	

	$options[] = array('name' => __('Box 4 Title', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_4_title', 'type' => 'text', 'std' => 'Simply dummy tetxt');
	$options[] = array('name' => __('Box 4 Description', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_4_description', 'type' => 'textarea', 'std' => 'Is simply dummy tetxt of the printing and typesetting industry.Is simply dummy tetxt of the printing and typesetting industry.Is simply dummy tetxt of the printing and typesetting industry.');	
	$options[] = array('name' => __('Box 4 Link', 'honma'), 'desc' => __('', 'honma'), 'id' => 'box_4_link', 'type' => 'text', 'std' => esc_url(home_url()));
	$options[] = array('name' => __('Box 4 Image', 'honma'), 'desc' => __('Recommended image sizes 255 X 255', 'honma'), 'id' => 'box_4_image', 'type' => 'upload');	

	$options[] = array('name' => __('Bar 2 Box Title', 'honma'), 'desc' => __('', 'honma'), 'id' => 'bar_2_box_title', 'type' => 'text', 'std' => 'Is simply dummy tetxt of the printing and typesetting industry.');	
	$options[] = array('name' => __('Bar 2 Box Button Text', 'honma'), 'desc' => __('', 'honma'), 'id' => 'bar_2_box_button_text', 'std' => 'Contact Us', 'type' => 'text');	
	$options[] = array('name' => __('Bar 2 Box Button Link', 'honma'), 'desc' => __('', 'honma'), 'id' => 'bar_2_box_button_link', 'type' => 'text', 'std' => esc_url(home_url()));		
		

	/* Post Box*/	
		
	$options[] = array('name' => __('Recent Posts', 'honma'), 'desc' => __('', 'honma'), 'id' => 'post_title', 'std' => 'Recent Posts' , 'type' => 'text');
		
	return $options;
}