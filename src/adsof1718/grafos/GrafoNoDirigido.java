/**
 * 
 */
package adsof1718.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eps
 *
 */
public class GrafoNoDirigido<T> extends Grafo<T>{
	
	/**
	 * Constructor de la clase GrafoNoDirigido.
	 * Crea los mapas de los arcos y vertices.
	 */
	public GrafoNoDirigido() {
		arcos = new HashMap<Integer,Map<Integer,Double>>();
		vertices = new HashMap<Integer, Vertice<T>>();
	}
	
	/**
	 * @see Grafo#addArco(Vertice, Vertice, double)
	 */
	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		if(arcos.containsKey(v1.getId()) == false)
			arcos.put(v1.getId(), new HashMap<Integer,Double>());
	
		if(arcos.containsKey(v2.getId()) == false) 
			arcos.put(v2.getId(), new HashMap<Integer,Double>());
		
		arcos.get(v1.getId()).put(v2.getId(), peso);
		arcos.get(v2.getId()).put(v1.getId(), peso);	
	}
	
	/**
	 * @see Grafo#existeArco(Vertice, Vertice)
	 */
	@Override
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		if(arcos.containsKey(v1.getId()) == false || arcos.containsKey(v2.getId()) == false)
			return false;
		if(arcos.get(v1.getId()).containsKey(v2.getId()) == true && arcos.get(v2.getId()).containsKey(v1.getId()) == true)
			return true;
		return false;
	}
	
	/**
	 * @see Grafo#getNumArcos()
	 */
	@Override
	public int getNumArcos() {
		return arcos.size()/2;
	}
	
	/**
	 * @see Grafo#getPesoDe(Vertice, Vertice)
	 */
	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		if(existeArco(v1, v2) == true) {
			return arcos.get(v1.getId()).get(v2.getId()); 
		}
		return -1;
	}
	
	/**
	 * @see Grafo#getVecinosDe(Vertice)
	 */
	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		if(arcos.containsKey(v.getId()) == true) {
			List<Vertice<T>> vecinos = new ArrayList<Vertice<T>>();
			for(Integer i : arcos.get(v.getId()).keySet()) {
				if(vertices.containsKey(i) == true)
					vecinos.add(vertices.get(i));
			}
			return vecinos;
		}
		return null;
	}
}
