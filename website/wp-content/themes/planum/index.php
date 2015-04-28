<?php
/**
 * @package Planum
 */
get_header(); ?>

<!-- Heading Tagline -->
		<?php $home_image = get_header_image(); ?>
<div id="home-tagline" style="background: <?php echo get_theme_mod( 'home_tagline_bgcolor', '#2E3138' ); ?><?php if( !empty($home_image) ) { ?> url(<?php echo esc_url( $home_image );?>); background-position: 50% 50%; background-size:100%<?php } ?>;">
	<div class="tagline-txt">
		<?php echo get_theme_mod( 'home_tagline', '<h1>Planum Free</h1>' ); ?>
	</div>
</div><!--#home-tagline-->

		<div id="planum-scroll">

	<div id="content" class="site-content clearfix" role="main" style="background: #<?php echo get_theme_mod( 'background_color','FFF' ); ?> url(<?php echo get_theme_mod( 'background_image' ); ?>);">

		<?php
		$sticky_posts = get_option('sticky_posts');

			if ( !empty( $sticky_posts ) ) :
			$args = array(
			    'post__in' => get_option('sticky_posts'),
				'post_status' => 'publish'
			);

			$sticky_query = new WP_Query( $args ); ?>

		<?php if ( $sticky_query->have_posts() ) : ?>

			<div class="sticky-posts clearfix">
				<?php while ( $sticky_query->have_posts() ) : $sticky_query->the_post(); ?>

					<?php get_template_part( 'content', 'sticky' ); ?>

				<?php endwhile; wp_reset_postdata(); ?>
			</div><!-- .sticky-posts -->

		<?php endif; ?>

			<?php endif; //!empty ?>

		<?php

		$args = array(
		    'posts_per_page' => get_option('posts_per_page'),
		    'paged' => get_query_var('paged'),
		    'post__not_in' => get_option('sticky_posts'),
		    'post_status' => 'publish'
		);

		$wp_query = new WP_Query( $args ); ?>

		<?php get_template_part( 'content', 'blog-tiles' ); ?>

	</div><!-- #content -->

		</div><!-- #planum-scroll -->

<?php
	if ( class_exists( 'Jetpack' ) && ! Jetpack::is_module_active( 'infinite-scroll' ) ) {
planum_content_nav( 'nav-below' );
	}
?>

<?php get_footer(); ?>