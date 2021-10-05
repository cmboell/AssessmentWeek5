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
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		ListVinylHelper lvh = new ListVinylHelper();
		CollectorHelper ch = new CollectorHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String collectorName = request.getParameter("collectorName");
		//find our add the new collector
		Collector newCollector = ch.findCollector(collectorName);
		
		LocalDate ld;
		try {
		ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
		ld = LocalDate.now();
		}
		try {
		//vinyls are selected in list to add
		String[] selectedItems = request.getParameterValues("allVinylsToAdd");
		List<ListVinyl> selectedItemsInList = new ArrayList<ListVinyl>();
		for (int i = 0; i < selectedItems.length; i++) {
		System.out.println(selectedItems[i]);
		ListVinyl c = lvh.searchForAlbumById(Integer.parseInt(selectedItems[i]));
		selectedItemsInList.add(c);
		}
		listToUpdate.setListOfVinyls(selectedItemsInList);
		} catch (NullPointerException ex) {
		// no vinyls selected in list/set to an empty list
		List<ListVinyl> selectedItemsInList = new ArrayList<ListVinyl>();
		listToUpdate.setListOfVinyls(selectedItemsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setPurchaseDate(ld);
		listToUpdate.setCollector(newCollector);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
}
