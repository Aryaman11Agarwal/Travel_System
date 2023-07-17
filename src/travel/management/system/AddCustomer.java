/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

import  javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail;
    JRadioButton rmale,rfemale;
    JButton add,back;
    String username;
  
    AddCustomer(String username){
        setBounds(450,200,850,500);
        setLayout(null);
       
        getContentPane().setBackground(Color.white);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid=new JLabel("Id:");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
         comboid=new JComboBox(new String[] {"Select","Passport","Aadhar Card","PAN card","Ration Card"});
         comboid.setBounds(220,90,150,25);
         comboid.setBackground(Color.white); 
         add(comboid);
         
         JLabel lblnumber=new JLabel("Number:");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber =new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        JLabel lblname=new JLabel("Name:");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        
        labelname=new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        JLabel lblgender=new JLabel("Gender:");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        rmale=new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.white);
        add(rmale);
        
         rfemale=new JRadioButton("Female");
         rfemale.setBounds(300,210,70,25);
         rfemale.setBackground(Color.white);
        add(rfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        
        JLabel lblcountry=new JLabel("Country:");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        tfcountry =new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        
         JLabel lbladdress=new JLabel("Address:");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        
        JLabel lblphone=new JLabel("Phone:");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
         JLabel lblemail=new JLabel("Email:");
        lblemail.setBounds(30,370,150,25);
        add(lblemail);
        
        tfemail =new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);
        
        add=new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);
         
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,38,450,500);
                add(image);
                
                
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("Select * from account where username ='"+username+"'");
                    
                    while(rs.next()){
                        labelusername.setText(rs.getString("username"));
                        labelname.setText(rs.getString("name"));
                    }
                    
                }catch(Exception e){
                    
                }
                
               
        
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=labelusername.getText();
            String id=(String)comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender="";
            if(rmale.isSelected())
                gender="Male";
            else if(rfemale.isSelected())
                gender="Female";
            
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            
            
            
            try{
                Conn c=new Conn();
               
                if(id.equals("Select"))
                JOptionPane.showMessageDialog(null, "Select a valid id proof");
          else  if(number.equals(""))
                JOptionPane.showMessageDialog(null, "Enter the number");
         else   if(gender.equals(""))
                JOptionPane.showMessageDialog(null, "Select gender");
         else   if(country.equals(""))
                JOptionPane.showMessageDialog(null, "Enter your country");
          else  if(address.equals(""))
                JOptionPane.showMessageDialog(null, "Enter your address");
           else  if(phone.equals(""))
                JOptionPane.showMessageDialog(null, "Enter your phone number");
            else  if(email.equals(""))
                JOptionPane.showMessageDialog(null, "Enter your email");
            
            
          else {
              String query="insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
              c.s.executeUpdate(query);
              
              JOptionPane.showMessageDialog(null, "Customer Details added successfully");
              setVisible(false);
            
          }
            
            }catch(Exception e){
               e.printStackTrace(); 
            }
               
           
            
        }
        else{
           setVisible(false);
           //new Dashboard(labelusername.getText()).setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new AddCustomer("");
    }
    
}
