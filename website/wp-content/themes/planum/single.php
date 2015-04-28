<?php
/**
 * @package Planum
 */

get_header(); ?>

	<header class="headline">

	<h1 class="entry-title"><?php the_title(); ?></h1>

	<?php if ( has_excerpt() ) : ?>
		<?php the_excerpt(); ?>
	<?php endif; //has_excerpt() ?>	

	</header><!-- .entry-header -->

	<div id="content" class="site-content clearfix" style="background: #<?php echo get_theme_mod( 'background_color','FFF' ); ?> url(<?php echo get_theme_mod( 'background_image' ); ?>);">

			<?php while ( have_posts() ) : the_post(); ?>

				<?php get_template_part( 'content', 'single' ); ?>

			<?php endwhile; // end of the loop. ?>

			<?php get_sidebar(); ?>

	</div><!-- #content -->


<?php get_footer(); ?>