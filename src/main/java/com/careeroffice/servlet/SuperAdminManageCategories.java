package com.careeroffice.servlet;

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

@WebServlet({"/manage_categories"})
public class SuperAdminManageCategories extends HttpServlet {

    private static final CategoryService categoryService = (CategoryService) ServiceFactory.getService(ServiceEnum.CategoryService);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AuthService authService = new AuthService(request.getSession());

        request.setAttribute("user", authService.getUser());
        request.setAttribute("categories", categoryService.findAll());
        request.setAttribute("categoryCount", categoryService.count());

        request.getRequestDispatcher("WEB-INF/views/super_admin/manage_categories.jsp").forward(request, response);
    }
}