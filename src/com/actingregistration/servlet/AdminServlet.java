package com.actingregistration.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actingregistration.entities.Admin;
import com.actingregistration.service.AdminService;
import com.actingregistration.serviceImpl.AdminServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminservlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService adminService=new AdminServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		String action = request.getParameter("action");
		PrintWriter printWriter=response.getWriter();
		
		if (action.equals("register")){ 
			try {
				Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
				Map<String, Boolean> value=new LinkedHashMap<String, Boolean>();
				value.put("check",adminService.adminRegistration(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("emailId"), request.getParameter("password"), Long.parseLong(request.getParameter("contactNo"))));
				String userJson=gson.toJson(value);
				System.out.println(userJson);
				printWriter.write(userJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(action.equals("login")){
			try {
				Gson gson1=new Gson();
				Admin admin=adminService.adminLogin(request.getParameter("emailId"), request.getParameter("password"));
				String userJson1=gson1.toJson(admin);
				System.out.println(userJson1);
				printWriter.write(userJson1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(action.equals("loginforgot")){
			try {
				Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
				Map<String, Boolean> value=new LinkedHashMap<String, Boolean>();
				value.put("check",adminService.forgotPassword(request.getParameter("emailId"), request.getParameter("forgot_psw"), Long.parseLong(request.getParameter("contactNo"))));
				String userJson=gson.toJson(value);
				System.out.println(userJson);
				printWriter.write(userJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
