--liquibase formatted sql

--changeset lekha:1653760916797-47 
ALTER TABLE `accounts` DROP `full_name`;
ALTER TABLE `accounts` ADD `full_name` VARCHAR(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci GENERATED ALWAYS AS (concat(first_name,' ',last_name)) VIRTUAL AFTER `last_name`;
