package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox religion, category, income, education, occupation;
    JTextField panTextField, aadharTextField;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    String formno;

    // constructor accepts formno from Signup1
    Signup2(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additional = new JLabel("Page 2: Additional Details ");
        additional.setFont(new Font("Raleway", Font.BOLD, 22));
        additional.setBounds(290, 80, 400, 30);
        add(additional);

        JLabel l1 = new JLabel("Religion :");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(100, 140, 200, 30);
        add(l1);

        String reli[] = {"Hindu", "Sikh", "Christian", "Muslim", "Other"};
        religion = new JComboBox(reli);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel l2 = new JLabel("Category:");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(100, 190, 200, 30);
        add(l2);

        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel l3 = new JLabel("Income:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(100, 240, 200, 30);
        add(l3);

        String incomecat[] = {"Null", "<1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecat);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel l4 = new JLabel("Education:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(100, 315, 200, 30);
        add(l4);

        String edu[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Other"};
        education = new JComboBox(edu);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel l5 = new JLabel("Occupation:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l5.setBounds(100, 390, 200, 30);
        add(l5);

        String occ[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox(occ);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel l6 = new JLabel("PAN Number:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(100, 440, 200, 30);
        add(l6);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel l7 = new JLabel("Aadhar Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setBounds(100, 490, 200, 30);
        add(l7);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        JLabel l8 = new JLabel("Senior Citizen:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setBounds(100, 540, 200, 30);
        add(l8);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(400, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel l9 = new JLabel("Existing Account:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setBounds(100, 590, 200, 30);
        add(l9);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(400, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existGroup = new ButtonGroup();
        existGroup.add(eyes);
        existGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(620, 660, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        String seniorcitizen = null;
        if (syes.isSelected()) seniorcitizen = "Yes";
        else if (sno.isSelected()) seniorcitizen = "No";

        String existingacc = null;
        if (eyes.isSelected()) existingacc = "Yes";
        else if (eno.isSelected()) existingacc = "No";

        try {
            Conn c = new Conn();
            String query = "insert into signup2 values('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingacc + "')";
            c.s.executeUpdate(query);

            // go to page 3
           // setVisible(false);
          //  new Signup2(formno).//setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signup2("").setVisible(true);
    }
}
