<?php
/**
 * @package Planum
 */

add_action( 'admin_init', 'planum_theme_settings_init' );
add_action( 'admin_menu', 'planum_add_settings_page' );

/*=SETUP----------------------------------------------------*/

function planum_theme_settings_init(){
	register_setting( 'planum_theme_settings', 'planum_theme_settings', 'planum_options_validate' );
}

function planum_admin_enqueue_scripts( $hook_suffix ) {
	$template_directory_uri = get_template_directory_uri();

	wp_enqueue_style( 'planum-theme-options', $template_directory_uri . '/theme-options/theme-options.css', false, '1.0.4' );
	wp_enqueue_script( 'planum-theme-options', $template_directory_uri . '/theme-options/theme-options.js', array( 'jquery' ), '1.0.4' );

	wp_enqueue_script('media-upload');
	wp_enqueue_script('thickbox');
	wp_enqueue_style('thickbox');
}
add_action( 'admin_print_styles-appearance_page_setting', 'planum_admin_enqueue_scripts' );

function planum_add_settings_page() {
	global $planum_admin_page;

	$planum_admin_page = add_theme_page( __( 'Theme Options', 'planum' ), __( 'Theme Options', 'planum' ), 'manage_options', 'setting', 'planum_theme_settings_page');

	// Contextual Help
	add_action( 'load-' . $planum_admin_page, 'planum_admin_contextual_help' );
}

function options_echo_scripts()
{
?>
<script type="text/javascript">
//<![CDATA[
jQuery(document).ready(function() {

// Media Uploader
window.formfield = '';

jQuery('.upload_image_button').live('click', function() {
	window.formfield = jQuery('.upload_field',jQuery(this).parent());
	tb_show('', 'media-upload.php?type=image&TB_iframe=true');
	return false;
});

window.original_send_to_editor = window.send_to_editor;
window.send_to_editor = function(html) {
	if (window.formfield) {
		imgurl = jQuery('img',html).attr('src');
		window.formfield.val(imgurl);
		tb_remove();
	}
	else {
		window.original_send_to_editor(html);
	}
	window.formfield = '';
	window.imagefield = false;
}

});
//]]> 
</script>
<?php
}
add_action('admin_head', 'options_echo_scripts');

/**
 * Options Page Build
 */
function planum_theme_settings_page() {	
?>

<!--GO Page Options-->

<div class="wrap">

<?php
if ( isset ($_GET['settings-updated']) ) { ?>
<div id="message" class="updated fade -message"><p><?php _e('Options Saved','planum'); ?></p></div>
<?php } ?>

<h2><?php $theme_name = wp_get_theme(); echo $theme_name ?><?php _e( ' Theme Options', 'planum' ) ?></h2>

<div style="padding: 10px 20px 20px 20px;background-color:#FFF;border:solid 1px #DDD;">
<h3><?php _e( 'Thank you for choosing this Theme!', 'planum' ); ?></h3>
<p><?php _e( 'This theme has a contextual help which is integrated in the built-in Help WordPress. To get quick help - click the Help tab on the top right.', 'planum' ); ?></p>
<span style="margin-right:10px;"><strong><?php _e( 'More features and personal support 24/7', 'planum' ); ?></strong></span>
<a href="http://dinevthemes.com/collection/planum/" class="button-primary"><?php _e( 'Get Now!', 'planum' ); ?></a>
</div>

<form method="post" action="options.php">

<?php settings_fields( 'planum_theme_settings' ); ?>
<?php $options = get_option( 'planum_theme_settings' ); ?>

<table class="form-table">

<tr valign="top">
<th scope="row">
<?php _e( 'Avatar', 'planum' ); ?>
</th>
<td>
<input id="planum_theme_settings[file_avatar]" class="regular-text upload_field" type="text" size="36" name="planum_theme_settings[file_avatar]" value="<?php echo esc_url($options['file_avatar']); ?>" />
<input class="upload_image_button button-secondary" type="button" value="<?php _e( 'Upload Image', 'planum' ); ?>" />
<br />
<label class="description" for="planum_theme_settings[file_avatar]"><?php _e( 'Upload or enter URL file the image instead of the Gravatar. Better square image larger than 120x120px','planum'); ?></label>
</td>
</tr>

<tr valign="top">
<th scope="row"><?php _e( 'Built-in share button', 'planum' ); ?></th>
<td>
<input id="planum_theme_settings[share_but]" class="checkbox" type="checkbox" name="planum_theme_settings[share_but]" value="1" <?php checked( $options['share_but'], 1 ); ?> />
<label class="description" for="planum_theme_settings[share_but]"><?php _e( 'Check, if disable the built-in share button.','planum'); ?></label>
</td>
</tr>

</table>

<p class="submit-changes">
<input type="submit" class="button-primary" value="<?php _e( 'Save Options', 'planum' ); ?>" />
</p>
</form>
</div><!--//wrap -->

<!--END Page Options-->

<?php
}
/*=Sanitize------------------
-------------------------------*/
function planum_options_validate( $input ) {

	$output = $options = get_option( 'planum_theme_settings' );

		$output['file_avatar'] = wp_kses_post($input['file_avatar']);

		if( !isset( $input['share_but'] ) ) {
			$input['share_but'] = null;
			}
		$output['share_but'] = ( $input['share_but'] == 1 ? 1 : 0 );

	return apply_filters( 'planum_options_validate', $output, $input, $options );
}
?>