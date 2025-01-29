Tour Management System
Project Overview
The Tour Management System is a Java-based application designed to manage travel tours, guides, bookings, and customer interactions. It uses PostgreSQL as its database and follows an object-oriented programming (OOP) approach with design patterns such as Singleton for database management.

Project Structure
The system consists of the following key classes:

DatabaseHandler.java (Database Management - Singleton Pattern)
Manages the connection to the PostgreSQL database.
Ensures a single instance of the database connection is used throughout the application.
Sets up necessary tables (tours, guides, bookings, tour_guides, etc.).
Tour.java (Encapsulation for Tours)
Represents a travel tour with attributes like id, name, location, price, and dates.
Uses getters and setters for encapsulation.
Overrides toString() to display tour details.
#Guide.java (Encapsulation for Guides)

Represents a tour guide with attributes like id, name, and language.
Uses getters and setters.
Overrides toString() to display guide details.
#Admin.java (Admin Operations)

Allows admins to:
Add new tours to the database.
Add new guides to the system.
Assign guides to specific tours (stored in tour_guides table).
Retrieve and display all tours and guides.
Uses JDBC (Java Database Connectivity)to interact with PostgreSQL.
#TourManagementSystem.java (Main Class - Entry Point)

The main execution file that initializes the system.
Connects to the database using DatabaseHandler.
Creates sample tours and guides, assigns guides to tours.
Displays all tours and guides.
Technologies Used
Java (Core OOP principles)
PostgreSQL (Database Management)
JDBC (Database connectivity)
Git & GitHub (Version Control)
Database Schema(PostgreSQL Tables)
The system manages the following tables:

CREATE TABLE IF NOT EXISTS tours (
    id SERIAL PRIMARY KEY,
    name TEXT,
    location TEXT,
    price REAL,
    dates TEXT
);

CREATE TABLE IF NOT EXISTS guides (
    id SERIAL PRIMARY KEY,
    name TEXT,
    language TEXT
);

CREATE TABLE IF NOT EXISTS tour_guides (
    tour_id INTEGER REFERENCES tours(id),
    guide_id INTEGER REFERENCES guides(id),
    PRIMARY KEY (tour_id, guide_id)
);
How to Run the Project?
Clone the Repository
git clone https://github.com/AzizaSdv/TourManagementSystem.git
cd TourManagementSystem
Set Up the Database(PostgreSQL)
Install PostgreSQL if not already installed.
Create a database named tour_management.
Run the SQL schema above to create tables.
Run the Java Program
Open the project in IntelliJ IDEA.
Ensure PostgreSQL is running.
Run the TourManagementSystem.java file.
The system will:
Connect to the database.
Add sample tours and guides.
Assign guides to tours.
Display the list of available tours and guides.
Expected Console Output
Database setup completed successfully.
Guide added: Guide: John Doe, Language: English
Guide added: Guide: Maria Gonzalez, Language: Spanish
Guide assigned to tour: Dubai Islands
All guides in system:
ID: 1, Name: John Doe, Language: English
ID: 2, Name: Maria Gonzalez, Language: Spanish
All tours in system:
ID: 1, Name: Beach Adventure, Location: Hawaii, Price: $1500.5, Dates: 2025-06-15 to 2025-06-20
ID: 2, Name: Dubai Islands, Location: Dubai, Price: $4000.5, Dates: 2025-04-15 to 2025-04-20
Future Improvements
Add a booking system for customers. Implement GUI (Graphical User Interface). Add user authentication (Admin vs. Customers). Implement REST API for external access.

Author:
AzizaSdv (Me: Aziza Saiduova)- Tour Management System
