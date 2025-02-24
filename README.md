# 🌤️ Weather App (Spring Boot & Next.js)

A **Weather Forecast Application** built with **Spring Boot (backend)** and **Next.js (frontend)** using **OpenWeather API** to fetch real-time weather data.

## 🚀 Features
✔️ Get real-time weather updates for any city   
✔️ Supports **Celsius** & **Fahrenheit** toggle ️  
✔️ Caching to reduce API calls   
✔️ Multi-language support    
✔️ Dynamic backgrounds based on temperature 

## 🛠️ Tech Stack
### **Backend:**
- Java + Spring Boot 
- Spring Web, Spring Cache
- Gradle (Build Tool)
- OpenWeather API ️

### **Frontend:**
- Next.js 
- TailwindCSS
- shad cn

---

## 🔑 API Details
This application integrates with the **OpenWeather API** to fetch weather details.

### **Base API URL**
```bash
https://api.openweathermap.org/data/2.5/weather
```
---

## 🔧 Installation & Setup

### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/VeenaDharshini/My-Weather-App-Server.git
cd weather-app 
```

### **2️⃣ Backend Setup (Spring Boot)**
- Make sure you have **Java 17+** and **Gradle** installed.
- Configure your **API Key** in `application.properties`:
```properties
openweather.api.key=YOUR_OPENWEATHER_API_KEY
openweather.api=https://api.openweathermap.org/data/2.5/weather
```
- Run the application:
```bash
./gradlew bootRun
```

### **3️⃣ Frontend Setup (Next.js)**
```bash
git clone https://github.com/VeenaDharshini/My-Weather-App-UI.git
cd weather-app-ui
```
- Go to the frontend folder:
```bash
node required : 18 + (or later)
cd frontend
pnpm install
```
- Start the frontend server:
```bash
pnpm run dev
```
---

##  Environment Variables

```bash
NEXT_PUBLIC_API_BASE_URL="http://localhost:8080/api/"
CACHE_TTL=3600  # Cache duration in seconds
```

---

##  API Endpoints (Backend)
| HTTP Method | Endpoint | Description                    |
|-------------|---------|--------------------------------|
| `POST`      | `/api/weather` | Get weather details for a city |
---

##  Future Enhancements
🔹 Add historical weather data   
🔹 Allow user location detection   
🔹 Improve UI animations & design 
---



