package com.HiveTask.persistance.dao.impl;

import com.HiveTask.domain.entity.User;
import com.HiveTask.domain.services.UserService;
import com.HiveTask.persistance.dao.UserDao;
import com.HiveTask.persistance.database.DatabaseConnection;
import com.HiveTask.persistance.rowMaper.UsersRowMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private final DatabaseConnection databaseConnection;
    private final UsersRowMapper usersRowMapper;

    public UserDaoImpl() {
        this.databaseConnection = DatabaseConnection.getInstance();
        this.usersRowMapper = new UsersRowMapper();
    }



    @Override
    public void userRegister(User user) {

        String sql = "INSERT INTO users (id, name, email, password, userName, codeIMG) VALUES (?, ?, ?, ?, ?, ?)";


        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql)){

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getUserName());
            preparedStatement.setString(6, user.getCodeIMG());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No se inserto ningun registro");
            } else {
                System.out.println("Se inserto un nuevo usuario");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void userLoginByEmail(String email) {

    }

    @Override
    public void userLoginByName(String name) {

    }
}