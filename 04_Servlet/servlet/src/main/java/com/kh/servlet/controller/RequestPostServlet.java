package com.kh.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/posttest.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("userName"); // 최지원 | ""
		String gender = request.getParameter("gender"); // M | F | null
		int age = Integer.parseInt(request.getParameter("age")); // "55"-> 55 | ""
		String city = request.getParameter("city"); // "경기" | "서울" | "대구"등...
		double height = Double.parseDouble(request.getParameter("height")); // "180.0" -> 180.0

		// 체크박스와같이 여러개의 값을 추출하고자할 때
		String[] foods = request.getParameterValues("food"); // ["한식", "일식"] || null

		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		System.out.println("foods : " + String.join(", ", foods));

		RequestDispatcher view=request.getRequestDispatcher("/views/responsePage.jsp");
		
		view.forward(request, response);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
