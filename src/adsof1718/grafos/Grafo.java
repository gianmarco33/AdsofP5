/**
 * 
 */
package adsof1718.grafos;
import java.util.*;

/**
 * @author gianmarco
 *
 */
public abstract class Grafo<T> {

	protected Map<Integer, Vertice<T>> vertices;
	protected Map<Integer,Map<Integer,Double>> arcos;
	
	
	public Vertice<T> addVertice(T datos){
		Vertice<T> newVertice = new Vertice<T>(this.getNumVertices(),datos);
		vertices.put(this.getNumVertices()+1, newVertice);
		return newVertice;
	}
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> newVertice = new Vertice<T>(id,datos);
		vertices.put(id, newVertice);
		return newVertice;
	}
	public List<Vertice<T>> getVertices(){
		List<Vertice<T>> laux = new ArrayList<Vertice<T>>();
		for(Vertice<T> v : vertices.values()) {
			laux.add(v);
		}
		return laux;
		//return (List<Vertice<T>>) vertices.values();
	}
	public int getNumVertices() {
		return vertices.keySet().size();
	}
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	public abstract boolean existeArco(Vertice<T> v1, Vertice<T> v2);
	
	public abstract int getNumArcos();
	
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
	public String toString() {	
		return vertices.values().toString();// los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
	}
	
}
