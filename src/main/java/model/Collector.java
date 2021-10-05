/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Oct 4, 2021
 */
package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="collector")
public class Collector {
	//variables
	@Id
	@GeneratedValue
	private int id;
	private String collectorName;
	//constructors
	public Collector() {
		super();
	}
	public Collector(int id, String collectorName) {
		super();
		this.id = id;
		this.collectorName = collectorName;
	}
	public Collector(String collectorName) {
		super();
		this.collectorName = collectorName;
	}
	//getters/setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the collectorName
	 */
	public String getCollectorName() {
		return collectorName;
	}
	/**
	 * @param shopperName the shopperName to set
	 */
	//methods
	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}
	
	@Override
	public String toString() {
		return "Collector [id="+id+", collectorName="+collectorName+"]";
	}
}
