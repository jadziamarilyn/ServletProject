package com.facilio.servlet;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
public class Main extends HttpServlet {
    int personid=0;
    static HashMap<Integer, Contact> details = new HashMap<>();
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        Reader reader = request.getReader();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            String name = (String) jsonObject.get("name");
            String age = (String) jsonObject.get("age");
            String mobileno = (String) jsonObject.get("mobileno");
            String mailid = (String) jsonObject.get("mailid");
            personid = personid + 1;
            Contact c = new Contact(name, age, mobileno, mailid);
            details.put(personid, c);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JsonObject message = new JsonObject();
        message.addProperty("Status", "Created Successfully");
        out.println(message);
    }

}
