# Inventory Manager Application

## Overview

Inventory Manager is a robust web-based application designed to help businesses efficiently manage their product inventory. Built using Spring Boot, this application provides comprehensive CRUD (Create, Read, Update, Delete) functionality for product management.

## 🚀 Technologies Used

- **Backend**:
    - Java
    - Spring Boot
    - Spring Data JPA
    - Thymeleaf
  

- **Database**: 
    - MySQL


- **Frontend**:
    - Bootstrap
    - HTML5
    - CSS3

## ✨ Features

### Product Management
- **Add Products**: Easily add new products to the inventory
- **View Products**: Display a complete list of all products
- **Search Products**:
    - Look up products by name
    - Look up products by ID
- **Edit Products**: Update product details
- **Remove Products**: Delete products by name or ID

### Key Functionalities
- Unique product name validation
- Minimum quantity tracking
- Comprehensive product details (ID, Name, Category, Price, Quantity, Description)

## 🛠️ Prerequisites

- Java 17
- MySQL 8.0+
- Maven

## 📦 Database Setup

1. Create a MySQL database named `inventory_manager`
2. Configure database connection in `application.properties`
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/inventory_manager
   spring.datasource.username=root
   spring.datasource.password=hello
   ```

## 🚦 Installation and Running

1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/inventory-manager.git
   cd inventory-manager
   ```

2. Build the project
   ```bash
   mvn clean install
   ```

3. Run the application
   ```bash
   mvn spring-boot:run
   ```

4. Access the application
    - Open a web browser
    - Navigate to `http://localhost:8080`

## 📝 Project Structure

```
src
├── main
│   ├── java
│   │   └── org
│   │       └── inventory
│   │           ├── InventoryManagerApp.java
│   │           ├── InventoryManagerController.java
│   │           ├── controller
│   │           │   └── ProductController.java
│   │           ├── entities
│   │           │   ├── Category.java
│   │           │   └── Product.java
│   │           └── repositories
│   │               ├── CategoryRepository.java
│   │               └── ProductRepository.java
│   └── resources
│       ├── application.properties
│       ├── MySQL_script
│       ├── templates
│       │   ├── addProduct.html
│       │   ├── editProduct.html
│       │   ├── index.html
│       │   ├── lookProduct.html
│       │   ├── products.html
│       │   └── removeProduct.html
│       └── Inventory_Manager_Dump.sql
├── test
│   └── java
│       └── org
│           └── inventory
│               ├── CategoryRepositoryTests.java
│               └── ProductRepositoryTests.java
│              
```

## 🖥️ User Interface

The application features a responsive, modern UI with:
- Gradient background
- Sidebar navigation
- Bootstrap styling
- Custom Google Fonts


## 📜 License

Distributed under the MIT License. See `LICENSE` for more information.

## 📞 Contact

Project Link: [https://github.com/yourusername/inventory-manager](https://github.com/yourusername/inventory-manager)