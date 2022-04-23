
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class Datosproductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel2;
	static ConexionSQL sql=new ConexionSQL();
	static String [] titulo = {"ID", "Nombre", "Marca", "Categoria", "Precio","Cantidad"};
	static DefaultTableModel dtm = new DefaultTableModel(null, titulo);
	private JTable table2;
	private JButton update;
	private JButton Delete;
	private JButton Close;
	private JButton btnNuevo;
	/**
	 * Launch the application.
	 * @return 
	 */
	//metodos
	public void eliminarrow() {
		int i=dtm.getRowCount();
		for(int x=i-1;x>=0;x--) {
			dtm.removeRow(x);
		}
	}
	public void actualizar() {
		eliminarrow();
		sql.getAll_Productos(dtm);
	}
	public void design(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 380);
		contentPanel2 = new JPanel();
		contentPanel2.setBackground(new Color(0, 153, 204));
		contentPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel2);
		contentPanel2.setLayout(null);
		
		table2 = new JTable(dtm);
	
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table2.setDropMode(DropMode.ON);
		table2.setForeground(Color.WHITE);
		table2.setFont(new Font("Tahoma", Font.BOLD, 11));
		table2.setGridColor(Color.WHITE);
		table2.setBackground(SystemColor.desktop);
		table2.setBounds(10, 62, 932, 210);
		table2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.WHITE));
		contentPanel2.add(table2);
		
		JLabel lblNewLabel = new JLabel("Datos de los Productos");
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD, 25));
		lblNewLabel.setBounds(364, 11, 313, 40);
		contentPanel2.add(lblNewLabel);
		
		JButton volver = new JButton("VOLVER");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarrow();
				dispose();
				Gestion pd = new Gestion();
				pd.setVisible(true);
			}
		});
		volver.setFont(new Font("Arial", Font.BOLD, 15));
		volver.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		volver.setBackground(UIManager.getColor("List.selectionBackground"));
		volver.setBounds(856, 293, 86, 23);
		contentPanel2.add(volver);
		
		update = new JButton("ACTUALIZAR");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarProductos au = new ActualizarProductos();
				au.setVisible(true);
			}
			
		});
		update.setFont(new Font("Arial", Font.BOLD, 15));
		update.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		update.setBackground(UIManager.getColor("List.selectionBackground"));
		update.setBounds(237, 293, 126, 23);
		contentPanel2.add(update);
		
		Delete = new JButton("ELIMINAR");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EliminarProductos eu = new EliminarProductos();
				eu.setVisible(true);
			}
		});
		Delete.setFont(new Font("Arial", Font.BOLD, 15));
		Delete.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Delete.setBackground(UIManager.getColor("List.selectionBackground"));
		Delete.setBounds(441, 293, 126, 23);
		contentPanel2.add(Delete);
		
		Close = new JButton("");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				principal pd = new principal();
				pd.setVisible(true);
			}
		});
		Close.setIcon(new ImageIcon("img/logout.png"));
		Close.setFont(new Font("Arial", Font.BOLD, 15));
		Close.setBorder(null);
		Close.setBackground(new Color(0, 153, 204));
		Close.setBounds(902, 11, 40, 40);
		contentPanel2.add(Close);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuevoproductos rg = new Nuevoproductos();
				rg.setVisible(true);
			}
		});
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 15));
		btnNuevo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNuevo.setBackground(UIManager.getColor("List.selectionBackground"));
		btnNuevo.setBounds(34, 294, 126, 23);
		contentPanel2.add(btnNuevo);
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datosproductos frame = new Datosproductos();
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
	public Datosproductos() {
		design();
		actualizar();
	}
}
