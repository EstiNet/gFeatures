<?php
/**
 * @package Planum
 */
?>


<div class="content-right" role="main">

<?php if ( has_post_thumbnail() ) { ?>
	<div class="post-thumb">
	<?php the_post_thumbnail( 'planum-featured-small' ); ?>
	</div>
<?php } ?>

<article id="post-<?php the_ID(); ?>" <?php post_class(); ?>>

	<div class="entry-content">
		<?php the_content(); ?>
		<?php
			wp_link_pages( array(
				'before' => '<div class="page-links">' . __( 'Pages:', 'planum' ),
				'after'  => '</div>',
			) );
		?>
	</div><!-- .entry-content -->

</article><!-- #post-## -->

<?php planum_content_nav( 'nav-below' ); ?>

	<?php
		// If comments are open or we have at least one comment, load up the comment template
		if ( comments_open() || '0' != get_comments_number() )
			comments_template();
	?>

</div><!-- .content-right -->