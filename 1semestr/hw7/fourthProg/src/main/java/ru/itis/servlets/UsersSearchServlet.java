package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.ClassForFirstname;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users/search")
public class UsersSearchServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "adelka0508";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String str = request.getParameter("firstname");
//
//        if (str != null) {
//            doPost(request, response);
//        }
////        String str = request.getParameter("firstname");
//        List<User> users = new ArrayList<>();
        ClassForFirstname str = objectMapper.readValue(request.getReader(), ClassForFirstname.class);
        System.out.println(str.firstname);
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            UsersRepositoryJdbcImpl usersRepositoryJdbc = new UsersRepositoryJdbcImpl(connection);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().println(objectMapper.writeValueAsString(usersRepositoryJdbc.findAllByBeginning(str.firstname)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/html/users_search.html").forward(request, response);
    }
}
