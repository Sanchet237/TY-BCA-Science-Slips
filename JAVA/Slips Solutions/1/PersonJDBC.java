/*Q2. Write a JDBC program to display all the details of the Person table in proper format on the 
screen.  Create  and  insert  values  in  Person  table  with  fields  as  PID,  name,  gender,  birth_year  in 
PostgreSQL database. */

import java.sql.*;
class PersonJDBC {
	public static void main(String args[]) throws java.sql.SQLException {
		Connection conn;
        Statement stmt;
        ResultSet rs;

		try{
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sanchet","postgres","mit@2025");
			if(conn==null)
				System.out.println("fail");
			else
				System.out.println("connected");
                                stmt=conn.createStatement();
                                rs=stmt.executeQuery("Select * from person");
                        while(rs.next())
                        {
                          System.out.println("PID="+rs.getInt(1));
                          System.out.println("name="+rs.getString(2));
		          System.out.println("gender="+rs.getString(3));
                          System.out.println("birth_year="+rs.getDate(4));
                        conn.close();
                        }
                   }
                 
		catch(Exception e){
			System.out.println(e);
		}
	}
}
