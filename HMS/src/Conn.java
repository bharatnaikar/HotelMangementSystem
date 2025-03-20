
import java.sql.*;

public class Conn {
    
    public static void main(String args[]){
      
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms2","root","");
        
        Statement smt = con.createStatement();
        ResultSet rs=smt.executeQuery("select * from Login");
        
        System.out.println("Connection Established Successfully");
        
        while(rs.next())
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        
        
        con.close();
        
        }catch(Exception e){
            System.out.println(e);
            
            
        }
    }
    
}
