package com.kosa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.dao.BoardDAO;
import com.kosa.model.BoardVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	public BoardController() {
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd"); // ~~~?cmd=list
		System.out.println("cmd : " + cmd);

		if (cmd.equals("list")) {
			list(request, response);
		}

		if (cmd.equals("writeForm")) {
			request.getRequestDispatcher("/WEB-INF/views/writeForm.jsp").forward(request, response);
		}

		if (cmd.equals("write")) {
			write(request, response);
		}

		if (cmd.equals("detail")) {
			detail(request, response);
		}

		if (cmd.equals("delete")) {
			delete(request, response);
		}

		if (cmd.equals("update")) {
			update(request, response);
		}

		if (cmd.equals("searchForm")) {
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);
			/* search(request, response); */
		}

		if (cmd.equals("search")) {
			search(request, response);
		}
		if (cmd.equals("search2")) {
			search2(request, response);
		}

	} // service end

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll();

		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
		} else {
			// response.sendRedirect("index.html");
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}

	private void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		int result = dao.insert(vo);

		if (result > 0) {
			response.sendRedirect("board?cmd=list");
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}

	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.selectBySeq(seq);

		if (vo != null) {
			request.setAttribute("dto", vo);
			request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);

//			int seqnum = vo.getSeq();
//			String title = vo.getTitle();
//			String writer = vo.getWriter();
//			String content = vo.getContent();
//			request.setAttribute("seq", seqnum);
//			request.setAttribute("title", title);
//			request.setAttribute("writer", writer);
//			request.setAttribute("content", content);
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDAO dao = new BoardDAO();
		int result = dao.delete(seq);

		if (result > 0) {
			response.sendRedirect("board?cmd=list");
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		int result = dao.update(vo);

		if (result > 0) {
			response.sendRedirect("board?cmd=list");
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}

//	단일검색
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");

		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("keyvalue", keyvalue);

		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList(map);

		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}

	}

//	다중검색
	private void search2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String keyvalue = request.getParameter("keyvalue");

		Map<String, String> map = new HashMap<String, String>();
		map.put("writer", writer);
		map.put("content", content);
		map.put("title", title);
		map.put("keyvalue", keyvalue);

		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList2(map);

		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}

	}
}
