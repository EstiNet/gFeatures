<?php
/**
 * The Header for our theme.
 *
 * Displays all of the <head> section and everything up till <div id="content">
 *
 * @package Honma
 */
?>
<!DOCTYPE html>
<html <?php language_attributes(); ?>>
<head>
<meta charset="<?php bloginfo( 'charset' ); ?>" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<title><?php wp_title( '|', true, 'right' ); ?></title>
<link rel="pingback" href="<?php bloginfo('pingback_url'); ?>">
<link rel="stylesheet" type="text/css" media="all" href="<?php echo get_stylesheet_uri(); ?>" />
<?php wp_head(); ?>
</head>
<body <?php body_class(); ?>>
	<div id="wrapper">
		<div class="header_container" <?php if ( of_get_option('header_image') ) { ?> style="background-image: url('<?php echo esc_url(of_get_option('header_image')); ?>');" <?php } ?>>
			<div class="header_block">
				<header id="header" class="container clearfix">
					<?php if ( of_get_option('logo_image') ) { ?>
					   <a class="logo" href="<?php echo esc_url(home_url('/')); ?>"><img src="<?php echo esc_url(of_get_option('logo_image')); ?>" /></a>
					<?php } else if (of_get_option('header_logo_text1')){  ?>
					    <a class="logo" href="<?php echo esc_url(home_url('/')); ?>"><?php echo esc_html(of_get_option('header_logo_text1')); ?> <span><?php echo esc_html(of_get_option('header_logo_text2')); ?></span></a>
					<?php } else {  ?>
						<a class="logo" href="<?php echo esc_url(home_url('/')); ?>"><?php bloginfo('name'); ?></a>
					<?php } ?>					
					<nav class="menu_top_container">
						<a class="icon_menu" href="#"><?php _e( 'Menu', 'honma' ); ?></a>
						<?php if ( has_nav_menu( 'main' ) ) { ?>
						   <?php wp_nav_menu( array('container'=> '', 'theme_location' => 'main', 'items_wrap'  => '<ul class="menu_top">%3$s</ul>'  ) ); ?>
						<?php } else { ?>
							<?php wp_nav_menu(  array( 'menu_class'  => 'menu_top') ); ?>	
						<?php } ?>
						<?php if ( has_nav_menu( 'main' ) ) { ?>
						   <?php wp_nav_menu( array('container'=> '', 'theme_location' => 'main', 'items_wrap'  => '<ul class="menu_top_mobile">%3$s</ul>'  ) ); ?>
						<?php } else { ?>
							<?php wp_nav_menu(  array( 'menu_class'  => 'menu_top_mobile' ) ); ?>	
						<?php } ?>						
					</nav>
				</header>
			</div>
			<?php if(is_front_page()) { ?>
			<div class="page_title">
				<div class="container">
					<div class="welcome_banner">
						<h1>
						<?php if(of_get_option('top_title1')) { ?> <span> <?php  echo esc_html(of_get_option('top_title1')); ?> </span> <?php } ?> 
						<?php if(of_get_option('top_title2')) {  echo esc_html(of_get_option('top_title2')); } ?>
						</h1>
						<?php if(of_get_option('top_subtitle')) { ?> <p><?php  echo esc_html(of_get_option('top_subtitle')); ?></p> <?php } ?>
					</div>
				</div>
			</div>
			<?php } ?>
		</div>