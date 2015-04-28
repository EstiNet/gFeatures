<?php
/**
 * @package Planum
 */

	/**
	 * Set the content width based on the theme's design and stylesheet.
	 */
	if ( ! isset( $content_width ) ) {
		$content_width = 2800; /* pixels */
	}

if ( ! function_exists( 'planum_setup' ) ) :
/**
 * Sets up theme defaults and registers support for various WordPress features.
 */
function planum_setup() {

	/**
	 * Custom template tags for this theme.
	 */
	require( get_template_directory() . '/inc/template-tags.php' );

	/**
	 * Custom functions that act independently of the theme templates
	 */
	require( get_template_directory() . '/inc/extras.php' );

	/**
	 * Make theme available for translation
	 */
	load_theme_textdomain( 'planum', get_template_directory() . '/languages' );

	/*
	 * This theme styles the visual editor to resemble the theme style
	 */
	add_editor_style( array( 'editor-style.css', planum_fonts_url() ) );

	/**
	 * Add default posts and comments RSS feed links to head
	 */
	add_theme_support( 'automatic-feed-links' );

	/**
	 * Enable support for Post Thumbnails
	 */
	add_theme_support( 'post-thumbnails' );

	/*
	 * Let WordPress 4.1+ manage the document title.
	 * By adding theme support, we declare that this theme does not use a
	 * hard-coded <title> tag in the document head, and expect WordPress to
	 * provide it for us.
	 */
	add_theme_support( 'title-tag' );

	/**
	 * WooCommerce Ready
	 */
	function woocommerce_support() {
    		add_theme_support( 'woocommerce' );
	}

	/**
	 * Set the Custom Image Sizes
	 */
	add_image_size( 'planum-quadratum', 800, 800, true );

	add_image_size( 'planum-rectangulum', 400, 220, true );

	add_image_size( 'planum-sticky', 600, 420, true );

	add_image_size( 'planum-featured-small', 9999, 750, true );

	add_image_size( 'planum-featured', 9999, 1400, true );

	/*
	 * HTML5
	 */
	add_theme_support( 'html5', array(
		'comment-form', 'comment-list', 'gallery', 'caption'
	) );

	/**
	 * Enable support for Post Formats
	 */
	//add_theme_support( 'post-formats', array( 'image', 'video', 'audio', 'quote', 'link', 'aside', 'status', 'gallery' ) );

	/**
	 * Setup the WordPress core custom header image.
	 */
	add_theme_support( 'custom-header', apply_filters( 'planum_custom_header_args', array(
		//'default-image'	=> get_template_directory_uri().'/img/header.jpg',
                                'header-text'	=> false,
		'width'	=> 9999,
		'height'	=> 750,
		'flex-height'	=> true,
                                'flex-width'	=> true,
		//'wp-head-callback'       => 'planum_header_style',
		'admin-head-callback'    => 'planum_admin_header_style',
		'admin-preview-callback' => 'planum_admin_header_image',
	) ) );

	/**
	 * Setup the WordPress core custom background feature.
	 */
	add_theme_support( 'custom-background', apply_filters( 'planum_custom_background_args', array(
		'default-color' => 'fff'
	) ) );

	/**
	 * Custom Menu location.
	 */
	register_nav_menus( array(
		'primary' => __( 'Header Menu', 'planum' ),
		'top' => __( 'Top Menu', 'planum' ),
		'social' => __( 'Social Menu', 'planum' )
	) );

}
endif; // planum_setup
add_action( 'after_setup_theme', 'planum_setup' );

/**
 * Add Excerpt for Page.
 */
function true_add_excerpt_to_pages() {
	add_post_type_support( 'page', 'excerpt' );
}
add_action('init', 'true_add_excerpt_to_pages');

/**
 * Implement the Custom Header feature.
 */
require get_template_directory() . '/inc/custom-header.php';

/**
 * Widgetized
 */
function planum_widgets_init() {
	register_sidebar( array(
		'name'          => __( 'Blog Sidebar', 'planum' ),
		'id'            => 'sidebar-blog',
		'before_widget' => '<aside id="%1$s" class="widget %2$s clearfix">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h1 class="widget-title">',
		'after_title'   => '</h1>',
	) );
	register_sidebar( array(
		'name'          => __( 'Page Sidebar', 'planum' ),
		'id'            => 'sidebar-page',
		'before_widget' => '<aside id="%1$s" class="widget %2$s clearfix">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h1 class="widget-title">',
		'after_title'   => '</h1>',
	) );
	register_sidebar( array(
		'name'          => __( 'Archive Sidebar', 'planum' ),
		'id'            => 'sidebar-archive',
		'before_widget' => '<aside id="%1$s" class="widget %2$s clearfix">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h1 class="widget-title">',
		'after_title'   => '</h1>',
	) );
	register_sidebar( array(
		'name'          => __( 'Top Left', 'planum' ),
		'id'            => 'top-left',
		'before_widget' => '<aside id="%1$s" class="widget %2$s clearfix">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h5 class="widget-title">',
		'after_title'   => '</h5>',
	) );
	register_sidebar( array(
		'name'          => __( 'Top Right', 'planum' ),
		'id'            => 'top-right',
		'before_widget' => '<aside id="%1$s" class="widget %2$s clearfix">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h5 class="widget-title">',
		'after_title'   => '</h5>',
	) );
	register_sidebar( array(
		'name' => __('Footer1', 'planum'),
		'description' => __('Located in the footer left of the page.', 'planum'),
		'id' => 'footer1',
		'before_title' => '<h5>', //class="hidden"
		'after_title' => '</h5>',
		'before_widget' => '<div class="footer-widget">',
		'after_widget' => '</div>'
	) );
       register_sidebar( array(
            'name' => __('Footer2', 'planum'),
            'description' => __('Located in the footer center of the page.', 'planum'),
            'id' => 'footer2',
            'before_title' => '<h5>',
            'after_title' => '</h5>',
            'before_widget' => '<div class="footer-widget">',
            'after_widget' => '</div>'
        ) );
       register_sidebar( array(
            'name' => __('Footer3', 'planum'),
            'description' => __('Located in the footer right of the page.', 'planum'),
            'id' => 'footer3',
            'before_title' => '<h5>',
            'after_title' => '</h5>',
            'before_widget' => '<div class="footer-widget">',
            'after_widget' => '</div>'
        ) );
}
add_action( 'widgets_init', 'planum_widgets_init' );


/**
 * Register Google fonts for Theme
 * Better way
 */
if ( ! function_exists( 'planum_fonts_url' ) ) :

function planum_fonts_url() {
    $fonts_url = '';
 
    /* Translators: If there are characters in your language that are not
    * supported by Open Sans, translate this to 'off'. Do not translate
    * into your own language.
    */
    $open_sans = _x( 'on', 'Open Sans font: on or off', 'planum' );
 
    if ( 'off' !== $open_sans ) {
        $font_families = array();
 
        if ( 'off' !== $open_sans ) {
            $font_families[] = 'Open Sans:300italic,400italic,700italic,400,600,700,300';
        }
 
        $query_args = array(
            'family' => urlencode( implode( '|', $font_families ) ),
            'subset' => urlencode( 'latin,cyrillic' ),
        );
 
        $fonts_url = add_query_arg( $query_args, '//fonts.googleapis.com/css' );
    }
 
    return $fonts_url;
}
endif;

/**
 * Enqueue scripts and styles
 */
function planum_scripts() {

	wp_enqueue_style( 'planum-fonts', planum_fonts_url(), array(), null );
      
	wp_enqueue_style( 'awesome', get_template_directory_uri() . '/font-awesome/css/font-awesome.min.css?v=4.2' );//Awesome inc
	
                wp_enqueue_style( 'planum-style', get_stylesheet_uri() );

	wp_enqueue_script( 'planum-flexslider', get_template_directory_uri() . '/js/jquery.flexslider-min.js', array( 'jquery' ), '27102014', true );

	wp_enqueue_script( 'planum-fitvids', get_template_directory_uri() . '/js/jquery.fitvids.js', array( 'jquery' ), '27102014', true );

	wp_enqueue_script( 'planum-main', get_template_directory_uri() . '/js/main.js', array( 'jquery' ), '27102014', true );

	wp_enqueue_script( 'planum-skip-link-focus-fix', get_template_directory_uri() . '/js/skip-link-focus-fix.js', array(), '27102014', true );

	if ( is_singular() && comments_open() && get_option( 'thread_comments' ) ) {
		wp_enqueue_script( 'comment-reply' );
	}
}
add_action( 'wp_enqueue_scripts', 'planum_scripts' );

/**
 * Excerpt length
 */
function planum_excerpt_length($length) {
	if ( is_sticky() ) {
		$length = 50;
	} elseif ( is_page() ) {
		$length = 30;
	} elseif ( is_home() || is_category() || is_archive() ) {
		$length = 40;
	} else {
		$length = 20;
	}
	return $length;
}
add_filter('excerpt_length', 'planum_excerpt_length', 999);

/**
 * Replace [...] in excerpts with something new
 */
function planum_excerpt_more($more) {
	return '&hellip;';
}
add_filter('excerpt_more', 'planum_excerpt_more');

/**
 * Gallery layout
 */
require( get_template_directory() . '/inc/gallery.php');

/**
 * Add button CSS class
 */
function planum_add_btn_link_class() {
	return 'class="btn"';
}
add_filter('next_posts_link_attributes', 'planum_add_btn_link_class');
add_filter('previous_posts_link_attributes', 'planum_add_btn_link_class');
add_filter('next_comments_link_attributes', 'planum_add_btn_link_class');
add_filter('previous_comments_link_attributes', 'planum_add_btn_link_class');

/**
 * Footer credits.
 */
function planum_txt_credits() {
	$text = sprintf( __( 'Powered by %s', 'planum' ), '<a href="http://wordpress.org/">WordPress</a>' );
	$text .= '<span class="sep"> &middot; </span>';
	$text .= sprintf( __( 'Theme by %s', 'planum' ), '<a href="http://dinevthemes.com/">DinevThemes</a>' );
	echo apply_filters( 'planum_txt_credits', $text );
}
add_action( 'planum_credits', 'planum_txt_credits' );

/**
 * Theme Customizer
 **/
require_once ( get_template_directory() .'/inc/customizer.php' );

/**
 * Theme Options
 */
require(get_template_directory() . '/theme-options/theme-admin.php');

/**
 * Contextual Help
 */
require( get_template_directory() . '/inc/contextual-help.php' );

/**
 * EXTRA FUNC&PLUGINS
 */

/*======JetPack=======*/

/**
 * Add theme support for infinity scroll
 */
function planum_infinite_scroll_init() {
	add_theme_support( 'infinite-scroll', array(
				'container' => 'planum-scroll',
				'render'	=> 'planum_infinite_scroll_render',
				'footer'	=> false,
				'type'	=> 'scroll'
			) );
}
add_action( 'after_setup_theme', 'planum_infinite_scroll_init' );

/**
 * Set the code to be rendered on for calling posts for infinity scroll
 */
function planum_infinite_scroll_render() {
    get_template_part('content', 'blog-tiles');
}

/**
 * Remove sharedaddy from excerpt.
 */
function planum_sidebar_sharedaddy() {
	remove_filter( 'the_content', 'sharing_display', 19 );
}
add_action( 'dynamic_sidebar', 'planum_sidebar_sharedaddy' );

function planum_excerpt_sharedaddy() {
    remove_filter( 'the_excerpt', 'sharing_display', 19 );
}
add_action( 'wp_head', 'planum_excerpt_sharedaddy' );

/*======WooCommerce Plugin=======*/

require_once( ABSPATH . 'wp-admin/includes/plugin.php' );
//plugin activate?

if ( is_plugin_active( 'woocommerce/woocommerce.php' ) ) {

	function wooshop_widgets_init() {
		register_sidebar(array(
		'name' => __('WooShop', 'planum' ),
		'description' => __('Located in the sidebar woo-shop pages.', 'planum' ),
		'id' => 'wooshop',
		'before_title' => '<h1 class="widget-title">',
		'after_title' => '</h3>',
		'before_widget' => '<aside id="%1$s" class="widget %2$s clearfix">',
		'after_widget' => '</aside>'
		));
	}
add_action( 'widgets_init', 'wooshop_widgets_init' );

	function planum_woocommerce_css() {
		wp_enqueue_style( 'woocommerce-custom-style', get_template_directory_uri() . '/css/woocommerce.css' );
	}
add_action( 'wp_enqueue_scripts', 'planum_woocommerce_css' );

remove_action( 'woocommerce_before_main_content', 'woocommerce_output_content_wrapper', 10);
remove_action( 'woocommerce_after_main_content', 'woocommerce_output_content_wrapper_end', 10);

add_filter( 'woocommerce_show_page_title', 'custom_woocommerce_page_title');
function custom_woocommerce_page_title( $page_title ) {
    return false;
}

} // is_plugin_active()