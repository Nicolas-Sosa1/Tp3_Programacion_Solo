package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
		
		DaoCategoria categoriaDao = new DaoCategoria();
		
	    ArrayList<Categoria> lista = categoriaDao.obtenerTodasLasCategoria();
	    System.out.println("Cantidad: " + lista.size());
	    for (Categoria c : lista) {
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
		
		
		/*DaoProducto productoDao = new DaoProducto();
		
		Producto producto1 = new Producto();
		producto1.setCodigo("A1");
		producto1.setIdCategoria(1);
		producto1.setNombre("Monitor");
		producto1.setPrecio(200.000);
		producto1.setStock(10);
		producto1.setIdCategoria(1);
		
		int filas = productoDao.agregarProducto(producto1);
		
		if(filas == 1) {
			System.out.println("Se agrego con exito el Producto");
		}
		else {
			System.out.println("No se pudo agregar el Producto");
		}*/
		
		
		

	}

}
