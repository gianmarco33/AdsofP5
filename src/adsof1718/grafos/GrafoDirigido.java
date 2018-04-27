/**
 * 
 */
package adsof1718.grafos;

import java.util.*;

/**
 * @author eps
 * @param <T>
 *
 */
public class GrafoDirigido<T> extends Grafo<T>{
	
	//protected Map<Integer,Map<Integer,Double>> arcos;
	public GrafoDirigido() {
		
		arcos = new HashMap<Integer,Map<Integer,Double>>();
		vertices = new HashMap<Integer, Vertice<T>>();
	}
	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		//super.arcos.get(v1.getId()).put(v2.getId(), peso);
		if(arcos.containsKey(v1.getId()) == false)
			arcos.put(v1.getId(), new HashMap<Integer,Double>());		
		arcos.get(v1.getId()).put(v2.getId(), peso);		
	}
	
	@Override
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		if(arcos.containsKey(v1.getId()) == false)
			return false;
		if(arcos.get(v1.getId()).containsKey(v2.getId()) == true)
			return true;
		return false;
	}
	
	@Override
	public int getNumArcos() {
		return arcos.size();
	}
	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		if(existeArco(v1, v2) == true) {
			return arcos.get(v1.getId()).get(v2.getId()); 
		}
		return -1;
	}
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
