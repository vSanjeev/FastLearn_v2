/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Sanjeev
 */
public class UserType extends HttpServlet {
    @Resource(name = "DerbyDB_FastLearn")
    private DataSource derbyDB_FastLearn;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet UserType</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet UserType at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            Connection con=derbyDB_FastLearn.getConnection();
            PreparedStatement ps=con.prepareStatement("select AccType from LoginDetails where UserName=(?) and Password=(?)");     
            Statement s = con.createStatement();
        String user = request.getParameter("username");
        String pwd = request.getParameter("password");
        ps.setString(1, user);
        ps.setString(2,pwd);
  //      String query="Select AccType from LoginDetails where UserName="+"'"+user+"'";
        ResultSet rs = ps.executeQuery();//query);
        String s1 = null;
        while(rs.next())
            {
                s1=rs.getString(1);
                out.print(s1);
                out.println("<br>");
            }
        if(user.equalsIgnoreCase(s1)){
            if(pwd.equalsIgnoreCase("studpass"))
            {
            RequestDispatcher rd = request.getRequestDispatcher("/Student/StudentHome.jsp");
            rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("/Common/LoginError.jsp");
                rd.forward(request, response);
            }
        }
        }
        catch(Exception ex)
        {
            out.println("Couldn't able to establish connection="+ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
