CREATE TABLE  user (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  FirstName VARCHAR(45) NOT NULL,
  LastName VARCHAR(45) NOT NULL,
  Password VARCHAR(255) NOT NULL,
  Email VARCHAR(45) NOT NULL,
  Role_ID INT NOT NULL,
  UNIQUE INDEX email_UNIQUE (email ASC)
);

CREATE TABLE  role (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL
);

CREATE TABLE  status (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NULL
);

CREATE TABLE  resolution (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NULL
);

CREATE TABLE  priority (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  color VARCHAR(45) NOT NULL
);

CREATE TABLE  type (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  UNIQUE INDEX id_UNIQUE (id ASC)
);

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
  UNIQUE INDEX id_UNIQUE_issue (id ASC)
);

CREATE TABLE comments (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  issue_id INT NOT NULL ,
  createDate DATE NOT NULL ,
  create_user_id INT NOT NULL ,
  comment LONGTEXT NULL
);


CREATE TABLE project (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL ,
  description VARCHAR(100) NULL ,
  manager_user_id INT NOT NULL
);


CREATE TABLE build (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL ,
  project_id INT NOT NULL
);

