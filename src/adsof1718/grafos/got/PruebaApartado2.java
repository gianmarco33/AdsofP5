package adsof1718.grafos.got;
import adsof1718.grafos.*;
import java.util.*;

public class PruebaApartado2 {
	public static void main(String[] args) throws Exception {
		Grafo<PersonajeGOT> g = new GrafoGOT<>("got-s01-vertices.csv","got-s01-arcos.csv");
		
		//Grafo<String> g = new GrafoDirigido<>();
		System.out.println(g.getClass().getName() + "\n");
		System.out.println(g.getVertices());
		
		/*
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
		*/
	}
	
}
