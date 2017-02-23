DROP DATABASE IF EXISTS BAR_DATABASE;

CREATE DATABASE BAR_DATABASE;

USE BAR_DATABASE;

CREATE TABLE CUSTOMERS
(
	 CUSTOMER_ID    		BIGINT          NOT NULL PRIMARY KEY AUTO_INCREMENT
	,USERNAME     			VARCHAR(100)    NOT NULL
	,PASS	     			VARCHAR(100)    NOT NULL
	,AGE         			VARCHAR(2) 	    NULL
    ,EMAIL       			VARCHAR(150)    NULL
	,STATE  				INT             NULL DEFAULT 1
);

CREATE TABLE CATEGORYS
(
	 CATEGORY_ID			INTEGER  		NOT NULL PRIMARY KEY AUTO_INCREMENT
	,CATEGORY_NAME			VARCHAR(150) 	NOT NULL
	,STATE					INTEGER 		DEFAULT 1
);

CREATE TABLE PRODUCTS(
	 PRODUCT_ID				INTEGER  		NOT NULL PRIMARY KEY AUTO_INCREMENT
	,PRODUCT_NAME			VARCHAR(150) 	NOT NULL
	,CONTAINER 				VARCHAR(50)     NOT NULL
	,CATEGORY_ID			INTEGER 		NOT NULL
	,STATE					INTEGER		 	DEFAULT 1
	,FOREIGN KEY (CATEGORY_ID)				REFERENCES CATEGORYS(CATEGORY_ID)
);

CREATE TABLE ORDERS
(
	 ORDER_ID				BIGINT  		NOT NULL PRIMARY KEY AUTO_INCREMENT
	,ORDER_DATE				DATE 			NOT NULL
	,QRCODE					VARCHAR(150)   	NOT NULL
	,CUSTOMER_ID    		BIGINT			NOT NULL
	,STATE					INTEGER 		DEFAULT 1
	,FOREIGN KEY (CUSTOMER_ID)				REFERENCES CUSTOMERS(CUSTOMER_ID)
);

CREATE TABLE ORDER_DETAILS
(
     ORDER_DETAIL_ID        BIGINT  		NOT NULL PRIMARY KEY AUTO_INCREMENT
	,ORDER_ID				BIGINT  		NOT NULL
	,PRODUCT_ID				INTEGER 		NOT NULL
	,UNIT_PRICE				DECIMAL(7,2) 	NULL
	,QUANTITY				INTEGER  		NULL
	,FOREIGN KEY (ORDER_ID)					REFERENCES ORDERS(ORDER_ID)
	,FOREIGN KEY (PRODUCT_ID)				REFERENCES PRODUCTS(PRODUCT_ID)
);

CREATE TABLE BARS
(
	 BAR_ID         		BIGINT          NOT NULL PRIMARY KEY AUTO_INCREMENT 
	,NAME      	 			VARCHAR(300)    NOT NULL
    ,ADDRESS				VARCHAR(300)    NOT NULL
    ,LATITUDE      			DECIMAL(18,12)  NULL
    ,LONGITUDE    			DECIMAL(18,12)  NULL
    ,PHONE     				VARCHAR(15)     NULL
    ,HOUR_OPEN    			TIME            DEFAULT '00:00:00'
    ,HOUR_CLOSE  			TIME            DEFAULT '00:00:00'
	,STATE	 				INT             NULL DEFAULT 1
);

CREATE TABLE REPUTATIONS
(
	 REPUTATION_ID  		BIGINT          NOT NULL PRIMARY KEY AUTO_INCREMENT 
    ,CUSTOMER_ID  			BIGINT          NOT NULL       
	,BAR_ID     			BIGINT          NOT NULL
	,REPUTATION   			DECIMAL(3,2)    NULL
	,COMMENTS  				VARCHAR(1000)   NULL
	,STATE					INT             NULL DEFAULT 1
	,FOREIGN KEY (CUSTOMER_ID)				REFERENCES CUSTOMERS(CUSTOMER_ID)
	,FOREIGN KEY (BAR_ID)					REFERENCES BARS(BAR_ID)
);

CREATE TABLE CATALOGS
(
	 CATALOG_ID     		BIGINT          NOT NULL PRIMARY KEY AUTO_INCREMENT 
	,BAR_ID					BIGINT          NOT NULL
	,PRODUCT_ID				INTEGER         NOT NULL
	,UNIT_PRICE				DECIMAL         NOT NULL
	,START_DATE				DATE			NOT NULL
	,FINAL_DATE				DATE			DEFAULT NULL
	,STATE	         		INTEGER         NULL DEFAULT 1
	,FOREIGN KEY (PRODUCT_ID)				REFERENCES PRODUCTS(PRODUCT_ID)
	,FOREIGN KEY (BAR_ID)					REFERENCES BARS(BAR_ID)
);
