<?php
/**
 * @package Planum
 */
?>

<article id="post-<?php the_ID(); ?>" <?php post_class(); ?>>

<a href="<?php the_permalink(); ?>" class="sticky-frame">
<div class="home-sticky" style="background: <?php echo get_theme_mod( 'planum_main_color' ); ?> url(<?php $thumbnail = wp_get_attachment_image_src( get_post_thumbnail_id(), 'planum-featured' );  if( !empty($thumbnail) ) { echo $thumbnail[0]; }else{ echo get_template_directory_uri() . '/img/blank.png'; }?>) no-repeat; background-position: 50%; background-size: cover;">

		<header class="entry-header">
	<h1 class="entry-title"><?php the_title(); ?></h1>
		</header><!-- .entry-header -->

		<div class="entry-summary">

	<?php if ( has_excerpt() ) : ?>
		<?php the_excerpt(); ?>
	<?php endif; //has_excerpt() ?>	

		<time datetime="<?php the_time('Y-m-d'); ?>"><?php the_date( get_option( 'date_format' ), '<em>', '</em>' ); ?></time>

		</div><!-- .entry-summary -->

</div><!-- .home-sticky-->
</a>


</article><!-- #post-<?php the_ID(); ?> -->