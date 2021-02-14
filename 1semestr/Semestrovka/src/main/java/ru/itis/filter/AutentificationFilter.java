package ru.itis.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AutentificationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //запись к нужному виду
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //берем сессию у запроса
        //false  - только сществующую, если ее не было - вернем null
        HttpSession session = request.getSession(false);
        //аутентифицирован ли пользователь
        boolean isAuthenticated = false;
        //существ ли сессия вообще?
        boolean sessionExists = session != null;
        // идет ли запрос на страницу входа или регистрации ?
        boolean isRequestOnOpenPage = request.getRequestURI().equals("/signIn") ||
                request.getRequestURI().equals("/signUp") ||
                request.getRequestURI().equals("/main") || request.getRequestURI().startsWith("/css");
        //если сессия есть
        if (request.getRequestURI().equals("/main") && sessionExists){
            session.setAttribute("user", null);
        }
        if (sessionExists) {
            //проверяем есть ли атрибут юзер
            isAuthenticated = session.getAttribute(("user")) != null;

        }
        //если авторизован и запрашивает страницу не для всех или не авторизован, но запрос на страницу для всех
        if (isAuthenticated && !isRequestOnOpenPage || !isAuthenticated && isRequestOnOpenPage || isAuthenticated && request.getRequestURI().startsWith("/css")){
            //отдаем, что хочет
            filterChain.doFilter(request, response);
        } else if (isAuthenticated && isRequestOnOpenPage) {
            //аутентифицирован и запрос нe для всех
            //отдаем профиль
            response.sendRedirect(("/profile"));
        } else {
            //не аутентифицирован и запрос на не для всех
            response.sendRedirect("/signIn");
        }

    }

    @Override
    public void destroy() {

    }
}
