<?php
/**
 * @package klean
 */
?>

	<div class = "grid3 col-lg-4 col-md-4 col-sm-4 col-xs-12">

<article id="post-<?php the_ID(); ?>" <?php post_class('homepage-article'); ?>>
<div class = "featured-wrapper">

<div class="featured-image">

<?php if (has_post_thumbnail()) : ?>
	
	<?php the_post_thumbnail('home-thumb'); ?>
<?php else: ?>
	<img src="<?php echo get_template_directory_uri()."/images/dthumb.jpg";?>">
		<?php endif;?> 

</div>
<div class="featured-bar">
</div>
<header class="entry-header">
		
		<?php 
			if (strlen(get_the_title()) >= 30) { ?>
				<h1 class="entry-title"><a href="<?php the_permalink(); ?>" data-title="<?php esc_attr(get_the_title()); ?>" rel="bookmark">
		<?php echo esc_attr(substr(get_the_title(), 0, 29))."...";
		}
				
			else { ?>
			<h1 class="entry-title"><a href="<?php esc_url(the_permalink()); ?>" rel="bookmark">
		<?php	the_title_attribute();	
			}	
				 ?>
	</a></h1>
	</header><!-- .entry-header -->
</div>


</article><!-- #post-## -->
</div>