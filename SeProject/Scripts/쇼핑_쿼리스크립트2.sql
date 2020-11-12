SELECT * FROM product WHERE product_name LIKE '%Gold%';
SELECT * FROM product WHERE brand LIKE '%T%';
--첫번째 셀렉박스에 선택될 카테고리 구하기 (cntl+shift+y : 소문자로 바꾸기)
select * from topcategory where topcategory_id=(
	select topcategory_id from subcategory where subcategory_id=15
);

SELECT * FROM SUBCATEGORY;

select * from topcategory where topcategory_id=(select topcategory_id from subcategory where subcategory_id=9);

SELECT * FROM TOPCATEGORY;

SELECT * FROM SUBCATEGORY WHERE SUBCATEGORY_ID =SUBCATEGORY_ID;