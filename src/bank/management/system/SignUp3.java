package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.xml.crypto.Data;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class SignUp3 extends JFrame implements ActionListener {
	String formNumber;
	JRadioButton btn1, btn2, btn3, btn4;
	JCheckBox check1, check2, check3, check4, check5, check6, check7;
	JButton submit, cancel;

	public static void main(String[] args) {
		new SignUp3("");
	}

	/* Contructor. */
	SignUp3(String formNumber) {
		super("Account Opening Form");
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank_log.png"));
		Image img2 = img1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel image = new JLabel(img3);
		image.setBounds(25, 10, 40, 40);
		add(image);

		JLabel label2 = new JLabel("Account Details");
		label2.setFont(new Font("Courier New", Font.BOLD, 18));
		label2.setBounds(80, 10, 600, 40);
		add(label2);

		JLabel label3 = new JLabel("Account Type");
		label3.setFont(new Font("Courier New", Font.BOLD, 16));
		label3.setBounds(50, 80, 200, 30);
		add(label3);

		btn1 = new JRadioButton("Saving Account");
		btn1.setBounds(180, 90, 150, 30);
		btn1.setBackground(new Color(250, 251, 252));
		btn1.setFont(new Font("Courier New", Font.PLAIN, 14));
		add(btn1);

		btn2 = new JRadioButton("Current Account");
		btn2.setFont(new Font("Courier New", Font.PLAIN, 14));
		btn2.setBackground(new Color(250, 251, 252));
		btn2.setBounds(400, 90, 180, 30);
		add(btn2);

		btn3 = new JRadioButton("Fixed-Deposit Account");
		btn3.setFont(new Font("Courier New", Font.PLAIN, 14));
		btn3.setBackground(new Color(250, 251, 252));
		btn3.setBounds(180, 130, 220, 30);
		add(btn3);

		btn4 = new JRadioButton("Recurring-Deposit Account");
		btn4.setFont(new Font("Courier New", Font.PLAIN, 14));
		btn4.setBackground(new Color(250, 251, 252));
		btn4.setBounds(400, 130, 300, 30);
		add(btn4);

		ButtonGroup accountType = new ButtonGroup();
		accountType.add(btn1);
		accountType.add(btn2);
		accountType.add(btn3);
		accountType.add(btn4);

		JLabel label4 = new JLabel("Card Number ");
		label4.setFont(new Font("Courier New", Font.BOLD, 16));
		label4.setBounds(50, 170, 200, 30);
		add(label4);

		JLabel label5 = new JLabel("(Your 16-Digit Card Number)");
		label5.setFont(new Font("Courier New", Font.PLAIN, 12));
		label5.setBounds(10, 195, 200, 20);
		add(label5);

		JLabel label6 = new JLabel("XXXX-XXXX-XXXX-1234");
		label6.setFont(new Font("Courier New", Font.BOLD, 14));
		label6.setBounds(350, 180, 200, 20);
		add(label6);

		JLabel label7 = new JLabel("(It would appear on ATM Card/Cheque Book and Statements.)");
		label7.setFont(new Font("Courier New", Font.PLAIN, 12));
		label7.setBounds(240, 195, 450, 20);
		add(label7);
		add(label7);

		JLabel label8 = new JLabel("PIN ");
		label8.setFont(new Font("Courier New", Font.BOLD, 16));
		label8.setBounds(50, 225, 200, 20);
		add(label8);

		JLabel label9 = new JLabel("XXXX");
		label9.setFont(new Font("Courier New", Font.BOLD, 14));
		label9.setBounds(390, 230, 200, 20);
		add(label9);

		JLabel label10 = new JLabel("(4-Digit Password)");
		label10.setFont(new Font("Courier New", Font.PLAIN, 12));
		label10.setBounds(10, 245, 200, 20);
		add(label10);

		JLabel label11 = new JLabel("Services");
		label11.setFont(new Font("Courier New", Font.BOLD, 16));
		label11.setBounds(50, 280, 200, 30);
		add(label11);

		check1 = new JCheckBox("ATM Card");
		check1.setBackground(new Color(250, 251, 252));
		check1.setFont(new Font("Courier New", Font.PLAIN, 14));
		check1.setBounds(150, 290, 100, 30);
		add(check1);

		check2 = new JCheckBox("Email Alert");
		check2.setBackground(new Color(250, 251, 252));
		check2.setFont(new Font("Courier New", Font.PLAIN, 14));
		check2.setBounds(300, 290, 150, 30);
		add(check2);

		check3 = new JCheckBox("Cheque Book");
		check3.setBackground(new Color(250, 251, 252));
		check3.setFont(new Font("Courier New", Font.PLAIN, 14));
		check3.setBounds(150, 330, 123, 30);
		add(check3);

		check4 = new JCheckBox("E-Statement");
		check4.setBackground(new Color(250, 251, 252));
		check4.setFont(new Font("Courier New", Font.PLAIN, 14));
		check4.setBounds(300, 330, 150, 30);
		add(check4);

		check5 = new JCheckBox("Mobile Banking");
		check5.setBackground(new Color(250, 251, 252));
		check5.setFont(new Font("Courier New", Font.PLAIN, 14));
		check5.setBounds(450, 330, 150, 30);
		add(check5);

		check6 = new JCheckBox("Internet Banking");
		check6.setBackground(new Color(250, 251, 252));
		check6.setFont(new Font("Courier New", Font.PLAIN, 14));
		check6.setBounds(450, 290, 200, 30);
		add(check6);

		check7 = new JCheckBox(
				"I here by decleares that the above entered details correct to the best of my knowledge.");
		check7.setBackground(new Color(250, 251, 252));
		check7.setFont(new Font("Courier New", Font.BOLD, 12));
		check7.setBounds(20, 370, 700, 30);
		add(check7);

		this.formNumber = formNumber;

		JLabel label12 = new JLabel("Form No");
		label12.setBounds(350, 10, 600, 40);
		label12.setFont(new Font("Courier New", Font.BOLD, 14));
		add(label12);

		JLabel label13 = new JLabel(formNumber);
		label13.setBounds(460, 10, 60, 40);
		label13.setFont(new Font("Courier New", Font.BOLD, 14));
		add(label13);

		submit = new JButton("Submit");
		submit.setFont(new Font("Courier New", Font.BOLD, 14));
		submit.setBounds(200, 450, 100, 30);
		submit.setForeground(Color.white);
		submit.setBackground(Color.black);
		submit.addActionListener(this);
		add(submit);

		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Courier New", Font.BOLD, 14));
		cancel.setBounds(400, 450, 100, 30);
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.addActionListener(this);
		add(cancel);

		/* Frame Layout. */
		getContentPane().setBackground(new Color(250, 251, 252));
		setLayout(null);
		setUndecorated(true);
		setSize(700, 600);
		setLocation(360, 40);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actType = null;
		if (btn1.isSelected()) {
			actType = "Saving Account";
		} else if (btn2.isSelected()) {
			actType = "Current Account";
		} else if (btn3.isSelected()) {
			actType = "Fixed-Deposit Account";
		} else if (btn4.isSelected()) {
			actType = "Recurring-Deposit Account";
		}

		/* Logic for Generating Random Number. */
		Random randomNo = new Random();

		/* for Card Number. */
		long first7 = (randomNo.nextLong() % 90000000L) + 1409963000000000L;
		String cardNo = "" + Math.abs(first7);

		/* for Pin Number. */
		long first3 = (randomNo.nextLong() % 9000L) + 1000L;
		String pin = "" + Math.abs(first3);

		String bankServices = "";
		// Assuming you have an array or a list of your checkboxes like checkBoxesArray
		JCheckBox[] checkBoxesArray = {check1, check2, check3, check4, check5, check6};

		for (JCheckBox checkBox : checkBoxesArray) {
		    if (checkBox.isSelected()) {
		        bankServices += checkBox.getText() + ", ";
		    }
		}

		// Trim any extra whitespace at the end
		bankServices = bankServices.trim();

		try {
			if (e.getSource() == submit) {
				if (actType.equals("")) {
					JOptionPane.showMessageDialog(null, "Fill all the Fields.");
				} else {
					DataBaseConnection connect3 = new DataBaseConnection();

					String query1 = "INSERT INTO SignUpThree values('" + formNumber + "','" + actType + "','" + cardNo
							+ "','" + pin + "','" + bankServices + "')";

					String query2 = "INSERT INTO LoginDetails values('" + formNumber + "','" + cardNo + "','" + pin
							+ "')";

					connect3.statement.executeUpdate(query1);
					connect3.statement.executeUpdate(query2);

					JOptionPane.showMessageDialog(null, "CARD NUMBER : " + cardNo + "\n    PIN     : " + pin);

					new Deposit(pin);
					setVisible(false);
				}
			} else if (e.getSource() == cancel) {
				System.exit(0);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}
/* @Saurabh_Wankhade. */