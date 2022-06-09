--liquibase formatted sql

--changeset lekha:1653760916797-46 
ALTER TABLE `hostels` ADD `address` TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci GENERATED ALWAYS AS (concat(city,' - ',district,' - ',ward,' - ',street)) VIRTUAL AFTER `street`;

--changeset lekha:1653760916797-47
ALTER TABLE `hostels` ADD UNIQUE(`hostel_slug`);
