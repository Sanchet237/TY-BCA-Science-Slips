/*Q2. Create and insert values to Person table (PID, name, gender, birth_year) in postgreSQL database. 
Write a JDBC program to display information about the ResultSet like number of columns 
available in the ResultSet and SQL type of each column using ResultSetMetaData. 
[20 Marks]*/

import java.sql.*;
 
public class PersonJDBC{
    public static void main(String[] args){
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sanchet","postgres","mit@2025");
            stmt = con.createStatement();      

            String sql = "SELECT * FROM Person";      
              
            ResultSetMetaData rsmd =  stmt.executeQuery(sql).getMetaData();      
            int colCount = rsmd.getColumnCount();       

            System.out.println("Number Of Columns : "+colCount);
            System.out.println("column Details :");

            for(int i=1;i<=colCount; i++){
            	String colName = rsmd.getColumnName(i);      
            	String colType = rsmd.getColumnTypeName(i);  
            	System.out.println(colName+" is of type "+colType);
			}
            stmt.close();
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
