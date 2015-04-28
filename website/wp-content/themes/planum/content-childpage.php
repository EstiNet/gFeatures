<?php
/**
 * @package Planum
 */
?>

<article id="post-<?php the_ID(); ?>" <?php post_class(); ?>>

	<header class="entry-header">
		<div class="page-thumb">
			<a href="<?php the_permalink(); ?>">
	<?php the_post_thumbnail( 'planum-rectangulum' ); ?>
			</a>
		</div>
		<h2 class="entry-title">
<a href="<?php the_permalink(); ?>" title="<?php the_title(); ?>" rel="bookmark"><?php the_title(); ?></a>
		</h2>
	</header><!-- .entry-header -->

	<div class="entry-content">
		<?php the_excerpt(); //the_content(); ?>
	</div><!-- .entry-content -->
</article><!-- #post-<?php the_ID(); ?> -->
