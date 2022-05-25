package LabHomework;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListFrame frame = new ListFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public ListFrame() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FileReader file1 = new FileReader("C:\\Users\\yusuf kerem\\Desktop\\homework.txt");
        BufferedReader buffer1 = new BufferedReader(file1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 112, 429, 221);
		contentPane.add(scrollPane);
		
		final DefaultTableModel model = new DefaultTableModel();
		
		String[] columns = new String[] {"ID","Customer","Brand","CPU"};
		model.setColumnIdentifiers(columns);
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		 MainFrame mf = new MainFrame();
	        for (Computer c : mf.CList) {
	        	
	        	String[] str = new String[5];
	        	
	        	str[0]=Integer.toString(c.id);
	        	str[1]=c.CustomerName.toString();
	        	str[2]=c.ComputerBrand.toString();
	        	str[3]=c.CPU.toString();
	        	model.addRow(str);
	        	
			}
		
	}
}
