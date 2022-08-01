package com.facilio.servlet;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
public class DeleteContact extends HttpServlet {
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Reader reader = request.getReader();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            String key = (String) jsonObject.get("key");
            Main.details.remove(Integer.parseInt(key));
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            JsonObject message = new JsonObject();
            message.addProperty("Status", "Deleted Successfully");
            out.println(message);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
