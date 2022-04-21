package chap14;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S14Servlet01
 */
@WebServlet("/S14Servlet01")
public class S14Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S14Servlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// database에서 records 가져오기
		// 1. 연결설정
		String host = "13.125.59.156";
		String schema = "w3shools";
		String id = "root";
		String pw = "XDsQluLHy3tW";
		
		Connection con = null;
		// 2. statement 객체 생성
		// 3. 쿼리 실행
		// 4. 실행결과 정제
		// 5. 자원닫기
		
		/*
		List<String> cities = new ArrayList<>();
		cities.add("Berlin");
		cities.add("London");
		cities.add("Madrid");
		*/
		
		// request에 records 넣기
		request.setAttribute("cities", cities);
		
		// jsp에 forward
		String location = "/WEB-INF/view/chap14/ex01.jsp";
		request.getRequestDispatcher(location).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
