import java.time.LocalDate;
import java.util.List;

import controller.CollectorHelper;
import controller.ListDetailsHelper;
import model.Collector;
import model.ListDetails;


/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Oct 4, 2021
 */

/**
 * @author cmboe
 *
 */
public class ListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collector colby = new Collector("Colby");
		CollectorHelper ch = new CollectorHelper();
		ch.insertCollector(colby);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails colbysList = new ListDetails("Colby's List",LocalDate.now(),colby);
		ldh.insertNewListDetails(colbysList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}
	

}
