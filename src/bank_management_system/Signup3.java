package bank_management_system;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;


public class Signup3 extends JFrame  {

  JRadioButton r1,r2,r3,r4;
  JCheckBox c1,c2,c3,c4,c5,c6;
  JButton submit, cancel;
  String formno;

Signup3( ){
  this.formno=formno;
  setLayout(null);
  setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
  


  JLabel l1=new JLabel("Page 3: Account Detail");
  l1.setFont(new Font("Raleway", Font.BOLD,22));
  l1.setBounds(280,40,400,40);
  add(l1);

  JLabel type=new JLabel("Account Type :");
  type.setFont(new Font("Raleway",Font.BOLD,20));
  type.setBounds(100,140,200,30);
  add(type);

  r1=new JRadioButton("Saving Account");
  r1.setFont(new Font("Raleway",Font.BOLD,16));
  r1.setBackground(Color.WHITE);
  r1.setBounds(100,180,200,20);
  add(r1);

  r2=new JRadioButton("Saving Account");
  r2.setFont(new Font("Raleway",Font.BOLD,16));
  r2.setBackground(Color.WHITE);
  r2.setBounds(350,180,300,20);
  add(r2);

  r3=new JRadioButton("Saving Account");
  r3.setFont(new Font("Raleway",Font.BOLD,16));
  r3.setBackground(Color.WHITE);
  r3.setBounds(100,220,200,20);
  add(r3);




  JLabel card=new JLabel("Card Number:");
  card.setFont(new Font("Raleway",Font.BOLD,20));
  card.setBounds(100,300,200,30);
  add(card);


  JLabel number=new JLabel("xxxx-xxxx-xxxx-5894 :");
  number.setFont(new Font("Raleway",Font.BOLD,20));
  number.setBounds(330,300,300,30);
  add(number);

  JLabel carddetail =new JLabel("Your 16 Digit Card Number:");
  carddetail.setFont(new Font("Raleway",Font.BOLD,12));
  carddetail.setBounds(100,
  330,300,20);
  add(carddetail);



  JLabel pin =new JLabel("PIN :");
  pin.setFont(new Font("Raleway",Font.BOLD,20));
  pin.setBounds(100,370,200,300);
  add(pin);

  JLabel pindetail2=new JLabel("4 Digit Password");
  pindetail2.setFont(new Font("Raleway",Font.PLAIN,12));
  pindetail2.setBounds(100,400,200,20);
  add(pindetail2);

  JLabel services=new JLabel("Services Required");
  services.setFont(new Font("Raleway",Font.BOLD,20));
  services.setBounds(100,450,200,30);
  add(services);




  setSize(850,820);
setLocation(350,0);
  setVisible(true);

}


  public static void main(String args[]){
    new Signup3();
  }
}
