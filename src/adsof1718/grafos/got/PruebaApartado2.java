package adsof1718.grafos.got;
import java.util.*;

public class PruebaApartado2 {
	public static void main(String[] args) throws Exception {
		GrafoGOT g;
		
		g = new GrafoGOT("got-s01-vertices.csv", "got-s01-arcos.csv");

		System.out.println("Casas del grafo: ");
		List<String> lCasas = g.casas();
		System.out.println("\t" + lCasas + "\n");
		/*for(String casa : lCasas)
			System.out.println(casa);*/
		
		System.out.println("Miembros de la casa Stark: ");
		List<String> lPersXCasa = g.miembrosCasa("Stark");
		System.out.println("\t" + lPersXCasa + "\n");
		/*for(String pers : lPersXCasa)
			System.out.println(pers);*/
		
		System.out.println("Grado de los personajes: ");
		Map<String,Integer> mapaGrados = g.gradoPersonajes();
		System.out.println("\t" + mapaGrados + "\n");
		
		System.out.println("Grado ponderado de los personajes: ");
		Map<String,Double> mapaPonderado = g.gradoPonderadoPersonajes();
		System.out.println("\t" + mapaPonderado + "\n");
		
		System.out.println("Personajes relevantes: ");
		Map<String,Double> mapaRelevantes = g.personajesRelevantes();
		System.out.println("\t" + mapaRelevantes + "\n");

	}
	
}
