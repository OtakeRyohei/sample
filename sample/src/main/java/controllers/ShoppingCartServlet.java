package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,String[]> parameterMap = request.getParameterMap();
		
		if(parameterMap.containsKey("reset") == true) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<String> orders = (List<String>) session.getAttribute("orders");
		
		if(orders == null) {
			orders = new ArrayList<String>();
		}
		
		String newOrder = request.getParameter("newOrder");
		
		if(newOrder.isEmpty() == false) {
			orders.add(newOrder);
		}
		session.setAttribute("orders", orders);
		request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
	}

}
