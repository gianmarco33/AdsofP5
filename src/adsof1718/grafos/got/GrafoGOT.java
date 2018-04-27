/**
 * 
 */
package adsof1718.grafos.got;

import adsof1718.grafos.*;
import java.util.*;
import java.io.*;

/**
 * @author gianmarco
 *
 */
public class GrafoGOT<T> extends GrafoNoDirigido<T>{
	
	private BufferedReader csvVertices;
	
	
	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception{
		//Leer datos fichero y asignarlos a los mapas supongo.
		String str = null;
		String ar[] = null;
		
		csvVertices = new BufferedReader(new FileReader("csv/" + ficheroVertices));
		
		while((str = csvVertices.readLine()) != null) {
			ar = str.split(",");
			PersonajeGOT p = new PersonajeGOT(Integer.parseInt(ar[0]), ar[1], ar[2]);
			Vertice<PersonajeGOT> v = new Vertice<PersonajeGOT>(Integer.parseInt(ar[0]),p);
			vertices.put(Integer.parseInt(ar[0]), v);
		}
		
		
	}
	
	
	public Vertice<PersonajeGOT> getVertice(String nombre){
		
		return null;
	}
	
	public List<String> casas(){
		return null;
	}
	
	public List<String> miembrosCasa(String casa){
		return null;
	}
	
	public Map<String, Integer> gradoPersonajes(){
		return null;
	}
	
	public Map<String, Integer> gradoPonderadoPersonajes(){
		return null;
	}
	
	public Map<String, Integer> personajesRelevantes(){
		return null;
	}
	
	
}
