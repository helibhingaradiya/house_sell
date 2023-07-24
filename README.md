Coding-Assignment

Technology use in that project are spring boot,maven,mysql database.

project built using sppring spring initializr

dependancy use in this assignment project:
   1. maven
   2. lombok
   3. gson
   4. mysql service
   5. spring-boot-starter-data-jpa

Api curl and it's response :

1. Average sale price of the house overall:
   curl --location 'localhost:8080/api/house/averageSalePriceOverall'
   {
    "message": "getting average Seling price!!",
    "requestBody": "252461.53846153847"
   }

 2. Average sale price of the house per location:
  curl --location 'localhost:8080/api/house/averageSalePricePerLocation'
   {
    "message": "Getting Successfully!!!!",
    "requestBody": "[{\"location\":\"A\",\"average\":245217.39130434784},{\"location\":\"B\",\"average\":242380.95238095237},{\"location\":\"C\",\"average\":270476.1904761905}]"
  }   

 3. Max sale price:
   curl --location 'localhost:8080/api/house/maxSalePrice'
   {
    "message": "getting max Seling price!!",
    "requestBody": "350000.0"
   }

 4. Min sale price:
  curl --location 'localhost:8080/api/house/minSalePrice'
  {
    "message": "getting min Seling price!!",
    "requestBody": "150000.0"
  }
