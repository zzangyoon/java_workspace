/*최상위 카테고리*/
CREATE TABLE topcategory(
	topcategory_id NUMBER,
	name varchar(25),
	PRIMARY KEY(topcategory_id)
);
/*블럭지정 후 cntl + enter 누르면 쿼리문수행*/

CREATE SEQUENCE seq_topcategory
INCREMENT BY 1
START WITH 1;

/*하위 카테고리*/
CREATE TABLE subcategory(
	subcategory_id NUMBER,
	topcategory_id number,
	name varchar(25),
	PRIMARY key(subcategory_id),
	CONSTRAINT fk_topcategory FOREIGN KEY (topcategory_id)
	REFERENCES topcategory(topcategory_id)
);
CREATE SEQUENCE seq_subcategory
INCREMENT BY 1
START WITH 1;

CREATE TABLE product(
	product_id NUMBER,
	subcategory_id NUMBER,
	product_name varchar(30),
	brand varchar(20),
	price NUMBER DEFAULT 0,
	filename varchar(20),
	PRIMARY key(product_id),
	CONSTRAINT fk_subcategory FOREIGN KEY (subcategory_id)
		REFERENCES subcategory(subcategory_id)
);

CREATE SEQUENCE seq_product
INCREMENT BY 1
START WITH 1;

/*데이터 넣기*/
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID, NAME) values(seq_topcategory.nextval, '상의');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID, NAME) values(seq_topcategory.nextval, '하의');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID, NAME) values(seq_topcategory.nextval, '액세서리');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID, NAME) values(seq_topcategory.nextval, '신발');

SELECT * FROM topcategory;
/*블럭 지정후 cntl + shift + y : 소문자로 바꾸기*/
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,1,'가디건');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,1,'셔츠');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,1,'티셔츠');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,1,'니트');

INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,2,'청바지');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,2,'치마');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,2,'슬랙스');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,2,'면바지');

INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,3,'귀걸이');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,3,'팔찌');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,3,'목걸이');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,3,'반지');

INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,4,'구두');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,4,'샌들');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,4,'슬리퍼');
INSERT INTO subcategory(subcategory_id, topcategory_id, name) values(seq_subcategory.nextval,4,'운동화');

SELECT * FROM subcategory;

select * from subcategory where topcategory_id = 3;


