/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

/**
 *
 * @author aryam
 */
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;
public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JButton checkprice,bookpackage,back;
    JLabel lblprice,labelid,labelphone,labelnumber;
     BookPackage(String username){
         this.username=username;
         setBounds(350,200,1100,500);
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
         JLabel text =new JLabel("BOOK PACKAGE");
         text.setBounds(100,10,200,30);
         text.setFont(new Font("Tahoma",Font.BOLD,20));
         add(text);
         
         JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
        JLabel labelusername=new JLabel("");
        labelusername.setBounds(250,70,200,20);
        
        add(labelusername);
                
        
        JLabel selectPac=new JLabel("Select Package");
        selectPac.setBounds(40,110,120,20);
        selectPac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(selectPac);
        
        cpackage = new Choice();
        cpackage.add("Select");
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);
        
                
        
        JLabel lblpersons=new JLabel("Number of Persons:");
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpersons.setBounds(40,150,150,20);
        add(lblpersons);
        
       tfpersons=new JTextField("1");
       tfpersons.setBounds(250,150,200,25);
       add(tfpersons);
        
        
        JLabel lblid=new JLabel("Id:");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
         labelid=new JLabel("");
        labelid.setBounds(250,190,150,25);
        add(labelid);
                
        
        JLabel lblnumber=new JLabel("Number:");
        lblnumber.setBounds(40,230,150,20);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
         labelnumber=new JLabel("");
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        
          JLabel lblphone=new JLabel("Phone:");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);


 labelphone=new JLabel("");
        labelphone.setBounds(250,270,150,25);
        add(labelphone);        
   
        
        JLabel lbltotal=new JLabel("Total:");
        lbltotal.setBounds(40,310,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
         lblprice=new JLabel();
        lblprice.setBounds(250,310,150,20);
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
         checkprice.setBounds(60,380,120,25);
         checkprice.addActionListener(this);
         add(checkprice);
         
         bookpackage=new JButton("Book Package");
         bookpackage.setBackground(Color.black);
         bookpackage.setForeground(Color.white);
         bookpackage.setBounds(200,380,120,25);
         bookpackage.addActionListener(this);
         add(bookpackage);
         
         back=new JButton("Back");
         back.setBackground(Color.black);
         back.setForeground(Color.white);
         back.setBounds(340,380,120,25);
         back.addActionListener(this);
         add(back);
         
         
         
         
         
        
        setVisible(true);
     }
    
     
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()==back){
           //   new Dashboard(username).setVisible(true);
             setVisible(false);
         }
         else{
           String pack=cpackage.getSelectedItem();
           int persons=Integer.parseInt(tfpersons.getText());
           int cost=0;
           
           if(pack.equals("Select"))
                JOptionPane.showMessageDialog(null, "Select a package");
           else{  
               
                if(pack.equals("Gold Package"))
               cost+=persons*36000;
          else if(pack.equals("Silver Package"))
               cost+=persons*24000;
           
           else
              cost+=persons*12000;
         
                
                if(ae.getSource()==checkprice){
      lblprice.setText("Rs. "+cost+"");
         }
         
         else if(ae.getSource()==bookpackage){
             
             try{
                 Conn c=new Conn();
                 c.s.executeUpdate("insert into bookpackage values('"+username+"', '"+pack+"', '"+persons+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+cost+"')");
                 JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                 //setVisible(false);
                 // new Dashboard(username).setVisible(true);
                 dispose();
             }catch(Exception e){
                 e.printStackTrace();
             }
             
         }
         
        
           } 
         }
     }
    public static void main(String args[]){
        new BookPackage("");
    }
}
