package ua.nure.danylenko.practice10;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mysql.jdbc.*;

@WebServlet(name = "getConnection")
public class GetConnectionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        DataSource ds = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext
                    .lookup("java:/comp/env");

            ds = (DataSource) envContext
                    .lookup("jdbc/testDB_" + type);

            request.setAttribute("con", ds.getConnection());

        } catch (NamingException | SQLException ex) {
            //throw new DBException(Messages.ERR_CANNOT_OBTAIN_DATA_SOURCE, ex);
            ex.printStackTrace();
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
