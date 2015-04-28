<?php
/**
 * The main template file
 *
 * @package Felynx_Forest
 * @since Felynx Forest 1.0
 */

get_header(); ?>

<header id="header">
	<div class="cover"<?php 
		if( get_theme_mod( 'cover_url' ) ) {
			echo ' style="background-image: url(' . get_theme_mod( 'cover_url' ) . ');"';
		}
	?>>
		<div class="layer"></div>
	</div>
	<div class="text">
		<h1><?php
			$title = wp_title( '', false );
			$pos = strpos( $title, get_bloginfo( 'name' ) );

			if ( $pos !== false) {
				$title = substr( $title, 0, $pos ); 
			}

			if ( empty( $title ) ) {
				bloginfo( 'description' );
			} else {
				echo $title;
			}
		?></h1>
	</div>
</header>

<main id="main" role="main">
	<ul class="post-entries container">
		<?php
			while ( have_posts() ) :
				the_post();

				$cover_img = '';
				if ( has_post_thumbnail() ) {
					$cover_img = ' style="background-image: url(' . wp_get_attachment_image_src( get_post_thumbnail_id(), 'large' )['0'] . ')"';
				} elseif ( get_theme_mod( 'cover_url' ) ) {
					$cover_img = ' style="background-image: url(' . get_theme_mod( 'cover_url' ) . ')"';
				}
		?><li id="post-<?php the_ID(); ?>" <?php post_class(); ?>>
			<a class="post-entry" href="<?php the_permalink(); ?>">
				<header>
					<div class="cover"<?php echo $cover_img?>>
						<div class="layer"></div>
					</div>
					<h2><?php the_title(); ?></h2>
					<h3><?php
						the_time( get_option( 'date_format' ) );

						$num_comments = get_comments_number();

						if ( comments_open() && $num_comments != 0 ) {
							if ( $num_comments > 1 ) {
								$comments = $num_comments . __( ' comments', 'felynxforest' );
							} else {
								$comments = __( 'One comment' , 'felynxforest' );
							}
							echo ' &middot; ' . $comments; 
						}
					?></h3>
				</header>
				<div class="the-excerpt">
					<?php the_excerpt(); ?>
				</div>
			</a>
		</li><?php endwhile; ?>
	</ul>
	<nav>
		<ul class="nav-links">
			<li class="prev">
				<?php previous_posts_link( '<i class="fa fa-angle-left"></i><span>' . __( 'Previous page', 'felynxforest' ) . '</span>' ); ?>
			</li><li class="next">
				<?php next_posts_link( '<span>' . __( 'Next page', 'felynxforest' ) . '</span><i class="fa fa-angle-right"></i>' ); ?>
			</li>
		</ul>
	</nav>
</main>

<?php get_footer(); ?>