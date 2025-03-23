package br.com.dio.persistence.entity;

import java.util.List;

import lombok.Data;

@Data
public class BoardEntity {
    private Long id;
    private String name;
    private List<BoardColumnEntity> boardColumns;

    public BoardColumnEntity getInitialColumn(){
        return getFilteredColumn(bc -> bc.getKind().equals(INITIAL));
    }

    public BoardColumnEntity getCancelColumn(){
        return getFilteredColumn(bc -> bc.getKind().equals(CANCEL));
    }

    private BoardColumnEntity getFilteredColumn(Predicate<BoardColumnEntity> filter){
        return boardColumns.stream()
                .filter(filter)
                .findFirst().orElseThrow();


    }
