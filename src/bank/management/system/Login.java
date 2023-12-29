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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

//	Global Variable Declare.
	JLabel label, label1, label2;
	JTextField text;
	JPasswordField pass;
	JButton btn1, btn2, btn3;

	public static void main(String[] args) {
		new Login();
	}

	Login() {
		super("Bank Management System");

		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
		Image img2 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel img = new JLabel(img3);
		img.setBounds(350, 10, 100, 100);
		add(img);

		ImageIcon img11 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
		Image img12 = img11.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon img13 = new ImageIcon(img12);
		JLabel image = new JLabel(img13);
		image.setBounds(630, 350, 100, 100);
		add(image);

//		JLabel simply is used to display a text message or an icon/image or both on the screen.
		label = new JLabel("WELCOME TO ATM");
		label.setForeground(Color.white);
		label.setFont(new Font("Courier New", Font.BOLD, 24));
		label.setBounds(300, 110, 450, 40);
		add(label);

		label1 = new JLabel("Card Number:");
		label1.setFont(new Font("Courier New", Font.BOLD, 20));
		label1.setForeground(Color.white);
		label1.setBounds(150, 190, 375, 30);
		add(label1);

		text = new JTextField(15);
		text.setBounds(325, 190, 230, 30);
		text.setFont(new Font("Courier New", Font.BOLD, 20));
		add(text);

		label2 = new JLabel("PIN:");
		label2.setFont(new Font("Courier New", Font.BOLD, 20));
		label2.setForeground(Color.white);
		label2.setBounds(150, 230, 375, 30);
		add(label2);

		pass = new JPasswordField(15);
		pass.setBounds(325, 230, 230, 30);
		text.setFont(new Font("Courier New", Font.BOLD, 20));
		add(pass);

		ImageIcon background1 = new ImageIcon(ClassLoader.getSystemResource("icon/bgimage.jpg"));
		Image background2 = background1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
		ImageIcon background3 = new ImageIcon(background2);
		JLabel bg = new JLabel(background3);
		bg.setBounds(0, 0, 850, 480);
		add(bg);

		btn1 = new JButton("SIGN IN");
		btn1.setFont(new Font("Courier New", Font.BOLD, 14));
		btn1.setBounds(300, 300, 100, 30);
		btn1.setForeground(Color.white);
		btn1.setBackground(Color.black);
		btn1.addActionListener(this);
		add(btn1);

		btn2 = new JButton("CLEAR");
		btn2.setFont(new Font("Courier New", Font.BOLD, 14));
		btn2.setBounds(430, 300, 100, 30);
		btn2.setForeground(Color.white);
		btn2.setBackground(Color.black);
		btn2.addActionListener(this);
		add(btn2);

		btn3 = new JButton("SIGN UP");
		btn3.setFont(new Font("Courier New", Font.BOLD, 14));
		btn3.setBounds(300, 350, 230, 30);
		btn3.setForeground(Color.white);
		btn3.setBackground(Color.black);
		btn3.addActionListener(this);
		add(btn3);

		// Display window tabs.
		setLayout(null);
		setSize(850, 480);
		setLocation(450, 200);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btn1) {

				DataBaseConnection connect = new DataBaseConnection();
				String cardNumber = text.getText();
				String cardPassword = pass.getText();

				/* Query for verify the card logindetails availabel in database. */
				String check = "SELECT * FROM logindetails WHERE  Card_Number= '" + cardNumber + "' AND Pin_Number= '"+ cardPassword + "'";

				/* Getting Data from database and store into resultset. */
				ResultSet resultset = connect.statement.executeQuery(check);

				/*
				 * The next method moves the cursor to the next row, and because it returns
				 * false when there are no more rows in the ResultSet object.
				 */
				if (resultset.next()) {
					setVisible(false);
					new BankMainClass(cardPassword);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				}

			} else if (e.getSource() == btn2) {
				text.setText("");
				pass.setText("");
			} else if (e.getSource() == btn3) {
				new SignUp();
				setVisible(false);
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}

/* @Saurabh_Wankhade. */
