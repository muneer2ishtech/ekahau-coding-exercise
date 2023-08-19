CREATE TABLE t_book (
  id     BIGSERIAL     NOT NULL,
  author VARCHAR(255)  NOT NULL,
  price  NUMERIC(10,2) NOT NULL,
  title  VARCHAR(255)  NOT NULL,
  year   SMALLINT      NOT NULL,
  PRIMARY KEY (id)
);