import java.sql.Connection;
import java.sql.DriverManager;
import javax.json.JsonObject;
 
public class my_connect 
    {
 
    String url = "jdbc:mysql://localhost?&useSSL=false";
 
    String user = "morris";
 
    String password = "*warswook8";
    Connection con;

    protected Connection doit(JsonObject personObject)
	{
        System.out.println("Inside connect");
                String transcode = personObject.getString("transcode");
                System.out.println("transcode " + transcode);
    
        try {
/*            con = DriverManager.getConnection(url, user, password); */
            con = DriverManager.getConnection(AdmethereDriverData.url + "://" + AdmethereDriverData.host + "/" + AdmethereDriverData.db + "?&useSSL=false", AdmethereDriverData.user, AdmethereDriverData.passw);
            System.out.println("Success");
            return(con);

            } 
        catch (Exception e) 
            {
            e.printStackTrace();
            }
        return(con);
        }
    }


