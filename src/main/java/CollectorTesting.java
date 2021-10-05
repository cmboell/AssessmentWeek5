

import java.util.List;

import controller.CollectorHelper;
import model.Collector;

/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Oct 4, 2021
 */

//tester class to see if code for collector was working
public class CollectorTesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collector colby = new Collector("Colby");
		Collector margot = new Collector("Margot");
		CollectorHelper ch = new CollectorHelper();
		
		ch.insertCollector(colby);
		ch.insertCollector(margot);
		List<Collector> allCollectors = ch.showAllCollectors();
		for(Collector a: allCollectors) {
			System.out.println(a);
		}
	}

}
