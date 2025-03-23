--liquibase formatted sql
--changeset Gabrielle:202503231417
--comment: block table create

create table BLOCK (
    id bigint auto_increment primary key,
    blockCause varchar(255) not null,
    unblockCause varchar(255) not null,
    created_at timestamp default CURRENT_TIMESTAMP,
    finished_at timestamp null,
    finished_reason varchar(255) not null,
    card_id bigint not null,
    constraint cards__block_fk foreign key (card_id) references cards(id) on delete cascade

) engine=InnoDB;

--rollback drop table block