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
import java.awt.event.*;
import javax.swing.border.LineBorder;
public class Dashboard extends JFrame implements ActionListener{
    
    
    JPanel p1,p2,p3;
    JButton addpersonaldetails, viewpersonaldetails,updatepersonaldetails,deletepersonaldetails,checkpackages,bookpackage,viewpackage,viewhotel,bookhotel,viewbookedhotel;
    JButton destination,payment,calculator,notepad,about;
    String username;
    Dashboard(String username){
       // setBounds(0,0,1600,1000);
       this.username=username;
       setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(7,0,70,70);
                p1.add(image);
        
        JLabel heading =new JLabel("Dashboard");
        heading.setBounds(100,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
       
        addpersonaldetails=new JButton("Add Personal Details");
        addpersonaldetails.setBounds(0,0,300,50);
        addpersonaldetails.setBackground(new Color(0,0,102));
        addpersonaldetails.setForeground(Color.white);
        addpersonaldetails.setMargin(new Insets(0,0,0,60));
        addpersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
         
       // addpersonaldetails.setBorder(new LineBorder(new Color(0,0,120)));
        addpersonaldetails.setMargin(new Insets(0,0,0,60));
        addpersonaldetails.addActionListener(this);
      p2.add(addpersonaldetails);
        
        
        viewpersonaldetails=new JButton("View Personal Details");
        viewpersonaldetails.setBounds(0,50,300,50);
        viewpersonaldetails.setBackground(new Color(0,0,102));
        viewpersonaldetails.setForeground(Color.white);
        viewpersonaldetails.setMargin(new Insets(0,0,0,50));
     //   viewpersonaldetails.setBorder(new LineBorder(new Color(0,0,120)));
        viewpersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpersonaldetails.addActionListener(this);
        p2.add(viewpersonaldetails);
        
        updatepersonaldetails=new JButton("Update Personal Details");
       updatepersonaldetails.setBounds(0,100,300,50);
        updatepersonaldetails.setBackground(new Color(0,0,102));
        updatepersonaldetails.setForeground(Color.white);
        updatepersonaldetails.setMargin(new Insets(0,0,0,30));
      //  updatepersonaldetails.setBorder(new LineBorder(new Color(0,0,120)));
        updatepersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatepersonaldetails.addActionListener(this);
        // updatepersonaldetails.setMargin(new Insets(0,0,0,75640));
        p2.add(updatepersonaldetails);
        
        deletepersonaldetails=new JButton("Delete Personal Details");
        deletepersonaldetails.setBounds(0,150,300,50);
        deletepersonaldetails.setBackground(new Color(0,0,102));
        deletepersonaldetails.setForeground(Color.white);
        deletepersonaldetails.setMargin(new Insets(0,0,0,40));
        //deletepersonaldetails.setBorder(new LineBorder(new Color(0,0,120)));
        deletepersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletepersonaldetails.addActionListener(this);
        
        p2.add(deletepersonaldetails);
        
        checkpackages=new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.white);
        checkpackages.setMargin(new Insets(0,0,0,110));
     //   checkpackages.setBorder(new LineBorder(new Color(0,0,120)));
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        bookpackage=new JButton("Book Package");
        bookpackage.setBounds(0,250,300,50);
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setForeground(Color.white);
        bookpackage.setMargin(new Insets(0,0,0,120));
       // bookpackage.setBorder(new LineBorder(new Color(0,0,120)));
        bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
       bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        viewpackage=new JButton("View Package");
        viewpackage.setBounds(0,300,300,50);
        viewpackage.setBackground(new Color(0,0,102));
        viewpackage.setForeground(Color.white);
       // viewpackage.setMargin(new Insets(0,0,0,60));
       // viewpackage.setBorder(new LineBorder(new Color(0,0,120)));
        viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackage.addActionListener(this);
        viewpackage.setMargin(new Insets(0,0,0,120));
        p2.add(viewpackage);
        
        viewhotel=new JButton("View Hotels");
        viewhotel.setBounds(0,350,300,50);
        viewhotel.setBackground(new Color(0,0,102));
        viewhotel.setForeground(Color.white);
        viewhotel.setMargin(new Insets(0,0,0,130));
       // viewhotel.setBorder(new LineBorder(new Color(0,0,120)));
        viewhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotel.addActionListener(this);
        p2.add(viewhotel);
        
        bookhotel=new JButton("Book Hotel");
        bookhotel.setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.white);
        bookhotel.setMargin(new Insets(0,0,0,140));
      //  bookhotel.setBorder(new LineBorder(new Color(0,0,120)));
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        
        
        viewbookedhotel=new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0,450,300,50);
        viewbookedhotel.setBackground(new Color(0,0,102));
        viewbookedhotel.setForeground(Color.white);
        viewbookedhotel.setMargin(new Insets(0,0,0,70));
     //   viewbookedhotel.setBorder(new LineBorder(new Color(0,0,120)));
        viewbookedhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookedhotel.addActionListener(this);
        
        p2.add(viewbookedhotel);
        
        destination=new JButton("Destinations");
        destination.setBounds(0,500,300,50);
        destination.setBackground(new Color(0,0,102));
        destination.setForeground(Color.white);
        destination.setMargin(new Insets(0,0,0,125));
       // destination.setBorder(new LineBorder(new Color(0,0,120)));
        destination.setFont(new Font("Tahoma",Font.PLAIN,20));
        destination.addActionListener(this);
        p2.add(destination);
        
        
         payment=new JButton("Make Payment");
        payment.setBounds(0,550,300,50);
        payment.setBackground(new Color(0,0,102));
        payment.setForeground(Color.white);
        payment.setMargin(new Insets(0,0,0,105));
      //  payment.setBorder(new LineBorder(new Color(0,0,120)));
        payment.setFont(new Font("Tahoma",Font.PLAIN,20));
        payment.addActionListener(this);
        p2.add(payment);
        
        
         calculator=new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setMargin(new Insets(0,0,0,145));
       // calculator.setBorder(new LineBorder(new Color(0,0,120)));
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        
         notepad=new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
       notepad.setMargin(new Insets(0,0,0,155));
        // n otepad.setBorder(new LineBorder(new Color(0,0,120)));
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        
         about=new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setMargin(new Insets(0,0,0,175));
    //    about.setBorder(new LineBorder(new Color(0,0,120)));
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(7,0,1650,1000);
                add(image1);
                
                
                JLabel text=new JLabel("Travel and Tourism Management System");
                text.setBounds(400,70,1200,70);
                text.setForeground(Color.white);
                text.setFont(new Font("",Font.PLAIN,55));
                image1.add(text);
        
        setLayout(null);
        setVisible(true);
        
   }
    
    @Override
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==addpersonaldetails){
        //  setVisible(false);
      new  AddCustomer(username).setVisible(true);
      }  
      
     else if(ae.getSource()==viewpersonaldetails){
         // setVisible(false);
      new  ViewCustomer(username).setVisible(true);
      } 
      
     else if(ae.getSource()==updatepersonaldetails){
        //  setVisible(false);
      new  UpdateCustomer(username).setVisible(true);
      }
     
     else if(ae.getSource()==deletepersonaldetails){
        //  setVisible(false);
      new  DeleteDetails(username,this).setVisible(true);
      }
       
     else  if(ae.getSource()==destination){
          new  Destinations(username).setVisible(true);
      }
      
     else  if(ae.getSource()==checkpackages){
         
      new  CheckPackage();
      } 
      
     else if(ae.getSource()==calculator){
          try{
              Runtime.getRuntime().exec("calc.exe");
          }catch(Exception e){
              System.out.println(e);
          }
      }
      
      else if(ae.getSource()==notepad){
          try{
              Runtime.getRuntime().exec("notepad.exe");
          }catch(Exception e){
              System.out.println(e);
          }
      }
       
      else if(ae.getSource()==about){
         
      new  About().setVisible(true);
      } 
      
      else if(ae.getSource()==viewpackage){
          new ViewPackage(username);
      }
      
      else if(ae.getSource()==viewbookedhotel){
          new ViewBookedHotel(username);
      }
      
      else if(ae.getSource()==viewhotel){
          new CheckHotels();
      }
      
      else if(ae.getSource()==bookpackage){
          new BookPackage(username);
      }
      
       else if(ae.getSource()==bookhotel){
          new BookHotel(username);
      }
      
       else if(ae.getSource()==payment){
          new Payment();
      }
      
      
      
    }
    
    public static void main(String args[]){
        new Dashboard("Akshay");
    }
    
}
