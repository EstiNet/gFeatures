<?php
/**
 * The template for displaying post comments
 *
 * @package Felynx_Forest
 * @since Felynx Forest 1.0
 */

	if ( post_password_required() ) {
		return;
	}

	if ( have_comments() ) : ?>

	<ol class="comment-list">
		<?php
			wp_list_comments( array(
				'style'			=> 'ol',
				'avatar_size'	=> 32,
				'max_depth'		=> 1,
				'type'			=> 'comment',
			) );
		?>
	</ol><!-- /.comment-list -->

<?php endif; // have_comments()
	// If comments are closed and there are comments
	if ( ! comments_open() && get_comments_number() && post_type_supports( get_post_type(), 'comments' ) ) :
?>
	<p class="no-comments"><?php _e( 'Comments are closed', 'felynxforest' ); ?></p>
<?php endif; ?>

<ul class="comment-pagination">
	<li class="prev">
    	<?php previous_comments_link() ?>
  	</li><li class="next">
    	<?php next_comments_link(); ?>
  	</li>
</ul>

<?php
	$fields =  array(
	 	'author' => '
		 	<p class="comment-form-author">
				<input placeholder="' . __( 'Name', 'felynxforest' ) . '" id="author" name="author" type="text" value="' . esc_attr( $commenter['comment_author'] ) . '" size="30"' . ( $req ? ' required' : '' )  . '>
				<label for="author"><i class="fa fa-user"></i></label>
			</p><!--',

	  	'email' =>
			'--><p class="comment-form-email">
				<input placeholder="' . __( 'Email address', 'felynxforest' ) . '" id="email" name="email" type="email" value="' . esc_attr( $commenter['comment_author_email'] ) . '" size="30"' . ( $req ? ' required' : '' )  . '>
				<label for="email"><i class="fa fa-envelope-o"></i></label>
			</p><!--',

	  	'url' =>
	 		'--><p class="comment-form-url">
				<input placeholder="' . __( 'Website', 'felynxforest' ) . '" id="url" name="url" type="url" value="' . esc_attr( $commenter['comment_author_url'] ) . '" size="30"' . ( $req ? ' required' : '' )  . '>
				<label for="url"><i class="fa fa-link"></i></label>
			</p>',
	);

	$comment_field =
		'<p class="comment-form-comment">
			<textarea placeholder="' . __( 'Write your comment', 'felynxforest' ) . '" id="comment" name="comment" cols="42" rows="8" required></textarea>
			<label for="comment"><i class="fa fa-pencil"></i></label>
		</p>';
	
	comment_form( array(
		'comment_notes_before'	=> '',
		'comment_notes_after'	=> '',
		'title_reply'			=> '',
		'fields'				=> $fields,
		'comment_field'			=> $comment_field,
	) );
?>