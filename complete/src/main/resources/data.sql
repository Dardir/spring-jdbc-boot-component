--
-- Dumping data for table `prev_maint`
--

LOCK TABLES `prev_maint` WRITE;
/*!40000 ALTER TABLE `prev_maint` DISABLE KEYS */;
INSERT INTO `prev_maint` VALUES (1,'2018-04-04','Cairo','Notes',32),(2,'2018-04-05','Alex','Notes',32);
/*!40000 ALTER TABLE `prev_maint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roletraining`
--

DROP TABLE IF EXISTS `roletraining`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roletraining` (
  `ID` int(11) NOT NULL,
  `ROLE` varchar(255) NOT NULL,
  `TRAINING` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ROLETRAINING_INDEX1` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roletraining`
--

LOCK TABLES `roletraining` WRITE;
/*!40000 ALTER TABLE `roletraining` DISABLE KEYS */;
INSERT INTO `roletraining` VALUES (1,'Safety','First Aid'),(2,'Safety','Crisis Control');
/*!40000 ALTER TABLE `roletraining` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-26 11:23:09
