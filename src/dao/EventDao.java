/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Event;
import java.sql.*;

/**
 *
 * @author Meghana Jain
 */
public class EventDao {

    public static void save(Event event) {
        String query = "insert into event (name) values('" + event.getName() + "')";
        DbOperations.setDataOrDelete(query, "Event Added Successfully");
    }
    
    public static ArrayList<Event> getAllRecords(){
        ArrayList<Event> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select *from event");
            while(rs.next()){
                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setName(rs.getString("name"));
                arrayList.add(event);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void delete(String id){
        String query = "delete from event where id='"+id+"'";
        DbOperations.setDataOrDelete(query, "Event Deleted Successfully");
    }
}
