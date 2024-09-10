//package com.java.adv;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Hotel_Management implements ActionListener {
    JFrame f;
    JTextField t1, t2, t3, t4, t5, cgstField, sgstField;
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton gb, b1;
    JTextArea ar;

    Hotel_Management() {
        f = new JFrame("Hotel Management Billing System");
        f.getContentPane().setBackground(Color.decode("#ADD8E6"));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l = new JLabel(" Hotel Management Billing System");
        l.setForeground(Color.white);
        l.setBackground(Color.decode("#006400"));
        l.setOpaque(true);

        Font myFont = new Font("Arial", Font.PLAIN, 18);
        l.setFont(myFont);
        l.setBounds(130, 40, 280, 30);
        f.add(l);

        Font myFont1 = new Font("Arial", Font.BOLD, 12);
        l1 = new JLabel("Order No: ");
        l1.setBounds(60, 80, 80, 20);
        l1.setFont(myFont1);
        f.add(l1);

        t1 = new JTextField();
        t1.setBounds(120, 80, 100, 20);
        f.add(t1);

        l2 = new JLabel("Customer Name: ");
        l2.setBounds(230, 80, 120, 20);
        l2.setFont(myFont1);
        f.add(l2);

        t2 = new JTextField();
        t2.setBounds(330, 80, 120, 20);
        f.add(t2);

        l3 = new JLabel("Menu: ");
        l3.setBounds(60, 110, 60, 20);
        l3.setFont(myFont1);
        f.add(l3);

        c1 = new JCheckBox(" Tea (₹ 10)");
        c1.setBounds(120, 130, 150, 20);
        c1.setFont(myFont1);
        f.add(c1);

        c2 = new JCheckBox(" Coffee (₹ 20)");
        c2.setBounds(120, 150, 150, 20);
        c2.setFont(myFont1);
        f.add(c2);

        c3 = new JCheckBox(" Masala Dosa (₹ 45)");
        c3.setBounds(120, 170, 150, 20);
        c3.setFont(myFont1);
        f.add(c3);

        c4 = new JCheckBox(" Pav Bhaji (₹ 80)");
        c4.setBounds(330, 130, 120, 20);
        c4.setFont(myFont1);
        f.add(c4);

        c5 = new JCheckBox(" Misal Pav (₹ 90)");
        c5.setBounds(330, 150, 120, 20);
        c5.setFont(myFont1);
        f.add(c5);

        c6 = new JCheckBox(" Vada Pav (₹ 15)");
        c6.setBounds(330, 170, 120, 20);
        c6.setFont(myFont1);
        f.add(c6);

        l4 = new JLabel(" Quantity: ");
        l4.setBounds(60, 200, 80, 20);
        l4.setFont(myFont1);
        f.add(l4);

        t3 = new JTextField();
        t3.setBounds(120, 200, 100, 20);
        f.add(t3);

        l5 = new JLabel(" Amount: ");
        l5.setBounds(230, 200, 60, 20);
        l5.setFont(myFont1);
        f.add(l5);

        t4 = new JTextField();
        t4.setBounds(330, 200, 100, 20);
        f.add(t4);

        l6 = new JLabel(" CGST (4.5%): ");
        l6.setBounds(60, 235, 100, 20);
        l6.setFont(myFont1);
        f.add(l6);

        cgstField = new JTextField();
        cgstField.setBounds(150, 235, 80, 20);
        f.add(cgstField);

        l7 = new JLabel(" SGST (4.5%): ");
        l7.setBounds(230, 235, 100, 20);
        l7.setFont(myFont1);
        f.add(l7);

        sgstField = new JTextField();
        sgstField.setBounds(330, 235, 80, 20);
        f.add(sgstField);

        l8 = new JLabel(" Final Amount (Incl. of Taxes): ");
        l8.setBounds(60, 270, 200, 20);
        l8.setFont(myFont1);
        f.add(l8);

        t5 = new JTextField();
        t5.setBounds(260, 270, 100, 20);
        
        f.add(t5);

        gb = new JButton(" Generate Bill ");
        gb.setBounds(150, 310, 120, 20);
        gb.setBackground(Color.green);
        gb.setFont(myFont1);
        gb.addActionListener(this);
        f.add(gb);

        b1 = new JButton(" Cancel Order ");
        b1.setBounds(280, 310, 120, 20);
        b1.setBackground(Color.orange);
        b1.setFont(myFont1);
        b1.addActionListener(e -> System.exit(0));
        f.add(b1);

        ar = new JTextArea();
        ar.setBounds(30, 350, 450, 250);
        ar.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        ar.setEditable(false);
        f.add(ar);
        Border textAreaBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        ar.setBorder(textAreaBorder);

        f.setSize(550, 650); // Increased the height to adjust for the new layout
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Check if required fields are empty
            if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()) {
                throw new Exception("Order No, Customer Name, Menu Items and Quantity\nare compulsory to enter!");
            }

            int orderno = Integer.parseInt(t1.getText());
            String custname = t2.getText();

            int price = 0;
            StringBuilder p1 = new StringBuilder();
            StringBuilder rate = new StringBuilder();

            // Check if any menu item is selected
            if (!c1.isSelected() && !c2.isSelected() && !c3.isSelected() && !c4.isSelected() && !c5.isSelected()
                    && !c6.isSelected()) {
                throw new Exception("At least one menu item must be selected!");
            }

            // Menu item selection and price calculation
            if (c1.isSelected()) {
                price = 10;
                p1.append("Tea");
                rate.append("₹ 10");
            }
            if (c2.isSelected()) {
                price += 20;
                p1.append(" Coffee");
                rate.append(" ₹ 20");
            }
            if (c3.isSelected()) {
                price += 45;
                p1.append(" Masala Dosa");
                rate.append(" ₹ 45");
            }
            if (c4.isSelected()) {
                price += 80;
                p1.append(" Pav Bhaji");
                rate.append(" ₹ 80");
            }
            if (c5.isSelected()) {
                price += 90;
                p1.append(" Misal Pav");
                rate.append(" ₹ 90");
            }
            if (c6.isSelected()) {
                price += 15;
                p1.append(" Vada Pav");
                rate.append(" ₹ 15");
            }

            int quantity = Integer.parseInt(t3.getText());
            int amount = price * quantity;


            double cgst = Math.round((amount * 0.045) * 100.0) / 100.0;
            double sgst = Math.round((amount * 0.045) * 100.0) / 100.0;
            double totalWithTaxes = Math.round((amount + cgst + sgst) * 100.0) / 100.0;

            t4.setText(String.valueOf(amount));
            cgstField.setText(String.valueOf(cgst));
            sgstField.setText(String.valueOf(sgst));
            t5.setText(String.valueOf(totalWithTaxes));

            ar.setText(" Hello " + custname + ", Your Order Number is " + orderno
                    + "\n------------------------------------------------------------------------------\n"
                    + " Product Name: " + p1 + "\n Quantity: " + quantity + "\n Rate: " + rate
                    + "\n------------------------------------------------------------------------------\n"
                    + "        Total: ₹" + amount + " ₹."
                    + "\n        CGST (4.5%): ₹" + cgst + " ."
                    + "\n        SGST (4.5%): ₹" + sgst + " ."
                    + "\n        Final Amount (Incl. of Taxes): ₹ " + totalWithTaxes + " ."
                    + "\n-------------------------------------------------------------------------------"
                    + "\n------------>> Thank You !! Visit Again...<<----------------\n");
        } catch (Exception ex) {
            ar.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Hotel_Management();
    }
}