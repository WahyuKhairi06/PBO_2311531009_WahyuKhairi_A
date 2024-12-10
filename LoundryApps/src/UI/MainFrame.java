package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Tugas.Array;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 555);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KHUMAR LOUNDRY");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(42, 22, 385, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnOrder = new JButton("Pesanan");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetailFrame odf = new OrderDetailFrame();
				odf.setVisible(true);
				dispose();
			}		
		});
		btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOrder.setBounds(10, 98, 142, 110);
		contentPane.add(btnOrder);
		
		JButton btnService = new JButton("Layanan");
		btnService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceFrame service = new ServiceFrame();
				service.setVisible(true);
				dispose();
			}
		});
		btnService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnService.setBounds(162, 98, 142, 110);
		contentPane.add(btnService);
		
		JButton btnCustomers = new JButton("Pelanggan");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomersFrame cts = new CustomersFrame();
				cts.setVisible(true);
				dispose();
				
			}
		});
		btnCustomers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCustomers.setBounds(314, 98, 142, 110);
		contentPane.add(btnCustomers);
		
		JButton btnUser = new JButton("Pengguna");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFrame user = new UserFrame();
				user.setVisible(true);
				dispose();
				
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUser.setBounds(10, 226, 142, 110);
		contentPane.add(btnUser);
		
		JButton btnReport = new JButton("Laporan");
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReport.setBounds(162, 226, 142, 110);
		contentPane.add(btnReport);
		
		JButton btnProfil = new JButton("Profil");
		btnProfil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProfil.setBounds(314, 226, 142, 110);
		contentPane.add(btnProfil);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame login = new LoginFrame ();
				login.setVisible(true);
				dispose();
				
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(10, 466, 446, 39);
		contentPane.add(btnExit);
		
		JButton btnTugas = new JButton("Tugas");
		btnTugas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Array arrayframe = new Array();
				arrayframe.setVisible(true);
				dispose();
				
			}
		});
		btnTugas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTugas.setBounds(162, 345, 142, 110);
		contentPane.add(btnTugas);
	}
}
