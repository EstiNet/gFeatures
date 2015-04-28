<?php
/**
 * The sidebars containing at the homepage.
 *
 * @package klean
 */
 
 if(! is_active_sidebar('sidebar-3')) {
	 return;
 } ?>
 
 <div id="secondary" class="widget-area right-sidebar col-lg-3 col-md-3 col-sm-6 col-xs-12" role="complementary">
	<?php dynamic_sidebar( 'sidebar-3' ); ?>
</div><!-- #secondary -->