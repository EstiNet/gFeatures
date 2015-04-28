<?php
/**
 * @package Planum
 */
?>
	</div><!-- #main -->

	<footer id="colophon" class="site-footer clearfix" role="contentinfo">
		
	<div class="grid3 clearfix">
<div class="col"><?php dynamic_sidebar('footer1'); ?></div>
<div class="col"><?php dynamic_sidebar('footer2'); ?></div>
<div class="col"><?php dynamic_sidebar('footer3'); ?></div>
	</div><!-- .grid3 -->

	<?php if ( has_nav_menu( 'social' ) ) { ?>
<div id="socialicons">
<?php
wp_nav_menu(
	array(
	'theme_location'  => 'social',
	'menu_id'         => 'menu-social',
	'depth'           => 1,
	'link_before'     => '<span class="screen-reader-text">',
	'link_after'      => '</span>',
	'fallback_cb'     => '',
	)
); ?>
</div><!--#socialicons-->
	<?php } // has_nav_menu( 'social' ) ?>

		<div class="site-info">
<?php echo '&copy; '.date('Y').' &middot; '; ?><span id="copyright-message"><?php echo get_theme_mod( 'planum_footer_copyright_text', 'All Rights Reserved' ); ?></span>
<?php do_action( 'planum_credits' ); ?>
		</div><!-- .site-info -->

	</footer><!-- #colophon -->
</div><!-- #page -->

<?php wp_footer(); ?>
</body>
</html>