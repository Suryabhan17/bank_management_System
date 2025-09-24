package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
JButton back;
String pinnumber;
  BalanceEnquiry(String pinnumber){
    this.pinnumber=pinnumber;
    setLayout(null);
    setTitle("BALANCE ENQUIRY");

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel text = new JLabel("Your Current Account Balance is:");
        text.setFont(new Font("System", Font.BOLD, 22));
        text.setForeground(Color.WHITE);
        text.setBounds(170, 220, 500, 30);
        image.add(text);
int balance = 0;
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel balanceLabel = new JLabel("Rs " + balance);
        balanceLabel.setFont(new Font("System", Font.BOLD, 30));
        balanceLabel.setForeground(Color.YELLOW);
        balanceLabel.setBounds(300, 270, 400, 40);
        image.add(balanceLabel);

        back = new JButton("Back");
        back.setBounds(370, 400, 150, 30);
        back.addActionListener(this);
        image.add(back);


   setSize(900,700);
   setLocation(350,10);
   setUndecorated(true);
   setVisible(true);

  }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
  public static void main(String[] args) {
    new BalanceEnquiry("").setVisible(true);
  }

}
