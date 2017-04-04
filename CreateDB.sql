CREATE DATABASE IF NOT EXISTS `issuetrackerdb` ;
USE `issuetrackerdb`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE  `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Role_ID` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  `user`
(`id`,`FirstName`,`LastName`,`Password`,`Email`,`Role_ID`)
VALUES
(1,"admin","admin","admin","admin@admin.com",3);

INSERT INTO `user`
(`id`,`FirstName`,`LastName`,`Password`,`Email`,`Role_ID`)
VALUES
(2,"guest","guest","","",1);


DROP TABLE IF EXISTS `role`;
CREATE TABLE  `role` (
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

INSERT INTO  `role`
(`id`,`name`,`issueView`,`issueEdit`,`issueClose`,`issueReopen`,`issueAssignment`,
`issueFind`,`userAdd`,`userFind`,`userEdit`,`userViewAllData`,`userEditAllData`,
`projectAdd`,`projectEdit`,`statustEdit`,`resolutionAdd`,`resolucinEdit`,`priorityAdd`,
`priorityEdit`,`typeAdd`,`typeEdit`,`messageGet`,`commentAdd`,`fileAdd`)
VALUES
(1,"GUEST",1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

INSERT INTO  `role`
(`id`,`name`,`issueView`,`issueEdit`,`issueClose`,`issueReopen`,`issueAssignment`,
`issueFind`,`userAdd`,`userFind`,`userEdit`,`userViewAllData`,`userEditAllData`,
`projectAdd`,`projectEdit`,`statustEdit`,`resolutionAdd`,`resolucinEdit`,`priorityAdd`,
`priorityEdit`,`typeAdd`,`typeEdit`,`messageGet`,`commentAdd`,`fileAdd`)
VALUES
(2,"USER",1,1,1,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1);

INSERT INTO  `role`
(`id`,`name`,`issueView`,`issueEdit`,`issueClose`,`issueReopen`,`issueAssignment`,
`issueFind`,`userAdd`,`userFind`,`userEdit`,`userViewAllData`,`userEditAllData`,
`projectAdd`,`projectEdit`,`statustEdit`,`resolutionAdd`,`resolucinEdit`,`priorityAdd`,
`priorityEdit`,`typeAdd`,`typeEdit`,`messageGet`,`commentAdd`,`fileAdd`)
VALUES
(3,"ADMINISTRATOR",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);

DROP TABLE IF EXISTS `status`;
CREATE TABLE  `status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  `status`
(`id`,`name`)
VALUES
(1,"New");

INSERT INTO  `status`
(`id`,`name`)
VALUES
(2,"Assigned");

INSERT INTO  `status`
(`id`,`name`)
VALUES
(3,"In Progress");

INSERT INTO  `status`
(`id`,`name`)
VALUES
(4,"Resolved");

INSERT INTO  `status`
(`id`,`name`)
VALUES
(5,"Closed");

INSERT INTO  `status`
(`id`,`name`)
VALUES
(6,"Reopened");

DROP TABLE IF EXISTS `resolution`;
CREATE TABLE  `resolution` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  `resolution`
(`id`,`name`)
VALUES
(1,"Fixed");

INSERT INTO  `resolution`
(`id`,`name`)
VALUES
(2,"Invalid");

INSERT INTO  `resolution`
(`id`,`name`)
VALUES
(3,"Wontfix");

INSERT INTO  `resolution`
(`id`,`name`)
VALUES
(4,"Worksforme");

DROP TABLE IF EXISTS `priority`;
CREATE TABLE  `priority` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  `priority`
(`id`,`name`)
VALUES
(1,"Critical");

INSERT INTO  `priority`
(`id`,`name`)
VALUES
(2,"Major");

INSERT INTO  `priority`
(`id`,`name`)
VALUES
(3,"Important");

INSERT INTO  `priority`
(`id`,`name`)
VALUES
(4,"Minor");

DROP TABLE IF EXISTS `type`;
CREATE TABLE  `type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  `type`
(`id`,`name`)
VALUES
(1,"Cosmetic");

INSERT INTO  `type`
(`id`,`name`)
VALUES
(2,"Bug");

INSERT INTO  `type`
(`id`,`name`)
VALUES
(3,"Feature");

INSERT INTO  `type`
(`id`,`name`)
VALUES
(4,"Performance");

DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `createDate` DATE NOT NULL COMMENT '',
  `create_user_id` INT NOT NULL COMMENT '',
  `modifyDate` DATE NOT NULL COMMENT '',
  `modify_user_id` INT NOT NULL COMMENT '',
  `summary` CHAR(100) NOT NULL COMMENT '',
  `description` LONGTEXT NULL COMMENT '',
  `status_id` INT NULL COMMENT '',
  `resolution_id` INT NULL COMMENT '',
  `type_id` INT NULL COMMENT '',
  `priority_id` INT NULL COMMENT '',
  `project_id` INT NULL COMMENT '',
  `assignee_user_id` INT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
INSERT INTO `issuetrackerdb`.`issue`
(`id`,
`createDate`,
`create_user_id`,
`modifyDate`,
`modify_user_id`,
`summary`,
`description`,
`status_id`,
`resolution_id`,
`type_id`,
`priority_id`,
`project_id`,
`assignee_user_id`)
VALUES
(1,
"04.04.2017",
1,
"04.04.2017",
2,
"testsum",
"test description",
2,
3,
2,
3,
1,
1);

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `description` VARCHAR(100) NULL COMMENT '',
  `manager_user_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `issuetrackerdb`.`project`
(`id`,`name`,`description`,`manager_user_id`)
VALUES
(1,"testProject","It is the first test project",2);

DROP TABLE IF EXISTS `build`;
CREATE TABLE `build` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `project_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  KEY `fk_project` (`project_id`),
  CONSTRAINT `fk_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `build`
(`id`,`name`,`project_id`)
VALUES
(1,"1.0v",1);

INSERT INTO `issuetrackerdb`.`build`
(`id`,`name`,`project_id`)
VALUES
(2,"1.12v",1);
