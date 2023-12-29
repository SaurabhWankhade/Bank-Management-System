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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class ChangePIN extends JFrame implements ActionListener {
	JButton btn1, btn2;
	JPasswordField pass1, pass2;
	String cardPassword;

	public ChangePIN(String cardPassword) {

		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image img2 = img1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);

		JLabel label1 = new JLabel(img3);
		label1.setBounds(0, 0, 1550, 830);
		add(label1);

		this.cardPassword = cardPassword;

		JLabel label2 = new JLabel("CHANGE YOUR PIN");
		label2.setForeground(Color.white);
		label2.setBounds(420, 180, 400, 35);
		label2.setFont(new Font("Courier New", Font.BOLD, 20));
		/* Adding font over image. */
		label1.add(label2);

		JLabel label3 = new JLabel("New PIN");
		label3.setForeground(Color.white);
		label3.setBounds(420, 230, 400, 35);
		label3.setFont(new Font("Courier New", Font.BOLD, 18));
		/* Adding font over image. */
		label1.add(label3);

		pass1 = new JPasswordField();
		pass1.setBounds(610, 230, 220, 30);
		pass1.setFont(new Font("Courier New", Font.BOLD, 18));
		pass1.setBackground(new Color(65, 125, 128));
		pass1.setForeground(Color.white);
		label1.add(pass1);

		JLabel label4 = new JLabel("Re-Enter New PIN");
		label4.setForeground(Color.white);
		label4.setBounds(420, 290, 400, 35);
		label4.setFont(new Font("Courier New", Font.BOLD, 18));
		/* Adding font over image. */
		label1.add(label4);

		pass2 = new JPasswordField();
		pass2.setBounds(610, 290, 220, 30);
		pass2.setFont(new Font("Courier New", Font.BOLD, 18));
		pass2.setBackground(new Color(65, 125, 128));
		pass2.setForeground(Color.white);
		label1.add(pass2);

		btn1 = new JButton("CHANGE");
		btn1.setBounds(700, 362, 150, 35);
		btn1.setFont(new Font("Courier New", Font.BOLD, 18));
		btn1.setBackground(new Color(65, 125, 128));
		btn1.setForeground(Color.white);
		btn1.addActionListener(this);
		label1.add(btn1);

		btn2 = new JButton("BACK");
		btn2.setBounds(700, 408, 150, 35);
		btn2.setFont(new Font("Courier New", Font.BOLD, 18));
		btn2.setBackground(new Color(65, 125, 128));
		btn2.setForeground(Color.white);
		btn2.addActionListener(this);
		label1.add(btn2);

		/* Frame Layout. */
		setSize(1550, 1080);
		setLayout(null);
		setVisible(true);
		setUndecorated(true);
		setLocation(0, 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String pin1 = pass1.getText();
			String pin2 = pass2.getText();
			/* Pin-Number verification Logic. */
			if (!pin1.equals(pin2)) {
				JOptionPane.showMessageDialog(null, "Entered PIN Number Does Not Match.");
				return;
			}

			if (e.getSource() == btn1) {
				/* when user fill blank PIN details in textfield then below code will executed.*/
				if (pass1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter New PIN.");
					return;
				}
				if (pass2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Re-Enter New PIN.");
					return;
				}
				DataBaseConnection connect = new DataBaseConnection();

				/*
				 * Below 3 Query Is used to Update data from Database bank, signupthree &
				 * logindetails tables.
				 */
				String query1 = "UPDATE Bank set  Pin_Number='" + pin1 + "' Where  Pin_Number= '" + cardPassword + "'";
				String query2 = "UPDATE LoginDetails set  Pin_Number='" + pin1 + "' Where  Pin_Number= '" + cardPassword+ "'";
				String query3 = "UPDATE  SignupThree set  Pin_Number='" + pin1 + "' Where  Pin_Number= '" + cardPassword+ "'";

				connect.statement.executeUpdate(query1);
				connect.statement.executeUpdate(query2);
				connect.statement.executeUpdate(query3);

				JOptionPane.showMessageDialog(null, "PIN Changed Successfully.");
				setVisible(false);
				new BankMainClass(cardPassword);
			} else if (e.getSource() == btn2) {
				new BankMainClass(cardPassword);
				setVisible(false);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChangePIN("");
	}

}
/* @Saurabh_Wankhade. */