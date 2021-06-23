CREATE TABLE CUSTOMERS(ID INT PRIMARY KEY, NAME VARCHAR);
CREATE TABLE PRODUCT(ID INT PRIMARY KEY, POINTS_COST INT, CODE VARCHAR, NAME VARCHAR);
CREATE TABLE ACTIVE_DAYS(ID INT PRIMARY KEY, CUSTOMER_ID INT, ACTIVE_DAYS INT, TOTAL_POINTS INT);

INSERT INTO PRODUCT VALUES(1, 360, 'AP567', 'Apple Smart Watch');
INSERT INTO PRODUCT VALUES(2, 300, 'DR140', 'Hair Dryer');
INSERT INTO PRODUCT VALUES(3, 75, 'QC101', 'Sun Glasses');
INSERT INTO PRODUCT VALUES(4, 160, 'TM890', 'Gas Lamp');
INSERT INTO PRODUCT VALUES(5, 80, 'KA502', 'Wireless Keyboard');
INSERT INTO PRODUCT VALUES(6, 50, 'EP4500', '120GB MicroSD');


INSERT INTO CUSTOMERS VALUES (1, 'Bill Johnson');
INSERT INTO CUSTOMERS VALUES (2, 'Sizwe Ngcobo');
INSERT INTO CUSTOMERS VALUES (3, 'Tumelo Mokoena');
INSERT INTO CUSTOMERS VALUES (4, 'Mohammed Naidoo');
INSERT INTO CUSTOMERS VALUES (5, 'Dakalo Maluleke');
 
 INSERT INTO ACTIVE_DAYS VALUES (1, 1, 500, 500);
INSERT INTO ACTIVE_DAYS VALUES (2, 4, 370, 370);
INSERT INTO ACTIVE_DAYS VALUES (3, 2, 54, 54);
INSERT INTO ACTIVE_DAYS VALUES (4, 5, 250, 250);
INSERT INTO ACTIVE_DAYS VALUES (5, 3, 20, 20);
