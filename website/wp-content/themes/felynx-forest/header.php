<?php
/**
 * The template for displaying the header
 *
 * @package Felynx_Forest
 * @since Felynx Forest 1.0
 */

?><!DOCTYPE html>
<html <?php language_attributes(); ?>>
	<head>
		<meta charset="<?php bloginfo( 'charset' ); ?>">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="pingback" href="<?php bloginfo( 'pingback_url' ); ?>">
		<!--[if lt IE 9]>
		<script src="<?php echo esc_url( get_template_directory_uri() ); ?>/js/html5shiv.js"></script>
		<![endif]-->
		<!-- <link rel="stylesheet" href="<?php bloginfo( 'stylesheet_url' ); ?>" type="text/css"> -->
		<?php
			wp_head();

			$style = '<style type="text/css">';

			$layer_opacity = get_theme_mod( 'layer_opacity' );
			if( $layer_opacity ) {
				switch ( $layer_opacity ) {
					case 'dark':
						$style .= 'body .layer { background: rgba(0,0,0,0.62) }';
						break;
					case 'light':
						$style .= 'body .layer { background: rgba(0,0,0,0.38) }';
						break;
					case 'none':
						$style .= 'body .layer { background: none }';
						break;
				}
			}

			$font_choice = get_theme_mod( 'font_choice' );
			if( $font_choice ) {
				switch ( $font_choice ) {
					case 'raleway':
						break;
					case 'arial':
						$style .= 'body { font-family: Arial, Helvetica, sans-serif }';
						break;
					case 'comic':
						$style .= 'body { font-family: "Comic Sans MS", cursive, sans-serif }';
						break;
					case 'courier':
						$style .= 'body { font-family: "Courier New", Courier, monospace }';
						break;
					case 'helvetica':
						$style .= 'body { font-family: "Helvetica Neue", Helvetica, Arial, sans-serif }';
						break;
					case 'lucida':
						$style .= 'body { font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif }';
						break;
					case 'palatino':
						$style .= 'body { font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif }';
						break;
					case 'tahoma':
						$style .= 'body { font-family: Tahoma, Geneva, Verdana, sans-serif }';
						break;
					case 'times':
						$style .= 'body { font-family: "Times New Roman", Times, serif }';
						break;
				}
			}

			echo $style . '</style>';
		?>
	</head>
	<body <?php body_class(); ?>>
		<nav id="nav" role="navigation">
			<div class="brand-container">
				<?php
					$has_primary_menu = false;

					if ( has_nav_menu( 'primary' ) ) {
						$primary_menu = wp_nav_menu( array(
							'theme_location'  => 'primary',
							'container_class' => 'menu-container',
							'echo'            => false,
						) );

						if ( ! empty ( $primary_menu ) ) {
							$has_primary_menu = true;
						}
					}

					if ( $has_primary_menu ) {
						echo '<button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>';
					}
				?>
				<div class="brand<?php if ( $has_primary_menu ) echo ' has-menu' ?>">
					<?php
						$logo_dark  = get_theme_mod( 'logo_dark' );
						$logo_light = get_theme_mod( 'logo_light' );
						$site_title = get_bloginfo( 'name' ); 
						$link_class = '';

						if ( $logo_dark && $logo_light ) {
							$link_class = 'logos';
						}

						$html       = '<a class="' . $link_class . '" href="' . esc_url( home_url( '/' ) ) . '">';

						if( $logo_dark ) {
							$html .= '<img class="dark logo" src="' . esc_url( $logo_dark ) . '" alt="' . esc_attr( $site_title ) . '">';
						}

						if( $logo_light ) { 
							$html .= '<img class="light logo" src="' . esc_url( $logo_light ) . '" alt="' . esc_attr( $site_title ) . '">';
						}

						if( ! get_theme_mod( 'only_logo' ) || ( ! $logo_dark && ! $logo_light ) ) {
							$html .= '<strong>' . sanitize_text_field( $site_title ) . '</strong>';
						}

						echo $html . '</a>';
					?>
				</div>
			</div>
			<?php
				if ( $has_primary_menu ) {
					echo $primary_menu;
				}
			?>
		</nav>