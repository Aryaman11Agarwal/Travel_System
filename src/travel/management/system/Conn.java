/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

import java.sql.*;

/**
 *
 * @author aryam
 */
public class Conn {
    Connection c;
    Statement s;
    Conn(){
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         
          c=DriverManager.getConnection("jdbc:mysql:///travelManagementSystem","root","Sooryavanshi@1103");
          s=c.createStatement();
      }catch(Exception e){
          System.out.println(e);
      }
}
}
