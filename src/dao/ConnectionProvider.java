/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
/**
 *
 * @author Meghana Jain
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?useSSL=false","root","Megha@2002");
            return con;
        }
        catch(Exception e) {
            return null;
        }
    }
}
