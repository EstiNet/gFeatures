<?php
/**
 * @package Planum
 */
?>
	<div id="sidebar" class="content-left widget-area" role="complementary">	

		<?php do_action( 'before_sidebar' ); ?>

		<?php if ( ! dynamic_sidebar( 'sidebar-page' ) ) : ?>

			<p><?php _e( 'Pages and posts have different sidebar.', 'planum' ) ?></p>

		<?php endif; // ! dynamic_sidebar ?>

	</div><!-- #sidebar -->