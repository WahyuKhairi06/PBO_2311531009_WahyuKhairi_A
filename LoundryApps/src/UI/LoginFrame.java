package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Error.ValidationException;
import Model.User;
import Service.LoginService;
import Util.ValidationUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 435);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(119, 131, 226, 27);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(122, 106, 84, 14);
		contentPane.add(lblNewLabel);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(119, 205, 226, 27);
		contentPane.add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBounds(119, 180, 84, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String userValue = txtUsername.getText();
			    String passValue = txtPassword.getText();
			    // Create user object
			    User user = new User(userValue, passValue);
			    try {
			        ValidationUtil.validate(user);
			        LoginService loginService = new LoginService();
			        if (loginService.authenticate(user)) {
			            System.out.println("Login successful!");
			            new MainFrame().setVisible(true);
			            dispose();
			        } else {
			            System.out.println("Invalid username or password.");
			            JOptionPane.showMessageDialog(null, "Login Gagal, Invalid username or password.");
			        }
			    } catch (ValidationException | NullPointerException exception) {
			        System.out.println("Data tidak valid: " + exception.getMessage());
			        JOptionPane.showMessageDialog(null, "Login Gagal: " + exception.getMessage());
			    } finally {
			        System.out.println("Selalu di eksekusi");
			    }
			}
		});
	
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setForeground(new Color(0, 0, 255));
		btnLogin.setBounds(119, 266, 226, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("KHUMAR LOUNDRY");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(101, 0, 254, 65);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\"Baju Anda Kotor? Tenang Kami cuci Sampai Suci\"");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(255, 128, 0));
		lblNewLabel_2.setBounds(115, 62, 240, 19);
		contentPane.add(lblNewLabel_2);
	}
}
