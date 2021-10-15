package co.edu.unbosque.multipartservlet.multiparservlet;

import com.google.gson.Gson;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;


@WebServlet(name = "PHOTO", value = "/PHOTO")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class photo extends HttpServlet {
    private String UPLOAD_DIRECTORY= "uploads";
    private arrayCsv arraycsv;


    public void init() {
        arraycsv= new arrayCsv();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("Name: "+ request.getParameter("nombreMascota"));

        String uploadPath = getServletContext().getRealPath("")+ File.separator+UPLOAD_DIRECTORY;
        File uploadDir=new File(uploadPath);
        if(!uploadDir.exists()) uploadDir.mkdir();
        String fileName="";
        try{
            for(Part part: request.getParts()){
                fileName=part.getSubmittedFileName();
                Random rnd = new Random();
                int newName = rnd.nextInt(1000);
                fileName = String.valueOf(newName)+"."+ FilenameUtils.getExtension(fileName);
                part.write(uploadPath+ File.separator+fileName);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String petName=request.getParameter("nombreMascota");
        String hora= new Date()+"";
        Cookie[] cookies = request.getCookies();
        String correo="";
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("Correo")){
                correo= cookie.getValue();
            }
        }
        arraycsv.getArray().add(new metaData(petName,hora,correo,fileName) );

        response.sendRedirect(request.getContextPath()+"/result.html");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson(arraycsv.getArray()));
    }

    public void destroy () {
    }

    public String getUPLOAD_DIRECTORY() {
        return UPLOAD_DIRECTORY;
    }

    public void setUPLOAD_DIRECTORY(String UPLOAD_DIRECTORY) {
        this.UPLOAD_DIRECTORY = UPLOAD_DIRECTORY;
    }

    public arrayCsv getArraycsv() {
        return arraycsv;
    }

    public void setArraycsv(arrayCsv arraycsv) {
        this.arraycsv = arraycsv;
    }

}
