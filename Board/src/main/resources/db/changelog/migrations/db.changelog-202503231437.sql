--liquibase formatted sql
--changeset Gabrielle:202503231417
--comment: boards_columns table create

create table BOARDS_COLUMNS (
    id bigint auto_increment primary key,
    name varchar(255) not null,
    `order` int not null,
    kind varchar(255) not null,
    board_id bigint not null,
    constraint boards__boards_columns_fk foreign key (board_id) references boards(id) on delete cascade,
    constraint id_order_uk unique key unique_board_id_order (border_id, `order`) 
) engine=InnoDB;

--rollback drop table boards_columns