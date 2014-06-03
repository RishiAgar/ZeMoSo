
package twitterapplication.database;

public interface DatabaseParameter
{
    public void setPassword();
    public void setUserName();
    public void setDatabaseName();
    public void setDatabaseURL();
    public void setJDBCDriver();
    public String getPassword();
    public String getUserName();
    public String getDatabaseName();
    public String getDatabaseURL();
    public String getJDBCDriver();
}
