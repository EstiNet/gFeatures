<?php
/**
 * The sidebars containing at the homepage.
 *
 * @package klean
 */
 
 if(! is_active_sidebar('sidebar-2') ) {
	 return;
 } ?>
 
 <div id="secondary" class="widget-area left-sidebar col-lg-3 col-md-3 col-sm-6 col-xs-12" role="complementary">
	<?php dynamic_sidebar( 'sidebar-2' ); ?>
</div><!-- #secondary -->