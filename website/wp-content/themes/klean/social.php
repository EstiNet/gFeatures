<?php
/**
 * The social icon template of the theme.
 *
 * @package klean
 */
?>


<div id="social-icons" class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

	<?php 
	$s = array(
				"facebook",
				"twitter",
				"google-plus",
				"instagram",
				"youtube",
				"linkedin",
				"pinterest-p",
				"vimeo-square",
				"envelope-o",
				"tumblr",
				"stumbleupon",
				"reddit",
				"vine",
				"soundcloud",
				"yelp"
			  );
			  
	$t = array(
				"Facebook",
				"Twitter",
				"Google Plus",
				"Instagram",
				"Youtube",
				"Linked In",
				"Pinterest",
				"Vimeo",
				"Mail",
				"Tumblr",
				"StumbleUpon",
				"Reddit",
				"Vine",
				"SoundCloud",
				"Yelp"
			);
			  
	for($u = 0; $u < 14; $u++) {
		if (get_theme_mod($s[$u])) {
	?>
		<a target="_blank" href="<?php echo get_theme_mod($s[$u]); ?>" title="<?php echo $t[$u] ?>"><span class="fa-stack fa-lg"> <i class="fa fa-circle fa-stack-2x"></i><i class="fa fa-<?php echo $s[$u] ?> fa-stack-1x fa-inverse"></i></span></a>
	<?php }
	}
	?>

</div>