<?php
/**
 * @package Intro
 */
?>

	<article id="post-<?php the_ID(); ?>" <?php post_class(); ?>>
		
		<?php if ( has_post_thumbnail() ) : ?>
			<div class="entry-image">
				<a href="<?php the_permalink(); ?>" title="<?php the_title(); ?>" >
					<?php the_post_thumbnail('intro-thumb'); ?>
				</a>			
			</div>	
		<?php endif; ?>

		<div class="entry-info">
			<header class="entry-header">
				<?php the_title( sprintf( '<h5 class="entry-title"><a href="%s" rel="bookmark">', esc_url( get_permalink() ) ), '</a></h5>' ); ?>

				<?php if ( 'post' == get_post_type() ) : ?>
				<div class="entry-meta">
					<?php intro_posted_on(); ?>
				</div><!-- .entry-meta -->
				<?php endif; ?>
			</header><!-- .entry-header -->
		</div><!-- .entry-content -->
	</article><!-- #post-## -->
