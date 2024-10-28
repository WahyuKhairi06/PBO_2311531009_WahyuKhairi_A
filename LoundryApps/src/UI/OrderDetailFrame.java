package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.OrderDetailRepo;
import DAO.ServiceRepo;
import DAO.UserRepo;
import Model.OrderDetail;
import Model.Service;
import Model.User;
import Table.TableOrderDetail;
import Table.TableService;
import Table.TableUser;


import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrderDetailFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHarga;
	private JTextField txtJumlah;
	private JTextField txtJenis;
	private JTextField txtTotal1;
	private JTable TableOrderDetail;
	private JTextField txtTotal2;
	private JTextField txtOrderID;
	private JTextField txtTanggal;
	private JTextField txtTanggalPembelian;
	private JTable tableService;
	private JComboBox<String> cbPelanggan;

	
	ServiceRepo srv = new ServiceRepo();
	List<Service> ls;
	String id;
	
	public void loadTable() {
		ls = srv.show();
		TableService tu = new TableService(ls);
		tableService.setModel(tu);;
		tableService.getTableHeader().setVisible(true);
	}
	
	private double total (double harga, double quantity) {
		return harga * quantity;
	}
	private double hargabagi (double harga, double quantity) {
		return harga / quantity;
	}
	
	OrderDetailRepo odf = new OrderDetailRepo();
	List<OrderDetail> ls_1;
	
	public void loadDataOrderDetail() {
	    ls_1 = odf.show(); // Ambil data dari repo
	    TableOrderDetail tu = new TableOrderDetail(ls_1); // Pastikan ini menggunakan data yang benar
	    TableOrderDetail.setModel(tu);
	    TableOrderDetail.getTableHeader().setVisible(true);
	}
	
	public void reset () {
		txtHarga.setText("");
		txtJenis.setText("");
		txtJumlah.setText("");
		txtTotal2.setText("");
	}

	
	public void loadPelanggan() {
		String cust;
//		for (int i = 0; i < tableUsers.getRowCount(); i++) {
//		    Object value = tableUsers.getValueAt(i, 1); 
//	
//            cust = value.toString();
//            cbPelanggan.addItem(cust); 
//	        
//		}
        cust = "Wahyu Khairi";
        cbPelanggan.addItem(cust);
//        cbPelanggan.addItem(tableUsers.getValueAt(0,1).toString());
        
	}
	
	LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formattedDate = today.format(formatter);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailFrame frame = new OrderDetailFrame();
					frame.setVisible(true);
					frame.loadTable();
					frame.loadPelanggan();
					frame.loadDataOrderDetail();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderDetailFrame() {
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
		txtOrderID.setEditable(false);
		txtOrderID.setText("TRX-001");
		txtOrderID.setBounds(10, 25, 186, 20);
		panel1.add(txtOrderID);
		txtOrderID.setColumns(10);
		
		JLabel lblPelanggan = new JLabel("Pelanggan");
		lblPelanggan.setBounds(10, 52, 65, 20);
		panel1.add(lblPelanggan);
		
		cbPelanggan = new JComboBox();
		cbPelanggan.setModel(new DefaultComboBoxModel(new String[] {"Wahyu Khairi"}));
		cbPelanggan.setBounds(10, 72, 186, 20);
		panel1.add(cbPelanggan);

		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setBounds(10, 94, 65, 20);
		panel1.add(lblTanggal);
		
		txtTanggal = new JTextField();
		txtTanggal.setText("28/10/2024");
		txtTanggal.setColumns(10);
		txtTanggal.setBounds(10, 113, 186, 20);
		panel1.add(txtTanggal);
		
		JLabel lblTanggalPengambilan = new JLabel("Tanggal Pengambilan");
		lblTanggalPengambilan.setBounds(10, 137, 116, 14);
		panel1.add(lblTanggalPengambilan);
		
		txtTanggalPembelian = new JTextField();
		txtTanggalPembelian.setColumns(10);
		txtTanggalPembelian.setBounds(10, 154, 186, 20);
		panel1.add(txtTanggalPembelian);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 185, 116, 14);
		panel1.add(lblStatus);
		
		JComboBox cbStatus = new JComboBox();
		cbStatus.setEditable(true);
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Proses", "Selesai"}));
		cbStatus.setBounds(10, 201, 186, 22);
		panel1.add(cbStatus);
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setBounds(10, 237, 46, 14);
		panel1.add(lblNewLabel);
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setBounds(10, 281, 97, 14);
		panel1.add(lblPembayaran);
		
		JComboBox cbPembayaran = new JComboBox();
		cbPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Qris", "Debit", "Kredit", "Paylater"}));
		cbPembayaran.setBounds(10, 299, 186, 22);
		panel1.add(cbPembayaran);
		
		JLabel lblStatusPembayaran = new JLabel("Status Pembayaran");
		lblStatusPembayaran.setBounds(10, 333, 129, 14);
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
		
		txtTotal1 = new JTextField();
		txtTotal1.setEditable(false);
		txtTotal1.setColumns(10);
		txtTotal1.setBounds(10, 253, 186, 20);
		panel1.add(txtTotal1);
		
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
		txtJumlah.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        try {
		            if (txtJumlah.getText().isEmpty() || txtHarga.getText().isEmpty()) {
		                txtTotal2.setText("");
		                txtTotal1.setText("");
		            } else {
		                double harga = Double.parseDouble(txtHarga.getText());
		                double quantity = Double.parseDouble(txtJumlah.getText());
		                txtTotal2.setText("" + total(harga, quantity));
		                txtTotal1.setText("" + total(harga, quantity));
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter valid numbers in the Harga and Jumlah fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});

		txtJumlah.setColumns(10);
		txtJumlah.setBounds(10, 65, 210, 20);
		panel2.add(txtJumlah);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(229, 50, 46, 14);
		panel2.add(lblTotal);
		
		txtTotal2 = new JTextField();
		txtTotal2.setEditable(false);
		txtTotal2.setColumns(10);
		txtTotal2.setBounds(230, 65, 192, 20);
		panel2.add(txtTotal2);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetail orderdtl = new OrderDetail();
				orderdtl.setJenis(txtJenis.getText());
				orderdtl.setQuantity(txtJumlah.getText());
				orderdtl.setTotal(txtTotal2.getText());
				reset();
				odf.save(orderdtl);
				loadTable();
				loadDataOrderDetail();
			}
		});
		btnSimpan.setBounds(10, 100, 89, 23);
		panel2.add(btnSimpan);
		
		JButton btnUbah = new JButton("Ubah");
		btnUbah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OrderDetail orderdtl = new OrderDetail();
				orderdtl.setJenis(txtJenis.getText());
				orderdtl.setQuantity(txtJumlah.getText());
				orderdtl.setTotal(txtTotal2.getText());
				orderdtl.setId(id);
				odf.update(orderdtl);
				reset();
				loadTable();
				loadDataOrderDetail();
			}
		});
		btnUbah.setBounds(109, 100, 89, 23);
		panel2.add(btnUbah);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					odf.delete(id);
					reset();
					loadTable();
					loadDataOrderDetail();
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
				}
			}
		});
		btnHapus.setBounds(208, 100, 89, 23);
		panel2.add(btnHapus);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame main = new MainFrame();
				main.setVisible(true);
				dispose();
			}
		});
		btnBatal.setBounds(307, 100, 89, 23);
		panel2.add(btnBatal);
		
		JLabel lblJenis = new JLabel("Jenis Layanan");
		lblJenis.setBounds(229, 11, 105, 14);
		panel2.add(lblJenis);
		
		txtJenis = new JTextField();
		txtJenis.setEditable(false);
		txtJenis.setColumns(10);
		txtJenis.setBounds(230, 25, 192, 20);
		panel2.add(txtJenis);
		
		JLabel lblLayanan = new JLabel("Layanan");
		lblLayanan.setBounds(230, 7, 74, 14);
		contentPane.add(lblLayanan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 20, 432, 113);
		contentPane.add(scrollPane);
		
		tableService = new JTable();
		tableService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(),2).toString());
				txtJenis.setText(tableService.getValueAt(tableService.getSelectedRow(),1).toString());
				txtJumlah.setText("");
				txtTotal2.setText("");
			}
		});
		tableService.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableService);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(226, 293, 432, 247);
		contentPane.add(scrollPane_1);
		
		TableOrderDetail = new JTable();
		TableOrderDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = TableOrderDetail.getValueAt(TableOrderDetail.getSelectedRow(),0).toString();
				txtJenis.setText(TableOrderDetail.getValueAt(TableOrderDetail.getSelectedRow(),1).toString());
				txtJumlah.setText(TableOrderDetail.getValueAt(TableOrderDetail.getSelectedRow(),2).toString());
				txtTotal2.setText(TableOrderDetail.getValueAt(TableOrderDetail.getSelectedRow(),3).toString()+".0");
			}
		});
		TableOrderDetail.setFillsViewportHeight(true);
		TableOrderDetail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TableOrderDetail.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(TableOrderDetail);
	}
}
