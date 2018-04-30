package adsof1718.grafos;
import java.util.*;

/**
 * @author Dario Hernandez Barroso
 * @author Gianmarco Minelli Sierra
 *
 */

public class PruebaApartado1 {
	
	public static void main(String[] args) {
		Grafo<String> g = new GrafoNoDirigido<>();
		//Grafo<String> g = new GrafoDirigido<>();
		System.out.println(g.getClass().getName() + "\n");
		Vertice<String> v1 = g.addVertice("A");
		Vertice<String> v2 = g.addVertice("B");
		Vertice<String> v3 = g.addVertice("C");
		Vertice<String> v4 = g.addVertice("D");
		Vertice<String> v5 = g.addVertice("E");
		g.addArco(v1, v2, 10.0);
		g.addArco(v1, v2, 20.0);
		g.addArco(v3, v1, 30.0);
		g.addArco(v3, v4, 30.0);
		g.addArco(v3, v5, 25.0);
		System.out.println(g);
		List<Vertice<String>> vecinos1 = g.getVecinosDe(v1);
		System.out.println("Vecinos de " + v1 + ":");
		for (Vertice<String> v : vecinos1) {
		 System.out.println(v);
		}
		double peso1 = g.getPesoDe(v1, v2);
		System.out.println("Peso entre " + v1 + " y " + v2 + ": " + peso1);
		double peso2 = g.getPesoDe(v1, v3);
		System.out.println("Peso entre " + v1 + " y " + v3 + ": " + peso2);
	}
	
}
