package twitterapplication.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable
{
   public void create()
   {
        Parameter obj = new Parameter();
        Connection conn = null;
        Statement stmt = null;
        String sql;
        try
        {
            Class.forName(obj.getJDBCDriver());
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(obj.getDatabaseURL(), 
                    obj.getUserName(), obj.getPassword());
            System.out.println("Connected database successfully...");
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            
            sql = "CREATE TABLE USER " +
                  "(userid  BIGINT, " +
                  "name VARCHAR(255), " +
                  " screenname VARCHAR(255), " +
                  " statuscount INTEGER, " + 
                  " favouritescount INTEGER, " + 
                  " followerscount INTEGER, " + 
                  " friendscount INTEGER," +
                    " PRIMARY KEY ( userid ))"; 
            
            stmt.executeUpdate(sql);
            
             sql = "CREATE TABLE STATUS " +
                   "(userid  BIGINT, " +
                   "statusid  BIGINT, " + 
                   "date VARCHAR(50), " +
                   "statustext VARCHAR(1024), " +  
                   " retweetcount INTEGER, " + 
                   " favouritecount INTEGER, " + 
                   " isretweet BOOLEAN, " + 
                   " isfavourited BOOLEAN," +
                     " PRIMARY KEY ( statusid ))"; 
            
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            
            sql ="SELECT USER.userid from USER inner join STATUS on "
                    + "USER.userid = STATUS.userid";
            stmt.executeQuery(sql);
            
            System.out.println("Tables joined via User ID...");
        }
        catch(SQLException se)
        {
                    System.err.println(se.getMessage());
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
                System.out.println(se.getMessage());
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
                System.out.println(se.getMessage());
            }
        }
   }
   public static void main(String[] args)
   {
        new CreateTable().create();
    }
}