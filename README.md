# Practice: Spring Boots Test, Devtools, Actutor

## Part 1: Unit testing in JUnit 5 and Mockito

### 1.1. Project Structure: Reuse old Rest API project (JPA + OracleDB)

![](./image/Structure%20Program.PNG)

### 1.2. Write test cases for each layer

  * **Sample Oracle database used during testing**  
---
![](./image/Database.PNG)

* **Test Folder Structure**
---
![](./image/test-structure.PNG)

#### 1.2.1. CRUD methods for the Repository layer

* **Setup class TutorialRepositoryTest**
  ````
  * @Mock: virtual object, which simulates the behavior and properties of the real object
  ````
![](./image/bean-repository.PNG)

* **GET: find by published** 
![](./image/find-by-published-repository.PNG)

* **CREATE/UPDATE: save Tutorial**
![](./image/save-tutorial-repository.PNG)

* **DELETE: delete all Tutorials**
![](./image/delete-all-repository.PNG)

* **Result: Pass all test cases**
![](./image/result-repository.PNG)

#### 1.2.2. Write test cases for Service layer methods
* **Setup class TutorialServiceImplTest**

![](./image/set-up-service.PNG)

* **Find all Tutorials** 
![](./image/find-all-service.PNG)

* **Save Tutorial**
![](./image/save-tutorial-service.PNG)

* **Delete all Tutorials**
![](./image/delete-all-service.PNG)

* **Result: Pass all test cases**
![](./image/result-service.PNG)

#### 1.2.2. Write test cases for API of Controller layer
* **Setup class TutorialControllerTest**

![](./image/setup-controller.PNG)

* **API: GET /api/tutorials** 
![](./image/get-all-tutorials-controller.PNG)

* **API: GET /api/tutorials/{id}**
![](./image/get-tutorial-by-id-controller.PNG)

* **API: GET /api/tutorials/published**
![](./image/find-by-published-controller.PNG)


* **API: POST /api/tutorials**
![](./image/create-tutorial-controller.PNG)
* **API: PUT /api/tutorials/{id}**
![](./image/update-tutorial-controller.PNG)
* **API: DELETE /api/tutorials/{id}**
![](./image/delete-tur-controller.PNG)
* **API: DELETE /api/tutorials/**
![](./image/delete-all-t%E1%BB%A7-controller.PNG)

* **Result: Pass all test cases**
![](./image/result-controller.PNG)

## Part 2: Setting Actuator and DevTools


### 2.1. Spring Boot Actuator
##### Dependence
  ````
  <dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>

  ````
##### The corresponding configuration in the file application.properties
![](./image/actuator-config.PNG)
* Set up port 8090 for monitoring management
* Set enable for all endpoints
* Shut down the application using Actuator
  
##### Result
* Run-time port 8090
![](./image/port-8090-actuator.PNG)
* Actuator Endpoints
  ![](./image/actuator-endpoint.PNG)
  
* Actuator Health
   ![](./image/actuator-health.PNG)
* Actuator ShutDown
  * Postman request **API: POST /actuator/shutdown**
  ![](./image/postman-shutdown-actuator.PNG)

  * Console
  ![](./image/console-shut-down.PNG)

### 2.2. DevTools
* **Dependence**
  ````
  <dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
	<optional>true</optional>
  </dependency>
  ````

* **Settings when using IntelliJ**
  ![](./image/setting-devtools-intellij.PNG)

* **The program is running on port 8090**
  ![](./image/program-run-8090.PNG)

  ![](./image/actuator-endpoint.PNG)
* **Set up port 8091 for monitoring management**
* **Endpoints after changing port 8091**
  * Port 8090:
  ![](./image/falied-8090.PNG)
  * Port 8091:
  ![](./image/success-devtol-8091.PNG)
  

