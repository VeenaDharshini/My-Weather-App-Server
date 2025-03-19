# 🌤️ Weather App (Spring Boot & Next.js)

A **Weather Forecast Application** built with **Spring Boot (backend)** and **Next.js (frontend)** using **OpenWeather API** to fetch real-time weather data.
🌟 **Live Now →** [**Check it out here!**](https://my-weather-app-two.vercel.app/) 


## 🚀 Features

✔️ Get real-time weather updates for any city  
✔️ Supports **Celsius** & **Fahrenheit** toggle ️  
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
- Configure your **API Key** in `.env`:

```properties
OPEN_WEATHER_API=https://api.openweathermap.org/data/2.5
OPEN_WEATHER_API_KEY=your-open-weather-api-key
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

## Environment Variables

```bash
NEXT_PUBLIC_API_BASE_URL="https://elegant-celebration-production.up.railway.app/api/"
```

---

## API Endpoints (Backend)

| HTTP Method | Endpoint       | Description                    |
| ----------- | -------------- | ------------------------------ |
| `POST`      | `/api/weather` | Get weather details for a city |

---

## Future Enhancements

🔹 Add historical weather data  
🔹 Allow user location detection  
🔹 Improve UI animations & design

---
