/**
 * 
 */
package adsof1718.grafos.got.simulador;

import adsof1718.grafos.got.*;

import java.util.*;
import java.util.function.Predicate;
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
	
	private Map<String,Integer> InteraccionesCasas;
	
	private PersonajeGOT personaje;
	
	/**
	 * Constructor de la clase ObservadorGOT
	 * @param s Simulador al que pertenecera.
	 * @param p Personaje al que hara referencia.
	 */
	public ObservadorGOT(SimuladorGOT s, PersonajeGOT p) {
		this.sujeto = s;
		personaje = p;
		numInteraccionesCasa = 0;
		numInteraccionesOtrasCasas = 0;
		numInteraccionesTotales = 0;
		InteraccionesCasas = new HashMap<String,Integer>();
		s.attach(this);
	}

	/**
	 * Devuelve el personaje al que hace referencia.
	 * @return Personaje del observador.
	 */
	public PersonajeGOT getPersonaje() {
		return personaje;
	}
	
	/**
	 * Devuelve el numero de interacciones totales
	 * @return numero de interacciones totales.
	 */
	public int getNumInteraccionesTotales(){
		return numInteraccionesTotales;
	}
	
	/**
	 * Devuelve el numero de interacciones con su propia casa
	 * @return numero de interacciones con su casa.
	 */
	public int getNumInteraccionesCasa(){
		return numInteraccionesCasa;
	}
	
	/**
	 * Devuelve el numero de interacciones con casas ajenas
	 * @return numero de interacciones con casas ajenas.
	 */
	public int getNumInteraccionesOtrasCasas(){
		return numInteraccionesOtrasCasas;
	}
	
	/**
	 * Metodo toString de ObservadorGOT
	 */
	@Override
	public String toString() {
		String ret = "";
		for(String s : InteraccionesCasas.keySet()) {
			if(InteraccionesCasas.get(s) != null) {
				ret += "\t\t" + s + ": " + InteraccionesCasas.get(s) + "\n";
			}
				
		}
		return personaje.getNombre() + "\n"
				+ "\tInteracciones: " + numInteraccionesTotales
				+ "\n\tCon miembros de tu casa: " + numInteraccionesCasa
				+ "\n\tCon miembros de casas ajenas: " + numInteraccionesOtrasCasas + "\n"
				+ ret + "\n";
	}
	
	
	/**
	 * @see Observador#update()
	 */
	@Override
	public void update() {
		SimuladorGOT simulador = (SimuladorGOT) super.sujeto;
		PersonajeGOT origen = simulador.getOrigen(); 
		List<PersonajeGOT> destinos = simulador.getDestinos();
		
		Predicate<PersonajeGOT> predicadoCasaDiferente = new Predicate<PersonajeGOT>() {		 
			@Override
			 public boolean test(PersonajeGOT p) {
				return !p.getCasa().equals(origen.getCasa());
			 }	 
			};
		
		numInteraccionesTotales += destinos.size();
		numInteraccionesCasa += destinos.stream().filter(v -> v.getCasa().equals(origen.getCasa())).collect(Collectors.toList()).size();
		numInteraccionesOtrasCasas += destinos.stream().filter(predicadoCasaDiferente).collect(Collectors.toList()).size();
		
		
		for(PersonajeGOT p : destinos) {
			if(!p.getCasa().equals(origen.getCasa()) || simulador.getRedSocial().casas().contains(p.getCasa()))
				if(InteraccionesCasas.get(p.getCasa()) == null)
					InteraccionesCasas.put(p.getCasa(), 1);
				else
					InteraccionesCasas.put(p.getCasa(), InteraccionesCasas.get(p.getCasa())+1);
		}
	}	
}
