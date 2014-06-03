import java.io.*;
public class p67
{
	public static void main(String[] args)throws IOException
	{
		int i, j=0 ,maxi, k=0, sum=0, l, len=0;
		char ch;
		BufferedReader bfr=new BufferedReader(new FileReader("p67.txt"));
		String s;
		int[][] a = new int[100][100];
		while(  k<100 )
		{
			s = bfr.readLine();
			len = s.length();
			l=99;
			j=0;
			for( i=len-1; i>=0; i-- )
			{
				ch = s.charAt(i);
				if( ch == ' ') 
				{
					sum = 0;
					j=0;
					continue;
				}
				else
				{
					if( j==0)
						sum+=(int)ch-48;
					else
						sum = sum + ((int)ch-48)*10;
					j++;
				}
				if(j ==2 && l>=0 && k<100)
				{
					a[k][l] = sum;
					l--;
				}
			}
			sum=0;
			for( i=l; i>=0 ; i-- )
				a[k][i] = 0;
			k++;
		}	
		bfr.close();	 		 
		for( i=1; i<100; i++ )
			for(j=99-i; j<100; j++)
				if( j == 99 )
					a[i][j] = a[i-1][j]+a[i][j];
				else if( j == 99-i )
					a[i][j] = a[i-1][j+1]+a[i][j];
				else
					a[i][j] = Math.max(  a[i-1][j+1], a[i-1][j]) + a[i][j];
		maxi=0;
		for( i=0; i<100; i++ )
			maxi = Math.max( maxi, a[99][i]);
		System.out.println(maxi);
	}
}