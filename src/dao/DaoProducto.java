package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Producto;

public class DaoProducto {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "bdInventario";
	
	public DaoProducto() {
		
	}
	
	
	
	public int agregarProducto(Producto producto) {
		
		String query = "INSERT INTO Productos(Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('" 
			    + producto.getCodigo() + "', '" 
			    + producto.getNombre() + "', " 
			    + producto.getPrecio() + ", " 
			    + producto.getStock() + ", " 
			    + producto.getIdCategoria() + ")";
		
		
		Connection cn = null;
		
		int filas = 0;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return filas;
		
		}
	
	
	public int eliminarProducto(Producto producto) {
	    
		String query = "DELETE FROM Productos WHERE Codigo = '" + producto.getCodigo() + "'";
	    
	    Connection cn = null;
	    int filas = 0;
	    
	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        Statement st = cn.createStatement();
	        filas = st.executeUpdate(query);
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	    
	    return filas;
	}
	
	public int actualizarProducto(Producto p) {
	    String query =
	        "UPDATE Productos SET " +
	        "Nombre = '" + p.getNombre() + "', " +
	        "Precio = " + p.getPrecio() + ", " +
	        "Stock = " + p.getStock() + ", " +
	        "IdCategoria = " + p.getIdCategoria() + " " +
	        "WHERE Codigo = '" + p.getCodigo() + "'";

	    Connection cn = null;
	    int filas = 0;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        Statement st = cn.createStatement();
	        filas = st.executeUpdate(query);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return filas; 
	}


	
	
	public ArrayList<Producto> obtenerTodosLosProducto() {
		
		ArrayList<Producto> lUsuarios = new ArrayList<Producto>();
		
		Connection cn = null;
		
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			String query = "Select * from Productos";
			ResultSet rs= st.executeQuery(query);
			
			while(rs.next()) {
				Producto x = new Producto();
				x.setCodigo(rs.getString("Codigo"));
				x.setNombre(rs.getString("Nombre"));
				x.setPrecio(rs.getDouble("Precio"));
				x.setStock(rs.getInt("Stock"));
				x.setIdCategoria(rs.getInt("IdCategoria"));
				lUsuarios.add(x);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return lUsuarios;
		
			
	}
	
	
	public void ejecutarProcedimientoAlmacenado(Producto producto) {
		
		Connection cn= null;
		
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			CallableStatement cst = cn.prepareCall("CALL sp_AgregarProducto (?,?,?,?,?)");
			cst.setString(1,producto.getCodigo());
			cst.setString(2,producto.getNombre());
			cst.setDouble(3,producto.getPrecio());
			cst.setInt(4,producto.getStock());
			cst.setInt(5,producto.getIdCategoria());
			cst.execute();
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	
	

}
