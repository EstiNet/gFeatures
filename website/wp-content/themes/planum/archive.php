<?php
/**
 * @package Planum
 */

get_header(); ?>

	<div id="content" class="site-content clearfix" style="background: #<?php echo get_theme_mod( 'background_color','FFF' ); ?> url(<?php echo get_theme_mod( 'background_image' ); ?>);">

		<div class="content-right" role="main">

		<?php if ( have_posts() ) : ?>

			<header class="page-header">
				<h1 class="page-title">
					<?php
						if ( is_category() ) :
							printf( __( 'Category %s', 'planum' ), '<span>' . single_cat_title( '', false ) . '</span>' );

						elseif ( is_tag() ) :
							printf( __( 'Tag %s', 'planum' ), '<span>' . single_tag_title( '', false ) . '</span>' );

						elseif ( is_author() ) :
							the_post();
							printf( __( 'Author %s', 'planum' ), '<span class="vcard"><a class="url fn n" href="' . esc_url( get_author_posts_url( get_the_author_meta( 'ID' ) ) ) . '" title="' . esc_attr( get_the_author() ) . '" rel="me">' . get_the_author() . '</a></span>' );
							rewind_posts();

						elseif ( is_day() ) :
							printf( __( 'Daily %s', 'planum' ), '<span>' . get_the_date() . '</span>' );

						elseif ( is_month() ) :
							printf( __( 'Monthly %s', 'planum' ), '<span>' . get_the_date( 'F Y' ) . '</span>' );

						elseif ( is_year() ) :
							printf( __( 'Yearly %s', 'planum' ), '<span>' . get_the_date( 'Y' ) . '</span>' );

						else :
							_e( 'Archives', 'planum' );

						endif;
					?>
				</h1>
				<?php
					if ( is_category() ) :
						// show an optional category description
						$category_description = category_description();
						if ( ! empty( $category_description ) ) :
							echo apply_filters( 'category_archive_meta', '<div class="taxonomy-description">' . $category_description . '</div>' );
						endif;

					elseif ( is_tag() ) :
						// show an optional tag description
						$tag_description = tag_description();
						if ( ! empty( $tag_description ) ) :
							echo apply_filters( 'tag_archive_meta', '<div class="taxonomy-description">' . $tag_description . '</div>' );
						endif;

					endif;
				?>
			</header><!-- .page-header -->

			<?php while ( have_posts() ) : the_post(); ?>

				<?php get_template_part( 'content' ); //get_post_format() ?>

			<?php endwhile; ?>

		<?php else : ?>

			<?php get_template_part( 'no-results', 'archive' ); ?>

		<?php endif; ?>

			<?php planum_content_nav( 'nav-below' ); ?>

		</div><!-- .content-right -->

		<?php get_sidebar(); ?>

	</div><!-- #content -->
<?php get_footer(); ?>