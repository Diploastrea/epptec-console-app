# Solution for homework from eppTec 

## How to start
- Git clone repository
- `cd` into `epptec-console-app` folder and run `java -jar epptec-console-app.jar` in command line

## App features
All data will be stored in a `db.txt` file, which serves as a database. The file will be created automatically if it doesn't exist already. Upon start up, database will be loaded into an `ArrayList<Person>`, upon exit any changes will be saved into the database.
- ### Adding new person  
Provide first name, last name and ID number (must be unique). If first or last name is empty or ID is in incorrect format, an error message will be displayed.
- ### Remove person
Provide ID of the person to remove, if given person is not found, an error message will be displayed.
- ### Find person by ID
Provide ID of the person to print their details (full name, age, ID). If given person is not found, an error message will be displayed.
- ### List people in database
Implemented for testing purposes. Prints details of each person in the database, if the database is empty, a simple message will be displayed instead.
