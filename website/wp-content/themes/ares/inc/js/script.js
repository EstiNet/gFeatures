/**
 * Avenue Script
 * Author Bilal
 * 
 */
jQuery(document).ready(function($) {
    //--Match CTA Boxes height
    
    
    matchColHeights('.site-cta');
    
    $('.site-cta').css({visibility:'hidden'});
    
    $(window).scroll(function(){
        if( $('.site-cta').scrollTop() <= $(window).height() ){
            $('.site-cta').css({visibility:'visible'}).addClass('animated fadeInUp');
        }
    });    
    
    
    
    $('.site-cta').hover( function() {
        $('.fa', this).addClass('hover');
    }, function(){
        $('.fa', this).removeClass('hover');
    });
    
    $('#tasty-mobile-toggle .fa').click(function(){
        var clicker = $(this);
        
        clicker.toggleClass('active');
        $('.menu', '#tasty-mobile-toggle').slideToggle(400);
        
    });
    
    //------------------- Match Height Function
    function matchColHeights(selector) {
        var maxHeight = 0;
        $(selector).each(function() {
            var height = $(this).height();
            if (height > maxHeight) {
                maxHeight = height;
            }
        });
        $(selector).height(maxHeight);
    }
    
    function resize_slider() {
        var w = $('#main-slider').width();
        $('#slider_container,#slider_container > div').width(w);
    }

    $('.scroll-top').click(function() {
        $("html, body").animate({scrollTop: 0}, "slow");
        return false;
    });

    $('.menu-toggle').html('<i class="fa fa-bars fa-lg"></i>');
});