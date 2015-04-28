<?php
/**
 * The Sidebar containing the main widget areas.
 *
 * @package Honma
 */
?>
<div class="page_sidebar">
	<div class="gutter">				
		<?php if ( is_active_sidebar('sidebar-widget-area') ) : ?>
		<?php dynamic_sidebar('sidebar-widget-area'); ?>
		<?php else : ?>	
			<aside class="widget">
				<h3 class="widget-title"><?php _e( 'Recent Posts', "honma" ); ?></h3><hr />
				<ul>
					<?php wp_get_archives('type=postbypost&limit=10'); ?>
				</ul>
			</aside>
			<aside class="widget">
				<h3 class="widget-title"><?php _e( 'Pages', "honma" ); ?></h3><hr />
				<ul>
					<?php wp_list_pages('title_li='); ?>
				</ul>
			</aside>
			<aside class="widget">
				<h3 class="widget-title"><?php _e( 'Tag Cloud', "honma" ); ?></h3><hr />
				<div class="tagcloud">
					<?php wp_tag_cloud(); ?>
				</div>
			</aside>
			<aside class="widget">
				<h3 class="widget-title"><?php _e( 'Categories', "honma" ); ?></h3><hr />
				<ul>
					<?php wp_list_categories('title_li='); ?>
				</ul>
			</aside>		
		<?php endif; ?>
	</div>
</div>