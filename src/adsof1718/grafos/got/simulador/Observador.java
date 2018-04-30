/**
 * 
 */
package adsof1718.grafos.got.simulador;

/**
 * @author Dario Hernandez Barroso
 * @author Gianmarco Minelli Sierra
 *
 */

public abstract class Observador {
	protected Sujeto sujeto;
	
	/**
	 * Metodo por el cual un Observador actualizara su estado.
	 */
	public abstract void update();
}
