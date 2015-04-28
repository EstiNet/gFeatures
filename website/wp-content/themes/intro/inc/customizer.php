<?php
/**
 * Intro Theme Customizer
 *
 * @package Intro
 */


function intro_customize_register( $wp_customize ) {
	$wp_customize->get_setting( 'blogname' )->transport         = 'postMessage';
	$wp_customize->get_setting( 'blogdescription' )->transport  = 'postMessage';
	$wp_customize->get_setting( 'header_textcolor' )->transport = 'postMessage';

    //___General___//
    $wp_customize->add_section(
        'intro_general',
        array(
            'title' => __('General', 'intro'),
            'priority' => 9,
        )
    );
    //Logo Upload
    $wp_customize->add_setting(
        'site_logo',
        array(
            'default-image' => '',
            'sanitize_callback' => 'esc_url_raw',
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Image_Control(
            $wp_customize,
            'site_logo',
            array(
               'label'          => __( 'Upload your logo', 'intro' ),
               'type'           => 'image',
               'section'        => 'intro_general',
               'settings'       => 'site_logo',
               'priority' => 9,
            )
        )
    );
    //Favicon Upload
    $wp_customize->add_setting(
        'site_favicon',
        array(
            'default-image' => '',
            'sanitize_callback' => 'esc_url_raw',
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Image_Control(
            $wp_customize,
            'site_favicon',
            array(
               'label'          => __( 'Upload your favicon', 'intro' ),
               'type'           => 'image',
               'section'        => 'intro_general',
               'settings'       => 'site_favicon',
               'priority' => 10,
            )
        )
    );
    //Apple touch icon 144
    $wp_customize->add_setting(
        'apple_touch_144',
        array(
            'default-image' => '',
            'sanitize_callback' => 'esc_url_raw',
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Image_Control(
            $wp_customize,
            'apple_touch_144',
            array(
               'label'          => __( 'Upload your Apple Touch Icon (144x144 pixels)', 'intro' ),
               'type'           => 'image',
               'section'        => 'intro_general',
               'settings'       => 'apple_touch_144',
               'priority'       => 11,
            )
        )
    );
    //Apple touch icon 114
    $wp_customize->add_setting(
        'apple_touch_114',
        array(
            'default-image' => '',
            'sanitize_callback' => 'esc_url_raw',
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Image_Control(
            $wp_customize,
            'apple_touch_114',
            array(
               'label'          => __( 'Upload your Apple Touch Icon (114x114 pixels)', 'intro' ),
               'type'           => 'image',
               'section'        => 'intro_general',
               'settings'       => 'apple_touch_114',
               'priority'       => 12,
            )
        )
    );
    //Apple touch icon 72
    $wp_customize->add_setting(
        'apple_touch_72',
        array(
            'default-image' => '',
            'sanitize_callback' => 'esc_url_raw',
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Image_Control(
            $wp_customize,
            'apple_touch_72',
            array(
               'label'          => __( 'Upload your Apple Touch Icon (72x72 pixels)', 'intro' ),
               'type'           => 'image',
               'section'        => 'intro_general',
               'settings'       => 'apple_touch_72',
               'priority'       => 13,
            )
        )
    );
    //Apple touch icon 57
    $wp_customize->add_setting(
        'apple_touch_57',
        array(
            'default-image' => '',
            'sanitize_callback' => 'esc_url_raw',
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Image_Control(
            $wp_customize,
            'apple_touch_57',
            array(
               'label'          => __( 'Upload your Apple Touch Icon (57x57 pixels)', 'intro' ),
               'type'           => 'image',
               'section'        => 'intro_general',
               'settings'       => 'apple_touch_57',
               'priority'       => 14,
            )
        )
    );
	//___Header area___//
    $wp_customize->add_section(
        'header_area',
        array(
            'title' => __('Header Area', 'intro'),
            'priority' => 12,
        )
    );
    //Typed title
    $wp_customize->add_setting(
        'typed_title',
        array(
            'default' => '',
            'sanitize_callback' => 'intro_sanitize_text',           
        )
    );
    $wp_customize->add_control(
        'typed_title',
        array(
            'label' => __( 'Title', 'intro' ),
            'description' => __( 'Enter the text to display before your animated strings', 'intro' ),
            'section' => 'header_area',
            'type' => 'text',
            'priority' => 10
        )
    );     
    //Typed strings
    $wp_customize->add_setting(
        'typed_strings',
        array(
            'default' => '',
            'sanitize_callback' => 'intro_sanitize_text',           
        )
    );
    $wp_customize->add_control(
        'typed_strings',
        array(
            'label' => __( 'Animated strings', 'intro' ),
            'description' => __( 'Add your strings in this form and replace with your own text: ["first string", "second string"]', 'intro' ),
            'section' => 'header_area',
            'type' => 'textarea',
            'priority' => 11
        )
    );
    //Typed message
    $wp_customize->add_setting(
        'typed_message',
        array(
            'default' => '',
            'sanitize_callback' => 'intro_sanitize_text',           
        )
    );
    $wp_customize->add_control(
        'typed_message',
        array(
            'label' => __( 'Message', 'intro' ),
            'description' => __( 'A message to be displayed after your animated text', 'intro' ),
            'section' => 'header_area',
            'type' => 'text',
            'priority' => 12
        )
    );

   //Header button 1
    $wp_customize->add_setting(
        'header_btn_text_1',
        array(
            'default' => '',
            'sanitize_callback' => 'intro_sanitize_text',
        )
    );
    $wp_customize->add_control(
        'header_btn_text_1',
        array(
            'label' => __( 'First call to action button title', 'intro' ),
            'section' => 'header_area',
            'type' => 'text',
            'priority' => 13
        )
    );
   //Header button link 1
    $wp_customize->add_setting(
        'header_btn_link_1',
        array(
            'default' => '',
            'sanitize_callback' => 'esc_url_raw',
        )
    );
    $wp_customize->add_control(
        'header_btn_link_1',
        array(
            'label' => __( 'First call to action button link', 'intro' ),
            'section' => 'header_area',
            'type' => 'text',
            'priority' => 14
        )
    ); 
   //Header button 2
    $wp_customize->add_setting(
        'header_btn_text_2',
        array(
            'default' => '',
            'sanitize_callback' => 'intro_sanitize_text',
        )
    );
    $wp_customize->add_control(
        'header_btn_text_2',
        array(
            'label' => __( 'Second call to action button title', 'intro' ),
            'section' => 'header_area',
            'type' => 'text',
            'priority' => 15
        )
    );
   //Header button link 2
    $wp_customize->add_setting(
        'header_btn_link_2',
        array(
            'default' => '',
            'sanitize_callback' => 'esc_url_raw',
        )
    );
    $wp_customize->add_control(
        'header_btn_link_2',
        array(
            'label' => __( 'Second call to action button link', 'intro' ),
            'section' => 'header_area',
            'type' => 'text',
            'priority' => 16
        )
    );

    //Header min-height
    $wp_customize->add_setting(
        'header_height',
        array(
            'default' => '100',
            'sanitize_callback' => 'absint',           
        )
    );
    $wp_customize->add_control(
        'header_height',
        array(
            'label' => __( 'Header min. height', 'intro' ),
            'description' => __( 'Add your minimum height for the header area [%]', 'intro' ),
            'section' => 'header_area',
            'type' => 'text',
            'priority' => 17
        )
    );
    //Cover
    $wp_customize->add_setting(
        'header_cover',
        array(
            'sanitize_callback' => 'intro_sanitize_checkbox',
            'default' => 0,         
        )       
    );
    $wp_customize->add_control(
        'header_cover',
        array(
            'type' => 'checkbox',
            'label' => __('Check this box to set [background-size: cover] instead of [background-size: contain] for the header image', 'intro'),
            'section' => 'header_area',
            'priority' => 18,           
        )
    );
    //Activate
    $wp_customize->add_setting(
        'header_active',
        array(
            'sanitize_callback' => 'intro_sanitize_checkbox',
            'default' => 0,         
        )       
    );
    $wp_customize->add_control(
        'header_active',
        array(
            'type' => 'checkbox',
            'label' => __('Disable the header image and text on all pages except the front page?', 'intro'),
            'section' => 'header_area',
            'priority' => 19,            
        )
    );
    //___Fonts___//
    $wp_customize->add_section(
        'intro_typography',
        array(
            'title' => __('Fonts', 'intro' ),
            'priority' => 15,
        )
    );
    $font_choices = 
        array(
            'Source Sans Pro:400,700,400italic,700italic' => 'Source Sans Pro',     
            'Droid Sans:400,700' => 'Droid Sans',
            'Lato:400,700,400italic,700italic' => 'Lato',
            'Arvo:400,700,400italic,700italic' => 'Arvo',
            'Lora:400,700,400italic,700italic' => 'Lora',
            'PT Sans:400,700,400italic,700italic' => 'PT Sans',
            'PT Sans Narrow:400,700' => 'PT Sans Narrow',
            'Arimo:400,700,400italic,700italic' => 'Arimo',
            'Ubuntu:400,700,400italic,700italic' => 'Ubuntu',
            'Bitter:400,700,400italic' => 'Bitter',
            'Droid Serif:400,700,400italic,700italic' => 'Droid Serif',
            'Open Sans:400italic,700italic,400,700' => 'Open Sans',
            'Roboto:400,400italic,700,700italic' => 'Roboto',
            'Oswald:400,700' => 'Oswald',
            'Open Sans Condensed:700,300italic,300' => 'Open Sans Condensed',
            'Roboto Condensed:400italic,700italic,400,700' => 'Roboto Condensed',
            'Raleway:400,700' => 'Raleway',
            'Roboto Slab:400,700' => 'Roboto Slab',
            'Yanone Kaffeesatz:400,700' => 'Yanone Kaffeesatz',
            'Rokkitt:400' => 'Rokkitt',
            'Questrial' => 'Questrial',
            'Rambla:400,700,400italic,700italic' => 'Rambla',
            'Dosis:200,300,400,500,600,700,800' => 'Dosis',
            'Abel' => 'Abel',           
        );
    
    $wp_customize->add_setting(
        'headings_fonts',
        array(
            'sanitize_callback' => 'intro_sanitize_fonts',
        )
    );
    
    $wp_customize->add_control(
        'headings_fonts',
        array(
            'type' => 'select',
            'label' => __('Select your desired font for the headings.', 'intro'),
            'section' => 'intro_typography',
            'choices' => $font_choices
        )
    );
    
    $wp_customize->add_setting(
        'body_fonts',
        array(
            'sanitize_callback' => 'intro_sanitize_fonts',
        )
    );
    
    $wp_customize->add_control(
        'body_fonts',
        array(
            'type' => 'select',
            'label' => __('Select your desired font for the body.', 'intro'),
            'section' => 'intro_typography',
            'choices' => $font_choices
        )
    );
    //H1 size
    $wp_customize->add_setting(
        'h1_size',
        array(
            'sanitize_callback' => 'absint',
            'default'           => '50',
            'transport'         => 'postMessage'
        )       
    );
    $wp_customize->add_control( 'h1_size', array(
        'type'        => 'number',
        'priority'    => 11,
        'section'     => 'intro_typography',
        'label'       => __('H1 font size', 'intro'),
        'input_attrs' => array(
            'min'   => 10,
            'max'   => 60,
            'step'  => 1,
            'style' => 'margin-bottom: 15px; padding: 15px;',
        ),
    ) );
    //H2 size
    $wp_customize->add_setting(
        'h2_size',
        array(
            'sanitize_callback' => 'absint',
            'default'           => '42',
            'transport'         => 'postMessage'
        )       
    );
    $wp_customize->add_control( 'h2_size', array(
        'type'        => 'number',
        'priority'    => 12,
        'section'     => 'intro_typography',
        'label'       => __('H2 font size', 'intro'),
        'input_attrs' => array(
            'min'   => 10,
            'max'   => 60,
            'step'  => 1,
            'style' => 'margin-bottom: 15px; padding: 15px;',
        ),
    ) );
    //H3 size
    $wp_customize->add_setting(
        'h3_size',
        array(
            'sanitize_callback' => 'absint',
            'default'           => '36',
            'transport'         => 'postMessage'
        )       
    );
    $wp_customize->add_control( 'h3_size', array(
        'type'        => 'number',
        'priority'    => 13,
        'section'     => 'intro_typography',
        'label'       => __('H3 font size', 'intro'),
        'input_attrs' => array(
            'min'   => 10,
            'max'   => 60,
            'step'  => 1,
            'style' => 'margin-bottom: 15px; padding: 15px;',
        ),
    ) );
    //h4 size
    $wp_customize->add_setting(
        'h4_size',
        array(
            'sanitize_callback' => 'absint',
            'default'           => '24',
            'transport'         => 'postMessage'
        )       
    );
    $wp_customize->add_control( 'h4_size', array(
        'type'        => 'number',
        'priority'    => 14,
        'section'     => 'intro_typography',
        'label'       => __('H4 font size', 'intro'),
        'input_attrs' => array(
            'min'   => 10,
            'max'   => 60,
            'step'  => 1,
            'style' => 'margin-bottom: 15px; padding: 15px;',
        ),
    ) );
    //h5 size
    $wp_customize->add_setting(
        'h5_size',
        array(
            'sanitize_callback' => 'absint',
            'default'           => '20',
            'transport'         => 'postMessage'
        )       
    );
    $wp_customize->add_control( 'h5_size', array(
        'type'        => 'number',
        'priority'    => 15,
        'section'     => 'intro_typography',
        'label'       => __('H5 font size', 'intro'),
        'input_attrs' => array(
            'min'   => 10,
            'max'   => 60,
            'step'  => 1,
            'style' => 'margin-bottom: 15px; padding: 15px;',
        ),
    ) );
    //h6 size
    $wp_customize->add_setting(
        'h6_size',
        array(
            'sanitize_callback' => 'absint',
            'default'           => '14',
            'transport'         => 'postMessage'
        )       
    );
    $wp_customize->add_control( 'h6_size', array(
        'type'        => 'number',
        'priority'    => 16,
        'section'     => 'intro_typography',
        'label'       => __('H6 font size', 'intro'),
        'input_attrs' => array(
            'min'   => 10,
            'max'   => 60,
            'step'  => 1,
            'style' => 'margin-bottom: 15px; padding: 15px;',
        ),
    ) );
    //body
    $wp_customize->add_setting(
        'body_size',
        array(
            'sanitize_callback' => 'absint',
            'default'           => '15',
            'transport'         => 'postMessage'
        )       
    );
    $wp_customize->add_control( 'body_size', array(
        'type'        => 'number',
        'priority'    => 17,
        'section'     => 'intro_typography',
        'label'       => __('Body font size', 'intro'),
        'input_attrs' => array(
            'min'   => 10,
            'max'   => 24,
            'step'  => 1,
            'style' => 'margin-bottom: 15px; padding: 15px;',
        ),
    ) );
    //Home page widget titles size
    $wp_customize->add_setting(
        'widget_title_size',
        array(
            'sanitize_callback' => 'absint',
            'default'           => '46',
            'transport'         => 'postMessage'
        )       
    );
    $wp_customize->add_control( 'widget_title_size', array(
        'type'        => 'number',
        'priority'    => 18,
        'section'     => 'intro_typography',
        'label'       => __('Home page widget titles size', 'intro'),
        'input_attrs' => array(
            'min'   => 10,
            'max'   => 90,
            'step'  => 1,
            'style' => 'margin-bottom: 15px; padding: 15px;',
        ),
    ) );

    //___Colors___//    
    //Primary color
    $wp_customize->add_setting(
        'primary_color',
        array(
            'default'           => '#f2d25b',
            'sanitize_callback' => 'sanitize_hex_color',
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'primary_color',
            array(
                'label' => __('Primary color', 'intro'),
                'section' => 'colors',
                'settings' => 'primary_color',
                'priority' => 12
            )
        )
    );
    //Site title
    $wp_customize->add_setting(
        'site_title_color',
        array(
            'default'           => '#ffffff',
            'sanitize_callback' => 'sanitize_hex_color',
            'transport'         => 'postMessage'
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'site_title_color',
            array(
                'label' => __('Site title', 'intro'),
                'section' => 'colors',
                'settings' => 'site_title_color',
                'priority' => 13
            )
        )
    );
    //Site description
    $wp_customize->add_setting(
        'site_desc_color',
        array(
            'default'           => '#ffffff',
            'sanitize_callback' => 'sanitize_hex_color',
            'transport'         => 'postMessage'
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'site_desc_color',
            array(
                'label' => __('Site description', 'intro'),
                'section' => 'colors',
                'settings' => 'site_desc_color',
                'priority' => 14
            )
        )
    );
    //Body
    $wp_customize->add_setting(
        'body_text_color',
        array(
            'default'           => '#aaa',
            'sanitize_callback' => 'sanitize_hex_color',
            'transport'         => 'postMessage'
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'body_text_color',
            array(
                'label' => __('Text', 'intro'),
                'section' => 'colors',
                'settings' => 'body_text_color',
                'priority' => 16
            )
        )
    );
    //Footer
    $wp_customize->add_setting(
        'footer_color',
        array(
            'default'           => '#222',
            'sanitize_callback' => 'sanitize_hex_color',
            'transport'         => 'postMessage'
        )
    );
    $wp_customize->add_control(
        new WP_Customize_Color_Control(
            $wp_customize,
            'footer_color',
            array(
                'label' => __('Footer background', 'intro'),
                'section' => 'colors',
                'settings' => 'footer_color',
                'priority' => 17
            )
        )
    );


}
add_action( 'customize_register', 'intro_customize_register' );

/**
 * Sanitization
 */
//Text
function intro_sanitize_text( $input ) {
    return wp_kses_post( force_balance_tags( $input ) );
}
//Checkboxes
function intro_sanitize_checkbox( $input ) {
    if ( $input == 1 ) {
        return 1;
    } else {
        return '';
    }
}
//Fonts
function intro_sanitize_fonts( $input ) {
    $valid = array(
            'Source Sans Pro:400,700,400italic,700italic' => 'Source Sans Pro',     
            'Droid Sans:400,700' => 'Droid Sans',
            'Lato:400,700,400italic,700italic' => 'Lato',
            'Arvo:400,700,400italic,700italic' => 'Arvo',
            'Lora:400,700,400italic,700italic' => 'Lora',
            'PT Sans:400,700,400italic,700italic' => 'PT Sans',
            'PT+Sans+Narrow:400,700' => 'PT Sans Narrow',
            'Arimo:400,700,400italic,700italic' => 'Arimo',
            'Ubuntu:400,700,400italic,700italic' => 'Ubuntu',
            'Bitter:400,700,400italic' => 'Bitter',
            'Droid Serif:400,700,400italic,700italic' => 'Droid Serif',
            'Open+Sans:400italic,700italic,400,700' => 'Open Sans',
            'Roboto:400,400italic,700,700italic' => 'Roboto',
            'Oswald:400,700' => 'Oswald',
            'Open Sans Condensed:700,300italic,300' => 'Open Sans Condensed',
            'Roboto Condensed:400italic,700italic,400,700' => 'Roboto Condensed',
            'Raleway:400,700' => 'Raleway',
            'Roboto Slab:400,700' => 'Roboto Slab',
            'Yanone Kaffeesatz:400,700' => 'Yanone Kaffeesatz',
            'Rokkitt:400' => 'Rokkitt',
            'Questrial' => 'Questrial',
            'Rambla:400,700,400italic,700italic' => 'Rambla',
            'Dosis:200,300,400,500,600,700,800' => 'Dosis',
            'Abel' => 'Abel',
    );
 
    if ( array_key_exists( $input, $valid ) ) {
        return $input;
    } else {
        return '';
    }
}
/**
 * Binds JS handlers to make Theme Customizer preview reload changes asynchronously.
 */
function intro_customize_preview_js() {
	wp_enqueue_script( 'intro_customizer', get_template_directory_uri() . '/js/customizer.js', array( 'customize-preview' ), '20130508', true );
}
add_action( 'customize_preview_init', 'intro_customize_preview_js' );
