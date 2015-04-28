<?php
/* 
 * Ares Theme setup
 */



function ares_scripts() {
    wp_enqueue_style('ares-style', get_stylesheet_uri());
    wp_enqueue_style('bootstrap', get_template_directory_uri() . '/inc/css/bootstrap.css', array(), ARES_VERSION);
    wp_enqueue_style('fontawesome', get_template_directory_uri() . '/inc/css/font-awesome.min.css', array(), ARES_VERSION);
    wp_enqueue_style('ares-main-style', get_template_directory_uri() . '/inc/css/style.css', array(), ARES_VERSION);
    wp_enqueue_style('ares-animations', get_template_directory_uri() . '/inc/css/animate.css', array(), ARES_VERSION);
    
    if('Source Sans Pro, sans-serif' == of_get_option('ares_font_family')) 
        wp_enqueue_style('ares-font-sans', '//fonts.googleapis.com/css?family=Source+Sans+Pro:200,400,600', array(), ARES_VERSION);
    
    if('Lato, sans-serif' == of_get_option('ares_font_family')) 
        wp_enqueue_style('ares-font-lato', '//fonts.googleapis.com/css?family=Lato:100,300,400,700,900,300italic,400italic', array(), ARES_VERSION);
    
    if('Josefin Sans, sans-serif' == of_get_option('ares_font_family', 'Josefin Sans, sans-serif') ) 
        wp_enqueue_style('ares-font-josefin', '//fonts.googleapis.com/css?family=Josefin+Sans:300,400,600,700', array(), ARES_VERSION);
    
    wp_enqueue_style('ares-template', get_template_directory_uri() . '/inc/css/temps/' . esc_attr( of_get_option('ares_theme_color', 'aqua') ) . '.css', array(), ARES_VERSION);
    wp_enqueue_style('ares-slider-style', get_template_directory_uri() . '/inc/css/camera.css', array(), ARES_VERSION);

    wp_enqueue_script('ares-navigation', get_template_directory_uri() . '/js/navigation.js', array('jquery'), ARES_VERSION, true);
    wp_enqueue_script('ares-bootstrapjs', get_template_directory_uri() . '/inc/js/bootstrap.min.js', array('jquery'), ARES_VERSION, true);
    wp_enqueue_script('ares-skip-link-focus-fix', get_template_directory_uri() . '/js/skip-link-focus-fix.js', array('jquery'), ARES_VERSION, true);

    wp_enqueue_script('ares-easing', get_template_directory_uri() . '/inc/js/jquery.easing.1.3.js', array('jquery'), ARES_VERSION, true);
    wp_enqueue_script('ares-uslider', get_template_directory_uri() . '/inc/js/camera.min.js', array('jquery'), ARES_VERSION, true);

    wp_enqueue_script('ares-script', get_template_directory_uri() . '/inc/js/script.js', array('jquery', 'jquery-ui-core'), ARES_VERSION);

    if (is_singular() && comments_open() && get_option('thread_comments')) {
        wp_enqueue_script('comment-reply');
    }
}

add_action('wp_enqueue_scripts', 'ares_scripts');


/**
 * Register widget area.
 *
 * @link http://codex.wordpress.org/Function_Reference/register_sidebar
 */
function ares_widgets_init() {

    register_sidebar(array(
        'name' => __('Header Right', 'ares'),
        'id' => 'sidebar-header-right',
        'description' => '',
        'before_widget' => '<aside id="%1$s" class="widget %2$s">',
        'after_widget' => '</aside>',
        'before_title' => '<h2 class="hidden">',
        'after_title' => '</h2>',
    ));

    register_sidebar(array(
        'name' => __('Homepage Widget', 'ares'),
        'id' => 'sidebar-banner',
        'description' => '',
        'before_widget' => '<aside id="%1$s" class="widget %2$s">',
        'after_widget' => '</aside>',
        'before_title' => '<h2>',
        'after_title' => '</h2>',
    ));

    register_sidebar(array(
        'name' => __('Sidebar', 'ares'),
        'id' => 'sidebar-1',
        'description' => '',
        'before_widget' => '<aside id="%1$s" class="widget %2$s">',
        'after_widget' => '</aside>',
        'before_title' => '<h2 class="widget-title">',
        'after_title' => '</h2><div class="avenue-underline"></div>',
    ));
    
    register_sidebar(array(
        'name' => __('Footer', 'ares'),
        'id' => 'sidebar-footer',
        'description' => '',
        'before_widget' => '<aside id="%1$s" class="' . esc_attr( of_get_option('ares_footer_columns') ) . ' widget %2$s">',
        'after_widget' => '</aside>',
        'before_title' => '<h2 class="widget-title">',
        'after_title' => '</h2><div class="avenue-underline"></div>',
    ));
}
add_action('widgets_init', 'ares_widgets_init');


add_action('optionsframework_custom_scripts', 'optionsframework_custom_scripts');

function optionsframework_custom_scripts() { ?>
    <script type="text/javascript">
        jQuery(document).ready(function() {

            jQuery('#example_showhidden').click(function() {
                jQuery('#section-example_text_hidden').fadeToggle(400);
            });

            if (jQuery('#example_showhidden:checked').val() !== undefined) {
                jQuery('#section-example_text_hidden').show();
            }

        });
    </script>
    <?php
}

add_action('wp_head', 'ares_css');
function ares_css() {
    ?>
    <style type="text/css">
        body{
            font-size: <?php echo esc_attr( of_get_option('ares_font_size') ); ?>;
            font-family: <?php echo esc_attr( of_get_option('ares_font_family', 'Josefin Sans, sans-serif') ); ?>;
        }
    </style>
    <?php
}

class ares_recent_posts_widget extends WP_Widget {

    function __construct() {
        parent::__construct(
                'ares_recent_posts_widget', __('Avenue Recent Articles', 'ares'), array('description' => __('Use this widget to display the Ares Recent Posts.', 'ares'),)
        );
    }

    // Creating widget front-end
    // This is where the action happens
    public function widget($args, $instance) {
        $title = apply_filters('widget_title', $instance['title']);

        // before and after widget arguments are defined by themes
        echo $args['before_widget'];
        if (!empty($title))
            echo $args['before_title'] . $title . $args['after_title'];

        // This is where you run the code and display the output
//        include 'inc/widget.php';
        echo ares_recent_posts();

    }

    // Widget Backend
    public function form($instance) {
        if (isset($instance['title'])) {
            $title = $instance['title'];
        } else {
            $title = __('Recent Articles', 'ares');
        }
        // Widget admin form
        ?>
        <p>
            <label for="<?php echo $this->get_field_id('title'); ?>"><?php _e('Title:', 'ares'); ?></label>
            <input class="widefat" id="<?php echo $this->get_field_id('title'); ?>" name="<?php echo $this->get_field_name('title'); ?>" type="text" value="<?php echo esc_attr($title); ?>" />             
        </p>
        <?php
    }

    // Updating widget replacing old instances with new
    public function update($new_instance, $old_instance) {
        $instance = array();
        $instance['title'] = (!empty($new_instance['title']) ) ? strip_tags($new_instance['title']) : '';
        return $instance;
    }

}

// Class sc_recent_posts_widget ends here
// Register and load the widget
function ares_load_widget() {
    register_widget('ares_recent_posts_widget');
}

add_action('widgets_init', 'ares_load_widget');

function ares_recent_posts() {
    $args = array(
        'numberposts' => '4',
        'post_status' => 'publish'
    );
    ?>
    <div id="ares_recent_posts">
        <?php $recent_posts = wp_get_recent_posts($args);
        foreach ($recent_posts as $post) { ?>
            <div class="col-sm-3">
                <div>
                    <?php $url = wp_get_attachment_url(get_post_thumbnail_id($post['ID'])); ?>
                    <img src="<?php echo $url; ?> " title="<?php echo $post['post_title']; ?>"/>
                    <div class="overlay">
                        <a href="<?php echo get_permalink($post['ID']) ?>" class="title">
                            <?php echo $post['post_title']; ?>
                        </a>
                        <?php // $date = new DateTime($post['post_date']); ?>
                        <div class="date">
                            <i class="fa fa-calendar"></i>
                            <?php echo date('M d', strtotime($post['post_date'])); ?>
                        </div>
                        <div class="author">
                            <i class="fa fa-pencil"></i>
                            <?php echo get_userdata($post['post_author'])->user_login; ?>
                        </div>
                        
                    </div>
                </div>
            </div>
    <?php } ?>
    </div>
<?php
}
function ares_slider() { ?>
<script>
    jQuery(document).ready(function($){
        jQuery('#camera_wrap_1').camera({
            height: '650px',
            loader: 'pie',
            pagination: false,
            thumbnails: false,
            fx: 'simpleFade',
            time: 4000,
            overlayer: true,
        });            
    });
</script>
    <div class="sc-slider-wrapper">
	<div class="fluid_container">
        <div class="camera_wrap" id="camera_wrap_1">

                <?php if ('' != of_get_option('ares_slide1_image', get_template_directory_uri() . '/images/ares_demo.jpg')) { ?>
                    <div data-thumb="<?php echo esc_attr( of_get_option('ares_slide1_image', get_template_directory_uri() . '/images/ares_demo.jpg') ) ;?>" data-src="<?php echo esc_attr( of_get_option('ares_slide1_image', get_template_directory_uri() . '/images/ares_demo.jpg') ) ?>">
                        <div class="camera_caption fadeFromBottom">
                            <span><?php echo esc_attr( of_get_option('ares_slide1_text','Ares: Responsive Multi-purpose WordPress Theme') );?></span>
                        </div>
                    </div>
                <?php } ?>            
            
                <?php if ('' != of_get_option('ares_slide2_image', get_template_directory_uri() . '/images/ares_demo.jpg')) { ?>
                      <div data-thumb="<?php echo esc_attr( of_get_option('ares_slide2_image', get_template_directory_uri() . '/images/ares_demo.jpg') ); ?>" data-src="<?php echo esc_attr( of_get_option('ares_slide2_image', get_template_directory_uri() . '/images/ares_demo.jpg') ); ?>">
                        <div class="camera_caption fadeFromBottom">
                            <span><?php echo esc_attr( of_get_option('ares_slide2_text','Ares: Responsive Multi-purpose WordPress Theme') );?></span>
                        </div>
                    </div>
                <?php } ?>   
            
                <?php if ('' != of_get_option('ares_slide3_image', get_template_directory_uri() . '/images/ares_demo.jpg')) { ?>     
                    <div data-thumb="<?php echo esc_attr( of_get_option('ares_slide3_image', get_template_directory_uri() . '/images/ares_demo.jpg') );?>" data-src="<?php echo esc_attr( of_get_option('ares_slide3_image', get_template_directory_uri() . '/images/ares_demo.jpg') ); ?>">
                        <div class="camera_caption fadeFromBottom">
                            <span><?php echo esc_attr( of_get_option('ares_slide3_text','Ares: Responsive Multi-purpose WordPress Theme') );?></span>
                        </div>
                    </div>
                <?php } ?>      
        </div><!-- #camera_wrap_1 -->
        </div>
    </div>
    <?php
}

function ares_ctas() { ?>
    <div id="site-cta" class="<?php echo of_get_option('ares_slider_bool', 'yes') == 'yes' ? '' : 'no-slider' ?>"><!-- #CTA boxes -->
        <div class="row">
        
        <div class="col-md-4 site-cta">
            <div class="center">
                <i class="<?php echo esc_attr( of_get_option('ares_cta1_icon', 'fa fa-desktop') ); ?> animated"></i>
            </div>
                
            <h3><?php echo esc_attr( of_get_option('ares_cta1_title', 'Box 1 Title') ); ?></h3>
            <p>
                <?php echo of_get_option('ares_cta1_text', 'Box 1 Text. Input anything you want here'); ?>
            </p>
            <p class="">
                <a href="<?php echo esc_attr( of_get_option('ares_cta1_url') ) ?>" class=""><?php echo of_get_option('ares_cta1_button_text', 'Click Here');  ?></a>
            </p>                                
                
        </div>
            <div class="col-md-4 site-cta">
                <div class="center">
                    <i class="<?php echo esc_attr( of_get_option('ares_cta2_icon', 'fa fa-tachometer') ); ?>"></i>
                </div>

                <h3><?php echo of_get_option('ares_cta2_title', 'Box 2 Title') ?></h3>
                <p>
                    <?php echo of_get_option('ares_cta2_text', 'Box 2 Text. Input anything you want here'); ?>
                </p>
                <p class="">
                    <a href="<?php echo esc_attr( of_get_option('ares_cta2_url') ); ?>" class=""><?php echo of_get_option('ares_cta2_button_text', 'Click Here');  ?></a>
                </p>                                

            </div>
            <div class="col-md-4 site-cta">
                <div class="center">
                    <i class="<?php echo esc_attr( of_get_option('ares_cta3_icon', 'fa fa-rocket') ); ?>"></i>
                </div>

                <h3><?php echo of_get_option('ares_cta3_title', 'Box 3 Title') ?></h3>
                <p>
                    <?php echo of_get_option('ares_cta3_text', 'Box 3 Text. Input anything you want here') ?>
                </p>
                <p class="">
                    <a href="<?php echo esc_attr( of_get_option('ares_cta3_url') ) ?>" class=""><?php echo of_get_option('ares_cta3_button_text', 'Click Here');  ?></a>
                </p>

            </div>
        </div>
        
    </div><!-- #CTA boxes -->
    <div class="clear"></div>
    <?php
}

function ares_banner() {
    ?>
    <div id="top-banner" class="full-banner col-md-12">
        <div class="row">
            <div class="col-md-12">
                <div class="top-banner-text">
                    <?php get_sidebar('banner'); ?>
                </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
    <?php
}

function ares_toolbar() {
    if ('no' != of_get_option('ares_headerbar_bool', 'yes')) {
        ?>
        <div id="site-toolbar">
            <div class="row "> 
                    <div class="col-xs-6 social-bar">

                        <?php if ('' != of_get_option('ares_facebook_url')) : ?>
                            <a href="<?php echo esc_attr( of_get_option('ares_facebook_url') ) ?>" target="_blank" class="icon-facebook animated fadeInDown">
                                <i class="fa fa-facebook"></i>
                            </a>
                        <?php endif; ?>

                        <?php if ('' != of_get_option('ares_twitter_url')) : ?>
                        <a href="<?php echo esc_attr( of_get_option('ares_twitter_url') ) ?>" target="_blank" class="icon-twitter animated fadeInDown">
                                <i class="fa fa-twitter"></i>                            
                            </a>
                        <?php endif; ?>


                        <?php if ('' != of_get_option('ares_linkedin_url')) : ?>
                            <a href="<?php echo esc_attr( of_get_option('ares_linkedin_url') ) ?>" target="_blank" class="icon-linkedin animated fadeInDown">
                                <i class="fa fa-linkedin"></i>                            
                            </a>
                        <?php endif; ?>


                        <?php if ('' != of_get_option('ares_gplus_url')) : ?>
                            <a href="<?php echo esc_attr( of_get_option('ares_gplus_url') ) ?>" target="_blank" class="icon-gplus animated fadeInDown">
                                <i class="fa fa-google-plus"></i>                            
                            </a>
                        <?php endif; ?>

                    </div>                    
                    
                    <div class="col-xs-6 contact-bar">
                        <?php echo get_sidebar('header-right'); ?>

                    </div>


                
            </div>
        </div>
        <?php
    }
}

function ares_close() { ?>
    <i class="scroll-top fa fa-chevron-up"></i>
    <footer id="colophon" class="site-footer " role="contentinfo">
        <div class="footer-boxes">
            <div class="row ">
                <div class="col-md-12">
                    <?php get_sidebar('footer'); ?>
                </div>            
            </div>        
        </div>
        <div class="site-info">
            <div class="row ">
                <div class="col-xs-6 text-left">
                    <?php echo of_get_option('ares_footer_text');?>
                </div>
                <div class="col-xs-6 text-right">
                    <a href="http://smartcatdesign.net/" rel="designer">
                        <img src="<?php echo get_template_directory_uri() . '/inc/images/cat_logo.png'?>" width="20px"/>
                        Design by SmartCat
                    </a>                     
                    
                </div>              
            </div>
        </div><!-- .site-info -->
    </footer><!-- #colophon -->
    </div><!-- #page -->    
    <?php 

}
