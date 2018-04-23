package grafos;

public class Vertice<T> {
	private final int id;
	private T datos;
	
	public Vertice(int id1, T datos){
		this.id = id1;
		this.datos = datos;
	}
	public int getId() {return id;}
	public T getDatos() {return datos;}
}
