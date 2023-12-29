package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BankMainClass extends JFrame implements ActionListener {
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
	String cardPassword;

	BankMainClass(String cardPassword) {
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image img2 = img1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel imageLabel = new JLabel(img3);
		imageLabel.setBounds(0, 0, 1550, 830);
		add(imageLabel);

		JLabel label1 = new JLabel("Please Select Your Transaction");
		label1.setBounds(475, 200, 700, 35);
		label1.setForeground(Color.white);
		label1.setFont(new Font("System", Font.BOLD, 20));
		imageLabel.add(label1);

		/* Receive pin card From Login class & store into cardPassword. */
		this.cardPassword = cardPassword;

		/* Left Side Button. */
		btn1 = new JButton("DEPOSIT");
		btn1.setForeground(Color.white);
		btn1.setBackground(new Color(65, 125, 128));
		btn1.setBounds(410, 280, 150, 35);
		btn1.addActionListener(this);
		imageLabel.add(btn1);

		btn2 = new JButton("FAST CASH");
		btn2.setForeground(Color.white);
		btn2.setBackground(new Color(65, 125, 128));
		btn2.setBounds(410, 325, 150, 35);
		btn2.addActionListener(this);
		imageLabel.add(btn2);

		btn3 = new JButton("PIN CHANGE");
		btn3.setForeground(Color.white);
		btn3.setBackground(new Color(65, 125, 128));
		btn3.setBounds(410, 370, 150, 35);
		btn3.addActionListener(this);
		imageLabel.add(btn3);

		/* Right Side Buttons. */
		btn4 = new JButton("CASH WITHDRAWL");
		btn4.setForeground(Color.white);
		btn4.setBackground(new Color(65, 125, 128));
		btn4.setBounds(690, 280, 150, 35);
		btn4.addActionListener(this);
		imageLabel.add(btn4);

		btn5 = new JButton("MINI STATEMENT");
		btn5.setForeground(Color.white);
		btn5.setBackground(new Color(65, 125, 128));
		btn5.setBounds(690, 325, 150, 35);
		btn5.addActionListener(this);
		imageLabel.add(btn5);

		btn6 = new JButton("BALANCE ENQUIRY");
		btn6.setForeground(Color.white);
		btn6.setBackground(new Color(65, 125, 128));
		btn6.setBounds(690, 370, 150, 35);
		btn6.addActionListener(this);
		imageLabel.add(btn6);

		btn7 = new JButton("EXIT");
		btn7.setForeground(Color.white);
		btn7.setBackground(new Color(65, 125, 128));
		btn7.setBounds(690, 415, 150, 35);
		btn7.addActionListener(this);
		imageLabel.add(btn7);

		/* Frame Layout. */
		setLayout(null);
		setSize(1920, 1080);
		setLocation(0, 0);
		setUndecorated(true);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			new Deposit(cardPassword);
			setVisible(false);
		} else if (e.getSource() == btn2) {
			new FastCash(cardPassword);
			setVisible(false);
		} else if (e.getSource() == btn3) {
			new ChangePIN(cardPassword);
			setVisible(false);
		} else if (e.getSource() == btn4) {
			new Withdrawl(cardPassword);
			setVisible(false);
		} else if (e.getSource() == btn5) {
			new MiniStatement(cardPassword);
			setVisible(false);
		} else if (e.getSource() == btn6) {
			new BalanceEnquiry(cardPassword);
			setVisible(false);
		} else if (e.getSource() == btn7) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new BankMainClass("");
	}
}
/* @Saurabh_Wankhade. */