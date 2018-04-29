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
			vertices.put(Integer.parseInt(ar[0]), v);
		}

		csvVertices = new BufferedReader(new FileReader("csv/" + ficheroArcos));
		
		while((str = csvVertices.readLine()) != null) {
			ar = str.split(",");
			this.addArco(vertices.get(Integer.parseInt(ar[0])), vertices.get(Integer.parseInt(ar[1])),Double.parseDouble(ar[2]));		
		}	
	}
	
	
	//Cambiar el collect por un reduce() ya que collect es para collecciones y solo quiero un valor?
	public Vertice<PersonajeGOT> getVertice(String nombre){
		return vertices.values().stream().filter(p -> p.getDatos().getNombre().equals(nombre)).collect(Collectors.toList()).get(0);	
	}
	
	public List<String> casas(){
		return vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getCasa)
				.filter(s -> !s.equals("null")).distinct().sorted().collect(Collectors.toList());
	}
	
	public List<String> miembrosCasa(String casa){
		Predicate<PersonajeGOT> predicadoCasa = new Predicate<PersonajeGOT>() {		 
			@Override
			 public boolean test(PersonajeGOT p) {
				return p.getCasa().equals(casa);
			 }	 
			};
		return vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).filter(predicadoCasa).map(PersonajeGOT::getNombre).sorted().collect(Collectors.toList());
	}
	
	public Map<String, Integer> gradoPersonajes(){
		
		//Function<Vertice<PersonajeGOT>,Integer> vecinos = x -> getVecinosDe(x).size();
		
		Map<String, Integer> mapita = new HashMap<String,Integer>();
		for(Vertice<PersonajeGOT> pers : vertices.values()) mapita.put(pers.getDatos().getNombre(),getVecinosDe(pers).size());
		return mapita;
		//map(Vertice<PersonajeGOT>::getDatos).collect(Collectors.toMap(PersonajeGOT::getNombre,PersonajeGOT::getId));
		//return mapita;
	}
	
	public Map<String, Double> gradoPonderadoPersonajes(){
		List<Vertice<PersonajeGOT>> vec = new ArrayList<Vertice<PersonajeGOT>>();
		Double auxPeso = 0.0;
		Map<String, Double> mapita = new HashMap<String,Double>();
		for(Vertice<PersonajeGOT> pers : vertices.values()) {
			vec = getVecinosDe(pers);
			auxPeso = 0.0;
			for(Vertice<PersonajeGOT> v : vec) {
				auxPeso += arcos.get(pers.getDatos().getId()).get(v.getDatos().getId());
			}
			mapita.put(pers.getDatos().getNombre(),auxPeso);
			//mapita.put(pers.getDatos().getNombre(),getVecinosDe(pers).forEach(p -> arcos.get(pers.getDatos().getId()).get(p.getDatos().getId())));
		}
		return mapita;
	}
	
	public Map<String, Double> personajesRelevantes(){

		Map<String, Double> mapita = gradoPonderadoPersonajes();
		
		Double media = mapita.values().stream().reduce(0.0, Double::sum) / mapita.keySet().size();
		
		return mapita.entrySet().stream().filter(p -> p.getValue() > media).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
	}
	
	
}
