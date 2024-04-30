-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory_manager
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_46ccwnsi9409t36lurvtyljak` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Fruits');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` text,
  `Category` varchar(50) NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int DEFAULT NULL,
  `min_quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1058 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1000,'Apple','Fresh red apple','Fruits',1.99,100,20),(1001,'Banana','Ripe banana','Fruits',0.99,100,30),(1002,'Orange','Juicy orange','Fruits',1.49,100,20),(1003,'Pear','Fresh ripe pear','Fruits',2.49,100,20),(1004,'Grapes','Seedless green grapes','Fruits',3.99,100,15),(1005,'Watermelon','Sweet seedless watermelon','Fruits',5.99,100,10),(1006,'Lemon','Fresh lemon','Fruits',0.69,100,15),(1007,'Strawberry','Ripe strawberry','Fruits',3.49,100,20),(1008,'Pineapple','Sweet pineapple','Fruits',4.99,100,25),(1009,'Coconut','Whole coconut','Fruits',2.99,100,20),(1010,'Mango','Juicy mango','Fruits',2.79,100,20),(1011,'Peach','Ripe peach','Fruits',1.89,100,15),(1012,'Blueberry','Fresh blueberry','Fruits',4.29,100,25),(1013,'Grapefruit','Pink grapefruit','Fruits',1.79,100,15),(1014,'Soda','Carbonated soft drink (cola)','Drinks',1.29,100,20),(1015,'Water','Bottled mineral water','Drinks',0.99,100,30),(1016,'Juice','Orange juice (freshly squeezed)','Drinks',2.99,100,15),(1017,'Lemonade','Refreshing lemonade','Drinks',1.99,100,20),(1018,'Iced Tea','Brewed iced tea','Drinks',1.49,100,30),(1019,'Energy Drink','Caffeinated energy drink','Drinks',2.99,100,15),(1020,'Cola','Cola-flavored carbonated soft drink','Drinks',1.49,100,20),(1021,'Coffee','Medium roast ground coffee','Drinks',8.99,100,30),(1022,'Tea','Black tea bags','Drinks',2.79,100,20),(1023,'Milk','Fresh whole milk','Drinks',1.99,100,30),(1024,'Smoothie','Mixed fruit smoothie','Drinks',4.99,100,20),(1025,'Sports Drink','Electrolyte sports drink','Drinks',2.29,100,15),(1026,'Chips','Potato chips (salted)','Snacks',2.49,100,10),(1027,'Chocolate','Milk chocolate bar','Snacks',1.99,100,15),(1028,'Cookies','Chocolate chip cookies','Snacks',3.99,100,10),(1029,'Popcorn','Buttered popcorn','Snacks',1.99,100,10),(1030,'Pretzels','Salted pretzels','Snacks',1.49,100,15),(1031,'Trail Mix','Assorted nuts and dried fruits','Snacks',3.49,100,10),(1032,'T-shirt','Unisex cotton t-shirt','Clothes',14.99,100,15),(1033,'Jeans','Men\'s straight-fit jeans','Clothes',34.99,100,10),(1034,'Sweater','Knit pullover sweater','Clothes',44.99,100,10),(1035,'Skirt','Women\'s pleated skirt','Clothes',24.99,100,5),(1036,'Sandals','Women\'s flip-flop sandals','Clothes',9.99,100,10),(1037,'Hat','Baseball cap','Clothes',19.99,100,5),(1038,'Dress Shirt','Men\'s dress shirt','Clothes',29.99,100,10),(1039,'Dress Pants','Men\'s dress pants','Clothes',39.99,100,10),(1040,'Blouse','Women\'s blouse','Clothes',24.99,100,5),(1041,'Dress','Women\'s cocktail dress','Clothes',49.99,100,5),(1042,'Suit','Men\'s tailored suit','Clothes',199.99,100,5),(1043,'Skirt Suit','Women\'s skirt suit','Clothes',149.99,100,5),(1044,'Laptop','15-inch laptop with Intel i5 processor','Electronics',799.99,100,5),(1045,'Smartphone','Latest smartphone model with 5G support','Electronics',999.99,100,5),(1046,'Headphones','Wireless over-ear headphones','Electronics',149.99,100,5),(1047,'Tablet','10-inch tablet with retina display','Electronics',399.99,100,5),(1048,'Camera','DSLR camera with 24MP sensor','Electronics',599.99,100,5),(1049,'Smartwatch','Fitness tracker smartwatch','Electronics',199.99,100,5),(1050,'Bluetooth Speaker','Portable Bluetooth speaker','Electronics',79.99,100,5),(1051,'External Hard Drive','1TB external hard drive','Electronics',59.99,100,5),(1052,'Wireless Earbuds','True wireless earbuds','Electronics',129.99,100,5),(1053,'Smart TV','4K Ultra HD smart TV','Electronics',699.99,100,5),(1054,'Fitness Tracker','Waterproof fitness tracker','Electronics',49.99,100,5),(1055,'Gaming Console','Next-gen gaming console','Electronics',499.99,100,5);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-30  2:26:18
