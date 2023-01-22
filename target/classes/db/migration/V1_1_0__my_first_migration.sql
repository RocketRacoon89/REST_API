CREATE TABLE `rest_api`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `rest_api`.`events` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `file_id` INT NULL,
  `operation` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `rest_api`.`files` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `filePath` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));