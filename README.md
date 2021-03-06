# Full CRUD Operation For Islandgrill Menu

Below is an overview of my project which entails a full CRUD (create, read, update and delete) operation. This document is to aid with the understanding of this project.  

## Table of Content
* [Objective](#Objective)
   * [Requirements](#Requirements)
   * [Application and Approach ](#Application and Approach)
   * [Tools Used ](#Tools Used)
* [Framework](#Framework)
   * [Font-End Application](#Font-End Application)
   * [Databases](#Databases)
   * [Postman](#Postman)
   * [Project Management](#Project Management)
   * [Testing](#Testing)
   * [Risk Assessment](#Risk Assessment)
* [Known Issues](#Known-issues)
* [Future Improvements](#Future-improvements)
* [Authors](#Authors)

## Objective
The objective of this project is as outlined below:

To create a web page that accepts user inputs for a restaurant menu and sends the input to a SQL and H2 database. The use will be able to add a dish to the menu, read dishes from the database, update existing dishes in the database and delete dishes from the database. The application should log all the aforementioned actions from the user. 

In layman terms, there will be a full CRUD operations. A Front End should be provided for user input which is connected to a Back-End. The Back-End will send the user input to the SQL or H2 database. A Unit Test and Integration Test is done for acceptable coverage.

### Requirements
All the following requirements should be met:
* Project management using Jira Board
* CRUD operations on a Database
* Back-End in Java
* Working Front-End
* Automated Testing 
* Continuous Integration Testing 
* Use of a Cloud Database

### Application and Approach
I have build a simple front-End application using JavaScript, CSS and HTML. The user adding Dishes should be able to do/see the following:
* Table to start adding dishes:
   * *Dish Number*
   * *Dish Name*
   * *Vegan Suitability*
   * *Dish Price*
* The application should log each input/request into the database then query the database and log all existing input in another table on the web page:
   * *ID* (Database Table id and Primary key)
   * *Dish Name*(The name of the dish)
   * *Dish Number* (The number the Dish is place on the menu)
   * *Vegan Suitability* (If the Dish is suitable for vegans)
   * *Dish Price* (Price of meal)

In addition, the following features are added:
* Data is able to be send from the Back-End to the database (eg. post man)
* A integration and unit test is done for coverage
### Tools Used
* Scripting Languages: 
   * *Java*
   * *JavaScript*
   * *HTML*
   * *CSS*
   * *SQL*
   * *Spring Boot syntax*
   
* Applications:
   * *Jira Board*
   * *Git Hub*
   * *Spring Boot*
   * *Visual Studio Codes*
   * *Post Man*
   * *Excel*
   * *Google Cloud Platform*
   * *H2*
   * *PyCharm*
   

## Framework
### Font-End Application
The images below is the front-end application. It has 5 user input at present.

The following images shows CRUD operation on the front end:
* *Create & Read*

<img src="Images/app_dishes.png" width="800" height = "400">

* *Update*

<img src="Images/app_update.png" width="800" height = "400">

* *Delete*

<img src="Images/app_delete.png" width="800" height = "400">

### Databases
The following image shows CRUD operation on GCP MySQL database:
* *CRUD*

<img src="Images/gcp_CRUD.png" width="800" height = "400">

The following images shows CRUD operation on h2 database:
* *Create & Read*

<img src="Images/h2_dishes.png" width="800" height = "400">

* *Update*

<img src="Images/h2_update.png" width="800" height = "400">

* *Delete*

<img src="Images/h2_delete.png" width="800" height = "400">

### Postman
An application called the Postman is used to send data from the back-end to the database to make the coding lighter. An image of this application is displayed below:
* *Postman*

<img src="Images/postman.png" width="800" height = "400">

### Project Management
A Jira Board was used to tract this project. It has the capability for monitoring, project collaboration and, project planning and management. The image below shows all my panning and processes. 
* *Jira Board*

<img src="Images/jiraboard.png" width="800" height = "400">


### Testing
A Mokito unit testing was perform on my Back-End. This coverage of the test and give insights on where the code can be optimised. It test each function individually, which makes it easy to use for small testing. Coverages are displayed below, however 100% was not achieve as my code had extra functionalities that did not get test.
* *Unit Testing Coverage*

<img src="Images/unittesting.png" width="800" height = "400">

unittesting.png
 * *Integration Testing*
 
<img src="Images/integrationtesting.png" width="800" height = "400">

### Risk Assessment
* A risk assessment was perform to analyse and mitigate all potential risk. A table is presented below outlining these risks. 
 * *Risk Assessment*
 
<img src="Images/risk_as.png" width="800" height = "400">
.

## Known Issues
There are no known issues with performance for CRUD operations. 

## Future Improvements
There are a number of improvements that can be made to improve UX, UI, code improvement and Bug Fixes. Some improvements are outlined below:
 * *Improve front-end design which includes CSS, JavaScript and HTML to get a better UI and UX.*
 * *Test for bugs in the back end and front end after improvements.*
 * *Improve the back-end code to optimise speed.*

## Written By 
Alanzo
