/**
 * 
 */
package adsof1718.grafos.got.simulador;

import java.util.*;

import adsof1718.grafos.got.*;
/**
 * @author Dario Hernandez Barroso
 * @author Gianmarco Minelli Sierra
 *
 */

public abstract class Sujeto {
	
	public List<ObservadorGOT> listaObservadores;
	public abstract void attach(ObservadorGOT o);
	public abstract void detach(ObservadorGOT o);
	public abstract void notificar();
	public abstract void interaccion(String nombre);
	
}
