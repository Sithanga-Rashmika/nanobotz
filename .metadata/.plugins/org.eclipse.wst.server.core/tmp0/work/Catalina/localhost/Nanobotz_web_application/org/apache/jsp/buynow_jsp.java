/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.84
 * Generated at: 2023-12-30 18:37:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class buynow_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1703755842936L));
    _jspx_dependants.put("jar:file:/E:/Java%20workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Nanobotz_web_application/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.4.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("	$(document)\r\n");
      out.write("			.ready(\r\n");
      out.write("					function() {\r\n");
      out.write("\r\n");
      out.write("						// Function to handle quantity change and update invoice and points\r\n");
      out.write("						function updateInvoiceAndPoints() {\r\n");
      out.write("							var itemPrice = parseFloat($('#itemPrice').val());\r\n");
      out.write("							var quantity = parseInt($('#quantity').val());\r\n");
      out.write("\r\n");
      out.write("							// AJAX call to the servlet to calculate points and update UI\r\n");
      out.write("							$.ajax({\r\n");
      out.write("								type : 'POST',\r\n");
      out.write("								url : 'invoice_servlet',\r\n");
      out.write("								data : {\r\n");
      out.write("									itemPrice : itemPrice,\r\n");
      out.write("									quantity : quantity,\r\n");
      out.write("									pid : $('#pid').val(),\r\n");
      out.write("									uid : $('#uid').val(),\r\n");
      out.write("									date : $('#dates').val(),\r\n");
      out.write("\r\n");
      out.write("								},\r\n");
      out.write("								success : function(response) {\r\n");
      out.write("									$('#invoiceValue').text(\r\n");
      out.write("											response.invoiceValue);\r\n");
      out.write("									$('#points').text(response.points);\r\n");
      out.write("								},\r\n");
      out.write("								error : function(error) {\r\n");
      out.write("									console.error('Error updating values:',\r\n");
      out.write("											error);\r\n");
      out.write("								}\r\n");
      out.write("							});\r\n");
      out.write("						}\r\n");
      out.write("\r\n");
      out.write("						// Attach event handler to quantity input\r\n");
      out.write("						$('#quantity').on('input', updateInvoiceAndPoints);\r\n");
      out.write("\r\n");
      out.write("						$('#buy_now_form').submit(\r\n");
      out.write("								function(event) {\r\n");
      out.write("									// Prevent default form submission\r\n");
      out.write("									event.preventDefault();\r\n");
      out.write("\r\n");
      out.write("									// Get values from form inputs\r\n");
      out.write("									var itemPrice = parseFloat($('#itemPrice')\r\n");
      out.write("											.val());\r\n");
      out.write("									var quantity = parseInt($('#quantity')\r\n");
      out.write("											.val());\r\n");
      out.write("\r\n");
      out.write("									// Perform the AJAX call\r\n");
      out.write("									$.ajax({\r\n");
      out.write("										type : 'POST',\r\n");
      out.write("										url : 'invoice_servlet',\r\n");
      out.write("										data : {\r\n");
      out.write("											itemPrice : itemPrice,\r\n");
      out.write("											quantity : quantity,\r\n");
      out.write("											pid : $('#pid').val(),\r\n");
      out.write("											uid : $('#uid').val(),\r\n");
      out.write("											date : $('#dates').val(),\r\n");
      out.write("											buyNowButton : 'true'\r\n");
      out.write("										},\r\n");
      out.write("\r\n");
      out.write("										success : function(response) {\r\n");
      out.write("											$('#invoiceValue').text(\r\n");
      out.write("													response.invoiceValue);\r\n");
      out.write("											$('#points').text(response.points);\r\n");
      out.write("										},\r\n");
      out.write("										error : function(error) {\r\n");
      out.write("											console.error(\r\n");
      out.write("													'Error updating values:',\r\n");
      out.write("													error);\r\n");
      out.write("										}\r\n");
      out.write("									});\r\n");
      out.write("								});\r\n");
      out.write("\r\n");
      out.write("						// Initial calculation on page load\r\n");
      out.write("						updateInvoiceAndPoints();\r\n");
      out.write("\r\n");
      out.write("						// Set the current date and time \r\n");
      out.write("						var currentDate = new Date();\r\n");
      out.write("						var formattedDate = currentDate.toLocaleString('en-US',\r\n");
      out.write("								{\r\n");
      out.write("									year : 'numeric',\r\n");
      out.write("									month : '2-digit',\r\n");
      out.write("									day : '2-digit',\r\n");
      out.write("									hour : '2-digit',\r\n");
      out.write("									minute : '2-digit'\r\n");
      out.write("								});\r\n");
      out.write("						$('#dates').val(formattedDate);\r\n");
      out.write("\r\n");
      out.write("						// Function to extract URL parameters\r\n");
      out.write("						function getParameterByName(name, url) {\r\n");
      out.write("							if (!url)\r\n");
      out.write("								url = window.location.href;\r\n");
      out.write("							name = name.replace(/[\\[\\]]/g, '\\$&');\r\n");
      out.write("							var regex = new RegExp('[?&]' + name\r\n");
      out.write("									+ '(=([^&#]*)|&|#|$)'), results = regex\r\n");
      out.write("									.exec(url);\r\n");
      out.write("							if (!results)\r\n");
      out.write("								return null;\r\n");
      out.write("							if (!results[2])\r\n");
      out.write("								return '';\r\n");
      out.write("							return decodeURIComponent(results[2].replace(/\\+/g,\r\n");
      out.write("									' '));\r\n");
      out.write("						}\r\n");
      out.write("\r\n");
      out.write("						// Set values from URL parameters\r\n");
      out.write("						$('#pid').val(getParameterByName('id'));\r\n");
      out.write("						$('#uid').val(getParameterByName('uid'));\r\n");
      out.write("						$('#itemName').val(getParameterByName('name'));\r\n");
      out.write("						$('#itemPrice').val(getParameterByName('price'));\r\n");
      out.write("\r\n");
      out.write("					});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	");

	HttpSession currentSession = request.getSession();
	Integer UIDAttribute = (Integer) currentSession.getAttribute("UID");
	int UID = (UIDAttribute != null) ? UIDAttribute.intValue() : 0;

	String PID = request.getParameter("id");
	
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		var uidValue =\r\n");
      out.write("	");
      out.print(UID);
      out.write("\r\n");
      out.write("		;\r\n");
      out.write("		$(document).ready(function() {\r\n");
      out.write("			$('#uid').val(uidValue);\r\n");
      out.write("		});\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<form id='buy_now_form' action='buy_now' method='post'>\r\n");
      out.write("		Product Id <input type='text' name='pid' id='pid'><br>\r\n");
      out.write("		Customer Id <input type='text' name='uid' id='uid'><br>\r\n");
      out.write("		Item name <input type='text' name='itemName' id='itemName'><br>\r\n");
      out.write("		Item Price <input type='text' name='itemPrice' id='itemPrice'><br>\r\n");
      out.write("		Quantity <input type='number' name='quantity' id='quantity' min='0'><br>\r\n");
      out.write("		Date <input type='text' name='date' id='dates'><br>\r\n");
      out.write("\r\n");
      out.write("		<h4>invoice details</h4>\r\n");
      out.write("		<p>\r\n");
      out.write("			User ID:\r\n");
      out.write("			");
      out.print(UID);
      out.write("</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			Product ID:\r\n");
      out.write("			");
      out.print(PID);
      out.write("</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			Invoice Value: $<span id='invoiceValue'>0.00</span>\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			Points: <span id='points'>0</span>\r\n");
      out.write("		</p>\r\n");
      out.write("\r\n");
      out.write("		<input type='submit' name='buyNowButton' id='buy_now_button'\r\n");
      out.write("			value='Buy now'>\r\n");
      out.write("	</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
