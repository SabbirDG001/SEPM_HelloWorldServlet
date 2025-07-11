package com.project.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = {"/hello", "/hello-world"})
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html;charset=UTF-8");

        // Get the writer to write the response
        PrintWriter out = response.getWriter();

        // Get current timestamp
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        // Get client information
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        try {
            // Write HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World Servlet</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
            out.println("h1 { color: #333; }");
            out.println(".info { background-color: #f4f4f4; padding: 20px; border-radius: 5px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello World from Java Servlet!</h1>");
            out.println("<div class='info'>");
            out.println("<p><strong>Server Time:</strong> " + timestamp + "</p>");
            out.println("<p><strong>Client IP:</strong> " + clientIP + "</p>");
            out.println("<p><strong>User Agent:</strong> " + userAgent + "</p>");
            out.println("<p><strong>Request Method:</strong> " + request.getMethod() + "</p>");
            out.println("<p><strong>Request URI:</strong> " + request.getRequestURI() + "</p>");
            out.println("</div>");
            out.println("<p>This servlet is running successfully in IntelliJ!</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // For POST requests, delegate to GET method
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "HelloWorld Servlet - A simple servlet example";
    }
}