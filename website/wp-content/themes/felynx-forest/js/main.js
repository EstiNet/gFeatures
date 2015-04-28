jQuery( function ( $ ) {
	// Global variables
	var nav  = $( '#nav' ),
		menu = nav.find( '.menu' );

	// Change background depending on scroll position
	$( window ).bind( 'scroll load', function() {
		var scroll = $( window ).scrollTop();

		if ( scroll > nav.outerHeight() ) {
			nav.addClass( 'scrolled' );
		} else {
			nav.removeClass( 'scrolled' );
		}
	});


	// Toggle actions
	var toggleComments = $( '#toggle-comments' ),
		comments = $( '#comments' );

	$( toggleComments ).click( function() {
		$( comments ).slideToggle( 'fast' );
		$( this ).toggleClass( 'active' );
	});

	// Toggle subpages
	var togglePages = $( '.page_item_has_children' );

	$( togglePages ).click( function() {
		$( this ).find( '.children li' ).slideToggle();
		$( this ).toggleClass( 'active' );
	});


	// Scroll to anchor on click
	$( 'a[href*=#]:not([href=#])' ).click( function() {
		if ( location.pathname.replace( /^\//, '' ) == this.pathname.replace( /^\//,'') && location.hostname == this.hostname ) {
			var target = $( this.hash );
			target = target.length ? target : $('[name=' + this.hash.slice(1) +']');

			if ( target.length ) {
				$( 'html,body' ).animate( {
					scrollTop: target.offset().top - $( '#nav' ).height() - $( '#wpadminbar' ).height() + 3
				}, 1000 );

				return false;
			}
		}
	});

	// Scroll to anchor on load
	var hashOnLoad = window.location.hash;

	if( hashOnLoad ) {
		if ( hashOnLoad.substring( 0, 8 ) == '#comment' ) {
			$( '#comments' ).show();
			$( '#toggle-comments' ).addClass( 'active' );
		}

		var target = $( hashOnLoad );

		if ( target.length ) {
			$( 'html,body' ).animate( {
				scrollTop: target.offset().top - $( '#nav' ).height() - $( '#wpadminbar' ).height() + 3
			}, 500 );

			return false;
		}
	}

	// If menu exists
	if( menu.length ) {
		// Active mobile design when menu is too long
		$( window ).on( 'resize', function () {
			var navWidth   = nav.width(),
				brandWidth = nav.find( '.brand' ).outerWidth(),
				menuWidth  = nav.find( '.menu' ).outerWidth();

			if ( menuWidth >= navWidth - brandWidth ) {
				nav.addClass( 'mobile' );

				if ( nav.hasClass( 'open' ) ) {
					setMaxHeight( menu );
				}
			} else {
				nav.removeClass( 'mobile' );
			}
		} ).resize()

		// Open mobile menu
		$( '.menu-toggle' ).click( function() {
			if ( nav.hasClass( 'open' ) ) { // closing
				menu.slideUp().promise().done( function() {
					nav.removeClass( 'open' );
					menu.removeAttr( 'style' );
				} );
			} else { // opening
				nav.addClass( 'open' );
				menu.slideDown();
				setMaxHeight( menu );
			}
		});
	}

	// Set max-height, default to viewport height
	function setMaxHeight( e, val ) {
		if ( typeof val === 'undefined' ) {
			val = $( window ).height() - e.position().top - nav.position().top;
		}

		e.css( 'max-height', val );
	}
} );
