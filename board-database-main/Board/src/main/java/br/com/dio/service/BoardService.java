package br.com.dio.service;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.dio.persistence.dao.BoardColumnDAO;
import br.com.dio.persistence.dao.BoardDAO;
import br.com.dio.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardService {
    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException {
        var boardColumnDAO = new BoardColumnDAO(connection);
        var dao = new BoardDAO(connection);
        try {
            dao.insert(entity);
            var columns = entity.getBoardColumns().stream().map(c -> {
                c.setBoard(entity);
                return c;
            }).toList();
            for(var column: columns){
                boardColumnDAO.insert(column);
            }
            connection.commit();
            
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
        return entity;
    }

    public void delete(final Long id) throws SQLException{
        var dao = new BoardDAO(connection);
        try{
            if (!dao.exists(id)){
                return false;
            }
                dao.delete(id);
                connection.commit();
        } catch(SQLException e){
            connection.rollback();
            throw e;
        }
    }
}
