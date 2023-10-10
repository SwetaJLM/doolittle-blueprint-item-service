ALTER TABLE `content` ADD COLUMN `template_id` VARCHAR(255) DEFAULT NULL;
ALTER TABLE `content` ADD COLUMN `template_version` bigint(20) DEFAULT NULL;