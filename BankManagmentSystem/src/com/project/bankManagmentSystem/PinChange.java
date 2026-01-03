package com.project.bankManagmentSystem;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
	JPasswordField pinTextField, repin;
	JButton change, back;

	String pinnumber;

	PinChange(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		// image
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(250, 280, 500, 35);
		image.add(text);

		JLabel pintext = new JLabel("New PIN : ");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setBounds(165, 320, 180, 25);
		image.add(pintext);

		// textfield
		pinTextField = new JPasswordField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pinTextField.setBounds(330, 320, 180, 25);
		add(pinTextField);

		JLabel repintext = new JLabel("Re-Enter New PIN : ");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		repintext.setBounds(165, 360, 180, 25);
		image.add(repintext);

		// textfield
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 14));
		repin.setBounds(330, 360, 180, 25);
		add(repin);

		// buttons
		change = new JButton("CHANGE");
		change.setBounds(355, 485, 150, 30);
		change.addActionListener(this);
		image.add(change);

		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(300, 0);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == change) {
			try {
				String npin = pinTextField.getText();
				String rpin = repin.getText();
				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}
				if (npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
					return;
				}
				if (rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter  new PIN");
					return;
				}
				Conn con = new Conn();
				//
				String query1 = "update bank set pin= '" + rpin + "' where pin='" + pinnumber + "'  ";
				String query2 = "update login set pin= '" + rpin + "' where pin='" + pinnumber + "'  ";
				String query3 = "update signupthree set pin= '" + rpin + "' where pin='" + pinnumber + "'  ";

				con.stmt.executeUpdate(query1);
				con.stmt.executeUpdate(query2);
				con.stmt.executeUpdate(query3);

				JOptionPane.showMessageDialog(null, "PIN Changed Sucessfully");

				setVisible(false);
				new Transactions(rpin).setVisible(true);

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}

	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
		;
	}

}
