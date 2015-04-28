<?php
/**
 * The template for displaying the content of pages and single posts
 *
 * @package Felynx_Forest
 * @since Felynx Forest 1.0
 */

	$cover_url = '';

	if ( has_post_thumbnail() ) {
		$cover_url = wp_get_attachment_image_src( get_post_thumbnail_id(), 'full')['0'];
	} elseif ( get_theme_mod( 'cover_url' ) ) {
		$cover_url = get_theme_mod( 'cover_url' );
	}

	$cover_img = ' style="background-image: url(' . $cover_url . ')"';
?>
<article id="post-<?php the_ID(); ?>" <?php post_class(); ?>>
	<div class="cover"<?php if( $cover_url ) echo $cover_img; ?>>
		<div class="layer">
		</div>
	</div>

	<div class="post-content">
		<header>
			<h1>
				<a href="<?php the_permalink(); ?>">
					<?php the_title(); ?>
				</a>
			</h1>
			<a class="invite-scroll" href="#content-<?php the_ID(); ?>">
				<i class="fa fa-<?php if(is_page()) echo 'leaf'; else echo 'tree'; ?>"></i>
			</a>
			<?php if( is_single() ): the_date( get_option( 'date_format' ), '<time class="post-date" datetime="' . get_the_time('c') . '">', '</time>' ); endif; ?>
		</header>

		<?php if( is_single() ): ?>
			<nav>
				<ul class="nav-links">
					<?php previous_post_link('<li class="prev">%link</li>', '<i class="fa fa-angle-left"></i><span>%title</span>'); ?>
					<?php next_post_link('<li class="next">%link</li>', '<span>%title</span><i class="fa fa-angle-right"></i>'); ?>
				</ul>
			</nav>
		<?php endif ?>

		<div class="the-content container" id="content-<?php the_ID(); ?>">
			<?php the_content(); ?>
			<?php wp_link_pages(); ?>
			<div class="clear"></div>
		</div>

		<div class="post-actions container">
			<?php if( is_single() ): ?>
				<div class="post-meta">
					<div class="post-metadata">
						<?php
							the_category();
							if( get_the_tag_list() ) {
								echo get_the_tag_list('<ul class="post-tags"><li>','</li><li>','</li></ul>');
							}
						?>
						<div class="clear"></div>
		  			</div>
				</div>
			<?php endif; ?>
			<div class="floral-heart">&#x2766;</div>
			<?php
				$num_comments = get_comments_number();
				$comments = '';

				if ( $num_comments == 0 && comments_open() ) {
					$comments = __( 'Comment', 'felynxforest' );
				} elseif ( $num_comments == 1 ) {
					$comments = __( 'One comment', 'felynxforest' );
				} elseif ( $num_comments > 1 ) {
					$comments = $num_comments . __(' comments', 'felynxforest' );
				}

				if ( ! empty ( $comments ) ) {
		 			$comments = '<li class="action-item"><button id="toggle-comments" type="button">' . $comments . '</button></li>';
				}
			?>
			<ul class="actions-list">
				<?php echo $comments ?>
			</ul>
			<div class="container" id="comments">
				<?php comments_template(); ?> 
			</div>
		</div>
		<div class="clear"></div>
	</div>
</article>