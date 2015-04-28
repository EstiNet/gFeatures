<?php
/**
 * ares functions and definitions
 *
 * @package ares
 */
if (!function_exists('ares_setup')) :
    function ares_setup() {
        if (!isset($content_width)) {
            global $content_width;
            $content_width = 1060;
        }

        define('ARES_VERSION', '1.43');
        load_theme_textdomain('ares', get_template_directory() . '/languages');

        // Add default posts and comments RSS feed links to head.
        add_theme_support('automatic-feed-links');
        add_theme_support('post-thumbnails');
        add_theme_support( "title-tag" );
        add_editor_style('');
        /*
         * Enable support for Post Thumbnails on posts and pages.
         *
         * @link http://codex.wordpress.org/Function_Reference/add_theme_support#Post_Thumbnails
         */
        register_nav_menus(array(
            'primary' => __('Primary Menu', 'ares'),
        ));

        // Enable support for Post Formats.
        add_theme_support('post-formats', array('aside', 'image', 'video', 'quote', 'link'));

        // Setup the WordPress core custom background feature.
        add_theme_support('custom-background', apply_filters('ares_custom_background_args', array(
            'default-color' => 'ffffff',
            'default-image' => '',
        )));

        // Enable support for HTML5 markup.
        add_theme_support('html5', array(
            'comment-list',
            'search-form',
            'comment-form',
            'gallery',
            'caption',
        ));
        add_filter('widget_text', 'do_shortcode');
    }
endif; 

// For WP versions older than 4.1 supply a title tag
if ( version_compare( $GLOBALS['wp_version'], '4.1', '<' ) ) :
    /**
     * Filters wp_title to print a neat <title> tag based on what is being viewed.
     *
     * @param string $title Default title text for current view.
     * @param string $sep Optional separator.
     * @return string The filtered title.
     */
    function ares_wp_title( $title, $sep ) {
        if ( is_feed() ) {
            return $title;
        }
        global $page, $paged;
        // Add the blog name
        $title .= get_bloginfo( 'name', 'display' );
        // Add the blog description for the home/front page.
        $site_description = get_bloginfo( 'description', 'display' );
        
        if ( $site_description && ( is_home() || is_front_page() ) ) {
            $title .= " $sep $site_description";
        }
        // Add a page number if necessary:
        if ( ( $paged >= 2 || $page >= 2 ) && ! is_404() ) {
            $title .= " $sep " . sprintf( __( 'Page %s', '_s' ), max( $paged, $page ) );
        }
        return $title;
    }
    add_filter( 'wp_title', 'ares_wp_title', 10, 2 );
    /**
     * Title shim for sites older than WordPress 4.1.
     *
     * @link https://make.wordpress.org/core/2014/10/29/title-tags-in-4-1/
     * @todo Remove this function when WordPress 4.3 is released.
     */
    function ares_render_title() {
        ?>
        <title><?php wp_title( '|', true, 'right' ); ?></title>
        <?php
    }
    add_action( 'wp_head', 'ares_render_title' );
endif;


add_action('after_setup_theme', 'ares_setup');
require get_template_directory() . '/inc/template-tags.php';
require get_template_directory() . '/inc/extras.php';
require get_template_directory() . '/inc/customizer.php';
require get_template_directory() . '/inc/jetpack.php';
define('OPTIONS_FRAMEWORK_DIRECTORY', get_template_directory_uri() . '/inc/');
require_once dirname(__FILE__) . '/inc/options-framework.php';
require_once dirname(__FILE__) . '/inc/engine/tgm.php';
require_once dirname(__FILE__) . '/inc/engine/avenue.php';
