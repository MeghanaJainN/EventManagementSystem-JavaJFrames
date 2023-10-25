/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author Meghana Jain
 */
public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE(email))";
            String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','8901234567','India','admin','What is your fav Marvel Character?','LOKI','true')";
            String eventTable = "create table event(id int AUTO_INCREMENT primary key,name varchar(200))";
            String venueTable = "create table venue(id int AUTO_INCREMENT primary key,name varchar(200),event varchar(200),price varchar(200))";
            String billTable = "create table bill(id int primary key,name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdBy varchar(200))";
            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
            DbOperations.setDataOrDelete(adminDetails, "Admin Details added Succesfully");
            DbOperations.setDataOrDelete(eventTable, "Event Table created Succesfully");
            DbOperations.setDataOrDelete(venueTable, "Venue Table created Succesfully");
            DbOperations.setDataOrDelete(billTable, "Bill Table created Succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
