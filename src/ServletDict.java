import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletDict", urlPatterns = "/translate")
public class ServletDict extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dict = new HashMap<>();
        dict.put("book", "sách");
        dict.put("flower", "hoa");
        dict.put("apple", "táo");
        String textInput = request.getParameter("textInput");
        String result = dict.get(textInput);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        if (result != null) {
            writer.println("The word " + textInput + " in Vietnamese is: " + result);
        } else {
            writer.println("Not found!");
        }
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
