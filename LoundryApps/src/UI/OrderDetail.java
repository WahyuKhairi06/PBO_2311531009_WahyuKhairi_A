package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ServiceRepo;
import Model.Service;
import Table.TableService;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.Color;
public class OrderDetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableTotal;
	private JTextField txtHarga;
	private JTextField txtJumlah;
	private JTextField txtTotal;
	private JTextField txtOrderID;
	private JTextField txtTanggal;
	private JTextField txtTanggalPembelian;

	
	ServiceRepo srv = new ServiceRepo();
	List<Service> ls;
	String id;
	private JTable tableService;
	
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
					OrderDetail frame = new OrderDetail();
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
	public OrderDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 11, 206, 529);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblOrderID = new JLabel("Order ID");
		lblOrderID.setBounds(10, 11, 72, 14);
		panel1.add(lblOrderID);
		
		txtOrderID = new JTextField();
		txtOrderID.setBounds(10, 25, 186, 20);
		panel1.add(txtOrderID);
		txtOrderID.setColumns(10);
		
		JLabel lblPelanggan = new JLabel("Pelanggan");
		lblPelanggan.setBounds(10, 52, 65, 14);
		panel1.add(lblPelanggan);
		
		JComboBox cbPelanggan = new JComboBox();
		cbPelanggan.setBounds(10, 66, 186, 22);
		panel1.add(cbPelanggan);
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setBounds(10, 94, 65, 14);
		panel1.add(lblTanggal);
		
		txtTanggal = new JTextField();
		txtTanggal.setColumns(10);
		txtTanggal.setBounds(10, 110, 186, 20);
		panel1.add(txtTanggal);
		
		JLabel lblTanggalPembelian = new JLabel("Tanggal Pembelian");
		lblTanggalPembelian.setBounds(10, 137, 116, 14);
		panel1.add(lblTanggalPembelian);
		
		txtTanggalPembelian = new JTextField();
		txtTanggalPembelian.setColumns(10);
		txtTanggalPembelian.setBounds(10, 154, 186, 20);
		panel1.add(txtTanggalPembelian);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 185, 116, 14);
		panel1.add(lblStatus);
		
		JComboBox cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Proses", "Selesai"}));
		cbStatus.setBounds(10, 201, 186, 22);
		panel1.add(cbStatus);
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setBounds(10, 237, 46, 14);
		panel1.add(lblNewLabel);
		
		JLabel lblRp = new JLabel("RP. 10.000");
		lblRp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRp.setBounds(10, 248, 97, 22);
		panel1.add(lblRp);
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setBounds(10, 281, 97, 14);
		panel1.add(lblPembayaran);
		
		JComboBox cbPembayaran = new JComboBox();
		cbPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Qris", "Debit", "Kredit", "Paylater"}));
		cbPembayaran.setBounds(10, 299, 186, 22);
		panel1.add(cbPembayaran);
		
		JLabel lblStatusPembayaran = new JLabel("Status Pembayaran");
		lblStatusPembayaran.setBounds(10, 333, 97, 14);
		panel1.add(lblStatusPembayaran);
		
		JComboBox cbStatusPembayran = new JComboBox();
		cbStatusPembayran.setModel(new DefaultComboBoxModel(new String[] {"Lunas", "Ngutang"}));
		cbStatusPembayran.setBounds(10, 350, 186, 22);
		panel1.add(cbStatusPembayran);
		
		JButton btnSimpanOrder = new JButton("Simpan");
		btnSimpanOrder.setBounds(10, 405, 89, 23);
		panel1.add(btnSimpanOrder);
		
		JButton btnBatalOrder = new JButton("Batal");
		btnBatalOrder.setBounds(107, 405, 89, 23);
		panel1.add(btnBatalOrder);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(226, 148, 432, 134);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblHarga = new JLabel("Harga/kg");
		lblHarga.setBounds(10, 11, 62, 14);
		panel2.add(lblHarga);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setBounds(10, 50, 46, 14);
		panel2.add(lblJumlah);
		
		txtHarga = new JTextField();
		txtHarga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(),2).toString());
			}
		});
		txtHarga.setBounds(10, 25, 210, 20);
		panel2.add(txtHarga);
		txtHarga.setColumns(10);
		
		txtJumlah = new JTextField();
		txtJumlah.setColumns(10);
		txtJumlah.setBounds(10, 65, 210, 20);
		panel2.add(txtJumlah);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(229, 50, 46, 14);
		panel2.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(230, 65, 192, 20);
		panel2.add(txtTotal);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setBounds(10, 100, 89, 23);
		panel2.add(btnSimpan);
		
		JButton btnUbah = new JButton("Ubah");
		btnUbah.setBounds(109, 100, 89, 23);
		panel2.add(btnUbah);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.setBounds(208, 100, 89, 23);
		panel2.add(btnHapus);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setBounds(307, 100, 89, 23);
		panel2.add(btnBatal);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(226, 298, 432, 242);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		tableTotal = new JTable();
		tableTotal.setBackground(new Color(255, 255, 255));
		tableTotal.setBounds(0, 0, 430, 242);
		panel3.add(tableTotal);
		
		JLabel lblLayanan = new JLabel("Layanan");
		lblLayanan.setBounds(230, 7, 74, 14);
		contentPane.add(lblLayanan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 20, 432, 113);
		contentPane.add(scrollPane);
		
		tableService = new JTable();
		tableService.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableService);
	}
}
