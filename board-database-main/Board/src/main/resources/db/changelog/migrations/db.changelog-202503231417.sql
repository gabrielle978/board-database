--liquibase formatted sql
--changeset Gabrielle:202503231417
--comment: boards table create

create table BOARDS (
    id bigint auto_increment primary key,
    name varchar(255) not null
) engine=InnoDB;

--rollback drop table boards