<?php
/**
 * The template for displaying the footer.
 *
 *
 * @package Honma
 */
?>
		<footer id="footer">
			<div class="container">
				<div class="footer_widgets columnwrapp clearfix">
					<div class="column4">
						<?php if ( is_active_sidebar('footer-widget-area-1') ) : ?>
						<?php dynamic_sidebar('footer-widget-area-1'); ?>
						<?php else : ?>	
							<aside class="widget">
								<h3 class="widget-title"><?php _e( 'Recent Posts', "honma" ); ?></h3>
								<ul>
									<?php wp_get_archives('type=postbypost&limit=10'); ?>
								</ul>
							</aside>
						<?php endif; ?>
					</div>
					<div class="column4">
						<?php if ( is_active_sidebar('footer-widget-area-2') ) : ?>
						<?php dynamic_sidebar('footer-widget-area-2'); ?>
						<?php else : ?>	
							<aside class="widget">
								<h3 class="widget-title"><?php _e( 'Tag Cloud', "honma" ); ?></h3>
								<div class="tagcloud">
									<?php wp_tag_cloud(); ?>
								</div>
							</aside>
						<?php endif; ?>
					</div>
					<div class="column4">
						<?php if ( is_active_sidebar('footer-widget-area-3') ) : ?>
						<?php dynamic_sidebar('footer-widget-area-3'); ?>
						<?php else : ?>	
							<aside class="widget">
								<h3 class="widget-title"><?php _e( 'Pages', "honma" ); ?></h3>
								<ul>
									<?php wp_list_pages('title_li='); ?>
								</ul>
							</aside>
						<?php endif; ?>
					</div>
					<div class="column4">
						<?php if ( is_active_sidebar('footer-widget-area-4') ) : ?>
						<?php dynamic_sidebar('footer-widget-area-4'); ?>
						<?php else : ?>	
							<aside class="widget">
								<h3 class="widget-title"><?php _e( 'Categories', "honma" ); ?></h3>
								<ul>
									<?php wp_list_categories('title_li='); ?>
								</ul>
							</aside>
						<?php endif; ?>
					</div>
				</div> 
				<div class="copyright_container clearfix">
					<p class="copyright"><?php  echo esc_html(of_get_option('footer_text_left')); ?></p>
					<p class="credit_footer"><?php do_action( 'honma_display_credits' ); ?> </p>
				</div>
			</div>
		</footer> 
	</div>
<?php wp_footer(); ?>		
</body>
</html>