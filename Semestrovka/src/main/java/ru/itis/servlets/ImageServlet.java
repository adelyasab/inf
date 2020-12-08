package ru.itis.servlets;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("name");
        resp.setContentType("image/png");

        String path = (String) getServletContext().getAttribute("imageDir");

        IOUtils.copyLarge(
                new FileInputStream(path + File.separator + filename),
                resp.getOutputStream()
        );
    }
}
