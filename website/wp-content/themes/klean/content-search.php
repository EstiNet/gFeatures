<?php
/**
 * The template part for displaying results in search pages.
 *
 * Learn more: http://codex.wordpress.org/Template_Hierarchy
 *
 * @package klean
 */
?>

<article id="post-<?php the_ID(); ?>" <?php post_class('search-entry'); ?>>
	<header class="entry-header">
		<?php the_title( sprintf( '<h1 class="entry-title col-lg-9 col-md-9 col-sm-12 col-xs-12"><a href="%s" rel="bookmark">', esc_url( get_permalink() ) ), '</a></h1>' ); ?>

		<?php if ( 'post' == get_post_type() ) : ?>
		<div class="entry-meta col-lg-3 col-md-3 col-sm-12 col-xs-12">
			<?php klean_posted_on(); ?>
		</div><!-- .entry-meta -->
		<?php endif; ?>
	</header><!-- .entry-header -->

	<div class="entry-summary">
		<?php the_excerpt(); ?>
	</div><!-- .entry-summary -->

	<footer class="entry-footer">
		<?php klean_entry_footer(); ?>
	</footer><!-- .entry-footer -->
</article><!-- #post-## -->
