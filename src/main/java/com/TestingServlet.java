/* package org.eclipse.jetty.embedded; */

import java.io.StringReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.Json; 
import javax.json.JsonObject; 
import javax.json.JsonReader;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class TestingServlet extends HttpServlet
{
    public static void main(String[] args)
        throws Exception
        {
        Server server = new Server(8080);
	ServletContextHandler handler = new ServletContextHandler(server, "/");
	handler.addServlet(XMLTransaction.class, "/xml");
	handler.addServlet(UserTransaction.class, "/user");
	handler.addServlet(CompanyTransaction.class, "/company");

        server.start();
        server.join();
        }
    }
