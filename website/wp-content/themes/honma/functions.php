<?php
/**
 * Honma functions and definitions
 *
 * @package Honma
 */
 
if ( !function_exists( 'optionsframework_init' ) ) {
	define( 'OPTIONS_FRAMEWORK_DIRECTORY', esc_url(get_template_directory_uri() . '/inc/') );
	require( get_template_directory() . '/inc/options-framework.php' );
}
if ( ! function_exists( 'honma_setup' ) ) :
function honma_setup() {
    global $content_width;
	if ( ! isset( $content_width ) ) { $content_width = 1000; }
	load_theme_textdomain( 'honma', get_template_directory() . '/languages' );
	register_nav_menu( 'main', __( 'Main Menu', "honma" ) );
	add_theme_support( 'automatic-feed-links' );
	add_theme_support( 'post-thumbnails' );	
	add_theme_support( 'custom-background' );	
	$custom_header_support = array(
		'default-text-color' => '000',
		'flex-height' => true,
	);
	set_post_thumbnail_size( 150, 150, true );
	add_image_size( 'news-honma', 200, 200, true );
	add_image_size( 'large-feature-honma', 600, 480, true );
	add_image_size( 'small-feature-honma', 500, 300 );

}
endif; 
add_action( 'after_setup_theme', 'honma_setup' );


if ( ! function_exists( 'honma_of_register_js' ) ) :
function honma_of_register_js() {
	wp_enqueue_script('main-honma', esc_url(get_template_directory_uri() . '/js/main.js'), array('jquery'),'1.0', true);
	if ( is_singular() && comments_open() && get_option( 'thread_comments' ) ) {
		wp_enqueue_script( 'comment-reply' );
	}
}
endif; 
add_action('wp_enqueue_scripts', 'honma_of_register_js');

function honma_ie_support_header() {
    echo '<!--[if lt IE 9]>'. "\n";
    echo '<script src="' . esc_url( get_template_directory_uri() . '/js/html5.js' ) . '"></script>'. "\n";
    echo '<![endif]-->'. "\n";
}
add_action( 'wp_head', 'honma_ie_support_header', 1 );

if ( ! function_exists( 'honma_widgets_init' ) ) :
function honma_widgets_init() {
	register_sidebar(array(
		'name' => __( 'Sidebar Widget Area', "honma"),
		'id' => 'sidebar-widget-area',
		'description' => __( 'The sidebar widget area', "honma"),
		'before_widget' => '<aside id="%1$s" class="widget %2$s"> ', 
		'after_widget' => '</aside>',
		'before_title' => '<h3 class="widget-title">',
		'after_title' => '</h3><hr>',
	));		
	register_sidebar(array(
		'name' => __( 'Footer Widget Area 1', "honma"),
		'id' => 'footer-widget-area-1',
		'description' => __( 'The footer widget area 1', "honma"),
		'before_widget' => '<aside id="%1$s" class="widget %2$s"> ',
		'after_widget' => '</aside>',
		'before_title' => '<h3 class="widget-title">',
		'after_title' => '</h3>'
	));	
	register_sidebar(array(
		'name' => __( 'Footer Widget Area 2', "honma"),
		'id' => 'footer-widget-area-2',
		'description' => __( 'The footer widget area 2', "honma"),
		'before_widget' => '<aside id="%1$s" class="widget %2$s"> ',
		'after_widget' => '</aside>',
		'before_title' => '<h3 class="widget-title">',
		'after_title' => '</h3>'
	));	
	register_sidebar(array(
		'name' => __( 'Footer Widget Area 3', "honma"),
		'id' => 'footer-widget-area-3',
		'description' => __( 'The footer widget area 3', "honma"),
		'before_widget' => '<aside id="%1$s" class="widget %2$s"> ',
		'after_widget' => '</aside>',
		'before_title' => '<h3 class="widget-title">',
		'after_title' => '</h3>'
	));	
	register_sidebar(array(
		'name' => __( 'Footer Widget Area 4', "honma"),
		'id' => 'footer-widget-area-4',
		'description' => __( 'The footer widget area 4', "honma"),
		'before_widget' => '<aside id="%1$s" class="widget %2$s"> ',
		'after_widget' => '</aside>',
		'before_title' => '<h3 class="widget-title">',
		'after_title' => '</h3>'
	));		
}
endif;
add_action( 'widgets_init', 'honma_widgets_init' );

if ( ! function_exists( 'honma_head_css' ) ) :
function honma_head_css() {
        $meta = '';
		
		$fav_icon = of_get_option('fav_icon');
		if ($fav_icon <> '') {
			$meta .= "<link rel=\"shortcut icon\" href=\"".esc_url($fav_icon)."\" type=\"image/x-icon\" />\n";
		}
		$web_clip = of_get_option('web_clip');
		if ($web_clip <> '') {
			$meta .= "<link rel=\"apple-touch-icon-precomposed\" href=\"".esc_url($web_clip)."\" />\n";
		}		

		if ($meta <> '') {
			echo $meta;
		}														
}
endif;
add_action('wp_head', 'honma_head_css');

function honma_wp_title( $title, $sep ) {
	global $paged, $page;

	if ( is_feed() ) {
		return $title;
	}
	
	$title .= get_bloginfo( 'name', 'display' );

	$site_description = get_bloginfo( 'description', 'display' );
	if ( $site_description && ( is_home() || is_front_page() ) ) {
		$title = "$title $sep $site_description";
	}

	if ( $paged >= 2 || $page >= 2 ) {
		$title = "$title $sep " . sprintf( __( 'Page %s', 'honma' ), max( $paged, $page ) );
	}

	return $title;
}
add_filter( 'wp_title', 'honma_wp_title', 10, 2 );

if ( ! function_exists( 'honma_get_list_posts' ) ) :
function honma_get_list_posts($n) {
    global $wp_query;
	$paged = (get_query_var('paged')) ? get_query_var('paged') : 1; 
    $args = array(
        'post_type' => 'post',
        'orderby' => 'date',
		'order' => 'DESC',
		'posts_per_page' => $n
    );
	$wp_query->query( $args );
    return new WP_Query( $args );
}
endif; 

if ( ! function_exists( 'honma_paginate_page' ) ) :
function honma_paginate_page() {
	wp_link_pages( array( 'before' => '<div class="pagination">', 'after' => '</div><div class="clear"></div>', 'link_before' => '<span class="current_pag">','link_after' => '</span>' ) );
}
endif; 

if ( ! function_exists( 'honma_credits' ) ) :
function honma_credits() {
	$text = __('Theme created by <a href="'.esc_url('http://www.pwtthemes.com/theme/honma-free-responsive-wordpress-theme').'">PWT</a>. Powered by <a href="'.esc_url('http://wordpress.org/').'">WordPress.org</a>', 'honma');
	echo apply_filters( 'honma_credits_text', $text) ;
}
endif; 
add_action( 'honma_display_credits', 'honma_credits' );
?>