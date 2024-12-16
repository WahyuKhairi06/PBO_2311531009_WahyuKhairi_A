package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import DAO.CustomersRepo;
import listener.DataListener;
import Model.Customers;
import Table.TableCustomers;

public class DialogPelanggan extends JDialog {
	private DataListener listener;
	CustomersRepo usr = new CustomersRepo();
	List<Customers> ls;
	public String id;
	private JTable tablePelanggan;
	
	public DialogPelanggan(DataListener listener) {
		this.listener = listener;
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setSize(660, 377);
		setLocationRelativeTo(null);
		setTitle("Data Pelanggan");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(10, 10, 626, 192);
		getContentPane().add(scrollPane);
		
		tablePelanggan = new JTable();
		tablePelanggan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listener.onDataReceived(tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(),0).toString(), tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(),1).toString());
//				getData();
				dispose();
			}
		});
		scrollPane.setViewportView(tablePelanggan);
		loadTable();
	}
	
	public void loadTable() {
		ls = usr.show();
		TableCustomers tu = new TableCustomers(ls);
		tablePelanggan.setModel(tu);
		tablePelanggan.getTableHeader().setVisible(true);
	}

}