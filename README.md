# Practice: Spring Boots Test, Devtools, Actutor

## Part 1

### 1.1. Project Structure: Reuse old Rest API project (JPA + OracleDB)

![](./image/Structure%20Program.PNG)

### 1.2. Write test cases for each layer (Using JUnit + Mockito)

  * **Sample Oracle database used during testing**  
---
![](./image/Database.PNG)

* **Test Folder Structure**
---
![](./image/test-structure.PNG)

#### 1.2.1. CRUD methods for the repository layer

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

#### 1.2.2. Write test cases for service layer methods
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

#### 1.2.2. Write test cases for controller layer api
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
