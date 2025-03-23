package br.com.dio.persistence.config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConnectionConfig { //o 'final' faz com que a herança não seja herdável
    public static Connection getConnection() throws SQLException {
        var url = "jdbc:mysql://localhost/board";
        var user = "board";
        var password = "board";
        var connection = DriverManager.getConnection(url, user, password); //string de conexão com bd
        connection.setAutoCommit(false);
        return connection;
    }
}
