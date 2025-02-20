# 🚀 **TCP Producer and Consumer Services** 🚀

This project contains two services designed to work together to receive messages via TCP, publish them to RabbitMQ, and store them in Elasticsearch.

---

## 🛠️ **Services**

### 1. **tcp-producer-service** 📡
The **tcp-producer-service** receives messages from a TCP server and then publishes them to a RabbitMQ queue. It acts as the message producer.

### 2. **tcp-consumer-service** 🔄
The **tcp-consumer-service** listens to the RabbitMQ queue and retrieves messages, which it then writes to an Elasticsearch index for storage and analysis.

---

## ⚙️ **Technologies Used**

- ![Java](https://img.shields.io/badge/Java-8-blue) Java 8
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.5.4-blue)
- ![RabbitMQ](https://img.shields.io/badge/RabbitMQ-v3.8.16-blue)
- ![Elasticsearch](https://img.shields.io/badge/Elasticsearch-7.10-blue)
- ![Docker](https://img.shields.io/badge/Docker-v20.10-blue)

---

## 🔧 **Setup Instructions**

### Prerequisites

1. Install **Java 8**
2. Install **Docker** (for running services in containers)

### 1. **Clone the repository:**
   ```bash
   git clone https://github.com/username/tcp-producer-consumer.git
