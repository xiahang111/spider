/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.22-community-nt : Database - spider
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spider` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spider`;

/*Table structure for table `item_jd` */

DROP TABLE IF EXISTS `item_jd`;

CREATE TABLE `item_jd` (
  `item_id` varchar(20) NOT NULL,
  `item_price` int(20) default NULL,
  `item_title` varchar(50) default NULL,
  PRIMARY KEY  (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item_jd` */

insert  into `item_jd`(`item_id`,`item_price`,`item_title`) values ('1',11,'111'),('11',100,'111'),('14',100,'111');

/*Table structure for table `url_jd` */

DROP TABLE IF EXISTS `url_jd`;

CREATE TABLE `url_jd` (
  `URL_ID` int(11) NOT NULL auto_increment,
  `URL_NAME` varchar(50) default NULL,
  PRIMARY KEY  (`URL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `url_jd` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
