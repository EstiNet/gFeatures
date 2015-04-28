// JavaScript Document
jQuery(document).ready(function ($) {
	setTimeout(function () {
		$(".fade").fadeOut("slow", function () {
			$(".fade").remove();
		});

	}, 2000);
});