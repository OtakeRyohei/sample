package controllers;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.Player;
import services.PlayerService;

/**
 * Servlet implementation class PlayerAddServlet
 */
@WebServlet("/PlayerAddServlet")
public class PlayerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/player_add.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlayerService ps = new PlayerService();
		
		String name = request.getParameter("name");
		String position = request.getParameter("position");
		
		int countryId = 1;
		int uniformNum = 99;
		String club = "未所属";
		LocalDate birth = LocalDate.of(2000, 1, 1);
		int height = 180;
		int weight = 70;
		
		Player p = new Player(0, countryId, uniformNum, position, name, club, birth, height, weight);
		ps.insert(p);
		
		response.sendRedirect("PlayerServlet");
	}

}
