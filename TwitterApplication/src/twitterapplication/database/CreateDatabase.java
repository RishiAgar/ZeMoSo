

package twitterapplication.database;

import java.sql.*;

public class CreateDatabase
{
    static final String DB_URL = "jdbc:mysql://localhost/";
    public void create()
    {
        Parameter obj = new Parameter();
        Connection conn;
        Statement stmt;
        try
        {
            Class.forName(obj.getJDBCDriver());
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, obj.getUserName(), 
                    obj.getPassword());
            stmt = conn.createStatement();
            System.out.println("Connected database successfully...");
            System.out.println("Creating database... "+ obj.getDatabaseName());
            stmt.executeUpdate("CREATE DATABASE " + obj.getDatabaseName());
            System.out.println("Created database successfully...");
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            System.exit(0);
        }
    }
    public static void main(String[] args) throws Exception
    {
        CreateDatabase obj = new CreateDatabase();
        obj.create();
    }
}