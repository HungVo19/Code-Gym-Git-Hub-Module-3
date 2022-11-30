package com.example.usermanager.dao;

import com.example.usermanager.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUerDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/lec12_user_manager?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select * from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String FIND_BY_COUNTRY_SQL = "select * from users where country LIKE concat('%',?,'%');";
    private static final String SORT_BY_SQL = "select * from users order by ";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);

            ResultSet rs = getSet(preparedStatement);

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            resultSet(users, preparedStatement);
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<User> findByCountry(String countryToFind) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_COUNTRY_SQL)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, countryToFind);

            ResultSet rs = getResultSet(preparedStatement);
            resultNext(users, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    private static ResultSet getResultSet(PreparedStatement preparedStatement) throws SQLException {
        ResultSet rs = getSet(preparedStatement);
        return rs;
    }

    public List<User> sortBy(String string) {
        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_SQL + string)) {
            resultSet(users, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    private void resultSet(List<User> users, PreparedStatement preparedStatement) throws SQLException {
        ResultSet rs = getSet(preparedStatement);
        resultNext(users, rs);
    }

    private void resultNext(List<User> users, ResultSet rs) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            users.add(new User(id,name,email,country));
        }
    }

    private static ResultSet getSet(PreparedStatement preparedStatement) throws SQLException {
        ResultSet rs = preparedStatement.executeQuery();
        return rs;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
