import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;
import com.k33ptoo.components.KButton;
import java.awt.SystemColor;

public class login extends JFrame {
	
	private static User user;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public static User getUser() {
		return user;
	}
	public static void run() {
		login frame = new login();
		frame.setVisible(true);
		frame.setTitle("LOG IN");
	}

	
	public login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 0, 584, 314);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 21));
		lblNewLabel.setBounds(384,14,100,30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(334,55,62,30);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textField.setBackground(new Color(0, 51, 102));
		textField.setBounds(334,81,211,20);
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(334,122,62,20);
		panel.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(SystemColor.text);
		passwordField.setBackground(new Color(0, 51, 102));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passwordField.setBounds(334,143,211,20);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBounds(0, 0, 300, 315);
		panel.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Library That You Can Buy");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(25, 74, 223, 31);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Any Book From It");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(67, 101, 143, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("_________________________________");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(0, 124, 280, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("_____________________________");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5_1.setBounds(10, 135, 255, 14);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("_________________________");
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5_1_1.setBounds(35, 149, 213, 14);
		panel_1.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("_____________________");
		lblNewLabel_5_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5_1_1_1.setBounds(10, 149, 280, 14);
		panel_1.add(lblNewLabel_5_1_1_1);
		
		KButton LoginButton = new KButton();
		LoginButton.kHoverForeGround = SystemColor.text;
		LoginButton.kHoverStartColor = new Color(0, 0, 128);
		LoginButton.kHoverEndColor = new Color(0, 250, 154);
		LoginButton.kBorderRadius = 30;
		LoginButton.setBorder(null);
		LoginButton.kEndColor = new Color(0, 0, 51);
		LoginButton.kStartColor = new Color(51, 153, 153);
		LoginButton.setText("Log In");
		LoginButton.setBounds(322, 189, 102, 31);
		LoginButton.setFocusable(false);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = getPass(passwordField.getPassword());
				if(textField.getText().length()>0 && password.length()>0) {
					User a = User.LinearSearch(conectDatabase.getUsers(), textField.getText(), password);
					if(a != null) {
						dispose();
						BookShop.run();
					}else {
						JOptionPane.showMessageDialog(LoginButton, "Not Found !!");
					}
				}else {
					JOptionPane.showMessageDialog(LoginButton, "Fill Tha Blanks !!");
				}
			}
		});
		panel.add(LoginButton);
		
		KButton Sign_Up_BTN = new KButton();
		Sign_Up_BTN.kHoverStartColor = new Color(0, 0, 128);
		Sign_Up_BTN.kHoverForeGround = new Color(0, 250, 154);
		Sign_Up_BTN.kStartColor = new Color(51, 153, 153);
		Sign_Up_BTN.setkStartColor(new Color(51, 153, 153));
		Sign_Up_BTN.kEndColor = new Color(0, 0, 51);
		Sign_Up_BTN.setkEndColor(new Color(0, 0, 51));
		Sign_Up_BTN.kBorderRadius = 30;
		Sign_Up_BTN.setkBorderRadius(30);
		Sign_Up_BTN.setText("Sign Up");
		Sign_Up_BTN.setFocusable(false);
		Sign_Up_BTN.setBorder(null);
		Sign_Up_BTN.setBounds(454, 189, 102, 31);
		Sign_Up_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sign_Up.run();
			}
		});
		panel.add(Sign_Up_BTN);
		
		JLabel lblNewLabel_2 = new JLabel("100,000 Books Here Choose Any Book You Want");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setBounds(310, 252, 264, 14);
		panel.add(lblNewLabel_2);
	}
	public static String getPass(char [] t) {
		String a ="";
		for(int i =0 ; i<t.length;i++) {
			a=a+t[i];
		}
		return a;
	}
}
