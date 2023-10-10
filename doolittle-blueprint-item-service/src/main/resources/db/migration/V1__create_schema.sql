-- Initial schema for contentlist content service

DROP TABLE IF EXISTS `content`;

CREATE TABLE `content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_id` varchar(255) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `language` varchar(5) DEFAULT NULL,
  `processing_state` varchar(16) DEFAULT NULL,
  `processing_detail` longtext DEFAULT NULL,
  `attribution` json DEFAULT NULL,
  `raw_source` VARCHAR(255) DEFAULT NULL,
  `tags` json DEFAULT NULL,
  `labeled_version` int DEFAULT NULL,
  `comment` longtext DEFAULT NULL,
  `content_components` json DEFAULT NULL,
  `layout` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_contentlist_content_content_id` (`content_id`, `id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;
