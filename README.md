Database Setup
1. Create a database named intern in MySQL:

   CREATE DATABASE intern;
   USE intern;

2.Create the Registration table:
   
   CREATE TABLE Registration (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    DateOfBirth DATE NOT NULL,
    PhoneNumber VARCHAR(15),
    Address TEXT
);


3. Update the DatabaseConnection class in the code with your MySQL credentials:

private static final String URL = "jdbc:mysql://localhost:3306/registration_db";
private static final String USER = "root";
private static final String PASSWORD = "Kundana@2002";



Steps to Run With Maven
1.Add the MySQL Connector dependency in your pom.xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.34</version>
</dependency>


2.Run the project using Maven
mvn compile
mvn exec:java -Dexec.mainClass="Main"


Project Structure
/src
├── DatabaseConnection.java   # Handles database connection
├── RegistrationDAO.java      # CRUD operation logic
├── Main.java                 # Entry point to test the CRUD operations
/pom.xml (using Maven)






