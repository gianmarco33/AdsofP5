/**
 * 
 */
package grafos;
import java.util.*;

/**
 * @author gianmarco
 *
 */
public abstract class Grafo<T> {
//Wololo
	protected Map<Integer, Vertice<T>> vertices;
	protected Map<Integer,Map<Integer,Integer>> arcos;
	
	
	public Vertice<T> addVertice(T datos){
		Vertice<T> newVertice = new Vertice<T>(this.getNumVertices(),)
		vertices.put(this.getNumVertices()+1, n)
		return null;
	}
	protected Vertice<T> addVertice(int id, T datos){
		return null;
	}
	public List<Vertice<T>> getVertices(){
		return (List<Vertice<T>>) vertices.values();
	}
	public int getNumVertices() {
		return vertices.keySet().size();
	}
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		Integer i = v1.getId();
		Integer j = v2.getId();
		if(arcos.get(i).get(j) != null)
			return true;	
		return false;
	}
	public int getNumArcos() {
		Map<Integer,Integer> mapa;
		int i = 0;
		for(Integer k : arcos.keySet()) {
			 mapa = arcos.get(k);
			 for(Integer o : mapa.keySet())
				 i++;
		}
		return i;	
	}
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
	public String toString() {
		return null;// los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
	}
	
}
