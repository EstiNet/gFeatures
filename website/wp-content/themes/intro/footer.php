<?php
/**
 * The template for displaying the footer.
 *
 * Contains the closing of the #content div and all content after
 *
 * @package Intro
 */
?>

	</div>
	</section><!-- #content -->

	<footer id="footer">
		<div class="row">
			<div class="large-12 columns text-center">

			<?php if ( has_nav_menu( 'social' ) ) : ?>
				<nav class="share-social">
					<?php wp_nav_menu( array( 'theme_location' => 'social', 'link_before' => '<span class="screen-reader-text">', 'link_after' => '</span>', 'menu_class' => 'menu clearfix', 'fallback_cb' => false ) ); ?>
				</nav>
			<?php endif; ?>
				
			<div>
			<a href="<?php echo esc_url( __( 'http://wordpress.org/', 'intro' ) ); ?>"><?php printf( __( 'Proudly powered by %s', 'intro' ), 'WordPress' ); ?></a>
			<span class="sep"> | </span>
			<?php printf( __( 'Theme: %2$s by %1$s.', 'intro' ), 'aThemes', '<a href="http://athemes.com/theme/intro" rel="designer">Intro</a>' ); ?>
			</div>

			</div>
			<a data-scroll href="top" class="to-top"><i class="fa fa-chevron-up"></i></a>
		</div>
	</footer>

<?php wp_footer(); ?>

</body>
</html>