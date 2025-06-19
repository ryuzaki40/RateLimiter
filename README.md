# 🚦 RateLimiter (Spring Boot)

A lightweight rate limiting component built using Spring Boot to restrict excessive API usage from clients using a simple in-memory algorithm.

## 🔧 Features
- Simple in-memory rate limiting
- Thread-safe using `ConcurrentHashMap`
- Easy to integrate into existing Spring Boot projects
- Configurable request limits and time window

## 🧪 API Endpoint

| Method | Endpoint         | Query Params          | Description                          |
|--------|------------------|-----------------------|--------------------------------------|
| GET    | `/api/data`      | `clientId=user123`    | Returns protected data if allowed    |

## ⚙️ How It Works
Each client is identified by a `clientId`. If a client sends more than 5 requests in 60 seconds, further requests are blocked temporarily.

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3.5.0

## 🚀 Getting Started

```bash
git clone https://github.com/ryuzaki40/RateLimiter.git
cd RateLimiter
mvn spring-boot:run
