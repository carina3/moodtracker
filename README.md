## MoodTracker

An application used to track your mood and analyze changes over time. Built with Spring Boot, MySQL and Docker. 

This project is intended as private project to learn the basics of Spring Boot.

## Project Status: Work in progress

This project is still in development. Currently, users can add mood entries to a database and view basic statistics. User  management and authentication functionality is in progress. Integration with a frontend framework is also planned.

## Installation and Setup Instructions

Clone this repository. You will need `Java 11` or more to run this project. If you plan to run the containerized version, you will also need at least `Docker 20.10.6` and `Docker Compose 1.29.2`.

#### Run with Docker Compose

**Clone repository and `cd` into the directory:**

`git@gitlab.com:carwalk/moodtracker.git`

`cd moodtracker/`

**To run the server:**

`docker-compose up`  

**To shutdown the app:**

`docker-compose down`

#### Run without Docker Compose

If you run the app without Docker Compose, you are required to manually set up a MySQL database.

**Clone repository and `cd` into the directory:**

`git@gitlab.com:carwalk/moodtracker.git`

`cd moodtracker/`

**Install MySQL:**

Manually install MySQL via Docker or build from source.

**Create new user and database:**

After having installed MySQL, run the following scripts:

`mysql -u root -p < mysql-startscripts/create_user.sql`

`mysql -u root -p < mysql-startscripts/dump.sql`

**To run the app server:**

Make sure to run the MySQL server before running the app server.

To run the app server:

`mvn spring-boot:run`  

**To shutdown the app:**

Press:

`ctrl + c`

#### Accessing API endpoints

**Credentials to access API endpoints (secured via Basic Authentication):**

username: `user`

password: `password`

**To visit the app:**

`http://localhost:8080/`  

 **To add entries to the database:**

` http://localhost:8080/moodEntry/`

**To view statistics:**

`http://localhost:8080/statistics/mood`

#### Test endpoints with Insomnia REST:

To test the API endpoints with Insomnia, import the following file from the subdirectory `insomnia`:

`moodtracker-api.yaml`



## Reflection

This is an ongoing private project I began while working through Darby's "Spring & Hibernate for Beginners (includes Spring Boot)" course on Udemy ([link][https://www.udemy.com/course/spring-hibernate-tutorial/]). Project goals include familiarizing myself with the Spring Boot framework and RESTful principles.

Technologies used in this project are Java 11, Spring Boot 2,  Docker, Docker Compose, Git, MySQL and Insomnia REST for testing API endpoints. 

Planned functionalities are user management and authentication with Spring Security and integrating an Angular-based frontend.

