package org.example.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/avatar")

public class Avatar extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


       response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        PrintWriter out = response.getWriter();

        String jpgName = "temporaryName.jpg";

        String jpgPath = "webapp/avatar/";


        response.setContentType("image/jpg");
        response.setHeader("Content-Disposition",
                "attachment; filename=\""
                        + jpgName + "\"");


        FileInputStream inputStream
                = new FileInputStream(jpgPath + jpgName);
        int in;
        while ((in = inputStream.read()) != -1) {
            out.write(in);
        }


        inputStream.close();
        out.close();

        printWriter.close();
    }
}
