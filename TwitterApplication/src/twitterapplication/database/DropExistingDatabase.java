

package twitterapplication.database;

import java.sql.*;

public class DropExistingDatabase 
{
   public void drop()
   {
        Parameter obj = new Parameter();
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName(obj.getJDBCDriver());
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(obj.getDatabaseURL(), 
                    obj.getUserName(), obj.getPassword());
            System.out.println("Connected database successfully...");
            System.out.println("Deleting database...");
            stmt = conn.createStatement();
            String sql = "DROP DATABASE sakila";
            stmt.executeUpdate(sql);
            System.out.println("Database deleted successfully...");
        }
        catch(SQLException se)
        {
            System.err.println(se);
        }
        catch(Exception e)
        {
            System.err.println(e);
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
                System.err.println(se);
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
                System.err.println(se);
            }
        }
    }
    public static void main(String[] args)
    {
        new DropExistingDatabase().drop();
    }
}