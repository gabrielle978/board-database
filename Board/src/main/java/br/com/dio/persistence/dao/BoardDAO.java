package br.com.dio.persistence.dao;

import java.sql.Connection;

import br.com.dio.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;
import java.sql.SQLException;
import java.util.Optional;

import com.mysql.cj.jdbc.StatementImpl;

@AllArgsConstructor
public class BoardDAO {

    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException{
        var sql = "select 1 from boards where id = ?";
        try(var statement = connection.prepareStatement(sql)){
            statement.setString(1, entity.getName());
            statement.executeQuery();
            if(statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());

            }
        }
    }

    private void delete (final Long id) throws SQLException{
        var sql = "delete from boards where id = ?";
        try(var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();

    }
    private Optional<BoardEntity> findById(final Long id) throws SQLException{

        var sql = "select id, name from boards where id = ?";
        try(var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if(resultSet.next()){
                var entity = new BoardEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                return Optional.of(entity);
            }
            return Optional.empty();
        }
    }

    private Boolean exists (final Long id) throws SQLException{
        var sql = "select 1 from boards where id = ?";
        try(var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();
            return statement.getResultSet().next();
        }
    }
    
}
}