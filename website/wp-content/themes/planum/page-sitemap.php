<?php
/**
 * Template Name: SiteMap
 *
 * @package Planum
 */

get_header(); ?>

	<div id="content" class="site-content clearfix" style="background: #<?php echo get_theme_mod( 'background_color','FFF' ); ?> url(<?php echo get_theme_mod( 'background_image' ); ?>); padding-top: 24px;">

			<?php while ( have_posts() ) : the_post(); ?>
		<div class="content-right" role="main">

			<header class="page-header">
		<h1 class="entry-title"><?php the_title(); ?></h1>
			</header><!-- .page-header -->

<div class="grid2">
<div class="col">

                    <div class="month-archive archives nolist">
                        <h4>Month and Year</h4>
                        <ul>
                        <?php wp_get_archives('type=monthly&limit=12'); ?>
                        </ul>
                    </div>

                    <div class="authors archives nolist">
                        <h4>Authors</h4>
                        <ul>
                        <?php wp_list_authors('exclude_admin=0&optioncount=1&show_fullname=1&hide_empty=1'); ?>
                        </ul>
                    </div>

 </div><!--col-->
<div class="col">

                    <div class="categories archives nolist">
                        <h4>Categories</h4>
                        <ul>
                            <?php $args = array(
                                'orderby'            => 'name',
                                'order'              => 'ASC',
                                'style'              => 'list',
                                'show_count'         => 1,
                                'hide_empty'         => 1,
                                'child_of'           => 0,
                                'title_li'           => '',
                                'taxonomy'           => 'category',
                            ); wp_list_categories($args); ?>
                        </ul>
                    </div>

 </div><!--col-->
<div class="clearfix"></div>
 </div><!--grid2-->
		</div><!-- .content-right -->
			<?php endwhile; // end of the loop. ?>

	<?php get_sidebar( 'archive' ); ?>

	</div><!-- #content -->
<?php get_footer(); ?>