import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import keeptoo.KGradientPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import com.k33ptoo.components.KButton;
import java.awt.SystemColor;

public class AddForm extends JFrame {

	private JPanel contentPane;
	private JTextField NameField;
	private JTextField TypeField;
	private JTextField PriceField;

	public static void run() {
		AddForm frame = new AddForm();
		frame.setVisible(true);
	}

	public AddForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 261, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = Color.PINK;
		gradientPanel.kEndColor = Color.CYAN;
		gradientPanel.setBounds(0, 0, 245, 187);
		contentPane.add(gradientPanel);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 21, 46, 14);
		gradientPanel.add(lblNewLabel);
		
		JLabel lblType = new JLabel("Price");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblType.setBounds(20, 98, 46, 14);
		gradientPanel.add(lblType);
		
		JLabel lblPrice = new JLabel("Type");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice.setBounds(20, 61, 46, 14);
		gradientPanel.add(lblPrice);
		
		NameField = new JTextField();
		NameField.setForeground(Color.WHITE);
		NameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		NameField.setOpaque(false);
		NameField.setBounds(20, 34, 204, 20);
		gradientPanel.add(NameField);
		NameField.setColumns(10);
		
		TypeField = new JTextField();
		TypeField.setForeground(Color.WHITE);
		TypeField.setOpaque(false);
		TypeField.setColumns(10);
		TypeField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		TypeField.setBounds(20, 73, 204, 20);
		gradientPanel.add(TypeField);
		
		PriceField = new JTextField();
		PriceField.setForeground(Color.WHITE);
		PriceField.setOpaque(false);
		PriceField.setColumns(10);
		PriceField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		PriceField.setBounds(20, 111, 204, 20);
		gradientPanel.add(PriceField);
		
		KButton AddBTN = new KButton();
		AddBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NameField.getText().length()>0 && PriceField.getText().length()>0 && TypeField.getText().length()>0) {
					try {
						int a=1;
						String name=NameField.getText();
						String type=TypeField.getText();
						Double price= Double.parseDouble(String.valueOf(PriceField.getText()));
						if(conectDatabase.getBooks().size() !=0) {
							a=conectDatabase.getBooks().get(conectDatabase.getBooks().size()-1).getId()+1;
						}
						conectDatabase.addBook(new Book(a,name,type,price));
						BookShop.addBookInTheTable(new Book(a,name,type,price));
						NameField.setText("");
						PriceField.setText("");
						TypeField.setText("");
						JOptionPane.showMessageDialog(AddBTN, "Added !");
					}catch(Exception q) {
						JOptionPane.showMessageDialog(AddBTN, "Price Should be a Number");
					}
				}else {
					JOptionPane.showMessageDialog(AddBTN, "Fill The Blanks PLease");
				}
			}
		});
		AddBTN.kHoverForeGround = new Color(230, 230, 250);
		AddBTN.kStartColor = new Color(233, 150, 122);
		AddBTN.kHoverEndColor = SystemColor.textHighlight;
		AddBTN.kHoverStartColor = SystemColor.activeCaption;
		AddBTN.setFocusable(false);
		AddBTN.setBorder(null);
		AddBTN.setText("Add Book");
		AddBTN.kEndColor = Color.PINK;
		AddBTN.kBorderRadius = 30;
		AddBTN.setBounds(71, 142, 97, 28);
		gradientPanel.add(AddBTN);
		setResizable(false);
	}
}
