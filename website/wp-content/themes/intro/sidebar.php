<?php
/**
 * The sidebar containing the main widget area.
 *
 * @package Intro
 */
?>

<aside id="sidebar" class="hidden">	

	<div class="widget">
		<nav class="sidebar-nav" role="navigation">
			<?php wp_nav_menu( array( 'theme_location' => 'primary' ) ); ?>
		</nav>
	</div><!--.widget-->

	<?php 
		if (is_active_sidebar( 'sidebar-1' )) {
			dynamic_sidebar( 'sidebar-1' );
		}
	?>

</aside><!--#sidebar-->