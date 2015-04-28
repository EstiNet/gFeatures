//<![CDATA[
    jQuery(function($) {
        $('.spinner').fadeOut();
        $('.preloader').delay(500).fadeOut('slow');
    });
//]]>

jQuery(function($) {

    function fixedHeader() {
        var scroll = $(window).scrollTop(),
            height = $('#header-banner').outerHeight();

        if ( scroll > height ) {
            $('.header-fixed').addClass('scroll');
        } else {
            $('.header-fixed').removeClass('scroll');
        }

        if (!($('#header-banner').length)){
            $('.header-fixed').addClass('always-show');
            $('#content').css('margin-top', '120px');
        }        
    }

    // fixedHeader();

    $(document).on("ready", fixedHeader);
    $(window).on("scroll", fixedHeader);
    $(window).on("resize", fixedHeader);

    

	/* ---------------------------------------------------------------------- */
	/*  Parallax
	/* ---------------------------------------------------------------------- */

	$('.parallax').parallax();

    /* ---------------------------------------------------------------------- */
    /*  Portfolio
    /* ---------------------------------------------------------------------- */


    var posts = $('body');

    posts.find('.portfolio-nav li a').on('click', function(){
        posts.find('.portfolio-nav li a').removeClass('active');
        $(this).addClass('active');
        var selector = $(this).attr('data-filter');
        posts.find('.filtered').addClass('inactive');
        posts.find(selector).removeClass('inactive');
        return false;
    });
    
    /* ---------------------------------------------------------------------- */
    /*  Sidebar
    /* ---------------------------------------------------------------------- */

    $('.sidebar-btn').click(function(){
        $('#sidebar').toggleClass('hidden');
        $(this).toggleClass('cross');
       return false;
    });

    /* ---------------------------------------------------------------------- */
    /*  Lightbox
    /* ---------------------------------------------------------------------- */

    $('.portfolio-filter figcaption a').magnificPopup({
        type:'image',
        mainClass: 'mfp-fade'
    });


    /* ---------------------------------------------------------------------- */
    /*  CounterUp
    /* ---------------------------------------------------------------------- */

    $('.counter').counterUp({
    	time: 1500
    });


    /* ---------------------------------------------------------------------- */
    /*  Testimonials
    /* ---------------------------------------------------------------------- */

    $('.testimonials-view-all').on('click', function(){
        $('.testimonials-all').addClass('is-visible');

        return false;
    });

    $('.testimonials-all .close-btn').on('click', function(){
        $('.testimonials-all').removeClass('is-visible');

        return false;
    });

    $(document).keyup(function(event){
        if(event.which=='27'){
            $('.testimonials-all').removeClass('is-visible');   
        }
    });

    /* ---------------------------------------------------------------------- */
    /*  Fitvids
    /* ---------------------------------------------------------------------- */

    $("body").fitVids();

    /* ---------------------------------------------------------------------- */
    /*  Smooth Scroll
    /* ---------------------------------------------------------------------- */

    smoothScroll.init({
        speed: 300,
        updateURL: false
    });

    $(".to-top").hide();
    
    // fade in .to-top
    $(function () {
        $(window).scroll(function () {
            if ($(this).scrollTop() > 100) {
                $('.to-top').fadeIn();
            } else {
                $('.to-top').fadeOut();
            }
        });

        // scroll body to 0px on click
        $('.to-top').click(function () {
            $('body,html').animate({
                scrollTop: 0
            }, 800);
            return false;
        });
    }); 

});


/* ---------------------------------------------------------------------- */
/*  Typed
/* ---------------------------------------------------------------------- */
jQuery(function($) {
    if(typedText.strings !== ''){
        var typedStrings = JSON.parse(typedText.strings);
        $(".type").typed({
            strings: typedStrings,
            typeSpeed: 100,
            backDelay: 3000,
            loop: true,
        });
    }
});