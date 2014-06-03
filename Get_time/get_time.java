import java.io.*;
import java.lang.Math.*;
import java.util.*;
import java.text.*;
public class get_time
{
	public static void main(String[] args) throws IOException
	{
		int h, m, l, i, hr = 0, min=0, hr2=0, min2=0;
		byte temp = 0;
		char ch;
		String line="", str="", city="", time="";
		long diff_mil;
		if( args.length != 2)
		{
			System.out.println("ERROR! Wrong Input!");
			System.exit(0);
		}
		if( args[0].charAt(0) >= 48 && args[0].charAt(0) <= 57 )
		{
			temp = 1 ;
			time = args[0];
			city = args[1];
		}
		else if( args[1].charAt(0) >= 48 && args[1].charAt(0) <= 57 )
		{
			temp = -1;
			time = args[1];
			city = args[0];
		}
		else
		{
			System.out.println("ERROR! Wrong Input!");
			System.exit(0);
		}
		int city_len  = city.length();
		int len  = time.length();
		int[] a = new int[4];
		for( i=0; i<4; i++ )
			a[i] = 0;
		byte flag = 0;
		int k = 0;
		for( i=0; i<len; i++ )
		{
			ch = time.charAt(i);
			if( (int)ch >= 48 && (int)ch <= 57 )
				a[k++] = (int)ch - 48;
			if( ch == 'p' || ch == 'P')
			{
				flag=1;
				break;
			}
			else if( ch == 'a'|| ch == 'A' )
			{
				flag=2;
				break;
			}
		}
		if( k == 0)
		{
			System.out.println("ERROR! Enter time");
			System.exit(0);
		}
		else if( k == 1 )
			if( flag == 0 || flag == 2 )
				hr = a[0];
			else
				hr = 12 + a[0];
		else if( k == 2 )
		{
			hr = a[0]*10 +a[1];
			if( hr > 24 )
			{
				System.out.println("ERROR! Hour cannot be greater than 24");
				System.exit(0);
			}
			else if( hr > 12 && flag == 2 )
			{
				System.out.println("ERROR! For a.m. hour should be less than 12"); 
				System.exit(0);
			}
		}
		else if( k == 3 )
		{
			hr = a[0];
			min = a[1]*10 + a[2];
			if( min >= 60 )
			{
				System.out.println("ERROR! Minute cannot be greater than 60"); 
				System.exit(0);
			}
			if( flag == 1 )
				hr = hr + 12;
		}
		else if( k == 4 )
		{
			hr = a[0]*10 + a[1];
			min = a[2]*10 + a[3];
			if( min >= 60 )
			{
				System.out.println("ERROR! Minute cannot be greater than 60"); 
				System.exit(0);
			}
			if( hr > 24 )
			{
				System.out.println("ERROR! Hour cannot be greater than 24");
				System.exit(0);
			}
			else if( hr >= 12 && flag == 2 )
			{
				System.out.println("ERROR! For a.m. hour should be less than 12"); 
				System.exit(0);
			}
		}
		else
		{
			System.out.println("ERROR! Wrong time"); 
			System.exit(0);
		}
		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		TimeZone fromZone = cal.getTimeZone();
		Date date2 = new Date(d.getTime() - fromZone.getRawOffset());
		long differenceInMillis = d.getTime() - date2.getTime();
		Date myDate = new Date(differenceInMillis );
		int gmt_min = ((int)differenceInMillis / (1000 * 60)) % 60;
		int gmt_hr = ((int)differenceInMillis / (1000 * 60 * 60)) % 24;
		BufferedReader bfr = null;
		try
		{
			bfr = new BufferedReader(new FileReader("Cities_Database.txt"));
		}
		catch (Exception e)
		{
			System.out.println("ERROR! Database for cities not present");
			System.exit(0);
		}		
		while ((line = bfr.readLine()) != null)
		{
			l = line.length();
			str = line.substring( 0, city_len);
			if( (city.toLowerCase()).compareTo(str.toLowerCase()) == 0 )
			{
				for( i=city_len; i<l-4 ; i++ )
				{
					ch = line.charAt(i);
					if(( line.substring(i, i+3)).compareTo("GMT") == 0 )
					{
						hr2  = (line.charAt(i+4)-48)*10 + (line.charAt(i+5)-48);
						min2 = (line.charAt(i+7)-48)*10 + (line.charAt(i+8)-48);
						break;
					}
				}
				if( line.charAt(i+3) == '+' )
				{
					hr2 = hr + temp*(- gmt_hr + hr2) ;
					min2 = min + temp*(- gmt_min + min2);
					if( min2 >=60 )
					{
						min2 = min2 -60;
						hr2 = hr2 + 1;
					}
					if( hr2 >= 24 )
						hr2 = hr2 - 24;
					if( min2 <0 )
					{
						min2 = min2 + 60;
						hr2 = hr2 - 1;
					}
					if( hr2 < 0 )
						hr2 = hr2 + 24;
				}
				else
				{
					hr2 = hr + temp*(- gmt_hr - hr2) ;
					min2 = min + temp*(- gmt_min - min2);
				}
				for( i = l-1; i>=0; i--)
					if( line.charAt(i)>=65 &&line.charAt(i)<=92)
						continue;
					else
						break;
				
				System.out.print( String.format("%02d", hr2) + ":" + String.format("%02d", min2) + " " );
				if( temp == 1 )
					System.out.println( line.substring( i+1, l) );
				else
				{
					time = date2.toString();
					k = time.length();
					for( i=k-6; i>=0; i-- )
						if( time.charAt(i) == ' ' )
							break;
					System.out.println( time.substring( i+1, k-5) );
				}
				bfr.close();
				System.exit(0);
			}
			else if((city.toLowerCase()).compareTo(str.toLowerCase()) < 0)
			{
					System.out.println("ERROR! City not in Database");
					bfr.close();
					System.exit(0);
			}
		}
		System.out.println("ERROR! City not in Database");
	}
}
