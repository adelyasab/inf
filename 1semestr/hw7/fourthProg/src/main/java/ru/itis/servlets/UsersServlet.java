package ru.itis.servlets;

import lombok.*;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "adelka0508";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private UsersRepository usersRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ageValue = request.getParameter("age");
        List<User> users = null;
        if (ageValue != null) {
            Integer age = Integer.parseInt(ageValue);
            users = usersRepository.findAllByAge(age);
        } else {
            users = usersRepository.findAll();
        }
        request.setAttribute("UsersForJSP", users);
        request.getRequestDispatcher("WEB-INF/JSP/users.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    public void init() throws ServletException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        usersRepository = new UsersRepositoryJdbcImpl(connection);
        /*this.users = new ArrayList<User>();
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Class.forName("org.postgresql.Driver");
        Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("select * from dannie");

        while (result.next()) {
            users.add(User.builder().
                    id(result.getLong("id")).
                    firstname(result.getString("firstname")).
                    lastname(result.getString("lastname")).
                    age(result.getInt("age")).
                    build());
        }*/
    }
}
