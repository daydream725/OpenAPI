package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import VO.v2_itemVO;
import session.SqlMapClient;

/**
 * Servlet implementation class v2_iteminsertSerlvet
 */
@WebServlet("/v2_iteminsert.do")
public class v2_iteminsertSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public v2_iteminsertSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SqlSession sql = SqlMapClient.getSession();
		
		int ret = sql.selectOne("v2_item.selectLastNo");
		
		List<v2_itemVO> list = sql.selectList("v2_item.selectItemList");
		request.setAttribute("list", list);
		sql.commit();
		
		
		request.setAttribute("lastno", ret);
		request.getRequestDispatcher("/WEB-INF/v2_iteminsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String[] a = request.getParameterValues("no");
			String[] b = request.getParameterValues("name");
			String[] c = request.getParameterValues("price");
			String[] d = request.getParameterValues("qty");
			
			List<v2_itemVO> list = new ArrayList<v2_itemVO>();
			for(int i=0;i<a.length;i++) {
				v2_itemVO vo = new v2_itemVO();
				vo.setNo(Integer.parseInt(a[i]));
				vo.setName(b[i]);
				vo.setPrice(Integer.parseInt(c[i]));
				vo.setQty(Integer.parseInt(d[i]));
				list.add(vo);
			}
			SqlSession sql = SqlMapClient.getSession();
			sql.insert("v2_item.insertItemMulti",list);
			sql.commit();
			
			response.sendRedirect("v2_iteminsert.do");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
