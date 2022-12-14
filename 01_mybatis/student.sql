
-- WEB 계정 생성
-- CREATE USER WEB IDENTIFIED BY WEB;
-- GRANT RESOURCE, CONNECT TO WEB;
-- 계정 삭제하기
-- drop user WEB cascade;

------------------------------------------------
--------------- USER 관련 테이블 ---------------
------------------------------------------------

DROP TABLE STUDENT;

CREATE TABLE STUDENT (
    STUDENT_NO 		NUMBER PRIMARY KEY,
    STUDENT_NAME 	VARCHAR2(30) NOT NULL,
    STUDENT_TEL 	VARCHAR2(13),
    STUDENT_EMAIL	VARCHAR2(100),
    STUDENT_ADDR    VARCHAR2(100),
    REG_DATE DATE DEFAULT SYSDATE
);

DROP SEQUENCE SEQ_STUDENT;
CREATE SEQUENCE SEQ_STUDENT;

INSERT INTO STUDENT VALUES(SEQ_STUDENT.NEXTVAL,
 					'홍길동',
 					'01012345678',
 					'test@email.com',
 					'서울시 강남구 역삼동',DEFAULT);

COMMIT;

SELECT * FROM STUDENT;
