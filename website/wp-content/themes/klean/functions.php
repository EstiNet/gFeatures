<?php
/**
 * klean functions and definitions
 *
 * @package klean
 */

/**
 * Set the content width based on the theme's design and stylesheet.
 */
if ( ! isset( $content_width ) ) {
	$content_width = 640; /* pixels */
}

if ( ! function_exists( 'klean_setup' ) ) :
/**
 * Sets up theme defaults and registers support for various WordPress features.
 *
 * Note that this function is hooked into the after_setup_theme hook, which
 * runs before the init hook. The init hook is too late for some features, such
 * as indicating support for post thumbnails.
 */
function klean_setup() {

	/*
	 * Make theme available for translation.
	 * Translations can be filed in the /languages/ directory.
	 * If you're building a theme based on klean, use a find and replace
	 * to change 'klean' to the name of your theme in all the template files
	 */
	load_theme_textdomain( 'klean', get_template_directory() . '/languages' );

	// Add default posts and comments RSS feed links to head.
	add_theme_support( 'automatic-feed-links' );

	/*
	 * Enable support for Post Thumbnails on posts and pages.
	 *
	 * @link http://codex.wordpress.org/Function_Reference/add_theme_support#Post_Thumbnails
	 */
	add_theme_support( 'post-thumbnails' );

	// This theme uses wp_nav_menu() in one location.
	register_nav_menus( array(
		'primary' => __( 'Primary Menu', 'klean' ),
	) );

	/*
	 * Switch default core markup for search form, comment form, and comments
	 * to output valid HTML5.
	 */
	add_theme_support( 'html5', array(
		'search-form', 'comment-form', 'comment-list', 'gallery', 'caption',
	) );
	
	add_image_size('home-thumb', 400, 400, true);
	/*
	 * Enable support for Post Formats.
	 * See http://codex.wordpress.org/Post_Formats
	 */
	add_theme_support( 'post-formats', array(
		'aside', 'image', 'video', 'quote', 'link',
	) );
	
	add_theme_support('custom-header');
	// Set up the WordPress core custom background feature.
	add_theme_support( 'custom-background', apply_filters( 'klean_custom_background_args', array(
		'default-color' => 'ffffff',
		'default-image' => '',
	) ) );
}
endif; // klean_setup
add_action( 'after_setup_theme', 'klean_setup' );

/* 
 *  Adding title tag
*/

add_theme_support( 'title-tag' );


function klean_customizer($wp_customize) {

	$wp_customize-> add_setting(
	'logo',
	array(
		'sanitize_callback'	=> 'esc_url_raw',
		)
	);
    
    $wp_customize-> add_control(
	new WP_Customize_Image_Control(
        $wp_customize,
        'logo',
        array(
            'label' => __('OR Logo Upload', 'klean'),
            'section' => 'title_tagline',
            'settings' => 'logo'
            )
        )
    );
	
	$wp_customize-> add_section(
    'klean_social',
    array(
    	'title'			=> __('Social Settings','klean'),
    	'description'	=> __('Manage the Social Icon Setings of your site.','klean'),
    	'priority'		=> 3,
    	)
    );
    
    $wp_customize-> add_setting(
    'social',
    array(
    	'sanitize_callback'	=> 'klean_sanitize_checkbox',
    	)
    );
    
    $wp_customize-> add_control(
    'social',
    array(
    	'type'		=> 'checkbox',
    	'label'		=> __('Enable Social Icons','klean'),
    	'section'	=> 'klean_social',
    	'priority'	=> 1,
    	)
    );

    $wp_customize-> add_setting(
    'facebook',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'facebook',
    array(
    	'label'		=> __('Facebook URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'twitter',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'twitter',
    array(
    	'label'		=> __('Twitter URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'google-plus',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'google-plus',
    array(
    	'label'		=> __('Google Plus URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'instagram',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'instagram',
    array(
    	'label'		=> __('Instagram URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'pinterest-p',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'pinterest-p',
    array(
    	'label'		=> __('Pinterest URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'youtube',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'youtube',
    array(
    	'label'		=> __('Youtube URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'linkedin',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'linkedin',
    array(
    	'label'		=> __('Linked-In URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );

    
    $wp_customize-> add_setting(
    'vimeo-square',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'vimeo-square',
    array(
    	'label'		=> __('Vimeo URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'envelope-o',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'envelope-o',
    array(
    	'label'		=> __('Your E-Mail Info','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'tumblr',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'tumblr',
    array(
    	'label'		=> __('Tumblr URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'stumbleupon',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'stumbleupon',
    array(
    	'label'		=> __('StumbleUpon URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'reddit',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'reddit',
    array(
    	'label'		=> __('Reddit URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'vine',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'vine',
    array(
    	'label'		=> __('Vine URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'soundcloud',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'soundcloud',
    array(
    	'label'		=> __('SoundCloud URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    $wp_customize-> add_setting(
    'yelp',
    array(
    	'default'	=> '',
    	'sanitize_callback' => 'esc_url_raw',
    	)
    );
    
    $wp_customize-> add_control(
    'yelp',
    array(
    	'label'		=> __('Yelp URL','klean'),
    	'section'	=> 'klean_social',
    	'type'		=> 'text',
    	)
    );
    
    class Custom_CSS_Control extends WP_Customize_Control {
    public $type = 'textarea';
 
    public function render_content() {
        ?>
            <label>
                <span class="customize-control-title"><?php echo esc_html( $this->label ); ?></span>
                <textarea rows="8" style="width:100%;background: black; color: white;" <?php $this->link(); ?>><?php echo esc_textarea( $this->value() ); ?></textarea>
            </label>
        <?php
    }
}

	$wp_customize-> add_section(
    'custom_css',
    array(
    	'title'			=> __('Custom CSS','klean'),
    	'description'	=> __('Add some custom CSS code to edit your theme.','klean'),
    	'priority'		=> 11,
    	)
    );
	$wp_customize->add_setting(
	'css',
	array(
		'default'		=> '',
		'sanitize_callback'	=> 'klean_sanitize_text'
		)
	);
 
	$wp_customize->add_control(
	    new Custom_CSS_Control(
	        $wp_customize,
	        'css',
	        array(
	            'label' => 'Textarea',
	            'section' => 'custom_css',
	            'settings' => 'css'
	        )
	    )
	);
	
	$wp_customize-> add_section(
    'klean_pro',
    array(
    	'title'			=> __('Your Opinion Matters','klean'),
    	'description'	=> __('<i>Looking at the love and support this theme has recieved, I have decided to release a Pro version of the theme for more advanced users to create much more awesome stuff. Instead of stamping features on you, I decided to take your opinion regarding the features you would like in the Pro version. Don\'t worry, Klean will continue be the awesome theme it is.<br><br>
    	For providing your Input, just go to <a href="www.divjot.co">www.divjot.co</a> and answer a poll there on the sidebar.</i>','klean'),
    	'priority'		=> 999,
    	)
    );
    
    class MyCustom_Customize_Control extends WP_Customize_Control {    
	    public function render_content() {
	        ?>
	        <label>
						<input type="checkbox" value="<?php echo esc_attr( $this->value() ); ?>" <?php $this->link(); checked( $this->value() ); ?> />
						<?php echo esc_html( $this->label ); ?>
						<?php if ( ! empty( $this->description ) ) : ?>
							<span class="description customize-control-description"><?php echo $this->description; ?></span>
						<?php endif; ?>
					</label>
					
					<script>
					jQuery(function($){
						/* $('#customize-control-pro_hide' ).show(); */
						/*
wp.customize( 'pro_hide', function( value ) {
							value.bind( function( to ) {
*/
								$( '#customize-control-pro_hide' ).hide();
								$( '#accordion-section-klean_pro #accordion-section-title' ).css({"color":"#fff"});
							/*
} );
						} );
*/						
					});
					</script>

					
	        <?php
	    }
	}
    
    $wp_customize->add_setting(
	'pro_hide',
	array(
		'default'			=> false,
		'sanitize_callback'	=> 'klean_sanitize_checkbox',
		)
	);
 
	$wp_customize-> add_control( new MyCustom_Customize_Control( $wp_customize,
    'pro_hide',
    array(
    	'type'		=> 'checkbox',
    	'label'		=> __('Hide this section forever.','klean'),
    	'section'	=> 'klean_pro',
    	'priority'	=> 1,
    	/* 'active_callback' => 'is_front_page', */
    	)
    ));
    
     function klean_sanitize_checkbox( $i ) {
	    if ( $i == 1 ) {
	        return 1;
	    } 
	    else {
	        return '';
	    }
	 }
	 
	 function klean_sanitize_text( $input ) {
    return wp_kses_post( force_balance_tags( $input ) );
}
}

add_action('customize_register', 'klean_customizer');

/** 
 *Enqueuing  the fonts
 */

function klean_fonts_url() {
    $fonts_url = '';
    
    $source_sans_pro = _x('on', 'Source Sans Pro font: on or off', 'klean');

	if ( 'off' !== $source_sans_pro) {
	    $font_families = array();
	
	    if ('off' !== $source_sans_pro ) {
		    $font_families[] = 'Source Sans Pro:300,400';
	    }
		$query_args = array(
		    'family' => urlencode( implode( '|', $font_families ) ),
		    'subset' => urlencode( 'latin,latin-ext' ),
		);
	}
	
	$fonts_url = add_query_arg( $query_args, '//fonts.googleapis.com/css' );
 
    return $fonts_url;
}

function klean_scripts_styles() {
    wp_enqueue_style( 'klean-fonts', klean_fonts_url(), array(), null );
}
add_action( 'wp_enqueue_scripts', 'klean_scripts_styles' );

/**
 * Register widget area.
 *
 * @link http://codex.wordpress.org/Function_Reference/register_sidebar
 */
function klean_widgets_init() {
	register_sidebar( array(
		'name'          => __( 'Sidebar', 'klean' ),
		'id'            => 'sidebar-1',
		'description'   => '',
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h1 class="widget-title">',
		'after_title'   => '</h1>',
	) );
	
	register_sidebar( array(
		'name'          => __( 'Home Sidebar Left', 'klean' ),
		'id'            => 'sidebar-2',
		'description'   => '',
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h1 class="widget-title">',
		'after_title'   => '</h1>',
	) );
	
	register_sidebar( array(
		'name'          => __( 'Home Sidebar Right', 'klean' ),
		'id'            => 'sidebar-3',
		'description'   => '',
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h1 class="widget-title">',
		'after_title'   => '</h1>',
	) );
	
	register_sidebar( array(
		'name'          => __( 'Footer Sidebar 1', 'klean' ),
		'id'            => 'sidebar-4',
		'description'   => '',
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h1 class="widget-title">',
		'after_title'   => '</h1>',
	) );
	
	register_sidebar( array(
		'name'          => __( 'Footer Sidebar 2', 'klean' ),
		'id'            => 'sidebar-5',
		'description'   => '',
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h1 class="widget-title">',
		'after_title'   => '</h1>',
	) );
	
	register_sidebar( array(
		'name'          => __( 'Footer Sidebar 3', 'klean' ),
		'id'            => 'sidebar-6',
		'description'   => '',
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h1 class="widget-title">',
		'after_title'   => '</h1>',
	) );
}
add_action( 'widgets_init', 'klean_widgets_init' );

/**
 * Enqueue scripts and styles.
 */
function klean_scripts() {
	wp_enqueue_style( 'klean-style', get_stylesheet_uri() );

	wp_enqueue_style('klean-bootstrap-style',get_template_directory_uri()."/assets/bootstrap/bootstrap.min.css", array('klean-style'));
	
	wp_enqueue_style('klean-main-skin',get_template_directory_uri()."/assets/skins/main.css", array('klean-bootstrap-style'));
	
	 wp_enqueue_style('klean-font-awesome', get_template_directory_uri()."/assets/font-awesome/css/font-awesome.min.css", array('klean-main-skin'));
	
	wp_enqueue_script( 'klean-navigation', get_template_directory_uri() . '/js/navigation.js', array(), '20120206', true );

	wp_enqueue_script( 'klean-skip-link-focus-fix', get_template_directory_uri() . '/js/skip-link-focus-fix.js', array(), '20130115', true );

	if ( is_singular() && comments_open() && get_option( 'thread_comments' ) ) {
		wp_enqueue_script( 'comment-reply' );
	}
}
add_action( 'wp_enqueue_scripts', 'klean_scripts' );

function klean_initialize_header() {
	echo "<style>";
	
	echo get_theme_mod('css');
	
	echo "</style>";
}

add_action('wp_head', 'klean_initialize_header');

/**
 * Implement the Custom Header feature.
 */
require get_template_directory() . '/inc/custom-header.php';

/**
 * Custom template tags for this theme.
 */
require get_template_directory() . '/inc/template-tags.php';

/**
 * Custom functions that act independently of the theme templates.
 */
require get_template_directory() . '/inc/extras.php';

/**
 * Customizer additions.
 */
require get_template_directory() . '/inc/customizer.php';

/**
 * Load Jetpack compatibility file.
 */
require get_template_directory() . '/inc/jetpack.php';
