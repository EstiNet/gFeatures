<?php
/**
 * Theme Contextual Help
 * @package Planum
 */
add_filter( 'contextual_help', 'planum_admin_contextual_help', 10 );

function planum_admin_contextual_help() {

	$screen = get_current_screen();

if ( $screen->id == 'appearance_page_setting' ) {

  $screen->add_help_tab( array(
      'id' => 'my_help_tab',
      'title' => __( 'Welcome!', 'planum' ),
      'content' => '<p><strong>' . __( 'Thank you for choosing this Theme!', 'planum' ) . '</strong></p><p>' . __( 'Almost every console screen contains contextual help on this Theme by DinevThemes.', 'planum' ) . '</p><p>' . __( 'Introduction, tutorials and examples can be found on the DinevThemes website at <a href="http://www.dinevthemes.com/">www.dinevthemes.com</a>', 'planum' ) . '</p><p>' . __( 'More features and personal email support will get by purchasing the <a href="http://dinevthemes.com/themes/planum/">Premium Planum Theme</a>', 'planum' ) . '</p><p>',
  ) );

	$screen->add_help_tab( array(
		'id'      => 'planum-features',
		'title'   => __( 'Features', 'planum' ),
		'content' => __('<h2>Theme Features</h2><h3>Content Template</h3><p>The default Front page displays Your latest posts: a Home Tagline section, below sticky post in full width on the background featured image, and square tile posts.</p><p>As the Home page, you can specify a page with one of the custom page templates:</p><ol><li><strong>Full Width</strong>. Page without sidebars full width.</li><li><strong>Child Grid</strong>. Page displaying its content and header background featured image and below the grid featured image and titles child pages in two columns.</li><li><strong>Blog Tiles</strong>. And Blog page template in the grid square tile.</li></ol><p>As the Home page, you can also select the page with the Default Template. In this case, will be shown the content of the page (if the page is featured image, it will be used as background image), and below the sticky posts full width.</p><p>To configure Home page: <em>Settings > Reading: Front page displays</em> OR use the Customizer Static Front Page section.</p><h3>Theme Customizer</h3><p>To upload a logo image, choose colors, and much more is done using Customizer. You can preview settings changes in real time. Go to <em>Appearance > Customize</em></p><h3>Custom Menus</h3><p>The theme has 3 locations for menu: Header (Main), Top (on show/hide additional top-bar, the plus button) and Social (in the footer is located).</p><h4>Features Top menu</h4><p>If you create a menu Link - http://tel: / http://mailto: / https://goo.gl - will be automatically displayed icons Font Awesome.</p><p>Example:<br /><em>URL</em> http://tel:+74956627390<br /><em>Navigation Label</em> +7 495 662-73-90</p><h4>Features Social menu</h4><p>To create a menu item, use the tab Links (Edit Menus).</p><p>Example:<br />tab <strong>Links</strong><br /><em>URL</em> http://twitter.com/your<br /><em>Navigation Label</em> Twitter</p><h3>Slideshow Gallery</h3><p>WordPress shortcode <code>[gallery]</code> you can use the optional parameter <em>type="slider"</em> for a slideshow.</p><p>Usage: <code>[gallery columns="..." ids="..." type="slider"]</code></p><p><strong>Other features and examples you will find on DinevThemes website at www.dinevthemes.com</p>', 'planum' ),
	) );

	$screen->add_help_tab( array(
		'id'      => 'planum-options',
		'title'   => __( 'Theme Options', 'planum' ),
		'content' =>  __('<h2>Theme Options</h2><ul><li><strong>Avatar</strong> If the author posts is not registered in the service Gravatar or want to use another image avatars, use this field. The uploaded image will be used for avatars all authors of all posts.</li><li><strong>Built-in share button</strong> Sidebar post contains built-in buttons to share on Twitter, Facebook and Google Plus. Check here if you want to disable.</li></ul><p>Other settings using WordPress Customizer. Go to <em>Appearance > Customize</em>.</p><p>For background settings section Home Tagline, go to <em>Appearance > Header</em>. For background settings pages main content go to <em>Appearance>Background</em>. It also can be configured Customizer.</p>', 'planum' ),
	) );

/**------------------------------------------------------------------------------------------
	$screen->add_help_tab( array(
		'id'      => 'planum-faq',
		'title'   => __( 'FAQ', 'planum' ),
		'content' => implode( '', file( get_template_directory() . '/help/faq.htm' ) ),
	) );Plugins
--------------------------------------------------------------------------------------------*/

	$screen->add_help_tab( array(
		'id'      => 'planum-plugins',
		'title'   => __( 'Plugins', 'planum' ),
		'content' => __('<h2>Recommended Plugins</h2><ul><li><strong>Jetpack</strong> By WordPress.com<br />http://jetpack.me/</li><li><strong>Soliloquy Sliders</strong> By Thomas Griffin<br />http://soliloquywp.com/</li><li><strong>Shortcodes Ultimate</strong> By Vladimir Anokhin<br />http://gndev.info/shortcodes-ultimate/</li><li><strong>WP Google Maps</strong> By WP Google Maps<br />http://www.wpgmaps.com/</li><li><strong>Contact Form 7</strong> By Takayuki Miyoshi<br />http://contactform7.com/</li></ul>', 'planum' ),
	) );
/**------------------------------------------------------------------------------------------
	$screen->add_help_tab( array(
		'id'      => 'planum-support',
		'title'   => __( 'Support', 'planum' ),
		'content' => implode( '', file( get_template_directory() . '/help/support.htm' ) ),
	) );

	$screen->add_help_tab( array(
		'id'      => 'planum-changelog',
		'title'   => __( 'Changelog', 'planum' ),
		'content' => implode( '', file( get_template_directory() . '/help/changelog.htm' ) ),
	) );

	$screen->add_help_tab( array(
		'id'      => 'planum-license',
		'title'   => __( 'License', 'planum' ),
		'content' => implode( '', file( get_template_directory() . '/help/license.htm' ) ),
	) );
--------------------------------------------------------------------------------------------*/

    $screen->set_help_sidebar(
                               '<p><strong>' . __( 'For more information:', 'planum' ) . '</strong></p><p>' . __( '<a href="http://www.dinevthemes.com/">DinevThemes</a>' ) . '</p><p>' . __( '<a href="http://dinevthemes.com/documentation/">Documentation</a>', 'planum' ) . '</p><p>' . __( '<a href="http://dinevthemes.com/support/">Support</a>', 'planum' ) . '</p>'
                             );

}

if ( $screen->id == 'post' ) {

	$screen->add_help_tab( array(
		'id'      => 'planum-post-fimg',
		'title'   => __( 'Featured image', 'planum' ),
		'content' => '<p><strong>' . __( 'Use Featured image', 'planum' ) . '</strong></p><p>' . __( 'Upload the image that will be displayed posts tiles and header background image on single post. Better to use image of height 900 pixels and more.', 'planum' ) . '</p>',
  ) );
}

if ( $screen->id == 'page' ) {

  $screen->add_help_tab( array(
      'id' => 'planum_page_tab',
      'title' => __('Feature', 'planum'),
	'content' => __('<h2>Features</h2><p>Featured Image is used as background image of the title page. For pages actively Excerpt field. The text that is entered in the Excerpt will be displayed under the page title.</p><p>For Featured Image upload the large image width: 1200 pixels and more. If you do not upload Feautered Image, as the background of the title page image Header Image.</p>', 'planum' ),
  ) );

	$screen->add_help_tab( array(
		'id'      => 'planum-page-templates',
		'title'   => __( 'Templates', 'planum' ),
		'content' => __('<h2>Page templates</h2><p>You can choose a page template in Page Attributes using dropdown menu Template.</p><p>The theme offers several templates:</p><ol><li><strong>Full Width</strong>. Page without sidebars full width.</li><li><strong>Child Grid</strong>. Page displaying its content and header background featured image and below the grid featured image and titles child pages in two columns.</li><li><strong>Blog Tiles</strong>. The template displays blog posts as grid square tile.</li></ol>', 'planum' ),
	) );

}

if ( $screen->id == 'appearance_page_custom-header' ) {

	$screen->add_help_tab( array(
		'id'      => 'planum-header',
		'title'   => __( 'Feature', 'planum' ),
		'content' => __('<h2>Header Image</h2><p>Header Image is a background image section of Home Tagline. If you Remove Image, the background of Home Tagline will be the fill color. The background color of Home Tagline is configured Customizer. New background image Home Tagline can also be uploaded using Customizer.</p><p>If you upload multiple images, you can display different background images in random order.</p>', 'planum' ),
	) );
}

if ( $screen->id == 'appearance_page_custom-background' ) {

	$screen->add_help_tab( array(
		'id'      => 'planum-background',
		'title'   => __( 'Feature', 'planum' ),
		'content' => __('<h2>Background</h2><p>You can customize your background for the main content.</p><p>You can specify the fill color for the background or upload a background image. This can be done by Customizer in the live preview.</p>', 'planum' ),
	) );
}

if ( $screen->id == 'nav-menus' ) {

	$screen->add_help_tab( array(
		'id'      => 'planum-top-menus',
		'title'   => __( 'Top Menu', 'planum' ),
		'content' => __('<h2>Top Menu</h2><p>The theme has an additional top bar, which shows/hides the Plus button. The top panel has a Theme locations for Top menu.</p><p>If you create a menu item using Links tab (Edit Menus) and links will be http://tel: OR http://mailto: OR https://goo.gl (short link google map) it will be displayed icons Font Awesome.</p><p>Example:<br />tab <strong>Links</strong><br /><em>URL</em> http://tel+74956627390<br /><em>Navigation Label</em> +7 495 662-73-90</p>', 'planum' ),
	) );
	$screen->add_help_tab( array(
		'id'      => 'planum-social-menus',
		'title'   => __( 'Social Menu', 'planum' ),
		'content' => __('<h2>Social Media icons Menu</h2><p>Menu icons social media is displayed in the footer. Built all popular icons of social media, and including Feedburner.</p><p>To create a menu item, use the tab Links (Edit Menus).</p><p>Example:<br />tab <strong>Links</strong><br /><em>URL</em> http://twitter.com/your<br /><em>Navigation Label</em> Twitter</p>', 'planum' ),
	) );
}

/**
*else
*/
      return;
}
?>