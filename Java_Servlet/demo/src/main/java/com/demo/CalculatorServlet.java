package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="CalculatorServlet", value="/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter output = resp.getWriter();
        output.println(
                "<!doctype html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\"\n" +
                        "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                        "    <title>Document</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<form action=\"/calculator\" method=\"post\">\n" +
                        "    <input type=\"number\" name=\"first_number\">\n" +
                        "    <input type=\"number\" name=\"second_number\">\n" +
                        "    <button type=\"submit\" name=\"operation\" value=\"add\">Cộng</button>\n" +
                        "    <button type=\"submit\" name=\"operation\" value=\"sub\">Trừ</button>\n" +
                        "    <button type=\"submit\" name=\"operation\" value=\"mul\">Nhân</button>\n" +
                        "    <button type=\"submit\" name=\"operation\" value=\"div\">Chia</button>\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>"
        );

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        int a = Integer.parseInt(req.getParameter("first_number"));
        int b = Integer.parseInt(req.getParameter("second_number"));
        String operation = req.getParameter("operation");

        double result = 0;
        switch(operation){
            case "add" -> result = a + b;
            case "sub" -> result = a - b;
            case "mul" -> result = a * b;
            case "div" -> {
                if(b != 0){
                    result = (double) a / b;
                } else {
                    resp.getWriter().println("So chia khong duoc bang 0 !");
                    return;
                }
            }
        }

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h1>Result: " + result + "</h1>");
    }
}
