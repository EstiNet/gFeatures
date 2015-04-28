<?php
/**
 * The template for displaying Search Results pages.
 *
 * @package ares
 */

get_header(); ?>

	<div class="site-content">
		<div class="col-md-12">
			<?php if ( have_posts() ) : ?>
				<div class="page-title">
					<h1 class="row center"><?php printf( __( 'Search Results for: %s', 'ares' ), '<span>' . get_search_query() . '</span>' ); ?></h1>
				</div><!-- .page-title -->

				<?php /* Start the Loop */ ?>
				<div class="row">
					<div class="page-content col-md-12">
						<div class="col-md-9">
							<?php while ( have_posts() ) : the_post(); ?>
				
								<?php
								/**
								 * Run the loop for the search to output the results.
								 * If you want to overload this in a child theme then include a file
								 * called content-search.php and that will be used instead.
								 */
								get_template_part( 'content', 'search' );
							?>
							<?php endwhile; ?>
	
							<?php ares_paging_nav(); ?>
						</div>
						<div class="col-md-3">
                        	<?php get_sidebar(); ?>
						</div>
					</div>
				</div>
		<?php else : ?>
			<?php get_template_part( 'content', 'none' ); ?>
		<?php endif; ?>

		</div><!-- .col-md-12 -->
	</div><!-- .site-content -->
	
<?php get_footer(); ?>
