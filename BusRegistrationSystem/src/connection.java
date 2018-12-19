/*


import com.mysql.jdbc.Connection;
import java.sql.*;


public class connection {
    public static void main(String[] args) {

        try{
            // 1. get a connection to  database
            Connection mycon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_system", "root", "");
            // 2. create a statement
            Statement mystat = mycon.createStatement();
            // 3. Execute SQL query
            ResultSet myres = mystat.executeQuery("select * from ticket_details");
            //4. Process thee result set
            while (myres.next())
            {
                System.out.println(myres.getString("Name") + ", " + myres.getString("From") + ", " + myres.getString("To")+", "+myres.getString("age"));
            }
        }

        catch  (Exception e){

        }
    }
}
*/
