# Sportyshoes API Application

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Sprint Planning](#sprint-planning)
* [Setup](#setup)

## General info
DESCRIPTION

As a Full Stack Developer, design and develop an E-commerce API application for Sporty Shoes. Use the GitHub repository to manage the project artifacts. 
 

ackground of the problem statement:

Sporty Shoes is a company that manufactures and sells sports shoes. They have a walk-in store, and now, they wish to launch their ecommerce portal sportyshoes.com.

The API application needs to have the following features:
managing of product: (add the system date to add/delete/update)
- add product   ---> @POST
- delete product  ---> @DELETE
- update the product details   ---> @PUT
- search the product by - ---> @GET + Path variable {id}/{season}/{brand}/{category}/{price}/{color}/{date}
    - season (winter, summer, rainy)
    - brand(nike /adidas/ puma)
    - category( male / female / both)
    - price (Asc/ Desc order)
    - product color (black, brown, white)
    - date -- latest products (means latest date)

browse the list of users:
- view users which are registered on the website  ---> @Get

purchase order reports filtered by date and category (use the table product_order)
- get all the product details   --> @Get
- get all the users till now    --> @Get
     
	
## Technologies
Project is created with:
* SpringToolSuite4
* JDK 8
* MySql
* Tomcat 9


## Sprint Planning
https://app.asana.com/0/1201757711653493/board

	
## Setup
This application is created using SpringToolSuite4. Used tomcat server version 9 to start the application and MySql as DB.