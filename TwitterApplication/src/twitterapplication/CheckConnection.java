package twitterapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class CheckConnection
{
    public String proxyAddress = null;
    public int portNumber = 0;
    public byte check()throws Exception
    {
        byte flag=0;
        URLConnection yc;
        BufferedReader in;
        URL checkConnectionURL = new URL("http://www.google.com/");
        try 
        {
            yc = checkConnectionURL.openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            in.close();
            flag = 1;
            System.out.println("Connected: Proxy Not used");
            if(yc.getContentLength() == -1)
            {
                System.err.println("Error: Failed to verify connection");
            }
        }
        catch (ConnectException e)
        {
                System.out.println("Checking Proxy connection");
                try
                {
                    try( BufferedReader bfr = new BufferedReader
                            (new FileReader("proxy.txt"))) 
                    {
                        proxyAddress = bfr.readLine();
                        portNumber = Integer.parseInt(bfr.readLine());
                    }
                    Proxy proxy = new Proxy(Proxy.Type.HTTP, 
                            new InetSocketAddress(proxyAddress, portNumber));
                    yc = checkConnectionURL.openConnection(proxy);
                    yc.setConnectTimeout(2000);
                    in = new BufferedReader(new InputStreamReader
                            (yc.getInputStream()));
                    in.close();
                    flag = 2 ;
                    System.out.println("Connected: Using Proxy");
                    System.out.println("Proxy address: " + proxyAddress);
                    System.out.println("Port number: " + portNumber);
                }
                catch (InterruptedIOException | ConnectException ie)
                {
                        System.err.println (ie.getMessage());
                }   
        }   
        catch (IOException e)
        {
                System.err.println(e.getMessage());
        }
        return flag;
    }
}