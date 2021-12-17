# Auction-Shortened-URL
Auction Shortened URL

Girilen URL'leri kısa, benzersiz ve kullanıcı özel URL üreten Spring Boot Rest API uygulamasıdır.

## Kullanılan Teknolojiler
- JDK 11
- Spring Boot
- Restful API
- Spring Data JPA
- MySQL
- Junit 5

## API'ler

### USER
- api/user/getAll  

  Oluşturulan kullanıcıları getirir

- api/user/signup 

  Üye kaydı yapar

### URL
- api/url/{redirectUrl}   
 
  Girilen kısa URL'yi gerçek adrese yönlendirir
  
  
- api/url/getAllUrls      
 
  Oluşturulan bütün URL'leri getirir


- api/url/getByUrlId      
 
  Girilen Id'ye göre URL'yi getirir


- api/url/getAllByUserId
 
  Girilen userId'ye göre kullanıcının oluşturduğu URL'leri getirir


- api/url/getShortenedUrl
 
  Girilen URL'ye göre oluşturulan kısa URL'yi getirir


- api/url/createUrl
 
  Kısa URL oluşturur


- api/url/deleteUrl  

  Girilen Id'ye göre oluşturulan URL'yi siler
