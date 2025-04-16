package com.HiveTask.persistance.rowMaper;

import com.HiveTask.domain.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRowMapper extends RowMapper<User> {

    @Override
    public User mapItem(ResultSet rs) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setUserName(rs.getString("userName"));
        user.getCodeIMG();

        return user;
    }



}
