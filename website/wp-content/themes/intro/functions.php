<?php
/**
 * Intro functions and definitions
 *
 * @package Intro
 */


if ( ! function_exists( 'intro_setup' ) ) :
/**
 * Sets up theme defaults and registers support for various WordPress features.
 *
 * Note that this function is hooked into the after_setup_theme hook, which
 * runs before the init hook. The init hook is too late for some features, such
 * as indicating support for post thumbnails.
 */
function intro_setup() {

	/*
	 * Make theme available for translation.
	 * Translations can be filed in the /languages/ directory.
	 * If you're building a theme based on Intro, use a find and replace
	 * to change 'intro' to the name of your theme in all the template files
	 */
	load_theme_textdomain( 'intro', get_template_directory() . '/languages' );

	// Add default posts and comments RSS feed links to head.
	add_theme_support( 'automatic-feed-links' );

	// Set the content width based on the theme's design and stylesheet.
	global $content_width;
	if ( ! isset( $content_width ) ) {
		$content_width = 640;
	}

	/*
	 * Enable support for Post Thumbnails on posts and pages.
	 *
	 * @link http://codex.wordpress.org/Function_Reference/add_theme_support#Post_Thumbnails
	 */
	add_theme_support( 'post-thumbnails' );
	add_image_size('intro-thumb', 500, 500, true);

	// This theme uses wp_nav_menu() in one location.
	register_nav_menus( array(
		'primary' => __( 'Primary Menu', 'intro' ),
		'social' => __( 'Social', 'intro' )
	) );

	/*
	 * Switch default core markup for search form, comment form, and comments
	 * to output valid HTML5.
	 */
	add_theme_support( 'html5', array(
		'search-form', 'comment-form', 'comment-list', 'gallery', 'caption',
	) );

	/*
	 * Enable support for Post Formats.
	 * See http://codex.wordpress.org/Post_Formats
	 */
	add_theme_support( 'post-formats', array(
		'aside', 'image', 'video', 'quote', 'link',
	) );

	// Set up the WordPress core custom background feature.
	add_theme_support( 'custom-background', apply_filters( 'intro_custom_background_args', array(
		'default-color' => 'ffffff',
		'default-image' => '',
	) ) );
}
endif; // intro_setup
add_action( 'after_setup_theme', 'intro_setup' );

/**
 * Register widget area.
 *
 * @link http://codex.wordpress.org/Function_Reference/register_sidebar
 */
function intro_widgets_init() {
	register_sidebar( array(
		'name'          => __( 'Sidebar', 'intro' ),
		'id'            => 'sidebar-1',
		'description'   => '',
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h5 class="sidebar-title">',
		'after_title'   => '</h5>',
	) );

	if ( function_exists('siteorigin_panels_activate') ) {
		register_widget( 'Intro_Services' );
		register_widget( 'Intro_Portfolio' );
		register_widget( 'Intro_Action' );
		register_widget( 'Intro_Facts' );
		register_widget( 'Intro_Employees' );
		register_widget( 'Intro_Testimonials' );
		register_widget( 'Intro_About' );
		register_widget( 'Intro_Posts' );
	}	
}
add_action( 'widgets_init', 'intro_widgets_init' );

if ( function_exists('siteorigin_panels_activate') ) {
	require get_template_directory() . "/widgets/fp-services.php";
	require get_template_directory() . "/widgets/fp-portfolio.php";
	require get_template_directory() . "/widgets/fp-call-to-action.php";
	require get_template_directory() . "/widgets/fp-facts.php";
	require get_template_directory() . "/widgets/fp-employees.php";
	require get_template_directory() . "/widgets/fp-testimonials.php";
	require get_template_directory() . "/widgets/fp-about.php";
	require get_template_directory() . "/widgets/fp-latest-posts.php";
}

/**
 * Enqueue scripts and styles.
 */
function intro_scripts() {

	$headings_font = esc_html(get_theme_mod('headings_fonts'));
	$body_font = esc_html(get_theme_mod('body_fonts'));
	if( $headings_font ) {
		wp_enqueue_style( 'intro-headings-fonts', '//fonts.googleapis.com/css?family='. $headings_font );	
	} else {
		wp_enqueue_style( 'intro-body-fonts', '//fonts.googleapis.com/css?family=Raleway:400,700');
	}	
	if( $body_font ) {
		wp_enqueue_style( 'intro-body-fonts', '//fonts.googleapis.com/css?family='. $body_font );	
	} else {
		wp_enqueue_style( 'intro-body-fonts', '//fonts.googleapis.com/css?family=Raleway:400,700');
	}	

	wp_enqueue_style( 'intro-foundation', get_template_directory_uri() . '/css/foundation.css' );

	wp_enqueue_style( 'intro-style', get_stylesheet_uri() );
		
	wp_enqueue_style( 'intro-font-awesome', get_template_directory_uri() . '/fonts/font-awesome.min.css' );

	wp_enqueue_script( 'intro-navigation', get_template_directory_uri() . '/js/navigation.js', array(), '20120206', true );

	wp_enqueue_script( 'intro-skip-link-focus-fix', get_template_directory_uri() . '/js/skip-link-focus-fix.js', array(), '20130115', true );

	wp_enqueue_script( 'intro-fitvids', get_template_directory_uri() . '/js/jquery.fitvids.js', array('jquery'), true );

	wp_enqueue_script( 'intro-scripts', get_template_directory_uri() . '/js/scripts.js', array('jquery'), true );

	wp_enqueue_script( 'intro-popup', get_template_directory_uri() . '/js/jquery.magnific-popup.min.js', array('jquery'), true );

	wp_enqueue_script( 'intro-scroll', get_template_directory_uri() . '/js/smooth-scroll.js', array('jquery'), true );

	wp_enqueue_script( 'intro-counterup', get_template_directory_uri() . '/js/jquery.counterup.min.js', array('jquery'), true );

	wp_enqueue_script( 'intro-custom', get_template_directory_uri() . '/js/custom.js', array('jquery'), true );


	if ( is_singular() && comments_open() && get_option( 'thread_comments' ) ) {
		wp_enqueue_script( 'comment-reply' );
	}

	//Typed.js options
		$strings = get_theme_mod('typed_strings');
		$strings = str_replace("'", "\\u0027", $strings);

		$typed_options = array(
			'strings' => esc_textarea($strings),
		);			
		wp_localize_script('intro-custom', 'typedText', $typed_options);

}
add_action( 'wp_enqueue_scripts', 'intro_scripts' );

/**
 * Load html5shiv
 */
function intro_html5shiv() {
    echo '<!--[if lt IE 9]>' . "\n";
    echo '<script src="' . esc_url( get_template_directory_uri() . '/js/html5shiv.js' ) . '"></script>' . "\n";
    echo '<![endif]-->' . "\n";
}
add_action( 'wp_head', 'intro_html5shiv' ); 

/**
 * Post classes
 */
function intro_post_class( $classes ) {
	if ( is_home() || is_archive() ) {
		$classes[] = 'large-4 medium-6 columns';
	}
	return $classes;
}
add_filter( 'post_class', 'intro_post_class' );

/**
 * Row style for the page builder
 */
function intro_panels_row_styles($styles) {
	$styles['full'] = __('Full width', 'intro');
	return $styles;
}
add_filter('siteorigin_panels_row_styles', 'intro_panels_row_styles');

/**
 * Implement the Custom Header feature.
 */
require get_template_directory() . '/inc/custom-header.php';

/**
 * Custom template tags for this theme.
 */
require get_template_directory() . '/inc/template-tags.php';

/**
 * Custom functions that act independently of the theme templates.
 */
require get_template_directory() . '/inc/extras.php';

/**
 * Customizer additions.
 */
require get_template_directory() . '/inc/customizer.php';

/**
 * Load Jetpack compatibility file.
 */
require get_template_directory() . '/inc/jetpack.php';

/**
 * Row styles
 */
require get_template_directory() . '/inc/rows.php';

/**
 * Dynamic styles
 */
require get_template_directory() . '/styles.php';

