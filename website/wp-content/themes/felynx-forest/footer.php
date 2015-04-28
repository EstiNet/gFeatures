<?php
/**
 * The template for displaying the footer
 *
 * @package Felynx_Forest
 * @since Felynx Forest 1.0
 */

	if ( ( is_page() && ! get_theme_mod( 'main_user_page' ) ) || ( is_single() && ! get_theme_mod( 'main_user_post' ) ) ) {
		$user_id = get_the_author_meta( 'ID' );
	}
	else {
		$user_id = get_theme_mod( 'main_user' );
	}

	$avatar = get_theme_mod( 'avatar_url' );
	if ( ! $avatar ) {
		$avatar = get_template_directory_uri() . '/img/avatar.jpg';
	}
	
	if( $user_id ) {
		$author = array(
			'about'    => get_the_author_meta( 'description', $user_id ),
			'name'     => get_the_author_meta( 'display_name', $user_id ),
			'avatar'   => get_avatar( $user_id, 212, $avatar ),
			'position' => '',
		);
	} else {
		$urls = array(
			'avatar'     => $avatar,
			'customizer' => admin_url( 'customize.php' ),
			'profile'    => admin_url( 'profile.php' ),
		);

		$author = array(
			'about'    => sprintf( wp_kses( __( 'Meow, this is no place for a kitty! I want you to replace me. Go to the <a href="%1$s">theme customizer</a>, open the footer section and click on the main profile setting. Select your user profile in the list and save. That\'s it, all your public details (avatar, name, biography and social media icons) will be displayed here. Also, don\'t forget to <a href="%2$s">fill up your profile</a>.', 'felynxforest' ), array( 'a' => array( 'href' => array() ) ) ), esc_url( $urls[ 'customizer' ] ), esc_url( $urls[ 'profile' ] ) ),
			'name'     => __( 'Jane Doe', 'felynxforest' ),
			'avatar'   => '<img width="212" height="212" class="avatar avatar-212 photo" src="' . esc_url( $urls[ 'avatar' ] ) . '" alt="">',
			'position' => '<section class="widget"><h2>' . __( 'Endor cat', 'felynxforest' ) . '</h2>' . __( 'Tree designer', 'felynxforest' ) . '</section>',
		);
	}

	if ( has_nav_menu( 'social' ) ) {
		$social_menu = wp_nav_menu(
			array(
				'theme_location'  => 'social',
				'container'       => false,
				'menu_class'      => 'social',
				'depth'           => 1,
				'link_before'     => '<span class="screen-reader-text">',
				'link_after'      => '</span>',
				'fallback_cb'     => '',
				'echo'            => false,
				'walker'          => new Felynxforest_Social_Walker,
			)
		);
	}

	if ( empty ( $social_menu ) ) {
		$social_menu = '<ul class="social"><li><a href="' . esc_url( 'https://wordpress.org/' ) . '" title="WordPress"><span class="screen-reader-text">WordPress</span></a></li></ul>';
	}
?>
		<footer id="footer"<?php 
			if( get_theme_mod( 'cover_url' ) ) {
				echo ' style="background-image: url(' . get_theme_mod( 'cover_url' ) . ');"';
			}
		?>>
			<div class="layer"></div>
			<div class="container">
				<div class="abouts">
					<?php if ( $author['about'] != '' ) : ?>
						<section>
							<h2><?php _e( 'About', 'felynxforest' ); ?></h2>
							<p><?php echo $author['about'] ?></p>
						</section>
					<?php endif ?>
					<?php if ( ! function_exists( 'dynamic_sidebar' ) || ! dynamic_sidebar( 'sidebar-footer' ) ) {}; ?>
				</div><aside class="author">
					<section>
						<h2><?php echo $author['name'] ?></h2>
						<ul>
							<li class="author-avatar">
								<span><?php echo $author['avatar'] ?></span>
							</li>
						</ul>
					</section>
					<?php 
						echo $author['position'];
						if ( ! function_exists( 'dynamic_sidebar' ) || ! dynamic_sidebar( 'sidebar-author' ) ) {};
					?>
				</aside>
			</div>

			<nav class="ground">
				<div class="container">
					<?php
						echo $social_menu;
					?><ul class="links">
						<li>
							<a href="<?php echo esc_url( home_url() ); ?>"><?php bloginfo( 'name' ); ?></a>
						</li><li>
							<a href="<?php echo esc_url( 'http://felynx.com/' ); ?>"><?php printf( __( 'Design: %s', 'felynxforest' ), 'Felynx Forest' ); ?></a>
						</li>
					</ul>
				</div>
			</nav>
		</footer>
		<?php wp_footer(); ?>
	</body>
</html>