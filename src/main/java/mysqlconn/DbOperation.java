
package mysqlconn;
import AdminPanel.EditViewPanel;
import GetterAndSetter.GetterSetter;
import com.mysql.cj.MysqlConnection;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class DbOperation 
{
    boolean status=false;
    public ResultSet loginConnection(String name,String pswrd)
    {
        System.out.println("Login Name :"+name);
        System.out.println("Login Pswrd :"+pswrd);
        ResultSet rs = null;
     try
      {                     
        DbConnection mc=new DbConnection();
        Connection con=  mc.getConnection();
        PreparedStatement ps=con.prepareStatement("select*from register where NAME=? and PASSWORD=?" );

         ps.setString(1, name);
         ps.setString(2, pswrd);

          rs=ps.executeQuery();
       
         
          }
       catch(Exception r)
          {
              System.out.println(r);

          }
    
    return rs;
    }
public int registersignup(GetterSetter rgs)
{
   int i=0;
    try
    {
    DbConnection mc=new DbConnection();
    Connection con= mc.getConnection();
    
    PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
        System.out.println("name "+rgs.getName());
    ps.setString(1,rgs.getName() );
    ps.setString(2, rgs.getEmail());
    ps.setString(3, rgs.getPswrd());
    ps.setString(4, rgs.getGender());
    ps.setString(5, rgs.getMblnum());   
   i= ps.executeUpdate();
    }
   
    catch(Exception e)
    {
        System.out.println(e);
    }
return i;
}
public ResultSet getSelectEmp(String email1)
{
    System.out.println("Email "+email1);
    ResultSet rs=null;
DbConnection mcn=new DbConnection();
try
{
Connection con=mcn.getConnection();
    
PreparedStatement ps=con.prepareStatement("select*from register where EMAIL=?");
ps.setString(1, email1);
 rs=ps.executeQuery();


}
catch(Exception e)
{
    System.out.println(e);
}
return rs;
}
public int updateEmploye(GetterSetter rgs)
{
  int i=0;
 
try
{
 DbConnection mcn=new DbConnection();
Connection con = mcn.getConnection();
PreparedStatement ps=con.prepareStatement("update register set NAME=?,PASSWORD=?,MOBILE_NUM=?,gender=? where EMAIL=?");
ps.setString(1, rgs.getName());
ps.setString(2, rgs.getPswrd());
ps.setString(3, rgs.getMblnum());
ps.setString(4, rgs.getGender());
ps.setString(5, rgs.getEmail());
i=ps.executeUpdate();


}
catch(Exception r)
{
    System.out.println(r);
}
return i;
}
public int deleteRow(String email)
{
int i=0;
       
     DbConnection mcn=new DbConnection();
    try
    {
    Connection con = mcn.getConnection();
   PreparedStatement ps= con.prepareStatement("delete from register where EMAIL=?");
    ps.setString(1, email);
    i=ps.executeUpdate();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }


return i;
}
public int updatePassword(String o_pswrd,String n_pswrd,String cnfrm_pswrd)
{
    String c_pswrd="";
int i=0;
    try
{
DbConnection dbo=new DbConnection();
Connection con=dbo.getConnection();
PreparedStatement ps=con.prepareStatement("select PASSWORD from register where name='asad'");

ResultSet rs1=ps.executeQuery();
while(rs1.next())
{
c_pswrd=rs1.getString("PASSWORD");
}
  
    System.out.println("Current password"+c_pswrd);
    System.out.println(" old  password"+o_pswrd);
    
    if(c_pswrd.equals(o_pswrd))
    {
    if(cnfrm_pswrd.equals(n_pswrd))
    {
        PreparedStatement ps1=con.prepareStatement("update register set PASSWORD=? where name='samar khan'");
        ps1.setString(1, n_pswrd);
       i= ps1.executeUpdate();
    }
    }
  
  
}
catch(Exception e)
{
    System.out.println(e);
}
return i;
}
public static boolean addItem(FileInputStream fis,String...args)
{
  boolean status=false;
  DbConnection dbc=new DbConnection();
  Connection con=dbc.getConnection();
  try
  {
  PreparedStatement ps=con.prepareStatement("insert into items values(?,?,?,?,?,?)");
  ps.setString(1,args[0]);
  ps.setString(2,args[1]);
  ps.setString(3,args[2]);
  ps.setString(4,args[3]);
  ps.setString(5,args[4]);
  ps.setBinaryStream(6, fis);
  int i=ps.executeUpdate();
  if(i>0)
  {
  status=true;
  }
  
  }
catch(Exception e)
{
    System.out.println(e);
}
  return status;
}
public static ResultSet editItems()
{
     ResultSet rs = null;
    DbConnection dbc=new DbConnection();
   Connection con= dbc.getConnection();
try
{
  
   PreparedStatement ps= con.prepareStatement("select Item_ID,Item_Name from  items");
   rs=ps.executeQuery();
}
catch(Exception e)
{
    System.out.println(e);
}
return rs;
}
public static ResultSet editItem2(String Item_id)
{
ResultSet rs=null;
    DbConnection dbc=new DbConnection();
Connection con =dbc.getConnection();
try
{


PreparedStatement ps=con.prepareStatement("select*from  items where Item_Id=?");

ps.setString(1, Item_id);
 rs=ps.executeQuery();

}
catch(Exception e)
{
    System.out.println(e);

}    
return rs;
}
public  static int editItems3(FileInputStream fis,String...args)
{
    System.out.println("Heyy");
    int i=0;
DbConnection dbc=new DbConnection();
Connection con = dbc.getConnection();
try
{
PreparedStatement ps=con.prepareStatement("update items set Item_Id=?,Item_Name=?,Item_Price=?,Item_Category=?,Item_Desc=?,Item_Image=? where Item_Id=?");
ps.setString(1, args[0]);
ps.setString(2, args[1]);
ps.setString(3, args[2]);
ps.setString(4, args[3]);
ps.setString(5, args[4]);
ps.setString(7, args[0]);
    System.out.println("Id :"+args[0]);
    System.out.println("Name :"+args[1]);
ps.setBinaryStream(6, fis);
 i=ps.executeUpdate();
}
catch(Exception e)
{
    System.out.println(e);
}
return i;
}

public static int deleteitem(String Item_Id)
{
int i=0;
       
     DbConnection mcn=new DbConnection();
    try
    {
    Connection con = mcn.getConnection();
   PreparedStatement ps= con.prepareStatement("delete from items where Item_Id=?");
    ps.setString(1, Item_Id);
    i=ps.executeUpdate();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }


return i;
}

public static  int updateEmpPassword(String o_pswrd,String n_pswrd,String cnfrm_pswrd,String name)
{
   
    String c_pswrd="";
int i=0;
    try
{
DbConnection dbo=new DbConnection();
Connection con=dbo.getConnection();
PreparedStatement ps=con.prepareStatement("select PASSWORD from register where name=?");
ps.setString(1, name);
ResultSet rs1=ps.executeQuery();
while(rs1.next())
{
c_pswrd=rs1.getString("PASSWORD");
    
}
  
    System.out.println("Current password"+c_pswrd);
    System.out.println(" old  password"+o_pswrd);
    
    if(c_pswrd.equals(o_pswrd))
    {
    if(cnfrm_pswrd.equals(n_pswrd))
    {
        System.out.println("heyy laudu");
        PreparedStatement ps1=con.prepareStatement("update register set PASSWORD=? where name=?");
        ps1.setString(1, n_pswrd);
        ps1.setString(2, name);
       i= ps1.executeUpdate();
    }
    }
  
  
}
catch(Exception e)
{
    System.out.println(e);
}
return i;
}
public static ResultSet viewAllEmployee()
{
ResultSet  rs=null;
  try
      {                     
        DbConnection mc=new DbConnection();
        Connection con=  mc.getConnection();
        PreparedStatement ps=con.prepareStatement("select*from register" );
        
          rs=ps.executeQuery();
          }
       catch(Exception r)
          {
              System.out.println(r);

          }
    
    return rs;
    }
 public static ResultSet customerDetails(String phn)
 {
     ResultSet rs = null;
     DbConnection dbc=new DbConnection();
   
 try
 {
   Connection con  = dbc.getConnection();  
     PreparedStatement ps=con.prepareStatement("select*from customerDetails where Mobile_Num=?");
     ps.setString(1, phn);
     rs=ps.executeQuery();
     
 }
 catch(Exception e)
 {
 
 e.printStackTrace();
 }
 return rs;
 }
 public static int registerCustomer(String...args)
 {
     int i=0;
try
{
     ResultSet rs = null;
     DbConnection dbc=new DbConnection();
     Connection con  = dbc.getConnection();  
     PreparedStatement ps=con.prepareStatement("insert into customerDetails values(?,?,?)");
      ps.setString(1, args[0]);
      ps.setString(2, args[1]);
      ps.setString(3, args[2]);
     i= ps.executeUpdate();
      
}
catch(Exception e)
{
e.printStackTrace();

}
return i;
 }
 
 public static int shopingDetails(HashMap hm,GetterSetter gs,String mbl)
 {
     int i=0;
try
{
     ResultSet rs = null;
     DbConnection dbc=new DbConnection();
     Connection con  = dbc.getConnection();  
     PreparedStatement ps=con.prepareStatement("update customerDetails set Cust_Items=?,Emp_Email=? where Mobile_Num=?");
     ps.setObject(1, hm);
     ps.setString(2,gs.getEmail());
     ps.setString(3, mbl);
     i= ps.executeUpdate();
      
}
catch(Exception e)
{
e.printStackTrace();

}
return i;
 }
 public static  int insertDataDb(String...args)
    {
        int i=0;
    try
    {
        DbConnection dbc=new DbConnection();
        Connection con= dbc.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into customerDetails values(?,?,?,?,?,?,?) ");
        ps.setString(1,args[0]);
        ps.setString(2,args[1]);
        ps.setString(3,args[2]);
        ps.setString(4,args[3]);
         ps.setString(5,args[4]);
        ps.setString(6,args[5]);
         ps.setString(7,args[6]);
          i=ps.executeUpdate();
         
    }
    catch(Exception e)
    {
    
    }
    return  i;
    }
 
 
}





