package com.project.bankManagmentSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JButton login, clear, signup;
	JTextField cardTextField;
	JPasswordField pinTextField;

	Login() {
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);

		JLabel text = new JLabel("Welcome To ATM");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(200, 40, 400, 40);
		add(text);

		// cardno
		JLabel cardno = new JLabel("Card NO.");
		cardno.setFont(new Font("Raleway", Font.BOLD, 28));
		cardno.setBounds(120, 150, 150, 30);
		add(cardno);

		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);

		// pin
		JLabel pin = new JLabel("PIN");
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		pin.setBounds(120, 220, 250, 30);
		add(pin);

		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTextField);

		// Sign button
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);

		// Clear button
		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);

		// Sign Up button
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);

		getContentPane().setBackground(Color.WHITE);

		setSize(800, 500);
		setVisible(true);
		setLocation(350, 200);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} else if (ae.getSource() == login) {
			Conn con = new Conn();
			String cardnumber = cardTextField.getText().trim();
			String pinnumber = String.valueOf(pinTextField.getPassword()).trim();

			try {
				String query = "SELECT * FROM login WHERE cardnumber = ? AND pin = ?";
				PreparedStatement pstmt = con.conn.prepareStatement(query);
				pstmt.setString(1, cardnumber.trim()); // cardnumber is varchar
				pstmt.setString(2, pinnumber.trim()); // pin is varchar

				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
			} catch (Exception e) {
				System.out.println("Login error: " + e);
			}
		} else if (ae.getSource() == signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Login();
	}

}
