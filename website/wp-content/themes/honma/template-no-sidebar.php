<?php 
/**
 * Template Name: Full Width
 * 
 * @package Honma
 */
 get_header(); ?>
 <?php while (have_posts()) : the_post(); ?>
 		<div id="content">
			<div class="container">
				<div class="shadow_block">
					<div class="inner_page clearfix fullwidth">
						<div class="page_section">
							<div class="gutter">
								<article class="single_post">
									<div class="article_text">
										<h2><?php the_title(); ?></h2><hr>						
										<?php the_content(); ?>
										<div class="clear"></div>
										<p><?php posts_nav_link(); ?></p>
									</div>
									<?php honma_paginate_page(); ?> 
									<div class="comments"> 
										<?php comments_template(); ?>
									</div>									
									<div class="clear"></div>
								</article>
							</div>
						 </div>
					</div>
				</div>
			</div>
		</div>
<?php endwhile; ?>		
<?php get_footer(); ?>