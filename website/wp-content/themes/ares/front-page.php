<?php
/*
 * Theme homepage
 * @author bilal hassan <info@smartcatdesign.net>
 * 
 */
get_header(); ?>

<div class="site-content-wrapper <?php echo esc_attr( of_get_option('ares_theme_background_pattern','crossword') ); ?>">
    <div id="" class="page-content frontpage">

        <?php if (of_get_option('ares_slider_bool', 'yes') == 'yes') echo ares_slider(); ?>
        
        <?php if( of_get_option('ares_cta_header_one') ) : ?>
        <div class="center relative" id="main-heading">
            <div class="row">
                <h3 id="" class="animated fadeInLeft"><span><?php echo esc_attr( of_get_option('ares_cta_header_one', 'Tyros: A highly customizable modern online store') );?></span></h3>
            </div>
        </div>
        <?php endif; ?>        
        
        <?php if( of_get_option('ares_cta_header_two') ) : ?>
        <div class="center relative" id="secondary-heading">
            <div class="row">
                <h3 id="" class="animated fadeInRight"><span><?php echo esc_attr( of_get_option('ares_cta_header_two', 'Tyros: A highly customizable modern online store') );?></span></h3>
            </div>
        </div>
        <?php endif; ?>        
        
        
        <?php if (of_get_option('ares_cta_bool', 'yes') == 'yes') echo ares_ctas(); ?>
        <?php if (of_get_option('ares_banner_bool', 'yes') == 'yes') echo ares_banner(); ?>
        
        <div class="frontpage row">
        <?php while (have_posts()) : the_post(); ?>
            <?php
            if( 'yes' == of_get_option('ares_frontpage_content_bool', 'yes') ) :
                if ('posts' == get_option('show_on_front') ) {
                    get_template_part('content', 'posts');
                } else {
                    get_template_part('content', 'page');
                }                
            endif;
            // If comments are open or we have at least one comment, load up the comment template
            if (comments_open() || '0' != get_comments_number()) :
                comments_template();
            endif;
            ?>
        <?php endwhile; // end of the loop.   ?>
        </div>
    </div>
</div>
<?php get_footer(); ?>
