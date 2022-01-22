# Auction-Shortened-URL

Girilen URL'leri kısa, benzersiz ve kullanıcı özel URL üreten Spring Boot REST API uygulamasıdır.

## Kullanılan Teknolojiler

- JDK 11
- Spring Boot
- REST API
- Spring Data JPA
- MySQL
- Junit 5

## REST Servis Endpoint'leri

#### USER

- GET `api/users`  

  :arrow_right_hook: Oluşturulan kullanıcıları getirir

- POST `api/users` 

  :arrow_right_hook: Üye kaydı yapar

- GET  `api/users/{userId}` 

  :arrow_right_hook: UserId'ye göre kullanıcıyı getirir

- GET  `api/users/{userId}/{originalUrl}`

  :arrow_right_hook: UserId'ye ve OriginalUrl'e göre kısaltılmış URL'i getirir

- GET `api/users/{userId}/urls`

  :arrow_right_hook: UserId'ye göre URL'leri getirir
  

#### URL

- GET `api/urls/redirect/{redirectUrl}`   
 
  :arrow_right_hook: Girilen kısa URL'i gerçek adrese yönlendirir  
  
- GET `api/urls`      
 
  :arrow_right_hook: Oluşturulan bütün URL'leri getirir

- GET `api/urls/{urlId}`      
 
  :arrow_right_hook: Girilen Id'ye göre URL'i getirir

- POST `api/urls`
 
  :arrow_right_hook: Kısa URL oluşturur
  
- DELETE `api/urls/{urlId}`  

  :arrow_right_hook: Girilen Id'ye göre oluşturulan URL'i siler
