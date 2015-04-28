<?php 
/**
 * 
 * @package Honma 
 */
get_header(); ?>
		<div id="content">
			<div class="container">
				<div class="shadow_block">
					<div class="getstarted_ads">
						<div class="gutter">
							<table>
								<tbody>
									<tr>
										<td class="column1">
											<?php if(of_get_option('bar_box_title')) { ?><p><?php  echo esc_html(of_get_option('bar_box_title')); ?> </p> <?php } ?>
										</td>
										<td class="column2">
											<?php if(of_get_option('bar_box_button_text')) { ?> <a class="button_getstarted" href="<?php  echo esc_url(of_get_option('bar_box_button_link')); ?>"> <?php  echo esc_html(of_get_option('bar_box_button_text')); ?>  </a> <?php } ?>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<?php while (have_posts()) : the_post(); ?>
					<div class="gutter">
						<article class="article_welcome clearfix">
							<div class="article_text">
								<?php the_content(); ?>
							</div>
						</article>
						<hr class="separe" />
					</div>
					<?php endwhile; ?>
					<div class="slider_container">
						<div class="gutter">
							<?php if(of_get_option('box_title_4')) { ?> <h2><?php echo esc_html(of_get_option('box_title_4')); ?></h2><?php } ?>
						</div>
						<div class="wedo_slider">
							<ul>
								<li>
									<article class="article_wedo gutter">
									    <?php if(of_get_option('box_1_image')) { ?>
										<div class="box">
											<div class="box_inner">
												<a href="<?php echo esc_url(of_get_option('box_1_link')); ?>">
												<img class="fullwidth" src="<?php echo esc_url(of_get_option('box_1_image')); ?>" alt="" />
												</a>
											</div>
										</div>
										<?php } ?>
										<?php if(of_get_option('box_1_title')) { ?> <h3><a href="<?php echo esc_url(of_get_option('box_1_link')); ?>"><?php  echo esc_html(of_get_option('box_1_title')); ?> </a></h3> <?php } ?>
										<?php if(of_get_option('box_1_description')) { ?> <p> <?php  echo esc_html(of_get_option('box_1_description')); ?> </p> <?php } ?>
									</article>
								</li>
								<li>
									<article class="article_wedo gutter">
									    <?php if(of_get_option('box_2_image')) { ?>
										<div class="box">
											<div class="box_inner">
												<a href="<?php echo esc_url(of_get_option('box_2_link')); ?>">
												<img class="fullwidth" src="<?php echo esc_url(of_get_option('box_2_image')); ?>" alt="" />
												</a>
											</div>
										</div>
										<?php } ?>
										<?php if(of_get_option('box_2_title')) { ?> <h3><a href="<?php echo esc_url(of_get_option('box_2_link')); ?>"><?php  echo esc_html(of_get_option('box_2_title')); ?> </a></h3> <?php } ?>
										<?php if(of_get_option('box_2_description')) { ?> <p> <?php  echo esc_html(of_get_option('box_2_description')); ?> </p> <?php } ?>
									</article>
								</li>
								<li>
									<article class="article_wedo gutter">
									    <?php if(of_get_option('box_3_image')) { ?>
										<div class="box">
											<div class="box_inner">
												<a href="<?php echo esc_url(of_get_option('box_3_link')); ?>">
												<img class="fullwidth" src="<?php echo esc_url(of_get_option('box_3_image')); ?>" alt="" />
												</a>
											</div>
										</div>
										<?php } ?>
										<?php if(of_get_option('box_3_title')) { ?> <h3><a href="<?php echo esc_url(of_get_option('box_3_link')); ?>"><?php  echo esc_html(of_get_option('box_3_title')); ?> </a></h3> <?php } ?>
										<?php if(of_get_option('box_3_description')) { ?> <p> <?php  echo esc_html(of_get_option('box_3_description')); ?> </p> <?php } ?>
									</article>
								</li>
								<li>
									<article class="article_wedo gutter">
									    <?php if(of_get_option('box_4_image')) { ?>
										<div class="box">
											<div class="box_inner">
												<a href="<?php echo esc_url(of_get_option('box_4_link')); ?>">
												<img class="fullwidth" src="<?php echo esc_url(of_get_option('box_4_image')); ?>" alt="" />
												</a>
											</div>
										</div>
										<?php } ?>
										<?php if(of_get_option('box_4_title')) { ?> <h3><a href="<?php echo esc_url(of_get_option('box_4_link')); ?>"><?php  echo esc_html(of_get_option('box_4_title')); ?> </a></h3> <?php } ?>
										<?php if(of_get_option('box_4_description')) { ?> <p> <?php  echo esc_html(of_get_option('box_4_description')); ?> </p> <?php } ?>
									</article>
								</li>								
							</ul>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<div class="shadow_block">
					<div class="gutter">
						<div class="guarantee_ads">
							<table>
								<tbody>
									<tr>
										<td class="column2">
											<?php if(of_get_option('bar_2_box_title')) { ?> <p><?php  echo esc_html(of_get_option('bar_2_box_title')); ?></p> <?php } ?>
										</td>
										<td class="column3">
											<?php if(of_get_option('bar_2_box_button_text')) { ?> <a class="button_guarantee" href="<?php  echo esc_url(of_get_option('bar_2_box_button_link')); ?>"> <?php  echo esc_html(of_get_option('bar_2_box_button_text')); ?> </a> <?php } ?>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<hr class="separe_2px" />
					</div>
					<div class="slider_container news_home">
						<div class="gutter">
							<?php if(of_get_option('post_title')) { ?> <h2> <?php  echo esc_html(of_get_option('post_title')); ?> </h2> <?php } ?>
						</div>
						<div class="blog_slider">
							<ul>
								<?php 
								$list_posts = honma_get_list_posts(3);
								while ( $list_posts->have_posts() ) {
								$list_posts->the_post();
								?>
								<li>
									<article class="article_blog_slider gutter">
										<div class="box clearfix">
											<?php if ( has_post_thumbnail() && ! post_password_required() ) : ?>
											<div class="box_inner">
												<a href="<?php the_permalink(); ?>"><?php the_post_thumbnail('news-honma'); ?></a>
											</div>												
											<?php endif; ?>
											<div class="article_text">
												<h3><a href="<?php the_permalink() ?>"><?php echo the_title(); ?></a></h3>
												<?php the_excerpt(); ?>
												<p class="posted"><?php _e( 'By', 'honma' ); ?> <?php the_author(); ?>  | <?php the_time( get_option( 'date_format' ) ); ?></p>
												<p class="posted-read-more"><a href="<?php the_permalink(); ?>"><?php _e( 'Read More', 'honma' ); ?></a></p>
											</div>
										</div>
									</article>
								</li>								
								<?php	} ?>
							</ul>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
<?php get_footer(); ?>