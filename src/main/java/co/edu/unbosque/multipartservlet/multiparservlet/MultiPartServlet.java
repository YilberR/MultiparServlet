package co.edu.unbosque.multipartservlet.multiparservlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "multiPartServlet", value = "/multiPartServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class MultiPartServlet extends HttpServlet {
    private String message;
    private String UPLOAD_DIRECTORY= "uploads";
    public CSV csv;

    public void init() {
        csv = new CSV();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String nom = request.getParameter("correo");
        String contra = request.getParameter("contrasena");
        String petName = request.getParameter("nombreMascota");
        Cookie cookie1 = new Cookie("Correo", nom);
        Cookie cookie2 = new Cookie("Rol", "");
        cookie1.setMaxAge(3600);
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        if (csv.array.get(3).equals(nom))  {
            if (csv.array.get(4).equals(contra)) {
                cookie2.setValue(csv.array.get(5));
                response.addCookie(cookie2);
                response.sendRedirect(request.getContextPath() + "/propietario.html");
            } else if (csv.array.get(4) != (contra)) {
                response.sendRedirect(request.getContextPath() + "/error2.html");
            }
        } else if (csv.array.get(0).equals(nom)) {
            if (csv.array.get(1).equals(contra)) {
                cookie2.setValue(csv.array.get(2));
                response.addCookie(cookie2);
                response.sendRedirect(request.getContextPath() + "/funcionario.html");
            } else if (csv.array.get(1) != (contra)) {
                response.sendRedirect(request.getContextPath() + "/error2.html");
            }
        } else if (csv.array.get(0) != (nom) || csv.array.get(3) != (nom)) {
            response.sendRedirect(request.getContextPath() + "/error.html");
        }


    }

        public void destroy () {
        }
    }
