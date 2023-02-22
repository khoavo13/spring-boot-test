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

* **Inject Bean into TutorialRepositoryTest**
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