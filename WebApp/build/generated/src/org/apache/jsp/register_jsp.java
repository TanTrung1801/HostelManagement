package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Register Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Register Page</h1>\r\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\r\n");
      out.write("            User ID </br>\r\n");
      out.write("                <input type=\"text\" name=\"userID\" required=\"\" placeholder=\"Input your ID\"/></br>    \r\n");
      out.write("            Email </br>\r\n");
      out.write("                <input type =\"email\" name=\"email\" required=\"\" placeholder=\"Input your email\"></br>\r\n");
      out.write("            Role </br>\r\n");
      out.write("                <input type =\"radio\" name=\"roleID\" name=\"\" value=\"user\" checked> User\r\n");
      out.write("                <input type=\"radio\" name=\"roleID\" value=\"manager\"> Manager</br>\r\n");
      out.write("            Password </br> \r\n");
      out.write("                <input type=\"password\" name=\"password\" required=\"\" placeholder=\"Input your password\"/><br>\r\n");
      out.write("            Confirm  </br>\r\n");
      out.write("                <input type=\"password\" name=\"confirm\" required=\"\"placeholder=\"Confirm your password\"/></br>\r\n");
      out.write("            Full Name </br> \r\n");
      out.write("                <input type=\"text\" name=\"fullName\" placeholder=\"Input Your Name \"/></br>\r\n");
      out.write("            Date of Birth </br> \r\n");
      out.write("                <input type=\"date\" name=\"dateOfBirth\"/></br>\r\n");
      out.write("            Identity Card </br> \r\n");
      out.write("                <input type=\"text\" name=\"idCard\" placeholder=\"Input Your Indentity Card\"/></br>\r\n");
      out.write("            Phone Number </br>\r\n");
      out.write("                <input type=\"text\" name=\"phone\" placeholder=\"Input Your Phone Number\"/></br>\r\n");
      out.write("            <div style=\"margin-left: 95px\" class=\"g-recaptcha\" data-sitekey=\"6Le7ZqgeAAAAAHHg2a5N9WAw9H4BzBS-8UOLG5TC\"></div>\r\n");
      out.write("                <input type=\"submit\" name=\"action\" value=\"Register\"/>\r\n");
      out.write("                <input type=\"reset\" value=\"Reset\"/> \r\n");
      out.write("            </form>\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <h2>\r\n");
      out.write("            --Already Have An Account ?-- </br>\r\n");
      out.write("            <button href=\"login.jsp\">Sign In</button>\r\n");
      out.write("        </h2>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <h3>\r\n");
      out.write("            --Forgot Your Password ?--</br>\r\n");
      out.write("             <button href=\"forgot_password.jsp\">Forgot my password</button>\r\n");
      out.write("        </h3>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
