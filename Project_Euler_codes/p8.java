import java.io.*;
public class p8
{
    public static void main(String[] args) throws IOException
	{
		int a=1, count=0, pro=1, max=0, n=0, i;
        BufferedReader bfr=new BufferedReader(new FileReader("p8.txt"));
		int[] b = new int[5];
		while(( n = (int)bfr.read()) != -1 )
		{
			a = n-48;
			if( a < 0)
				continue;
			count++;
			if( a == 0 )
			{
				pro=1;
				for( i=0; i<5; i++ )
					b[i] = 1;
				continue;
			}
			if( count == 5)
			{
				pro *= a;
				max = pro;
				b[count - 1] = a;
				continue;
			}
			else if( count < 5 )
			{
				pro *=a;
				b[count-1] = a;
			}
			else
			{
				pro = pro * a / b[0];
				for( i=1; i<5; i++ )
					b[i-1] = b[i];
				b[4] = a;
			}
			if( max < pro )
				max = pro;
		}
		System.out.println(max);
		bfr.close();
    }
}