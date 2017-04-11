-- APARTMENT_ID NULLABLE ONLY IF ROOM IS NULL, FK
-- ROOM_ID NULLABLE, FK
-- MESSAGE_ID NULLABLE, FK
-- MAINT_REQ_ID FK
-- TRANS_REQ_ID FK

-- DROP TABLES/SEQ --
DROP TABLE TRANS_REQS;
DROP TABLE MESSAGES;
DROP TABLE CHAINS;
DROP TABLE GROUPS;
DROP TABLE EMPLOYEES;
DROP TABLE APARTMENTS;
DROP TABLE GENDERS;
/
DROP SEQUENCE APARTMENT_SEQ;
DROP SEQUENCE CHAIN_SEQ;
DROP SEQUENCE EMPLOYEE_SEQ;
DROP SEQUENCE GROUP_SEQ;
DROP SEQUENCE MESSAGE_SEQ;
/
-- CREATE TABLES --
-- FILL 1 = occupied, 0 = vacated
CREATE TABLE EMPLOYEES 
(
  EMPLOYEE_ID NUMBER NOT NULL,
  FIRST_NAME VARCHAR2(25) NOT NULL,
  LAST_NAME VARCHAR2(25) NOT NULL,
  USERNAME VARCHAR2(25) NOT NULL UNIQUE,
  PASSWORD VARCHAR2(25) NOT NULL,
  APARTMENT_ID NUMBER,
  GENDER_ID NUMBER,
  FILL NUMBER DEFAULT 1,
  CONSTRAINT PK_EMPLOYEES PRIMARY KEY (EMPLOYEE_ID)
);

-- lookup table
CREATE TABLE GENDERS
(
  GENDER_ID NUMBER NOT NULL,
  GENDER VARCHAR(15),
  CONSTRAINT PK_GENDERS PRIMARY KEY (GENDER_ID)
);

CREATE TABLE APARTMENTS
(
  APARTMENT_ID NUMBER NOT NULL,
  ADDRESS VARCHAR2(50) NOT NULL,
  CITY VARCHAR2(25) NOT NULL,
  STATE VARCHAR2(25) NOT NULL,
  ZIP_CODE VARCHAR2(10) NOT NULL,
  GENDER_ID VARCHAR(10) NOT NULL,
  ROOMS_AVAILABLE NUMBER DEFAULT 6,
  CONSTRAINT PK_APARTMENTS PRIMARY KEY (APARTMENT_ID)
);

CREATE TABLE MESSAGES
(
  MESSAGE_ID NUMBER NOT NULL,
  CHAIN_ID NUMBER NOT NULL,
  MESSAGE VARCHAR2(2000),
  CONSTRAINT PK_MESSAGES PRIMARY KEY (MESSAGE_ID)
);

CREATE TABLE CHAINS
(
  CHAIN_ID NUMBER NOT NULL,
  GROUP_ID_1 NUMBER,
  GROUP_ID_2 NUMBER,
  CONSTRAINT PK_CHAINS PRIMARY KEY (CHAIN_ID)
);

-- AT MOST 6 
CREATE TABLE GROUPS
(
  GROUP_ID NUMBER NOT NULL,
  EMPLOYEE_ID_1 NUMBER,
  EMPLOYEE_ID_2 NUMBER,
  EMPLOYEE_ID_3 NUMBER,
  EMPLOYEE_ID_4 NUMBER,
  EMPLOYEE_ID_5 NUMBER,
  EMPLOYEE_ID_6 NUMBER,
  CONSTRAINT PK_GROUPS PRIMARY KEY (GROUP_ID)
);
-- ALTER TABLES --
ALTER TABLE EMPLOYEES ADD CONSTRAINT FK_APARTMENT_ID
  FOREIGN KEY (APARTMENT_ID) REFERENCES APARTMENTS (APARTMENT_ID);

ALTER TABLE EMPLOYEES ADD CONSTRAINT FK_GENDER_ID
  FOREIGN KEY (GENDER_ID) REFERENCES GENDERS (GENDER_ID);

ALTER TABLE MESSAGES ADD CONSTRAINT FK_CHAIN_ID
  FOREIGN KEY (CHAIN_ID) REFERENCES CHAINS (CHAIN_ID);
  
ALTER TABLE CHAINS ADD CONSTRAINT FK_GROUP_ID_1
  FOREIGN KEY (GROUP_ID_1) REFERENCES GROUPS (GROUP_ID);
  
ALTER TABLE CHAINS ADD CONSTRAINT FK_GROUP_ID_2
  FOREIGN KEY (GROUP_ID_2) REFERENCES GROUPS (GROUP_ID);
  
ALTER TABLE GROUPS ADD CONSTRAINT FK_EMPLOYEE_ID_1
  FOREIGN KEY (EMPLOYEE_ID_1) REFERENCES EMPLOYEES (EMPLOYEE_ID);

ALTER TABLE GROUPS ADD CONSTRAINT FK_EMPLOYEE_ID_2
  FOREIGN KEY (EMPLOYEE_ID_2) REFERENCES EMPLOYEES (EMPLOYEE_ID);

ALTER TABLE GROUPS ADD CONSTRAINT FK_EMPLOYEE_ID_3
  FOREIGN KEY (EMPLOYEE_ID_3) REFERENCES EMPLOYEES (EMPLOYEE_ID);

ALTER TABLE GROUPS ADD CONSTRAINT FK_EMPLOYEE_ID_4
  FOREIGN KEY (EMPLOYEE_ID_4) REFERENCES EMPLOYEES (EMPLOYEE_ID);

ALTER TABLE GROUPS ADD CONSTRAINT FK_EMPLOYEE_ID_5
  FOREIGN KEY (EMPLOYEE_ID_5) REFERENCES EMPLOYEES (EMPLOYEE_ID);

ALTER TABLE GROUPS ADD CONSTRAINT FK_EMPLOYEE_ID_6
  FOREIGN KEY (EMPLOYEE_ID_6) REFERENCES EMPLOYEES (EMPLOYEE_ID);

-- CREATE SEQUENCES --
/
CREATE SEQUENCE APARTMENT_SEQ
  MINVALUE 1
  START WITH    1
  INCREMENT BY  1;
/

CREATE SEQUENCE EMPLOYEE_SEQ
  MINVALUE 1
  START WITH    1
  INCREMENT BY  1;
/

CREATE SEQUENCE MESSAGE_SEQ
  MINVALUE 1
  START WITH    1
  INCREMENT BY  1;
/

CREATE SEQUENCE CHAIN_SEQ
  MINVALUE 1
  START WITH    1
  INCREMENT BY  1;
/

CREATE SEQUENCE GROUP_SEQ
  MINVALUE 1
  START WITH    1
  INCREMENT BY  1;
/


-- PRE-POPULATE DATABASE --
INSERT INTO GENDERS(GENDER_ID, GENDER) VALUES (1, 'Male');
INSERT INTO GENDERS(GENDER_ID, GENDER) VALUES (2, 'Female');
INSERT INTO GENDERS(GENDER_ID, GENDER) VALUES (3, 'Co-ed');
INSERT INTO GENDERS(GENDER_ID, GENDER) VALUES (4, 'Other');

INSERT INTO APARTMENTS(APARTMENT_ID, ADDRESS, CITY, STATE, ZIP_CODE, GENDER_ID) VALUES (1, '2100 Raven Tower Ct, #304', 'Herndon', 'VA', '20170', 1);
INSERT INTO APARTMENTS(APARTMENT_ID, ADDRESS, CITY, STATE, ZIP_CODE, GENDER_ID) VALUES (2, '609 Pride Ave', 'Herndon', 'VA', '20170', 1);
INSERT INTO APARTMENTS(APARTMENT_ID, ADDRESS, CITY, STATE, ZIP_CODE, GENDER_ID) VALUES (3, '2121 Raven Tower Ct, #104', 'Herndon', 'VA', '20170', 2);

INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, APARTMENT_ID, GENDER_ID) VALUES (1, 'Xavier', 'Grogan', 'xavier', 'grogan', 2, 1);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, APARTMENT_ID, GENDER_ID) VALUES (2, 'Jonathan', 'Lee', 'jonathan', 'lee', 2, 1);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, APARTMENT_ID, GENDER_ID) VALUES (3, 'Ben', 'Webster', 'ben', 'webster', 1, 1);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, APARTMENT_ID, GENDER_ID) VALUES (4, 'Aaron', 'Camm', 'aaron', 'camm', 1, 1);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, APARTMENT_ID, GENDER_ID) VALUES (5, 'Mory', 'Keita', 'mory', 'keita', 1, 1);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, APARTMENT_ID, GENDER_ID) VALUES (6, 'Bella', 'Rose', 'bella', 'rose', 3, 2);

INSERT INTO GROUPS(GROUP_ID, EMPLOYEE_ID_1, EMPLOYEE_ID_2) VALUES (1, 1, 2);
INSERT INTO GROUPS(GROUP_ID, EMPLOYEE_ID_1, EMPLOYEE_ID_2, EMPLOYEE_ID_3) VALUES (2, 3, 4, 5);
INSERT INTO GROUPS(GROUP_ID, EMPLOYEE_ID_1) VALUES (3, 6);