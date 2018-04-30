/**
 * 
 */
package adsof1718.grafos.got.simulador;

import java.util.*;

/**
 * @author Dario Hernandez Barroso
 * @author Gianmarco Minelli Sierra
 *
 */

public abstract class Sujeto {
	
	public List<ObservadorGOT> listaObservadores;
	
	/**
	 * Añade un observador a la lista de observadores sujeto
	 * @param o Observador a añadir
	 */
	public abstract void attach(ObservadorGOT o);
	
	/**
	 * Elimina un observador de la lista de observadores de sujeto.
	 * @param o
	 */
	public abstract void detach(ObservadorGOT o);
	
	/**
	 * Notifica del cambio a todos los observadores de la lista implicados en el cambio.
	 */
	public abstract void notificar();
	
	/**
	 * Calcula las posibles interacciones del personaje pasado con el grafo.
	 * @param nombre Personaje a calcular.
	 */
	public abstract void interaccion(String nombre);
	
}
