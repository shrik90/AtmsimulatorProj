package com.project.bankManagmentSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
	String pinnumber;
	JButton back;

	BalanceEnquiry(String pinnumber) {
		this.pinnumber = pinnumber;

		setLayout(null);
		// image atm
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);

		Conn con = new Conn();
		int balance = 0;
		try {
			ResultSet rs = con.stmt.executeQuery("SELECT * FROM bank WHERE pin='" + pinnumber + "'");
			while (rs.next()) {
				if (rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		JLabel text = new JLabel("Your Current Acount balance is Rs " + balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 300, 400, 30);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);

		setSize(900, 900);
		setLocation(300, 0);
		// setUndecorated(true);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);

	}

	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

}
