
package mysqlconn;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection
{
    Connection con;
public Connection getConnection()
{
try
{

  Class.forName("com.mysql.cj.jdbc.Driver");
  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/software_billing","root","root");
  
}
catch(Exception e)
{
    System.out.println(e);
}
return con;
}
}
