<?php
/**
 * Page Builder plugin support
 *
 * @package Intro
 */
?>
<?php


/* Defaults */
add_theme_support( 'siteorigin-panels', array( 
	'margin-bottom' => 0,
) );

/* Theme widgets */
function intro_theme_widgets($widgets) {
	$theme_widgets = array(
		'Intro_Services',
		'Intro_Portfolio',
		'Intro_Action',
		'Intro_Facts',
		'Intro_Employees',
		'Intro_Testimonials',
		'Intro_About',
		'Intro_Posts'
	);
	foreach($theme_widgets as $theme_widget) {
		if( isset( $widgets[$theme_widget] ) ) {
			$widgets[$theme_widget]['groups'] = array('intro-theme');
			$widgets[$theme_widget]['icon'] = 'dashicons dashicons-schedule';
		}
	}
	return $widgets;
}
add_filter('siteorigin_panels_widgets', 'intro_theme_widgets');

/* Adds a tab for the theme widgets in the page builder */
function intro_theme_widgets_tab($tabs){
	$tabs[] = array(
		'title' => __('Intro Theme Widgets', 'intro'),
		'filter' => array(
			'groups' => array('intro-theme')
		)
	);
	return $tabs;
}
add_filter('siteorigin_panels_widget_dialog_tabs', 'intro_theme_widgets_tab', 20);

/* Replace default row options */
function intro_row_styles($fields) {

	$fields['bottom_border'] = array(
		'name' => __('Bottom Border Color', 'intro'),
		'type' => 'color',
		'priority' => 3,		
	);
	$fields['padding'] = array(
		'name' => __('Top/bottom padding', 'intro'),
		'type' => 'measurement',
		'description' => __('Top and bottom padding for this row [default: 100px]', 'intro'),
		'priority' => 4,
	);
	$fields['align'] = array(
		'name' => __('Center align the content?', 'intro'),
		'type' => 'checkbox',
		'description' => __('This may or may not work. It depends on the widget styles.', 'intro'),
		'priority' => 5,
	);		
	$fields['background'] = array(
		'name' => __('Background Color', 'intro'),
		'type' => 'color',
		'description' => __('Background color of the row.', 'intro'),
		'priority' => 6,
	);
	$fields['color'] = array(
		'name' => __('Color', 'intro'),
		'type' => 'color',
		'description' => __('Color of the row.', 'intro'),
		'priority' => 7,
	);	
	$fields['background_image'] = array(
		'name' => __('Background Image', 'intro'),
		'type' => 'image',
		'description' => __('Background image of the row.', 'intro'),
		'priority' => 8,
	);
	$fields['row_stretch'] = array(
		'name' 		=> __('Row Layout', 'intro'),
		'type' 		=> 'select',
		'options' 	=> array(
			'' 				 => __('Standard', 'intro'),
			'full' 			 => __('Full Width', 'intro'),
			'full-stretched' => __('Full Width Stretched', 'intro'),
		),
		'priority' => 9,
	);
	return $fields;
}
remove_filter('siteorigin_panels_row_style_fields', array('SiteOrigin_Panels_Default_Styling', 'row_style_fields' ) );
add_filter('siteorigin_panels_row_style_fields', 'intro_row_styles');

/* Filter for the styles */
function intro_row_styles_output($attr, $style) {
	$attr['style'] = '';

	if(!empty($style['bottom_border'])) $attr['style'] .= 'border-bottom: 1px solid '. esc_attr($style['bottom_border']) . ';';
	if(!empty($style['background'])) $attr['style'] .= 'background-color: ' . esc_attr($style['background']) . ';';
	if(!empty($style['color'])) $attr['style'] .= 'color: ' . esc_attr($style['color']) . ';';
	if(!empty($style['align'])) $attr['style'] .= 'text-align: center;';
	if(!empty( $style['background_image'] )) {
		$url = wp_get_attachment_image_src( $style['background_image'], 'full' );
		if( !empty($url) ) {
			$attr['style'] .= 'background-image: url(' . esc_url($url[0]) . ');';
		}
	}
	if(!empty($style['padding'])) {
		$attr['style'] .= 'padding: ' . esc_attr($style['padding']) . ' 0; ';
	} else {
		$attr['style'] .= 'padding: 40px 0; ';
	}
	if( !empty( $style['row_stretch'] ) ) {
		$attr['class'][] = 'intro-stretch';
		$attr['data-stretch-type'] = esc_attr($style['row_stretch']);
	}
	if(empty($attr['style'])) unset($attr['style']);
	return $attr;
}
add_filter('siteorigin_panels_row_style_attributes', 'intro_row_styles_output', 10, 2);