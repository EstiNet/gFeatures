<?php
/**
 * @package Planum
 */

if ( ! function_exists( 'planum_content_nav' ) ) :

function planum_content_nav( $nav_id ) {
	global $wp_query, $post;

	if ( is_single() ) {
		$previous = ( is_attachment() ) ? get_post( $post->post_parent ) : get_adjacent_post( false, '', true );
		$next = get_adjacent_post( false, '', false );

		if ( ! $next && ! $previous )
			return;
	}

	if ( $wp_query->max_num_pages < 2 && ( is_home() || is_archive() || is_search() ) )
		return;

	$nav_class = ( is_single() ) ? 'navigation-post' : 'navigation-paging';

	?>
	<nav role="navigation" id="<?php echo esc_attr( $nav_id ); ?>" class="<?php echo $nav_class; ?>">
		<h1 class="screen-reader-text"><?php _e( 'Post navigation', 'planum' ); ?></h1>

	<?php if ( is_single() ) : ?>

		<?php previous_post_link( '<div class="nav-previous"><i class="fa fa-angle-left"></i> %link</div>', '%title' ); ?>
		<?php next_post_link( '<div class="nav-next">%link <i class="fa fa-angle-right"></i></div>', '%title' ); ?>

	<?php elseif ( $wp_query->max_num_pages > 1 && ( is_home() || is_archive() || is_search() ) ) : // navigation links for home, archive, and search pages ?>

		<?php if ( get_next_posts_link() ) : ?>
		<div class="nav-previous"><?php next_posts_link( __( '<i class="fa fa-arrow-left"></i>', 'planum' ) ); ?></div>
		<?php endif; ?>

		<?php if ( get_previous_posts_link() ) : ?>
		<div class="nav-next"><?php previous_posts_link( __( '<i class="fa fa-arrow-right"></i>', 'planum' ) ); ?></div>
		<?php endif; ?>

	<?php endif; //is_single() ?>

	</nav><!-- #<?php echo esc_html( $nav_id ); ?> -->
	<?php
}
endif; //planum_content_nav

/**
 * Template for comments and pingbacks.
 */

if ( ! function_exists( 'planum_comment' ) ) :

function planum_comment( $comment, $args, $depth ) {
	$GLOBALS['comment'] = $comment;
	switch ( $comment->comment_type ) :
		case 'pingback' :
		case 'trackback' :
	?>
	<li class="post pingback">
		<p><?php _e( 'Pingback:', 'planum' ); ?> <?php comment_author_link(); ?><?php edit_comment_link( __( 'Edit', 'planum' ), '<span class="edit-link">', '<span>' ); ?></p>
	<?php
			break;
		default :
	?>

	<?php $admincomment = ( user_can( $comment->user_id, 'manage_options' ) ? 'byadmin' : '' ); ?>

	<li <?php comment_class( $admincomment ) ?> id="li-comment-<?php comment_ID(); ?>">

		<article id="comment-<?php comment_ID(); ?>" class="comment">

			<figure class="comment-author-avatar">
				<?php echo get_avatar( $comment ); ?>
			</figure>

			<div class="comment-box">

				<div class="comment-author-vcard">

					<?php if ( user_can( $comment->user_id, 'manage_options' ) ) : ?>

						<?php _e( 'Author ', 'planum' ); ?>

					<?php endif; ?>

					<?php comment_author_link(); ?>


				</div><!-- .comment-author-vcard -->

				<div class="comment-content">

					<?php if ( $comment->comment_approved == '0' ) : ?>
						<em><?php _e( 'Your comment is awaiting moderation.', 'planum' ); ?></em>
						<br />
					<?php endif; ?>

					<?php comment_text(); ?>
<time datetime="<?php comment_time( 'c' ); ?>">
	<?php printf( _x( '%1$s &middot; %2$s', '1: date, 2: time', 'planum' ), get_comment_date(), get_comment_time() ); ?>
				</time>
				</div><!-- .comment-content -->

				<div class="comment-meta">
					<?php
						comment_reply_link( array_merge( $args,array(
							'depth'     => $depth,
							'max_depth' => $args['max_depth'],
							'before' => ' <i class="fa fa-reply"></i> '
						) ) );
					?>
<?php edit_comment_link( __( 'Edit', 'planum' ), '<span class="edit-link">', '<span>' ); ?>
				</div><!-- .comment-meta -->



			</div><!-- .comment-box -->

		</article><!-- #comment-## -->

	<?php
			break;
	endswitch;
}
endif; // ends check for planum_comment()

/**
 * Prints Meta information for the current post
 */
if ( ! function_exists( 'planum_posted_on' ) ) :

function planum_posted_on() {
	printf( __( '<span class="byline">by <span class="author vcard"><a class="url fn n" href="%1$s" title="%2$s" rel="author">%3$s</a></span></span> on <time class="entry-date" datetime="%4$s">%5$s</time>', 'planum' ),
		esc_url( get_author_posts_url( get_the_author_meta( 'ID' ) ) ),
		esc_attr( sprintf( __( 'All posts by %s', 'planum' ), get_the_author() ) ),
		get_the_author(),
		esc_attr( get_the_date( 'c' ) ),
		esc_html( get_the_date() )
	);
}
endif;
/**
 * Returns true if a blog has more than 1 category
 */
function planum_categorized_blog() {
	if ( false === ( $all_the_cool_cats = get_transient( 'all_the_cool_cats' ) ) ) {
		// Create an array of all the categories that are attached to posts
		$all_the_cool_cats = get_categories( array(
			'hide_empty' => 1,
		) );

		// Count the number of categories that are attached to the posts
		$all_the_cool_cats = count( $all_the_cool_cats );

		set_transient( 'all_the_cool_cats', $all_the_cool_cats );
	}

	if ( '1' != $all_the_cool_cats ) {
		// This blog has more than 1 category so planum_categorized_blog should return true
		return true;
	} else {
		// This blog has only 1 category so planum_categorized_blog should return false
		return false;
	}
}

/**
 * Flush out the transients used in planum_categorized_blog
 */
function planum_category_transient_flusher() {
	// Like, beat it. Dig?
	delete_transient( 'all_the_cool_cats' );
}
add_action( 'edit_category', 'planum_category_transient_flusher' );
add_action( 'save_post', 'planum_category_transient_flusher' );

if ( ! function_exists( 'planum_the_attached_image' ) ) :
/**
 * Prints the attached image with a link to the next attached image.
 */
function planum_the_attached_image() {
	$post                = get_post();
	$attachment_size     = apply_filters( 'planum_attachment_size', array( 1200, 1200 ) );
	$next_attachment_url = wp_get_attachment_url();

	/**
	 * Grab the IDs of all the image attachments in a gallery so we can get the
	 * URL of the next adjacent image in a gallery, or the first image (if
	 * we're looking at the last image in a gallery), or, in a gallery of one,
	 * just the link to that image file.
	 */
	$attachment_ids = get_posts( array(
		'post_parent'    => $post->post_parent,
		'fields'         => 'ids',
		'numberposts'    => -1,
		'post_status'    => 'inherit',
		'post_type'      => 'attachment',
		'post_mime_type' => 'image',
		'order'          => 'ASC',
		'orderby'        => 'menu_order ID'
	) );

	// If there is more than 1 attachment in a gallery...
	if ( count( $attachment_ids ) > 1 ) {
		foreach ( $attachment_ids as $attachment_id ) {
			if ( $attachment_id == $post->ID ) {
				$next_id = current( $attachment_ids );
				break;
			}
		}

		// get the URL of the next image attachment...
		if ( $next_id )
			$next_attachment_url = get_attachment_link( $next_id );

		// or get the URL of the first image attachment.
		else
			$next_attachment_url = get_attachment_link( array_shift( $attachment_ids ) );
	}

	printf( '<a href="%1$s" rel="attachment">%2$s</a>',
		esc_url( $next_attachment_url ),
		wp_get_attachment_image( $post->ID, $attachment_size )
	);
}
endif;