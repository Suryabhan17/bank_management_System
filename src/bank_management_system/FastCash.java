package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrow, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        setTitle("FAST CASH");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel text = new JLabel("Please Select Withdrawal Amount");
        text.setFont(new Font("System", Font.BOLD, 22));
        text.setBounds(180, 220, 400, 30);
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(160, 317, 140, 25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrow = new JButton("Rs 500");
        withdrow.setBounds(370, 317, 140, 25);
        withdrow.addActionListener(this);
        image.add(withdrow);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(160, 350, 140, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(370, 347, 140, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(160, 380, 140, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(370, 375, 140, 25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("BACK");
        exit.setBounds(370, 405, 140, 25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 700);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            return;
        }

        String amount = ((JButton) ae.getSource()).getText().replace("Rs", "").trim();
        Conn conn = new Conn();
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date = new Date();
            String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdraw','" + amount + "')";
            conn.s.executeUpdate(query); // ✅ Corrected

            JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
