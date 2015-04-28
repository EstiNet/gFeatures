<?php

/**
 * A unique identifier is defined to store the options in the database and reference them from the theme.
 * By default it uses the theme name, in lowercase and without spaces, but this can be changed if needed.
 * If the identifier changes, it'll appear as if the options have been reset.
 */
function optionsframework_option_name() {

    // This gets the theme name from the stylesheet
    $themename = wp_get_theme();
    $themename = preg_replace("/\W/", "_", strtolower($themename));

    $optionsframework_settings = get_option('optionsframework');
    $optionsframework_settings['id'] = $themename;
    update_option('optionsframework', $optionsframework_settings);
}

/**
 * Defines an array of options that will be used to generate the settings page and be saved in the database.
 * When creating the 'id' fields, make sure to use all lowercase and no spaces.
 *
 * If you are making your theme translatable, you should replace 'ares'
 * with the actual text domain for your theme.  Read more:
 * http://codex.wordpress.org/Function_Reference/load_theme_textdomain
 */
function optionsframework_options() {

    // Test data
    $test_array = array(
        'one' => __('One', 'ares'),
        'two' => __('Two', 'ares'),
        'three' => __('Three', 'ares'),
        'four' => __('Four', 'ares'),
        'five' => __('Five', 'ares')
    );
    $footer_columns = array(
        'col-md-12' => __('One', 'ares'),
        'col-md-6' => __('Two', 'ares'),
        'col-md-4' => __('Three', 'ares'),
        'col-md-3' => __('Four', 'ares'),
    );
    $icon_array = array(
        'fa fa-automobile' => __('automobile', 'ares'), 'fa fa-bank' => __('bank', 'ares'), 'fa fa-behance' => __('behance', 'ares'), 'fa fa-behance-square' => __('behance-square', 'ares'), 'fa fa-bomb' => __('bomb', 'ares'), 'fa fa-building' => __('building', 'ares'), 'fa fa-cab' => __('cab', 'ares'), 'fa fa-car' => __('car', 'ares'), 'fa fa-child' => __('child', 'ares'), 'fa fa-circle-o-notch' => __('circle-o-notch', 'ares'), 'fa fa-circle-thin' => __('circle-thin', 'ares'), 'fa fa-codepen' => __('codepen', 'ares'), 'fa fa-cube' => __('cube', 'ares'), 'fa fa-cubes' => __('cubes', 'ares'), 'fa fa-database' => __('database', 'ares'), 'fa fa-delicious' => __('delicious', 'ares'), 'fa fa-deviantart' => __('deviantart', 'ares'), 'fa fa-digg' => __('digg', 'ares'), 'fa fa-drupal' => __('drupal', 'ares'), 'fa fa-empire' => __('empire', 'ares'), 'fa fa-envelope-square' => __('envelope-square', 'ares'), 'fa fa-fax' => __('fax', 'ares'), 'fa fa-file-archive-o' => __('file-archive-o', 'ares'), 'fa fa-file-audio-o' => __('file-audio-o', 'ares'), 'fa fa-file-code-o' => __('file-code-o', 'ares'), 'fa fa-file-excel-o' => __('file-excel-o', 'ares'), 'fa fa-file-image-o' => __('file-image-o', 'ares'), 'fa fa-file-movie-o' => __('file-movie-o', 'ares'), 'fa fa-file-pdf-o' => __('file-pdf-o', 'ares'), 'fa fa-file-photo-o' => __('file-photo-o', 'ares'), 'fa fa-file-picture-o' => __('file-picture-o', 'ares'), 'fa fa-file-powerpoint-o' => __('file-powerpoint-o', 'ares'), 'fa fa-file-sound-o' => __('file-sound-o', 'ares'), 'fa fa-file-video-o' => __('file-video-o', 'ares'), 'fa fa-file-word-o' => __('file-word-o', 'ares'), 'fa fa-file-zip-o' => __('file-zip-o', 'ares'), 'fa fa-ge' => __('ge', 'ares'), 'fa fa-git' => __('git', 'ares'), 'fa fa-git-square' => __('git-square', 'ares'), 'fa fa-google' => __('google', 'ares'), 'fa fa-graduation-cap' => __('graduation-cap', 'ares'), 'fa fa-hacker-news' => __('hacker-news', 'ares'), 'fa fa-header' => __('header', 'ares'), 'fa fa-history' => __('history', 'ares'), 'fa fa-institution' => __('institution', 'ares'), 'fa fa-joomla' => __('joomla', 'ares'), 'fa fa-jsfiddle' => __('jsfiddle', 'ares'), 'fa fa-language' => __('language', 'ares'), 'fa fa-life-bouy' => __('life-bouy', 'ares'), 'fa fa-life-ring' => __('life-ring', 'ares'), 'fa fa-life-saver' => __('life-saver', 'ares'), 'fa fa-mortar-board' => __('mortar-board', 'ares'), 'fa fa-openid' => __('openid', 'ares'), 'fa fa-paper-plane' => __('paper-plane', 'ares'), 'fa fa-paper-plane-o' => __('paper-plane-o', 'ares'), 'fa fa-paragraph' => __('paragraph', 'ares'), 'fa fa-paw' => __('paw', 'ares'), 'fa fa-pied-piper' => __('pied-piper', 'ares'), 'fa fa-pied-piper-alt' => __('pied-piper-alt', 'ares'), 'fa fa-pied-piper-square' => __('pied-piper-square', 'ares'), 'fa fa-qq' => __('qq', 'ares'), 'fa fa-ra' => __('ra', 'ares'), 'fa fa-rebel' => __('rebel', 'ares'), 'fa fa-recycle' => __('recycle', 'ares'), 'fa fa-reddit' => __('reddit', 'ares'), 'fa fa-reddit-square' => __('reddit-square', 'ares'), 'fa fa-send' => __('send', 'ares'), 'fa fa-send-o' => __('send-o', 'ares'), 'fa fa-share-alt' => __('share-alt', 'ares'), 'fa fa-share-alt-square' => __('share-alt-square', 'ares'), 'fa fa-slack' => __('slack', 'ares'), 'fa fa-sliders' => __('sliders', 'ares'), 'fa fa-soundcloud' => __('soundcloud', 'ares'), 'fa fa-space-shuttle' => __('space-shuttle', 'ares'), 'fa fa-spoon' => __('spoon', 'ares'), 'fa fa-spotify' => __('spotify', 'ares'), 'fa fa-steam' => __('steam', 'ares'), 'fa fa-steam-square' => __('steam-square', 'ares'), 'fa fa-stumbleupon' => __('stumbleupon', 'ares'), 'fa fa-stumbleupon-circle' => __('stumbleupon-circle', 'ares'), 'fa fa-support' => __('support', 'ares'), 'fa fa-taxi' => __('taxi', 'ares'), 'fa fa-tencent-weibo' => __('tencent-weibo', 'ares'), 'fa fa-tree' => __('tree', 'ares'), 'fa fa-university' => __('university', 'ares'), 'fa fa-vine' => __('vine', 'ares'), 'fa fa-wechat' => __('wechat', 'ares'), 'fa fa-weixin' => __('weixin', 'ares'), 'fa fa-wordpress' => __('wordpress', 'ares'), 'fa fa-yahoo' => __('yahoo', 'ares'), 'fa fa-adjust' => __('adjust', 'ares'), 'fa fa-anchor' => __('anchor', 'ares'), 'fa fa-archive' => __('archive', 'ares'), 'fa fa-arrows' => __('arrows', 'ares'), 'fa fa-arrows-h' => __('arrows-h', 'ares'), 'fa fa-arrows-v' => __('arrows-v', 'ares'), 'fa fa-asterisk' => __('asterisk', 'ares'), 'fa fa-automobile' => __('automobile', 'ares'), 'fa fa-ban' => __('ban', 'ares'), 'fa fa-bank' => __('bank', 'ares'), 'fa fa-bar-chart-o' => __('bar-chart-o', 'ares'), 'fa fa-barcode' => __('barcode', 'ares'), 'fa fa-bars' => __('bars', 'ares'), 'fa fa-beer' => __('beer', 'ares'), 'fa fa-bell' => __('bell', 'ares'), 'fa fa-bell-o' => __('bell-o', 'ares'), 'fa fa-bolt' => __('bolt', 'ares'), 'fa fa-bomb' => __('bomb', 'ares'), 'fa fa-book' => __('book', 'ares'), 'fa fa-bookmark' => __('bookmark', 'ares'), 'fa fa-bookmark-o' => __('bookmark-o', 'ares'), 'fa fa-briefcase' => __('briefcase', 'ares'), 'fa fa-bug' => __('bug', 'ares'), 'fa fa-building' => __('building', 'ares'), 'fa fa-building-o' => __('building-o', 'ares'), 'fa fa-bullhorn' => __('bullhorn', 'ares'), 'fa fa-bullseye' => __('bullseye', 'ares'), 'fa fa-cab' => __('cab', 'ares'), 'fa fa-calendar' => __('calendar', 'ares'), 'fa fa-calendar-o' => __('calendar-o', 'ares'), 'fa fa-camera' => __('camera', 'ares'), 'fa fa-camera-retro' => __('camera-retro', 'ares'), 'fa fa-car' => __('car', 'ares'), 'fa fa-caret-square-o-down' => __('caret-square-o-down', 'ares'), 'fa fa-caret-square-o-left' => __('caret-square-o-left', 'ares'), 'fa fa-caret-square-o-right' => __('caret-square-o-right', 'ares'), 'fa fa-caret-square-o-up' => __('caret-square-o-up', 'ares'), 'fa fa-certificate' => __('certificate', 'ares'), 'fa fa-check' => __('check', 'ares'), 'fa fa-check-circle' => __('check-circle', 'ares'), 'fa fa-check-circle-o' => __('check-circle-o', 'ares'), 'fa fa-check-square' => __('check-square', 'ares'), 'fa fa-check-square-o' => __('check-square-o', 'ares'), 'fa fa-child' => __('child', 'ares'), 'fa fa-circle' => __('circle', 'ares'), 'fa fa-circle-o' => __('circle-o', 'ares'), 'fa fa-circle-o-notch' => __('circle-o-notch', 'ares'), 'fa fa-circle-thin' => __('circle-thin', 'ares'), 'fa fa-clock-o' => __('clock-o', 'ares'), 'fa fa-cloud' => __('cloud', 'ares'), 'fa fa-cloud-download' => __('cloud-download', 'ares'), 'fa fa-cloud-upload' => __('cloud-upload', 'ares'), 'fa fa-code' => __('code', 'ares'), 'fa fa-code-fork' => __('code-fork', 'ares'), 'fa fa-coffee' => __('coffee', 'ares'), 'fa fa-cog' => __('cog', 'ares'), 'fa fa-cogs' => __('cogs', 'ares'), 'fa fa-comment' => __('comment', 'ares'), 'fa fa-comment-o' => __('comment-o', 'ares'), 'fa fa-comments' => __('comments', 'ares'), 'fa fa-comments-o' => __('comments-o', 'ares'), 'fa fa-compass' => __('compass', 'ares'), 'fa fa-credit-card' => __('credit-card', 'ares'), 'fa fa-crop' => __('crop', 'ares'), 'fa fa-crosshairs' => __('crosshairs', 'ares'), 'fa fa-cube' => __('cube', 'ares'), 'fa fa-cubes' => __('cubes', 'ares'), 'fa fa-cutlery' => __('cutlery', 'ares'), 'fa fa-dashboard' => __('dashboard', 'ares'), 'fa fa-database' => __('database', 'ares'), 'fa fa-desktop' => __('desktop', 'ares'), 'fa fa-dot-circle-o' => __('dot-circle-o', 'ares'), 'fa fa-download' => __('download', 'ares'), 'fa fa-edit' => __('edit', 'ares'), 'fa fa-ellipsis-h' => __('ellipsis-h', 'ares'), 'fa fa-ellipsis-v' => __('ellipsis-v', 'ares'), 'fa fa-envelope' => __('envelope', 'ares'), 'fa fa-envelope-o' => __('envelope-o', 'ares'), 'fa fa-envelope-square' => __('envelope-square', 'ares'), 'fa fa-eraser' => __('eraser', 'ares'), 'fa fa-exchange' => __('exchange', 'ares'), 'fa fa-exclamation' => __('exclamation', 'ares'), 'fa fa-exclamation-circle' => __('exclamation-circle', 'ares'), 'fa fa-exclamation-triangle' => __('exclamation-triangle', 'ares'), 'fa fa-external-link' => __('external-link', 'ares'), 'fa fa-external-link-square' => __('external-link-square', 'ares'), 'fa fa-eye' => __('eye', 'ares'), 'fa fa-eye-slash' => __('eye-slash', 'ares'), 'fa fa-fax' => __('fax', 'ares'), 'fa fa-female' => __('female', 'ares'), 'fa fa-fighter-jet' => __('fighter-jet', 'ares'), 'fa fa-file-archive-o' => __('file-archive-o', 'ares'), 'fa fa-file-audio-o' => __('file-audio-o', 'ares'), 'fa fa-file-code-o' => __('file-code-o', 'ares'), 'fa fa-file-excel-o' => __('file-excel-o', 'ares'), 'fa fa-file-image-o' => __('file-image-o', 'ares'), 'fa fa-file-movie-o' => __('file-movie-o', 'ares'), 'fa fa-file-pdf-o' => __('file-pdf-o', 'ares'), 'fa fa-file-photo-o' => __('file-photo-o', 'ares'), 'fa fa-file-picture-o' => __('file-picture-o', 'ares'), 'fa fa-file-powerpoint-o' => __('file-powerpoint-o', 'ares'), 'fa fa-file-sound-o' => __('file-sound-o', 'ares'), 'fa fa-file-video-o' => __('file-video-o', 'ares'), 'fa fa-file-word-o' => __('file-word-o', 'ares'), 'fa fa-file-zip-o' => __('file-zip-o', 'ares'), 'fa fa-film' => __('film', 'ares'), 'fa fa-filter' => __('filter', 'ares'), 'fa fa-fire' => __('fire', 'ares'), 'fa fa-fire-extinguisher' => __('fire-extinguisher', 'ares'), 'fa fa-flag' => __('flag', 'ares'), 'fa fa-flag-checkered' => __('flag-checkered', 'ares'), 'fa fa-flag-o' => __('flag-o', 'ares'), 'fa fa-flash' => __('flash', 'ares'), 'fa fa-flask' => __('flask', 'ares'), 'fa fa-folder' => __('folder', 'ares'), 'fa fa-folder-o' => __('folder-o', 'ares'), 'fa fa-folder-open' => __('folder-open', 'ares'), 'fa fa-folder-open-o' => __('folder-open-o', 'ares'), 'fa fa-frown-o' => __('frown-o', 'ares'), 'fa fa-gamepad' => __('gamepad', 'ares'), 'fa fa-gavel' => __('gavel', 'ares'), 'fa fa-gear' => __('gear', 'ares'), 'fa fa-gears' => __('gears', 'ares'), 'fa fa-gift' => __('gift', 'ares'), 'fa fa-glass' => __('glass', 'ares'), 'fa fa-globe' => __('globe', 'ares'), 'fa fa-graduation-cap' => __('graduation-cap', 'ares'), 'fa fa-group' => __('group', 'ares'), 'fa fa-hdd-o' => __('hdd-o', 'ares'), 'fa fa-headphones' => __('headphones', 'ares'), 'fa fa-heart' => __('heart', 'ares'), 'fa fa-heart-o' => __('heart-o', 'ares'), 'fa fa-history' => __('history', 'ares'), 'fa fa-home' => __('home', 'ares'), 'fa fa-image' => __('image', 'ares'), 'fa fa-inbox' => __('inbox', 'ares'), 'fa fa-info' => __('info', 'ares'), 'fa fa-info-circle' => __('info-circle', 'ares'), 'fa fa-institution' => __('institution', 'ares'), 'fa fa-key' => __('key', 'ares'), 'fa fa-keyboard-o' => __('keyboard-o', 'ares'), 'fa fa-language' => __('language', 'ares'), 'fa fa-laptop' => __('laptop', 'ares'), 'fa fa-leaf' => __('leaf', 'ares'), 'fa fa-legal' => __('legal', 'ares'), 'fa fa-lemon-o' => __('lemon-o', 'ares'), 'fa fa-level-down' => __('level-down', 'ares'), 'fa fa-level-up' => __('level-up', 'ares'), 'fa fa-life-bouy' => __('life-bouy', 'ares'), 'fa fa-life-ring' => __('life-ring', 'ares'), 'fa fa-life-saver' => __('life-saver', 'ares'), 'fa fa-lightbulb-o' => __('lightbulb-o', 'ares'), 'fa fa-location-arrow' => __('location-arrow', 'ares'), 'fa fa-lock' => __('lock', 'ares'), 'fa fa-magic' => __('magic', 'ares'), 'fa fa-magnet' => __('magnet', 'ares'), 'fa fa-mail-forward' => __('mail-forward', 'ares'), 'fa fa-mail-reply' => __('mail-reply', 'ares'), 'fa fa-mail-reply-all' => __('mail-reply-all', 'ares'), 'fa fa-male' => __('male', 'ares'), 'fa fa-map-marker' => __('map-marker', 'ares'), 'fa fa-meh-o' => __('meh-o', 'ares'), 'fa fa-microphone' => __('microphone', 'ares'), 'fa fa-microphone-slash' => __('microphone-slash', 'ares'), 'fa fa-minus' => __('minus', 'ares'), 'fa fa-minus-circle' => __('minus-circle', 'ares'), 'fa fa-minus-square' => __('minus-square', 'ares'), 'fa fa-minus-square-o' => __('minus-square-o', 'ares'), 'fa fa-mobile' => __('mobile', 'ares'), 'fa fa-mobile-phone' => __('mobile-phone', 'ares'), 'fa fa-money' => __('money', 'ares'), 'fa fa-moon-o' => __('moon-o', 'ares'), 'fa fa-mortar-board' => __('mortar-board', 'ares'), 'fa fa-music' => __('music', 'ares'), 'fa fa-navicon' => __('navicon', 'ares'), 'fa fa-paper-plane' => __('paper-plane', 'ares'), 'fa fa-paper-plane-o' => __('paper-plane-o', 'ares'), 'fa fa-paw' => __('paw', 'ares'), 'fa fa-pencil' => __('pencil', 'ares'), 'fa fa-pencil-square' => __('pencil-square', 'ares'), 'fa fa-pencil-square-o' => __('pencil-square-o', 'ares'), 'fa fa-phone' => __('phone', 'ares'), 'fa fa-phone-square' => __('phone-square', 'ares'), 'fa fa-photo' => __('photo', 'ares'), 'fa fa-picture-o' => __('picture-o', 'ares'), 'fa fa-plane' => __('plane', 'ares'), 'fa fa-plus' => __('plus', 'ares'), 'fa fa-plus-circle' => __('plus-circle', 'ares'), 'fa fa-plus-square' => __('plus-square', 'ares'), 'fa fa-plus-square-o' => __('plus-square-o', 'ares'), 'fa fa-power-off' => __('power-off', 'ares'), 'fa fa-print' => __('print', 'ares'), 'fa fa-puzzle-piece' => __('puzzle-piece', 'ares'), 'fa fa-qrcode' => __('qrcode', 'ares'), 'fa fa-question' => __('question', 'ares'), 'fa fa-question-circle' => __('question-circle', 'ares'), 'fa fa-quote-left' => __('quote-left', 'ares'), 'fa fa-quote-right' => __('quote-right', 'ares'), 'fa fa-random' => __('random', 'ares'), 'fa fa-recycle' => __('recycle', 'ares'), 'fa fa-refresh' => __('refresh', 'ares'), 'fa fa-reorder' => __('reorder', 'ares'), 'fa fa-reply' => __('reply', 'ares'), 'fa fa-reply-all' => __('reply-all', 'ares'), 'fa fa-retweet' => __('retweet', 'ares'), 'fa fa-road' => __('road', 'ares'), 'fa fa-rocket' => __('rocket', 'ares'), 'fa fa-rss' => __('rss', 'ares'), 'fa fa-rss-square' => __('rss-square', 'ares'), 'fa fa-search' => __('search', 'ares'), 'fa fa-search-minus' => __('search-minus', 'ares'), 'fa fa-search-plus' => __('search-plus', 'ares'), 'fa fa-send' => __('send', 'ares'), 'fa fa-send-o' => __('send-o', 'ares'), 'fa fa-share' => __('share', 'ares'), 'fa fa-share-alt' => __('share-alt', 'ares'), 'fa fa-share-alt-square' => __('share-alt-square', 'ares'), 'fa fa-share-square' => __('share-square', 'ares'), 'fa fa-share-square-o' => __('share-square-o', 'ares'), 'fa fa-shield' => __('shield', 'ares'), 'fa fa-shopping-cart' => __('shopping-cart', 'ares'), 'fa fa-sign-in' => __('sign-in', 'ares'), 'fa fa-sign-out' => __('sign-out', 'ares'), 'fa fa-signal' => __('signal', 'ares'), 'fa fa-sitemap' => __('sitemap', 'ares'), 'fa fa-sliders' => __('sliders', 'ares'), 'fa fa-smile-o' => __('smile-o', 'ares'), 'fa fa-sort' => __('sort', 'ares'), 'fa fa-sort-alpha-asc' => __('sort-alpha-asc', 'ares'), 'fa fa-sort-alpha-desc' => __('sort-alpha-desc', 'ares'), 'fa fa-sort-amount-asc' => __('sort-amount-asc', 'ares'), 'fa fa-sort-amount-desc' => __('sort-amount-desc', 'ares'), 'fa fa-sort-asc' => __('sort-asc', 'ares'), 'fa fa-sort-desc' => __('sort-desc', 'ares'), 'fa fa-sort-down' => __('sort-down', 'ares'), 'fa fa-sort-numeric-asc' => __('sort-numeric-asc', 'ares'), 'fa fa-sort-numeric-desc' => __('sort-numeric-desc', 'ares'), 'fa fa-sort-up' => __('sort-up', 'ares'), 'fa fa-space-shuttle' => __('space-shuttle', 'ares'), 'fa fa-spinner' => __('spinner', 'ares'), 'fa fa-spoon' => __('spoon', 'ares'), 'fa fa-square' => __('square', 'ares'), 'fa fa-square-o' => __('square-o', 'ares'), 'fa fa-star' => __('star', 'ares'), 'fa fa-star-half' => __('star-half', 'ares'), 'fa fa-star-half-empty' => __('star-half-empty', 'ares'), 'fa fa-star-half-full' => __('star-half-full', 'ares'), 'fa fa-star-half-o' => __('star-half-o', 'ares'), 'fa fa-star-o' => __('star-o', 'ares'), 'fa fa-suitcase' => __('suitcase', 'ares'), 'fa fa-sun-o' => __('sun-o', 'ares'), 'fa fa-support' => __('support', 'ares'), 'fa fa-tablet' => __('tablet', 'ares'), 'fa fa-tachometer' => __('tachometer', 'ares'), 'fa fa-tag' => __('tag', 'ares'), 'fa fa-tags' => __('tags', 'ares'), 'fa fa-tasks' => __('tasks', 'ares'), 'fa fa-taxi' => __('taxi', 'ares'), 'fa fa-terminal' => __('terminal', 'ares'), 'fa fa-thumb-tack' => __('thumb-tack', 'ares'), 'fa fa-thumbs-down' => __('thumbs-down', 'ares'), 'fa fa-thumbs-o-down' => __('thumbs-o-down', 'ares'), 'fa fa-thumbs-o-up' => __('thumbs-o-up', 'ares'), 'fa fa-thumbs-up' => __('thumbs-up', 'ares'), 'fa fa-ticket' => __('ticket', 'ares'), 'fa fa-times' => __('times', 'ares'), 'fa fa-times-circle' => __('times-circle', 'ares'), 'fa fa-times-circle-o' => __('times-circle-o', 'ares'), 'fa fa-tint' => __('tint', 'ares'), 'fa fa-toggle-down' => __('toggle-down', 'ares'), 'fa fa-toggle-left' => __('toggle-left', 'ares'), 'fa fa-toggle-right' => __('toggle-right', 'ares'), 'fa fa-toggle-up' => __('toggle-up', 'ares'), 'fa fa-trash-o' => __('trash-o', 'ares'), 'fa fa-tree' => __('tree', 'ares'), 'fa fa-trophy' => __('trophy', 'ares'), 'fa fa-truck' => __('truck', 'ares'), 'fa fa-umbrella' => __('umbrella', 'ares'), 'fa fa-university' => __('university', 'ares'), 'fa fa-unlock' => __('unlock', 'ares'), 'fa fa-unlock-alt' => __('unlock-alt', 'ares'), 'fa fa-unsorted' => __('unsorted', 'ares'), 'fa fa-upload' => __('upload', 'ares'), 'fa fa-user' => __('user', 'ares'), 'fa fa-users' => __('users', 'ares'), 'fa fa-video-camera' => __('video-camera', 'ares'), 'fa fa-volume-down' => __('volume-down', 'ares'), 'fa fa-volume-off' => __('volume-off', 'ares'), 'fa fa-volume-up' => __('volume-up', 'ares'), 'fa fa-warning' => __('warning', 'ares'), 'fa fa-wheelchair' => __('wheelchair', 'ares'), 'fa fa-wrench' => __('wrench', 'ares'), 'fa fa-file' => __('file', 'ares'), 'fa fa-file-archive-o' => __('file-archive-o', 'ares'), 'fa fa-file-audio-o' => __('file-audio-o', 'ares'), 'fa fa-file-code-o' => __('file-code-o', 'ares'), 'fa fa-file-excel-o' => __('file-excel-o', 'ares'), 'fa fa-file-image-o' => __('file-image-o', 'ares'), 'fa fa-file-movie-o' => __('file-movie-o', 'ares'), 'fa fa-file-o' => __('file-o', 'ares'), 'fa fa-file-pdf-o' => __('file-pdf-o', 'ares'), 'fa fa-file-photo-o' => __('file-photo-o', 'ares'), 'fa fa-file-picture-o' => __('file-picture-o', 'ares'), 'fa fa-file-powerpoint-o' => __('file-powerpoint-o', 'ares'), 'fa fa-file-sound-o' => __('file-sound-o', 'ares'), 'fa fa-file-text' => __('file-text', 'ares'), 'fa fa-file-text-o' => __('file-text-o', 'ares'), 'fa fa-file-video-o' => __('file-video-o', 'ares'), 'fa fa-file-word-o' => __('file-word-o', 'ares'), 'fa fa-file-zip-o' => __('file-zip-o', 'ares'), 'fa fa-info-circle fa-lg fa-li' => __('info-circle fa-lg fa-li', 'ares'), 'fa fa-circle-o-notch' => __('circle-o-notch', 'ares'), 'fa fa-cog' => __('cog', 'ares'), 'fa fa-gear' => __('gear', 'ares'), 'fa fa-refresh' => __('refresh', 'ares'), 'fa fa-spinner' => __('spinner', 'ares'), 'fa fa-check-square' => __('check-square', 'ares'), 'fa fa-check-square-o' => __('check-square-o', 'ares'), 'fa fa-circle' => __('circle', 'ares'), 'fa fa-circle-o' => __('circle-o', 'ares'), 'fa fa-dot-circle-o' => __('dot-circle-o', 'ares'), 'fa fa-minus-square' => __('minus-square', 'ares'), 'fa fa-minus-square-o' => __('minus-square-o', 'ares'), 'fa fa-plus-square' => __('plus-square', 'ares'), 'fa fa-plus-square-o' => __('plus-square-o', 'ares'), 'fa fa-square' => __('square', 'ares'), 'fa fa-square-o' => __('square-o', 'ares'), 'fa fa-bitcoin' => __('bitcoin', 'ares'), 'fa fa-btc' => __('btc', 'ares'), 'fa fa-cny' => __('cny', 'ares'), 'fa fa-dollar' => __('dollar', 'ares'), 'fa fa-eur' => __('eur', 'ares'), 'fa fa-euro' => __('euro', 'ares'), 'fa fa-gbp' => __('gbp', 'ares'), 'fa fa-inr' => __('inr', 'ares'), 'fa fa-jpy' => __('jpy', 'ares'), 'fa fa-krw' => __('krw', 'ares'), 'fa fa-money' => __('money', 'ares'), 'fa fa-rmb' => __('rmb', 'ares'), 'fa fa-rouble' => __('rouble', 'ares'), 'fa fa-rub' => __('rub', 'ares'), 'fa fa-ruble' => __('ruble', 'ares'), 'fa fa-rupee' => __('rupee', 'ares'), 'fa fa-try' => __('try', 'ares'), 'fa fa-turkish-lira' => __('turkish-lira', 'ares'), 'fa fa-usd' => __('usd', 'ares'), 'fa fa-won' => __('won', 'ares'), 'fa fa-yen' => __('yen', 'ares'), 'fa fa-align-center' => __('align-center', 'ares'), 'fa fa-align-justify' => __('align-justify', 'ares'), 'fa fa-align-left' => __('align-left', 'ares'), 'fa fa-align-right' => __('align-right', 'ares'), 'fa fa-bold' => __('bold', 'ares'), 'fa fa-chain' => __('chain', 'ares'), 'fa fa-chain-broken' => __('chain-broken', 'ares'), 'fa fa-clipboard' => __('clipboard', 'ares'), 'fa fa-columns' => __('columns', 'ares'), 'fa fa-copy' => __('copy', 'ares'), 'fa fa-cut' => __('cut', 'ares'), 'fa fa-dedent' => __('dedent', 'ares'), 'fa fa-eraser' => __('eraser', 'ares'), 'fa fa-file' => __('file', 'ares'), 'fa fa-file-o' => __('file-o', 'ares'), 'fa fa-file-text' => __('file-text', 'ares'), 'fa fa-file-text-o' => __('file-text-o', 'ares'), 'fa fa-files-o' => __('files-o', 'ares'), 'fa fa-floppy-o' => __('floppy-o', 'ares'), 'fa fa-font' => __('font', 'ares'), 'fa fa-header' => __('header', 'ares'), 'fa fa-indent' => __('indent', 'ares'), 'fa fa-italic' => __('italic', 'ares'), 'fa fa-link' => __('link', 'ares'), 'fa fa-list' => __('list', 'ares'), 'fa fa-list-alt' => __('list-alt', 'ares'), 'fa fa-list-ol' => __('list-ol', 'ares'), 'fa fa-list-ul' => __('list-ul', 'ares'), 'fa fa-outdent' => __('outdent', 'ares'), 'fa fa-paperclip' => __('paperclip', 'ares'), 'fa fa-paragraph' => __('paragraph', 'ares'), 'fa fa-paste' => __('paste', 'ares'), 'fa fa-repeat' => __('repeat', 'ares'), 'fa fa-rotate-left' => __('rotate-left', 'ares'), 'fa fa-rotate-right' => __('rotate-right', 'ares'), 'fa fa-save' => __('save', 'ares'), 'fa fa-scissors' => __('scissors', 'ares'), 'fa fa-strikethrough' => __('strikethrough', 'ares'), 'fa fa-subscript' => __('subscript', 'ares'), 'fa fa-superscript' => __('superscript', 'ares'), 'fa fa-table' => __('table', 'ares'), 'fa fa-text-height' => __('text-height', 'ares'), 'fa fa-text-width' => __('text-width', 'ares'), 'fa fa-th' => __('th', 'ares'), 'fa fa-th-large' => __('th-large', 'ares'), 'fa fa-th-list' => __('th-list', 'ares'), 'fa fa-underline' => __('underline', 'ares'), 'fa fa-undo' => __('undo', 'ares'), 'fa fa-unlink' => __('unlink', 'ares'), 'fa fa-angle-double-down' => __('angle-double-down', 'ares'), 'fa fa-angle-double-left' => __('angle-double-left', 'ares'), 'fa fa-angle-double-right' => __('angle-double-right', 'ares'), 'fa fa-angle-double-up' => __('angle-double-up', 'ares'), 'fa fa-angle-down' => __('angle-down', 'ares'), 'fa fa-angle-left' => __('angle-left', 'ares'), 'fa fa-angle-right' => __('angle-right', 'ares'), 'fa fa-angle-up' => __('angle-up', 'ares'), 'fa fa-arrow-circle-down' => __('arrow-circle-down', 'ares'), 'fa fa-arrow-circle-left' => __('arrow-circle-left', 'ares'), 'fa fa-arrow-circle-o-down' => __('arrow-circle-o-down', 'ares'), 'fa fa-arrow-circle-o-left' => __('arrow-circle-o-left', 'ares'), 'fa fa-arrow-circle-o-right' => __('arrow-circle-o-right', 'ares'), 'fa fa-arrow-circle-o-up' => __('arrow-circle-o-up', 'ares'), 'fa fa-arrow-circle-right' => __('arrow-circle-right', 'ares'), 'fa fa-arrow-circle-up' => __('arrow-circle-up', 'ares'), 'fa fa-arrow-down' => __('arrow-down', 'ares'), 'fa fa-arrow-left' => __('arrow-left', 'ares'), 'fa fa-arrow-right' => __('arrow-right', 'ares'), 'fa fa-arrow-up' => __('arrow-up', 'ares'), 'fa fa-arrows' => __('arrows', 'ares'), 'fa fa-arrows-alt' => __('arrows-alt', 'ares'), 'fa fa-arrows-h' => __('arrows-h', 'ares'), 'fa fa-arrows-v' => __('arrows-v', 'ares'), 'fa fa-caret-down' => __('caret-down', 'ares'), 'fa fa-caret-left' => __('caret-left', 'ares'), 'fa fa-caret-right' => __('caret-right', 'ares'), 'fa fa-caret-square-o-down' => __('caret-square-o-down', 'ares'), 'fa fa-caret-square-o-left' => __('caret-square-o-left', 'ares'), 'fa fa-caret-square-o-right' => __('caret-square-o-right', 'ares'), 'fa fa-caret-square-o-up' => __('caret-square-o-up', 'ares'), 'fa fa-caret-up' => __('caret-up', 'ares'), 'fa fa-chevron-circle-down' => __('chevron-circle-down', 'ares'), 'fa fa-chevron-circle-left' => __('chevron-circle-left', 'ares'), 'fa fa-chevron-circle-right' => __('chevron-circle-right', 'ares'), 'fa fa-chevron-circle-up' => __('chevron-circle-up', 'ares'), 'fa fa-chevron-down' => __('chevron-down', 'ares'), 'fa fa-chevron-left' => __('chevron-left', 'ares'), 'fa fa-chevron-right' => __('chevron-right', 'ares'), 'fa fa-chevron-up' => __('chevron-up', 'ares'), 'fa fa-hand-o-down' => __('hand-o-down', 'ares'), 'fa fa-hand-o-left' => __('hand-o-left', 'ares'), 'fa fa-hand-o-right' => __('hand-o-right', 'ares'), 'fa fa-hand-o-up' => __('hand-o-up', 'ares'), 'fa fa-long-arrow-down' => __('long-arrow-down', 'ares'), 'fa fa-long-arrow-left' => __('long-arrow-left', 'ares'), 'fa fa-long-arrow-right' => __('long-arrow-right', 'ares'), 'fa fa-long-arrow-up' => __('long-arrow-up', 'ares'), 'fa fa-toggle-down' => __('toggle-down', 'ares'), 'fa fa-toggle-left' => __('toggle-left', 'ares'), 'fa fa-toggle-right' => __('toggle-right', 'ares'), 'fa fa-toggle-up' => __('toggle-up', 'ares'), 'fa fa-arrows-alt' => __('arrows-alt', 'ares'), 'fa fa-backward' => __('backward', 'ares'), 'fa fa-compress' => __('compress', 'ares'), 'fa fa-eject' => __('eject', 'ares'), 'fa fa-expand' => __('expand', 'ares'), 'fa fa-fast-backward' => __('fast-backward', 'ares'), 'fa fa-fast-forward' => __('fast-forward', 'ares'), 'fa fa-forward' => __('forward', 'ares'), 'fa fa-pause' => __('pause', 'ares'), 'fa fa-play' => __('play', 'ares'), 'fa fa-play-circle' => __('play-circle', 'ares'), 'fa fa-play-circle-o' => __('play-circle-o', 'ares'), 'fa fa-step-backward' => __('step-backward', 'ares'), 'fa fa-step-forward' => __('step-forward', 'ares'), 'fa fa-stop' => __('stop', 'ares'), 'fa fa-youtube-play' => __('youtube-play', 'ares'), 'fa fa-warning' => __('warning', 'ares'), 'fa fa-adn' => __('adn', 'ares'), 'fa fa-android' => __('android', 'ares'), 'fa fa-apple' => __('apple', 'ares'), 'fa fa-behance' => __('behance', 'ares'), 'fa fa-behance-square' => __('behance-square', 'ares'), 'fa fa-bitbucket' => __('bitbucket', 'ares'), 'fa fa-bitbucket-square' => __('bitbucket-square', 'ares'), 'fa fa-bitcoin' => __('bitcoin', 'ares'), 'fa fa-btc' => __('btc', 'ares'), 'fa fa-codepen' => __('codepen', 'ares'), 'fa fa-css3' => __('css3', 'ares'), 'fa fa-delicious' => __('delicious', 'ares'), 'fa fa-deviantart' => __('deviantart', 'ares'), 'fa fa-digg' => __('digg', 'ares'), 'fa fa-dribbble' => __('dribbble', 'ares'), 'fa fa-dropbox' => __('dropbox', 'ares'), 'fa fa-drupal' => __('drupal', 'ares'), 'fa fa-empire' => __('empire', 'ares'), 'fa fa-facebook' => __('facebook', 'ares'), 'fa fa-facebook-square' => __('facebook-square', 'ares'), 'fa fa-flickr' => __('flickr', 'ares'), 'fa fa-foursquare' => __('foursquare', 'ares'), 'fa fa-ge' => __('ge', 'ares'), 'fa fa-git' => __('git', 'ares'), 'fa fa-git-square' => __('git-square', 'ares'), 'fa fa-github' => __('github', 'ares'), 'fa fa-github-alt' => __('github-alt', 'ares'), 'fa fa-github-square' => __('github-square', 'ares'), 'fa fa-gittip' => __('gittip', 'ares'), 'fa fa-google' => __('google', 'ares'), 'fa fa-google-plus' => __('google-plus', 'ares'), 'fa fa-google-plus-square' => __('google-plus-square', 'ares'), 'fa fa-hacker-news' => __('hacker-news', 'ares'), 'fa fa-html5' => __('html5', 'ares'), 'fa fa-instagram' => __('instagram', 'ares'), 'fa fa-joomla' => __('joomla', 'ares'), 'fa fa-jsfiddle' => __('jsfiddle', 'ares'), 'fa fa-linkedin' => __('linkedin', 'ares'), 'fa fa-linkedin-square' => __('linkedin-square', 'ares'), 'fa fa-linux' => __('linux', 'ares'), 'fa fa-maxcdn' => __('maxcdn', 'ares'), 'fa fa-openid' => __('openid', 'ares'), 'fa fa-pagelines' => __('pagelines', 'ares'), 'fa fa-pied-piper' => __('pied-piper', 'ares'), 'fa fa-pied-piper-alt' => __('pied-piper-alt', 'ares'), 'fa fa-pied-piper-square' => __('pied-piper-square', 'ares'), 'fa fa-pinterest' => __('pinterest', 'ares'), 'fa fa-pinterest-square' => __('pinterest-square', 'ares'), 'fa fa-qq' => __('qq', 'ares'), 'fa fa-ra' => __('ra', 'ares'), 'fa fa-rebel' => __('rebel', 'ares'), 'fa fa-reddit' => __('reddit', 'ares'), 'fa fa-reddit-square' => __('reddit-square', 'ares'), 'fa fa-renren' => __('renren', 'ares'), 'fa fa-share-alt' => __('share-alt', 'ares'), 'fa fa-share-alt-square' => __('share-alt-square', 'ares'), 'fa fa-skype' => __('skype', 'ares'), 'fa fa-slack' => __('slack', 'ares'), 'fa fa-soundcloud' => __('soundcloud', 'ares'), 'fa fa-spotify' => __('spotify', 'ares'), 'fa fa-stack-exchange' => __('stack-exchange', 'ares'), 'fa fa-stack-overflow' => __('stack-overflow', 'ares'), 'fa fa-steam' => __('steam', 'ares'), 'fa fa-steam-square' => __('steam-square', 'ares'), 'fa fa-stumbleupon' => __('stumbleupon', 'ares'), 'fa fa-stumbleupon-circle' => __('stumbleupon-circle', 'ares'), 'fa fa-tencent-weibo' => __('tencent-weibo', 'ares'), 'fa fa-trello' => __('trello', 'ares'), 'fa fa-tumblr' => __('tumblr', 'ares'), 'fa fa-tumblr-square' => __('tumblr-square', 'ares'), 'fa fa-twitter' => __('twitter', 'ares'), 'fa fa-twitter-square' => __('twitter-square', 'ares'), 'fa fa-vimeo-square' => __('vimeo-square', 'ares'), 'fa fa-vine' => __('vine', 'ares'), 'fa fa-vk' => __('vk', 'ares'), 'fa fa-wechat' => __('wechat', 'ares'), 'fa fa-weibo' => __('weibo', 'ares'), 'fa fa-weixin' => __('weixin', 'ares'), 'fa fa-windows' => __('windows', 'ares'), 'fa fa-wordpress' => __('wordpress', 'ares'), 'fa fa-xing' => __('xing', 'ares'), 'fa fa-xing-square' => __('xing-square', 'ares'), 'fa fa-yahoo' => __('yahoo', 'ares'), 'fa fa-youtube' => __('youtube', 'ares'), 'fa fa-youtube-play' => __('youtube-play', 'ares'), 'fa fa-youtube-square' => __('youtube-square', 'ares'), 'fa fa-ambulance' => __('ambulance', 'ares'), 'fa fa-h-square' => __('h-square', 'ares'), 'fa fa-hospital-o' => __('hospital-o', 'ares'), 'fa fa-medkit' => __('medkit', 'ares'), 'fa fa-plus-square' => __('plus-square', 'ares'), 'fa fa-stethoscope' => __('stethoscope', 'ares'), 'fa fa-user-md' => __('user-md', 'ares'), 'fa fa-wheelchair' => __('wheelchair', 'ares')
    );
    $bool_array = array(
        'yes' => __('Yes', 'ares'),
        'no' => __('No', 'ares')
    );
    $slider_style = array(
        'cover' => __('Cover', 'ares'),
        '100% 100%' => __('Stretch', 'ares'),
    );

    // Multicheck Array
    $multicheck_array = array(
        'one' => __('French Toast', 'ares'),
        'two' => __('Pancake', 'ares'),
        'three' => __('Omelette', 'ares'),
        'four' => __('Crepe', 'ares'),
        'five' => __('Waffle', 'ares')
    );

    // Multicheck Defaults
    $multicheck_defaults = array(
        'one' => '1',
        'five' => '1'
    );

    // Background Defaults
    $background_defaults = array(
        'color' => '',
        'image' => '',
        'repeat' => 'repeat',
        'position' => 'top center',
        'attachment' => 'scroll');

    // Typography Defaults
    $typography_defaults = array(
        'size' => '15px',
        'face' => 'georgia');
    
    $width_array = array(
        'row1060' => '1060 px',
        'row1200' => '1200 px',
    );

    $font_size_array = array(
        '10px' => '10 px',
        '12px' => '12 px',
        '14px' => '14 px',
        '16px' => '16 px',
        '18px' => '18 px',
    );
    $font_family_array = array(
        'Arial, Helvetica, sans-serif' => 'Arial',
        'Arial Black, Gadget, sans-serif' => 'Arial Black',
        'Courier New, monospace' => 'Courier New',
        'Lobster, cursive' => 'Lobster - Cursive',
        'Georgia, serif' => 'Georgia',
        'Impact, Charcoal, sans-serif' => 'Impact',
        'Josefin Sans, sans-serif' => 'Josefin',
        'Lucida Console, Monaco, monospace' => 'Lucida Console',
        'Lucida Sans Unicode, Lucida Grande, sans-serif' => 'Lucida Sans Unicode',
        'MS Sans Serif, Geneva, sans-serif' => 'MS Sans Serif',
        'MS Serif, New York, serif' => 'MS Serif',
        'Palatino Linotype, Book Antiqua, Palatino, serif' => 'Palatino Linotype',
        'Source Sans Pro, sans-serif' => 'Source Sans Pro',
        'Lato, sans-serif' => 'Lato',
        'Tahoma, Geneva, sans-serif' => 'Tahoma',
        'Times New Roman, Times, serif' => 'Times New Roman',
        'Trebuchet MS, sans-serif' => 'Trebuchet MS',
        'Verdana, Geneva, sans-serif' => 'Verdana',
    );


    // Pull all the categories into an array
    $options_categories = array();
    $options_categories_obj = get_categories();
    foreach ($options_categories_obj as $category) {
        $options_categories[$category->cat_ID] = $category->cat_name;
    }

    // Pull all tags into an array
    $options_tags = array();
    $options_tags_obj = get_tags();
    foreach ($options_tags_obj as $tag) {
        $options_tags[$tag->term_id] = $tag->name;
    }


    // Pull all the pages into an array
    $options_pages = array();
    $options_pages_obj = get_pages('sort_column=post_parent,menu_order');
    $options_pages[''] = 'Select a page:';
    foreach ($options_pages_obj as $page) {
        $options_pages[$page->ID] = $page->post_title;
    }

    // If using image radio buttons, define a directory path
    $imagepath = get_template_directory_uri() . '/inc/images/';

    $options = array();

    // ------------------------------------------------------------------ Basic Settings
    $options[] = array(
        'name' => __('Header', 'ares'),
        'type' => 'heading');

    $options[] = array(
        'name' => __('Logo', 'ares'),
        'desc' => __('Your website Logo.', 'ares'),
        'id' => 'ares_logo_image',
        'type' => 'upload');

    $options[] = array(
        'name' => __('Header Bar', 'ares'),
        'desc' => __('Toggle the headerbar on or off', 'ares'),
        'id' => 'ares_headerbar_bool',
        'std' => 'yes',
        'type' => 'radio',
        'options' => $bool_array);

    $options[] = array(
        'name' => __('Facebook URL', 'ares'),
        'desc' => __('Enter the URL for your Facebook Page', 'ares'),
        'id' => 'ares_facebook_url',
        'std' => 'https://www.facebook.com/SmartcatDesign',
        'type' => 'text');

    $options[] = array(
        'name' => __('Twitter URL', 'ares'),
        'desc' => __('Enter the URL for your Facebook Page', 'ares'),
        'id' => 'ares_twitter_url',
        'std' => '',
        'type' => 'text');

    $options[] = array(
        'name' => __('LinkedIn URL', 'ares'),
        'desc' => __('Enter the URL for your LinkedIn Page', 'ares'),
        'id' => 'ares_linkedin_url',
        'std' => '',
        'type' => 'text');

    $options[] = array(
        'name' => __('Google Plus URL', 'ares'),
        'desc' => __('Enter the URL for your Google Plus Page', 'ares'),
        'id' => 'ares_gplus_url',
        'std' => '',
        'type' => 'text');

    // ---------------------------------------------------------------------- Design
    $options[] = array(
        'name' => __('Design', 'ares'),
        'type' => 'heading');
    
    $options[] = array(
        'name' => "Select theme skin color",
        'desc' => "This sets the main color of the theme",
        'id' => "ares_theme_color",
        'std' => "aqua",
        'type' => "images",
        'options' => array(
            'red' => $imagepath . 'red.png',
            'green' => $imagepath . 'green.png',
            'aqua' => $imagepath . 'aqua.png')
    );
    
    $options[] = array(
        'name' => "Select background pattern",
        'desc' => "Set the pattern for the site background",
        'id' => "ares_theme_background_pattern",
        'std' => "crossword",
        'type' => "images",
        'options' => array(
            'whitewall3' => $imagepath . 'witewall_3.png',
            'brickwall' => $imagepath . 'brickwall.png',
            'skulls' => $imagepath . 'skulls.png',
            'crossword' => $imagepath . 'crossword.png',
            'food' => $imagepath . 'food.png')
    );


    $options[] = array(
        'name' => __('Font Size', 'ares'),
        'desc' => __('Main body font size', 'ares'),
        'id' => 'ares_font_size',
        'std' => '14px',
        'type' => 'select',
        'class' => 'mini', //mini, tiny, small
        'options' => $font_size_array);
    
    $options[] = array(
        'name' => __('Font Family', 'ares'),
        'desc' => __('font family for the website', 'ares'),
        'id' => 'ares_font_family',
        'std' => 'Josefin Sans, sans-serif',
        'type' => 'select',
        'class' => 'small', //mini, tiny, small
        'options' => $font_family_array);    

    
    //--------------------------------------------------------------------------- Homepage
    

    
    $options[] = array(
        'name' => __('Homepage', 'ares'),
        'type' => 'heading');
    
    $options[] = array(
        'name' => "Select homepage design",
        'desc' => "Select to show or hide the homepage sidebar",
        'id' => "ares_homepage_sidebar",
        'std' => "sidebar-off",
        'type' => "images",
        'options' => array(
            'sidebar-off' => $imagepath . '1col.png',
            'sidebar-on' => $imagepath . '2cr.png')
    );   
    
    $path = get_template_directory_uri() . '/images/ares_demo.jpg';    
    $options[] = array(
        'name' => __('Slider', 'ares'),
        'desc' => __('Toggle the Slider on or off', 'ares'),
        'id' => 'ares_slider_bool',
        'std' => 'yes',
        'type' => 'radio',
        'options' => $bool_array);

    
    $options[] = array(
        'name' => __('Slide #1', 'ares'),
        'desc' => __('First Slide', 'ares'),
        'id' => 'ares_slide1_image',
        'std' => $path,
        'type' => 'upload');
    $options[] = array(
        'name' => __('Slide #1 Text', 'ares'),
        'desc' => __('First Slide Text', 'ares'),
        'id' => 'ares_slide1_text',
        'std' => 'Clean & Modern Design',
        'type' => 'text');

    $options[] = array(
        'name' => __('Slide #2', 'ares'),
        'desc' => __('Second Slide', 'ares'),
        'id' => 'ares_slide2_image',
        'std' => $path,
        'type' => 'upload');
    $options[] = array(
        'name' => __('Slide #2 Text', 'ares'),
        'desc' => __('Second Slide Text', 'ares'),
        'id' => 'ares_slide2_text',
        'std' => 'Reponsive with Bootstrap',
        'type' => 'text');

    $options[] = array(
        'name' => __('Slide #3', 'ares'),
        'desc' => __('Third Slide', 'ares'),
        'id' => 'ares_slide3_image',
        'std' => $path,
        'type' => 'upload');
    
    $options[] = array(
        'name' => __('Slide #3 Text', 'ares'),
        'desc' => __('Third Slide Text', 'ares'),
        'id' => 'ares_slide3_text',
        'std' => 'Comes with 600 Icons',
        'type' => 'text');

    
    $options[] = array(
        'name' => __('Show 3 CTA Boxes', 'ares'),
        'desc' => __('Toggle the CTAs on or off', 'ares'),
        'id' => 'ares_cta_bool',
        'std' => 'yes',
        'type' => 'radio',
        'options' => $bool_array);

    $options[] = array(
        'name' => __('CTA Heading 1', 'ares'),
        'desc' => __('first heading for CTA boxes', 'ares'),
        'id' => 'ares_cta_header_one',
        'std' => 'Easy to customize',
        'type' => 'text');    
    
    $options[] = array(
        'name' => __('CTA Heading 2', 'ares'),
        'desc' => __('second heading for CTA boxes', 'ares'),
        'id' => 'ares_cta_header_two',
        'std' => 'Responsive, Professional & Modern Multi-purpose theme',
        'type' => 'text');    
    
  // box 1
    $options[] = array(
        'name' => __('Box #1 Title', 'ares'),
        'desc' => __('First box title', 'ares'),
        'id' => 'ares_cta1_title',
        'std' => 'Box 1 Title',
        'type' => 'text');

    $options[] = array(
        'name' => __('Box #1 Icon', 'ares'),
        'desc' => __('Icon for the first box', 'ares'),
        'id' => 'ares_cta1_icon',
        'std' => 'fa fa-desktop',
        'type' => 'select',
        'class' => 'mini', //mini, tiny, small
        'options' => $icon_array);

    $options[] = array(
        'name' => __('Box #1 Text', 'ares'),
        'desc' => __('Textarea for Box #1', 'ares'),
        'id' => 'ares_cta1_text',
        'std' => 'Box 1 Text. Input anything you want here',
        'type' => 'textarea');

    $options[] = array(
        'name' => __('Box #1 Link', 'ares'),
        'desc' => __('URL box button links to', 'ares'),
        'id' => 'ares_cta1_url',
        'std' => '',
        'type' => 'text');

    $options[] = array(
        'name' => __('Box #1 Button Text', 'ares'),
        'desc' => __('Set the text on the button', 'ares'),
        'id' => 'ares_cta1_button_text',
        'std' => 'Click Here',
        'type' => 'text');
    // box 2
    $options[] = array(
        'name' => __('Box #2 Title', 'ares'),
        'desc' => __('First box title', 'ares'),
        'id' => 'ares_cta2_title',
        'std' => 'Box #2 Title',
        'type' => 'text');

    $options[] = array(
        'name' => __('Box #2 Icon', 'ares'),
        'desc' => __('Icon for the second box', 'ares'),
        'id' => 'ares_cta2_icon',
        'std' => 'fa fa-tachometer',
        'type' => 'select',
        'class' => 'mini', //mini, tiny, small
        'options' => $icon_array);

    $options[] = array(
        'name' => __('Box #2 Text', 'ares'),
        'desc' => __('Textarea for Box #2', 'ares'),
        'id' => 'ares_cta2_text',
        'std' => 'Box #2 text',
        'type' => 'textarea');

    $options[] = array(
        'name' => __('Box #2 Link', 'ares'),
        'desc' => __('URL box button links to', 'ares'),
        'id' => 'ares_cta2_url',
        'std' => '',
        'type' => 'text');
    
    $options[] = array(
        'name' => __('Box #2 Button Text', 'ares'),
        'desc' => __('Set the text on the button', 'ares'),
        'id' => 'ares_cta2_button_text',
        'std' => 'Click Here',
        'type' => 'text');
    //box3
    $options[] = array(
        'name' => __('Box #3 Title', 'ares'),
        'desc' => __('Third box title', 'ares'),
        'id' => 'ares_cta3_title',
        'std' => 'Box #3 Title',
        'type' => 'text');

    $options[] = array(
        'name' => __('Box #3 Icon', 'ares'),
        'desc' => __('Icon for the third box', 'ares'),
        'id' => 'ares_cta3_icon',
        'std' => 'fa fa-rocket',
        'type' => 'select',
        'class' => 'mini', //mini, tiny, small
        'options' => $icon_array);

    $options[] = array(
        'name' => __('Box #3 Text', 'ares'),
        'desc' => __('Textarea for Box #3', 'ares'),
        'id' => 'ares_cta3_text',
        'std' => 'Box #3 Text',
        'type' => 'textarea');

    $options[] = array(
        'name' => __('Box #3 Link', 'ares'),
        'desc' => __('URL box button links to', 'ares'),
        'id' => 'ares_cta3_url',
        'std' => '',
        'type' => 'text');
    
    $options[] = array(
        'name' => __('Box #3 Button Text', 'ares'),
        'desc' => __('Set the text on the button', 'ares'),
        'id' => 'ares_cta3_button_text',
        'std' => 'Click Here',
        'type' => 'text');
    

    // ---------------------------------------------------------------------- Templates
    
    $options[] = array(
        'name' => __('Templates', 'ares'),
        'type' => 'heading');
    
    $options[] = array(
        'name' => "Blog Page Layout",
        'desc' => "Select full-width or right sidebar page layout",
        'id' => "ares_blog_layout",
        'std' => "col2r",
        'type' => "images",
        'options' => array(
            'col1' => $imagepath . '1col.png',
            'col2r' => $imagepath . '2cr.png',
    ));        
    
    $options[] = array(
        'name' => __('Blog Featured Images','ares'),
        'desc' => __('Show or Hide the post images on the blog page', 'ares'),
        'id' => 'ares_blog_featured',
        'std' => 'on',
        'type' => 'radio',
        'options' => array(
            'on' => 'Show',
            'off' => 'Hide',
        ));
        
    $options[] = array(
        'name' => __("Single Post Layout", 'ares'),
        'desc' => __("Select full-width or right sidebar page layout", 'ares'),
        'id' => "ares_single_layout",
        'std' => "col2r",
        'type' => "images",
        'options' => array(
            'col1' => $imagepath . '1col.png',
            'col2r' => $imagepath . '2cr.png',
    ));      
    
    $options[] = array(
        'name' => __('Single Post Featured Images','ares'),
        'desc' => __('Show or Hide the post images on a single post', 'ares'),
        'id' => 'ares_single_featured',
        'std' => 'on',
        'type' => 'radio',
        'options' => array(
            'on' => 'Show',
            'off' => 'Hide',
        ));  
    
    
    $options[] = array(
        'name' => __('Single Post Date','ares'),
        'desc' => __('Show or Hide the Posted On post date', 'ares'),
        'id' => 'ares_single_date',
        'std' => 'on',
        'type' => 'radio',
        'options' => array(
            'on' => 'Show',
            'off' => 'Hide',
        ));  
    
    $options[] = array(
        'name' => __('Single Post Author','ares'),
        'desc' => __('Show or Hide the post author', 'ares'),
        'id' => 'ares_single_author',
        'std' => 'on',
        'type' => 'radio',
        'options' => array(
            'on' => 'Show',
            'off' => 'Hide',
        ));  
    
    
    /*------------------------------------------------------ Footer -----------*/
    $options[] = array(
        'name' => __('Footer', 'ares'),
        'type' => 'heading');
    $options[] = array(
        'name' => __('Number of Columns','ares'),
        'desc' => __('How many columns is the footer', 'ares'),
        'id' => 'ares_footer_columns',
        'std' => 'col-md-4',
        'type' => 'select',
        'options' => $footer_columns);
    
    $options[] = array(
        'name' => __('Footer Text', 'ares'),
        'desc' => __('Enter text for the footer', 'ares'),
        'id' => 'ares_footer_text',
        'std' => '&#169; 2014 Your company name',
        'type' => 'textarea');

    return $options;
}

add_action('optionsframework_after', 'ares_ares_options_display_sidebar');

function ares_ares_options_display_sidebar() {
    ?>

    <div class="width30 left ml2p">

        <div class="center">
            <img class="smartcat-icon" src="<?php echo OPTIONS_FRAMEWORK_DIRECTORY; ?>images/smartcat_wordpress.png"/>
        </div>

        <div class="sc-tab-option">
            <a href="http://smartcatdesign.net/preview/ares" target="_blank">
                View Theme Demo
            </a>
        </div>
        
    </div>
<?php } ?>