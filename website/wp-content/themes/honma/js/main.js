jQuery(document).ready(function(){
	
	jQuery(window).load(function() {
		//  menu_top
		jQuery('.menu_top li').hover(function(){
			jQuery(this).children('a').addClass('hover');
			jQuery(this).children('.sub-menu').stop().slideDown(200);
			jQuery(this).children('.children').stop().slideDown(200);
		}, function(){
			jQuery(this).children('a').removeClass('hover');
			jQuery(this).children('.sub-menu').stop().slideUp(200);
			jQuery(this).children('.children').stop().slideUp(200);
		});
		jQuery('.menu_top_container .icon_menu').click(function(eventObject) {
			eventObject.preventDefault();
		}).toggle(function(){
			jQuery(this).parent('.menu_top_container').find('.menu_top_mobile').stop().slideDown(200);
		}, function(){
			jQuery(this).parent('.menu_top_container').find('.menu_top_mobile').stop().slideUp(200);
		});	
		
		// input focus
		jQuery(".form .text, .form .textarea").focus(function(){
			var value = jQuery(this).attr("value");
			if (value == "")
			var attrfor = jQuery(this).attr('id');
			jQuery("label[for=" + attrfor + "]").css({"display":"none"});
		});
		jQuery(".form .text, .form .textarea").blur(function(){
			var value = jQuery(this).attr("value");
			if (value == "")
			var attrfor = jQuery(this).attr('id');
			jQuery("label[for=" + attrfor + "]").css({"display":"block"});
		});		
		
		// box hover
		jQuery('.box').hover(function(){
			jQuery(this).find('.overlay').stop().fadeIn(200);
		}, function(){
			jQuery(this).find('.overlay').stop().fadeOut(200);
		});
		
		// some css fix
		jQuery('.menu_topbar li:first-child, .menu_top .sub-menu li:first-child, .menu_top .children li:first-child, .menu_top_mobile li:first-child, .menu_footer li:first-child').addClass('first-child')
		jQuery('.articles_widget .article_sidebar:last-child').addClass('last-child')
	});
	
}); //Final ready