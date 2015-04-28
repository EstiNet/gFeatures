<?php
/**
 * The template for displaying all pages.
 *
 * @package Honma
 */
 get_header(); ?>
 <?php while (have_posts()) : the_post(); ?>
 		<div id="content">
			<div class="container">
				<div class="shadow_block">
					<div class="inner_page clearfix sidebar_right">
						<div class="page_section">
							<div class="gutter">
								<article class="single_post">
									<div class="article_text">
										<h2><?php if(get_the_title($post->ID)) { the_title(); } else { the_time( get_option( 'date_format' ) ); } ?></h2><hr>
										<p class="meta"><?php _e( 'By', 'honma' ); ?>  <?php the_author(); ?>  | <?php the_time( get_option( 'date_format' ) ); ?> | <?php _e( 'Category', 'honma' ); ?> <?php the_category(', '); ?></p>	
										<?php if ( has_post_thumbnail() && ! post_password_required() ) : ?>
												<?php the_post_thumbnail($post->ID, 'featured'); ?>
										<?php endif; ?>										
										<?php the_content(); ?>
										<p class="meta_tags"><?php the_tags(); ?></p>
										<p><?php posts_nav_link(); ?></p>
									</div>
									<?php honma_paginate_page(); ?> 								
									<div class="clear"></div>
									<div class="form"> 
											<?php comments_template(); ?>
									</div>	
								</article>
							</div>
						 </div>
						 <?php  get_sidebar(); ?>
					</div>
				</div>
			</div>
		</div>
<?php endwhile; ?>
<?php get_footer(); ?>