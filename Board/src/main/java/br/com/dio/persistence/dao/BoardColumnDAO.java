package br.com.dio.persistence.dao;

import br.com.dio.persistence.entity.BoardEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Driver;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


import com.mysql.cj.jdbc.StatementImpl;

import br.com.dio.persistence.entity.BoardColumnEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardColumnDAO {
    private final Connection connection;

    public BoardColumnEntity insert() throws SQLException{
        var sql = "insert into board_columns(name, `order`, kind, board_id) values (?,?,?,?);";
        try(var statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setString(i++, entity.getName());
            statement.setInt(i++, entity.getOrder());
            statement.setString(i++, entity.getKind().name());
            statement.setLong(i, entity.getBoard().getId());
            statement.executeQuery();

            if(statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
            return entity;
        }
    }
    public List<BoardColumnEntity> findByBoardId(final Long id){
        List<BoardColumnEntity> entities = new ArrayList<>();
        var sql = "select id, name, `order`, kind from boards_columns where board_id = ? order by `order`";
        try(var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            while(resultSet.next()){
                var entity = new BoardColumnEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setOrder(resultSet.getInt("order"));
                entity.setKind(findByName(resultSet.getString("kind")))
                entities.add(entity);
            }
        }
        return null;
    }
}
