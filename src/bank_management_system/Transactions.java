package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame {

  JButton deposit, withdrow,fastcash,ministatement,pinchange,balanceenquiry,exit;
  String pinnumber;

  Transactions(){

    this.pinnumber=pinnumber;
    setLayout(null);
    setTitle("TRANSACTIONS");


    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,900,700);
    add(image);





    
    JLabel text=new JLabel("Please Select Your Transaction");
    text.setFont(new Font("System",Font.BOLD,22));
    text.setBounds(180,215,400,30);
    image.add(text);


    setSize(900,700);
    setLocation(350,200);
    setVisible(true);
  }

public static void main(String[] args) {
  new Transactions();
}
  
}
