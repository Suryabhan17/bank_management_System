package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    String pinnumber;
    JButton back;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(120, 20, 250, 25);
        bank.setFont(new Font("System", Font.BOLD, 20));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 60, 300, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, 120, 400, 200);
        add(mini);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(20, 340, 400, 30);
        add(balanceLabel);

        back = new JButton("Back");
        back.setBounds(140, 400, 100, 30);
        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();

            // ✅ Masked card number
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                String cardnumber = rs.getString("cardnumber");
                card.setText("Card Number: " + cardnumber.substring(0, 4) + "XXXXXXXX" + cardnumber.substring(12));
            }

            // ✅ Show last transactions
            ResultSet rs2 = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "' ORDER BY date DESC LIMIT 10");
            StringBuilder statement = new StringBuilder("<html>");
            int balance = 0;

            while (rs2.next()) {
                statement.append(rs2.getString("date")).append("&nbsp;&nbsp;&nbsp;")
                        .append(rs2.getString("type")).append("&nbsp;&nbsp;&nbsp;Rs ")
                        .append(rs2.getString("amount")).append("<br>");
                if (rs2.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs2.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs2.getString("amount"));
                }
            }
            statement.append("</html>");
            mini.setText(statement.toString());
            balanceLabel.setText("Current Balance: Rs " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 500);
        setLocation(450, 200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}



