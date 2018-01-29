package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import VO.v2_customVO;
import session.SqlMapClient;

/**
 * Servlet implementation class v2__custominsertServlet
 */
@WebServlet("/v2_custominsert.do")
public class v2_custominsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public v2_custominsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/v2_custominsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String a = request.getParameter("id");
			String b = request.getParameter("pw");
			String c = request.getParameter("name");
			String d = request.getParameter("tel");
			
			v2_customVO vo = new v2_customVO();
			vo.setId(a);
			vo.setPw(b);
			vo.setName(c);
			vo.setTel(d);
			
			System.out.println(a +" / " + b +" / "+c+" / " +d);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.insert("v2_custom.v2_addCustom",vo);
			sqlsession.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
