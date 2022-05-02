package app01;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sun.net.httpserver.Authenticator.Success;

import app01.dao.ReplyDao;
import app01.dto.ReplyDto;

/**
 * Servlet implementation class ReplyRemoveServlet
 */
@WebServlet("/reply/delete")
public class ReplyRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
    	ServletContext application = getServletContext();
    	this.ds = (DataSource)application.getAttribute("dbpool");
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
		// request 파라미터 수집, 가공
		String replyIdStr = request.getParameter("id");
		String boardIdStr = request.getParameter("boardId");
		
		ReplyDto replyDto = new ReplyDto();
		
		replyDto.setId(Integer.parseInt(replyIdStr));
		replyDto.setBoardId(Integer.parseInt(boardIdStr));
		
		// bussiness logic 처리
		ReplyDao replyDao = new ReplyDao();
		boolean success = false;
		
		try(Connection con = ds.getConnection()){
			success = replyDao.delete(con, replyDto.getId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// 결과 세팅 xx
		
		// forward / redirect
		String location = request.getContextPath() + "/board/get" + "?" + "id=" + boardIdStr;
		response.sendRedirect(location);
	}

}
