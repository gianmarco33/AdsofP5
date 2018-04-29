package adsof1718.grafos.got;
import adsof1718.grafos.*;
import java.util.*;

public class PruebaApartado2 {
	public static void main(String[] args) throws Exception {
		GrafoGOT g;
		
		g = new GrafoGOT("got-s01-vertices.csv", "got-s01-arcos.csv");
		//System.out.println(grafo.getVertices());
		
		//System.out.println(g);
		
		//Vertice<PersonajeGOT> v1 = g.getVertice("Arya Stark");
		//System.out.println(v1);
		
		/*List<String> lCasas = g.casas();
		for(String casa : lCasas)
			System.out.println(casa);*/
		
		/*List<String> lPersXCasa = g.miembrosCasa("Stark");
		for(String pers : lPersXCasa)
			System.out.println(pers);*/
		
		
		/*Map<String,Integer> mapa = g.gradoPersonajes();
		System.out.println(mapa);*/
		
		/*Map<String,Double> mapa = g.gradoPonderadoPersonajes();
		System.out.println(mapa);*/
		
		Map<String,Double> mapa = g.personajesRelevantes();
		System.out.println(mapa);
		
		
		
		
	}
	
}
