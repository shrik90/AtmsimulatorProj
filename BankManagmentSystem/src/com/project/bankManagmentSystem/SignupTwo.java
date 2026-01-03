package com.project.bankManagmentSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
	JTextField panTextField, aadharTextField;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox religion1, cat, incomecat, education, occup;
	String formno;

	SignupTwo(String formno) {
		this.formno = formno;

		setTitle(" New Account Application Form_Page 2");
		setLayout(null);

		// page 2
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);

		// religion
		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);

		String valReligion[] = { "Hindu", "Sikh", "Muslim", "Christain", "Others" };
		religion1 = new JComboBox(valReligion);
		religion1.setBounds(300, 140, 400, 30);
		religion1.setBackground(Color.WHITE);
		add(religion1);

		// category

		JLabel category = new JLabel("Category :");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);

		String valCategory[] = { "General", "SC", "ST", "Others" };
		cat = new JComboBox(valCategory);
		cat.setBackground(Color.WHITE);
		cat.setBounds(300, 190, 400, 30);
		add(cat);

		// income
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);
		// combo box
		String incomeCategory[] = { "null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000" };
		incomecat = new JComboBox(incomeCategory);
		incomecat.setBackground(Color.WHITE);
		incomecat.setBounds(300, 240, 400, 30);
		add(incomecat);

		// Education
		JLabel educational = new JLabel("Educational:");
		educational.setFont(new Font("Raleway", Font.BOLD, 20));
		educational.setBounds(100, 290, 200, 30);
		add(educational);

		// Qualification
		JLabel qualification = new JLabel("Qualification");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);

		// combo box
		String educationVal[] = { "Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Othres" };
		education = new JComboBox(educationVal);
		education.setBackground(Color.WHITE);
		education.setBounds(300, 315, 400, 30);
		add(education);

		// Occupation
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);

		// combo box
		String occupationVal[] = { "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others" };
		occup = new JComboBox(occupationVal);
		occup.setBackground(Color.WHITE);
		occup.setBounds(300, 390, 400, 30);
		add(occup);

		// PAN No :
		JLabel pan = new JLabel("PAN Number :");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100, 440, 200, 30);
		add(pan);

		// panTextField field
		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panTextField.setBounds(300, 440, 400, 30);
		add(panTextField);

		// Aadhar Number
		JLabel aadharNo = new JLabel("Aadhar Numbe :");
		aadharNo.setFont(new Font("Raleway", Font.BOLD, 20));
		aadharNo.setBounds(100, 490, 200, 30);
		add(aadharNo);

		// aadharTextField field
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharTextField.setBounds(300, 490, 400, 30);
		add(aadharTextField);

		// Senior Citizen
		JLabel state = new JLabel("Senior Citizen :");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);

		// Buttons
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);

		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(syes);
		maritalGroup.add(sno);

		// Exsiting Account:
		JLabel pinCode = new JLabel("Exsiting Account:");
		pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
		pinCode.setBounds(100, 590, 200, 30);
		add(pinCode);

		// Buttons
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);

		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);

		ButtonGroup emaritalGroup = new ButtonGroup();
		emaritalGroup.add(eyes);
		emaritalGroup.add(eno);

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
		setSize(850, 800);
		setVisible(true);
		setLocation(350, 10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sreligion = (String) religion1.getSelectedItem();// to get text value
		String scategory = (String) cat.getSelectedItem();
		String sincome = (String) incomecat.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occup.getSelectedItem();

		String seniorCitizen = null;
		if (syes.isSelected()) {
			seniorCitizen = "Yes";

		} else if (sno.isSelected()) {
			seniorCitizen = "No";
		}
		String existingAccount = null;
		if (eyes.isSelected()) {
			existingAccount = "Yes";
		} else if (eno.isSelected()) {
			existingAccount = "No";
		}

		String pan = panTextField.getText();
		String aadhar = aadharTextField.getText();

		try {

			Conn c = new Conn();
			String query = "insert into signup2 values(' " + formno + " ',' " + sreligion + " ',' " + scategory
					+ " ', ' " + sincome + " ' ,' " + seducation + " ',' " + soccupation + " ',' " + pan + " ',' "
					+ aadhar + " ',' " + existingAccount + " ', ' " + seniorCitizen + " ')";
			c.stmt.executeUpdate(query);

			// signup 3 object
			setVisible(false);
			new SignupThree(formno).setVisible(true);

		} catch (Exception e3) {

			System.out.println(e3);

		}

	}

	public static void main(String[] args) {
		new SignupTwo("");
	}

}
