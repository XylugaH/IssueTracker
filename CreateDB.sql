CREATE SCHEMA `issuetrackerdb` ;

CREATE TABLE `issuetrackerdb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Role_ID` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE `issuetrackerdb`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
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

INSERT INTO `issuetrackerdb`.`role`
(`id`,`name`,`issueView`,`issueEdit`,`issueClose`,`issueReopen`,`issueAssignment`,
`issueFind`,`userAdd`,`userFind`,`userEdit`,`userViewAllData`,`userEditAllData`,
`projectAdd`,`projectEdit`,`statustEdit`,`resolutionAdd`,`resolucinEdit`,`priorityAdd`,
`priorityEdit`,`typeAdd`,`typeEdit`,`messageGet`,`commentAdd`,`fileAdd`)
VALUES
(1,"GUEST",1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

CREATE TABLE `issuetrackerdb`.`status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(1,"New");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(2,"Assigned");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(3,"In Progress");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(4,"Resolved");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(5,"Closed");

INSERT INTO `issuetrackerdb`.`status`
(`id`,`name`)
VALUES
(6,"Reopened");

CREATE TABLE `issuetrackerdb`.`resolution` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `issuetrackerdb`.`resolution`
(`id`,`name`)
VALUES
(1,"Fixed");

INSERT INTO `issuetrackerdb`.`resolution`
(`id`,`name`)
VALUES
(2,"Invalid");

INSERT INTO `issuetrackerdb`.`resolution`
(`id`,`name`)
VALUES
(3,"Wontfix");

INSERT INTO `issuetrackerdb`.`resolution`
(`id`,`name`)
VALUES
(4,"Worksforme");

CREATE TABLE `issuetrackerdb`.`priority` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `issuetrackerdb`.`priority`
(`id`,`name`)
VALUES
(1,"Critical");

INSERT INTO `issuetrackerdb`.`priority`
(`id`,`name`)
VALUES
(2,"Major");

INSERT INTO `issuetrackerdb`.`priority`
(`id`,`name`)
VALUES
(3,"Important");

INSERT INTO `issuetrackerdb`.`priority`
(`id`,`name`)
VALUES
(4,"Minor");


CREATE TABLE `issuetrackerdb`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `issuetrackerdb`.`type`
(`id`,`name`)
VALUES
(1,"Cosmetic");

INSERT INTO `issuetrackerdb`.`type`
(`id`,`name`)
VALUES
(2,"Bug");

INSERT INTO `issuetrackerdb`.`type`
(`id`,`name`)
VALUES
(3,"Feature");

INSERT INTO `issuetrackerdb`.`type`
(`id`,`name`)
VALUES
(4,"Performance");
