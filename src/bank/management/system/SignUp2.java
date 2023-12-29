package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp2 extends JFrame implements ActionListener {
	String formNumber;
	JComboBox comboBox1, comboBox2, comboBox3, comboBox4, comboBox5, comboBox6, comboBox7;
	JTextField textPAN, textAadharNo;
	JRadioButton btn1, btn2, btn3, btn4;
	JButton next;

	public static void main(String[] args) {
		new SignUp2("");
	}

	SignUp2(String  formNumber) {

		super("Account Opening Form");
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank_log.png"));
		Image img2 = img1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel image = new JLabel(img3);
		image.setBounds(25, 10, 40, 40);
		add(image);

		this.formNumber = formNumber;

		JLabel label1 = new JLabel("ADDITIONAL DETAILS*");
		label1.setFont(new Font("Courier New", Font.BOLD, 17));
		label1.setBounds(50, 52, 600, 30);
		add(label1);

		JLabel label2 = new JLabel("Page 2");
		label2.setFont(new Font("Courier New", Font.BOLD, 16));
		label2.setBounds(310, 500, 600, 30);
		add(label2);

		JLabel label3 = new JLabel("Religion");
		label3.setFont(new Font("Courier New", Font.BOLD, 16));
		label3.setBounds(50, 80, 100, 30);
		add(label3);

		String religion[] = { "Select", "Buddhist", "Hindu", "Muslim", "Sikh", "Christian", "Jains" };
		comboBox1 = new JComboBox(religion);
		comboBox1.setBackground(new Color(242, 244, 245));
		comboBox1.setFont(new Font("Courier New", Font.BOLD, 14));
		comboBox1.setBounds(230, 85, 300, 25);
		add(comboBox1);

		JLabel label4 = new JLabel("Category");
		label4.setFont(new Font("Courier New", Font.BOLD, 16));
		label4.setBounds(50, 115, 100, 30);
		add(label4);

		String category[] = { "Select", "General", "OBC", "SC", "ST", "Other" };
		comboBox2 = new JComboBox(category);
		comboBox2.setBackground(new Color(242, 244, 245));
		comboBox2.setFont(new Font("Courier New", Font.BOLD, 14));
		comboBox2.setBounds(230, 120, 300, 25);
		add(comboBox2);

		JLabel label5 = new JLabel("Income Details");
		label5.setFont(new Font("Courier New", Font.BOLD, 16));
		label5.setBounds(50, 150, 140, 30);
		add(label5);

		String income[] = { "Select", "< 1,50,000 Rs.", "< 2,50,000 Rs.", "5,00,000 Rs.", "Upto 10,00,000 Rs.",
				"Above 10,00,000 Rs.", "Null" };
		comboBox3 = new JComboBox(income);
		comboBox3.setBackground(new Color(242, 244, 245));
		comboBox3.setFont(new Font("Courier New", Font.BOLD, 14));
		comboBox3.setBounds(230, 155, 300, 25);
		add(comboBox3);

		JLabel label6 = new JLabel("Educational");
		label6.setFont(new Font("Courier New", Font.BOLD, 16));
		label6.setBounds(50, 185, 140, 30);
		add(label6);

		String education[] = { "Select", "X th", "XII th", "Non-Graduate", "Graduate", "Post-Graduate", "Others" };
		comboBox4 = new JComboBox(education);
		comboBox4.setBackground(new Color(242, 244, 245));
		comboBox4.setFont(new Font("Courier New", Font.BOLD, 14));
		comboBox4.setBounds(230, 190, 300, 25);
		add(comboBox4);

		JLabel label7 = new JLabel("Occupation");
		label7.setFont(new Font("Courier New", Font.BOLD, 16));
		label7.setBounds(50, 220, 100, 30);
		add(label7);

		String occupation[] = { "Select", "Student", "Salaried", "Self-Employed", "Business", "Retired", "Others" };
		comboBox5 = new JComboBox(occupation);
		comboBox5.setBackground(new Color(242, 244, 245));
		comboBox5.setFont(new Font("Courier New", Font.BOLD, 14));
		comboBox5.setBounds(230, 225, 300, 25);
		add(comboBox5);

		JLabel label8 = new JLabel("Aadhar Number");
		label8.setFont(new Font("Courier New", Font.BOLD, 16));
		label8.setBounds(50, 255, 150, 30);
		add(label8);

		textAadharNo = new JTextField();
		textAadharNo.setFont(new Font("Courier New", Font.PLAIN, 15));
		textAadharNo.setBounds(230, 260, 200, 25);
		add(textAadharNo);

		JLabel label9 = new JLabel("PAN Number");
		label9.setFont(new Font("Courier New", Font.BOLD, 16));
		label9.setBounds(50, 290, 100, 30);
		add(label9);

		textPAN = new JTextField();
		textPAN.setFont(new Font("Courier New", Font.PLAIN, 15));
		textPAN.setBounds(230, 295, 200, 25);
		add(textPAN);

		JLabel label10 = new JLabel("Senior Citizen");
		label10.setBounds(50, 325, 180, 30);
		label10.setFont(new Font("Courier New", Font.BOLD, 16));
		add(label10);

		btn1 = new JRadioButton("Yes");
		btn1.setBackground(new Color(250, 251, 252));
		btn1.setFont(new Font("Courier New", Font.PLAIN, 16));
		btn1.setBounds(230, 328, 70, 25);
		add(btn1);

		btn2 = new JRadioButton("No");
		btn2.setBackground(new Color(250, 251, 252));
		btn2.setFont(new Font("Courier New", Font.PLAIN, 16));
		btn2.setBounds(300, 328, 70, 25);
		add(btn2);

		/*
		 * The ButtonGroup class creates a group in which you can add radio buttons. Of
		 * course, only one radio button in a button group can be selected at any time.
		 */
		ButtonGroup btnGroupSC = new ButtonGroup();
		btnGroupSC.add(btn1);
		btnGroupSC.add(btn2);

		JLabel label11 = new JLabel("Existing Account");
		label11.setBounds(50, 360, 180, 30);
		label11.setFont(new Font("Courier New", Font.BOLD, 16));
		add(label11);

		btn3 = new JRadioButton("Yes");
		btn3.setBackground(new Color(250, 251, 252));
		btn3.setFont(new Font("Courier New", Font.PLAIN, 16));
		btn3.setBounds(230, 361, 70, 25);
		add(btn3);

		btn4 = new JRadioButton("No");
		btn4.setBackground(new Color(250, 251, 252));
		btn4.setFont(new Font("Courier New", Font.PLAIN, 16));
		btn4.setBounds(300, 361, 70, 25);
		add(btn4);

		/*
		 * The ButtonGroup class creates a group in which you can add radio buttons. Of
		 * course, only one radio button in a button group can be selected at any time.
		 */
		ButtonGroup btnGroupEA = new ButtonGroup();
		btnGroupEA.add(btn3);
		btnGroupEA.add(btn4);

		JLabel label12 = new JLabel("Form No");
		label12.setBounds(80, 10, 600, 40);
		label12.setFont(new Font("Courier New", Font.BOLD, 14));
		add(label12);

		/* formNumber is used to get a previous application form from signup file. */
		JLabel label13 = new JLabel(formNumber);
		label13.setBounds(180, 10, 60, 40);
		label13.setFont(new Font("Courier New", Font.BOLD, 14));
		add(label13);

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
		String rel = (String) comboBox1.getSelectedItem();
		String cate = (String) comboBox2.getSelectedItem();
		String inc = (String) comboBox3.getSelectedItem();
		String edu = (String) comboBox4.getSelectedItem();
		String occupation = (String) comboBox5.getSelectedItem();

		String panCard = textPAN.getText();
		String aadharCard = textAadharNo.getText();

		String seniorCitizen = "";
		if (btn1.isSelected()) {
			seniorCitizen = "Yes";
		} else if (btn2.isSelected()) {
			seniorCitizen = "No";
		}

		String existingAccount = "";
		if (btn3.isSelected()) {
			existingAccount = "Yes";
		} else if (btn4.isSelected()) {
			existingAccount = "No";
		}

		try {
			if (textPAN.getText().equals("") || textAadharNo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the fields.");
			} else {
				DataBaseConnection connect2 = new DataBaseConnection();

				String query2 = "Insert Into SignUpTwo Values ('" + formNumber + "','" + rel + "','" + cate + "','"
						+ inc + "','" + edu + "','" + occupation + "','" + panCard + "'" + ",'" + aadharCard + "','"
						+ seniorCitizen + "','" + existingAccount + "')";

				connect2.statement.executeUpdate(query2);

				new SignUp3(formNumber);
				setVisible(false);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
}
/* @Saurabh_Wankhade. */