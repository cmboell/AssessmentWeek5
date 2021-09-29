package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListVinyl;

/**
 * Servlet implementation class addVinylServlet
 */
@WebServlet("/addVinylServlet")
public class addVinylServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addVinylServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String artist = request.getParameter("artist");
		String album = request.getParameter("album");
		String color = request.getParameter("color");
		
		ListVinyl lv = new ListVinyl(artist,album,color);
		ListVinylHelper dao = new ListVinylHelper();
		dao.insertVinyl(lv);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
