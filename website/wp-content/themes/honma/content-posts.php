<?php 
/**
 * 
 * @package Honma 
 */
?>
<article <?php post_class(); ?> id="post-<?php the_ID(); ?>">
	<?php if ( has_post_thumbnail() && ! post_password_required() ) : ?>	
    <a class="article_img" href="<?php the_permalink(); ?>"><?php the_post_thumbnail('news-honma'); ?></a>	
	<?php endif; ?>	
	<div class="article_text">
		<h2><a href="<?php the_permalink() ?>"><?php if(get_the_title($post->ID)) { the_title(); } else { the_time( get_option( 'date_format' ) ); } ?></a></h2>
	    <p class="meta"><?php _e( 'By', 'honma' ); ?> <?php the_author(); ?>  | <?php the_time( get_option( 'date_format' ) ); ?> | <?php _e( 'Category', 'honma' ); ?> <?php the_category(', '); ?></p>
		<?php the_excerpt(); ?>
		<a href="<?php the_permalink(); ?>"><?php _e( 'Read More', 'honma' ); ?></a>
	</div>
	<div class="clear"></div>
</article>