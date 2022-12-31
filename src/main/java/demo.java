
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mysqlconn.DbConnection;


public class demo 

{
    HashMap<String, ArrayList>hm;
    ArrayList al;
   String items1="";
   String mblnum="987654231";
   String Custname="asad";
   
    String custEmail="asad@1234";
    String date="";
    String time="";
    String EmpEmail="samar@123";
   public void insertionOfHash()
   {
   hm=new HashMap<>();
   al=new ArrayList();
   
   al.add("Teddy Bear");
   al.add(300);
   al.add(3);
   ArrayList al2=new ArrayList();
   al2.add("Reebok");
   al2.add(500);
   al2.add(1);
   hm.put("101", al);
   hm.put("102", al2);
      
   getHash(hm);
   }
   public void getHash(HashMap<String,ArrayList>hm)
   {
   
   
   
   for(Map.Entry me :hm.entrySet())
   {
       
   items1=items1+me.getKey()+",";
    ArrayList al=(ArrayList)me.getValue();
   items1=items1+al.get(0)+",";
   items1=items1+al.get(1)+",";
   items1=items1+al.get(2)+",";
   
   }
   System.out.println(items1);
   /*LocalDate ld=LocalDate.now();
       date=ld.toString();
       LocalTime lt=LocalTime.now();
       time=lt.toString();
       insertDataDb(mblnum,Custname,custEmail,items1,date,time,EmpEmail);
       
       
       String items1="";
   String mblnum="987654231";
   String Custname="asad";
   
    String custEmail="asad@1234";
    String date="";
    String time="";*/
       
   }
   
   
    public static void main(String[] args) 
    {
     demo obj=new demo();
     obj.insertionOfHash();
     
     
    }
    public void insertDataDb(String...args)
    {
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
         int i=ps.executeUpdate();
         if(i>0)
         {
             System.out.println("Success");
         }
         else
         {
         }
       
       
        
    }
    catch(Exception e)
    {
    
    }
    }
    
}
