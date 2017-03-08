-- 요리책
CREATE TABLE COOKBOOK (
    BOOK_ID     INTEGER      PRIMARY KEY, -- 요리책ID
    BOOK_NAME   VARCHAR(20)  NOT NULL, -- 요리책명
    BOOK_DESC   VARCHAR(200) NOT NULL, -- 설명
    AUTHOR_ID   VARCHAR(30)  NOT NULL, -- 등록자ID
    AUTHOR_NAME VARCHAR(30)  NOT NULL -- 등록자명
);

CREATE SEQUENCE cookbook_seq START WITH 1 INCREMENT BY 1;

-- 조리법
CREATE TABLE RECIPE (
    RECIPE_ID     INTEGER      PRIMARY KEY, -- 레시피ID
    BOOK_ID       INTEGER      NOT NULL, -- 요리책ID
    RECIPE_NAME   VARCHAR(20)  NOT NULL, -- 레시피명
    RECIPE_TIME   INTEGER      NOT NULL, -- 조리시간
    F_LEVEL       INTEGER      NOT NULL, -- 난이도
    INGREDIENTS   VARCHAR(300) NULL    , -- 재료
    IMG_CONT_TYPE VARCHAR(20)  NULL    , -- 사진파일형식
    IMG_FILE_NAME VARCHAR(20)  NULL    , -- 사진파일명
    WRITER_ID     VARCHAR(30)  NOT NULL, -- 등록자ID
    WRITER_NAME   VARCHAR(30)  NOT NULL  -- 등록자명
);
CREATE SEQUENCE recipe_seq START WITH 1 INCREMENT BY 1;

-- 조리절차
CREATE TABLE RECIPE_PROCEDURE (
    RECIPE_ID INTEGER      NOT NULL , -- 레시피ID
    SEQ_NUM   INTEGER      NOT NULL , -- 조리절차순번
    PROCEDURE  VARCHAR(200) NOT NULL   -- 조리절차설명
);

-- 조리절차
ALTER TABLE RECIPE_PROCEDURE
    ADD CONSTRAINT PK_RECIPE_PROCEDURE -- 조리절차 기본키
        PRIMARY KEY (
            RECIPE_ID, -- 레시피ID
            SEQ_NUM   -- 조리절차순번
        );

-- 사용자
CREATE TABLE USER_TB (
    USER_ID   VARCHAR(30) NOT NULL , -- 사용자ID
    PASSWD  VARCHAR(30) NOT NULL , -- 비밀번호
    USER_NAME VARCHAR(30) NOT NULL   -- 사용자명
);

-- 사용자
ALTER TABLE USER_TB
    ADD CONSTRAINT PK_USER -- 사용자 기본키
        PRIMARY KEY (
            USER_ID -- 사용자ID
        );
        
        
-- 초기데이터 (사용자)
INSERT INTO USER_TB (user_id, passwd, user_name) VALUES ('yorizori', '1234', '요리조리');
INSERT INTO USER_TB (user_id, passwd, user_name) VALUES ('kimgisa', '1234', '김기사');

-- 초기데이터 (요리책)
INSERT INTO COOKBOOK (book_id, book_name, book_desc, author_id, author_name) 
VALUES (cookbook_seq.nextval, '요리조리북', '요리조리 특선 요리책', 'yorizori', '요리조리');

-- 초기데이터 (조리법)
INSERT INTO RECIPE (recipe_id, book_id, recipe_name, recipe_time, f_level, ingredients, img_cont_type, img_file_name, writer_id, writer_name)
VALUES (recipe_seq.nextval, 1, '맛있는 피자', 30, 3, '밀가루', '', '', 'kimgisa', '김기사');

INSERT INTO RECIPE_PROCEDURE (recipe_id, seq_num, procedure) 
VALUES (1, 1, '물에 밀가루를 넣는다.');

INSERT INTO RECIPE_PROCEDURE (recipe_id, seq_num, procedure) 
VALUES (1, 2, '오븐에 넣고 굽는다.');


COMMIT;