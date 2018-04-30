/**
 * 
 */
package adsof1718.grafos.got.simulador;

import adsof1718.grafos.got.*;

import adsof1718.grafos.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dario Hernandez Barroso
 * @author Gianmarco Minelli Sierra
 *
 */

public class SimuladorGOT extends Sujeto{

	public GrafoGOT redSocial;
	public PersonajeGOT personajeOrigen;
	public List<PersonajeGOT> personajesDestino;
	
	public SimuladorGOT(GrafoGOT redSocial) {
		this.redSocial = redSocial;
		this.personajesDestino = new ArrayList<PersonajeGOT>();
		listaObservadores = new ArrayList<ObservadorGOT>();
	}

	
	
	/**
	 * @return the redSocial
	 */
	public GrafoGOT getRedSocial() {
		return redSocial;
	}


	/**
	 * @param redSocial the redSocial to set
	 */
	public void setRedSocial(GrafoGOT redSocial) {
		this.redSocial = redSocial;
	}

	public PersonajeGOT getOrigen() {
		return personajeOrigen;
	}
	
	public List<PersonajeGOT> getDestinos(){
		return personajesDestino;
	}


	@Override
	public void attach(ObservadorGOT o) {
		listaObservadores.add(o);
	}

	@Override
	public void detach(ObservadorGOT o) {
		listaObservadores.remove(o);
	}

	@Override
	public void notificar() {
		/*for(ObservadorGOT obG : listaObservadores)
			if(obG.getPersonaje().equals(personajeOrigen))
				obG.update();*/
		listaObservadores.stream().filter(v -> v.getPersonaje().equals(personajeOrigen)).forEach(v -> v.update());
	}
	
	@Override
	public void interaccion(String nombre) {
		Vertice<PersonajeGOT> origen = redSocial.getVertice(nombre);
		Double denominador = redSocial.gradoPonderadoPersonajes().get(nombre);
		Double probInteraccion = Math.random();
		
		personajeOrigen = origen.getDatos();
		
		for(Vertice<PersonajeGOT> p : redSocial.getVecinosDe(origen))
			if(probInteraccion < (redSocial.getPesoDe(origen, p)/denominador))
				personajesDestino.add(p.getDatos());
		
		notificar();		
	}
	
	public String toString() {
		String ret = "";
		for(ObservadorGOT o: listaObservadores) {
			if(o.getNumInteraccionesTotales() !=0)
				ret += o.toString();
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		GrafoGOT g = new GrafoGOT("got-s01-vertices.csv", "got-s01-arcos.csv");
		SimuladorGOT simulador = new SimuladorGOT(g);
	
		for(Vertice<PersonajeGOT> vP : g.getVertices()) {
			new ObservadorGOT(simulador, vP.getDatos());
		}

		List<String> nombresPersonajes = g.getVertices().stream().map(v -> v.getDatos().getNombre()).collect(Collectors.toList());
		
		
		int n = 1000;
		Random rand = new Random();
		
		for(int i=0; i<n; i++) {
			int aleatorioVertice = rand.nextInt(nombresPersonajes.size());
			String nombrePers = nombresPersonajes.get(aleatorioVertice);
			simulador.interaccion(nombrePers);
		}
							
		System.out.println(simulador);
		
	}



	
	
}
