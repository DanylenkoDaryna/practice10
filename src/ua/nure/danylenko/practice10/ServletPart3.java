package ua.nure.danylenko.practice10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "name")
public class ServletPart3 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Map<String, String> names=new HashMap<>();
        getServletContext().setAttribute("names", names);
        super.init();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("cp1251");
        response.setCharacterEncoding("cp1251");
        String name = request.getParameter("name");
        Map<String, String> names= (Map<String, String>) getServletContext().getAttribute("names");
        names.put(name,name);
        getServletContext().setAttribute("names", names);
        request.getRequestDispatcher("name.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("cp1251");
        resp.setCharacterEncoding("cp1251");
        Map<String, String> names= (Map<String, String>) getServletContext().getAttribute("names");
        names.clear();
        req.getRequestDispatcher("name.jsp")
                .forward(req, resp);
    }
}
