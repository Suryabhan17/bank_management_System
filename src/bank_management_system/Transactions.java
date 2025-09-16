package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

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
    text.setForeground(Color.white);
    image.add(text);

    deposit =new JButton("Deposit");
    deposit.setBounds(160,317,140,30);
    deposit.addActionListener(this);
    image.add(deposit);

    withdrow =new JButton("Cash Withdrow");
    withdrow.setBounds(360,317,140,30);
    withdrow.addActionListener(this);
    image.add(withdrow);


    setSize(900,700);
    setLocation(350,10);
     //setUndecorated(true);
    setVisible(true);
   
  }
  public void actionPerformed(ActionEvent ae){

  }

public static void main(String[] args) {

  new Transactions();
}
  
}
