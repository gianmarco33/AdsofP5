package adsof1718.grafos;

/**
 * @author Dario Hernandez Barroso
 * @author Gianmarco Minelli Sierra
 *
 */

public class Vertice<T> {
	private final int id;
	private T datos;
	/**
	 * Contructor del vertice
	 * @param id1 Identificador del vertice.
	 * @param datos Datos que contendra el vertice.
	 */
	public Vertice(int id1, T datos){
		this.id = id1;
		this.datos = datos;
	}
	
	/**
	 * Devuelve el Id del vertice.
	 * @return Id del vertice
	 */
	public Integer getId() {return id;}
	
	/**
	 * Devuelve los datos del vertice.
	 * @return Datos del vertice
	 */
	public T getDatos() {return datos;}
	
	/**
	 * Imprime los datos de un vertice.
	 */
	public String toString() {	
		return datos.toString();
	}
}
