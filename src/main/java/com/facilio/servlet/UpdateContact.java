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

public class UpdateContact extends HttpServlet {
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Reader reader = request.getReader();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            String name = (String) jsonObject.get("name");
            String age = (String) jsonObject.get("age");
            String mobileno =(String) jsonObject.get("mobileno");
            String mailid=(String) jsonObject.get("mailid");
            String key = (String) jsonObject.get("key");
            if  (!name.equals("")){
                Contact c = Main.details.get(Integer.parseInt(key));
                c.setName(name);
            }
            if  (!age.equals("")){
                Contact c = Main.details.get(Integer.parseInt(key));
                c.setAge(age);
            }
            if  (!mobileno.equals("")){
                Contact c = Main.details.get(Integer.parseInt(key));
                c.setMobileno(mobileno);
            }
            if  (!mailid.equals("")){
                Contact c = Main.details.get(Integer.parseInt(key));
                c.setMail(mailid);
            }
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            JsonObject message = new JsonObject();
            message.addProperty("Status", "Updated Successfully");
            out.println(message);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
