package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
		
		DaoCategoria categoriaDao = new DaoCategoria();
		
	    ArrayList<Categoria> listaC = categoriaDao.obtenerTodasLasCategoria();
	    System.out.println("Cantidad: " + listaC.size());
	    for (Categoria c : listaC) {
	        System.out.println(c); 
	    }
		
	    
		
		/*
		categoria1.setNombre("Tecnologia");
		categoriaDao.agregarCategoria(categoria1);
		
		Categoria categoria2 = new Categoria();
		categoria2.setNombre("Muebles");
		categoriaDao.agregarCategoria(categoria2);
		
		Categoria categoria3 = new Categoria();
		categoria3.setNombre("Telefonos");
		categoriaDao.agregarCategoria(categoria3);
		*/
		
	    /*
		
		DaoProducto productoDao = new DaoProducto();
		
		Producto producto1 = new Producto();
		producto1.setCodigo("A1");
		producto1.setIdCategoria(3);
		producto1.setNombre("Monitor");
		producto1.setPrecio(200.000);
		producto1.setStock(10);
		
		int filas = productoDao.agregarProducto(producto1);
		
		if(filas == 1) {
			System.out.println("Se agrego con exito el Producto");
		}
		else {
			System.out.println("No se pudo agregar el Producto");
		}
		
		
		Producto producto2 = new Producto();
		producto2.setCodigo("A2");
		producto2.setIdCategoria(3);
		producto2.setNombre("Monitor-240hz");
		producto2.setPrecio(300.000);
		producto2.setStock(20);
		
		int filas2 = productoDao.agregarProducto(producto2);
		
		if(filas2 == 1) {
			System.out.println("Se agrego con exito el Producto");
		}
		else {
			System.out.println("No se pudo agregar el Producto");
		}
		
		
		Producto producto3 = new Producto();
		producto3.setCodigo("A3");
		producto3.setIdCategoria(3);
		producto3.setNombre("Monitor-500hz");
		producto3.setPrecio(600.000);
		producto3.setStock(5);
		
		int filas3 = productoDao.agregarProducto(producto3);
		
		if(filas3 == 1) {
			System.out.println("Se agrego con exito el Producto");
		}
		else {
			System.out.println("No se pudo agregar el Producto");
		}
		*/
		/*
		
	    DaoProducto productoDao = new DaoProducto();
	    Producto producto = new Producto();
	    producto.setCodigo("A1");
	    productoDao.eliminarProducto(producto);
	    
	    */
		
		DaoProducto productoDao = new DaoProducto();
		
	    ArrayList<Producto> listaP = productoDao.obtenerTodosLosProducto();
	    System.out.println("Cantidad: " + listaP.size());
	    for (Producto c : listaP) {
	        System.out.println(c); 
	    }
	    
	    
	    /*
	    // Crear y cargar el producto
	    Producto producto1 = new Producto();
	    producto1.setCodigo("A4");
	    producto1.setNombre("Monitor 75hz");
	    producto1.setPrecio(120.000);
	    producto1.setStock(30);
	    producto1.setIdCategoria(3); 

	    // Llamar al procedimiento almacenado
	    productoDao.ejecutarProcedimientoAlmacenado(producto1);

	    System.out.println("Producto cargado mediante procedimiento almacenado");
	    
	    */
	    
	    
	    DaoProducto dao = new DaoProducto();
	    Producto p = new Producto();
	    p.setCodigo("A1");          
	    p.setNombre("Monitor 200hz");
	    p.setPrecio(200.000);
	    p.setStock(8);
	    p.setIdCategoria(3);

	    int filas = dao.actualizarProducto(p);
	    System.out.println(filas == 1 ? "Actualizado" : "No se actualizó");
	    
	    
	    /*
	    DaoCategoria dao = new DaoCategoria();
	    Categoria categoria = new Categoria();
	    categoria.setIdCategoria(5);            
	    categoria.setNombre("Interior"); 

	    int filas = dao.modificarCategoria(categoria);

	    if (filas == 1) {
	        System.out.println("Categoría modificada con éxito");
	    } else {
	        System.out.println("No se pudo modificar la categoría");
	    } */



	}

}
