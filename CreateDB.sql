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

INSERT INTO  user VALUES (1,"admin","admin","$2a$11$MmNXphksqwYLE.eMGXW60eQgUnxlc6BtrvLeSYhrK42BkwJpJXcWC","admin@admin.com",2);

CREATE TABLE  role (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO  role VALUES (1,"ROLE_USER");
INSERT INTO  role VALUES (2,"ROLE_ADMIN");

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


CREATE TABLE project (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL ,
  description VARCHAR(100) NULL ,
  manager_user_id INT NOT NULL ,
  PRIMARY KEY (id)  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


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

