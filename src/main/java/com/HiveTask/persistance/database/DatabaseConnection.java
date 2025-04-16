package com.HiveTask.persistance.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.HiveTask.common.utils.AppPropertiesReader;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

@Log4j2
public class DatabaseConnection {
    // Singleton pattern
    private static DatabaseConnection instance = null;
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;
    private final Connection connection;

    private DatabaseConnection () {
        dbUrl = AppPropertiesReader.getProperty("app.datasource.url");
        dbUser = AppPropertiesReader.getProperty("app.datasource.username");
        dbPassword = AppPropertiesReader.getProperty("app.datasource.password");

        try {
            connection = DriverManager.getConnection(
                    dbUrl,
                    dbUser,
                    dbPassword
            );
        } catch (SQLException e) {
            throw new RuntimeException("Connection paramaters :\n\n" + getParameters() + "\nOriginal exception message: " + e.getMessage());
        }
    }

    private String getParameters (){
        return String.format("url: %s\nUser: %s\nPassword: %s\n",
                dbUrl,
                dbUser,
                dbPassword
        );
    }

    @SuppressWarnings("SqlSourceToSinkFlow")
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }
}