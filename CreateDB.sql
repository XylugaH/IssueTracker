DROP DATABASE IF EXISTS issuetrackerdb;
CREATE DATABASE issuetrackerdb ;
USE issuetrackerdb;

CREATE TABLE  user (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  FirstName VARCHAR(45) NOT NULL,
  LastName VARCHAR(45) NOT NULL,
  Password VARCHAR(255) NOT NULL,
  Email VARCHAR(45) NOT NULL,
  Role_ID INT NOT NULL,
  UNIQUE INDEX email_UNIQUE (email ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO user VALUES (1,"guest","guest","guest","guest",1);
INSERT INTO  user VALUES (2,"admin","admin","admin","admin@admin.com",3);

CREATE TABLE  role (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  issueView TINYINT(1) NULL DEFAULT 0,
  issueEdit TINYINT(1) NULL DEFAULT 0,
  issueClose TINYINT(1) NULL DEFAULT 0,
  issueReopen TINYINT(1) NULL DEFAULT 0,
  issueAssignment TINYINT(1) NULL DEFAULT 0,
  issueFind TINYINT(1) NULL DEFAULT 0,
  userAdd TINYINT(1) NULL DEFAULT 0,
  userFind TINYINT(1) NULL DEFAULT 0,
  userEdit TINYINT(1) NULL DEFAULT 0,
  userViewAllData TINYINT(1) NULL DEFAULT 0,
  userEditAllData TINYINT(1) NULL DEFAULT 0,
  projectAdd TINYINT(1) NULL DEFAULT 0,
  projectEdit TINYINT(1) NULL DEFAULT 0,
  statustEdit TINYINT(1) NULL DEFAULT 0,
  resolutionAdd TINYINT(1) NULL DEFAULT 0,
  resolucinEdit TINYINT(1) NULL DEFAULT 0,
  priorityAdd TINYINT(1) NULL DEFAULT 0,
  priorityEdit TINYINT(1) NULL DEFAULT 0,
  typeAdd TINYINT(1) NULL DEFAULT 0,
  typeEdit TINYINT(1) NULL DEFAULT 0,
  messageGet TINYINT(1) NULL DEFAULT 0,
  commentAdd TINYINT(1) NULL DEFAULT 0,
  fileAdd TINYINT(1) NULL DEFAULT 0
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  role VALUES (1,"GUEST",1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
INSERT INTO  role VALUES (2,"USER",1,1,1,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1);
INSERT INTO  role VALUES (3,"ADMINISTRATOR",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);

CREATE TABLE  status (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  status VALUES (1,"New");
INSERT INTO  status VALUES (2,"Assigned");
INSERT INTO  status VALUES (3,"In Progress");
INSERT INTO  status VALUES (4,"Resolved");
INSERT INTO  status VALUES (5,"Closed");
INSERT INTO  status VALUES (6,"Reopened");

CREATE TABLE  resolution (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  resolution VALUES (1,"Fixed");
INSERT INTO  resolution VALUES (2,"Invalid");
INSERT INTO  resolution VALUES (3,"Wontfix");
INSERT INTO  resolution VALUES (4,"Worksforme");

CREATE TABLE  priority (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  priority VALUES (1,"Critical");
INSERT INTO  priority VALUES (2,"Major");
INSERT INTO  priority VALUES (3,"Important");
INSERT INTO  priority VALUES (4,"Minor");

CREATE TABLE  type (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  type VALUES (1,"Cosmetic");
INSERT INTO  type VALUES (2,"Bug");
INSERT INTO  type VALUES (3,"Feature");
INSERT INTO  type VALUES (4,"Performance");

CREATE TABLE issue (
  id INT NOT NULL AUTO_INCREMENT ,
  createDate DATE NOT NULL ,
  create_user_id INT NOT NULL ,
  modifyDate DATE NOT NULL ,
  modify_user_id INT NOT NULL ,
  summary CHAR(100) NOT NULL ,
  description LONGTEXT NULL ,
  status_id INT NULL ,
  resolution_id INT NULL ,
  type_id INT NULL ,
  priority_id INT NULL ,
  project_id INT NULL ,
  assignee_user_id INT NULL ,
  PRIMARY KEY (id)  ,
  UNIQUE INDEX id_UNIQUE (id ASC)  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO issue VALUES
(1,"04.04.2017",1,"04.04.2017",2,"testsum","test description",2,3,2,3,1,1);

CREATE TABLE project (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL ,
  description VARCHAR(100) NULL ,
  manager_user_id INT NOT NULL ,
  PRIMARY KEY (id)  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO issuetrackerdb.project
(id,name,description,manager_user_id)
VALUES
(1,"testProject","It is the first test project",2);

CREATE TABLE build (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL ,
  project_id INT NOT NULL ,
  PRIMARY KEY (id)  ,
  KEY fk_project (project_id),
  CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES project (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO build
(id,name,project_id)
VALUES
(1,"1.0v",1);

INSERT INTO issuetrackerdb.build
(id,name,project_id)
VALUES
(2,"1.12v",1);
