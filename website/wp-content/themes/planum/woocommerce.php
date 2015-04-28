<?php
/**
 * The template for WooCommerce Shop
 * Template Name: WooCommerce
 *
 * @package Typal2business
 */

get_header(); ?>

	<header class="headline">

	<h1 class="entry-title"><?php woocommerce_page_title(); ?></h1>

<?php
	$args = array(
			'delimiter' => ' &#8250; ',
	);
?>
<?php woocommerce_breadcrumb( $args ); ?>

	</header><!-- .entry-header -->

	<div id="content" class="site-content clearfix" style="background: #<?php echo get_theme_mod( 'background_color','FFF' ); ?> url(<?php echo get_theme_mod( 'background_image' ); ?>);">

		<div class="content-right main-woocommerce" role="main">
			<div class="entry-content">
			<?php woocommerce_content(); ?>
			</div>
		</div><!-- .content-right -->

	<?php get_sidebar('wooshop'); ?>

	</div><!-- #content -->

<?php get_footer(); ?>
