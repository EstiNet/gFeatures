<?php
/**
 * The template used for displaying page content in page.php
 *
 * @package ares
 */
?>
<div class="col-md-12">
    <div class="page-title">
        <div class="row center">
            <?php the_title(); ?>
        </div>
    </div>
    <div class="row ">
        <div class=" page-content col-md-12">
            <div class="col-md-3">
                <?php get_sidebar('left'); ?>
            </div>
            <div class="col-md-9">
                <?php
                the_content();
                wp_link_pages(array('before' => '<div class="page-links">' . __('Pages:', 'ares'), 'after' => '</div>'));

                // If comments are open or we have at least one comment, load up the comment template
                if (comments_open() || '0' != get_comments_number()) :
                    comments_template();
                endif;
                ?>
            </div>

        </div>
    </div>
</div>
