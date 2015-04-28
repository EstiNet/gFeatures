<?php
/**
 * The template for displaying 404 pages (Not Found).
 *
 * @package ares
 */
get_header();
?>
<div class="site-content-wrapper <?php echo esc_attr( of_get_option('ares_theme_background_pattern','crossword') ); ?>">
    <div id="content" class="site-content">
        <div class="page-content row ">
            <article class="col-md-9 item-page">
                <div class="widget widget_categories">
                    <h2 class="widgettitle center">
                        <i class="fa fa-exclamation-triangle icon404"></i>
                        <h3 class="center"><?php _e("Sorry the page you're looking for is not available", "ares"); ?></h3>
                        <div class="center mt20">
                            <?php get_search_form(); ?>
                        </div>
                    </h2>

                </div><!-- .widget -->
            </article>
            <div class="col-md-3 avenue-sidebar">
                <?php get_sidebar(); ?>
            </div>
        </div>
    </div>
</div>


<?php get_footer(); ?>