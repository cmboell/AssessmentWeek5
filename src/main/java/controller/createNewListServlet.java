package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Collector;
import model.ListDetails;
import model.ListVinyl;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListVinylHelper lvh = new ListVinylHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String collectorName = request.getParameter("collectorName");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedVinyls = request.getParameterValues("allVinylsToAdd");
		List<ListVinyl> selectedVinylsInList = new ArrayList<ListVinyl>();
		
		if(selectedVinyls != null && selectedVinyls.length > 0) {
			for(int i = 0; i<selectedVinyls.length; i++) {
				System.out.println(selectedVinyls[i]);
				ListVinyl c = lvh.searchForAlbumById(Integer.parseInt(selectedVinyls[i]));
				selectedVinylsInList.add(c);
			}
		}
		
		Collector collector = new Collector(collectorName);
		ListDetails cld = new ListDetails(listName, ld, collector);
		cld.setListOfVinyls(selectedVinylsInList);
		ListDetailsHelper vlh = new ListDetailsHelper();
		vlh.insertNewListDetails(cld);
		
		System.out.println("Success!");
		System.out.println(cld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
