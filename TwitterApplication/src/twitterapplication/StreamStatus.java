package twitterapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import twitter4j.*;
import twitter4j.conf.*;
import twitterapplication.database.Parameter;

public class StreamStatus
{   
    private static final Object lock = new Object();
    private ConfigurationBuilder cb;
    static Connection conn = null;
    private String[] statusSearchKeyword;
    
    public StreamStatus()
    {
        cb = new TwitterUserConfiguration().TwitterConfiguration();
        statusSearchKeyword = new String[1];
        statusSearchKeyword[0] = "#aap";
    }
    public void enterStatusDatabase(Status status)
    {
        String sql;
        PreparedStatement ps;
        try
        {
            sql= "INSERT INTO USER VALUES(?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, (status.getUser()).getId());
            ps.setString(2, (status.getUser()).getName());
            ps.setString(3, (status.getUser()).getScreenName());
            ps.setInt(4, (status.getUser()).getStatusesCount());
            ps.setInt(5, (status.getUser()).getFavouritesCount());
            ps.setInt(6, (status.getUser()).getFollowersCount());
            ps.setInt(7, (status.getUser()).getFriendsCount());
            ps.executeUpdate();
            System.out.println("User info entered in Database");
            sql= "INSERT INTO STATUS VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, (status.getUser()).getId());
            ps.setLong(2, status.getId());
            ps.setString(3, (status.getCreatedAt()).toString());
            ps.setString(4, status.getText());
            ps.setInt(5, status.getRetweetCount());
            ps.setInt(6, status.getFavoriteCount());
            ps.setBoolean(7, status.isRetweet());
            ps.setBoolean(8, status.isFavorited());
            ps.executeUpdate();
            System.out.println("Status info entered in Database");
        } 
        catch (SQLException sqlEx)
        {
           System.err.println(sqlEx.getMessage());
        }
    }
    
    public void status()
    {
        TwitterStream twitterStream = 
                new TwitterStreamFactory(cb.build()).getInstance();
        try 
	{   
            Parameter obj = new Parameter();
            Class.forName(obj.getJDBCDriver());
            System.out.println("Connecting to a selected database...");
            try 
            {
                conn = DriverManager.getConnection(obj.getDatabaseURL(), 
                                obj.getUserName(), obj.getPassword());
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
            System.out.println("Connected database successfully...");
            System.out.println("Inserting records into the table...");
        }
	catch (ClassNotFoundException ex)
	{
            System.err.println(ex.getMessage());
        }
	try
	{
            StatusListener listener = new StatusListener()
            {
                int i = 0, getTweetLimit = 5;
                @Override
                public void onStatus(Status status)
                {
                    System.out.println("Tweet number: " + ++i);
                    enterStatusDatabase(status);   
                    if (i == getTweetLimit)
                    {
                        synchronized(lock)
                        {
                            lock.notify();
                        }
                        System.out.println("End");
                    }
                }
                @Override
                public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice)
                {
                    System.out.println("Got a status deletion notice id:" 
                            + statusDeletionNotice.getStatusId());
                }
                @Override
                public void onTrackLimitationNotice(int numberOfLimitedStatuses)
                {
                    System.out.println("Got track limitation notice:" 
                            + numberOfLimitedStatuses);
                }
                @Override
                public void onScrubGeo(long userId, long upToStatusId)
                {
                    System.out.println("Got scrub_geo event userId:" + userId 
                            + " upToStatusId:" + upToStatusId);
                }
                @Override
                public void onStallWarning(StallWarning warning)
                {
                    System.out.println("Got stall warning:" + warning);
                }
                @Override
                public void onException(Exception ex)
                {
                    System.err.println(ex);
                }
            };        
            FilterQuery fq = new FilterQuery();
            fq.track(statusSearchKeyword);
            twitterStream.addListener(listener);
            twitterStream.filter(fq); 
            System.out.println("Starting Streaming......");
            try
            {
                synchronized(lock)
                {
                    lock.wait();
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
                    System.exit(0);
                }
            }
            catch (InterruptedException e)
            {
		System.err.println(e.getMessage());	
            }
            System.out.println("returning statuses");
			
        }
        catch (NullPointerException ex)
        { 
            System.err.println(ex.getMessage()); 
        }
        catch (Throwable ex)
        {
            System.err.println(ex.getMessage());
        }
    }
    public static void main(String[] args) throws TwitterException, Exception 
    {
        new StreamStatus().status();
    }
}