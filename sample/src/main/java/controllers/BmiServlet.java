package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BmiServlet
 */
@WebServlet("/BmiServlet")
public class BmiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmiServlet() {
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ポストデータの内容をdouble値として取得
		double h = Double.parseDouble(request.getParameter("height"));
		double w = Double.parseDouble(request.getParameter("weight"));
		//BMI値を算出し、リクエスト属性BMIにセット
		double bmi = w / (h * h);
		request.setAttribute("bmi", bmi);
		//BMI値から判定したランクをリクエスト属性rankにセット
		if(bmi < 18.5) {
			request.setAttribute("rank", "やせ気味");
		}
		else if(bmi < 25) {
			request.setAttribute("rank", "標準");
		}
		else {
			request.setAttribute("rank","肥満気味");
		}
		//bmi_result.jspに処理を転送
		request.getRequestDispatcher("/bmi_result.jsp").forward(request,response);
	}

}
