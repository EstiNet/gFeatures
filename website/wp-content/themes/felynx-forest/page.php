<?php
/**
 * The template for displaying wordpress pages
 *
 * @package Felynx_Forest
 * @since Felynx Forest 1.0
 */

get_header(); ?>

<main id="main" role="main">
	<?php
		while ( have_posts() ) :
			the_post();
			get_template_part( 'content' );
		endwhile;
	?>
</main>

<?php get_footer(); ?>