package accidentsdatabase;

import java.io.IOException;
import java.sql.SQLException;

public class AccidentsDatabase 
{
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException
    {
        String userName = "postgres";
        String password = "1234";
        String databaseName = "events";
        String tableName = "Accidents";
        String fileName = "roadac_Accidents_Due_To_Alcohol_Drugs_Total-2006-12.csv";
        DatabaseQueries obj = new DatabaseQueries(userName,password,databaseName);
        obj.connectDatabase();
        obj.dropTable(tableName);
        new ConvertCSVtoDatabase(fileName, databaseName, userName, password).convert(tableName);
        obj.findMaximum();
        tableName = "Population";
        fileName = "States and union territories of India by past population.csv";
        obj.dropTable(tableName);
        obj.connectDatabase();
        new ConvertCSVtoDatabase(fileName, databaseName, userName, password).convert(tableName);
        obj.connectDatabase();
        tableName = "Accidents";
        System.out.println();
        for( int i=2006; i<=2012; i++ )
            obj.perCapitaAccidents(tableName, "y" + Integer.toString(i));
        tableName = "Vehicles";
        fileName = "rtyb_2011_12tab6.3.csv";
        obj.connectDatabase();
        obj.dropTable(tableName);
        new ConvertCSVtoDatabase(fileName, databaseName, userName, password).convert(tableName);
        obj.connectDatabase();
        tableName = "Accidents";
        System.out.println();
        System.out.println("____------_________");
        for( int i=2006; i<=2012; i++ )
            obj.perVehicleAccidents(tableName, "y" + Integer.toString(i));
    }
}
