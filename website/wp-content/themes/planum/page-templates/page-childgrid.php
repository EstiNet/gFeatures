<?php
/**
 * Template Name: Child Grid
 *
 * @package Planum
 */

get_header(); ?>

	<div id="content" class="site-content clearfix"  style="background: #<?php echo get_theme_mod( 'background_color','FFF' ); ?> url(<?php echo get_theme_mod( 'background_image' ); ?>);">

		<div class="content-full tagline" role="main" style="background: <?php echo get_theme_mod( 'planum_main_color' ); ?> url(<?php $thumbnail = wp_get_attachment_image_src( get_post_thumbnail_id(), 'planum-featured' ); echo $thumbnail[0]; ?>) no-repeat; background-position: 60% 50%; background-size: cover;">

			<?php while ( have_posts() ) : the_post(); ?>

				<?php get_template_part( 'content', 'page' ); ?>

			<?php endwhile; // end of the loop. ?>

		</div><!-- .content-full -->

<!-- ChildGrid -->
	<?php
		$child_pages = new WP_Query( array(
			'post_type'      => 'page',
			'orderby'        => 'menu_order',
			'order'          => 'ASC',
			'post_parent'    => $post->ID,
			'posts_per_page' => 999,
			'no_found_rows'  => true,
		) );
	?>

	<?php if ( $child_pages->have_posts() ) : ?>

<div class="grid2 childpage">
				<?php while ( $child_pages->have_posts() ) : $child_pages->the_post(); ?>

					<div class="col">
						<?php get_template_part( 'content', 'childpage' ); ?>
					</div>

				<?php endwhile; ?>
</div>

	<?php
		endif;
		wp_reset_postdata();
	?>
<!-- ChildGrid -->

	</div><!-- #content -->

<?php get_footer(); ?>
