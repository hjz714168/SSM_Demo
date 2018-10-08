-- auto-generated definition
CREATE TABLE student
(
  Uid     BIGINT      NOT NULL
  COMMENT 'Uid'
    PRIMARY KEY,
  Name    VARCHAR(20) NOT NULL,
  Age     INT(3)      NOT NULL,
  ClassId BIGINT      NULL
);
CREATE INDEX StudentClass
  ON student (ClassId);


-- auto-generated definition
CREATE TABLE studentclass
(
  ClassId   BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  ClassName VARCHAR(10) NULL
);