package twitterapplication;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class SimpleSearch
{
	public static void main(String[] args) throws TwitterException 
	{
            String searchKeyword = "#kejriwal";
            ConfigurationBuilder cb = new TwitterUserConfiguration().TwitterConfiguration();
            Twitter twitter = new TwitterFactory(cb.build()).getInstance();
            QueryResult result = twitter.search(new Query(searchKeyword));
            for (Status status : result.getTweets())
            {
                System.out.println("@" + status.getUser().getScreenName() 
                        + ":" + status.getText());
            }
        }
}