Nursery Management System Introduction:

The Nursery Management System Application is a powerful and efficient tool designed to streamline the management processes of nurseries, garden centers, and plant retailers. It is specifically tailored to cater to the unique needs and challenges faced by professionals in the nursery industry. This application serves as a comprehensive solution to manage and organize various aspects of nursery operations, including plant inventory, sales, customer management, and more.

With the Nursery Management System Application, nursery owners and managers can effectively monitor and control their entire nursery operation from a single, centralized platform. This application automates and simplifies time-consuming tasks, enabling nursery professionals to focus on providing quality care to plants and delivering exceptional customer service.

 Before you begin, please make sure that you have the following prerequisites installed:

Java Development Kit (JDK) version 8 or higher Maven build tool version 3.2 or higher MySQL relational database management system version 5.6 or higher

Installing and Running the Application

Clone the dangerous-powder-9842 project repository from GitHub using the following command: “git clone https://github.com/psudhansu/dangerous-powder-9842.git”

Create a MySQL database and configure the database settings in the application.properties file located in the src/main/resources directory. 
The default database settings are as follows: 
“spring.datasource.url=jdbc:mysql://localhost:3306/Nursery
 spring.datasource.class.driver=com.mysql.cj.jdbc.Driver
 spring.datasource.username=root 
 spring.datasource.password=root”
 Please make sure to replace the database URL, username, and password with your own database settings. Please make sure to configure the database settings and other environment-specific settings in the application.properties file before deploying the application to a production environment. 
Architecture The Nursery Management System is built using the Model-View-Controller (MVC) architecture pattern. The application is developed by using Java Core, Spring Boot, and MySQL.
 The MVC architecture pattern separates the application into three main components: The Model, The View, and The Controller. This separation of concerns allows for easier development, maintenance, and testing of the application. Controller The Controller acts as an intermediary between the Model and the View. It handles user requests, processes input data, and updates the Model and the View accordingly. In the Nursery Management application, the Controller is implemented using Spring MVC, which provides a robust and flexible framework for building web applications. The Nursery Management System application uses MySQL as its relational database management system. The database stores and retrieves data related to Customers, Plants, planters, Seeds and Orders. The database is accessed using the Spring Data JPA framework, which provides a powerful and easy-to-use interface for working with databases. Overall, the Nursery Management System is designed to be a scalable and maintainable web application that follows industry-standard architecture patterns and best practices.
 
Modules

Admin Module: This module allows users to register as admin, delete admin, and getadmin out of the application. 

Customer Module: This module enables customers to search for seeds,plants and planters, and purchase plants, planters and seeds in the Nursery. 

Planter Module: This module enables admins to manage the Planters in the Nursery. It includes functionality for searching for Planters, adding planters to the database, viewing Planter details,update planters ,and delete planters. 

Plant Module: This Module enables admins manage the Plant in the Nursery. It includes functionality for searching for Plants, adding plants to the database, viewing Plant details,update plants ,and delete plants.

Seed Module: This Module enables admins manage the Seed in the Nursery. It includes functionality for searching for Seeds, adding Seeds to the database, viewing Seed details,update Seeds ,and delete Seeds.

Order Module: This module enables customers to create and manage orders. It includes functionality for viewing order history and details.

 Customer Module To add a new product to the database: 
• Endpoint: POST /registerCustomer 
• Request Body: JSON object containing the Customer details, for example: { "customerName": "Shweta", "customerEmail": "123@gmail.com", "phoneNo": "696789023", "password": "Ab90@", "Address": "address" }
• Response: JSON object containing the saved product details, including the generated product ID. 

• To update an existing customer: 
• Endpoint: PUT /UpdateCustomer
• Request Body: JSON object containing the new customer details with customer Id, for example:
{ "CustomerId":1,"name": "New Customer Name", "CustomerEmail": "New Customer Email", "phoneNo": "New phoneNo", "password": "New password","Address":"New Address" }
• Response: JSON object containing the updated Customer details. 

• To delete a customer from the database: 
• Endpoint: DELETE /deleteCustomer/{custId} 
• Response: JSON object containing the deleted customer details. 

• To retrieve a specific customer from the database:
 • Endpoint: GET /customer/{custId} 
• Response: JSON object containing the customer details.


 • To retrieve all products in the database:
 • Endpoint: GET /customers
 • Response: JSON array containing all customers in the database, each represented as a JSON object.

Customer Module :- 
Retrieves all customers in the system. 
• URL: /customers 
• Method: GET 
• URL Params: None 
• Success Response: Code: 200 OK
Content: [ { "customerId": 1,
"CustomerName": "Customer1",
"customerEmail":"customerEmail", "phoneNo": "phoneNo1",
"password": "password 1","Address":"address1"}]

Retrieves a specific customers by ID.
• URL: /customer/{custid} 
• Method: GET 
• URL Params:id: The ID of the customer to retrieve.
• Success Response: Code: 200 OK
Content:
{ "customerId": 1,
"CustomerName": "Customer1",
"customerEmail":"customerEmail", "phoneNo": "phoneNo1",
"password": "password 1","Address":"address1"}

Add a new customer to the System
• URL: /registerCustomer 
• Method: POST 
• URL Params: None
 Request Body: {"customerId": 1,
"CustomerName": "Customer1",
"customerEmail":"customerEmail", "phoneNo": "phoneNo1",
"password": "password 1","Address":"address1"}
• Success Response: • Code: 200 OK
Content: { "customerId": 1,
"CustomerName": "Customer1",
"customerEmail":"customerEmail", "phoneNo": "phoneNo1",
"password": "password 1","Address":"address1"}

Updates an existing customer in the system.
 • URL: /UpdateCustomer
 • Method: PUT 
 • URL Params: None 
 • Request Body: { "customerId": 1,
"CustomerName": "Customer1",
"customerEmail":"customerEmail", "phoneNo": "phoneNo1",
"password": "password 1","Address":"address1" }

• Success Response: • Code: 200 OK
Content: { "customerId": 1,
"CustomerName": "Customer1",
"customerEmail":"customerEmail", "phoneNo": "phoneNo1",
"password": "password 1","Address":"address1"}


Plant Module:-
Retrieves all plants in the system based on typeofPlant. 
• URL: /plantViewAll/{typeOfPlant}
• Method: GET 
• URL Params: typeOfPlant 
• Success Response: Code: 200 OK
Content: [{"plantId": 1,
"plantHeight": 12,
"commonName":"commonName", "blommTime": "bloomtime1",
"medicinalOrCulinaryUse":"medicinalOrCulinaryUse",
"temperature":"temperature","typeOfPlant":"typeOfPlant",
"plantDescription":"plantDescription",
"plantCost":"plantCost" }]

Retrieves a specific plant by ID.
• URL: /plantView/{plantid} 
• Method: GET 
• URL Params:plantId: The ID of the plant to retrieve.
• Success Response: Code: 200 OK
Content:{{"plantId": 1,
"plantHeight": 12,
"commonName":"commonName", "blommTime": "bloomtime1",
"medicinalOrCulinaryUse":"medicinalOrCulinaryUse",
"temperature":"temperature","typeOfPlant":"typeOfPlant",
"plantDescription":"plantDescription",
"plantCost":"plantCost" }}


Add a new plant to the System
• URL: /plantsave 
• Method: POST 
• URL Params: None
 Request Body: {"plantId": 1,
"plantHeight": 12,
"commonName":"commonName", "blommTime": "bloomtime1",
"medicinalOrCulinaryUse":"medicinalOrCulinaryUse",
"temperature":"temperature","typeOfPlant":"typeOfPlant",
"plantDescription":"plantDescription",
"plantCost":"plantCost" }
• Success Response: • Code: 200 OK
Content: { {"plantId": 1,
"plantHeight": 12,
"commonName":"commonName", "blommTime": "bloomtime1",
"medicinalOrCulinaryUse":"medicinalOrCulinaryUse",
"temperature":"temperature","typeOfPlant":"typeOfPlant",
"plantDescription":"plantDescription",
"plantCost":"plantCost" }}

Updates an existing plant in the system.
 • URL: /plantUpdate
 • Method: PUT 
 • URL Params: None 
 • Request Body: { {"plantId": 1,
"plantHeight": 12,
"commonName":"commonName", "blommTime": "bloomtime1",
"medicinalOrCulinaryUse":"medicinalOrCulinaryUse",
"temperature":"temperature","typeOfPlant":"typeOfPlant",
"plantDescription":"plantDescription",
"plantCost":"plantCost" }}

• Success Response: • Code: 200 OK
Content: { {"plantId": 1,
"plantHeight": 12,
"commonName":"commonName", "blommTime": "bloomtime1",
"medicinalOrCulinaryUse":"medicinalOrCulinaryUse",
"temperature":"temperature","typeOfPlant":"typeOfPlant",
"plantDescription":"plantDescription",
"plantCost":"plantCost" }}

 Planter Module To add a new Planter to the database: 
• Endpoint: POST /planters
• Request Body: JSON object containing the Planter details, for example: { "planterHeight": 10, "planterCapacity": 10, "drinageHole": 5, "planterColor": "red", "planterShape": "Round","planterStock":400,"planterCost":200 }
• Response: JSON object containing the saved product details, including the generated planterID. 

• To update an existing planter: 
• Endpoint: PUT /UpdatePlanter
• Request Body: JSON object containing the new planter details with customer Id, for example:
{ "planterId":1,"planterHeight": 10, "planterCapacity": 10, "drinageHole": 5, "planterColor": "red", "planterShape": "Round","planterStock":400,"planterCost":200 }
• Response: JSON object containing the updated Customer details. 

• To delete a planter from the database: 
• Endpoint: DELETE /DeletePlanter/{planterId} 
• Response: JSON object containing the deleted planter details. 

• To retrieve a specific planter from the database:
 • Endpoint: GET /planter/{planterId} 
• Response: JSON object containing the planter details.


 • To retrieve all planters in the database:
 • Endpoint: GET /planters
 • Response: JSON array containing all planters in the database, each represented as a JSON object.

Seed Module:-
Seed Module To add a new Seed to the database: 
• Endpoint: POST /Seeds
• Request Body: JSON object containing the Planter details, for example: { "commonName": "commonName1", "bloomTime": "summer", "watering": "watering1", "typeOfSeeds": "vegitable", "SeedsDescription": "Description","SeedsCost":200,"SeedsPerPacket":500 }
• Response: JSON object containing the saved Seed details, including the generated SeedID. 

• To update an existing Seed: 
• Endpoint: PUT /seeds/{seedId}
• Request Body: seedId example:
• Response: JSON object containing the updated Seed details of mentioned SeedId. 

• To delete a \Seed from the database: 
• Endpoint: DELETE /seed/{seedId} 
• Response: String with message "Delete Successfully"

• To retrieve a specific Seed from the database:
 • Endpoint: GET /seedId/{seedId} 
• Response: JSON object containing the seed details.


 • To retrieve all seeds in the database:
 • Endpoint: GET /seeds
 • Response: JSON array containing all seeds in the database, each represented as a JSON object.


To interact with the database, the application uses Spring Data JPA which provides an easy-to-use interface for performing CRUD (Create, Read, Update, Delete) operations on the database tables. The application also uses Hibernate as the Object-Relational Mapping (ORM) framework to map the POJO classes to the database tables.

Overall, the use of a relational database in the Nursery Management System provides a scalable and reliable solution for managing the data of seeds, plants,planters, and orders.

 ERDIAGRAM Admin Module The Admin Controller is responsible for handling all the requests made by the admin for managing the plants,orders,planters and seeds in the Nursery Management System. The controller communicates with the AdminService, ProductService and other Service classes. 

Deployment This section should provide instructions for deploying the application to a production environment, including any necessary configuration steps and best practices for security and performance.

Conclusion I hope this documentation provides you with a clear understanding of the Nursery Management System. If you have any questions or require further clarification, please do not hesitate to reach out. We are here to assist you in any way we can. Thank you for considering this documentation.
