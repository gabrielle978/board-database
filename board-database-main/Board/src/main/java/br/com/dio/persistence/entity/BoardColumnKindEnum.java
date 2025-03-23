package br.com.dio.persistence.entity;

public enum BoardColumnKindEnum {
    INITIAL, FINAL, CANCEL, PENDING;

    public static BoardColumnKindEnum findByName(final String name){
        return Stream.of(BoardColumnKindEnum.values())
            .filter(b -> b.name()equals(name))
            .findFirst().orElseThrow();
    }

}
