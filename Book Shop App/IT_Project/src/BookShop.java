import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import com.k33ptoo.components.KButton;

public class BookShop extends JFrame {
	private JPanel contentPane;
	private static JTextArea Fatora; 
	private static JTable table;
	private static DefaultTableModel model;
	public static void run() {
		BookShop frame = new BookShop();
		frame.setVisible(true);
	}
	public BookShop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(10, 32, 503, 220);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setSelectionForeground(Color.WHITE);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setSelectionBackground(new Color(0, 51, 102));
		table.setRowMargin(0);
		table.setFocusable(false);
		table.setBorder(null);
		table.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Name", "Type", "Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		model=(	 DefaultTableModel ) table.getModel();
		JTableHeader head_of_the_table =table.getTableHeader();
		head_of_the_table.setFont(new Font("Segoe UI",Font.BOLD,14));
		table.setRowHeight(20);
		addBooks_in_the_table() ;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(523, 32, 251, 220);
		contentPane.add(scrollPane);
		
		Fatora = new JTextArea();
		Fatora.setEditable(false);
		scrollPane.setViewportView(Fatora);
		
		KButton SellBtn = new KButton();
		SellBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellBookFrame.run();
			}
		});
		SellBtn.kBorderRadius = 30;
		SellBtn.setFocusable(false);
		SellBtn.setBorder(null);
		SellBtn.kEndColor = new Color(0, 0, 153);
		SellBtn.setBounds(378, 319, 135, 35);
		SellBtn.setText("Add To Card");
		contentPane.add(SellBtn);
		
		KButton AddButton = new KButton();
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddForm.run();
			}
		});
		AddButton.setBounds(10, 263, 135, 35);
		AddButton.setText("Add");
		AddButton.kBorderRadius = 30;
		AddButton.setFocusable(false);
		AddButton.setBorder(null);
		contentPane.add(AddButton);
		
		KButton RemoveBTN = new KButton();
		RemoveBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>-1) {
					int id =Integer.parseInt(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
					conectDatabase.removeBook(id);
					model.removeRow(table.getSelectedRow());
					sort_table();
					conectDatabase.sort_books();
				}else {
					JOptionPane.showMessageDialog(RemoveBTN, "choose a book to remove !!!!");
				}
			}
		});
		RemoveBTN.setBounds(192, 263, 135, 35);
		RemoveBTN.setText("Remove");
		RemoveBTN.kBorderRadius = 30;
		RemoveBTN.setFocusable(false);
		RemoveBTN.setBorder(null);
		contentPane.add(RemoveBTN);
		
		KButton Clear_BTN = new KButton();
		Clear_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(conectDatabase.getBooks().size()>0) {
					RemoveRowsInTheTable();
					conectDatabase.TRUNCATE_BOOKS_TABLE();
				}else {
					JOptionPane.showMessageDialog(Clear_BTN, "No item found");
				}
			}
		});
		Clear_BTN.setBounds(10, 319, 135, 35);
		Clear_BTN.setText("Clear");
		Clear_BTN.kBorderRadius = 30;
		Clear_BTN.setFocusable(false);
		Clear_BTN.setBorder(null);
		contentPane.add(Clear_BTN);
		
		KButton UpdateBTN = new KButton();
		UpdateBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>-1) {
					UpdateForm.run();
				}else {
					JOptionPane.showMessageDialog(UpdateBTN, "Select a row !!");
				}
			}
		});
		UpdateBTN.setBounds(378, 263, 135, 35);
		UpdateBTN.setText("Update");
		UpdateBTN.kBorderRadius = 30;
		UpdateBTN.setFocusable(false);
		UpdateBTN.setBorder(null);
		contentPane.add(UpdateBTN);
		
		KButton Clear = new KButton();
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellBookFrame.setTotal(0.0);
				Fatora.setText("");
			}
		});
		Clear.setBounds(674, 263, 100, 35);
		Clear.setText("Clear");
		Clear.kBorderRadius = 30;
		Clear.setFocusable(false);
		Clear.setBorder(null);
		contentPane.add(Clear);
		
		KButton SaveBtn = new KButton();
		SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Fatora.getText().length()>0) {
					JFileChooser fileChooser = new JFileChooser();
		            int r=fileChooser.showSaveDialog(null);
		            if(r==JFileChooser.APPROVE_OPTION){
		                File file ;
		                file= new File(fileChooser.getSelectedFile().getAbsolutePath());
		                try {
							FileWriter writer = new FileWriter(file);
							writer.write("RECEIPT\n"+Fatora.getText()+"\nTotal >>> "+sellBookFrame.getTotal()+"\nTANKS");
							writer.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
		            }
				}else {
					JOptionPane.showMessageDialog(SaveBtn, "The receipt is empty !!!");
				}
			}
		});
		SaveBtn.setBounds(523, 263, 100, 35);
		SaveBtn.setText("Save");
		SaveBtn.kBorderRadius = 30;
		SaveBtn.setFocusable(false);
		SaveBtn.setBorder(null);
		contentPane.add(SaveBtn);
		
		KButton ExitBtn = new KButton();
		ExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ExitBtn.setBounds(674, 319, 100, 35);
		ExitBtn.setText("Exit");
		ExitBtn.kBorderRadius = 30;
		ExitBtn.setFocusable(false);
		ExitBtn.setBorder(null);
		contentPane.add(ExitBtn);
	}
	public static void addBookInTheTable(Book b) {
		model.addRow(new Object[] {b.getId(),b.getName(),b.getType(),b.getPrice()});
		

	}
	public void addBooks_in_the_table() {
		ArrayList<Book> books=conectDatabase.getBooks();
		for(int i =0 ; i<books.size();i++) {
			model.addRow(new Object[] {books.get(i).getId(),books.get(i).getName(),books.get(i).getType(),books.get(i).getPrice()});
		}
	}
	public void RemoveRowsInTheTable() {
		for(int i =model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
	}
	public static int getIdOfSelectedRow() {
		if(table.getSelectedRow()>-1) {
			return Integer.parseInt(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
		}else {
			return -1;
		}
	}
	public static void updateTable(String name ,String type,double price) {
		try {
			model.setValueAt(name, table.getSelectedRow(), 1);
			model.setValueAt(type, table.getSelectedRow(), 2);
			model.setValueAt(price, table.getSelectedRow(), 3);
		}catch(Exception e ) {
			JOptionPane.showMessageDialog(null, "No row selected !!!!");
		}

	}
	public void sort_table() {
		for(int i =0 ; i<conectDatabase.getBooks().size();i++) {
			model.setValueAt(i+1, i, 0);
		}
	}
	public static JTextArea getFatora() {
		return Fatora;
	}
	public static JTable getTable() {
		return table;
	}
}
