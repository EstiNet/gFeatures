<?php
/*
 * Template Name: No Sidebar
 */
get_header();
?>
<div class="site-content-wrapper <?php echo esc_attr( of_get_option('ares_theme_background_pattern','crossword') ); ?>">
    <div id="content" class="site-content">
        <?php while (have_posts()) : the_post(); ?>
            <?php // get_template_part('content', 'page'); ?>
            <div class="page-content row ">
                <article class="col-md-12 item-page">
                    <h2 class="post-title"><?php the_title(); ?></h2>
                    <div class="avenue-underline"></div>
                    <?php
                    the_content();
                    wp_link_pages(array('before' => '<div class="page-links">' . __('Pages:', 'ares'), 'after' => '</div>'));

                    // If comments are open or we have at least one comment, load up the comment template
                    if (comments_open() || '0' != get_comments_number()) :
                        comments_template();
                    endif;
                    ?>
                </article>

            </div>

        <?php endwhile; // end of the loop.   ?>
    </div>
</div>
<?php get_footer(); ?>
