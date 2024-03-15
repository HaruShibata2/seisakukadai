CREATE TABLE `account` (
	`id` SERIAL NOT NULL,
	`name` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`mail` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`password` VARCHAR(126) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`blance` INT(128) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;