<?php
/**
 * @package Planum
 */
?>

<article id="post-<?php the_ID(); ?>" <?php post_class('clearfix'); ?>>

	<?php if ( has_post_thumbnail() ) : ?>

		<figure class="featured-image">

			<a href="<?php the_permalink(); ?>" title="<?php the_title_attribute(); ?>">
			<?php the_post_thumbnail( 'planum-featured-small' ); ?>
			</a>

		</figure>

	<?php endif; ?>

	<header class="entry-header">
		<h1 class="entry-title">
			<a href="<?php the_permalink(); ?>" title="<?php the_title(); ?>" rel="bookmark"><?php the_title(); ?></a>
		</h1>

		<div class="entry-meta">

			<?php planum_posted_on(); ?>

			<?php $comments = get_comments_number();

			if ( $comments > 0 ) : ?>

				 | <a href="<?php the_permalink(); ?>#comments">

				<?php printf( _nx( '1 Comment', '%1$s Comments', $comments, 'comments title', 'planum' ), number_format_i18n( $comments ) ); ?>

				 </a>

			<?php endif; ?>

		</div><!-- .entry-meta -->

	</header><!-- .entry-header -->

	<div class="entry-summary" <?php if ( !has_post_thumbnail() ) : ?>style="padding: 0;"<?php endif; ?>>
	<?php the_excerpt(); ?>
	<a class="read-more" href="<?php the_permalink(); ?>" title="<?php the_title(); ?>" rel="bookmark"><div class="tiles-more"><?php _e('READ MORE', 'planum'); ?> <i class="fa fa-arrow-right"></i></div></a>


	</div><!-- .entry-summary -->

</article><!-- #post-<?php the_ID(); ?> -->