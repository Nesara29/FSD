<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:1a1a2e,50:16213e,100:1a1a2e&height=200&section=header&text=FULL%20STACK%20DEVELOPMENT%20LAB&fontSize=30&fontColor=EDEAE0&animation=fadeIn&fontAlignY=38&desc=React%20%C2%B7%20Spring%20Boot%20%C2%B7%20MongoDB%20%C2%B7%20JUnit&descAlignY=58&descSize=16&descColor=E94560" width="100%"/>

<br/>

<p>
  <img src="https://img.shields.io/badge/Frontend-React%20%2F%20JS-61DAFB?style=for-the-badge&logo=react&logoColor=black" alt="React / JS"/>
  <img src="https://img.shields.io/badge/Backend-Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Database-MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white" alt="MongoDB"/>
  <img src="https://img.shields.io/badge/Testing-JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit"/>
  <img src="https://img.shields.io/badge/License-Educational%20Use-7F5AF0?style=for-the-badge" alt="License"/>
</p>

<h3>🧪 A collection of Full Stack Development lab experiments — vanilla JS, React, Spring Boot, MongoDB, and JUnit</h3>

</div>

---

## 📖 Overview

This repository is a **lab notebook** rather than a single application — a set of standalone Full Stack Development exercises, each in its own folder, covering form handling in vanilla JavaScript and React, CRUD with and without a REST API, MongoDB integration, JUnit testing, and static page/login UI design.

## 🧪 Experiments Index

<div align="center">

| # | Experiment | Stack |
|---|---|---|
| exp-4 | Registration form using JavaScript | HTML, CSS, vanilla JavaScript |
| exp-5 | Registration form using React | React |
| exp-6 | Shopping cart | React |
| exp-7 | Navigation using React | React, React Router |
| exp-8 | CRUD without an API | Java, Spring Boot, Maven |
| exp-9 | CRUD with an API | Java, Spring Boot, Maven, REST |
| exp-11 | CRUD using MongoDB | Java, Spring Boot, Spring Data MongoDB |
| exp-12 | JUnit testing | Java, Spring Boot, JUnit 5 |
| — | Login / signup page design | HTML, CSS |

</div>

## 🛠️ Technology Stack

<div align="center">

![My Skills](https://skillicons.dev/icons?i=html,css,js,react,java,spring,mongodb,maven,git)

</div>

| Category | Technology |
|---|---|
| **Frontend basics** | HTML5, CSS3, vanilla JavaScript |
| **Frontend framework** | React (with React Router) |
| **Backend** | Java, Spring Boot, Spring Data JPA, Spring Data MongoDB |
| **Database** | MongoDB (exp-11), in-memory/relational (exp-8, exp-9) |
| **Testing** | JUnit 5 |
| **Build Tools** | Maven, npm |

## 📂 Project Structure

```
FSD/
├── exp-4 (registration using javascript)/
│   ├── orignal/                  → index.html, style.css, script.js
│   └── javapractice/             → index.html, app.css, script.js
├── exp-5 (registration for using react)/
│   └── registrationform/         → React registration form
├── exp-6 (shopping cart)/
│   └── shopping_cart/            → React shopping cart app
├── exp-7 (navigation using react)/
│   ├── navigationpage/
│   └── navigation_using_react_router/
├── exp-8 (crud without api)/
│   └── demonstrationofwithoutapi/ → Spring Boot app (Maven)
├── exp-9 (crud with api)/
│   └── withapi/                  → Spring Boot REST CRUD app (Maven)
├── exp-11 (crud using mondodb)/
│   └── mongodb/                  → Spring Boot + Spring Data MongoDB app
├── exp-12 (junit testing)/
│   └── junittest/                → Spring Boot app with JUnit 5 tests
├── login page/                   → index.html, signup.html, register.html, style.css
└── README.md
```

## 🚀 Running an Experiment

Each folder is self-contained. Pick the one you need:

**Static / vanilla JS experiments** (`exp-4`, `login page`)
```bash
cd "exp-4 (registration using javascript)/orignal"
# open index.html directly in a browser
```

**React experiments** (`exp-5`, `exp-6`, `exp-7`)
```bash
cd "exp-5 (registration for using react)/registrationform"
npm install
npm start
```

**Spring Boot experiments** (`exp-8`, `exp-9`, `exp-11`, `exp-12`)
```bash
cd "exp-9 (crud with api)/withapi"
mvn clean install
mvn spring-boot:run
# or
./mvnw spring-boot:run
```
> For `exp-11`, make sure a local MongoDB instance is running and configured in `application.properties` before starting the app.

## 🎯 Learning Outcomes

⚛️ React fundamentals (forms, routing, state) &nbsp;•&nbsp; 🟨 Vanilla JavaScript form handling &nbsp;•&nbsp; ☕ Spring Boot REST APIs &nbsp;•&nbsp; 🗄️ CRUD with and without a REST layer &nbsp;•&nbsp; 🍃 MongoDB with Spring Data &nbsp;•&nbsp; 🧪 Unit testing with JUnit 5 &nbsp;•&nbsp; 📦 Maven & npm project management

## 🤝 Contributing

This is a personal lab-work repository, but suggestions and corrections are welcome:

1. Fork the repository.
2. Create a new feature branch.
3. Commit your changes.
4. Push your branch.
5. Submit a Pull Request.

## 🔗 Project Links

<div align="center">

<a href="https://github.com/Nesara29/FSD">
  <img src="https://img.shields.io/badge/Repository-FSD-181717?style=for-the-badge&logo=github&logoColor=white" alt="Repository"/>
</a>
<a href="https://github.com/Nesara29/FSD/issues">
  <img src="https://img.shields.io/badge/Report-Issue-red?style=for-the-badge&logo=github&logoColor=white" alt="Issues"/>
</a>

</div>

## 📄 License

This repository is intended for **educational and learning purposes** as part of a Full Stack Development course/lab.

## ⭐ Support

If you found this useful for your own FSD lab work, please give it a ⭐ **Star** on GitHub.

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:16213e,50:1a1a2e,100:16213e&height=100&section=footer"/>

</div>
