package ua.nure.danylenko.practice10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "authorize")
public class ServletAuthorize extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        Map<String, String> users= new HashMap<>();

        Connection con = (Connection) request.getAttribute("con");
        if(con==null){

            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        }
        try(Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT login, password FROM users")) {
            while (rs.next()) {
                users.put(rs.getString("login"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(users.containsKey(login)&&users.containsValue(pass)){
            request.getRequestDispatcher("name.jsp")
                    .forward(request, response);
        }else{
            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
        }

    }
}
