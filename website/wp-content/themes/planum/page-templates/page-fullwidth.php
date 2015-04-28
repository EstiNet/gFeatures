<?php
/**
 * Template Name: Full Width
 *
 * @package Planum
 */

get_header(); ?>

	<div id="content" class="site-content clearfix" style="background: #<?php echo get_theme_mod( 'background_color','FFF' ); ?> url(<?php echo get_theme_mod( 'background_image' ); ?>);">

	<?php if ( has_post_thumbnail() ) {
		the_post_thumbnail( 'planum-featured' );
	} ?>

	<?php if ( has_excerpt() ) : ?>
		<div class="topexcerpt"><?php the_excerpt(); ?></div>
	<?php endif; //has_excerpt() ?>	

		<div class="content-full" role="main">

			<?php while ( have_posts() ) : the_post(); ?>

				<?php get_template_part( 'content', 'page' ); ?>

			<?php endwhile; // end of the loop. ?>

		</div><!-- .content-full -->

	</div><!-- #content -->

<?php get_footer(); ?>
