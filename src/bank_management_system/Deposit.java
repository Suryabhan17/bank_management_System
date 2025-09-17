package bank_management_system;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Deposit extends JFrame {

  JTextField amountTextField;
  JButton deposiBtn, backBtn;
  String pinnumber;
  
  Deposit(){
    setLayout(null);
    JLabel text=new JLabel("Enter amount you want to deposit");
    text.setFont(new Font("System",Font.BOLD,16));
    text.setBounds(170,200,400,20);
    add(text);
    amountTextField=new JTextField();
    amountTextField.setFont(new Font("Raleway",Font.BOLD,22));
    amountTextField.setBounds(170,250,320,30);
    add(amountTextField);









    
    getContentPane().setBackground(Color.white);
    setSize(700,600);
    setLocation(350,100);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Deposit();
  }
  
}
