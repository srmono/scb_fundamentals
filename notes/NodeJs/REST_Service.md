# REST API / REST Service Fundamentals for Beginners

## 1. What is REST?
**REST** (Representational State Transfer) is an **architectural style** for designing networked applications.  
It uses **HTTP** for communication and treats **everything as a resource**.

### Key Ideas:
- **Resources**: Things you can access (e.g., a user, a product, an order)
- **Resource Identifiers**: URLs that uniquely identify a resource
- **Representations**: Data format used to represent the resource (JSON, XML, HTML)

---

## 2. REST vs REST API vs REST Service
- **REST** → The design style
- **REST API** → An API built using REST principles
- **REST Service** → A service that exposes data or operations over REST

---

## 3. REST Principles (Constraints)
1. **Client–Server**  
   - Separation between the client (frontend) and the server (backend)
   
2. **Stateless**  
   - Each request is independent; the server does not remember the client's state
   
3. **Cacheable**  
   - Responses can be stored (cached) to improve performance
   
4. **Uniform Interface**  
   - Consistent way to interact with resources (same structure, naming, etc.)
   
5. **Layered System**  
   - Clients may not know if they’re connected directly to the server or through intermediaries
   
6. **Code on Demand** *(optional)*  
   - Server can send executable code (like JavaScript) to the client

---

## 4. HTTP Methods in REST
| Method   | Purpose                                | Example                  |
|----------|----------------------------------------|--------------------------|
| **GET**  | Retrieve a resource                    | `GET /users`             |
| **POST** | Create a new resource                  | `POST /users`            |
| **PUT**  | Update/replace an existing resource    | `PUT /users/123`         |
| **PATCH**| Partially update an existing resource  | `PATCH /users/123`       |
| **DELETE** | Remove a resource                    | `DELETE /users/123`      |

---

## 5. REST URL Design Best Practices
- Use **nouns** for resources:  
  ✅ `/users` instead of ❌ `/getUsers`
- Use **plural** resource names:  
  ✅ `/products` instead of ❌ `/product`
- Nest resources for relationships:  
  ✅ `/users/123/orders/456`
- Avoid verbs in URLs; verbs go in **HTTP methods**

---

## 6. REST Request & Response

### Example Request:
```http
GET /users/1 HTTP/1.1
Host: api.example.com
Accept: application/json
````

### Example Response:

```json
{
  "id": 1,
  "name": "Alice",
  "email": "alice@example.com"
}
```

---

## 7. HTTP Status Codes in REST

| Code                          | Meaning                        | Example Use Case |
| ----------------------------- | ------------------------------ | ---------------- |
| **200** OK                    | Successful GET request         |                  |
| **201** Created               | Resource created via POST      |                  |
| **204** No Content            | Successful DELETE              |                  |
| **400** Bad Request           | Invalid request data           |                  |
| **401** Unauthorized          | Missing/invalid authentication |                  |
| **404** Not Found             | Resource not found             |                  |
| **500** Internal Server Error | Unexpected server failure      |                  |

---

## 8. REST vs SOAP

| REST                 | SOAP                            |
| -------------------- | ------------------------------- |
| Lightweight          | Heavyweight                     |
| Uses HTTP & JSON/XML | Uses XML only                   |
| Stateless            | Can be stateful or stateless    |
| Easier for web apps  | More suited for enterprise apps |

---

## 9. Common REST API Tools

* **Testing**: Postman, Insomnia
* **Documentation**: Swagger (OpenAPI), Redoc
* **Frameworks**: Express.js, Spring Boot, Django REST Framework

---

## 10. Summary

* REST is about **resources** and **stateless communication**.
* Use **HTTP methods** to perform actions.
* Keep URLs **clean, consistent, and noun-based**.
* Always return proper **HTTP status codes**.

