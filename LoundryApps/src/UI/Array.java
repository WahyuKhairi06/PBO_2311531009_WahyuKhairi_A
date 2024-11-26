package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Array extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textData;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
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
	public Array() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Masukkan Data :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 32, 134, 24);
		contentPane.add(lblNewLabel);
		
		textData = new JTextField();
		textData.setBounds(10, 67, 294, 20);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setBounds(324, 66, 89, 23);
		contentPane.add(btnSimpan);
		
		JLabel lblNewLabel_1 = new JLabel("Data :");
		lblNewLabel_1.setBounds(10, 98, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Check Array ke -");
		lblNewLabel_1_1.setBounds(10, 146, 102, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(105, 143, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCheck = new JButton("Simpan");
		btnCheck.setBounds(324, 142, 89, 23);
		contentPane.add(btnCheck);
	}
}
