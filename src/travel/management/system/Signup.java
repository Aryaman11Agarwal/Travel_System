/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

/**
 *
 * @author aryam
 */

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
public class Signup extends JFrame implements ActionListener{
    
    JButton create,back;
    JLabel lblusername,lblname,lblpass,lblsecurity,lblans;
    JTextField tfusername,tfname,tfpass,tfans;
    Choice security;
    
    Signup(){
          setBounds(350,200,900,360);
          getContentPane().setBackground(Color.white);
          
          JPanel p1=new JPanel();
          p1.setLayout(null); 
          p1.setBounds(0,0,500,400);
          p1.setBackground(new Color(133,193,233));
          p1.setLayout(null);
          add(p1);
          
          lblusername=new JLabel("UserName:");
       lblusername.setBounds(50,20,120,25);
       lblusername.setFont(new Font("Tahoma",Font.PLAIN,14));
       p1.add(lblusername);
       
       tfusername= new JTextField();
       tfusername.setBounds(190,20,180,25);
       tfusername.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfusername);
       
        lblname=new JLabel("Name:");
       lblname.setBounds(50,60,120,25);
       lblname.setFont(new Font("Tahoma",Font.PLAIN,14));
       p1.add(lblname);
    
       tfname= new JTextField();
       tfname.setBounds(190,60,180,25);
       tfname.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfname);
       
       
        lblpass=new JLabel("Password:");
       lblpass.setBounds(50,100,120,25);
       lblpass.setFont(new Font("Tahoma",Font.PLAIN,14));
       p1.add(lblpass);
       
      tfpass= new JTextField();
       tfpass.setBounds(190,100,180,25);
       tfpass.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfpass);
       
       
       lblsecurity=new JLabel("Security Question:");
       lblsecurity.setBounds(50,140,120,25);
       lblsecurity.setFont(new Font("Tahoma",Font.PLAIN,14));
       p1.add(lblsecurity);
       
     security=new Choice();
       security.add("Select");
       security.add("Name of first school");
       security.add("Name of favourite celebrity");
       security.add("Name of best friend");
       security.add("Your lucky number");
       security.setBounds(190,140,180,25);
       p1.add(security);
       
       
 lblans=new JLabel("Answer:");
       lblans.setBounds(50,180,120,25);
       lblans.setFont(new Font("Tahoma",Font.PLAIN,14));
       p1.add(lblans);
       
       tfans= new JTextField();
       tfans.setBounds(190,180,180,25);
       tfans.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfans);
       
        create=new JButton("Create");
       create.setBackground(Color.white);
       create.setForeground(new Color(133,193,233));
       create.setFont(new Font("Tahoma",Font.PLAIN,14));
       create.setBorder(new LineBorder(new Color(133,193,233)));
       create.setBounds(80,250,100,30);
       create.addActionListener(this);
       p1.add(create);
       
       
      back=new JButton("<-Back");
       back.setBackground(Color.white);
       back.setForeground(new Color(133,193,233));
       back.setFont(new Font("Tahoma",Font.PLAIN,14));
       back.setBorder(new LineBorder(new Color(133,193,233)));
       back.setBounds(250,250,100,30);
       back.addActionListener(this);
       p1.add(back);
       
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
       add(image);
       
       
   setLayout(null);
          
           setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String name=tfname.getText();
            String username=tfusername.getText();
            String password=tfpass.getText();
            String  question=security.getSelectedItem();
            String answer=tfans.getText();
            
            if(name.equals(""))
                JOptionPane.showMessageDialog(null, "Name is  required");
          else  if(username.equals(""))
                JOptionPane.showMessageDialog(null, "Username is  required");
         else   if(password.equals(""))
                JOptionPane.showMessageDialog(null, "Password is  required");
         else   if(question.equals("Select"))
                JOptionPane.showMessageDialog(null, "Choose the security question");
          else  if(answer.equals(""))
                JOptionPane.showMessageDialog(null, "Enter the answer to the security question");
            
          else{ String query="insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account created Successfully");
                setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
            e.printStackTrace();
        }
            
          } 
            
        }
        else{
           setVisible(false);
           new Login();
        }
        
        
    }
    public static void main(String args[]){
        Signup s1=new Signup();
    }
    
}
