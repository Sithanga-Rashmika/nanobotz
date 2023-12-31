package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/invoice_servlet")
public class invoice_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isTrue = false;
		String itemPrice = request.getParameter("itemPrice");
		String quantity = request.getParameter("quantity");
		String ProductID = request.getParameter("pid");
		String UserID = request.getParameter("uid");
		String date = request.getParameter("date");

		double price = 0.0;
		double totPrice = 0.0;
		int qty = 0;
		int points = 0;
		int pid = 0;
		int uid = 0;

		
		try {
			price = Double.parseDouble(itemPrice);
			qty = Integer.parseInt(quantity);
			pid = Integer.parseInt(ProductID);
			uid = Integer.parseInt(UserID);
	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			
		}

		try {
			totPrice = (price * qty);

			if (totPrice >= 500 && totPrice < 1500) {
				points = points + 5;
			} else if (totPrice >= 1500 && totPrice < 5000) {
				points = points + 30;
			} else if (totPrice >= 5000 && totPrice < 10000) {
				points = points + 80;
			} else if (totPrice >= 10000) {
				points = (int) (totPrice / 10000) * 200;
			}

			// Create a JSON response
			String jsonResponse = String.format("{\"points\": %d, \"invoiceValue\": %.2f}", points, totPrice);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(jsonResponse);
			
			// Check if the request is from the Buy Now button
			if ("true".equals(request.getParameter("buyNowButton"))) {
			    // Call the DBUtill class to store data in the database
			    isTrue = DBUtill.generateInvoice(uid, date, totPrice, points, qty, pid);
			    if (isTrue) {
			        System.out.println("success..!!");
			        response.getWriter().write("{\"success\": true}");
			    } else {
			        System.out.println("failed...!");
			        response.getWriter().write("{\"success\": false}");
			    }
			    return;
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
