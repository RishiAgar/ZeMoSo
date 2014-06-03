
package twitterapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import twitterapplication.database.Parameter;

public class MostInfluentialUser 
{
	public static void main(String[] args)
	{
                Parameter obj = new Parameter();
                String basis_of_favourite = "followerscount";
                String table = "user"; 
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName(obj.getJDBCDriver());
                        System.out.println("Connecting to a selected database...");
                        conn = DriverManager.getConnection(obj.getDatabaseURL(), 
                                obj.getUserName(), obj.getPassword());
                        System.out.println("Connected database successfully...");
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
                        ResultSet rs;
                        
			String sql = "SELECT MAX(" + basis_of_favourite + 
                                ") FROM " + table;
			rs = stmt.executeQuery(sql);
			int max=0;
                        if (rs.next())
                        {
                            max = rs.getInt(1);
                        }
                        sql = "SELECT * FROM " + table + " WHERE " + 
                                basis_of_favourite + " = " + String.valueOf(max);
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
                            long userid  = rs.getLong("userid");
                            String name = rs.getString("name");
                            String screen_name = rs.getString("screenname");
                            int status_count  = rs.getInt("statuscount");
                            int favourites_count  = rs.getInt("favouritescount");
                            int followers_count  = rs.getInt("followerscount");
                            int friends_count = rs.getInt("friendscount");
                            System.out.print("User ID: " + userid);
                            System.out.print(", Name: " + name);
                            System.out.println(", Screen Name: " + screen_name);
                            System.out.println(", Status Count: " + status_count);
                            System.out.println(", Favourites Count: " + favourites_count);
                            System.out.println(", Followers Count: " + followers_count);
                            System.out.println(", Friends Count: " + friends_count);
                            rs.close();
                            sql = "SELECT statustext FROM status WHERE userid = " 
                                    + String.valueOf(userid);
                            rs = stmt.executeQuery(sql);
                            if(rs.next())
                            {
                                String status_text = rs.getString("statustext");
                                System.out.println(status_text);
                            }
                            rs.close();
                        }
		}
		catch(SQLException sqle)
		{
			System.err.println(sqle.getMessage());
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally
		{
			try
			{
                            if(stmt!=null)
                            {
                                conn.close();
                            }
			}
			catch(SQLException se)
			{
                            System.err.println(se.getMessage());
			}
			try
			{
                            if(conn!=null)
                            {
                                conn.close();
                            }
			}
			catch(SQLException se)
			{
				System.err.println(se.getMessage());
			}
		}
		System.out.println("Goodbye!");
        }
}