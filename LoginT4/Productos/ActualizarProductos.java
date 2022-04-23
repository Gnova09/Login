import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ActualizarProductos extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarProductos frame = new ActualizarProductos();
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
	//metodo
	public boolean validarCampos() {
		boolean valid=false;
		if((txtId.getText()=="" || txtNombre.getText()=="" || txtMarca.getText()=="" || txtCategoria.getText()=="" || txtPrecio.getText()==""||txtCantidad.getText()=="")){
			JOptionPane.showMessageDialog(null,"Campos vacios","ERROR",JOptionPane.ERROR_MESSAGE);
		}else {
			valid = true;
		}
		
		return valid;
	}
	
	//constructor
	public ActualizarProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 371);
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
				if(Sql.UpdateProducto(txtId.getText(), txtNombre.getText(),txtMarca.getText(), txtCategoria.getText(), txtPrecio.getText(), txtCantidad.getText()) == true) {
					JOptionPane.showMessageDialog(null,"Producto Actualizado","ACTUALIZADO",JOptionPane.INFORMATION_MESSAGE);
					Datosproductos da = new Datosproductos();
					//da.revalidate();
					dispose();
				}
			}
		  }
		});		
		btnNewButton.setIcon(new ImageIcon("img/save.png"));
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setBounds(10, 275, 58, 42);
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
		btnNewButton_1.setBounds(78, 275, 58, 42);
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
		
		txtMarca = new JTextField();
		txtMarca.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtMarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarca.setText("Marca");
		txtMarca.setColumns(10);
		txtMarca.setBounds(62, 91, 174, 29);
		contentPane.add(txtMarca);
		
		txtCategoria = new JTextField();
		txtCategoria.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		txtCategoria.setText("Categoria");
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(62, 131, 174, 29);
		contentPane.add(txtCategoria);
		
		txtPrecio = new JTextField();
		txtPrecio.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecio.setText("Precio");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(62, 171, 174, 29);
		contentPane.add(txtPrecio);
		
		txtCantidad = new JTextField();
		txtCantidad.setText("Cantidad");
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setColumns(10);
		txtCantidad.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtCantidad.setBounds(62, 210, 174, 29);
		contentPane.add(txtCantidad);
	}

}
