package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame implements ActionListener {

	JTextField firstName, middleName, lastName, textEmail, textAdd, textCityName, textStateName, textPinCode, textMobNo;
	JDateChooser dateOfBirth;

	JRadioButton btn1, btn2, btn3, btnMarried, btnUnMarried, btnOthers;
	JButton next;

	/* Random Application Form Number generator logic. */
	Random random = new Random();
	long first4 = (random.nextLong() % 9000L) + 1000L;
	String first = "" + Math.abs(first4);

	public static void main(String[] args) {
		new SignUp();
	}

	SignUp() {
		super("Account Opening Form");
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank_log.png"));
		Image img2 = img1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel image = new JLabel(img3);
		image.setBounds(25, 10, 40, 40);
		add(image);

		JLabel label1 = new JLabel("Form No: " + first);
		label1.setBounds(80, 10, 600, 40);
		label1.setFont(new Font("Courier New", Font.BOLD, 14));
		add(label1);

		JLabel label2 = new JLabel("Page 1");
		label2.setFont(new Font("Courier New", Font.BOLD, 16));
		label2.setBounds(310, 500, 600, 30);
		add(label2);

		JLabel label3 = new JLabel("PERSONAL DETAILS*");
		label3.setFont(new Font("Courier New", Font.BOLD, 17));
		label3.setBounds(50, 52, 600, 30);
		add(label3);

		JLabel name = new JLabel("First Name");
		name.setFont(new Font("Courier New", Font.BOLD, 16));
		name.setBounds(50, 80, 100, 30);
		add(name);

		firstName = new JTextField();
		firstName.setFont(new Font("Courier New", Font.PLAIN, 16));
		firstName.setBounds(200, 85, 300, 25);
		add(firstName);

		JLabel fName = new JLabel("Middle Name");
		fName.setBounds(50, 115, 150, 30);
		fName.setFont(new Font("Courier New", Font.BOLD, 16));
		add(fName);

		middleName = new JTextField();
		middleName.setBounds(200, 120, 300, 25);
		middleName.setFont(new Font("Courier New", Font.PLAIN, 16));
		add(middleName);

		JLabel sName = new JLabel("Last Name");
		sName.setBounds(50, 150, 100, 30);
		sName.setFont(new Font("Courier New", Font.BOLD, 16));
		add(sName);

		lastName = new JTextField();
		lastName.setBounds(200, 155, 300, 25);
		lastName.setFont(new Font("Courier New", Font.PLAIN, 16));
		add(lastName);

		JLabel DOB = new JLabel("Date of Birth");
		DOB.setBounds(50, 185, 150, 30);
		DOB.setFont(new Font("Courier New", Font.BOLD, 16));
		add(DOB);

		dateOfBirth = new JDateChooser();
		dateOfBirth.setForeground(new Color(250, 251, 252));
		dateOfBirth.setBounds(200, 190, 300, 25);
		add(dateOfBirth);

		JLabel genderType = new JLabel("Gender");
		genderType.setBounds(50, 220, 100, 25);
		genderType.setFont(new Font("Courier New", Font.BOLD, 16));
		add(genderType);

		btn1 = new JRadioButton("Male");
		btn1.setBackground(new Color(250, 251, 252));
		btn1.setFont(new Font("Courier New", Font.PLAIN, 16));
		btn1.setBounds(200, 225, 80, 25);
		add(btn1);

		btn2 = new JRadioButton("Female");
		btn2.setBackground(new Color(250, 251, 252));
		btn2.setFont(new Font("Courier New", Font.PLAIN, 16));
		btn2.setBounds(280, 225, 90, 25);
		add(btn2);

		btn3 = new JRadioButton("Others");
		btn3.setBackground(new Color(250, 251, 252));
		btn3.setFont(new Font("Courier New", Font.PLAIN, 16));
		btn3.setBounds(380, 225, 100, 25);
		add(btn3);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(btn1);
		btnGroup.add(btn2);
		btnGroup.add(btn3);

		JLabel emailAdd = new JLabel("Email Address");
		emailAdd.setBounds(50, 255, 150, 30);
		emailAdd.setFont(new Font("Courier New", Font.BOLD, 16));
		add(emailAdd);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Courier New", Font.PLAIN, 15));
		textEmail.setBounds(200, 260, 400, 25);
		add(textEmail);

		JLabel marriedStatus = new JLabel("Marital Status");
		marriedStatus.setBounds(50, 290, 150, 30);
		marriedStatus.setFont(new Font("Courier New", Font.BOLD, 16));
		add(marriedStatus);

		btnMarried = new JRadioButton("Married");
		btnMarried.setBackground(new Color(250, 251, 252));
		btnMarried.setFont(new Font("Courier New", Font.PLAIN, 16));
		btnMarried.setBounds(200, 295, 100, 25);
		add(btnMarried);

		btnUnMarried = new JRadioButton("Unmarried");
		btnUnMarried.setBackground(new Color(250, 251, 252));
		btnUnMarried.setFont(new Font("Courier New", Font.PLAIN, 16));
		btnUnMarried.setBounds(300, 295, 120, 25);
		add(btnUnMarried);

		btnOthers = new JRadioButton("Others");
		btnOthers.setFont(new Font("Courier New", Font.PLAIN, 16));
		btnOthers.setBounds(420, 295, 100, 25);
		btnOthers.setBackground(new Color(250, 251, 252));
		add(btnOthers);

		ButtonGroup btnGroup1 = new ButtonGroup();
		btnGroup1.add(btnMarried);
		btnGroup1.add(btnUnMarried);
		btnGroup1.add(btnOthers);

		JLabel address = new JLabel("Address");
		address.setBounds(50, 325, 100, 30);
		address.setFont(new Font("Courier New", Font.BOLD, 16));
		add(address);

		textAdd = new JTextField();
		textAdd.setBounds(200, 330, 400, 40);
		textAdd.setFont(new Font("Courier New", Font.PLAIN, 15));
		add(textAdd);

		JLabel cityName = new JLabel("State");
		cityName.setBounds(50, 382, 100, 30);
		cityName.setFont(new Font("Courier New", Font.BOLD, 16));
		add(cityName);

		textCityName = new JTextField();
		textCityName.setBounds(200, 382, 150, 25);
		textCityName.setFont(new Font("Courier New", Font.PLAIN, 15));
		add(textCityName);

		JLabel stateName = new JLabel("City");
		stateName.setBounds(380, 382, 100, 30);
		stateName.setFont(new Font("Courier New", Font.BOLD, 16));
		add(stateName);

		textStateName = new JTextField();
		textStateName.setBounds(460, 382, 150, 25);
		textStateName.setFont(new Font("Courier New", Font.PLAIN, 15));
		add(textStateName);

		JLabel pinCode = new JLabel("Pin Code");
		pinCode.setBounds(50, 420, 100, 30);
		pinCode.setFont(new Font("Courier New", Font.BOLD, 16));
		add(pinCode);

		textPinCode = new JTextField();
		textPinCode.setBounds(200, 420, 150, 25);
		textPinCode.setFont(new Font("Courier New", Font.PLAIN, 15));
		add(textPinCode);

		JLabel mobNumber = new JLabel("Mobile Number");
		mobNumber.setBounds(50, 455, 140, 30);
		mobNumber.setFont(new Font("Courier New", Font.BOLD, 16));
		add(mobNumber);

		textMobNo = new JTextField();
		textMobNo.setBounds(200, 455, 180, 30);
		textMobNo.setFont(new Font("Courier New", Font.PLAIN, 15));
		add(textMobNo);

		next = new JButton("Next");
		next.setFont(new Font("Courier New", Font.BOLD, 15));
		next.setBounds(590, 500, 80, 30);
		next.setForeground(Color.white);
		next.setBackground(Color.black);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(new Color(250, 251, 252));
		setLayout(null);
		setSize(700, 600);
		setUndecorated(true);
		setLocation(360, 40);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String formNumber = first;
		String name = firstName.getText();
		String fathersName = middleName.getText();
		String surName = lastName.getText();
		String DOB = ((JTextField) dateOfBirth.getDateEditor().getUiComponent()).getText();
		String gender = null;

		if (btn1.isSelected()) {
			gender = "Male";
		} else if (btn2.isSelected()) {
			gender = "Female";
		} else if (btn3.isSelected()) {
			gender = "Others";
		}

		String email_id = textEmail.getText();
		String maritalStatus = null;
		if (btnMarried.isSelected()) {
			maritalStatus = "Married";
		} else if (btnUnMarried.isSelected()) {
			maritalStatus = "UnMarried";
		} else if (btnOthers.isSelected()) {
			maritalStatus = "Others";
		}

		String address = textAdd.getText();
		String city = textCityName.getText();
		String state = textStateName.getText();
		String pinNumber = textPinCode.getText();
		String mobileNumber = textMobNo.getText();

		try {
			if (firstName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the fields.");
			} else {

				/* MySQL Data-base connection done by using JDBC Class. */
				DataBaseConnection connect1 = new DataBaseConnection();

				/* Writing SQL query for insertion of data in database. */
				String query = "insert into SignUp Values('" + formNumber + "','" + name + "','" + fathersName + "','"
						+ surName + "','" + DOB + "','" + gender + "','" + email_id + "','" + maritalStatus + "','"
						+ address + "','" + city + "','" + state + "','" + pinNumber + "','" + mobileNumber + "')";

				/* Storing Data From user to MySQL Database. */
				connect1.statement.executeUpdate(query);

				new SignUp2(first);
				setVisible(false);
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
}
/* @Saurabh_Wankhade. */