package br.com.dio.persistence.entity;

import liquibase.repackaged.org.apache.commons.lang3.builder.ToStringExclude;
import lombok.Data;

@Data
public class BoardColumnEntity {
    private Long id;
    private String name;
    private int order;
    private BoardColumnKindEnum kind;

    @ToStringExclude
    private BoardEntity board = new BoardEntity();
}
