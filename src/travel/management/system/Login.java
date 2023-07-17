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
import java.sql.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, fpass;
    JTextField tfpassword, tfusername;

    Login() {
        setLayout(null);
        setSize(900, 400);
        setLocation(350, 200);
        JPanel p1 = new JPanel();

        getContentPane().setBackground(Color.WHITE);
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        add(p1);
        p1.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN-SERIF", Font.PLAIN, 20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("SAN-SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

         tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.white);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        fpass = new JButton("Forgot Password");
        fpass.setBounds(130, 250, 130, 30);
        fpass.setBackground(new Color(133, 193, 233));
        fpass.setForeground(Color.white);
        fpass.setBorder(new LineBorder(new Color(133, 193, 233)));
        fpass.addActionListener(this);
        p2.add(fpass);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300, 250, 150, 20);
        text.setForeground(Color.red);
        p2.add(text);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                Conn c = new Conn();
                String username = tfusername.getText();
                String password = tfpassword.getText();

                String query = "Select * from account where username= '" + username + "' AND password = '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        }
        if (ae.getSource() == fpass) {
            setVisible(false);
            new ForgetPassword();

        }
    }

    public static void main(String args[]) {

        Login l = new Login();

    }

}
