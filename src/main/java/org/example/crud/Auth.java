package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class Auth extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String userEmail = request.getParameter("userEmail");
        String userPass = request.getParameter("userPass");

        Person person = new Person();
        person.setUserPass(Hesh_Password.HeshPassword(userPass));
        person.setUserEmail(userEmail);

        if (PersonDao.checkPersonIfExists(person) != null) {
            Person returnedPerson = PersonDao.checkPersonIfExists(person);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("ID", returnedPerson.getId());
            httpSession.setAttribute("userName", returnedPerson.getUserName());
            httpSession.setAttribute("userEmail", returnedPerson.getUserEmail());
            httpSession.setAttribute("userCountry", returnedPerson.getUserCountry());
            System.out.println(returnedPerson.getId());
            System.out.println(returnedPerson.getUserName());
            System.out.println(returnedPerson.getUserEmail());
            System.out.println(returnedPerson.getUserCountry());
            if (returnedPerson.getRole() == Person.ROLE.ADMIN){
                printWriter.print("<h1>User succesfully saved</h1>");
                response.sendRedirect("authed_admin.jsp");
            }
            else {
                person.setRole(Person.ROLE.USER);
                response.sendRedirect("authed_person.jsp");
            }


        }
        else{
            printWriter.print("<h1>User auth error</h1>");
            request.getRequestDispatcher("auth.html").include(request,response);
        }

        printWriter.close();
    }
}
