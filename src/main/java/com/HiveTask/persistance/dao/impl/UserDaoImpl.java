package com.HiveTask.persistance.dao.impl;

import com.HiveTask.domain.entity.User;
import com.HiveTask.domain.services.UserService;
import com.HiveTask.persistance.dao.UserDao;
import com.HiveTask.persistance.database.DatabaseConnection;
import com.HiveTask.persistance.rowMaper.UsersRowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        String sql = "INSERT INTO users (name, email, password, userName) VALUES (?, ?, ?, ?)";


        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql)){

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getUserName());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No se inserto ningun registro");
            } else {
                System.out.println("Se inserto un nuevo usuario");

                userLoginByEmail(user.getEmail(), user.getPassword());

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void userLoginByEmail(String email, String password) {

        String sql = "SELECT email, password FROM users WHERE email = ? AND password = ?";

        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                // Se encontró un usuario con ese email y password
                System.out.println("Login exitoso.");
            } else {
                // No se encontró ningún usuario
                System.out.println("Email o contraseña incorrectos.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void userLoginByName(String userName, String password) {

        String sql = "SELECT * FROM users WHERE userName = ? AND password = ?";

        try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                System.out.println("Login exitoso para el usuario: " + rs.getString("userName"));
            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}