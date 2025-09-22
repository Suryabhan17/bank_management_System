package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener {

    JTextField amountTextField;
    JButton depositBtn, backBtn;
    String pinnumber;

    Withdraw(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,700,600);
    add(image);

        JLabel text = new JLabel("Enter amount you want to Withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(135, 200, 400, 20);
        text.setForeground(Color.white);
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTextField.setBounds(135, 250, 250, 30);
        image.add(amountTextField);

        depositBtn = new JButton("Withdraw");
        depositBtn.setBounds(135, 320, 100, 30);
        depositBtn.addActionListener(this);
        image.add(depositBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(285, 320, 100, 30);
        backBtn.addActionListener(this);
        image.add(backBtn);

        getContentPane().setBackground(Color.WHITE);

        setSize(700, 600);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositBtn) {
            String number = amountTextField.getText();
            Date date = new Date();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            } else {
                try {
                    Conn conn = new Conn(); // your database connection class
                    String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdraw', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == backBtn) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdraw("").setVisible(true);
    }
}



