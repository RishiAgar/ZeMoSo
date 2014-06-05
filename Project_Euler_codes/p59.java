import java.io.*;
public class p59
{
    public static void main(String[] args) throws IOException
	{
		int b=1, n=0, i=0, k=0, max=0;
        	BufferedReader bfr=new BufferedReader(new FileReader("cipher1.txt"));
		int[] a = new int[1300];
		int[] c = new int[100];
		for( n=0; n<100; n++)
			c[n]=0;
		while(( n = (int)bfr.read()) != -1 )
		{
			if( n>58 || n<44)
				break;
			if( n==44)
			{
				i=i/10;
				a[k++]=i;
				c[i]++;
				if( max < i)
					max=i;
				i=0;
				continue;
			}
			else
			{
				i += (n-48);
				i *= 10;
			}
		}
		a[k++] = i/10;
		bfr.close();
		int[] d = new int[1300];
		char p, q;
		for( i=0; i<15; i++ )
			System.out.print( a[i]+" ");
		System.out.println();
		for( i=0; i<15; i++ )
		{
			p = (char)(a[i]);
			if( i%3 == 0)
				q = (char)(a[i+3]);
			else if( i%3 == 1)
				q = (char)(a[i+3]);
			else
				q = (char)(a[i+3]);
			System.out.println((byte)p+ " "+(byte)q+" "+(q^p)+" "+(((char)(q^p))^(char)(32)));
		}
		System.out.println("k2 = " +( ((char)79)^((char)115) )+"   k3 = "+ (((char)20)^((char)112)));
		for( i=2; i<k; i+=3 )
			System.out.print( (char)(((char)a[i])^((char)100))+" " );
		System.out.println();
		for( i=1; i<k; i+=3 )
			System.out.print( (char)(((char)a[i])^((char)60))+" " );		
		System.out.println();	
		max=0;	
		int pos=0;
		p=' ';			
		for( i=0; i<k; i++ )
		{
			if( i%3 == 0)
				System.out.print("_");
			else if( i%3 == 1)
				System.out.print("_");
			else
			{
				System.out.print( (char)(((char)a[i])^((char)100)) );
				if((char)(((char)a[i])^((char)100)) == ',' && max==0)
				{
					max=1;
					pos = i;
				}
			}
		}		
		p = (char)(((char)a[pos+1])^((char)32));
		System.out.println("\n");
		for( i=0; i<k; i++ )
		{
			if( i%3 == 0)
				System.out.print( (char)(((char)a[i])^(p)));
			else if( i%3 == 1)
				System.out.print("_");
			else
				System.out.print( (char)(((char)a[i])^((char)100)) );
		}
		System.out.println("\n");
		System.out.println(p+"_"+((char)100)+"\n");
		int sum;
		p = (char)(((char)a[pos+2])^'a');
		System.out.println("\n");
		for( i=0; i<k; i++ )
		{
			if( i%3 == 0)
				a[i] = (((char)a[i])^((char)103));
			else if( i%3 == 1)
				a[i] = (((char)a[i])^p);
			else
				a[i] = (((char)a[i])^((char)100));
			System.out.print( (char)a[i] );		
		}
		System.out.println("\n");
		sum=0;
		for( i=0; i<k; i++ )
			sum += a[i];
		System.out.println(sum+"\n");
	}
}
