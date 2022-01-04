package com.company.Model;

import com.company.Controller.DBUser;

import java.sql.SQLException;
import java.util.ArrayList;

public class User {

    private int id = -1;
    private String username;
    private String name;
    private String lastname;
    private String password;

    public User(String username, String name, String lastname, String password) {
        this.setUsername(username);
        this.setName(name);
        this.setLastname(lastname);
        setPassword(password);
    }

    public static ArrayList<User> getAllUsers(){
        try {
            return DBUser.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(){ //save in DataBase
        if (this.id == -1){
            try {
                id = DBUser.createUser(this);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                DBUser.editUser(this); //Update in database
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } //save => create or edit

    public void delete(){
        try {
            DBUser.deleteUser(this);
            id = -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User(int id, String username, String name, String lastname, String password) {
        this.setId(id);
        this.setUsername(username);
        this.setName(name);
        this.setLastname(lastname);
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
