<?php
/**
 * The sidebar containing the main widget area.
 *
 * @package klean
 */

if ( ! is_active_sidebar( 'sidebar-1' ) ) {
	return;
}
?>

<div id="secondary" class="widget-area col-lg-4 col-md-4 col-sm-12 col-xs-12" role="complementary">
	<?php dynamic_sidebar( 'sidebar-1' ); ?>
</div><!-- #secondary -->
