<?php
/**
 * The header for our theme.
 *
 * Displays all of the <head> section and everything up till <div id="content">
 *
 * @package klean
 */
?><!DOCTYPE html>
<html <?php language_attributes(); ?>>
<head>
<meta charset="<?php bloginfo( 'charset' ); ?>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="profile" href="http://gmpg.org/xfn/11">
<link rel="pingback" href="<?php bloginfo( 'pingback_url' ); ?>">

<?php wp_head(); ?>
</head>

<body <?php body_class(); ?>>
	<div id="header-wrapper">
	<header id="masthead" class="site-header" role="banner">
	<nav id="site-navigation" class="main-navigation" role="navigation">
			<button class="menu-toggle" aria-controls="menu" aria-expanded="false"><?php _e( 'Primary Menu', 'klean' ); ?></button>
			<?php wp_nav_menu( array( 'theme_location' => 'primary' ) ); ?>
		</nav><!-- #site-navigation -->

		<div class="site-branding container">
			<?php if (get_theme_mod("logo")) { ?>
			<div id = "logo">
				<a href="<?php echo esc_url(home_url('/')); ?>"><img src ="<?php echo esc_url(get_theme_mod('logo')); ?>"></a>
				</div>
			<?php } 
				else {
			?>
			<h1 class="site-title"><a href="<?php echo esc_url( home_url( '/' ) ); ?>" rel="home"><?php bloginfo( 'name' ); ?></a></h1>
			<div class = "site-description-wrapper">
			<h2 class="site-description"><?php bloginfo( 'description' ); ?></h2>
			</div>
			<?php } ?>
		</div><!-- .site-branding -->
	</header><!-- #masthead -->
	<div class = "header-image">
			</div>
			
			<div id = "search-top">
	<form method="get" id="searchform" action="<?php echo home_url(); ?>/">
	<div><input type="text" size="18" value="" name="s" id="s" />
	<button type="submit" class="search-submit">
	<img src = "<?php echo get_template_directory_uri() . '/images/search.png'?>" width="17px" height="17px">
	</button>
	</div>
</form>
	</div>
	<?php 
		if (get_theme_mod('social')) :
		get_template_part('social');
		endif;
	?>


	</div>

<div id="page" class="hfeed site container">
		<a class="skip-link screen-reader-text" href="#content"><?php _e( 'Skip to content', 'klean' ); ?></a>

	<div id="content" class="site-content container">
