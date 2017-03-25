CREATE SCHEMA `issuetrackerdb` ;

CREATE TABLE `issuetrackerdb`.`user` (
  `id` INT NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Role_ID` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE `issuetrackerdb`.`role` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `issueView` TINYINT(1) NULL DEFAULT 0,
  `issueEdit` TINYINT(1) NULL DEFAULT 0,
  `issueClose` TINYINT(1) NULL DEFAULT 0,
  `issueReopen` TINYINT(1) NULL DEFAULT 0,
  `issueAssignment` TINYINT(1) NULL DEFAULT 0,
  `issueFind` TINYINT(1) NULL DEFAULT 0,
  `userAdd` TINYINT(1) NULL DEFAULT 0,
  `userFind` TINYINT(1) NULL DEFAULT 0,
  `userEdit` TINYINT(1) NULL DEFAULT 0,
  `userViewAllData` TINYINT(1) NULL DEFAULT 0,
  `userEditAllData` TINYINT(1) NULL DEFAULT 0,
  `projectAdd` TINYINT(1) NULL DEFAULT 0,
  `projectEdit` TINYINT(1) NULL DEFAULT 0,
  `statustEdit` TINYINT(1) NULL DEFAULT 0,
  `resolutionAdd` TINYINT(1) NULL DEFAULT 0,
  `resolucinEdit` TINYINT(1) NULL DEFAULT 0,
  `priorityAdd` TINYINT(1) NULL DEFAULT 0,
  `priorityEdit` TINYINT(1) NULL DEFAULT 0,
  `typeAdd` TINYINT(1) NULL DEFAULT 0,
  `typeEdit` TINYINT(1) NULL DEFAULT 0,
  `messageGet` TINYINT(1) NULL DEFAULT 0,
  `commentAdd` TINYINT(1) NULL DEFAULT 0,
  `fileAdd` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE `issuetrackerdb`.`status` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(0,"New");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(1,"Assigned");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(2,"In Progress");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(3,"Resolved");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(4,"Closed");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(5,"Reopened");

CREATE TABLE `issuetrackerdb`.`resolution` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `issuetrackerdb`.`resolution`
(`id`,`name`)
VALUES
(0,"Fixed");

INSERT INTO `issuetrackerdb`.`resolution`
(`id`,`name`)
VALUES
(1,"Invalid");

INSERT INTO `issuetrackerdb`.`resolution`
(`id`,`name`)
VALUES
(2,"Wontfix");

INSERT INTO `issuetrackerdb`.`resolution`
(`id`,`name`)
VALUES
(3,"Worksforme");



