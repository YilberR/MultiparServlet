package co.edu.unbosque.multipartservlet.multiparservlet;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "jsonServlet", value = "/jsonServlet")
public class JsonServlet extends HttpServlet {
    private arrayCsv foto;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        foto = new arrayCsv();

        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson(foto.getArray()));

    }

}