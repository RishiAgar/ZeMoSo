public class p19
{
	public static void main(String[] args)
	{
		int i, j, s=0, count=0;
		for( i=1900; i<=2000; i++ )
		{
			for( j=1; j<=12; j++ )
			{
				if( j==1 || j==3 || j==5 || j==7 || j==8 || j==10 || j==12 )
					s+=31;
				else if( j==4 || j==6 || j==9 || j==11 )
					s+=30;
				else
					if( i%4 != 0)
						s+=28;
					else
						if( i%400 == 0 || i%100 != 0 )
							s+=29;
				if( s%7 == 6 && i>1900)
					count++;
			}
		}
		System.out.println(count);
	}
}