CREATE TABLE board_member(
	member_id NUMBER PRIMARY KEY,
	m_id varchar(20),
	m_pass varchar(20),
	m_name varchar(20),
	regdate DATE DEFAULT sysdate
);

CREATE SEQUENCE seq_board_member
INCREMENT BY 1
START WITH 1;

SELECT * FROM BOARD_MEMBER WHERE m_id=? AND m_pass=?

CREATE TABLE board(
	board_id NUMBER PRIMARY KEY,
	title varchar(100),
	writer varchar(20),
	content clob,
	regdate DATE DEFAULT sysdate,
	hit NUMBER DEFAULT 0
);

CREATE SEQUENCE seq_board
INCREMENT BY 1
START WITH 1;