package bank.management.system;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.crypto.Data;

public class MiniStatement extends JFrame implements ActionListener {
	String cardPassword;
	JButton btn;
	MiniStatement(String cardPassword) {
		getContentPane().setBackground(new Color(255, 204, 204));
		setSize(400, 600);
		setUndecorated(true);
		setLocation(20, 20);
		setLayout(null);

		JLabel label1 = new JLabel();
		label1.setBounds(20, 140, 400, 200);
		add(label1);

		JLabel label2 = new JLabel("MINI STATEMENT");
		label2.setFont(new Font("Courier New", Font.BOLD, 15));
		label2.setBounds(140, 20, 200, 20);
		add(label2);

		JLabel label3 = new JLabel();
		label3.setFont(new Font("Courier New", Font.BOLD, 15));
		label3.setBounds(20, 80, 300, 20);
		add(label3);

		JLabel label4 = new JLabel();
		label4.setFont(new Font("Courier New", Font.BOLD, 15));
		label4.setBounds(20, 400, 300, 20);
		add(label4);
		
		this.cardPassword=cardPassword;

		try {
			DataBaseConnection connect = new DataBaseConnection();
			ResultSet result = connect.statement.executeQuery("SELECT * FROM logindetails Where Pin_Number= '" + cardPassword + "'");

			while (result.next()) {
				label3.setText("Card Number : " + result.getString("Card_Number").substring(0, 4) + "XXXXXXXX"+ result.getString("Card_Number").substring(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			int balance = 0;
			DataBaseConnection connect = new DataBaseConnection();
			ResultSet resultset = connect.statement.executeQuery("Select * from bank where Pin_Number='" + cardPassword + "'");
			/*
			 * resultSet.next() it is used to verify & read data comes from database in row.
			 */
			while (resultset.next()) {
				label1.setText(label1.getText() + "<html>" + resultset.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ resultset.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultset.getString("Amount")+"<br><br><html>");
				if (resultset.getString("Type").equals("Deposit")) {
					balance += Integer.parseInt(resultset.getString("Amount"));
				} else {
					balance -= Integer.parseInt(resultset.getString("Amount"));
				}
			}
			label4.setText("Your Total Balance is Rs "+balance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		btn=new JButton("Exit");
		btn.setBounds(20,500,100,25);
		btn.setBackground(Color.black);
		btn.setForeground(Color.white);
		btn.addActionListener(this);
		add(btn);
		
		setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}

	public static void main(String[] args) {
		new MiniStatement("");
	}

}
/* @Saurabh_Wankhade. */