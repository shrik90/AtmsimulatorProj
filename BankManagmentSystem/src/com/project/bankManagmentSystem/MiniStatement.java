package com.project.bankManagmentSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener {
	String pinnumber;
	JButton back;

	public MiniStatement(String pinnumber) {
		this.pinnumber = pinnumber;

		setTitle("Mini Statement");
		setLayout(null);

		JLabel mini = new JLabel();
		mini.setBounds(20, 140, 400, 200);
		add(mini);

		JLabel bank = new JLabel("Apna Bank");
		bank.setFont(new Font("Raleway", Font.BOLD, 15));
		bank.setBounds(150, 20, 100, 20);
		add(bank);

		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);

		JLabel balance = new JLabel();
		balance.setBounds(20, 400, 300, 20);
		add(balance);

		try {
			Conn con = new Conn();
			ResultSet rs = con.stmt.executeQuery("SELECT * FROM login WHERE pin='" + pinnumber + "'");
			while (rs.next()) {
				card.setText("Card Number : " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("cardnumber").substring(12));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Conn con = new Conn();
			int bal = 0;
			ResultSet rs = con.stmt.executeQuery("SELECT * FROM bank WHERE pin='" + pinnumber + "'");

			String text = "<html>"; // start HTML once
			while (rs.next()) {
				text += rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("amount") + "<br><br>";
				if (rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				} else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			text += "</html>";
			balance.setText("Your current account balance is Rs " + bal);
			mini.setText(text); // set once after loop
		} catch (Exception e) {
			System.out.println(e);
		}

		setSize(400, 600);
		setLocation(20, 20);
		setUndecorated(true);
		getContentPane().setBackground(Color.white);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}

	public static void main(String[] args) {
		new MiniStatement("");
	}

}
