/*
    DDL: 데이터 정의어
    
    <ALTER>
    객체를 변경하는 구문
    기존에 생성된 객체(테이블, 컬럼, 제약조건 등)의 구조를 변경(수정, 추가, 제거, 이름변경 등)을 할 때 사용
    
    ALTER 변경할객체 변경할객체이름 변경할내용;
    
    ALTER TABLE 테이블명 변경할 내용
    
    *변경할 내용
    1) 컬럼 추가/수정/삭제
    2) 제약조건을 추가/삭제 -> 수정 불가
    3) 컬럼명/제약조건명/테이블명 변경
*/

SELECT * FROM DEPARTMENT;

-- 1) 컬럼/추가/삭제
-- DEPARTMENT 테이블에 CNAME 컬럼을 추가
ALTER TABLE DEPARTMENT ADD CNAME VARCHAR2(20);

-- LNAME컬럼 -> 기본값 '한국'
ALTER TABLE DEPARTMENT ADD LNAME VARCHAR2(20) DEFAULT '한국';

-- 1_2 커럼 수정
-- 데이터타입 수정: MODIFY 컬럼명 변경하고자하는 데이터타입
ALTER TABLE DEPARTMENT MODIFY CNAME VARCHAR2(30);
ALTER TABLE DEPARTMENT MODIFY LNAME NUMBER; -- 형식오류 발생

-- DEFAULT값 수정 : MODIFY 컬럼명 DEFAULT 변경할 기본값
-- LNAME 컬럼의 DEFAULT '미국'으로 변경
ALTER TABLE DEPARTMENT MODIFY LNAME DEFAULT '미국';

-- 다중변경
ALTER TABLE DEPARTMENT
        MODIFY DEPT_TITLE VARCHAR2(40)
        MODIFY LNAME DEFAULT '중국';
        
-- 1_3) 컬럼 삭제(DROP COLUMN): DROP COLUMN 삭제하고자하는 컬럼
CREATE TABLE DEPT_COPY
AS (SELECT * FROM DEPARTMENT);

ALTER TABLE DEPT_COPY DROP COLUMN DEPT_ID;
ALTER TABLE DEPT_COPY DROP COLUMN CNAME;
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_TITLE;

/*
    테이블이 생성된 후에 제약조건을 수정하는 방법
    ALTER TABLE 테이블명 변경할 내용
    
    제약조건 추가방법
    -PRIMARY KEY : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] PRIMARY KEY(컬럼명);
    -FOREIGN KEY : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] FOREIGN KEY(컬럼명) REFERENCES 참조할테이블명(컬럼명);
    -UNIQUE : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] UNIQUE(컬럼명);
    -CHECK : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] CHECK(컬럼에대한 조건식);
    
    위의 제약조건을 제거하려면
    -ALTER TABLE 테이블명 DROP CONTRAINT 제약조건이름;
    
    -NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
                ALTER TABLE 테이블명 MODIFY 컬럼명 NULL;
*/

-- DEPT_COPY
-- DEPT_ID에 PRIMARY 제약조건 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT DEPT_PK PRIMARY KEY(DEPT_ID);

-- DEPT_TITLE에 UNIQUE 제약조건 추가
-- LNAME에 NOT NULL 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT DEPT_UQ UNIQUE(DEPT_TITLE)
            MODIFY LNAME CONSTRAINT DEPT_LNAME_NN NOT NULL;

-- 위에서 만든 제약조건 삭제
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_PK;
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_UQ
                    MODIFY LNAME NULL;
                    
-- 테이블 삭제
-- DROP TABLE 테이블명;
-- 어딘가에 참조되고 있는 부모테이블은 함부로 삭제가 되지 않는다
-- 만약 지우고자 한다면
-- 1. 자식테이블의 데이터 또는 테이블자체를 먼저 전부 삭제
-- 2. 그냥 부모테이블만 삭제하는데 제약조건까지 삭제
-- DROP TABLE 테이블명 CASCADE CONSTRAINT

DROP TABLE DEPT_COPY;
SELECT * FROM DEPT_COPY;

-- 3) 컬럼명/제약조건명/테이블명 변경
-- 3_1) 컬럼명 변경 : RENAME COLUMN 기존컬럼명 TO 새로운컬럼명
-- DEPT_TITLE -> DEPT_NAME
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

-- 3_2) 제약조건명 변경 : RENAME CONSTRAINT 기존제약조건명 TO 새로운제약조건명
ALTER TABLE DEPT_COPY RENAME CONSTRAINT SYS_C008478 TO DEPT_ID_NN;

-- 3_3) 테이블명 변경: RENAME TO 변경할테이블명
ALTER TABLE DEPT_COPY RENAME TO DEPT_TEST;