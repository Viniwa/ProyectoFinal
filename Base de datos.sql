CREATE DATABASE  IF NOT EXISTS `tienda` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tienda`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: tienda
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `codigo` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` int DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idCliente_idx` (`id_usuario`),
  CONSTRAINT `idCliente` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_factura`
--

DROP TABLE IF EXISTS `detalle_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_factura` (
  `id_detalle_factura` int NOT NULL AUTO_INCREMENT,
  `id_factura` int DEFAULT NULL,
  `codigo_producto` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_factura`),
  UNIQUE KEY `id_detalle_factura_UNIQUE` (`id_detalle_factura`),
  KEY `id_factura_idx` (`id_factura`),
  KEY `codigo_productos_idx` (`codigo_producto`),
  CONSTRAINT `codigo_productos` FOREIGN KEY (`codigo_producto`) REFERENCES `productos` (`codigo`),
  CONSTRAINT `id_factura` FOREIGN KEY (`id_factura`) REFERENCES `facturas` (`id_facturas`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_factura`
--

LOCK TABLES `detalle_factura` WRITE;
/*!40000 ALTER TABLE `detalle_factura` DISABLE KEYS */;
INSERT INTO `detalle_factura` VALUES (13,16,1,3,700.00),(14,17,2,1,1200.00),(15,18,2,2,1200.00),(16,18,1,3,700.00),(17,19,1,1,700.00),(18,19,2,1,1200.00),(19,19,3,1,300.00),(20,19,4,1,600.00),(21,19,5,1,1200.00),(22,19,6,1,800.00),(23,19,7,1,450.00);
/*!40000 ALTER TABLE `detalle_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `id_facturas` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `id_pedido` int DEFAULT NULL,
  PRIMARY KEY (`id_facturas`),
  UNIQUE KEY `id_facturas_UNIQUE` (`id_facturas`),
  KEY `fecha_idx` (`fecha`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (16,11,'2024-07-08 09:23:18',2100.00,14),(17,12,'2024-07-08 10:09:27',1200.00,15),(18,11,'2024-07-10 11:35:03',4500.00,16),(19,11,'2024-07-10 13:21:20',5250.00,17);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id_pedidos` int NOT NULL AUTO_INCREMENT,
  `id_factura` int DEFAULT NULL,
  `cliente` int DEFAULT NULL,
  `fecha_pedido` datetime DEFAULT NULL,
  `estado` enum('Creado','Confirmado','Enviado') DEFAULT 'Creado',
  `fecha_estado` datetime DEFAULT NULL,
  PRIMARY KEY (`id_pedidos`),
  UNIQUE KEY `idpedidos_UNIQUE` (`id_pedidos`),
  KEY `id_factura_idx` (`id_factura`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (14,16,11,'2024-07-08 09:23:18','Enviado','2024-07-12 09:51:18'),(15,17,12,'2024-07-08 10:09:27','Enviado','2024-07-12 09:51:25'),(16,18,11,'2024-07-10 11:35:03','Confirmado','2024-07-12 09:51:11'),(17,19,11,'2024-07-10 13:21:20','Confirmado','2024-07-12 09:51:22');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` int NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `imagen` varchar(500) DEFAULT NULL,
  `descripcion` longtext,
  PRIMARY KEY (`id`,`codigo`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (3,1,'Iphone 11 Pro Max',700.00,393,'C:\\Users\\Viniwa\\Documents\\NetBeansProjects\\ProyectoFinal\\imagenes productos\\Apple_Iphone_11_Pro_Max.png','Pantalla: Super Retina XDR OLED de 6.5 pulgadas, con una resolución de 2688 x 1242 píxeles y un brillo máximo de 1200 nits.\n\nCámara: Triple cámara trasera de 12 MP (gran angular, ultra gran angular y teleobjetivo) con capacidades de grabación en 4K a 60 fps. Cámara frontal de 12 MP con modo retrato y grabación en 4K.\n\nProcesador: Chip A13 Bionic con Neural Engine de tercera generación.\n\nBatería: Capacidad de 3969 mAh, con carga rápida (50% en 30 minutos) y carga inalámbrica.\n\nResistencia: Certificación IP68, resistente al agua y al polvo (hasta 4 metros de profundidad durante 30 minutos).\n\nAlmacenamiento: Opciones de 64GB, 256GB y 512GB.\n\nSistema Operativo: iOS 13, actualizable a versiones más recientes.'),(4,2,'Samsung S24 Ultra',1200.00,296,'C:\\Users\\Viniwa\\Documents\\NetBeansProjects\\ProyectoFinal\\imagenes productos\\Galaxy_S24_Ultra.png','Pantalla: Dynamic LTPO AMOLED 2X de 6.8 pulgadas, con una resolución de 1440 x 3120 píxeles y un brillo máximo de 2600 nits.\n\nCámara: Cuádruple cámara trasera con un sensor principal de 200 MP, un teleobjetivo de 10 MP con zoom óptico 3x, un periscopio teleobjetivo de 50 MP con zoom óptico 5x, y un ultra gran angular de 12 MP. Cámara frontal de 12 MP.\n\nProcesador: Qualcomm Snapdragon 8 Gen 3.\n\nBatería: Capacidad de 5000 mAh, con carga rápida de 45W y carga inalámbrica de 15W.\n\nResistencia: Certificación IP68, resistente al agua y al polvo (hasta 1.5 metros de profundidad durante 30 minutos).\n\nAlmacenamiento: Opciones de 256GB, 512GB y 1TB, todas con 12GB de RAM.\n\nSistema Operativo: Android 14 con One UI 6.1.1.\n\nOtros: Incluye S Pen con integración Bluetooth, sensor de huellas ultrasónico bajo la pantalla, y soporte para Samsung DeX.'),(5,3,'iPhone 11',300.00,199,'C:\\Users\\Viniwa\\Documents\\NetBeansProjects\\ProyectoFinal\\imagenes productos\\Apple_iPhone_11.png','Pantalla: Liquid Retina HD LCD de 6.1 pulgadas, con una resolución de 1792 x 828 píxeles y un brillo máximo de 625 nits.\n\nCámara: Sistema de cámara dual de 12 MP (gran angular y ultra gran angular) con capacidades de grabación en 4K a 60 fps. Cámara frontal de 12 MP con modo retrato y grabación en 4K.\n\nProcesador: Chip A13 Bionic con Neural Engine de tercera generación.\n\nBatería: Capacidad de 3110 mAh, con carga rápida (50% en 30 minutos) y carga inalámbrica.\n\nResistencia: Certificación IP68, resistente al agua y al polvo (hasta 2 metros de profundidad durante 30 minutos).\n\nAlmacenamiento: Opciones de 64GB, 128GB y 256GB.\n\nSistema Operativo: iOS 13, actualizable a versiones más recientes.'),(6,4,'Honor 200 Pro',600.00,149,'C:\\Users\\Viniwa\\Documents\\NetBeansProjects\\ProyectoFinal\\imagenes productos\\Honor_200_Pro.png','Pantalla: OLED de 6.78 pulgadas, con una resolución de 1224 x 2700 píxeles y una tasa de refresco de 120 Hz.\n\nCámara: Triple cámara trasera con un sensor principal de 50 MP, un teleobjetivo de 50 MP con zoom óptico 2.5x, y un ultra gran angular de 12 MP. Cámara frontal de 50 MP.\n\nProcesador: Qualcomm Snapdragon 8s Gen 3.\n\nBatería: Capacidad de 5200 mAh, con carga rápida de 100W y carga inalámbrica de 66W.\n\nResistencia: Certificación IP55, resistente al agua y al polvo.\n\nAlmacenamiento: Opciones de 256GB, 512GB y 1TB, con 12GB o 16GB de RAM.\n\nSistema Operativo: Android 14 con MagicOS 8.\n\nOtros: Altavoces estéreo, lector de huellas en la pantalla, y soporte para 5G, WiFi 6, Bluetooth 5.3 y NFC.'),(7,5,'Huawei Pura 70 Ultra',1200.00,69,'C:\\Users\\Viniwa\\Documents\\NetBeansProjects\\ProyectoFinal\\imagenes productos\\Huawei_Pura_70_Ultra.png','Pantalla: OLED LTPO de 6.8 pulgadas, con una resolución de 2844 x 1260 píxeles y un brillo máximo de 2500 nits.\n\nCámara: Triple cámara trasera con un sensor principal de 50 MP, un ultra gran angular de 40 MP y un teleobjetivo de 50 MP con zoom óptico 3.5x. Cámara frontal de 13 MP.\n\nProcesador: Kirin 9010.\n\nBatería: Capacidad de 5200 mAh, con carga rápida de 100W y carga inalámbrica de 80W.\n\nResistencia: Certificación IP68, resistente al agua y al polvo.\n\nAlmacenamiento: Opciones de 512GB y 1TB, con 16GB de RAM.\n\nSistema Operativo: HarmonyOS 4.2.\n\nOtros: Cristal Kunlun Glass, altavoces estéreo, lector de huellas en pantalla, y soporte para WiFi 6 y Bluetooth 5.2.'),(8,6,'Oneplus 12',800.00,99,'C:\\Users\\Viniwa\\Documents\\NetBeansProjects\\ProyectoFinal\\imagenes productos\\Oneplus_12.png','Pantalla: LTPO AMOLED de 6.82 pulgadas, con una resolución de 1440 x 3168 píxeles y un brillo máximo de 4500 nits.\n\nCámara: Triple cámara trasera con un sensor principal de 50 MP, un teleobjetivo periscópico de 64 MP con zoom óptico 3x, y un ultra gran angular de 48 MP. Cámara frontal de 32 MP.\n\nProcesador: Qualcomm Snapdragon 8 Gen 3.\n\nBatería: Capacidad de 5400 mAh, con carga rápida de 100W y carga inalámbrica de 50W.\n\nResistencia: Certificación IP65, resistente al agua y al polvo.\n\nAlmacenamiento: Opciones de 256GB, 512GB y 1TB, con 12GB, 16GB o 24GB de RAM.\n\nSistema Operativo: Android 14 con OxygenOS 14.\n\nOtros: Altavoces estéreo, lector de huellas en pantalla, y soporte para 5G, WiFi 7, Bluetooth 5.4 y NFC.'),(9,7,'Realme 11 Pro',450.00,199,'C:\\Users\\Viniwa\\Documents\\NetBeansProjects\\ProyectoFinal\\imagenes productos\\Realme_11_Pro.png','Pantalla: AMOLED de 6.7 pulgadas, con una resolución de 1080 x 2412 píxeles y una tasa de refresco de 120 Hz.\n\nCámara: Cámara trasera dual con un sensor principal de 100 MP y un sensor macro de 2 MP. Cámara frontal de 16 MP.\n\nProcesador: MediaTek Dimensity 7050.\n\nBatería: Capacidad de 5000 mAh, con carga rápida de 67W.\n\nResistencia: Certificación IP54, resistente al polvo y salpicaduras.\n\nAlmacenamiento: Opciones de 128GB y 256GB, con 8GB o 12GB de RAM.\n\nSistema Operativo: Android 13 con Realme UI 4.0.\n\nOtros: Altavoces estéreo, lector de huellas en pantalla, y soporte para 5G, WiFi 6, Bluetooth 5.2 y NFC.');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `correo` varchar(60) DEFAULT NULL,
  `clave` varchar(90) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(90) DEFAULT NULL,
  `provincia` varchar(90) DEFAULT NULL,
  `c_postal` int DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'a','a','Alfredo','Garcia Sanchez','C/ Valencia, 15','Villacañas','Toledo',45678,666777888),(12,'b','b','Maria','Sanchez','c/Nueva, 123','Toledo','Toledo',45800,600600111);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tienda'
--

--
-- Dumping routines for database 'tienda'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-12 13:22:42
