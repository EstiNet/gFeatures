<?php
/*
 * Posts Template
 * @author bilal hassan <info@smartcatdesign.net>
 * 
 */
?>

<div class="item-post">
    <div class="post-thumb col-md-4">
        <a href="<?php the_permalink(); ?>">
            <?php the_post_thumbnail('large'); ?>
        </a>
    </div>
    <div class="col-md-8">
        <h2 class="post-title">
            <a href="<?php the_permalink(); ?>">
                <?php the_title(); ?>
            </a>
        </h2>
        <div class="post-content">
            <?php echo wp_trim_words( $post->post_content, 50); ?>
        </div>
        <div class="text-right">
            <a class="button button-primary" href="<?php the_permalink(); ?>">Read More</a>
        </div>                        
    </div>
</div>