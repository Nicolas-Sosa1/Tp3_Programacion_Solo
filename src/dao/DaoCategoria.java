package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;

public class DaoCategoria {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "bdInventario";
	
	public DaoCategoria() {
		
	}
	
	
	public int agregarCategoria(Categoria categoria) {
		

		String query = "INSERT INTO Categorias (Nombre) VALUES ('" 
	             + categoria.getNombre() + "')";

		
		
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
	
	
	public int eliminarCategoria(Categoria categoria) {
		
		String query = "DELETE FROM Categorias WHERE IdCategoria = "+ categoria.getIdCategoria();
		
		
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
	
	public int modificarCategoria(Categoria categoria) {
	    String query = "UPDATE Categorias SET Nombre = '" 
	                 + categoria.getNombre() + "' " 
	                 + "WHERE IdCategoria = " + categoria.getIdCategoria();

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

	
	
	
	
     public ArrayList<Categoria> obtenerTodasLasCategoria() {
		
		ArrayList<Categoria> lUsuarios = new ArrayList<Categoria>();
		
		Connection cn = null;
		
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			String query = "Select * from Categorias";
			ResultSet rs= st.executeQuery(query);
			
			while(rs.next()) {
				Categoria x = new Categoria();
				x.setNombre(rs.getString("Nombre"));
				lUsuarios.add(x);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return lUsuarios;
		
			
	}
	

}
