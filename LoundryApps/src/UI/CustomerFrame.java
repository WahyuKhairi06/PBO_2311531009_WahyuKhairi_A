package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CustomersRepo;
import Model.Customers;
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

public class CustomerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAddress;
	private JTextField txtHp;
	private JTextField txtName;
	private JTable tableCustomers;
	
	CustomersRepo cstr = new CustomersRepo();
	List<Customers> ls;
	String id;
	
	public void reset() {
		txtName.setText("");
		txtAddress.setText("");
		txtHp.setText("");
	}
	public void loadTable() {
		ls = cstr.show();
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
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
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
				Customers customers = new Customers();
				customers.setNama(txtName.getText());
				customers.setAlamat(txtAddress.getText());
				customers.setHp(txtHp.getText());
				reset();
				cstr.save(customers);
				loadTable();
			}
		});
		btnSave.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSave.setBounds(112, 156, 75, 25);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					cstr.delete(id);
					reset();
					loadTable();
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
				}
			}
		});
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDelete.setBounds(333, 156, 75, 25);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customers customers = new Customers();
				customers.setNama(txtName.getText());
				customers.setAlamat(txtAddress.getText());
				customers.setHp(txtHp.getText());
				customers.setId(id);
				cstr.update(customers);
				reset();
				loadTable();
			}
		});
		btnUpdate.setBackground(new Color(0, 128, 255));
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnUpdate.setBounds(216, 156, 75, 25);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 441, 267);
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
			}
		});
		tableCustomers.setFont(new Font("SansSerif", Font.PLAIN, 12));
	}
}