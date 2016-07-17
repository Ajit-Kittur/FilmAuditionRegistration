package com.actingregistration.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actingregistration.entities.Actor;
import com.actingregistration.service.ActorService;
import com.actingregistration.serviceImpl.ActorServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class actorservlet
 */
@WebServlet("/actorservlet")
public class actorservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ActorService actorService=new ActorServiceImpl();
    /**
     * Default constructor. 
     */
    public actorservlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action = request.getParameter("action");
		PrintWriter printWriter=response.getWriter();
		
		if (action.equals("register")){ 
			try {
				Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
				Map<String, Boolean> value=new LinkedHashMap<String, Boolean>();
				value.put("check",actorService.actorRegistration(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("emailId"), request.getParameter("password"), Long.parseLong(request.getParameter("contactNo"))));
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
				Actor actor=actorService.actorLogin(request.getParameter("emailId"), request.getParameter("password"));
				String userJson1=gson1.toJson(actor);
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
				value.put("check",actorService.forgotPassword(request.getParameter("emailId"), request.getParameter("forgot_psw"), Long.parseLong(request.getParameter("contactNo"))));
				String userJson=gson.toJson(value);
				System.out.println(userJson);
				printWriter.write(userJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(action.equals("getAllUsers")){
			try{
				Gson gson=new Gson();
				List<Actor> actorsList=actorService.getAllActors();
				System.out.println(gson.toJson(actorsList));
				printWriter.write(gson.toJson(actorsList));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
