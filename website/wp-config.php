<?php
/**
 * The base configurations of the WordPress.
 *
 * This file has the following configurations: MySQL settings, Table Prefix,
 * Secret Keys, and ABSPATH. You can find more information by visiting
 * {@link http://codex.wordpress.org/Editing_wp-config.php Editing wp-config.php}
 * Codex page. You can get the MySQL settings from your web host.
 *
 * This file is used by the wp-config.php creation script during the
 * installation. You don't have to use the web site, you can just copy this file
 * to "wp-config.php" and fill in the values.
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'website');

/** MySQL database username */
define('DB_USER', 'root');

/** MySQL database password */
define('DB_PASSWORD', 'Genesis?123');

/** MySQL hostname */
define('DB_HOST', '192.168.2.41');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'ZEYnK1+RV.!Y3|:pDtzwhc%?#v!!LlYX[izmW9kmk!+(#IhW]4[28?m0[.]7%j`R');
define('SECURE_AUTH_KEY',  'ox[6$?|?)gVWq8(d.1SUGs[[qHZ$`@eEe1gYaklABTW*!ZC1UfojKTCNE@XW1W81');
define('LOGGED_IN_KEY',    'jB:Pp4xi31n^k&WQXwulj :Zhq(]EK+![F+jTxOcsot~}xMhG%@5{/1V%R5|hG S');
define('NONCE_KEY',        'RTrk5o(rwn&&zl%;4?&Hk>u8,h20,|Ax05B(@1[K_0JtL}[M.<R-UThG<lnmblt9');
define('AUTH_SALT',        'bT+z/q+h8Q]|J6-`^N]*<Y+:A!5TI-HL5l<.Jj8zZ9IgTLx>-5wtEBQ4c{kzhPm>');
define('SECURE_AUTH_SALT', 'G4?($>L}uziqh%GWmh1p:UFtj]fSTZ|X0L0|EaxZtr,>g)wJdavH!8iC^35hdd$7');
define('LOGGED_IN_SALT',   'o*WpwV3|8(4y6Q-l_&)2?&-atUTMu@:r%XC/%XvQ +,}[atzziQ1qA |UY~5=e.U');
define('NONCE_SALT',       '0E]+4NBCtZ|9/LX*MDGm1bCE5L)FHu@]PLWuyR`Hzjphmd-,H9Bj-1.[1D}N|3QM');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each a unique
 * prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 */
define('WP_DEBUG', true);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');

