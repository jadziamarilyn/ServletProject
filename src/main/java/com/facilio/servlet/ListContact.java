package com.facilio.servlet;
import com.google.gson.Gson;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class ListContact extends HttpServlet {
    private Gson gson = new Gson();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String detailsjson = this.gson.toJson(Main.details);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.println(detailsjson);
    }
}
