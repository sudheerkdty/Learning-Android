package com.test.test.test;

/**
 * Created by nuventure on 17/2/16.
 */
public class User {

    // private variables
    public int _id;
    public String _name;
    public String _user_name;
    public String _password;
    public String _phone_number;
    public String _email;

    public User() {
    }

    // constructor
    public User(int id, String name,  String user_name, String password, String phone_number, String email) {
        this._id = id;
        this._name = name;
        this._user_name = user_name;
        this._password = password;
        this._phone_number = phone_number;
        this._email = email;

    }

    // constructor
    public User(String name,  String user_name, String password, String phone_number, String email) {
        this._name = name;
        this._user_name = user_name;
        this._password = password;
        this._phone_number = phone_number;
        this._email = email;

    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getName() {
        return this._name;
    }

    // setting name
    public void setName(String name) {
        this._name = name;
    }
    // getting name
    public String getUserName() {
        return this._user_name;
    }

    // setting name
    public void setUserName(String User_name) {
        this._user_name = User_name;
    }
    // getting name
    public String get_password() {
        return this._password;
    }

    // setting name
    public void set_password(String password) {
        this._password = password;
    }

    // getting phone number
    public String getPhoneNumber() {
        return this._phone_number;
    }

    // setting phone number
    public void setPhoneNumber(String phone_number) {
        this._phone_number = phone_number;
    }

    // getting email
    public String getEmail() {
        return this._email;
    }

    // setting email
    public void setEmail(String email) {
        this._email = email;
    }

}