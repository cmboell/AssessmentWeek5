import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.Collector;
import model.ListDetails;

import model.ListVinyl;


/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Oct 4, 2021
 */

/**
 * @author cmboe
 *
 */
public class CollectorTesting2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collector colby = new Collector("Colby");
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListVinyl queen = new ListVinyl("Queen", "Jazz","Blue");
		ListVinyl slipknot = new ListVinyl("Slipknot", "Iowa","White");
		List<ListVinyl> colbyItems = new ArrayList<ListVinyl>();
		colbyItems.add(queen);
		colbyItems.add(slipknot);
		ListDetails colbyList = new ListDetails("Colby's Vinyls ", LocalDate.now(), colby);
		colbyList.setListOfVinyls(colbyItems);
		ldh.insertNewListDetails(colbyList);
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
		System.out.println(a.toString());
		}
		}
		
}
