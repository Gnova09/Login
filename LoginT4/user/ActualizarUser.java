import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActualizarUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtCorreo;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	//constructos
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarUser frame = new ActualizarUser();
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
	//Metodos
	public boolean validarCampos() {
		boolean valid=false;
		if((txtId.getText()=="" || txtNombre.getText()=="" || txtApellidos.getText()=="" || txtCorreo.getText()=="" || txtTelefono.getText()=="")){
			JOptionPane.showMessageDialog(null,"Campos vacios","ERROR",JOptionPane.ERROR_MESSAGE);
		}else {
			valid = true;
		}
		
		return valid;
	}
	public ActualizarUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarCampos()==true) {
			ConexionSQL Sql = new ConexionSQL();
				if(Sql.Updateuser(txtId.getText(), txtNombre.getText(),txtApellidos.getText(), txtCorreo.getText(), txtTelefono.getText()) ==true) {
					JOptionPane.showMessageDialog(null,"Usuario Actualizado","ACTUALIZADO",JOptionPane.INFORMATION_MESSAGE);
					Datos da = new Datos();
					//da.revalidate();
					dispose();
				}
			}
		  }
		});		
		btnNewButton.setIcon(new ImageIcon("img/save.png"));
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setBounds(10, 233, 58, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("img/close.png"));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_1.setBackground(new Color(0, 153, 153));
		btnNewButton_1.setBounds(78, 233, 58, 42);
		contentPane.add(btnNewButton_1);
		
		txtId = new JTextField();
		txtId.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setText("ID");
		txtId.setBounds(62, 11, 174, 29);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setText("Nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(62, 51, 174, 29);
		contentPane.add(txtNombre);
		
		txtApellidos = new JTextField();
		txtApellidos.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidos.setText("Apellidos");
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(62, 91, 174, 29);
		contentPane.add(txtApellidos);
		
		txtCorreo = new JTextField();
		txtCorreo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setText("Correo");
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(62, 131, 174, 29);
		contentPane.add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setText("Telefono");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(62, 171, 174, 29);
		contentPane.add(txtTelefono);
	}

}
