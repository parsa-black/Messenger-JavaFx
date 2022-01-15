package com.company.Controller;


import com.company.Model.User;

import java.sql.*;
import java.util.ArrayList;

public class DBUser {

    static final String DB_URL = "jdbc:mysql://localhost:3306/javafx-project";
    static final String USER = "root";
    static final String PASS = "parsagorgzan1225@gmail";
    private static Connection connection;
    private static Statement statement;

    private DBUser() {
    }

    public static void makeConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-project", "root", "parsagorgzan1225@gmail");
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int createUser(User user) throws SQLException {

        makeConnection();
        statement.execute(String.format("insert into users (username , name , lastname , password) value ('%s' , '%s' , '%s' , '%s')",
                        user.getUsername(), user.getName(), user.getLastname(), user.getPassword()),
                Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        int id = resultSet.getInt(1);

        closeConnection();

        return id;

    }

    public static void deleteUser(User user) throws SQLException {

        makeConnection();

        statement.execute(String.format("delete from users where id = %d", user.getId()));

        closeConnection();

    }

    public static ArrayList<User> getAllUsers() throws SQLException {

        makeConnection();

        ResultSet resultSet = statement.executeQuery("select * from users");

        ArrayList<User> users = new ArrayList<>();

        while (resultSet.next()) {
            users.add(new User(resultSet.getInt("id"), resultSet.getString("username"),
                    resultSet.getString("name"), resultSet.getString("lastname"),
                    resultSet.getString("password")));
        }

        closeConnection();

        return users;

    }

    public static void editUser(User user) throws SQLException { //Update in sql
        makeConnection();

        statement.execute(String.format("update users set username = '%s' , name = '%s' ," +
                        " lastname = '%s' , password = '%s' where id = %d", user.getUsername(), user.getName()
                , user.getLastname(), user.getPassword(), user.getId()));

        closeConnection();

    }

    public void showUser() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id , username , name , lastname FROM users");) {

            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print("ID: " + rs.getString("username"));
                System.out.print("ID: " + rs.getString("name"));
                System.out.print("ID: " + rs.getString("lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
