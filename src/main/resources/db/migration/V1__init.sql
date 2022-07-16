create table customer (
 id bigserial primary key not null,
 document varchar(255) not null,
 code varchar(255) not null,
 phone varchar(14) not null,
 name varchar(255) not null,
 update_date DATE,
 create_date DATE
);

ALTER TABLE customer ADD CONSTRAINT document_unique UNIQUE (document);