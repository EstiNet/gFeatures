<?php
/**
 * @package Planum
 */
$options = get_option('planum_theme_settings'); 
?>
<!DOCTYPE html>
<html <?php language_attributes(); ?>>
<head>
<meta charset="<?php bloginfo( 'charset' ); ?>">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="profile" href="http://gmpg.org/xfn/11">
<link rel="pingback" href="<?php bloginfo( 'pingback_url' ); ?>">

<!--[if lt IE 9]>
<script src="<?php echo get_template_directory_uri(); ?>/js/html5.js" type="text/javascript"></script>
<![endif]-->

<?php wp_head(); ?>

</head>

<body <?php body_class(); ?>>
<div id="page" class="hfeed site">

	<?php do_action( 'before' ); ?>

<header id="masthead" class="site-header clearfix" role="banner">

		<div class="site-branding">

<?php $logo = get_theme_mod( 'logo_upload' );
	if ( !empty($logo) ) : ?>

<?php if ( !is_front_page() ) : ?>
	<a href="<?php echo esc_url( home_url( '/' ) ); ?>" rel="home">
	<img src="<?php echo esc_url( get_theme_mod( 'logo_upload' ) ); ?>" alt="<?php esc_attr( bloginfo( 'name' ) ); ?>" class="logo alignleft" />
	</a>
<?php else : ?>
	<img src="<?php echo get_theme_mod( 'logo_upload' ); ?>" alt="<?php bloginfo( 'name' ); ?>" class="logo alignleft" />
<?php endif; //!is_front_page() ?>

	<?php endif; //!empty ?>

<div id="header-title">
	<h1 class="site-title"><a href="<?php echo esc_url( home_url( '/' ) ); ?>" rel="home"><?php bloginfo( 'name' ); ?></a></h1>
                <h2 class="site-description"><?php bloginfo( 'description' ); ?></h2>
	
</div><!--header-title-->

		</div><!--.site-branding-->

		<div class="site-menu">
	<nav id="site-navigation" class="navigation-main" role="navigation">
		<?php wp_nav_menu( array( 'theme_location' => 'primary', 'depth' => 4 ) ); ?>
		<a href="#" class="toggle-top"></a>
	</nav><!-- #site-navigation -->
		</div><!--site-menu-->


</header><!-- #masthead -->

<div class="top-wrapper clearfix">
	<div class="top-left">
<?php if ( ! dynamic_sidebar( 'top-left' ) ) : ?>
		<?php get_search_form(); ?>
<?php endif; // ! dynamic_sidebar ?>
	</div>
	<div class="top-right">
<?php if ( ! dynamic_sidebar( 'top-right' ) ) : ?>
<?php if ( has_nav_menu( 'top' ) ) {
	wp_nav_menu( array( 'theme_location' => 'top', 'menu_class' => 'top-menu', 'depth' => 1 ) );
} ?>
<?php endif; // ! dynamic_sidebar ?>
	</div>
</div><!--.top-wrapper-->

	<div id="main" class="site-main clearfix">

<div class="backstretch" style="background: <?php echo get_theme_mod( 'planum_main_color', '#2e3138' ); ?> url(<?php $thumbnail = wp_get_attachment_image_src( get_post_thumbnail_id(), 'planum-featured' );  if( !empty($thumbnail) && !is_home() && !is_archive() && !is_search() ) { echo $thumbnail[0]; }else{ $home_image = get_header_image(); echo esc_url( $home_image ); }?>) no-repeat; background-size: cover; background-position:50%;">
<div class="trans" style="width: 100%; height: 100%;background: <?php echo get_theme_mod( 'planum_main_color', '#2e3138' ); ?>;">&nbsp;</div>
</div><!--.backstretch-->