package com.careeroffice.servlet;

import com.careeroffice.model.Category;
import com.careeroffice.service.AuthService;
import com.careeroffice.service.CategoryService;
import com.careeroffice.service.factory.ServiceEnum;
import com.careeroffice.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/create_category"})
public class SuperAdminCreateCategoryServlet extends HttpServlet {

    private static final CategoryService categoryService = (CategoryService) ServiceFactory.getService(ServiceEnum.CategoryService);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AuthService authService = new AuthService(request.getSession());

        if (!authService.isLoggedIn()) {
            response.sendRedirect("login");
            return;
        }

        if (!authService.hasRole("super_admin")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        request.getRequestDispatcher("WEB-INF/views/super_admin/create_category.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String slug = request.getParameter("slug");

        Category category = new Category(-1, title, slug);
        category = categoryService.save(category);

        response.sendRedirect("view_category?id=" + category.getId());
    }
}
