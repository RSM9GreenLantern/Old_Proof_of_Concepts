package com.revature.assignforce.beans;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USERID")
    @SequenceGenerator(name="USER_ID_GEN", sequenceName="USER_ID", initialValue = 1, allocationSize=1)
    @GeneratedValue(generator="USER_ID_GEN", strategy=GenerationType.SEQUENCE)
    private int id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLEID")
    private int roleId;
    @Column(name = "TRAINERID")
    private int trainerId;

    public User() {
    }

    public User(String email, String password, int roleId, int trainerId) {
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.trainerId = trainerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", trainerId=" + trainerId +
                '}';
    }
}
