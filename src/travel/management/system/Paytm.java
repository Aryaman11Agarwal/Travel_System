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
import java.awt.event.*;
public class Paytm extends JFrame implements ActionListener{
    JButton back;
    Paytm(){
        setBounds(500,200,800,600);
        JEditorPane pane =new JEditorPane();
        pane.setEditable(false);
        
        
        
        try{
            pane.setPage("http://paytm.com//rent-payment");
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load ,error 404</html>");
            
        }
        
        JScrollPane sp=new JScrollPane();
        getContentPane().add(sp);
        
        back=new JButton("Back");
        back.setBounds(610,20,80,40);
        back.addActionListener(this);
        pane.add(back);
        add(pane);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        dispose();
    }
    
    public static void main(String args[]){
        new Paytm();
    }
}
