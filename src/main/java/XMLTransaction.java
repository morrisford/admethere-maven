

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
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonException;
import javax.json.JsonObjectBuilder;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import io.jsonwebtoken.*;   

/*
public class XMLTransaction extends HttpServlet
        {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            {
            System.out.println("Enter doPost");
            doGet(request, response);
            }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            {
            System.out.println("Enter doGet");
	    JsonObject 	userObject = null;
	    JsonObjectBuilder	respObject;
	    JsonObject	theResponse;
	    String 	transcode = null;
	    String	transId = null;
	    String 	lastName = null;
	    String 	firstName = null;
	    String	emailAddress = null;
	    String	role = null;
	    String	token = null;
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
                }

            JsonReader reader = Json.createReader(new StringReader(jb.toString()));
            JsonObject personObject = reader.readObject();
            reader.close();


	    try {
		token = personObject.getString("token");
                System.out.println("token " + token); 
		transcode = personObject.getString("transcode");
                System.out.println("transcode " + transcode); 
		transId = personObject.getString("transId");
                System.out.println("transId " + transId); 
	  	userObject = personObject.getJsonObject("user");
		if(userObject != null)
		    {
		    lastName = userObject.getString("lastName");
		    System.out.println("lastName = " + lastName);
		    firstName = userObject.getString("firstName");
		    System.out.println("firstName = " + firstName);
		    emailAddress = userObject.getString("emailAddress");
		    System.out.println("emailAddress = " + emailAddress);
		    }
	        } 
	    catch (JsonException e) 
		{
    		throw new IOException("Error parsing JSON request string");
  		}


	String encodedKey = "FhY3GZwVsY92Kk3HBeWxn4NSEd31k0Axu4hyILVwOOU3mCuzh6rSk70wZiFGi75PeBrU0bfqUhCtVcWXUxPzIg==";
	byte[] decodedKey = Base64.getDecoder().decode(encodedKey);

	System.out.println("decoded key = " + decodedKey);

        Claims claims = Jwts.parser().setSigningKey(decodedKey).parseClaimsJws(token).getBody(); 

    System.out.println("ID: " + claims.getId());
    System.out.println("Subject: " + claims.getSubject());
    System.out.println("Issuer: " + claims.getIssuer());
    System.out.println("Expiration: " + claims.getExpiration());

	    respObject = Json.createObjectBuilder();

	    respObject.add("name", "razzamatazz");
	    theResponse = respObject.build();
	    
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();
	    out.print(theResponse);
	    out.flush();

	    switcher switchit = new switcher();
	    int result = switchit.doit(personObject); 
	    System.out.println("Result from switcher " + result);
            }
        }

*/


public class XMLTransaction extends HttpServlet
        {
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
            out.println("{user-transaction: greetings}");
            }
        }
