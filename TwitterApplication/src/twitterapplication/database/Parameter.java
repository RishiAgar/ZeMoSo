
package twitterapplication.database;

public class Parameter implements DatabaseParameter
{
    
    private String JDBC_DRIVER;  
    private String DB_URL;
    private String USER;
    private String PASS;
    private String dbName;

    @Override
    public final void setPassword()
    {
        PASS = "1234";
    }

    @Override
    public final void setUserName()
    {
        USER = "root";
    }
    
    @Override
    public final void setDatabaseName()
    {
        dbName = "twitter";
    }

    @Override
    public final void setDatabaseURL()
    {
        DB_URL = "jdbc:mysql://localhost/" + getDatabaseName();
    }
    
    @Override
    public final void setJDBCDriver()
    {
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
    }
    
    @Override
    public String getPassword()
    {
        setPassword();
        return PASS;
    }

    @Override
    public String getUserName()
    {
        setUserName();
        return USER;
    }

    @Override
    public String getDatabaseName()
    {
        setDatabaseName();
        return dbName;
    }

    @Override
    public String getDatabaseURL()
    {
        setDatabaseURL();
        return DB_URL;
    }

    @Override
    public String getJDBCDriver()
    {
        setJDBCDriver();
        return JDBC_DRIVER;
    }
}