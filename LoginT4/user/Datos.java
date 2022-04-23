


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Datos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static ConexionSQL sql=new ConexionSQL();
	static String [] titulo = {"ID", "Nombre", "Apellidos", "Email", "Telefono"};
	static DefaultTableModel dtm = new DefaultTableModel(null, titulo);
	private JTable table;
	private JButton update;
	private JButton Delete;
	private JButton Close;
	private JButton btnNuevo;
	/**
	 * Launch the application.
	 * @return 
	 */
	//MEtodos
	public void eliminarrow() {
		int i=dtm.getRowCount();
		for(int x=i-1;x>=0;x--) {
			dtm.removeRow(x);
		}
	}
	public void actualizar() {
		eliminarrow();
		sql.getAll_Usuarios(dtm);
	}
	public void design(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable(dtm);
	
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setDropMode(DropMode.ON);
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setGridColor(Color.WHITE);
		table.setBackground(SystemColor.desktop);
		table.setBounds(10, 62, 932, 210);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.WHITE));
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Datos de los Usuarios");
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD, 25));
		lblNewLabel.setBounds(364, 11, 313, 40);
		contentPane.add(lblNewLabel);
		
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
		contentPane.add(volver);
		
		update = new JButton("ACTUALIZAR");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ActualizarUser au = new ActualizarUser();
				au.setVisible(true);
				
			}
			
		});
		update.setFont(new Font("Arial", Font.BOLD, 15));
		update.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		update.setBackground(UIManager.getColor("List.selectionBackground"));
		update.setBounds(237, 293, 126, 23);
		contentPane.add(update);
		
		Delete = new JButton("ELIMINAR");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EliminarUser eu = new EliminarUser();
				eu.setVisible(true);
				
			}
		});
		Delete.setFont(new Font("Arial", Font.BOLD, 15));
		Delete.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Delete.setBackground(UIManager.getColor("List.selectionBackground"));
		Delete.setBounds(441, 293, 126, 23);
		contentPane.add(Delete);
		
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
		contentPane.add(Close);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuevo rg = new Nuevo();
				rg.setVisible(true);
			}
		});
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 15));
		btnNuevo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNuevo.setBackground(UIManager.getColor("List.selectionBackground"));
		btnNuevo.setBounds(34, 294, 126, 23);
		contentPane.add(btnNuevo);
		
		
	}
		
	//Constructor
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datos frame = new Datos();
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
	public Datos() {
		design();
		actualizar();
	}

}

	
