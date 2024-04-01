package org.example.crud;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/reg_user")
public class Register_user extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String userName=request.getParameter("userName");
        String userPass=request.getParameter("userPass");
        String userEmail=request.getParameter("userEmail");
        String userCountry=request.getParameter("userCountry");
//        String role=request.getParameter("role");

        Person person = new Person();
        person.setUserName(userName);
        person.setUserPass(Hesh_Password.HeshPassword(userPass));
        person.setUserEmail(userEmail);
        person.setUserCountry(userCountry);
        person.setRole(Person.ROLE.USER);


        int status = PersonDao.save(person);
        if (status >0){
            response.sendRedirect("auth.html");

        }
        else {
            printWriter.print("Something went wrong");
        }


        printWriter.close();
    }

}

