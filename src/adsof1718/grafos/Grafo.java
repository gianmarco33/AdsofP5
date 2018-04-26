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
		return null;
	}
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> newVertice = new Vertice<T>(id,datos);
		vertices.put(id, newVertice);
		return null;
	}
	public List<Vertice<T>> getVertices(){
		return (List<Vertice<T>>) vertices.values();
	}
	public int getNumVertices() {
		return vertices.keySet().size();
	}
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	public abstract boolean existeArco(Vertice<T> v1, Vertice<T> v2);
		/*Integer i = v1.getId();
		Integer j = v2.getId();
		if(arcos.get(i).get(j) != null)
			return true;	
		return false;*/
	
	public abstract int getNumArcos();
		/*Map<Integer,Integer> mapa;
		int i = 0;
		for(Integer k : arcos.keySet()) {
			 mapa = arcos.get(k);
			 for(Integer o : mapa.keySet())
				 i++;
		}
		return i;	*/
	
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los v�rtices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
	public String toString() {
		String ret;
		
		return vertices.toString();// los v�rtices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
	}
	
}
