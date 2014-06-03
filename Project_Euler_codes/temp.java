/*
import java.net.*;
import java.io.*;
public class temp
{
	public static void main(String[] args) throws Exception
	{
		String host = "10.3.100.211";
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, 8080));
		URL oracle = new URL("http://www.google.com/");
        URLConnection yc = oracle.openConnection(proxy);
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}

*/


import java.net.*;
import java.io.*;
public class temp
{
	public static void main(String[] args) throws Exception
	{
		int flag=0;
		BufferedReader in = null;
		URL oracle = new URL("http://www.google.com/");
		String host = "10.3.100.211";
		URLConnection yc = null;
		try 
		{
			yc = oracle.openConnection();
			in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			in.close();
			flag = 1;
			System.out.println("Connected: Proxy Not used");
			if(yc.getContentLength() == -1)
			  System.err.println("Error: Failed to verify connection");
		}
		catch (ConnectException e)
		{
			System.out.println("Checking Proxy connection");
			try 
			{
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, 8080));
				
				yc = oracle.openConnection(proxy);
				yc.setConnectTimeout(2000);
				in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
				in.close();
				flag = 2 ;
				System.out.println("Connected: Using Proxy");
			}
			catch (InterruptedIOException iioe)
			{
				System.err.println ("Remote host timed out during read operation");
			}
			catch (ConnectException e1)
			{
				System.err.println("Error: Connection not Established");
			}   
		}   
		catch (IOException e)
		{
			System.err.println("Error: Failed to open a connection");
		}
		System.out.println(flag);
	}
}