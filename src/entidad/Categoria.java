package entidad;

public class Categoria {
	
	int idCategoria;
	String nombre;
	
	public Categoria() {
		
	}
	
	public Categoria(int idCategoria, String nombre) {
		this.nombre = nombre;
		this.idCategoria = idCategoria;
		
	}

	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
	}
	
	

}
