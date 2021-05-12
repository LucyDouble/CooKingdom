CREATE TABLE DIRECTOR (
EMAIL VARCHAR2(50) CONSTRAINT DIRECTOR_EMAIL_PK PRIMARY KEY,
NAME VARCHAR2(20) NOT NULL, 
PASSWORD VARCHAR2(30) NOT NULL, 
PHONE NUMBER(30) NOT NULL, 
SERIAL VARCHAR2(20) NOT NULL
);

CREATE TABLE MANAGER ( 
EMAIL VARCHAR2(50) CONSTRAINT MANAGER_EMAIL_PK PRIMARY KEY,
NAME VARCHAR2(20) NOT NULL, 
PASSWORD VARCHAR2(30) NOT NULL, 
PHONE NUMBER(30) NOT NULL, 
SERIAL VARCHAR2(20) NOT NULL 
);

CREATE TABLE USERS ( 
EMAIL VARCHAR2(50) CONSTRAINT USER_EMAIL_PK PRIMARY KEY, 
NICKNAME VARCHAR2(30) UNIQUE NOT NULL, 
NAME VARCHAR2(20) NOT NULL, 
PASSWORD VARCHAR2(30) NOT NULL, 
BIRTH DATE NOT NULL, 
PHONE NUMBER(30) NOT NULL, 
ADDRESS VARCHAR2(300)
);

CREATE TABLE RECIPE ( 
  RECIPE_CODE NUMBER(7) CONSTRAINT RECIPE_RECIPE_CODE_PK PRIMARY KEY, 
  RECIPE_NAME VARCHAR2(30) NOT NULL, 
  TYPE_CODE NUMBER(7) NOT NULL, 
  TYPE_CAG VARCHAR2(20) NOT NULL, 
  RECIPE_INFO VARCHAR2(400) NOT NULL, 
  RECIPE_TYPE_CODE NUMBER(7) NOT NULL, 
  RECIPE_CAG VARCHAR2(40) NOT NULL, 
  COOKING_TIME VARCHAR2(20) NOT NULL, 
  CALORIE VARCHAR2(20) NOT NULL, 
  RECIPE_QTY VARCHAR2(20) NOT NULL, 
  RECIPE_LEVEL VARCHAR2(20) NOT NULL, 
  ING_TYPE VARCHAR2(30) NOT NULL,
  RECIPE_URL VARCHAR2(200),
  LIKES NUMBER(7),
  PRICE NUMBER(7) NOT NULL
);

CREATE TABLE INGREDIENT ( 
  RECIPE_CODE NUMBER(7) CONSTRAINT INGREDIENT_RECIPE_CODE_FK REFERENCES RECIPE, 
  ING_NAME VARCHAR2(30) NOT NULL,
  ING_TY_NM VARCHAR2(20) NOT NULL,
  ING_TY_CODE NUMBER(7) NOT NULL,
  ING_CPCTY VARCHAR2(20) NOT NULL
);
    
CREATE TABLE REVIEW ( 
REVIEW_NO NUMBER(3) CONSTRAINT REVIEW_REVIEW_NO_PK PRIMARY KEY, 
EMAIL VARCHAR2(50) NOT NULL CONSTRAINT REVIEW_EMAIL_FK REFERENCES USERS, 
RECIPE_CODE NUMBER(7) NOT NULL CONSTRAINT REVIEW_RECIPE_CODE_FK REFERENCES RECIPE, 
REVIEW_SUBJECT VARCHAR2(100) NOT NULL, 
REVIEW_DATE DATE NOT NULL, 
REVIEW_CONTENT VARCHAR2(3000) NOT NULL, 
REVIEW_PHOTO VARCHAR2(100),
HIT NUMBER DEFAULT 0
);
CREATE SEQUENCE SEQ_REVIEW 
    INCREMENT BY 1 
    START WITH 1
    NOMAXVALUE
    NOMINVALUE
    NOCYCLE
    NOCACHE;

CREATE TABLE COMMENTS (
COMMENT_NO NUMBER(3) CONSTRAINT COMMENTS_COMMENT_NO_PK PRIMARY KEY, 
EMAIL VARCHAR2(50) NOT NULL CONSTRAINT COMMENT_EMAIL_FK REFERENCES USERS, 
RECIPE_CODE NUMBER(7) NOT NULL CONSTRAINT COMMENT_RECIPE_CODE_FK REFERENCES RECIPE,
COMMENT_DATE DATE NOT NULL, 
COMMENT_CONTENT VARCHAR2(1000) NOT NULL,
COMMENT_DEPTH NUMBER(3) DEFAULT 0 NOT NULL,
COMMENT_GROUP NUMBER(3) NOT NULL,
COMMENT_SORTS NUMBER(3) NOT NULL
);

CREATE SEQUENCE SEQ_COMMENTS
    INCREMENT BY 1 
    START WITH 1
    NOMAXVALUE
    NOMINVALUE
    NOCYCLE
    NOCACHE;


CREATE TABLE CART (
CART_NO VARCHAR2(20)	CONSTRAINT CART_CART_NO_PK PRIMARY KEY,
EMAIL	VARCHAR2(50) NOT NULL CONSTRAINT CART_EMAIL_FK REFERENCES USERS,
TOTAL_PRICE NUMBER(7)
);


CREATE TABLE CART_INFO (
   CART_NO VARCHAR2(20) CONSTRAINT CART_INFO_CART_NO_FK REFERENCES CART NOT NULL,
   RECIPE_CODE NUMBER(7) CONSTRAINT CART_INFO_RECIPE_CODE_FK REFERENCES RECIPE NOT NULL,
   MEALKIT_QTY NUMBER(3) NOT NULL
);


CREATE TABLE ORDERS ( 
ORDER_CODE VARCHAR2(20) CONSTRAINT ORDERS_ORDER_CODE_PK PRIMARY KEY, 
EMAIL VARCHAR2(50) NOT NULL CONSTRAINT ORDER_EMAIL_FK REFERENCES USERS, 
ORDER_DATE DATE NOT NULL, 
ADDR VARCHAR2(300) NOT NULL, 
TOTAL_PRICE NUMBER(7)
);


CREATE TABLE ORDER_INFO ( 
ORDER_CODE VARCHAR2(20) NOT NULL CONSTRAINT ORDER_INFO_ORDER_CODE_FK REFERENCES ORDERS,
RECIPE_CODE NUMBER(7) CONSTRAINT ORDER_INFO_RECIPE_CODE_FK REFERENCES RECIPE NOT NULL,
MEALKIT_QTY NUMBER(3)
);


CREATE TABLE LIKES ( 
EMAIL VARCHAR2(50) NOT NULL CONSTRAINT LIKES_EMAIL_FK REFERENCES USERS,
RECIPE_CODE NUMBER(7) NOT NULL CONSTRAINT LIKES_RECIPE_CODE_FK REFERENCES RECIPE 
);

CREATE TABLE COOKING_STEPS (
    RECIPE_CODE NUMBER(7) CONSTRAINT COOKING_STEP_RECIPE_CODE_FK REFERENCES RECIPE NOT NULL,
    COOKING_STEP NUMBER(3),
    COOKING_DESC VARCHAR2(300),
    COOKING_IMAGE VARCHAR2(200)
);

COMMIT;

DROP TABLE COOKING_STEPS CASCADE CONSTRAINTS;
DROP TABLE LIKES CASCADE CONSTRAINTS;
DROP TABLE ORDER_INFO CASCADE CONSTRAINTS;
DROP TABLE ORDERS CASCADE CONSTRAINTS;
DROP TABLE CART_INFO CASCADE CONSTRAINTS;
DROP TABLE CART CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_COMMENTS;
DROP TABLE COMMENTS CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_REVIEW;
DROP TABLE REVIEW CASCADE CONSTRAINTS;
DROP TABLE COOKING_STEPS;
DROP TABLE INGREDIENT CASCADE CONSTRAINTS;
DROP TABLE RECIPE CASCADE CONSTRAINTS;
DROP TABLE USERS;
DROP TABLE MANAGER;
DROP TABLE DIRECTOR;

DROP TABLE MEALKIT CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_MEALKIT;



--임의의 사용자정보 INSERT
INSERT INTO USERS VALUES('kimttobi@ttobi.com', '또또비', '김또비', '1234ttobi', '2019-03-01', 01012345678, '서울특별시 중구 남대문로 120 대일빌딩 2F, 3F');