<?php
/**
 * Template for Posts Tiles
 *
 * @package Planum
 */
?>

<?php if ( have_posts() ) : ?>

	<?php while ( have_posts() ) : the_post(); ?>

		<article id="post-<?php the_ID(); ?>" <?php post_class('planum post'); ?>>

			<a href="<?php the_permalink(); ?>" title="<?php the_title_attribute(); ?>">

			<?php if ( has_post_thumbnail() ) :
				the_post_thumbnail('planum-quadratum');
				else : ?>
			<img src="<?php echo get_template_directory_uri(); ?>/img/blank.png" alt="" width="800" height="800" />
			<?php endif; ?>

			</a>

			<a href="<?php the_permalink(); ?>" title="<?php the_title_attribute(); ?>" class="planum-content <?php if ( !has_post_thumbnail())  : ?> no-thumbnail<?php endif; ?>" rel="bookmark">

				<h2 class="entry-title"><?php the_title(); ?></h2>

					<div class="entry-summary">
<?php if ( has_post_format( array('aside', 'quote', 'link', 'image', 'gallery', 'video', 'audio')) ) : ?>
	<?php echo get_post_format_string( get_post_format() ); ?>
<?php else ://post_format() ?>
	<?php the_excerpt(); ?>
<div class="tiles-more">READ MORE <i class="fa fa-arrow-right"></i></div>
<?php endif; //post_format() ?>
					</div><!-- .entry-summary -->

			</a><!-- .planum-content -->

		</article><!-- #post-<?php the_ID(); ?> -->

	<?php endwhile; ?>

<?php else : ?>

	<?php get_template_part( 'no-tiles' ); ?>

<?php endif; ?>
