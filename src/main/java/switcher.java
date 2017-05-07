/* package org.eclipse.jetty.embedded; */

import java.io.*;
import java.sql.SQLException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonException;
import javax.json.JsonObjectBuilder;


public class switcher
    {

    protected int doit(JsonObject personObject) throws IOException, SQLException
	{
        System.out.println("Inside switcher");
                String transcode = personObject.getString("transcode");
                System.out.println("transcode " + transcode);
        switch(transcode)
        {
            case "0004":
            {
            System.out.println("Transcode 0004 in switcher");
/*            connect conn = new connect();
            int result = connect.doit(personObject); */
            UserTransactions user_insert = new UserTransactions();
	    int result = user_insert.insert(personObject);
            }
        }
	return 5;

	}
    }

