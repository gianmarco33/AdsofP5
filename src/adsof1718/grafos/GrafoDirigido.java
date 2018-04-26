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
		super();
		super.arcos = new HashMap<Integer,Map<Integer,Double>>();
		super.vertices = new HashMap<Integer, Vertice<T>>();
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
		if(super.arcos.containsKey(v1.getId()) == false)
			return false;
		if(super.arcos.get(v1.getId()).containsKey(v2.getId()) == true)
			return true;
		return false;
	}
	
	@Override
	public int getNumArcos() {
		return super.arcos.size();
	}
	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		if(existeArco(v1, v2) == true) {
			return super.arcos.get(v1.getId()).get(v2.getId()); 
		}
		return 0;
	}
	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		if(super.arcos.containsKey(v.getId()) == true) {
			List<Vertice<T>> vecinos = new ArrayList<Vertice<T>>();
			for(Integer i : super.arcos.get(v.getId()).keySet()) {
				if(super.vertices.containsKey(i) == true)
					vecinos.add(super.vertices.get(i));
			}
			return vecinos;
		}
		return null;
	}


}
