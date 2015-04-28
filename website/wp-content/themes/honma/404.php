<?php
/**
 * The template for displaying page NOT FOUND.
 *
 * @package Honma
 */
 get_header(); ?>
 		<div id="content">
			<div class="container">
				<div class="shadow_block">
					<div class="inner_page clearfix sidebar_right">
						<div class="page_section">
							<div class="gutter">
								<article class="single_post">
									<div class="article_text">
										<h2><?php _e( 'Not found', 'honma' ); ?></h2><hr>						
										<p><?php _e( 'Sorry, but you are looking for something that isn\'t here.', 'honma' ); ?></p>
									</div>								
									<div class="clear"></div>
								</article>
							</div>
						 </div>
						 <?php  get_sidebar(); ?>
					</div>
				</div>
			</div>
		</div>
<?php get_footer(); ?>