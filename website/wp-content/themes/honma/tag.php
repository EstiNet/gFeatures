<?php
/**
 * The template for displaying tag
 *
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
							    <h2><?php printf( __( 'Tag Archives: %s', 'honma' ), '<span>' . single_tag_title( '', false ) . '</span>' ); ?></h2><hr>
								<?php while (have_posts()) : the_post(); ?>
									<?php get_template_part( 'content', 'posts');  ?>								
								<?php endwhile; ?>
								<hr class="separe" />
								<span class="prev"><?php next_posts_link(__('Previous Posts', 'honma')) ?></span>
								<span class="next"><?php previous_posts_link(__('Next posts', 'honma')) ?></span>
							</div>
						</div>
						<?php  get_sidebar(); ?>
					</div>
				</div>
			</div>
		</div> 
<?php get_footer(); ?>