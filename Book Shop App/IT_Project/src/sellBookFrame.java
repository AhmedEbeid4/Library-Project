import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import keeptoo.KGradientPanel;
import java.awt.Color;
import com.k33ptoo.components.KButton;

public class sellBookFrame extends JFrame {

	private JPanel contentPane;
	private static double total=0.0;

	public static void run() {
		
		sellBookFrame frame = new sellBookFrame();
		frame.setVisible(true);
				
	}

	
	public sellBookFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 274, 173);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = Color.LIGHT_GRAY;
		gradientPanel.kEndColor = Color.BLUE;
		gradientPanel.setBounds(0, 0, 258, 134);
		contentPane.add(gradientPanel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 22, 155, 22);
		gradientPanel.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(194, 23, 54, 20);
		gradientPanel.add(spinner);
		
		KButton SellBtn = new KButton();
		SellBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(String.valueOf(spinner.getValue()))>0) {
					if(conectDatabase.getBooks().size() >0) {
						Operation n = new Operation(String.valueOf(comboBox.getSelectedItem()),Integer.parseInt(String.valueOf(spinner.getValue())));
						BookShop.getFatora().setText(BookShop.getFatora().getText() +n.getFatora());
						total =total+n.getTotal();
					}else {
						JOptionPane.showMessageDialog(SellBtn, "No item found !!!");
					}
				}else {
					JOptionPane.showMessageDialog(SellBtn, "It should be more than 1 !!!");
				}
			}
			
		});
		SellBtn.kHoverEndColor = Color.BLACK;
		SellBtn.setBorder(null);
		SellBtn.setFocusable(false);
		SellBtn.kHoverForeGround = Color.WHITE;
		SellBtn.kHoverStartColor = Color.BLUE;
		SellBtn.kEndColor = Color.PINK;
		SellBtn.setBounds(68, 85, 118, 38);
		SellBtn.setText("Sell");
		gradientPanel.add(SellBtn);
		for(int i =0 ; i<conectDatabase.getBooksNames().size();i++) {
			comboBox.addItem(conectDatabase.getBooksNames().get(i));
		}
	}
	public static void setTotal(double a) {
		total=a;
	}
	public static double getTotal() {
		return total;
	}
}
