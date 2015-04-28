<?php
/**
 * Theme Customizer General
 * @package Planum
 */

if ( class_exists( 'WP_Customize_Control' ) ) {
	class Planum_Textarea_Control extends WP_Customize_Control {
	    public $type = 'textarea';
		public function render_content() {
		?>
	        <label>
	        <span class="customize-control-title"><?php echo esc_html( $this->label ); ?></span>
	        <textarea rows="5" class="custom-textarea" <?php $this->link(); ?>><?php echo esc_textarea( $this->value() ); ?></textarea>
	        </label>
	        <?php
		}
	}
}

function planum_register_theme_customizer( $wp_customize ) {

	/*-----------------------------------------------------------*
	 * Color Options section
	 *-----------------------------------------------------------*/
    $wp_customize->add_setting(
        'planum_main_color',
        array(
            'default'     => '#2E3138',
	'sanitize_callback' => 'sanitize_hex_color',
            'transport'   => 'postMessage'
        )
    );
    $wp_customize->add_setting(
        'planum_additional_color',
        array(
            'default'     => '#1ccca0',
	'sanitize_callback' => 'sanitize_hex_color',
            'transport'   => 'postMessage'
        )
    );
    $wp_customize->add_setting(
        'planum_menu_color',
        array(
            'default'     => '#FEFEFE',
	'sanitize_callback' => 'sanitize_hex_color',
            'transport'   => 'postMessage'
        )
    );
    $wp_customize->add_setting(
        'planum_secondary_color',
        array(
            'default'     => '#DEDEDE',
	'sanitize_callback' => 'sanitize_hex_color',
            'transport'   => 'postMessage'
        )
    );

 //CONTROL

    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'main_color',
            array(
                'label'      => __( 'Main Color', 'planum' ),
                'section'    => 'colors',
                'settings'   => 'planum_main_color'
            )
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'additional_color',
            array(
                'label'      => __( 'Additional Color', 'planum' ),
                'section'    => 'colors',
                'settings'   => 'planum_additional_color'
            )
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'menu_color',
            array(
                'label'      => __( 'Menu Color', 'planum' ),
                'section'    => 'colors',
                'settings'   => 'planum_menu_color'
            )
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'secondary_color',
            array(
                'label'      => __( 'Secondary Color', 'planum' ),
                'section'    => 'colors',
                'settings'   => 'planum_secondary_color'
            )
        )
    );

	/*-----------------------------------------------------------
	 * Home Tagline section
	 *-----------------------------------------------------------*/
	$wp_customize->add_section(
		'planum_home_tagline',
		array(
			'title'     => __( 'Home Tagline', 'planum' ),
			'priority'  => 100
		)
	);
		$wp_customize->add_setting(
			'home_tagline',
			array(
			'default' => 'Home Tagline. Use h1 tag title',
			'sanitize_callback' => 'planum_sanitize_textarea',
			'transport'   => 'postMessage'
			)
		);
    $wp_customize->add_setting(
        'home_tagline_bgcolor',
        array(
	'default'     => '#2E3138',
	'sanitize_callback' => 'sanitize_hex_color',
	'transport'   => 'postMessage'
        )
    );
//Home TagLine CONTROL
		$wp_customize->add_control( new planum_Textarea_Control( $wp_customize, 'home_tagline', array(
			'label' => __( 'Tagline Text', 'planum' ),
			'section' => 'planum_home_tagline',
			'settings' => 'home_tagline',
			//'priority' => 27,
			'type' => 'text',
		) ) );
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'home_tagline_bgcolor',
            array(
                'label'      => __( 'Background Color', 'planum' ),
                'section'    => 'planum_home_tagline',
	// 'section'  => 'header_image',
                'settings'   => 'home_tagline_bgcolor'
            )
        )
    );

	/*-----------------------------------------------------------*
	 * Display Options section
	 *-----------------------------------------------------------*/
	$wp_customize->add_section(
		'planum_display_options',
		array(
			'title'     => __( 'Display Options', 'planum' ),
			'priority'  => 200
		)
	);
	/* Header */
	$wp_customize->add_setting( 
		'planum_display_header',
		array(
			'sanitize_callback' => 'planum_sanitize_checkbox',
		)
	);
	$wp_customize->add_control(
		'planum_display_header',
		array(
			'section'   => 'planum_display_options',
			'label'     => __( 'Hide Site Title', 'planum' ),
			'type'      => 'checkbox'
		)
	);
	$wp_customize->add_setting( 
		'planum_display_tagline',
		array(
			'sanitize_callback' => 'planum_sanitize_checkbox',
		)
	);
	$wp_customize->add_control(
		'planum_display_tagline',
		array(
			'section'   => 'planum_display_options',
			'label'     => __( 'Hide Header Image &Tagline', 'planum' ),
			'type'      => 'checkbox'
		)
	);
	/* Logo Image Upload */
	$wp_customize->add_setting(
		'logo_upload',
		array(
			'sanitize_callback' => 'esc_url_raw',
		)
	);

	$wp_customize->add_control( new WP_Customize_Image_Control( $wp_customize, 'logo_upload', array(
		'label' => __( 'Logo Image', 'planum' ),
		'section' =>  'planum_display_options',
		'settings' => 'logo_upload'
	) ) );
	/* Copyright */
	$wp_customize->add_setting(
		'planum_footer_copyright_text',
		array(
			'default'            => 'All Rights Reserved',
			'sanitize_callback'  => 'planum_sanitize_txt',
			'transport'          => 'postMessage'
		)
	);

	$wp_customize->add_control(
		'planum_footer_copyright_text',
		array(
			'section'  => 'planum_display_options',
			'label'    => __( 'Copyright Message', 'planum' ),
			'type'     => 'text'
		)
	);


}
add_action( 'customize_register', 'planum_register_theme_customizer' );

	/*-----------------------------------------------------------*
	 * Sanitize
	 *-----------------------------------------------------------*/
function planum_sanitize_textarea( $input ) {
	return wp_kses_post(force_balance_tags($input));
}
function planum_sanitize_txt( $input ) {
	return strip_tags( stripslashes( $input ) );
}
function planum_sanitize_checkbox( $value ) {
        if ( 'on' != $value )
            $value = false;

        return $value;
    }

	/*-----------------------------------------------------------*
	 * Styles print
	 *-----------------------------------------------------------*/
function planum_customizer_css() {
?>
	 <style type="text/css">
body, .single .content-right .entry-header .entry-format, .archive .entry-title a, .search-results .entry-title a, #menu-topic a, #respond, .comment #respond,
#contactform, .wp-caption-text { color: <?php echo get_theme_mod( 'planum_main_color' ); ?>; }
.trans, .sub-menu, .sticky-posts, .comment-list .comment-box, .site-footer, .widget_calendar thead, #wp-calendar thead,
input[type="submit"], input[type="reset"], input[type="button"], button, .btn, .planum:nth-child(4n+1) .planum-content, .planum:nth-child(4n+4) .planum-content, tfoot { background: <?php echo get_theme_mod( 'planum_main_color' ); ?>; }
a, .content-left .entry-meta p, .sticky-post-content .entry-title a, .sticky-post-content-2 .entry-title a, .brick-post-content .entry-title a, .brick-post-content-2 .entry-title a, .tagline-txt h1, .widget_calendar td a, .menu-toggle::before, #menu-topic a:hover, .toggle-top::before, .toggle-comments::after, #wp-calendar td a, .widget_calendar td a, .caselink::before { color: <?php echo get_theme_mod( 'planum_additional_color' ); ?>; }
.navigation-main ul ul, .navigation-main ul ul ul, .navigation-main-mobile ul, .navigation-main-mobile ul li ul, .navigation-main-mobile ul li ul ul, .comment-list ul.children .comment .comment-box, .widget_calendar tbody, .tagline input[type="submit"],.tagline input[type="reset"],.tagline input[type="button"],.tagline button,.tagline .btn, .planum:nth-child(4n+3) .planum-content, .planum:nth-child(4n+2) .planum-content, #wp-calendar tbody, .widget_calendar tbody, blockquote { background: <?php echo get_theme_mod( 'planum_additional_color' ); ?>; }
.site-header .site-title a, .site-description, .site-title, .navigation-main ul li a, .navigation-main-mobile ul li a { color: <?php echo get_theme_mod( 'planum_menu_color' ); ?>; }
.navigation-main ul li:hover > a,.navigation-main ul li.current_page_item > a,.navigation-main ul li.current-menu-item > a,.navigation-main ul li.current-menu-ancestor > a,.navigation-main ul li.current_page_ancestor > a,.navigation-main-mobile ul li:hover > a,.navigation-main-mobile ul li.current_page_item > a,.navigation-main-mobile ul li.current-menu-item > a,.navigation-main-mobile ul li.current-menu-ancestor > a,.navigation-main-mobile ul li.current_page_ancestor > a, .footer-widget a { color: <?php echo get_theme_mod( 'planum_secondary_color' ); ?>; }
.top-wrapper, #wp-calendar td a, .widget_calendar td a { background: <?php echo get_theme_mod( 'planum_secondary_color' ); ?>; }

		<?php if( true === get_theme_mod( 'planum_display_header' ) ) { ?>
#header-title { display: none; }
		<?php } // end if ?>
		<?php if( true === get_theme_mod( 'planum_display_tagline' ) ) { ?>
#home-tagline { display: none; }
		<?php } // end if ?>
		
	 </style>
<?php
}
add_action( 'wp_head', 'planum_customizer_css' );

	/*-----------------------------------------------------------*
	 * Live Preview
	 *-----------------------------------------------------------*/
function planum_customizer_live_preview() {

	wp_enqueue_script(
		'theme-customizer',
		get_template_directory_uri() . '/js/theme-customizer.js',
		array( 'jquery', 'customize-preview' ),
		'27102014',
		true
	);

}
add_action( 'customize_preview_init', 'planum_customizer_live_preview' );