package com.careeroffice.servlet;

import com.careeroffice.model.Cv;
import com.careeroffice.model.Keyword;
import com.careeroffice.model.User;
import com.careeroffice.service.*;
import com.careeroffice.service.factory.ServiceEnum;
import com.careeroffice.service.factory.ServiceFactory;
import com.careeroffice.service.pivot.KeywordCvPivotService;
import com.careeroffice.service.CvService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * A successful student login is forwared to this servlet
 * StudentServlet serves the main portal for students, showing their
 * main information, keywords
 */
@WebServlet({"/StudentServlet", "/student", "/p_student", "/u_student"})
public class StudentServlet extends HttpServlet {

    /**
     * Java related serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Handles all GET requests.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AuthService authService = new AuthService(request.getSession());

        if (!authService.isLoggedIn()) {
            response.sendRedirect("login");
            return;
        }

        if (!authService.hasRole("u_student") && !authService.hasRole("p_student")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        CvService cvService = (CvService) ServiceFactory.getService(ServiceEnum.CvService);
        KeywordCvPivotService keywordCvPivotService = (KeywordCvPivotService) ServiceFactory.getService(ServiceEnum.KeywordCvPivotService);

        User user = authService.getUser();
        Cv cv = cvService.findOne(user.getUsername());

        /**
         * If a use has uploaded his CV, retrive the related keywords
         */
        if (cv != null) {
            List<Keyword> keywords = keywordCvPivotService.findByCvId(cv.getId());
            request.setAttribute("keywords", keywords);
            request.setAttribute("user", user);
        }

        request.getRequestDispatcher("WEB-INF/views/student/index.jsp").forward(request, response);
    }

    /**
     * Handles all POST requests.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}