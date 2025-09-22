package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

  JButton deposit, withdrow,fastcash,ministatement,pinchange,balanceenquiry,exit;
  String pinnumber;

  Transactions(String pinnumber){

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
    text.setBounds(180,220,400,30);
    text.setForeground(Color.white);
    image.add(text);

    deposit =new JButton("Deposit");
    deposit.setBounds(160,317,140,25);
    deposit.addActionListener(this);
    image.add(deposit);

    withdrow =new JButton("Cash Withdrow");
    withdrow.setBounds(370,317,140,25);
    withdrow.addActionListener(this);
    image.add(withdrow);

    fastcash =new JButton("Fast Cash");
    fastcash.setBounds(160,350,140,25);
    fastcash.addActionListener(this);
    image.add(fastcash);

    ministatement = new JButton("Mini Statement");
    ministatement.setBounds(370,347,140,25);
    ministatement.addActionListener(this);
    image.add(ministatement);

    pinchange =new JButton("PIN Change");
    pinchange.setBounds(160,380,140,25);
    pinchange.addActionListener(this);
    image.add(pinchange);

    balanceenquiry =new JButton("Balance Enquiry");
    balanceenquiry.setBounds(370,375,140,25);
    balanceenquiry.addActionListener(this);
    image.add(balanceenquiry);

    exit =new JButton("Exit");
    exit.setBounds(370,405,140,25);
    exit.addActionListener(this);
    image.add(exit);

    setSize(900,700);
    setLocation(350,10);
     setUndecorated(true);
    setVisible(true);
   
  }
  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == exit){
      System.exit(0);
  

    }  else if(ae.getSource() == deposit){
      setVisible(false);
      new Deposit(pinnumber).setVisible(true);


    } else if(ae.getSource()==withdrow){
      setVisible(false);
      new Withdraw(pinnumber).setVisible(true);

    } 
    else if(ae.getSource()== fastcash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
    }  /*else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }*/

  }

public static void main(String[] args) {

  new Transactions("").setVisible(true);
}
  
}
