<?php
/**
 * The template part for displaying a message that posts cannot be found.
 *
 * Learn more: http://codex.wordpress.org/Template_Hierarchy
 *
 * @package ares
 */
?>

<div class="page-title">
	<h1 class="row center"><?php _e( 'Nothing Found', 'ares' ); ?></h1>
</div><!-- .page-title -->

<div class="row">
	<div class="page-content col-md-12">
		<div class="col-md-9">
			<?php if ( is_home() && current_user_can( 'publish_posts' ) ) : ?>
		
				<p><?php printf( __( 'Ready to publish your first post? <a href="%1$s">Get started here</a>.', 'ares' ), esc_url( admin_url( 'post-new.php' ) ) ); ?></p>
		
			<?php elseif ( is_search() ) : ?>
		
				<p><?php _e( 'Sorry, but nothing matched your search terms. Please try again with some different keywords.', 'ares' ); ?></p>
				<?php get_search_form(); ?>
		
			<?php else : ?>
		
				<p><?php _e( 'It seems we can&rsquo;t find what you&rsquo;re looking for. Perhaps searching can help.', 'ares' ); ?></p>
				<?php get_search_form(); ?>
		
			<?php endif; ?>
		</div>
		<div class="col-md-3">
        	<?php get_sidebar(); ?>
		</div>
	</div><!-- .page-content -->
</div><!-- .row -->