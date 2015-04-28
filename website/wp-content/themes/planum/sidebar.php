<?php
/**
 * @package Planum
 */
$options = get_option('planum_theme_settings'); 
?>
	<div id="sidebar" class="content-left widget-area" role="complementary">

<?php if ( is_single() ) : ?>

<div id="meta-box">
	<div id="author" class="author-area">

<?php if( !empty($options['file_avatar']) ) { ?>
	<img src="<?php echo $options['file_avatar']; ?>" style="height:120px;" />
<?php } else { ?>
	<?php echo get_avatar( get_the_author_meta('ID'), 720 ); ?>
<?php } ?>

		<div class="author-meta">
			<?php _e( 'Posted by ', 'planum'); ?><?php the_author_posts_link(); ?>
			<time datetime="<?php the_time('Y-m-d'); ?>"><?php the_date('j F Y', '<br />', '<br />'); ?></time>
		</div>

	</div><!-- #author -->

<div class="entry-meta">
		<?php
			$category_list = get_the_category_list( __( ', ', 'planum' ) );
			$tag_list = get_the_tag_list( '', __( ', ', 'planum' ) );

			if ( ! planum_categorized_blog() ) {
				if ( '' != $tag_list ) {
					$meta_text = __( '<p>TAGS<br />%2$s.</p>', 'planum' );
				} else {
					$meta_text = '';
				}

			} else {
				if ( '' != $tag_list ) {
					$meta_text = __( 'CATEGORY<br />%1$s<br />TAGS<br />%2$s', 'planum' );
				} else {
					$meta_text = __( 'CATEGORY<br />%1$s', 'planum' );
				}

			} // end check for categories

			printf(
				$meta_text,
				$category_list,
				$tag_list
			);
		?>
	</div><!-- .entry-meta -->

<?php if ( $options['share_but'] == 0 ) : ?>
	<div id="share">
<a id="ref_fb" href="http://www.facebook.com/sharer.php?u=<?php the_permalink();?>&t=<?php the_title(); ?>" onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=no,scrollbars=no,height=400,width=600'); return false;"></a>
<a id="ref_tw" href="http://twitter.com/share?text=<?php the_title(); ?>&amp;url=<?php the_permalink(); ?>" onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=no,scrollbars=no,height=400,width=600');return false;"></a>
<a id="ref_gp" href="https://plus.google.com/share?url=<?php the_permalink();?>"
onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=no,scrollbars=no,height=400,width=600');return false"></a>
	</div>
<?php endif; ?>

</div><!--#meta-box-->

<?php endif; //  is_single()  ?>

		<?php do_action( 'before_sidebar' ); ?>

		<?php if ( ! dynamic_sidebar( 'sidebar-blog' ) ) : ?>

			<aside class="widget">
				<h1 class="widget-title"><?php _e( 'Meta', 'planum' ); ?></h1>
				<ul>
					<?php wp_register(); ?>
					<li><?php wp_loginout(); ?></li>
					<?php wp_meta(); ?>
				</ul>
			</aside>

		<?php endif; // ! dynamic_sidebar ?>

	</div><!-- #sidebar -->
