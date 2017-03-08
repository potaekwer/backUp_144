-- DROP TABLE AUTHOR_TB;
-- DROP TABLE BLOG_TB;
-- DROP TABLE POST_TB;
-- DROP TABLE TAG_TB;
-- DROP TABLE COMMENT_TB;
--
--DROP SEQUENCE blog_seq;
--DROP SEQUENCE post_seq;
--DROP SEQUENCE tag_seq;
--DROP SEQUENCE comment_seq;

CREATE SEQUENCE blog_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE post_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE tag_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE comment_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE author_tb (
  author_id varchar2(20),
  author_password varchar2(20),
  author_name varchar2(20) DEFAULT NULL,
  email varchar2(30) DEFAULT NULL,
 PRIMARY KEY (author_id)
);

CREATE TABLE blog_tb (
  blog_id NUMBER NOT NULL,
  title varchar2(255) DEFAULT NULL,
  author_id varchar2(20) DEFAULT NULL,
  PRIMARY KEY (blog_id)
);

CREATE TABLE post_tb (
  id NUMBER NOT NULL,
  subject varchar2(255) DEFAULT NULL,
  contents varchar2(2000) DEFAULT NULL,
  author_id varchar2(20) DEFAULT NULL,
  blog_id NUMBER DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE comment_tb (
  id NUMBER NOT NULL,
  name varchar2(255) DEFAULT NULL,
  comment_contents varchar2(2000) DEFAULT NULL,
  post_id NUMBER DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE tag_tb (
  id NUMBER NOT NULL,
  name varchar2(255) DEFAULT NULL,
  post_id NUMBER DEFAULT NULL,
  PRIMARY KEY (id)
);

insert into author_tb(author_id,author_password,author_name,email) values ('demonpark','111','박데몬','demonpark@nextree.co.kr');
insert into author_tb(author_id,author_password,author_name,email) values ('jhheo','111','허진호','jhheo@nextree.co.kr');
insert into author_tb(author_id,author_password,author_name,email) values ('syhan','111','한승용','syhan@nextree.co.kr');
insert into author_tb(author_id,author_password,author_name,email) values ('eykim','111','김은영','eykim@nextree.co.kr');
insert into author_tb(author_id,author_password,author_name,email) values ('kimgisa','111','김기사','hyunohkim@nextree.co.kr');

insert into blog_tb(blog_id,title,author_id) values (blog_seq.NEXTVAL,'하늘바람별','demonpark');
insert into blog_tb(blog_id,title,author_id) values (blog_seq.NEXTVAL,'보편적인블로그','eykim');
insert into blog_tb(blog_id,title,author_id) values (blog_seq.NEXTVAL,'김기사의 iT스토리','kimgisa');

insert into post_tb(id,subject,contents,blog_id) values (post_seq.NEXTVAL,'mybatis','mybatis의 이해와 적용',1);
insert into post_tb(id,subject,contents,blog_id) values (post_seq.NEXTVAL,'mybatis3','mybatis 3.0 무작정 따라하기',1);
insert into post_tb(id,subject,contents,blog_id) values (post_seq.NEXTVAL,'hibernate','OR매핑의 이해와 Hibernate',2);

insert into comment_tb(id,name,comment_contents,post_id) values (comment_seq.NEXTVAL,'임재락','이해가 잘 안되요',1);
insert into comment_tb(id,name,comment_contents,post_id) values (comment_seq.NEXTVAL,'이동규','그게 뭐에요?',2);
insert into comment_tb(id,name,comment_contents,post_id) values (comment_seq.NEXTVAL,'강원미','ORM기술은 정말 놀랍군요...',3);

insert into tag_tb(id,name,post_id) values (tag_seq.NEXTVAL,'mybatis',1);
insert into tag_tb(id,name,post_id) values (tag_seq.NEXTVAL,'mybatis3',2);
insert into tag_tb(id,name,post_id) values (tag_seq.NEXTVAL,'hibernate',3);

commit;