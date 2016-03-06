Letter Conversion
============

# Description
Converts a form with inputs to a pdf business letter.

## Prerequisites
+ Apache Tomcat
+ JDK
+ JRE
+ Spring MVC

## Installation
At first, clone or download this project. Afterwards, start an IDE (e. g. `Eclipse`) and import this web application as a dynamic web project. Thereafter, convert this project to a maven project. Eventually, add a new server to this maven project.

## Usage
First of all, it is very important to change the deployment path of the tomcat regarding this project. To do that, open the `XML.java` in the directory `src` and change the value of the variable `basePath`. Afterwards, start the Apache Tomcat for this project in the section `Servers`. Open your browser and visit the url `localhost:8080/letterConversion/`.

## More information
Generate the documentation regarding the special comments with a command in your terminal or with an IDE such as `Eclipse`. Furthermore, read the documentation about the framework `Spring MVC` at
https://spring.io/docs.
