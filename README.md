# StorageApp

StorageApp is created to help you keep track of your possessions whereabouts, where are they stored, what other items are there and so forth. 

## Business logic
A user can create storages (and storages in storages), which hold items.
The items have a name, value, weight, color, and if needed then an image and a serial number can be added.  

The user is able to register as regular or business client. Regular customers have no item limit, business clients have one that is set by the admin, every item over limit is taxed by 1 cent.
Admin user can see statistics such as how many items each user has. Also how many business clients exceed their limit and how many they have to pay as a consequence.  

## Stack 

Client: `Angular 13.3.5`
Server: `Java Spring Boot 2.7.0 | Java 11 | `
Database: `Postgres 14`

## Deployment
**client side**:
Open command prompt and navigate to client folder 
`cd /client`
install dependencies
`npm i` 
launch
`ng serve`

**server side**:
Open backend folder with suitable IDE,
right click `pom.xml` then select ->**Maven** and lastly->**Reload Project** 
Then either:
 1) Spring boot application has an entry point Java class called _SpringbootBackendApplication_ with the _public static void main(String[] args)_ method, which you can run to start the application.
 2) Or you can start the spring boot application via the command line using this command:  `mvn spring-boot:run` .

## ERD
![storage-app-2022-06-18_20-25](https://user-images.githubusercontent.com/71014202/174450143-a70799a3-a360-4f68-ad67-399a1edfeed1.png)
