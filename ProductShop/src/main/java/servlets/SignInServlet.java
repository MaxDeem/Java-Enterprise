package servlets;

import forms.LogInForm;
import services.AuthService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private AuthService authService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        authService = (AuthService)context.getAttribute("authService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/signIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LogInForm loginForm = LogInForm.builder()
                .email(email)
                .password(password)
                .build();

        authService.logIn(loginForm);
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Ой все.</h1>");
        writer.println("<h2>Ясно.</h2>");
        writer.println("<h3>раньше ты был другим..........</h3>");
    }
}
