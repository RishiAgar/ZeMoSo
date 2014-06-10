
package accidentsdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseQueries 
{
    Connection c;
    Statement stmt;
    private String username;
    private String password;
    private String databaseName;

    DatabaseQueries(String username, String password, String databaseName) throws ClassNotFoundException 
    {
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        Class.forName("org.postgresql.Driver");
    }
    
    public Connection connectDatabase() 
    {
        System.out.println("Connecting to Database....");
        try
        {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"
                    + databaseName, username, password);
            stmt = c.createStatement();
        }
        catch( SQLException ex )
        {
            System.out.println("Database not Found");
            System.out.println("Creating Database");
            createDatabase();
        }
        System.out.println("Connected to Database");
        return c;
    }
    
    public void createDatabase()
    {
        try
        {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"
                    , username, password);
            stmt = c.createStatement();
            stmt.executeUpdate("CREATE DATABASE events");
            stmt.close();
            c.close();
        }
        catch( SQLException ex )
        {
            System.err.println(ex.getMessage());
            System.exit(0);
        }
        System.out.println("Database created");
        connectDatabase();
    }
    
    public void createTable( String[] line , String tableName)
    {
        String create;
        if(line.length == 8)
            create = "CREATE TABLE IF NOT EXISTS "+ tableName +"(ID SERIAL NOT NULL PRIMARY KEY, " 
                            + line[0] + " varchar(40) NOT NULL UNIQUE, "
                            + line[1] + " INT NOT NULL, " 
                            + line[2] + " INT, " 
                            + line[3] + " INT, " 
                            + line[4] + " INT, " 
                            + line[5] + " INT, " 
                            + line[6] + " INT, " 
                            + line[7] + " INT"
                            + ")";
        else
            create = "CREATE TABLE IF NOT EXISTS "+ tableName +"(ID SERIAL NOT NULL PRIMARY KEY, " 
                            + line[0] + " varchar(40) NOT NULL UNIQUE, "
                            + line[1] + " INT"
                            + ")";;
        try
        {
            stmt.executeUpdate(create);
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
            System.exit(0);
        }
    }
    
    public void insertNewEntry(String[] header, String[] row, String tableName) 
    {
        String create;
        for( int i=0; i<row.length; i++)
            if( row[i].equalsIgnoreCase("na"))
                row[i] = "-1";
        if( header.length == 8 )
            create = "INSERT INTO " + tableName + " (" 
                + header[0] + "," 
                + header[1] + "," 
                + header[2] + "," 
                + header[3] + "," 
                + header[4] + "," 
                + header[5] + "," 
                + header[6] + "," 
                + header[7]+ ") " 
                + "VALUES (" + "'" 
                + row[0] + "'," 
                + row[1] + ", " 
                + row[2] + ", " 
                + row[3] + ", " 
                + row[4] + ", " 
                + row[5] + ", "
                + row[6] + ", "
                + row[7] +");";
        else
            create = "INSERT INTO " + tableName + " (" 
                + header[0] + ","
                + header[1]+ ") " 
                + "VALUES (" + "'" 
                + row[0] + "',"
                + row[1] +");";
        try
        {
            stmt.executeUpdate(create);
        } 
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
            System.exit(0);
        }
    }
    
    public void dropTable(String tableName)
    {
        String create;
        create = "DROP Table "+ tableName;
        try
        {
            stmt.executeUpdate(create);
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }
    }
    
    public void closeConnection() throws SQLException
    {
        stmt.close();
        c.close();
    }
    
    public void findMaximum() throws SQLException
    {
        String query;
        ResultSet rs;
        query = "SELECT states_uts FROM Accidents ORDER BY y2007 DESC LIMIT 4;";
        rs = stmt.executeQuery( query );
        rs.next();
        for( int i=2006; i<=2012; i++)
        {
            query = "SELECT states_uts FROM Accidents ORDER BY y" 
                    + Integer.toString(i) + " DESC LIMIT 4;";
            rs = stmt.executeQuery( query );
            rs.next();
            System.out.print(i);
            for( int j=0; j<3; j++)
            {
                rs.next();
                System.out.print( "    " + rs.getString("states_uts") ); 
            }
            System.out.println();
        }    
        rs.close();
    }
    
    public void perCapitaAccidents(String tableName, String columnName) throws SQLException
    {
        String query;
        ResultSet rs;
        query = "SELECT at.states_uts, CAST(at." + columnName + " as FLOAT) / "
                + "population2011 as result from " + tableName
                + " as at inner join POPULATION as ta on at.id = ta.id "
                + "ORDER BY result DESC LIMIT 4;";
        rs = stmt.executeQuery( query );
        String[] content = new String[36];
        System.out.println("\n"+columnName);
        int k=0;
        for( int i=0; i<4; i++ )
        {
            rs.next();
            content[i] = rs.getString("states_uts");
            if( content[i].equalsIgnoreCase("All India"))
                continue;
            k++;
            System.out.println(content[i]);
            if( k == 3 )
                break;
        }
        rs.close();
    }
    
    public void perVehicleAccidents(String tableName, String columnName) throws SQLException
    {
        String query;
        ResultSet rs;
        query = "SELECT yx.states_uts, xy.resu / "
                + "yx.No_of_Motor_Vehicles_1000_population_during_2011_12 as "
                + "result FROM (SELECT at.id, CAST(at." + columnName + " as "
                + "FLOAT) / (ta.population2011/1000) as resu from " + tableName
                + " as at inner join POPULATION as ta on at.id = ta.id) as xy "
                + "inner join Vehicles as yx on xy.id = yx.id ORDER BY result "
                + "DESC LIMIT 4;";
        rs = stmt.executeQuery( query );
        String[] content = new String[36];
        System.out.println("\n"+columnName);
        int k=0;
        for( int i=0; i<4; i++ )
        {
            rs.next();
            content[i] = rs.getString("states_uts");
            if( content[i].equalsIgnoreCase("All India"))
                continue;
            k++;
            System.out.println(content[i]);
            if( k == 3 )
                break;
        }
        rs.close();
    }
}