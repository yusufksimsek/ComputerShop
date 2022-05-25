package LabHomework;	//	C:\Users\yusuf kerem\Desktop

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class OrderFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtCustomer;
	private JTextField txtBrand;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public OrderFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 222, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		File f1 = new File("C:\\Users\\yusuf kerem\\Desktop\\homework.txt");	
		FileWriter writer = new FileWriter(f1);
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(23, 80, 46, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(93, 77, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(23, 145, 46, 14);
		contentPane.add(lblCustomer);
		
		txtCustomer = new JTextField();
		txtCustomer.setBounds(93, 142, 86, 20);
		contentPane.add(txtCustomer);
		txtCustomer.setColumns(10);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(23, 222, 46, 14);
		contentPane.add(lblBrand);
		
		txtBrand = new JTextField();
		txtBrand.setBounds(93, 219, 86, 20);
		contentPane.add(txtBrand);
		txtBrand.setColumns(10);
		
		JLabel lblCPU = new JLabel("CPU");
		lblCPU.setBounds(23, 303, 46, 14);
		contentPane.add(lblCPU);
		
		JComboBox cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"Intel", "AMD"}));
		cb.setBounds(93, 299, 86, 22);
		contentPane.add(cb);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Computer cp = new Computer();
				
				cp.id = Integer.parseInt(txtId.getText());
				cp.CustomerName = txtCustomer.getText();
				cp.ComputerBrand = txtBrand.getText();
				cp.CPU = cb.getSelectedItem().toString();
				
				MainFrame.CList.add(cp);
				
				try {
					FileWriter writer = new FileWriter(f1,true);
					BufferedWriter bfwrite = new BufferedWriter(writer);
					
					bfwrite.write(cp.id);
					bfwrite.newLine();
					bfwrite.write(cp.CustomerName);
					bfwrite.newLine();
					bfwrite.write(cp.ComputerBrand);
					bfwrite.newLine();
					bfwrite.write(cp.CPU+"");
					
					bfwrite.close();
					JOptionPane.showMessageDialog(btnSave, "SAVED!");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSave.setBounds(47, 360, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnBack.setBounds(47, 394, 89, 23);
		contentPane.add(btnBack);
	}
}
