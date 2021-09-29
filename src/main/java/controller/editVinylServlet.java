package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListVinyl;

/**
 * Servlet implementation class editVinylServlet
 */
@WebServlet("/editVinylServlet")
public class editVinylServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editVinylServlet() {
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
		ListVinylHelper dao = new ListVinylHelper();
		
		String artist = request.getParameter("artist");
		String album = request.getParameter("album");
		String color = request.getParameter("color");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListVinyl vinylToUpdate = dao.searchForAlbumById(tempId);
		vinylToUpdate.setArtist(artist);
		vinylToUpdate.setAlbum(album);
		vinylToUpdate.setColor(color);
		
		dao.updateVinyl(vinylToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllVinylsServlet").forward(request, response);
	}

}
