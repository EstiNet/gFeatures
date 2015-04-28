<?php
/**
 * The Header for our theme.
 *
 * Displays all of the <head> section and everything up till <div id="content">
 *
 * @package ares
 */
?><!DOCTYPE html>
<html <?php language_attributes(); ?>>
    <head>
        <meta charset="<?php bloginfo('charset'); ?>">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="profile" href="http://gmpg.org/xfn/11">
        <link rel="pingback" href="<?php bloginfo('pingback_url'); ?>">

        <?php wp_head(); ?>
    </head>

    <body <?php body_class(); ?>>
        <div id="page" class="hfeed site <?php echo 'no' == of_get_option('ares_headerbar_bool', 'yes') ? 'no_toolbar' : ''; ?>">
            <header id="masthead" class="site-header" role="banner">
                <?php ares_toolbar(); ?>
                <div class="site-branding">
                    <div class="row ">
                            <div class="col-xs-3">
                                <div id="tasty-mobile-toggle">
                                    
                                    <i class="fa fa-bars"></i>
                                    <?php wp_nav_menu(array('theme_location' => 'primary')); ?>
                                </div>
                                
                                <h2 class="site-title">
                                    <a href="<?php echo esc_url(home_url('/')); ?>" rel="home">
                                        <?php if (of_get_option('ares_logo_image') != '') : ?>
                                        <img src="<?php echo esc_attr( of_get_option('ares_logo_image') ); ?>" alt="" id="sc_logo"/>
                                        <?php else : ?>
                                        <?php bloginfo('name');?>
                                        <?php endif; ?>                                        
                                    </a>
                                </h2>
                                <?php if (of_get_option('ares_logo_image') == '') : ?>
                                    <h3 class="site-description"><?php bloginfo('description'); ?></h3>
                                <?php endif; ?>

                            </div>
                            <div class="col-xs-9 menu-bar">
                                <nav id="site-navigation" class="main-navigation" role="navigation">
                                    <?php wp_nav_menu(array('theme_location' => 'primary')); ?>
                                </nav>
                            </div>
                    </div>
                </div>

            </header><!-- #masthead -->


