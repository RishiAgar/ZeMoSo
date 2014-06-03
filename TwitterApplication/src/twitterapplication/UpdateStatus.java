
package twitterapplication;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class UpdateStatus
{
    static ConfigurationBuilder cb;
    private String message = null;
    public UpdateStatus()
    {
        cb = new TwitterUserConfiguration().TwitterConfiguration();
        message = "Message Update";
    }
    public String getUpdateMessage()
    {
        return message;
    }
    private void tweet()
    {
        try
        {
            Twitter twitter = new TwitterFactory(cb.build()).getInstance();
            twitter.updateStatus( getUpdateMessage());
            System.out.println("Message Updated");
        }
        catch( TwitterException te )
	{
            System.err.println(te.getMessage());				
	}
    }
    public static void main( String args[]) 
    {
        UpdateStatus obj = new UpdateStatus();
        obj.tweet();
    }
}