/**
 * 
 */
package grafos;

/**
 * @author gianmarco
 *
 */
public abstract class Grafo<T> {
	private final int id;
	private T datos;
	protected Map<Integer, Vertice<T>> vertices;
	
	
	public Vertice<T> addVertice(T datos);
	protected Vertice<T> addVertice(int id, T datos);
	public List<Vertice<T>> getVertices();
	public int getNumVertices();
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2);
	public int getNumArcos();
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
	public String toString(); // los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
	
}
