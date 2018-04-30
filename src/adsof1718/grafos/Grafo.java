	/**
 * 
 */
package adsof1718.grafos;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dario Hernandez Barroso
 * @author Gianmarco Minelli Sierra
 *
 */
public abstract class Grafo<T> {

	protected Map<Integer, Vertice<T>> vertices;
	protected Map<Integer,Map<Integer,Double>> arcos;
	
	
	
	/**
	 * Anyade un vertice al grafo con los datos pasados.
	 * @param datos Datos del vertice.
	 * @return Vertice creado.
	 */
	public Vertice<T> addVertice(T datos){
		Vertice<T> newVertice = new Vertice<T>(this.getNumVertices(),datos);
		vertices.put(this.getNumVertices()+1, newVertice);
		return newVertice;
	}
	
	/**
	 * Anyade un vertice al grafo con los datos pasados en la posicion indicada. Sobreescribira ese nodo si ya existe.
	 * @param id Id del vertice.
	 * @param datos Datos del vertice.
	 * @return Vertice creado.
	 */
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> newVertice = new Vertice<T>(id,datos);
		vertices.put(id, newVertice);
		return newVertice;
	}
	
	/**
	 * Devuelve los vertices de un grafo.
	 * @return Lista de vertices.
	 */
	public List<Vertice<T>> getVertices(){
		return vertices.values().stream().collect(Collectors.toList());
	}
	
	/**
	 * Devuelve el numero de vertices del grafo.
	 * @return numero de vertices.
	 */
	public int getNumVertices() {
		return vertices.keySet().size();
	}
	
	/**
	 * Anyade un arco entre dos vertices del grafo con un peso.
	 * @param v1 Vertice origen.
	 * @param v2 Vertice destino.
	 * @param peso Peso del arco.
	 */
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	/**
	 * Comprueba si existe un arco entre dos vertices.
	 * @param v1 Vertice origen.
	 * @param v2 Vertice destino.
	 * @return True si existe, False en caso contrario.
	 */
	public abstract boolean existeArco(Vertice<T> v1, Vertice<T> v2);
	
	/**
	 * Devuelve el numero de arcos del grafo.
	 * @return Numero de arcos del grafo.
	 */
	public abstract int getNumArcos();
	
	/**
	 * Obtiene el peso de un arco que une dos vertices.
	 * @param v1 Vertice origen.
	 * @param v2 Vertice destino.
	 * @return Peso del arco.
	 */
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	/**
	 * Devuelve la lista de vertices adyacentes al vertice dado.
	 * @param v Vertice origen.
	 * @return Lista de vecinos.
	 */
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v);
	
	/**
	 * Devuelve los vertices del grafo ordenados por identificador.
	 */
	public String toString() {	
		return vertices.values().toString();
	}
	
}
