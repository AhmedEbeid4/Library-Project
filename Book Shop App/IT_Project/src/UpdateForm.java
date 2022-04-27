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

public class UpdateForm extends JFrame {

	private JPanel contentPane;
	private JTextField NameField;
	private JTextField TypeField;
	private JTextField PriceField;

	
	public static void run() {
		
		UpdateForm frame = new UpdateForm();
		frame.setVisible(true);
	}	

	
	public UpdateForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 259, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = Color.PINK;
		gradientPanel.setkStartColor(Color.PINK);
		gradientPanel.kEndColor = Color.CYAN;
		gradientPanel.setkEndColor(Color.CYAN);
		gradientPanel.setBounds(0, 0, 243, 187);
		contentPane.add(gradientPanel);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 11, 46, 14);
		gradientPanel.add(lblNewLabel);
		
		JLabel lblType = new JLabel("Type");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblType.setBounds(20, 55, 46, 14);
		gradientPanel.add(lblType);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice.setBounds(20, 98, 46, 14);
		gradientPanel.add(lblPrice);
		
		NameField = new JTextField();
		NameField.setForeground(Color.WHITE);
		NameField.setOpaque(false);
		NameField.setColumns(10);
		NameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		NameField.setBounds(20, 24, 204, 20);
		gradientPanel.add(NameField);
		
		TypeField = new JTextField();
		TypeField.setForeground(Color.WHITE);
		TypeField.setOpaque(false);
		TypeField.setColumns(10);
		TypeField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		TypeField.setBounds(20, 67, 204, 20);
		gradientPanel.add(TypeField);
		
		PriceField = new JTextField();
		PriceField.setForeground(Color.WHITE);
		PriceField.setOpaque(false);
		PriceField.setColumns(10);
		PriceField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		PriceField.setBounds(20, 111, 204, 20);
		gradientPanel.add(PriceField);
		
		KButton UpdateBTN = new KButton();
		UpdateBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NameField.getText().length()>0 && TypeField.getText().length()>0 && PriceField.getText().length()>0) {
					try {
						String name=NameField.getText();
						String type=TypeField.getText();
						double price=Double.parseDouble(PriceField.getText());
						conectDatabase.updateBook(BookShop.getIdOfSelectedRow(), name, type, price);
						BookShop.updateTable(name, type, price);
					}catch(Exception q) {
						JOptionPane.showMessageDialog(UpdateBTN,"price should a number !!!");
					}
				}else {
					JOptionPane.showMessageDialog(UpdateBTN, "Fill the blanks !!!");
				}
			}
		});
		UpdateBTN.kStartColor = new Color(233, 150, 122);
		UpdateBTN.setkStartColor(new Color(233, 150, 122));
		UpdateBTN.setText("Update");
		UpdateBTN.setFocusable(false);
		UpdateBTN.setBorder(null);
		UpdateBTN.kHoverStartColor = SystemColor.activeCaption;
		UpdateBTN.setkHoverStartColor(SystemColor.activeCaption);
		UpdateBTN.kHoverForeGround = new Color(230, 230, 250);
		UpdateBTN.setkHoverForeGround(new Color(230, 230, 250));
		UpdateBTN.kHoverEndColor = SystemColor.textHighlight;
		UpdateBTN.setkHoverEndColor(SystemColor.textHighlight);
		UpdateBTN.kEndColor = Color.PINK;
		UpdateBTN.setkEndColor(Color.PINK);
		UpdateBTN.kBorderRadius = 30;
		UpdateBTN.setkBorderRadius(30);
		UpdateBTN.setBounds(71, 142, 97, 28);
		gradientPanel.add(UpdateBTN);
		setResizable(false);
	}
}
