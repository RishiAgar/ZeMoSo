public class p26
{
	public static void main(String args[])
	{
		int i, temp=0, count=0;
		int[] a=new int[1001];
		for( i=0; i<1001; i++ )
			a[i]=0;
		for( i=1; i<1001; i++ )
		{
			temp = i;
			while( true )
			{
				if ( temp%2 !=0 && temp%5 != 0 )
					break;
				if( temp%2 == 0) 
					temp/=2;
				if( temp%5 == 0) 
					temp/=5;
			}
			if(temp==i)
				count++;
			a[temp]++;
		}
		for( i=0; i<1001; i++ )
			if( a[i] != 0)
				System.out.print( i+" ");
		System.out.println("\n"+count);
	}
}