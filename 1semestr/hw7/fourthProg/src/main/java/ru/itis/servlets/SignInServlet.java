package ru.itis.servlets;

import ru.itis.repositories.UsersRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "adelka0508";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/JSP/signIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String login = req.getParameter("login_input");
            String password = req.getParameter("password_input");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            UsersRepositoryJdbcImpl usersRepositoryJdbc = new UsersRepositoryJdbcImpl(connection);
            if (usersRepositoryJdbc.isExistByLoginAndPassword(login, password)) {
                String myUUID = UUID.randomUUID().toString();
                Cookie cookie = new Cookie("user", myUUID);
                usersRepositoryJdbc.addingUUID(myUUID, login);
                resp.addCookie(cookie);
            }
            for (Cookie i : req.getCookies()) {
                if (i.getName().equals("user")) {
                    req.setAttribute("user", i.getValue());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(req, resp);
    }
}
