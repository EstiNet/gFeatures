<?php
/**
 * The template for displaying Archive pages.
 *
 * Learn more: http://codex.wordpress.org/Template_Hierarchy
 *
 * @package ares
 */
get_header();
?>
<div class="site-content-wrapper <?php echo esc_attr( of_get_option('ares_theme_background_pattern','crossword') ); ?>">
<div id="content" class="site-content">

    <?php if (have_posts()) : ?>

        <div class="col-md-12">
            <div class="page-title">
                <div class="row center">

                    <?php
                    if (is_category()) :
                        single_cat_title();

                    elseif (is_tag()) :
                        single_tag_title();

                    elseif (is_author()) :
                        printf(__('Author: %s', 'ares'), '<span class="vcard">' . get_the_author() . '</span>');

                    elseif (is_day()) :
                        printf(__('Day: %s', 'ares'), '<span>' . get_the_date() . '</span>');

                    elseif (is_month()) :
                        printf(__('Month: %s', 'ares'), '<span>' . get_the_date(_x('F Y', 'monthly archives date format', 'ares')) . '</span>');

                    elseif (is_year()) :
                        printf(__('Year: %s', 'ares'), '<span>' . get_the_date(_x('Y', 'yearly archives date format', 'ares')) . '</span>');

                    elseif (is_tax('post_format', 'post-format-aside')) :
                        _e('Asides', 'ares');

                    elseif (is_tax('post_format', 'post-format-gallery')) :
                        _e('Galleries', 'ares');

                    elseif (is_tax('post_format', 'post-format-image')) :
                        _e('Images', 'ares');

                    elseif (is_tax('post_format', 'post-format-video')) :
                        _e('Videos', 'ares');

                    elseif (is_tax('post_format', 'post-format-quote')) :
                        _e('Quotes', 'ares');

                    elseif (is_tax('post_format', 'post-format-link')) :
                        _e('Links', 'ares');

                    elseif (is_tax('post_format', 'post-format-status')) :
                        _e('Statuses', 'ares');

                    elseif (is_tax('post_format', 'post-format-audio')) :
                        _e('Audios', 'ares');

                    elseif (is_tax('post_format', 'post-format-chat')) :
                        _e('Chats', 'ares');

                    else :
                        _e('Archives', 'ares');

                    endif;
                    ?>
                </div>
            </div>
            <div class="row">
                <div class=" page-content col-md-12">
                    <div class="col-md-9">
                        <?php
                        // Show an optional term description.
                        $term_description = term_description();
                        if (!empty($term_description)) :
                            printf('<div class="taxonomy-description">%s</div>', $term_description);
                        endif;
                        ?>
                        </header><!-- .page-header -->

                        <?php /* Start the Loop */ ?>
                        <?php while (have_posts()) : the_post(); ?>

                            <?php
                            /* Include the Post-Format-specific template for the content.
                             * If you want to override this in a child theme, then include a file
                             * called content-___.php (where ___ is the Post Format name) and that will be used instead.
                             */
                            get_template_part('content', get_post_format());
                            ?>

                        <?php endwhile; ?>

                        <?php ares_paging_nav(); ?>

                    <?php else : ?>

                        <?php get_template_part('content', 'none'); ?>

                    <?php endif; ?>   
                </div>
                <div class="col-md-3 avenue-sidebar">
                    <?php get_sidebar(); ?>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<?php get_footer(); ?>
