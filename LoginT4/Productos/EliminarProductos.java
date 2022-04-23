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

public class EliminarProductos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarProductos frame = new EliminarProductos();
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
			if((txtID.getText()=="")){
				JOptionPane.showMessageDialog(null,"Campos vacios","ERROR",JOptionPane.ERROR_MESSAGE);
			}else {
				valid = true;
			}
			
			return valid;
		}
	
	//constructor
	public EliminarProductos() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 315, 218);
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
							if(Sql.DeleteProducto(txtID.getText()) == true) {
								JOptionPane.showMessageDialog(null,"Usuario Eliminado","Eliminado",JOptionPane.INFORMATION_MESSAGE);
								Datosproductos da = new Datosproductos();
								dispose();
							}
						}
				}
			});
			btnNewButton.setIcon(new ImageIcon("img/save.png"));
			btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			btnNewButton.setBackground(new Color(0, 153, 153));
			btnNewButton.setBounds(93, 92, 58, 42);
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
			btnNewButton_1.setBounds(161, 92, 58, 42);
			contentPane.add(btnNewButton_1);
			
			txtID = new JTextField();
			txtID.setText("ID");
			txtID.setHorizontalAlignment(SwingConstants.CENTER);
			txtID.setColumns(10);
			txtID.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			txtID.setBounds(67, 31, 174, 29);
			contentPane.add(txtID);
		}

}
