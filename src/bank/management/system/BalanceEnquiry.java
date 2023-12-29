package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.crypto.Data;

public class BalanceEnquiry extends JFrame implements ActionListener {
	JLabel label3;
	JButton btn1;
	String pinNumber;

	BalanceEnquiry(String pinNumber) {

		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image img2 = img1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);

		JLabel label1 = new JLabel(img3);
		label1.setBounds(0, 0, 1550, 830);
		add(label1);

		JLabel label2 = new JLabel("Your Current Balance is Rs.");
		label2.setForeground(Color.white);
		label2.setBounds(460, 220, 700, 35);
		label2.setFont(new Font("System", Font.BOLD, 16));
		/* Adding font over image. */
		label1.add(label2);

		label3 = new JLabel("");
		label3.setForeground(Color.white);
		label3.setBounds(500, 260, 400, 30);
		label3.setFont(new Font("System", Font.PLAIN, 16));
		/* Adding font over image. */
		label1.add(label3);

		btn1 = new JButton("BACK");
		btn1.setBounds(700, 406, 150, 35);
		btn1.setBackground(new Color(65, 125, 128));
		btn1.setForeground(Color.white);
		btn1.addActionListener(this);
		label1.add(btn1);

		this.pinNumber = pinNumber;
		int balance = 0;
		/* Getting Account balance from table. */
		try {
			DataBaseConnection deductedAmountConnection = new DataBaseConnection();
			/* Getting Data from user and store into resultset. */
			ResultSet resultSet = deductedAmountConnection.statement.executeQuery("Select * From Bank Where Pin_Number='" + pinNumber + "'");
			while (resultSet.next()) {
				if (resultSet.getString("Type").equals("Deposit")) {
					balance += Integer.parseInt(resultSet.getString("Amount"));
				} else {
					balance -= Integer.parseInt(resultSet.getString("Amount"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Account Balance Stored in Label 3. */
		label3.setText(" " + balance);

		/* Frame Layout. */
		setLayout(null);
		setSize(1920, 830);
		setUndecorated(true);
		setLocation(0, 0);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new BankMainClass(pinNumber);
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
}
/* @Saurabh_Wankhade. */