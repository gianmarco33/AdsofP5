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

public class ObservadorGOT extends Observador{
	
	private int numInteraccionesTotales;
	private int numInteraccionesCasa;
	private int numInteraccionesOtrasCasas;
	private PersonajeGOT personaje;
	
	public ObservadorGOT(SimuladorGOT s, PersonajeGOT p) {
		this.sujeto = s;
		personaje = p;
		numInteraccionesCasa = 0;
		numInteraccionesOtrasCasas = 0;
		numInteraccionesTotales = 0;
	}

	@Override
	public void update() {
		SimuladorGOT simulador = (SimuladorGOT) super.sujeto;
		PersonajeGOT origen = simulador.getOrigen(); 
		List<PersonajeGOT> destinos = simulador.getDestinos(); 
		
		numInteraccionesTotales += destinos.size();
		numInteraccionesCasa = destinos.stream().filter(v -> v.getCasa().equals(origen.getCasa())).collect(Collectors.toList()).size();
		numInteraccionesOtrasCasas = destinos.stream().filter(v -> !v.getCasa().equals(origen.getCasa())).collect(Collectors.toList()).size();
	}
	
	
}
