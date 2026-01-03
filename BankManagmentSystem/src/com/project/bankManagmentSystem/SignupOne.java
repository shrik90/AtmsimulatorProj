package com.project.bankManagmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
	long random;
	JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField,
			pinTextField;
	JButton next;
	JRadioButton male, female, other, married, unMarried;
	JDateChooser chooser;

	SignupOne() {
		setTitle("Application Form_Page 1");

		setLayout(null);

		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);

		JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);

		// page
		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);

		// name
		JLabel name = new JLabel("Name :");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);

		// field
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);

		// fname
		JLabel fname = new JLabel("Father's Name :");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);

		// f field
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);

		// dob
		JLabel dob = new JLabel("Date Of Birth :");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);

		// field
		chooser = new JDateChooser();
		chooser.setBounds(300, 240, 400, 30); // set position and size
		chooser.setFont(new Font("Raleway", Font.BOLD, 14));
		chooser.setForeground(Color.RED);
		add(chooser); // add to frame

		// gender
		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);

		female = new JRadioButton("Female");
		female.setBounds(450, 290, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);

		// Email
		JLabel email = new JLabel("Email Address :");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);

		// E field
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);

		// Marital Status
		JLabel marital = new JLabel("Marital Status :");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);

		// Buttons
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);

		unMarried = new JRadioButton("UnMarried");
		unMarried.setBounds(450, 390, 100, 30);
		unMarried.setBackground(Color.WHITE);
		add(unMarried);

		other = new JRadioButton("Other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unMarried);
		maritalGroup.add(other);

		// address
		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);

		// E field
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);

		// city
		JLabel city = new JLabel("City :");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);

		// city field
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);

		// state
		JLabel state = new JLabel("State :");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);

		// State field
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);

		// pinCode
		JLabel pinCode = new JLabel("Pin Code :");
		pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
		pinCode.setBounds(100, 590, 200, 30);
		add(pinCode);

		// pin field
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pinTextField.setBounds(300, 590, 400, 30);
		add(pinTextField);

		// next button
		next = new JButton("Next");
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		// page layout
		getContentPane().setBackground(Color.white);
		setSize(850,800);
		setVisible(true);
		setLocation(350, 10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String formno = "" + random; // long
		String name = nameTextField.getText();// to get text value
		String fname = fnameTextField.getText();
		String dob = ((JTextField) chooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "male";

		} else if (female.isSelected()) {
			gender = "female";
		}
		String email = emailTextField.getText();
		String marital = null;
		if (married.isSelected()) {
			marital = "married";
		} else if (unMarried.isSelected()) {
			marital = "unMarried";
		} else if (other.isSelected()) {
			marital = "other";
		}
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pinTextField.getText();

		try {
			// validation
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			} else {
				Conn c = new Conn();
				String query = "insert into signup values(' " + formno + " ',' " + name + " ',' " + fname + " ',' "
						+ dob + " ',' " + gender + " ',' " + email + " ',' " + marital + " ',' " + address + " ',' "
						+ city + " ',' " + pin + " ',' " + state + " ')";
				c.stmt.executeUpdate(query);
				setVisible(false);
				new SignupTwo(formno).setVisible(true);

			}
			if (dob.equals("")) {
				JOptionPane.showMessageDialog(null, "DOB is Required");
			}

		} catch (Exception e1) {

			System.out.println(e1);
		}

	}

	public static void main(String[] args) {
		new SignupOne();
	}

}
