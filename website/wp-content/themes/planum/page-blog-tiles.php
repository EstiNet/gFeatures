<?php
/**
 * Template Name: Blog Tiles
 *
 * @package Planum
 */

get_header(); ?>

	<div id="content" class="site-content planums-grid clearfix" role="main" style="background: #<?php echo get_theme_mod( 'background_color','FFF' ); ?> url(<?php echo get_theme_mod( 'background_image' ); ?>);">

		<?php
		$args = array(
			'post_type' => 'post',
			'post__not_in' => get_option('sticky_posts'),
			'post_status' => 'publish',
			'posts_per_page' => get_option('posts_per_page'),
			'paged' => get_query_var('paged'),
		);

		$wp_query = new WP_Query( $args ); ?>

		<?php get_template_part( 'content', 'blog-tiles' ); ?>

	</div><!-- #content -->

<?php
	planum_content_nav( 'nav-below' );
?>

<?php get_footer(); ?>