--liquibase formatted sql
--changeset Gabrielle:202503231417
--comment: cards table create

create table CARDS (
    id bigint auto_increment primary key,
    title varchar(255) not null,
    description varchar(255) not null,
    `order` int not null,
    board_column_id bigint not null,
    constraint boards_columns__cards_fk foreign key (board_column_id) references boards_columns(id) on delete cascade

) engine=InnoDB;

--rollback drop table cards