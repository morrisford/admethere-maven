
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author morris
 */
public class UserTransactions 
    {
        Connection conn;
        
     private static final String url = "jdbc:mysql://localhost?&useSSL=false";

    private static final String user = "morris";

    private static final String password = "*warswook8";

       
        protected int insert(JsonObject personObject) throws IOException, SQLException
	{
        String	transId = null;
	    String 	lastName = null;
	    String 	firstName = null;
	    String	emailAddress = null;
	    String	role = null;
	    String	token = null;
	    JsonObject 	userObject = null;
	    JsonObjectBuilder	respObject;
	    JsonObject	theResponse;
            
        System.out.println("Inside UserInsert");
        String transcode = personObject.getString("transcode");
        System.out.println("transcode " + transcode);


         
        my_connect my_conn = new my_connect();
	conn = my_conn.doit(personObject); 
        
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
                    role = userObject.getString("role");
		    System.out.println("role = " + role);

		    }
                String sql = "insert into users (lastName, firstName, role, emailAddress, transId) values ('" + lastName + "', '" + firstName + "', '" + role + "', '" + emailAddress +"', '" + transId + "')";
                System.out.println(sql);
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                
	        } 
	    catch (JsonException e) 
		{
    		throw new IOException("Error parsing JSON request string");
  		}


        return 6;
	}
    }
