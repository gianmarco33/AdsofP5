/**
 * 
 */
package adsof1718.grafos.got;

import adsof1718.grafos.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.io.*;

/**
 * @author Dario Hernandez Barroso
 * @author Gianmarco Minelli Sierra
 *
 */
public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT>{
	
	private BufferedReader csvVertices;
	
	/**
	 * Contructor de la clase GrafoGOT
	 * @param ficheroVertices Fichero externo donde se encuentra la informacion de los vertices del grafo.
	 * @param ficheroArcos Fichero externo donde se encuentra la informacion de los arcos del grafo.
	 * @throws Exception Excepcion que salta si no se abren bien los ficheros.
	 */
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

		csvVertices = new BufferedReader(new FileReader("csv/" + ficheroArcos));
		
		while((str = csvVertices.readLine()) != null) {
			ar = str.split(",");
			this.addArco(vertices.get(Integer.parseInt(ar[0])), vertices.get(Integer.parseInt(ar[1])),Double.parseDouble(ar[2]));		
		}	
	}
	
	/**
	 * Devuelve el vertice correspondiente al nombre pasado por argumento.
	 * @param nombre Nombre representativo del vertice a buscar.
	 * @return Vertice con nombre indicado.
	 */
	public Vertice<PersonajeGOT> getVertice(String nombre){
		return vertices.values().stream().filter(p -> p.getDatos().getNombre().equals(nombre)).collect(Collectors.toList()).get(0);	
	}
	
	/**
	 * Devuelve una lista de todas las casas del grafo ordenadas, sin repeticion y obviando los nulos.
	 * @return Lista de casas,
	 */
	public List<String> casas(){
		return vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getCasa)
				.filter(s -> !s.equals("null")).distinct().sorted().collect(Collectors.toList());
	}
	
	/**
	 * Devuelve el nombre de todos los miembros de una casa pasada por argumento.
	 * @param casa Nombre de la casa a buscar.
	 * @return Lista de personajes de la casa especificada.
	 */
	public List<String> miembrosCasa(String casa){
		Predicate<PersonajeGOT> predicadoCasa = new Predicate<PersonajeGOT>() {		 
			@Override
			 public boolean test(PersonajeGOT p) {
				return p.getCasa().equals(casa);
			 }	 
			};
		return vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos)
				.filter(predicadoCasa).map(PersonajeGOT::getNombre).sorted().collect(Collectors.toList());
	}
	
	/**
	 * Devuelve el grado de los personajes, es decir cada personaje con el numero de vecinos que tiene.
	 * @return Mapa que contiene a los personajes con el numero de sus vecinos.
	 */
	public Map<String, Integer> gradoPersonajes(){
		return vertices.values().stream().collect(Collectors.toMap(v -> v.getDatos().getNombre(), v -> getVecinosDe(v).size()));
	}
	
	/**
	 * Devuelve la suma de los pesos de los arcos que unen a cada vértice con sus vecinos
	 * @return Mapa de cada personaje con su sumatorio de pesos.
	 */
	public Map<String, Double> gradoPonderadoPersonajes(){
		return vertices.values().stream().collect(Collectors.toMap(v -> v.getDatos().getNombre(), 
				v -> arcos.get(v.getDatos().getId()).values().stream().reduce(0.0,Double::sum)));						
	}
	
	/**
	 * devuelve los personajes y sus “grados ponderados”, pero solo para aquellos personajes cuyo grado ponderado es superior al grado ponderado medio en la red social.
	 * @return Mapa de cada personaje con su sumatorio de pesos que sean mayores que la media.
	 */
	public Map<String, Double> personajesRelevantes(){

		Map<String, Double> mapita = gradoPonderadoPersonajes();
		
		Double media = mapita.values().stream().reduce(0.0, Double::sum) / mapita.keySet().size();
		
		return mapita.entrySet().stream().filter(p -> p.getValue() > media).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
	}
	
	
}
