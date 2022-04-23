
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Nuevo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private static ConexionSQL CSQL=new ConexionSQL();
	private JPasswordField pw;
	private JPasswordField pwConfimacion;

	//Metodos
	public String getUsuario() {
		
		String user = txtUsuario.getText();
		return(user);
	}
	public String getPass() {
		String clavefinal="";
		String Clave = new String(pw.getPassword());
		String Clave2 = new String(pwConfimacion.getPassword());
		if(Clave.equals(Clave2)==true) {
			 clavefinal = new String(Clave);
		}
		return(clavefinal);
	}
	public String getNombre() {
		 String valor = txtNombre.getText();
		return(valor);
	}
	public String getApellidos() {
		String valor = txtApellidos.getText();
		return(valor);
	}
	public String getEmail() {
		String valor = txtEmail.getText();
		return(valor);
	}
	public String getTelefono() {
		String valor = txtTelefono.getText();
		return(valor);
	}
	public void clean() {
		txtUsuario.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtEmail.setText("");
		txtTelefono.setText("");
		pw.setText("");
		pwConfimacion.setText("");
	}
	public boolean validobg() {
		boolean rs=false;
		if(getUsuario().equals("") || getNombre().equals("") || getApellidos().equals("") || getEmail().equals("") || getTelefono().equals("")){
			JOptionPane.showMessageDialog(null,"Todos los campos deben ser completados","ERROR",JOptionPane.ERROR_MESSAGE);
		}else {
			if(getPass().equals("")) {
				JOptionPane.showMessageDialog(null,"Contraseñas Erroneas","ERROR",JOptionPane.ERROR_MESSAGE);
			}else {
				CSQL.crearuser(getUsuario(), getPass(), getNombre(), getApellidos(), getEmail(), getTelefono());
				rs=true;
			}
		}
		return rs;
	}
	/**
	 * Launch the application.
	 */
	
	//Constuctores
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nuevo frame = new Nuevo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Nuevo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creacion de Usuario");
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD, 17));
		lblNewLabel.setBounds(124, 11, 190, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(102, 51, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(81, 76, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Confirmar contrase\u00F1a:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 101, 157, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre:");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(102, 129, 65, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Apellidos:");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(98, 154, 69, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Email:");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(125, 179, 42, 14);
		contentPane.add(lblNewLabel_1_5);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(204, 49, 190, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(null);
		txtNombre.setColumns(10);
		txtNombre.setBounds(204, 127, 190, 20);
		contentPane.add(txtNombre);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(204, 152, 190, 20);
		contentPane.add(txtApellidos);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(204, 177, 190, 20);
		contentPane.add(txtEmail);
		
		JButton Nuevouser = new JButton("CREAR");
		Nuevouser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validobg()==true) {
					JOptionPane.showMessageDialog(null,"Usuario Creado satisfactoriamente.","DONE",JOptionPane.INFORMATION_MESSAGE);
					clean();
					Datos da = new Datos();
					dispose();
				}	
			}
		});
		Nuevouser.setFont(new Font("Tahoma", Font.BOLD, 15));
		Nuevouser.setBackground(UIManager.getColor("List.selectionBackground"));
		Nuevouser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Nuevouser.setBounds(109, 255, 89, 23);
		contentPane.add(Nuevouser);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(204, 202, 190, 20);
		contentPane.add(txtTelefono);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Telefono:");
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_5_1.setBounds(98, 204, 69, 14);
		contentPane.add(lblNewLabel_1_5_1);
		
		pw = new JPasswordField();
		pw.setBounds(204, 74, 190, 20);
		contentPane.add(pw);
		
		pwConfimacion = new JPasswordField();
		pwConfimacion.setBounds(204, 99, 190, 20);
		contentPane.add(pwConfimacion);
		
		JButton Volver = new JButton("VOLVER");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		Volver.setFont(new Font("Tahoma", Font.BOLD, 15));
		Volver.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Volver.setBackground(UIManager.getColor("List.selectionBackground"));
		Volver.setBounds(257, 255, 89, 23);
		contentPane.add(Volver);
		
	}
}
