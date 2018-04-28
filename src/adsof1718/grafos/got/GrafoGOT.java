/**
 * 
 */
package adsof1718.grafos.got;

import adsof1718.grafos.*;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

/**
 * @author gianmarco
 *
 */
public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT>{
	
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
			//vertices.put(Integer.parseInt(ar[0]), v);
			//Error aqui
			vertices.put(Integer.parseInt(ar[0]), v);
		}
		
		/*for(Vertice<PersonajeGOT> pg : vertices.values())
			System.out.println(pg);*/
		
		csvVertices = new BufferedReader(new FileReader("csv/" + ficheroArcos));
		
		while((str = csvVertices.readLine()) != null) {
			ar = str.split(",");
			this.addArco(vertices.get(Integer.parseInt(ar[0])), vertices.get(Integer.parseInt(ar[1])),Double.parseDouble(ar[2]));		
		}	
	}
	
	
	public Vertice<PersonajeGOT> getVertice(String nombre){
		return vertices.values().stream().filter(p -> p.getDatos().getNombre().equals(nombre)).collect(Collectors.toList()).get(0);	
	}
	
	public List<String> casas(){
		return vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getCasa).filter(s -> !s.equals("null")).distinct().sorted().collect(Collectors.toList());
	}
	
	//Este hay que hacer un predicate WOT
	public List<String> miembrosCasa(String casa){
		return vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).filter(s -> s.getCasa() == "casa").map(PersonajeGOT::getNombre).sorted().collect(Collectors.toList());
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
