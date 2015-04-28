<?php
/**
 * @package Planum
 */
?><!DOCTYPE html>
<html <?php language_attributes(); ?>>
<head>
<meta charset="<?php bloginfo( 'charset' ); ?>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<?php if( !empty($options['file_icon']) ) : ?>
<link rel="icon" type="image/png" href="<?php echo $options['file_icon']; ?>" />
<?php else : ?>
<link rel="icon" type="image/png" href="<?php echo get_template_directory_uri(); ?>/img/favicon.png" />
<?php endif; //!favicon() ?>
<title>
<?php wp_title( '|', true, 'right' ); ?>
</title>

<!--[if lt IE 9]>
<script src="<?php echo get_template_directory_uri(); ?>/js/html5.js" type="text/javascript"></script>
<![endif]-->

<?php wp_head(); ?>

</head>

<body <?php body_class(); ?>>
<div id="page" class="hfeed site">

<header id="masthead" class="site-header clearfix" role="banner" style="background: #2e3138;">

		<div class="site-branding">
<h1 style="color:#fff;font-size:18px;"><a href="/"><i class="fa fa-reply"></i></a> <?php _e( 'Oops! That page can&rsquo;t be found.', 'planum' ); ?></h1>
		</div><!--.site-branding-->

</header><!-- #masthead -->

	<div id="main" class="site-main clearfix">