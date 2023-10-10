--
-- Table structure for table `content_properties`
--

DROP TABLE IF EXISTS `content_properties`;

CREATE TABLE `content_properties` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `content_id` varchar(255) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `modified_at` bigint(20) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `deprecated_at` bigint(20) DEFAULT NULL,
  `deprecated_by` varchar(255) DEFAULT NULL,
  `aliases` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_content_properties_id_content` (`id`,`content_id`),
  KEY `idx_content_properties_content` (`content_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;