DROP TABLE IF EXISTS "order";
CREATE TABLE "order" AS SELECT * FROM CSVREAD('classpath:order.csv');