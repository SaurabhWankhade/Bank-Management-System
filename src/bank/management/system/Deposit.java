package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Deposit extends JFrame implements ActionListener {
	String pinNumber;
	TextField textField;
	JButton btn1, btn2;

	public static void main(String[] args) {
		new Deposit("");
	}

	/* Constructor. */
	Deposit(String pinNumber) {

		this.pinNumber = pinNumber;

		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image img2 = img1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);

		JLabel label1 = new JLabel(img3);
		label1.setBounds(0, 0, 1550, 830);
		add(label1);

		JLabel label2 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
		label2.setForeground(Color.white);
		label2.setBounds(460, 220, 400, 35);
		label2.setFont(new Font("System", Font.BOLD, 16));
		/* Adding font over image. */
		label1.add(label2);

		textField = new TextField();
		textField.setBounds(460, 275, 320, 25);
		textField.setFont(new Font("Courier New", Font.BOLD, 16));
		textField.setBackground(new Color(65, 125, 128));
		textField.setForeground(Color.white);
		label1.add(textField);

		btn1 = new JButton("DEPOSIT");
		btn1.setBounds(700, 362, 150, 35);
		btn1.setBackground(new Color(65, 125, 128));
		btn1.setForeground(Color.white);
		btn1.addActionListener(this);
		label1.add(btn1);

		btn2 = new JButton("BACK");
		btn2.setBounds(700, 408, 150, 35);
		btn2.setBackground(new Color(65, 125, 128));
		btn2.setForeground(Color.white);
		btn2.addActionListener(this);
		label1.add(btn2);

		/* Frame Layout. */
		setLayout(null);
		setSize(1920, 830);
		setLocation(0, 0);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			/* Get amount in the form text from user and store into amount. */
			String amount = textField.getText();

			Date date = new Date();

			if (e.getSource() == btn1) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to Deposit.");
				} else {
					DataBaseConnection connect4 = new DataBaseConnection();

					connect4.statement.executeUpdate(
							"INSERT INTO Bank values('" + pinNumber + "','" + date + "','Deposit','" + amount + "')");
					JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully.");
					setVisible(false);
					new BankMainClass(pinNumber);
				}

			} else if (e.getSource() == btn2) {
				setVisible(false);
				new BankMainClass(pinNumber);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
/* @Saurabh_Wankhade. */
