package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ServiceRepo;
import Model.Service;
import Table.TableService;

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

public class ServiceFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHarga;
	private JTextField txtStatus;
	private JTextField txtJenis;
	private JTable tableService;
	
	ServiceRepo srv = new ServiceRepo();
	List<Service> ls;
	String id;
	
	public void reset() {
		txtJenis.setText("");
		txtHarga.setText("");
		txtStatus.setText("");
	}
	public void loadTable() {
		ls = srv.show();
		TableService tu = new TableService(ls);
		tableService.setModel(tu);;
		tableService.getTableHeader().setVisible(true);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceFrame frame = new ServiceFrame();
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
	public ServiceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHarga = new JLabel("Harga");
		lblHarga.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHarga.setBounds(10, 82, 92, 25);
		contentPane.add(lblHarga);
		
		txtHarga = new JTextField();
		txtHarga.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtHarga.setColumns(10);
		txtHarga.setBounds(112, 82, 314, 25);
		contentPane.add(txtHarga);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblStatus.setBounds(10, 117, 92, 25);
		contentPane.add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtStatus.setColumns(10);
		txtStatus.setBounds(112, 121, 314, 25);
		contentPane.add(txtStatus);
		
		JLabel lblJenis = new JLabel("Jenis");
		lblJenis.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblJenis.setBounds(10, 45, 92, 25);
		contentPane.add(lblJenis);
		
		txtJenis = new JTextField();
		txtJenis.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtJenis.setColumns(10);
		txtJenis.setBounds(112, 45, 314, 25);
		contentPane.add(txtJenis);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(0, 255, 0));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service service = new Service();
				service.setJenis(txtJenis.getText());
				service.setHarga(txtHarga.getText());
				service.setStatus(txtStatus.getText());
				reset();
				srv.save(service);
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
					srv.delete(id);
					reset();
					loadTable();
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
				}
			}
		});
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDelete.setBounds(351, 156, 75, 25);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service service = new Service();
				service.setJenis(txtJenis.getText());
				service.setHarga(txtHarga.getText());
				service.setStatus(txtStatus.getText());
				service.setId(id);
				srv.update(service);
				reset();
				loadTable();
			}
		});
		btnUpdate.setBackground(new Color(0, 128, 255));
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnUpdate.setBounds(229, 156, 75, 25);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 441, 267);
		scrollPane.setViewportView(tableService);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
		tableService = new JTable();
		tableService.setToolTipText("");
		tableService.setFillsViewportHeight(true);
		tableService.setBackground(new Color(255, 255, 255));
		tableService.setBounds(10, 200, 416, 232);
		scrollPane.setViewportView(tableService);
		tableService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableService.getValueAt(tableService.getSelectedRow(),0).toString();
				txtJenis.setText(tableService.getValueAt(tableService.getSelectedRow(),1).toString());
				txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(),2).toString());
				txtStatus.setText(tableService.getValueAt(tableService.getSelectedRow(),3).toString());
			}
		});
		tableService.setFont(new Font("SansSerif", Font.PLAIN, 12));
	}
}