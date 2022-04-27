import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import keeptoo.KGradientPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import com.k33ptoo.components.KButton;
import javax.swing.UIManager;

public class Sign_Up extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField EmailField;
	private JPasswordField conf_pass;

	
	public static void run() {
		
		Sign_Up frame = new Sign_Up();
		frame.setVisible(true);
		frame.setTitle("Sign Up");
				
	}

	
	public Sign_Up() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = Color.CYAN;
		gradientPanel.setBounds(0, 0, 434, 361);
		contentPane.add(gradientPanel);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 23));
		lblNewLabel.setBounds(149, 26, 122, 30);
		gradientPanel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passwordField.setOpaque(false);
		passwordField.setBounds(87, 185, 258, 20);
		gradientPanel.add(passwordField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Confirm password");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(87, 216, 141, 14);
		gradientPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(87, 163, 86, 14);
		gradientPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(87, 112, 62, 14);
		gradientPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(87, 67, 75, 14);
		gradientPanel.add(lblNewLabel_1);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		nameField.setForeground(Color.WHITE);
		nameField.setColumns(10);
		nameField.setBounds(87, 81, 258, 20);
		nameField.setBackground(new Color(0,0,0,100));
		nameField.setOpaque(false);
		gradientPanel.add(nameField);
		
		EmailField = new JTextField();
		EmailField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		EmailField.setForeground(Color.WHITE);
		EmailField.setOpaque(false);
		EmailField.setColumns(10);
		EmailField.setBounds(87, 132, 258, 20);
		gradientPanel.add(EmailField);
		
		conf_pass = new JPasswordField();
		conf_pass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		conf_pass.setForeground(Color.WHITE);
		conf_pass.setOpaque(false);
		conf_pass.setBounds(87, 238, 258, 20);
		
		gradientPanel.add(conf_pass);
		KButton LoginBtn = new KButton();
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login.run();
			}
		});
		LoginBtn.kForeGround = UIManager.getColor("Button.background");
		LoginBtn.kHoverEndColor = new Color(0, 0, 128);
		LoginBtn.kHoverForeGround = UIManager.getColor("Button.background");
		LoginBtn.kHoverStartColor = new Color(0, 0, 255);
		LoginBtn.kBackGroundColor = new Color(0, 0, 128);
		LoginBtn.setText("Log In");
		LoginBtn.kStartColor = new Color(0, 0, 255);
		LoginBtn.setBorder(null);
		LoginBtn.setFocusable(false);
		LoginBtn.kBorderRadius = 30;
		
		LoginBtn.setBounds(87, 290, 122, 30);
		gradientPanel.add(LoginBtn);
		
		KButton Sign_UpBTN = new KButton();
		Sign_UpBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =nameField.getText();
				String Email=EmailField.getText();
				String pass= login.getPass(passwordField.getPassword());
				String conf_pas=login.getPass(conf_pass.getPassword());
				boolean r1 = name.length()>0 && Email.length()>0 && pass.length()>0 && conf_pas.length()>0;
				if(!r1) {
					JOptionPane.showMessageDialog(Sign_UpBTN, "Fill The Blanks please");
				}
				if(r1) {
					boolean r2 = pass.equals(conf_pas);
					if(!r2) {
						JOptionPane.showMessageDialog(Sign_UpBTN, "Please make sure that your password is Similar.");
					}
					boolean r3 = help_functions.isEmail(Email);
					if(!r3) {
						JOptionPane.showMessageDialog(Sign_UpBTN, "Inavlid Email");
					}
					boolean r4= help_functions.isValidName(name);
					if(!r4) {
						JOptionPane.showMessageDialog(Sign_UpBTN, "Invalid Name");
					}
					boolean r5 = help_functions.isValidPass(pass);
					if(!r5) {
						JOptionPane.showMessageDialog(Sign_UpBTN,"The password should contain at least 7 , and at most 9 chars and at least 2 numbers , at most 4 numbers", "Invalid password",JOptionPane.ERROR_MESSAGE);
					}
					boolean r6=User.isntExist(name);
					if(!r6) {
						JOptionPane.showMessageDialog(Sign_UpBTN,"The name is already exist", "Invalid Name",JOptionPane.ERROR_MESSAGE);
					}
					boolean r =r2 && r3 && r4 && r5&&r6;
					if(r) {
							conectDatabase.addUser(new User(name , Email,pass));
							JOptionPane.showMessageDialog(Sign_UpBTN, "Added");
							nameField.setText("");
							EmailField.setText("");
							passwordField.setText("");
							conf_pass.setText("");
					}
				}
			}
		});
		Sign_UpBTN.kStartColor = Color.BLUE;
		Sign_UpBTN.setkStartColor(Color.BLUE);
		Sign_UpBTN.kHoverStartColor = Color.BLUE;
		Sign_UpBTN.setkHoverStartColor(Color.BLUE);
		Sign_UpBTN.kHoverForeGround = SystemColor.menu;
		Sign_UpBTN.setkHoverForeGround(SystemColor.menu);
		Sign_UpBTN.kHoverEndColor = new Color(0, 0, 128);
		Sign_UpBTN.setkHoverEndColor(new Color(0, 0, 128));
		Sign_UpBTN.kForeGround = SystemColor.menu;
		Sign_UpBTN.setkForeGround(SystemColor.menu);
		Sign_UpBTN.kBorderRadius = 30;
		Sign_UpBTN.setkBorderRadius(30);
		Sign_UpBTN.kBackGroundColor = new Color(0, 0, 128);
		Sign_UpBTN.setkBackGroundColor(new Color(0, 0, 128));
		Sign_UpBTN.setBounds(247, 290, 122, 30);
		Sign_UpBTN.setText("Sign Up");
		Sign_UpBTN.setBorder(null);
		gradientPanel.add(Sign_UpBTN);
	}
}
