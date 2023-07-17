/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author aryam
 */
public class BookHotel extends JFrame implements ActionListener{
    JButton checkprice,bookpackage,back;
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    JLabel labelusername;
    String username;
    JLabel lblprice,labelid,labelnumber,labelphone;
     BookHotel(String username){
         this.username=username;
     
         setBounds(350,200,1100,600);
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
         JLabel text =new JLabel("BOOK HOTEL");
         text.setBounds(100,10,200,30);
         text.setFont(new Font("Tahoma",Font.BOLD,20));
         add(text);
         
         JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
         labelusername=new JLabel("");
        labelusername.setBounds(250,70,200,20);
        
        add(labelusername);
                
        
        JLabel selectPac=new JLabel("Select Hotel");
        selectPac.setBounds(40,110,120,20);
        selectPac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(selectPac);
        
        chotel = new Choice();
        
        chotel.setBounds(250,110,200,20);
        add(chotel);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from hotel");
            
            while(rs.next()){
                chotel.add(rs.getString("name"));
                
            }
            
        }catch(Exception e){
         System.out.println(e);
     }
                
        
        JLabel lblpersons=new JLabel("Number of Persons:");
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpersons.setBounds(40,150,150,20);
        add(lblpersons);
        
       tfpersons=new JTextField("1");
       tfpersons.setBounds(250,150,200,25);
       add(tfpersons);
        
       
       JLabel lbldays=new JLabel("Number of Days:");
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldays.setBounds(40,190,150,20);
        add(lbldays);
        
       tfdays=new JTextField("1");
       tfdays.setBounds(250,190,200,25);
       add(tfdays);
       
       JLabel lblac=new JLabel("AC/Non-AC:");
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblac.setBounds(40,230,150,20);
        add(lblac);
        
       cac=new Choice();
       cac.add("AC");
       cac.add("Non-AC");
       cac.setBounds(250,230,200,25);
       add(cac);
       
       JLabel lblfood=new JLabel("Food:");
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfood.setBounds(40,270,150,20);
        add(lblfood);
        
      cfood=new Choice();
       cfood.add("Included");
       cfood.add("Not Included");
       cfood.setBounds(250,270,200,25);
       add(cfood);
       
        
        
        JLabel lblid=new JLabel("Id:");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
         labelid=new JLabel("");
        labelid.setBounds(250,310,150,25);
        add(labelid);
                
        
        JLabel lblnumber=new JLabel("Number:");
        lblnumber.setBounds(40,350,150,20);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
         labelnumber=new JLabel("");
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);
        
          JLabel lblphone=new JLabel("Phone:");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);


  labelphone=new JLabel("");
        labelphone.setBounds(250,390,150,25);
        add(labelphone);        
   
        
        JLabel lbltotal=new JLabel("Total:");
        lbltotal.setBounds(40,430,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
       lblprice=new JLabel();
        lblprice.setBounds(250,430,150,20);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblprice);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,20,500,300);
                add(image);
                
                  try{
                    Conn c=new Conn();
                    
                    ResultSet rs=c.s.executeQuery("Select * from customer where username='"+username+"'");
                    
                    while(rs.next()){
                        labelusername.setText(rs.getString("username"));
                        labelid.setText(rs.getString("id"));
                        labelnumber.setText(rs.getString("number"));
                      
                        labelphone.setText(rs.getString("phone"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                checkprice=new JButton("Check Price");
         checkprice.setBackground(Color.black);
         checkprice.setForeground(Color.white);
         checkprice.setBounds(60,480,120,25);
         checkprice.addActionListener(this);
         add(checkprice);
         
         bookpackage=new JButton("Book Hotel");
         bookpackage.setBackground(Color.black);
         bookpackage.setForeground(Color.white);
         bookpackage.setBounds(200,480,120,25);
         bookpackage.addActionListener(this);
         add(bookpackage);
         
         back=new JButton("Back");
         back.setBackground(Color.black);
         back.setForeground(Color.white);
         back.setBounds(340,480,120,25);
         back.addActionListener(this);
         add(back);
         
       
      
        
        
        setVisible(true);
     }
     @Override
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==checkprice){
             try{
                 Conn c=new Conn();
                 ResultSet rs=c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"' ");
                while(rs.next()){ 
                 int cost=Integer.parseInt(rs.getString("costperperson"));
                  int food=Integer.parseInt(rs.getString("foodincluded"));
                   int ac=Integer.parseInt(rs.getString("acroom"));
                
                   int persons=Integer.parseInt(tfpersons.getText());
                   int days=Integer.parseInt(tfdays.getText());
                   
                   
                   String acselected=cac.getSelectedItem();
                   String foodselected=cfood.getSelectedItem();
                   
                   if(persons*days>0){
                       int total=0;
                       total+=acselected.equals("AC")?ac:0;
                       total+=foodselected.equals("Included")?food:0;
                       total+=cost;
                       total=persons*days*total;
                       lblprice.setText("Rs "+total);
                   }
                   
                   else{
                       JOptionPane.showMessageDialog(null, "Please enter valid numbers");
                   }
                }
             }catch(Exception e){
                e.printStackTrace();
             }
         }
         
         else if(ae.getSource()==bookpackage){
             checkprice.doClick();
             Conn c=new Conn();
             try{
              c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+lblprice.getText()+"')");
                     JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");}
         catch(Exception e){
                 e.printStackTrace();
                 }
         }
         
         else{
         dispose();
         }
     }
    public static void main(String args[]){
        new BookHotel("Akshay");
    
}
    
}
