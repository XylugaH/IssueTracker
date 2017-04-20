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

CREATE TABLE  role (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE  status (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE  resolution (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE  priority (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  color VARCHAR(45) NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE  type (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  UNIQUE INDEX id_UNIQUE (id ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE issues (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
  build_id INT NULL ,
  assignee_user_id INT NULL ,
  UNIQUE INDEX id_UNIQUE (id ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE comments (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  issue_id INT NOT NULL ,
  createDate DATE NOT NULL ,
  create_user_id INT NOT NULL ,
  comment LONGTEXT NULL ,
  KEY fk_issue (issue_id),
  CONSTRAINT fk_issue FOREIGN KEY (issue_id) REFERENCES issues (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


CREATE TABLE project (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL ,
  description VARCHAR(100) NULL ,
  manager_user_id INT NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


CREATE TABLE build (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL ,
  project_id INT NOT NULL ,
  KEY fk_project (project_id),
  CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES project (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

