# Food Trucks Locator API


## Overview
This is a web application that returns a list of 5 restaurants for a given latitude and longitude 

## Business Value
This application will provide team members with a list of the 5 food trucks available, according to the San Francisco's food truck open database, giving them the chance to enjoy of a variety of food available, and also to discover new places to eat. 

## Functional Requirements

### User Persona
The user will a team member who wants to buy food truck available nearby. 

### Acceptance Criteria
1.  GIVEN a user accessing the food truck search page
    WHEN both, latitude and longitude are entered
    THEN the system will prompt a list of the 5 closest food trucks in the area
2.  GIVEN a user accessing the food truck search page
    WHEN wrong data is inserted in either latitude or longitude fields or both
    THEN the system will return an error message
3.  GIVEN a user accessing the food truck search page
    WHEN no data is inserted in either latitude or longitude fields or none of them
    THEN the system will return an error message

### Assumptions
1. Since team members might have limited time for a break lunch, the system will list the 5 "closest" food trucks available from a particular latitude and longitude. To calculate the disctance, the haversine formula to calculate the great-circle-distance will be used.

## Architecture

The application will consist of a REST API with UI interface. The application will have 3 layers. 

### Components

1. **Delivery Channel Layer:** The application will expose an API and also a UI interface.
2. **Business Service Layer:** It will take care of reading and validating the input from Delivery Channel Layer, retrieve data from repository Layer and execute the business logic.
3. **Repository Layer:** It will interact with the data. 

### Assumptions
1. The repository data will be downloaded automatically from source every 5 minutes and loaded directly in memory. 

### Limitations
1. Whole Database is loaded into memory. There is a strong assumption that the data file will not be bigger than 500kb. If this condition changes, then database need to be persisted and repository layer must be enhanced. A good alternative would be a column base technology. simple SQL might work in first instance. 


### Dependencies 
1. The San Francisco's food truck open dataset. This data is available in CSV format and downloaded every 5 min.


### Security
Due to the sensitivity of data, no mayor security requirements are needed for now. 

### Tech Stack
Node.js

### API

### Logging

### Health 

### Testing

### Regulatory and Compliance

### SLOs 

### Metrics

### CICD

## Next Steps and Potential Future Requirements
1. Integrate the application with geo localizer to improve the insertion of the location. (inserting latitude, longitude is not trivial)
2. Include filters by food category (Chinese, American, Mexican, Chilean, Etc.)


## Prerequisites
1. Java SDK 8
2. Apache maven (for development purposes)

## How to execute it locally
1. Clone the project from this git repo 
```
git clone https://github.com/pmella/food-truck.git
```
2. install the application with the following command:
```
mvn clean install
```
3. execute the following command:
```
java -jar target/foodtruck-0.0.1-SNAPSHOT.jar
```



