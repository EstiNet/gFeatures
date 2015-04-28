<?php
/**
 * The header for our theme.
 *
 * Displays all of the <head> section and everything up till <div id="content">
 *
 * @package Intro
 */
?><!DOCTYPE html>
<html <?php language_attributes(); ?>>
<head>
<meta charset="<?php bloginfo( 'charset' ); ?>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><?php wp_title( '|', true, 'right' ); ?></title>
<link rel="profile" href="http://gmpg.org/xfn/11">
<link rel="pingback" href="<?php bloginfo( 'pingback_url' ); ?>">
<?php if ( get_theme_mod('site_favicon') ) : ?>
	<link rel="shortcut icon" href="<?php echo esc_url(get_theme_mod('site_favicon')); ?>" />
<?php endif; ?>

<?php if ( get_theme_mod('apple_touch_144') ) : ?>
	<link rel="apple-touch-icon" sizes="144x144" href="<?php echo esc_url(get_theme_mod('apple_touch_144')); ?>" />
<?php endif; ?>
<?php if ( get_theme_mod('apple_touch_114') ) : ?>
	<link rel="apple-touch-icon" sizes="114x114" href="<?php echo esc_url(get_theme_mod('apple_touch_114')); ?>" />
<?php endif; ?>
<?php if ( get_theme_mod('apple_touch_72') ) : ?>
	<link rel="apple-touch-icon" sizes="72x72" href="<?php echo esc_url(get_theme_mod('apple_touch_72')); ?>" />
<?php endif; ?>
<?php if ( get_theme_mod('apple_touch_57') ) : ?>
	<link rel="apple-touch-icon" href="<?php echo esc_url(get_theme_mod('apple_touch_57')); ?>" />
<?php endif; ?>

<?php wp_head(); ?>
</head>

<body id="top" <?php body_class(); ?>>

	<!-- Preloader -->
	<div class="preloader">
		<div class="spinner">
			<div class="rect1"></div>
			<div class="rect2"></div>
			<div class="rect3"></div>
			<div class="rect4"></div>
			<div class="rect5"></div>
		</div>
	</div>

	<a class="skip-link screen-reader-text" href="#content"><?php _e( 'Skip to content', 'intro' ); ?></a>

	<a href="#" class="sidebar-btn cross"></a>
	<?php get_sidebar(); ?>

	<header class="header-fixed">
		<div class="site-branding">
			<?php if ( get_theme_mod('site_logo') ) : ?>
				<a href="<?php echo esc_url( home_url( '/' ) ); ?>" title="<?php echo esc_attr( get_bloginfo( 'name', 'display' ) ); ?>"><img class="site-logo" src="<?php echo esc_url(get_theme_mod('site_logo')); ?>" alt="<?php echo esc_attr( get_bloginfo( 'name', 'display' ) ); ?>" /></a>
			<?php else : ?>			
				<h1 class="site-title logo"><a href="<?php echo esc_url( home_url( '/' ) ); ?>" rel="home"><?php echo esc_html( get_bloginfo( 'name', 'display' ) ); ?></a></h1>
				<h2 class="site-description"><?php echo esc_html(bloginfo( 'description' )); ?></h2>
			<?php endif; ?>
		</div>
	</header>

	<?php if ( get_header_image() ) : ?>
		<?php if ( is_front_page() || (get_theme_mod('header_active') != 1 && !is_front_page()) ) : ?>
			<div id="header-banner" class="parallax" data-parallax="scroll"> 
				<div class="header-container">
					<?php if (get_theme_mod('typed_title') || get_theme_mod('typed_strings')) : //Animated text ?>
						<h1><?php echo esc_html(get_theme_mod('typed_title')); ?> <span class="type"></span></h1>
					<?php endif; ?>
					<?php if (get_theme_mod('typed_message')) : //Header message ?>
						<h4><?php echo esc_html(get_theme_mod('typed_message')); ?></h4>
					<?php endif; ?>
					<?php //Buttons
				    	if ( get_theme_mod('header_btn_link_1') ) {
					    	echo '<a class="button light" href="' . esc_url(get_theme_mod('header_btn_link_1')) . '">' . esc_html(get_theme_mod('header_btn_text_1')) . '</a>';
						}
				    	if ( get_theme_mod('header_btn_link_2') ) {
					    	echo '<a class="button" href="' . esc_url(get_theme_mod('header_btn_link_2')) . '">' . esc_html(get_theme_mod('header_btn_text_2')) . '</a>';
						}
					?>
				</div>
			</div>
		<?php endif; ?>		
	<?php endif; ?>	

	<section id="content" class="site-content">
		<div class="row">