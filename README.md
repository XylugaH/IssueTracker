# IssueTracker with Spring 4 and Hibernate 5.

## Requirements
- Java 1.8 or later
- Maven 3 or later
- MySQL 5.6 or later

## Stack
- Spring MVC
- Spring Secure
- Spring IOC
- Apache tiles
- Hibernate
- Maven
- JSP
- MySQL

## Configuration
- Create schema: https://github.com/XylugaH/IssueTracker/blob/master/CreateDB.sql
- Insert data: https://github.com/XylugaH/IssueTracker/blob/master/InitDataDB.sql
- DB configuration: https://github.com/XylugaH/IssueTracker/blob/master/src/main/resources/database.properties


## Running the Application
- Open the Command Prompt
- Go to the root project directory
- Run Tomcat server:  mvn clean tomcat7:run
- Go to the browser and enter the following URL:  localhost:8181/IssueTracker/
- Default account:

```
  Login: admin@admin.com
  Password: admin
```

