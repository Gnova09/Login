

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConexionSQL {
	private static Connection SqlCn;
	private String Nombre_db ="login_database";
	private String usuario ="root";
	private String password ="1009";
	private String url ="jdbc:mysql://localhost:3306/"+ Nombre_db + "?useUnicode=true&use"
			+ "JDBCCompliantTimezoneshift=true&useLegacyDatatimeCode=false&" + "serverTimezone=UTC"; 
	private Statement stm =null;
	private ResultSet Rs = null;
	
	
	public Connection getConnetion() {
		try {
			//driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//conexion con el server
			SqlCn= DriverManager.getConnection(url,usuario,password);
			if(SqlCn!=null) {
				System.out.println("Conexion exitosa");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurre una ClassException: "+e.getMessage());
			e.printStackTrace();
			SqlCn = null;
		}catch (SQLException e) {
			System.out.println("Ocurre una SQLException: "+e.getMessage());
		}
		return SqlCn;
	}
	
	//Metodos para los usuarios
	
	public boolean Validaruser(String User, String clave) {
		 
		// Connection Conexion= null;
		  
		  boolean valid = false;
			
			try {
				SqlCn = getConnetion();
				stm = SqlCn.createStatement();
				Rs = stm.executeQuery("SELECT * FROM usuarios WHERE Usuario ='"+User+"' AND Contrasena='"+clave+ "'");
				
				if(Rs.next()) {
					
							//valid = true;
							System.out.println(Rs);
							valid = true;
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					
				e.printStackTrace();
			}
			
		return valid;
	}
	
	public boolean crearuser(String user, String pass, String Name, String Lname, String Email, String Telefono) {
		
		boolean valid = false;
			
			try {
				SqlCn = getConnetion();
				stm = SqlCn.createStatement();
				stm.executeUpdate("INSERT INTO usuarios (Usuario, Contrasena, Nombre, Apellidos, Email, Telefono) "
						+ "VALUES ('"+user+"', '"+pass+"', '"+Name+"', '"+Lname+"', '"+Email+"', '"+Telefono+"');");
				System.out.println("Conexion exitosa");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Validaruser(user, pass)==true) {
				valid=true;
				}else {
					JOptionPane.showMessageDialog(null,"No se pudo validar el usuario","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			
		return valid;
	}
	
	public boolean Updateuser(String ID, String Name, String Lname, String Email, String Telefono) {
		
		boolean valid = false;
		stm=null;
			try {
				SqlCn = getConnetion();
				stm = SqlCn.createStatement();
				stm.executeUpdate("UPDATE usuarios SET Nombre= '"+ Name +"', Apellidos= '"+Lname+"', Email='"+Email+"', Telefono='"+Telefono+"'"
						+ "WHERE idUsuarios = '"+ID+"'");
				System.out.println("Conexion exitosa");
				valid=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"No se pudo Actualizar el usuario","ERROR",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
			
		return valid;
	}
	
	public boolean DeleteUser(String ID) {
		boolean valid = false;
		
		try {
			SqlCn = getConnetion();
			stm = SqlCn.createStatement();
			stm.executeUpdate("DELETE FROM usuarios WHERE idUsuarios = '"+ID+"'");
			System.out.println("Conexion exitosa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			valid=true;
		}
		return valid;
	}
	
	//Metodos para los productos
	public boolean Nuevoproducto(String Nombre, String Marca, String Categoria, String Precio, String Cantidad) {
		
		boolean valid = false;
			stm=null;
			try {
				SqlCn = getConnetion();
				stm = SqlCn.createStatement();
				stm.executeUpdate("INSERT INTO productos(NombreProducto,MarcaProducto,CategoriaProducto,PrecioProducto,StockProducto) "
						+ "VALUES ('"+Nombre+"', '"+Marca+"', '"+Categoria+"', '"+Precio+"', '"+Cantidad+"');");
				System.out.println("Conexion exitosa");
				valid=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		return valid;
	}
	
	public boolean UpdateProducto(String ID, String Nombre, String Marca, String Categoria, String Precio, String Cantidad) {
		
		boolean valid = false;
		stm=null;
			try {
				SqlCn = getConnetion();
				stm = SqlCn.createStatement();
				stm.executeUpdate("UPDATE productos SET "
						+ "NombreProducto= '"+ Nombre +"', "
						+ "MarcaProducto= '"+Marca+"',"
						+ "CategoriaProducto='"+Categoria+"',"
						+ "PrecioProducto='"+Precio+"',"
						+ "StockProducto='"+Cantidad+"'"
						+ "WHERE idProductos = '"+ID+"'");
				System.out.println("Conexion exitosa");
				valid=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"No se pudo Actualizar el Producto","ERROR",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
			
		return valid;
	}
	
	public boolean DeleteProducto(String ID) {
		boolean valid = false;
		
		try {
			SqlCn = getConnetion();
			stm = SqlCn.createStatement();
			stm.executeUpdate("DELETE FROM productos WHERE idproductos = '"+ID+"'");
			System.out.println("Conexion exitosa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			valid=true;
		}
		return valid;
	}
	
	//tablas de datos
	public DefaultTableModel getAll_Usuarios(DefaultTableModel model) {
		
		try {
			SqlCn = getConnetion();
			stm = SqlCn.createStatement();
			Rs = stm.executeQuery("SELECT idUsuarios,Nombre,Apellidos,Email,Telefono FROM usuarios");
			model.addRow(new Object[]{"ID","Nombres","Apellidos","Correo","Telefono"});
			while(Rs.next()) {
				model.addRow(new Object[]{
						Rs.getString(1),
						Rs.getString(2),
						Rs.getString(3),
						Rs.getString(4),
						Rs.getString(5)
				});
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				SqlCn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return model;
	}
	
	public DefaultTableModel getAll_Productos(DefaultTableModel model2) {
		
		try {
			SqlCn = getConnetion();
			stm = SqlCn.createStatement();
			Rs = stm.executeQuery("SELECT idproductos,NombreProducto,MarcaProducto,CategoriaProducto,PrecioProducto,StockProducto FROM productos");
			model2.addRow(new Object[]{"ID","Nombre","Marca","Categoria","Precio","Cantidad"});
			while(Rs.next()) {
				model2.addRow(new Object[]{
						Rs.getString(1),
						Rs.getString(2),
						Rs.getString(3),
						Rs.getString(4),
						Rs.getString(5),
						Rs.getString(6)
				});
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				SqlCn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return model2;
	}
	
	
	public static void main() {
		
	}
	
}
