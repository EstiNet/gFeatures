<?php
/**
 * The template used for displaying page content in page.php
 *
 * @package ares
 */
?>
<div class="homepage-content">
    <div class="row">
        <article id="post-<?php the_ID(); ?>" <?php //post_class();  ?> class="col-md-9 <?php echo esc_attr( of_get_option( 'ares_homepage_sidebar' ) ); ?>">
            <header class="entry-header">
                <?php the_title( '<h2 class="post-title">', '</h2>' ); ?>
                <div class="avenue-underline"></div>
            </header><!-- .entry-header -->

            <div class="entry-content">
                <?php the_content(); ?>
                <?php
                wp_link_pages( array(
                    'before' => '<div class="page-links">' . __( 'Pages:', 'ares' ),
                    'after' => '</div>',
                ) );
                ?>
            </div><!-- .entry-content -->
            <footer class="entry-footer">
                <?php edit_post_link( __( 'Edit', 'ares' ), '<span class="edit-link">', '</span>' ); ?>
            </footer><!-- .entry-footer -->
        </article><!-- #post-## -->
        <?php if ( 'sidebar-on' == of_get_option( 'ares_homepage_sidebar', 'sidebar-off' ) ) : ?>
            <div class="col-md-3 avenue-sidebar">
                <?php get_sidebar(); ?>
            </div>
        </div>
    </div>
<?php endif; ?>