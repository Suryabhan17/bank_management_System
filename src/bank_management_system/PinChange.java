package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {


  JPasswordField pinTextField,repinTextField;
  JButton change,back;

  String pinnumber;


  PinChange(String pinnumber){

  this.pinnumber=pinnumber;
  setLayout(null);
  setTitle("PIN CHANGE");

  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System",Font.BOLD,22));
        text.setBounds(240,220,400,30);
        text.setForeground(Color.white);
        image.add(text);

        JLabel pinText=new JLabel("New PIN :");
        pinText.setFont(new Font("Raleway",Font.BOLD,18));
        pinText.setBounds(170,255,200,25);
        pinText.setForeground(Color.RED);
        image.add(pinText);

        pinTextField=new JPasswordField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,18));
        pinTextField.setBounds(300,255,200,25);
        image.add(pinTextField);


        JLabel repinText =new JLabel("Re-Enter New PIN :");
        repinText.setFont(new Font("System",Font.BOLD,18));
        repinText.setBounds(170,300,200,25);
        repinText.setForeground(Color.RED);
        image.add(repinText);

        repinTextField=new JPasswordField();
        repinTextField.setFont(new Font("Raleway",Font.BOLD,18));
        repinTextField.setBounds(350,300,150,25);
        image.add(repinTextField);

        change=new JButton("Change");
        change.setBounds(200,370,120,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(360,370,120,30);
        back.addActionListener(this);
        image.add(back);

setSize(900,700);
setLocation(350,10);
setUndecorated(true);
setVisible(true);

  }

public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pinTextField.getText();
                String rpin = repinTextField.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter New PIN");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter New PIN");
                    return;
                }

                Conn conn = new Conn();
                // Update in all relevant tables (assuming pin is stored in multiple tables)
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                String query3 = "update signup3 set pin = '" + rpin + "' where pin = '" + pinnumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

               
                setVisible(false);
                new Transactions(rpin).setVisible(true);

                 JOptionPane.showMessageDialog(null, "PIN changed successfully");


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

  public static void main(String[] args) {
    new PinChange("").setVisible(true);
  }

}
