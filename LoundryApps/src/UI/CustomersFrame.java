package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CustomersRepo;
import Model.Customers;
import Model.CustomerBuilder;
import Table.TableCustomers;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class CustomersFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAddress;
	private JTextField txtHp;
	private JTextField txtName;
	private JTable tableCustomers;
	
	CustomersRepo cs = new CustomersRepo();
	List<Customers> ls;
	String id;
	private JTextField txtEmail;
	
	public void reset() {
		txtName.setText("");
		txtAddress.setText("");
		txtHp.setText("");
		txtEmail.setText("");
	}
	public void loadTable() {
		ls = cs.show();
		TableCustomers tu = new TableCustomers(ls);
		tableCustomers.setModel(tu);;
		tableCustomers.getTableHeader().setVisible(true);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomersFrame frame = new CustomersFrame();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomersFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAddress.setBounds(10, 82, 92, 25);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtAddress.setColumns(10);
		txtAddress.setBounds(112, 82, 314, 25);
		contentPane.add(txtAddress);
		
		JLabel lblHp = new JLabel("No.Hp");
		lblHp.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHp.setBounds(10, 117, 92, 25);
		contentPane.add(lblHp);
		
		txtHp = new JTextField();
		txtHp.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtHp.setColumns(10);
		txtHp.setBounds(112, 121, 314, 25);
		contentPane.add(txtHp);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName.setBounds(10, 45, 92, 25);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtName.setColumns(10);
		txtName.setBounds(112, 45, 314, 25);
		contentPane.add(txtName);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(0, 255, 0));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customers customers = new CustomerBuilder()
						.setNama(txtName.getText())
						.setAlamat(txtAddress.getText())
						.setHp(txtHp.getText())
						.setEmail(txtEmail.getText())
						.build();
				cs.save(customers);
				reset();
				loadTable();
			}
		});
		btnSave.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSave.setBounds(112, 196, 75, 25);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					cs.delete(id);
					reset();
					loadTable();
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
				}
			}
		});
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDelete.setBounds(282, 196, 75, 25);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customers customers = new Customers("","","","","");
				customers.setNama(txtName.getText());
				customers.setAlamat(txtAddress.getText());
				customers.setHp(txtHp.getText());
				customers.setEmail(txtEmail.getText());
				customers.setId(id);
				cs.update(customers);
				reset();
				loadTable();
			}
		});
		btnUpdate.setBackground(new Color(0, 128, 255));
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnUpdate.setBounds(197, 196, 75, 25);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 441, 234);
		scrollPane.setViewportView(tableCustomers);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
		tableCustomers = new JTable();
		tableCustomers.setToolTipText("");
		tableCustomers.setFillsViewportHeight(true);
		tableCustomers.setBackground(new Color(255, 255, 255));
		tableCustomers.setBounds(10, 200, 416, 232);
		scrollPane.setViewportView(tableCustomers);
		tableCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableCustomers.getValueAt(tableCustomers.getSelectedRow(),0).toString();
				txtName.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(),1).toString());
				txtAddress.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(),2).toString());
				txtHp.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(),3).toString());
				txtEmail.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(),4).toString());
			}
		});
		tableCustomers.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(112, 157, 314, 25);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEmail.setBounds(10, 153, 92, 25);
		contentPane.add(lblEmail);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame main = new MainFrame();
				main.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBack.setBackground(new Color(128, 128, 128));
		btnBack.setBounds(367, 196, 75, 25);
		contentPane.add(btnBack);
	}
}