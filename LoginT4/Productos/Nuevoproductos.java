import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class Nuevoproductos extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private static ConexionSQL CSQL=new ConexionSQL();
	private JTextField textCantidad;

	/*Metodos*/

	public String getNombre() {
		 String valor = txtNombre.getText();
		return(valor);
	}
	public String getmarca() {
		String valor = txtMarca.getText();
		return(valor);
	}
	public String getCategoria() {
		String valor = txtCategoria.getText();
		return(valor);
	}
	public String getPrecio(){
		String valor = txtPrecio.getText();
		return(valor);
	}
	public String getCantidad(){
		String valor = textCantidad.getText();
		return(valor);
	}
	public void clean() {
		
		txtNombre.setText("");
		txtMarca.setText("");
		txtCategoria.setText("");
		txtPrecio.setText("");
		textCantidad.setText("");
	}
	public boolean validobg() {
		boolean rs=false;
		if(getNombre().equals("") || getmarca().equals("") || getCategoria().equals("") || getPrecio().equals("")){
			JOptionPane.showMessageDialog(null,"Todos los campos deben ser completados","ERROR",JOptionPane.ERROR_MESSAGE);
		}else {
			
				CSQL.Nuevoproducto(getNombre(), getmarca(), getCategoria(), getPrecio(), getCantidad());
				rs=true;
			
		}
		return rs;
	}

	//constructor
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nuevoproductos frame = new Nuevoproductos();
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
	public Nuevoproductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo producto");
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD, 17));
		lblNewLabel.setBounds(59, 30, 190, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre:");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(27, 73, 65, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Marca:");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(27, 97, 69, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Categoria:");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(27, 121, 96, 14);
		contentPane.add(lblNewLabel_1_5);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(null);
		txtNombre.setColumns(10);
		txtNombre.setBounds(133, 72, 190, 20);
		contentPane.add(txtNombre);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(133, 96, 190, 20);
		contentPane.add(txtMarca);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(133, 120, 190, 20);
		contentPane.add(txtCategoria);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(133, 144, 190, 20);
		contentPane.add(txtPrecio);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Precio:");
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_5_1.setBounds(27, 145, 69, 14);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("Cantidad:");
		lblNewLabel_1_5_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_5_1_1.setBounds(27, 169, 96, 14);
		contentPane.add(lblNewLabel_1_5_1_1);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(133, 168, 190, 20);
		contentPane.add(textCantidad);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validobg()==true) {
					JOptionPane.showMessageDialog(null,"Usuario Creado satisfactoriamente.","DONE",JOptionPane.INFORMATION_MESSAGE);
					clean();
					Datosproductos da = new Datosproductos();
					dispose();
				}	
			}
		});
		btnNewButton.setIcon(new ImageIcon("img/save.png"));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setBounds(37, 209, 58, 42);
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
		btnNewButton_1.setBounds(105, 209, 58, 42);
		contentPane.add(btnNewButton_1);
		
	}
}
