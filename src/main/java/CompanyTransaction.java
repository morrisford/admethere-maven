/* package org.eclipse.jetty.embedded; */

import java.io.StringReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

    

public class CompanyTransaction extends HttpServlet
        {
    /* ------------------------------------------------------------ */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            {
            System.out.println("Enter doPost");
            doGet(request, response);
            }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            {
            System.out.println("Enter doGet");

            StringBuffer jb = new StringBuffer();
            String line = null;
            try
                {
                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null)
                    {
                    jb.append(line);
                    }
                }
            catch (Exception e)
                {
                /*report an error*/
                }

            System.out.println("posted " + jb.toString());

            JsonReader reader = Json.createReader(new StringReader(jb.toString()));
            JsonObject personObject = reader.readObject();
            reader.close();
            System.out.println("Name   : " + personObject.getString("name"));

            response.setContentType("application/json; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();
            out.println("{company-transaction: greetings}");
            }
        }
