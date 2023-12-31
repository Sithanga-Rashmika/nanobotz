package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product_servlet")
public class product_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		double price =0.0;
		String priceString = request.getParameter("price");
		
		
		try {
			if (priceString != null) {
		        price = Double.parseDouble(priceString);
		    }
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		boolean isTrue;
		
		try {
			isTrue = DBUtill.insertProduct(name, brand, price);
			if(isTrue == true){
				System.out.println("success");
				RequestDispatcher dis = request.getRequestDispatcher("addNewProduct.jsp");
				dis.forward(request, response);
			}else {
				System.out.println("failed");
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
