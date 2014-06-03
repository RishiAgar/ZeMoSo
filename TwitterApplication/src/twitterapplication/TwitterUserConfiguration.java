
package twitterapplication;

import twitter4j.conf.ConfigurationBuilder;

public class TwitterUserConfiguration
{
    public ConfigurationBuilder TwitterConfiguration()
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        CheckConnection obj = new CheckConnection();
        byte flag = -1;
        try
        {
            flag = obj.check();
        }
        catch( Exception ex )
        {
            System.err.println( ex.getMessage());
        }
        cb.setOAuthConsumerKey("oOn2pvu0k6keonHCgEukOg");
        cb.setOAuthConsumerSecret("uqF7jzfOubX4ahcADbKeAOjQB22TzXcQxC5Hn3XiNT0");
        cb.setOAuthAccessToken("238706762-U7bZ4OCccpar7TK2XVy4JpyavqyHbTGV5EBO6gnE");
        cb.setOAuthAccessTokenSecret("CbLzjL5CVHs73sSbp0laUGgAwDiPPWYGroCOZIRN6Ulut");
        switch( flag )
        {
            case 1:
                System.out.println("Twitter4j configured");
                break;
            case 2:
                cb.setHttpProxyHost(obj.proxyAddress);
                cb.setHttpProxyPort(obj.portNumber);
                System.out.println("Twitter4j configured using proxy");
                break;
            default:
                System.exit(0);
                break;
        }
        return cb;
    }
}
