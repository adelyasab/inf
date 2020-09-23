package ru.itis.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/hello")
public class SimpleHTMLServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "adelka0508";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/html/hello.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name_input");

        try {
            Connection connection = null;
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = null;
            statement = connection.createStatement();
            //language=SQL
            String sqlInsertUser = "insert into dannie(name ) " +
                    "values (?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(sqlInsertUser);
            preparedStatement.setString(1, name);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }
}
