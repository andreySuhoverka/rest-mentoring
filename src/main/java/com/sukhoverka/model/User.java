package com.sukhoverka.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String email;

    public User(){}

    public User(String firstName, String lastName, String login, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    @XmlElement
    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }
}
