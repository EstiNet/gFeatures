<?php
/**
 * Felynx Forest functions and definitions
 *
 * @package Felynx_Forest
 * @since Felynx Forest 1.0
 */

if ( ! isset( $content_width ) ) {
	$content_width = 800; // size of .container
}

function felynxforest_setup() {
	// Text domain
	load_theme_textdomain( 'felynxforest', get_template_directory() . '/languages' );

	// Theme support
	add_theme_support( 'title-tag' );
	add_theme_support( 'automatic-feed-links' );
	add_theme_support( 'html5', array( 'comment-list', 'comment-form', 'search-form', 'gallery', 'caption' ) );
	add_theme_support( 'post-thumbnails' );

	// Editor style
	add_editor_style( 'css/custom-editor-style.css' );

	// Menus
	register_nav_menu( 'primary', __( 'Primary menu', 'felynxforest' ) );
	register_nav_menu( 'social', __( 'Social icons', 'felynxforest' ) );
}
add_action( 'after_setup_theme', 'felynxforest_setup' );

function felynxforest_scripts() {
	wp_enqueue_script(
		'main',
		get_template_directory_uri() . '/js/main.js',
		array( 'jquery' ), '0.6', true
	);

	if ( is_singular() && comments_open() && get_option( 'thread_comments' ) ) {
		wp_enqueue_script( 'comment-reply' );
	}

	$color_scheme = get_theme_mod( 'color_scheme' );
	if ( empty ( $color_scheme ) ) {
		$color_scheme = 'green';
	}
	wp_register_style( 'style', get_template_directory_uri() . '/css/' . $color_scheme . '.css', array(), wp_get_theme()->get( 'Version' ) );
	wp_enqueue_style( 'style' );
}
add_action( 'wp_enqueue_scripts', 'felynxforest_scripts');

function felynxforest_hack_title( $title )
{
	if( empty( $title ) ) {
		return get_bloginfo( 'name' ) . ' &#183; ' . get_bloginfo( 'description' );
	}
	return $title;
}
add_filter( 'wp_title', 'felynxforest_hack_title' );

function felynxforest_excerpt_length( $length ) {
	return 20;
}
add_filter( 'excerpt_length', 'felynxforest_excerpt_length', 999 );

function felynxforest_excerpt_more( $more ) {
	return '&hellip;';
}
add_filter( 'excerpt_more', 'felynxforest_excerpt_more' );

function felynxforest_widgets_init() {
	register_sidebar( array(
		'name'			=> __( 'Footer widget area', 'felynxforest' ),
		'id'			=> 'sidebar-footer',
		'description'	=> __( 'Add widgets here to appear in your footer.', 'felynxforest' ),
		'before_widget'	=> '<section id="%1$s" class="widget %2$s">',
		'after_widget'	=> '</section>',
		'before_title'	=> '<h2 class="widget-title">',
		'after_title'	=> '</h2>',
	) );

	register_sidebar( array(
		'name'			=> __( 'Author widget area', 'felynxforest' ),
		'id'			=> 'sidebar-author',
		'description'	=> __( 'Add widgets here to appear below the author avatar and name.', 'felynxforest' ),
		'before_widget'	=> '<section id="%1$s" class="widget %2$s">',
		'after_widget'	=> '</section>',
		'before_title'	=> '<h2 class="widget-title">',
		'after_title'	=> '</h2>',
	) );
}
add_action( 'widgets_init', 'felynxforest_widgets_init' );

require get_template_directory() . '/inc/customizer.php';
require get_template_directory() . '/inc/walker.php';

?>