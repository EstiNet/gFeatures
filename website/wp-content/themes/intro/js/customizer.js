/**
 * Theme Customizer enhancements for a better user experience.
 *
 * Contains handlers to make Theme Customizer preview reload changes asynchronously.
 */

( function( $ ) {
	// Site title and description.
	wp.customize( 'blogname', function( value ) {
		value.bind( function( to ) {
			$( '.site-title a' ).text( to );
		} );
	} );
	wp.customize( 'blogdescription', function( value ) {
		value.bind( function( to ) {
			$( '.site-description' ).text( to );
		} );
	} );
	// Header text color.
	wp.customize( 'header_textcolor', function( value ) {
		value.bind( function( to ) {
			if ( 'blank' === to ) {
				$( '.site-title, .site-description' ).css( {
					'clip': 'rect(1px, 1px, 1px, 1px)',
					'position': 'absolute'
				} );
			} else {
				$( '.site-title, .site-description' ).css( {
					'clip': 'auto',
					'color': to,
					'position': 'relative'
				} );
			}
		} );
	} );

	// Font sizes
	wp.customize('h1_size',function( value ) {
		value.bind( function( newval ) {
			$('h1').css('font-size', newval + 'px' );
		} );
	});	
    wp.customize('h2_size',function( value ) {
        value.bind( function( newval ) {
            $('h2').css('font-size', newval + 'px' );
        } );
    });	
    wp.customize('h3_size',function( value ) {
        value.bind( function( newval ) {
            $('h3').css('font-size', newval + 'px' );
        } );
    });
    wp.customize('h4_size',function( value ) {
        value.bind( function( newval ) {
            $('h4').css('font-size', newval + 'px' );
        } );
    });
    wp.customize('h5_size',function( value ) {
        value.bind( function( newval ) {
            $('h5').css('font-size', newval + 'px' );
        } );
    });
    wp.customize('h6_size',function( value ) {
        value.bind( function( newval ) {
            $('h6').css('font-size', newval + 'px' );
        } );
    });
    wp.customize('body_size',function( value ) {
        value.bind( function( newval ) {
            $('body').css('font-size', newval + 'px' );
        } );
    });
    wp.customize('widget_title_size',function( value ) {
        value.bind( function( newval ) {
            $('.panel .widget-title').css('font-size', newval + 'px' );
        } );
    });	
    // Site title
    wp.customize('site_title_color',function( value ) {
        value.bind( function( newval ) {
            $('.site-title a').css('color', newval );
        } );
    });
    // Site description
    wp.customize('site_desc_color',function( value ) {
        value.bind( function( newval ) {
            $('.site-description').css('color', newval );
        } );
    });
    // Body text color
    wp.customize('body_text_color',function( value ) {
        value.bind( function( newval ) {
            $('body').css('color', newval );
        } );
    });
    // Footer background
    wp.customize('footer_color',function( value ) {
        value.bind( function( newval ) {
            $('#footer').css('background-color', newval );
        } );
    });
    
} )( jQuery );
