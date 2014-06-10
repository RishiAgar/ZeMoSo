
package accidentsdatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class ConvertCSVtoDatabase 
{
    private String fileName;
    private String password;
    private String userName;
    private String databaseName = "Accidents";
    public ConvertCSVtoDatabase(String fileName)
    {
        this.fileName = fileName;
    }
    public ConvertCSVtoDatabase(String fileName, String databaseName, String userName, String password)
    {
        this.fileName = fileName;
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
    }
    public String getFileName()
    {
        return fileName;
    }
    public String getdatabaseName()
    {
        return databaseName;
    }
    
    public void convert(String tableName) throws IOException, ClassNotFoundException, SQLException
    {
        BufferedReader bfr = null;
        String[] divided, header;
        String line;
        DatabaseQueries obj = new DatabaseQueries(userName,password,databaseName);
        obj.connectDatabase();
        try
        {
            bfr=new BufferedReader(new FileReader(fileName));
        }
        catch( FileNotFoundException ex)
        {
            System.err.println(ex.getMessage());
            System.exit(0);
        }
        line = bfr.readLine();
        divided = line.split(",");
        header = divided;
        obj.createTable(divided, tableName);
        while(( line = bfr.readLine()) != null )
        {
            divided = line.split(",");
            obj.insertNewEntry( header, divided, tableName);
        }
        bfr.close();
        obj.closeConnection();
    }
}