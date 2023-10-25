/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import model.Venue;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Event;

/**
 *
 * @author Meghana Jain
 */
public class VenueDao {

    public static void save(Venue venue) {
        String query = "insert into venue(name,event,price)values('" + venue.getName() + "','" + venue.getEvent() + "','" + venue.getPrice() + "')";
        DbOperations.setDataOrDelete(query, "Venue added Successfully");
    }

    public static ArrayList<Venue> getAllRecords() {
        ArrayList<Venue> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from venue");
            while (rs.next()) {
                Venue venue = new Venue();
                venue.setId(rs.getInt("id"));
                venue.setName(rs.getString("name"));
                venue.setEvent(rs.getString("event"));
                venue.setPrice(rs.getString("price"));
                arrayList.add(venue);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void update(Venue venue) {
        String query = "update venue set name='" + venue.getName() + "',event='" + venue.getEvent() + "',price='" + venue.getPrice() + "'where id='" + venue.getId() + "'";
        DbOperations.setDataOrDelete(query, "Venue updated Successfully");
    }

    public static void delete(String id) {
        String query = "delete from venue where id='" + id + "'";
        DbOperations.setDataOrDelete(query, "Venue Deleted Successfully");
    }

    public static ArrayList<Venue> getAllRecordsByEvent(String event) {
        ArrayList<Venue> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from venue where event = '" + event + "'");
            while (rs.next()) {
                Venue venue = new Venue();
                venue.setName(rs.getString("name"));
                arrayList.add(venue);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static ArrayList<Venue> filterVenueByname(String name, String event) {
        ArrayList<Venue> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from venue where name like '%" + name + "%' and event ='" + event + "'");
            while (rs.next()) {
                Venue venue = new Venue();
                venue.setName(rs.getString("name"));
                arrayList.add(venue);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static Venue getVenueByname(String name){
        Venue venue =new Venue();
        try{
            ResultSet rs = DbOperations.getData("select *from venue where name ='" + name + "'"); 
            while (rs.next()) {
                venue.setName(rs.getString(2));
                venue.setEvent(rs.getString(3));
                venue.setPrice(rs.getString(4));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return venue;
    }
}
