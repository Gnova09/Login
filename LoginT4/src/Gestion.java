

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Gestion extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion frame = new Gestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Metodos
	public void logout() {
		dispose();
		principal pd = new principal();
		pd.setVisible(true);
	}
	
	public void user() {
		dispose();
		Datos dt = new Datos();
		dt.setVisible(true);
	}
	
	public void productos() {
	dispose();
	Datosproductos dp = new Datosproductos();
	dp.setVisible(true);
	}
	//constructor
	public Gestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Close = new JButton("");
		Close.setIcon(new ImageIcon("img/logout.png"));
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});

		
		Close.setFont(new Font("Arial", Font.BOLD, 15));
		Close.setBorder(null);
		Close.setBackground(new Color(0, 153, 204));
		Close.setBounds(384, 11, 40, 40);
		contentPane.add(Close);
		
		JButton usergestion = new JButton("Gestion de usuarios");
		usergestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user();
			}
		});
		usergestion.setFont(new Font("Arial", Font.BOLD, 15));
		usergestion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		usergestion.setBackground(UIManager.getColor("List.selectionBackground"));
		usergestion.setBounds(113, 93, 189, 21);
		contentPane.add(usergestion);
		
		JButton prodgestion = new JButton("Gestion de Productos");
		prodgestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productos();
			}
		});
		prodgestion.setHorizontalTextPosition(SwingConstants.LEADING);
		prodgestion.setFont(new Font("Arial", Font.BOLD, 15));
		prodgestion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		prodgestion.setBackground(UIManager.getColor("List.selectionBackground"));
		prodgestion.setBounds(113, 232, 189, 21);
		contentPane.add(prodgestion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/productos.png"));
		lblNewLabel.setBounds(158, 147, 115, 74);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/users.png"));
		lblNewLabel_1.setBounds(158, 23, 115, 74);
		contentPane.add(lblNewLabel_1);
	}
}
