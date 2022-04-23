import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtUsuario;
	private static JPasswordField txtPassword;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton Iniciar;
	private Registrar Rg=new Registrar();
	private Gestion gt=new Gestion();
	private static ConexionSQL CSQL=new ConexionSQL();

	/**
	 * Launch the application.
	 */
	public static String getUsuario() {
		
		String user = txtUsuario.getText();
		return(user);
	}
	public static String getPassword() {
		
		char[] Clave = txtPassword.getPassword();
		String clavefinal = new String(Clave);
		return(clavefinal);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(170, 11, 81, 64);
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(148, 86, 178, 20);
		txtUsuario.setToolTipText("");
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(148, 116, 178, 20);
		contentPane.add(txtPassword);
		
		lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setBounds(66, 86, 67, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setBounds(40, 119, 98, 13);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2);
		
		Iniciar = new JButton("INICIAR");
		Iniciar.setFont(new Font("Arial", Font.BOLD, 15));
		Iniciar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Iniciar.setBackground(UIManager.getColor("List.selectionBackground"));
		Iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		if(CSQL.Validaruser(getUsuario(), getPassword())==true) {
			dispose();//cerramos actual
			gt.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null,"Debe ingresar su usuario y contraseña, si no está registrado debe registrarse.","ERROR",JOptionPane.ERROR_MESSAGE);
		}
			
	 }
	});
		Iniciar.setBounds(110, 182, 85, 21);
		contentPane.add(Iniciar);
		
		JButton Registrar = new JButton("REGISTRARSE");
		Registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Rg.setVisible(true);
			}
		});
		Registrar.setBackground(UIManager.getColor("List.selectionBackground"));
		Registrar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Registrar.setFont(new Font("Arial", Font.BOLD, 15));
		Registrar.setBounds(217, 181, 126, 23);
		contentPane.add(Registrar);
	}
}
