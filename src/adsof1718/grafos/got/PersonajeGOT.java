/**
 * 
 */
package adsof1718.grafos.got;


/**
 * @author gianmarco
 *
 */
public class PersonajeGOT{
	private Integer id;
	private String nombre;
	private String casa;
	public PersonajeGOT(Integer id, String nombre, String casa) {
		this.id = id;
		this.nombre = nombre;
		this.casa = casa;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the casa
	 */
	public String getCasa() {
		return casa;
	}
	/**
	 * @param casa the casa to set
	 */
	public void setCasa(String casa) {
		this.casa = casa;
	}
	
	@Override
	public String toString() {
		return "{Nombre: " +nombre +  ", Casa: " +casa+ "}";
	}
	
	
}
