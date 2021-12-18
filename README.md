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

- `api/user/getAll`  

  :arrow_right_hook: Oluşturulan kullanıcıları getirir

- `api/user/signup` 

  :arrow_right_hook: Üye kaydı yapar

#### URL

- `api/url/{redirectUrl}`   
 
  :arrow_right_hook: Girilen kısa URL'yi gerçek adrese yönlendirir  
  
- `api/url/getAllUrls`      
 
  :arrow_right_hook: Oluşturulan bütün URL'leri getirir

- `api/url/getByUrlId`      
 
  :arrow_right_hook: Girilen Id'ye göre URL'yi getirir

- `api/url/getAllByUserId`
 
  :arrow_right_hook: Girilen userId'ye göre kullanıcının oluşturduğu URL'leri getirir

- `api/url/getShortenedUrl`
 
  :arrow_right_hook: Girilen userId ve URL'ye göre oluşturulan kısa URL'yi getirir

- `api/url/createUrl`
 
  :arrow_right_hook: Kısa URL oluşturur
  
- `api/url/deleteUrl`  

  :arrow_right_hook: Girilen Id'ye göre oluşturulan URL'yi siler
