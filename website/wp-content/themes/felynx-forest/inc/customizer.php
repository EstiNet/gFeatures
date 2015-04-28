<?php
/**
 * Felynx Forest customizer functions
 *
 * @package Felynx_Forest
 * @since Felynx Forest 2.0
 */

function felynxforest_customizer( $wp_customize ) {
	/* Graphic identity */
	$wp_customize->add_panel( 'graphic_id', array(
		'priority'    => 1,
		'capability'  => 'edit_theme_options',
		'title'       => __( 'Graphic identity', 'felynxforest' ),
		'description' => __( 'Set up the different graphic elements to create your very own identity.', 'felynxforest' ),
	) );

	// Color scheme
	class Radio_Swatch_Control extends WP_Customize_Control {
		public $type = 'radio-swatch';

		public function render_content() {
			if ( empty( $this->choices ) )
				return;
			$name = '_customize-radio-' . $this->id;
			?>
			<span class="customize-control-title"><?php echo esc_html( $this->label ); ?></span>
			<?php
			foreach ( $this->choices as $value => $palette ) {
				echo '<label>
							<table class="color-palette" style="margin: 10px 0">
								<tbody>
									<tr>
										<td style="border-radius: 3px 0px 0px 3px; color: white; padding: 5px 0 5px 10px; width: 50%; background: ' . $palette['swatches'][0] . '">
											<input type="radio" value="' . esc_attr( $value ) . '" name="' . esc_attr( $name ) . '" ' . $this->get_link() . checked( $this->value(), $value, false ) . '/><span style="padding-left: 5px;">' . esc_attr( $palette[ 'label' ] ) . '</span>
										</td>
										<td style="border-radius: 0 3px 3px 0; background: ' . $palette['swatches'][1] . '">&nbsp;</td>
									</tr>
								</tbody>
							</table>
						</label>';
			}
		}
	}

	$wp_customize->add_section( 'color_style', array(
		'priority'    => 21,
		'title'       => __( 'Colors', 'felynxforest' ),
		'panel'       => 'graphic_id',
	) );

	$wp_customize->add_setting(
		'color_scheme',
		array(
			'default' => 'green',
			'sanitize_callback' => 'felynxforest_sanitize_choices',
		)
	);
	 
	$wp_customize->add_control(
		new Radio_Swatch_Control(
			$wp_customize,
			'color_scheme',
			array(
				'section' => 'color_style',
				'label'   => __( 'Color scheme', 'felynxforest' ),
				'type'    => 'radio-swatch',
				'choices' => array(
					'green' => array(
						'label'    => __( 'Green', 'felynxforest' ),
						'swatches' => array( '#467736', '#82C36C' ),
					),
					'blue' => array(
						'label'    => __( 'Blue', 'felynxforest' ),
						'swatches' => array( '#0085b0', '#58acfa' ),
					),
					'red' => array(
						'label'    => __( 'Red', 'felynxforest' ),
						'swatches' => array( '#bf2c2c', '#ed4e4e' ),
					),
				),
			)
		)
	);

	// Logo
	$wp_customize->add_section( 'logo_image', array(
		'priority'    => 22,
		'title'       => __( 'Logo', 'felynxforest' ),
		'description' => __( 'Your logo will appear in the top navigation bar.', 'felynxforest' ),
		'panel'       => 'graphic_id',
	) );

	$wp_customize->add_setting( 'logo_dark', array(
		'default' => '',
		'sanitize_callback' => 'esc_url_raw',
	) );
	
	$wp_customize->add_control(
		new WP_Customize_Image_Control(
			$wp_customize,
			'logo1',
			array(
				'label'       => __( 'Logo upload', 'felynxforest' ),
				'description' => sprintf( __( 'The recommended height is %s40px%s.', 'felynxforest'), '<b>', '</b>' ),
				'section'     => 'logo_image',
				'settings'    => 'logo_dark'
			)
		)
	);

	$wp_customize->add_setting( 'logo_light', array(
		'default' => '',
		'sanitize_callback' => 'esc_url_raw',
	) );

	$wp_customize->add_control(
		new WP_Customize_Image_Control(
			$wp_customize,
			'logo2',
			array(
				'label'       => __( 'Alternative for dark background', 'felynxforest' ),
				'description' => sprintf( __( 'The recommended height is %s40px%s.', 'felynxforest'), '<b>', '</b>' ),
				'section'     => 'logo_image',
				'settings'    => 'logo_light'
			)
		)
	);

	$wp_customize->add_setting( 'only_logo', array(
		'default' => false,
		'sanitize_callback' => 'felynxforest_sanitize_checkbox',
	) );

	$wp_customize->add_control( 'only_logo', array(
		'label'    => __( 'Display the logo w/o the site title', 'felynxforest' ),
		'section'  => 'logo_image',
		'type'     => 'checkbox',
	) );

	// Cover image
	$wp_customize->add_section( 'cover_image', array(
		'priority'    => 23,
		'title'       => __( 'Cover image', 'felynxforest' ),
		'description' => __( 'The cover image is used as the background default image in your header. In your posts, set a post thumbnail to overwrite it.', 'felynxforest' ),
		'panel'       => 'graphic_id',
	) );

	$wp_customize->add_setting( 'cover_url', array(
		'default' => '',
		'sanitize_callback' => 'esc_url_raw',
	) );
	
	$wp_customize->add_control(
		new WP_Customize_Image_Control(
			$wp_customize,
			'banner',
			array(
				'label'    => __( 'Cover image upload', 'felynxforest' ),
				'section'  => 'cover_image',
				'settings' => 'cover_url'
			)
		)
	);

	$wp_customize->add_setting( 'layer_opacity', array(
			'default' => 'dark',
			'sanitize_callback' => 'felynxforest_sanitize_choices',
		)
	);
	 
	$wp_customize->add_control( 'layer_opacity', array(
			'type'    => 'radio',
			'label'   => __( 'Layer opacity', 'felynxforest' ),
			'section' => 'cover_image',
			'description' => __( 'Combine your cover image with a layer to make the text more readable.', 'felynxforest' ),
			'choices' => array(
				'dark'  => __( 'Dark', 'felynxforest' ),
				'light' => __( 'Light', 'felynxforest' ),
				'none'  => __( 'None', 'felynxforest' ),
			),
		)
	);

	// Font
	$wp_customize->add_section( 'font', array(
		'priority'    => 23,
		'title'       => __( 'Font', 'felynxforest' ),
		'panel'       => 'graphic_id',
	) );

	$wp_customize->add_setting( 'font_choice', array(
			'default' => 'raleway',
			'sanitize_callback' => 'felynxforest_sanitize_choices',
		)
	);
	 
	$wp_customize->add_control( 'font_choice', array(
			'type'    => 'select',
			'label'   => __( 'Choose your font', 'felynxforest' ),
			'section' => 'font',
			'choices' => array(
				'arial'      => 'Arial',
				'comic'      => 'Comic Sans',
				'courier'    => 'Courier New',
				'helvetica'  => 'Helvetica',
				'lucida'     => 'Lucida Grande',
				'palatino'   => 'Palatino',
				'raleway'    => 'Raleway',
				'tahoma'     => 'Tahoma',
				'times'      => 'Times New Roman',
			),
		)
	);

	/* Header section */
	$wp_customize->add_panel( 'header_section', array(
		'priority'    => 2,
		'capability'  => 'edit_theme_options',
		'title'       => __( 'Header section', 'felynxforest' ),
		'description' => __( 'Personalize the content of your header. For the logo and the cover image, go to the graphic identity panel.', 'felynxforest' ),
	) );

	$wp_customize->get_section( 'title_tagline' )->panel = 'header_section';
	$wp_customize->get_section( 'nav' )->panel = 'header_section';

	/* Footer section */
	$wp_customize->add_panel( 'footer_section', array(
		'priority'    => 3,
		'capability'  => 'edit_theme_options',
		'title'       => __( 'Footer section', 'felynxforest' ),
		'description' => __( 'Personalize the content of your footer.', 'felynxforest' ),
	) );

	// Profile settings
	$get_users = get_users( array( 'fields' => array( 'ID', 'display_name' ) ) );
	$users[ 0 ] = __( '&mdash; Select &mdash;', 'felynxforest' );

	foreach ( $get_users as $user ) {
		$users[ $user->ID ] = esc_html( $user->display_name );
	}

	$wp_customize->add_section( 'main_profile', array(
		'priority'    => 31,
		'title'       => __( 'Main profile', 'felynxforest' ),
		'description' => __( 'The public details (avatar, name and biography) of the main profile are displayed in the footer of main pages.', 'felynxforest' ),
		'panel'       => 'footer_section',
	) );

	$wp_customize->add_setting( 'main_user', array(
		'default' => 0,
		'sanitize_callback' => 'felynxforest_sanitize_choices',
	) );
	
	$wp_customize->add_control(
		'main_user',
		array(
			'type'    => 'select',
			'label'   => __( 'Main profile', 'felynxforest' ),
			'section' => 'main_profile',
			'choices' => $users,
		)
	);

	$wp_customize->add_setting( 'main_user_page', array(
		'default' => false,
		'sanitize_callback' => 'felynxforest_sanitize_checkbox',
	) );

	$wp_customize->add_control( 'main_user_page', array(
		'label'    => __( 'Use the main profile for pages', 'felynxforest' ),
		'section'  => 'main_profile',
		'type'     => 'checkbox',
	) );

	$wp_customize->add_setting( 'main_user_post', array(
		'default' => false,
		'sanitize_callback' => 'felynxforest_sanitize_checkbox',
	) );

	$wp_customize->add_control( 'main_user_post', array(
		'label'    => __( 'Use the main profile for posts', 'felynxforest' ),
		'section'  => 'main_profile',
		'type'     => 'checkbox',
	) );

	// Default avatar
	$wp_customize->add_section( 'default_avatar', array(
		'priority'    => 32,
		'title'       => __( 'Default avatar', 'felynxforest' ),
		'description' => __( "The avatar is retrieved from the Gravatar of the user. However, if the user have not created one yet, the default avatar will be displayed instead.", 'felynxforest' ),
		'panel'       => 'footer_section',
	) );

	$wp_customize->add_setting( 'avatar_url', array(
		'default' => '',
		'sanitize_callback' => 'esc_url_raw',
	) );
	
	$wp_customize->add_control(
		new WP_Customize_Image_Control(
			$wp_customize,
			'avatar',
			array(
				'label'       => __( 'Default avatar upload', 'felynxforest' ),
				'description' => sprintf( __( 'The recommended size is %s212px by 212px%s.', 'felynxforest'), '<b>', '</b>' ),
				'section'     => 'default_avatar',
				'settings'    => 'avatar_url'
			)
		)
	);

	// Widgets
	$sidebar_footer = (object) $wp_customize->get_section( 'sidebar-widgets-sidebar-footer' );
	$sidebar_footer->panel = 'footer_section';
	$sidebar_footer->priority = 34;

	$sidebar_author = (object) $wp_customize->get_section( 'sidebar-widgets-sidebar-author' );
	$sidebar_author->panel = 'footer_section';
	$sidebar_author->priority = 35;

	// Social links	
	$social_menu = wp_get_nav_menu_object( 'social' );
	$social_menu = 1;

	if ( $social_menu ) {
		$menus       = wp_get_nav_menus();
		$choices = array( 0 => __( '&mdash; Select &mdash;', 'felynxforest' ) );
		foreach ( $menus as $menu ) {
			$choices[ $menu->term_id ] = wp_html_excerpt( $menu->name, 40, '&hellip;' );
		}

		$wp_customize->add_section( 'social_menu', array(
			'title'          => __( 'Social icons', 'felynxforest' ),
			'theme_supports' => 'menus',
			'priority'       => 33,
			'description'    => sprintf( __( '%sCreate a menu%s with custom links pointing to your social profiles around the web. Choose this menu here and the icons will be automatically displayed in your footer.', 'felynxforest'), '<a href="' . admin_url( 'nav-menus.php?action=edit&menu=0' ) . '">', '</a>' ),
			'panel'          => 'footer_section',
		) );

		$wp_customize->add_setting( 'nav_menu_locations[social]', array(
			'sanitize_callback' => 'absint',
			'theme_supports'    => 'menus',
		) );

		$wp_customize->add_control( 'nav_menu_locations[social]', array(
			'label'   => __( 'Social menu', 'felynxforest' ),
			'section' => 'social_menu',
			'type'    => 'select',
			'choices' => $choices,
		) );
	}

	/* Home page */
	$wp_customize->add_panel( 'home_page', array(
		'priority'    => 4,
		'capability'  => 'edit_theme_options',
		'title'       => __( 'Home page', 'felynxforest' ),
		'description' => __( 'Personalize the content of your home page.', 'felynxforest' ),
	) );

	$wp_customize->get_section( 'static_front_page' )->panel = 'home_page';
}

add_action( 'customize_register', 'felynxforest_customizer' );

function felynxforest_sanitize_checkbox( $input ) {
	if ( $input == 1 ) {
		return 1;
	} else {
		return '';
	}
}

function felynxforest_sanitize_choices( $input, $setting ) {
	global $wp_customize;
 
	$control = $wp_customize->get_control( $setting->id );
 
	if ( array_key_exists( $input, $control->choices ) ) {
		return $input;
	} else {
		return $setting->default;
	}
}
