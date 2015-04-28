<?php

//Dynamic styles
function intro_custom_styles($custom) {


	//Fonts
	$headings_font = esc_html(get_theme_mod('headings_fonts'));	
	$body_font = esc_html(get_theme_mod('body_fonts'));	
	$welcome_font = esc_html(get_theme_mod('welcome_fonts'));
	
	if ( $headings_font ) {
		$font_pieces = explode(":", $headings_font);
		$custom = "h1, h2, h3, h4, h5, h6, input[type=\"text\"], input[type=\"email\"], .search_widget input, button, .button,input[type=\"submit\"], input[type=\"reset\"] { font-family: {$font_pieces[0]}; }"."\n";
	}
	if ( $body_font ) {
		$font_pieces = explode(":", $body_font);
		$custom .= "body { font-family: {$font_pieces[0]}; }"."\n";
	}
	if ( $welcome_font ) {
		$font_pieces = explode(":", $welcome_font);
		$custom .= ".welcome-info { font-family: {$font_pieces[0]}; }"."\n";
	}	
	//H1 size
	$h1_size = get_theme_mod( 'h1_size' );
	if ( get_theme_mod( 'h1_size' )) {
		$custom .= "h1 { font-size:" . intval($h1_size) . "px; }"."\n";
	}
    //H2 size
    $h2_size = get_theme_mod( 'h2_size' );
    if ( get_theme_mod( 'h2_size' )) {
        $custom .= "h2 { font-size:" . intval($h2_size) . "px; }"."\n";
    }
    //H3 size
    $h3_size = get_theme_mod( 'h3_size' );
    if ( get_theme_mod( 'h3_size' )) {
        $custom .= "h3 { font-size:" . intval($h3_size) . "px; }"."\n";
    }
    //H4 size
    $h4_size = get_theme_mod( 'h4_size' );
    if ( get_theme_mod( 'h4_size' )) {
        $custom .= "h4 { font-size:" . intval($h4_size) . "px; }"."\n";
    }
    //H5 size
    $h5_size = get_theme_mod( 'h5_size' );
    if ( get_theme_mod( 'h5_size' )) {
        $custom .= "h5 { font-size:" . intval($h5_size) . "px; }"."\n";
    }
    //H6 size
    $h6_size = get_theme_mod( 'h6_size' );
    if ( get_theme_mod( 'h6_size' )) {
        $custom .= "h6 { font-size:" . intval($h6_size) . "px; }"."\n";
    }
    //Body size
    $body_size = get_theme_mod( 'body_size' );
    if ( get_theme_mod( 'body_size' )) {
        $custom .= "body { font-size:" . intval($body_size) . "px; }"."\n";
    }
    //Widget titles size
    $widget_title_size = get_theme_mod( 'widget_title_size' );
    if ( get_theme_mod( 'widget_title_size' )) {
        $custom .= ".panel .widget-title { font-size:" . intval($widget_title_size) . "px; }"."\n";
    }
    //Header
    $header_height = get_theme_mod('header_height', '100');
	if ( isset($header_height) && ( $header_height != '100' ) ) {
		$custom .= "#header-banner { min-height: " . intval($header_height) . "%; }"."\n";
	}
    $header_cover = get_theme_mod('header_cover');
	if ( isset($header_cover) && ( $header_cover != '' ) ) {
		$custom .= "#header-banner { background-size: cover !important; }"."\n";
	}

	//Primary color
	$primary_color = esc_html(get_theme_mod( 'primary_color' ));
	if ( isset($primary_color) && ( $primary_color != '#f2d25b' )) {
		$custom .= ".button, .to-top:hover [class^=\"icon\"], input[type=\"submit\"], a:hover, .sidebar-nav ul li a:hover, .header-container h1 span, .portfolio-nav li a.active, .hentry:hover .entry-title, .post:hover .entry-title { color: {$primary_color}; }"."\n";
		$custom .= ".icon-round, .button.dark.solid:hover, .button:hover, .button.solid, #contact-form .notification.success, #contact-form label.error, input[type=\"submit\"]:hover, .panel .widget-title:after, .spinner > div, .tags a:hover, #services .feature .icon-bg { background-color: {$primary_color}; }"."\n";
		$custom .= ".button.dark.solid:hover, .button, #content.single-post .hentry, .to-top:hover, #footer .share-social, input[type=\"submit\"] { border-color: {$primary_color}; }"."\n";
	}
	//Site title
	$site_title = esc_html(get_theme_mod( 'site_title_color' ));
	if ( isset($site_title) && ( $site_title != '#ffffff' )) {
		$custom .= ".site-title a { color: {$site_title}; }"."\n";
	}
	//Site description
	$site_desc = esc_html(get_theme_mod( 'site_desc_color' ));
	if ( isset($site_desc) && ( $site_desc != '#ffffff' )) {
		$custom .= ".site-description { color: {$site_desc}; }"."\n";
	}	
	//Body text
	$body_text = esc_html(get_theme_mod( 'body_text_color' ));
	if ( isset($body_text) && ( $body_text != '#aaa' )) {
		$custom .= "body { color: {$body_text}; }"."\n";
	}
	//Footer background
	$footer_bg = esc_html(get_theme_mod( 'footer_color' ));
	if ( isset($footer_bg) && ( $footer_bg != '#222' )) {
		$custom .= "#footer { background-color: {$footer_bg}; }"."\n";
	}	
	//Output all the styles
	wp_add_inline_style( 'intro-style', $custom );	
}
add_action( 'wp_enqueue_scripts', 'intro_custom_styles' );