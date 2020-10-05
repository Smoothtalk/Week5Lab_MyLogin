package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountService;
import model.User;

/**
 *
 * @author 775653
 */
public class LoginServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User authenticatedUser = (User) session.getAttribute("user");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null || password == null){
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        AccountService acctService = new AccountService();
        authenticatedUser = acctService.login(username, password);   
        if(authenticatedUser != null){
            session.setAttribute("user", authenticatedUser);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("loginError", "Error logging in");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

}
