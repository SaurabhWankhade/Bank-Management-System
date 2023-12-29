package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Withdrawl extends JFrame implements ActionListener {
	TextField textField;
	JButton btn1, btn2;
	String pinNumber;

	Withdrawl(String pinNumber) {

		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image img2 = img1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);

		JLabel label1 = new JLabel(img3);
		label1.setBounds(0, 0, 1550, 830);
		add(label1);

		JLabel label2 = new JLabel("MAXIMUM WITHDRAWL AMOUNT IS RS.10,000");
		label2.setForeground(Color.white);
		label2.setBounds(460, 220, 700, 35);
		label2.setFont(new Font("System", Font.BOLD, 16));
		/* Adding font over image. */
		label1.add(label2);

		JLabel label3 = new JLabel("PLEASE ENTER YOUR AMOUNT");
		label3.setForeground(Color.white);
		label3.setBounds(500, 260, 400, 30);
		label3.setFont(new Font("System", Font.PLAIN, 16));
		/* Adding font over image. */
		label1.add(label3);

		textField = new TextField();
		textField.setBounds(460, 295, 320, 25);
		textField.setFont(new Font("Courier New", Font.BOLD, 16));
		textField.setBackground(new Color(65, 125, 128));
		textField.setForeground(Color.white);
		label1.add(textField);

		this.pinNumber = pinNumber;

		btn1 = new JButton("WITHDRAWL");
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
		/* When user press withdrawl button below if block executed. */
		if (e.getSource() == btn1) {
			try {
				String amount = textField.getText();
				Date date = new Date();
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Withdraw.");
				} else {
					DataBaseConnection connect = new DataBaseConnection();
					ResultSet result = connect.statement
							.executeQuery("SELECT * FROM Bank Where Pin_Number ='" + pinNumber + "'");
					int balance = 0;
					while (result.next()) {
						if (result.getString("Type").equals("Deposit")) {
							balance += Integer.parseInt(result.getString("Amount"));
						} else {
							balance -= Integer.parseInt(result.getString("Amount"));
						}
					}
					/*
					 * When the Actual Account Balance is less than the User Entered Amount then it
					 * shows a message.
					 */
					if (balance < Integer.parseInt(amount)) {
						JOptionPane.showMessageDialog(null, "Insufficiant Balance.");
						return;
					}
					/* Amount Debited Query. */
					connect.statement.executeUpdate(
							"INSERT Into Bank Values('" + pinNumber + "','" + date + "','Withdrawl','" + amount + "')");
					JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully.");
					setVisible(false);
					new BankMainClass(pinNumber);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} /* When user press back button below if block executed. */
		else if (e.getSource() == btn2) {
			setVisible(false);
			new BankMainClass(pinNumber);
		}
	}

	public static void main(String[] args) {
		new Withdrawl("");
	}
}
/* @Saurabh_Wankhade. */