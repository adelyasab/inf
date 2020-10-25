package ru.itis.repositories;

import ru.itis.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleJdbcTemplate<T> {
    private Connection connection;

    public SimpleJdbcTemplate(Connection connection) {
        this.connection = connection;
    }

    public   <T> List<T> queryForList(String sql, RowMapper<T> rowMapper, Object ... args){
        try {
            ResultSet resultSet = null;
            if (args == null) {
                Statement statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                int position = 1;
                for (Object arg: args) {
                    preparedStatement.setObject(position, arg);
                    position++;
                }
                resultSet = preparedStatement.executeQuery();
            }
            if (resultSet == null) {
                throw new SQLException("Empty result");
            }
            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(rowMapper.mapRow(resultSet));
            }

            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public   <T> List<T> queryForListByBeginning(String sql, RowMapper<T> rowMapper, String s){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int position = 1;
            ResultSet resultSet = preparedStatement.executeQuery();

            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                if (resultSet.getString("first_name").startsWith(s)) {
                    result.add(rowMapper.mapRow(resultSet));
                }
            }
            return result;
        }catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
