/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Oct 4, 2021
 */
package model;



import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author cmboe
 *
 */
@Entity
public class ListDetails {
	//annotated variables
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate purchaseDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Collector collector;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListVinyl> listOfVinyls;
	//constructors
	public ListDetails() {
		super();
	}
	public ListDetails(int id, String listName, LocalDate purchaseDate,Collector collector, List<ListVinyl> listOfVinyls) {
		this.id = id;
		this.listName = listName;
		this.purchaseDate = purchaseDate;
		this.collector = collector;
		this.listOfVinyls = listOfVinyls;
	}
	public ListDetails(String listName, LocalDate purchaseDate,Collector collector, List<ListVinyl> listOfVinyls) {
		this.listName = listName;
		this.purchaseDate = purchaseDate;
		this.collector = collector;
		this.listOfVinyls = listOfVinyls;
	}
	public ListDetails(String listName, LocalDate purchaseDate,Collector collector) {
		this.listName = listName;
		this.purchaseDate = purchaseDate;
		this.collector = collector;
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
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the purchaseDate
	 */
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	/**
	 * @return the collector
	 */
	public Collector getCollector() {
		return collector;
	}
	/**
	 * @param collector the collector to set
	 */
	public void setCollector(Collector collector) {
		this.collector = collector;
	}
	/**
	 * @return the listOfVinyls
	 */
	public List<ListVinyl> getListOfVinyls() {
		return listOfVinyls;
	}
	/**
	 * @param listOfVinyls the listOfVinyls to set
	 */
	public void setListOfVinyls(List<ListVinyl> listOfVinyls) {
		this.listOfVinyls = listOfVinyls;
	} 
	
	//methods
	@Override
	public String toString() {
		return "ListDetails [id="+id+" listName="+listName+" purchaseDate="+purchaseDate+" collector="+collector+" listOfVinyls="+listOfVinyls;
	}
}
