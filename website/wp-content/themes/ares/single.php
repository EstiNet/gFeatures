<?php
/**
 * The Template for displaying all single posts.
 *
 * @package ares
 */
get_header(); ?>

<div id="content" class="site-content-wrapper <?php echo esc_attr( of_get_option('ares_theme_background_pattern','crossword') ); ?>">
    <?php while (have_posts()) : the_post(); ?>
        <div class="page-content row ">
            <article class="col-md-9 item-page <?php echo esc_attr( of_get_option('ares_single_layout') ); ?>">
                <h2 class="post-title"><?php the_title(); ?></h2>
                <div class="avenue-underline"></div>
                <?php
                'on' == of_get_option('ares_single_featured', 'on') ? the_post_thumbnail('medium') : '';
                the_content();
                echo 'on' == of_get_option('ares_single_date', 'on') ? 'Posted on: ' .  esc_html( get_the_date() ) : '';
                echo 'on' == of_get_option('ares_single_author', 'on') ? ', by : ' . esc_attr(get_the_author() ) : '';
                wp_link_pages(array(
                    'before' => '<div class="page-links">' . __('Pages:', 'ares'),
                    'after' => '</div>',
                ));
                if (comments_open() || '0' != get_comments_number()) :
                    comments_template();
                endif;
                ?>
            </article>
            <?php if( 'col2r' == of_get_option('ares_single_layout', 'col2r')) : ?>
            <div class="col-md-3 avenue-sidebar">
                <?php get_sidebar(); ?>
            </div>
            <?php endif; ?>
        </div>
    <?php endwhile; // end of the loop. ?>

</div><!-- #primary -->

<?php get_footer(); ?>