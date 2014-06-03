public class p52
{
	public static void main(String[] args)
	{
		int k=2, i,j, temp,flag=1, l;
		int[] a = new int[10];
		int[] b = new int[10];
		for( i=11; ; i++ )
		{
			if( 6*i >= (int)Math.pow(10,k+1) )
			{
				i = (int)Math.pow(10,k+1)+1;
				k++;
				continue;
			}
			for( j=0; j<10; j++ )
			{
				a[j]=0;
				b[j]=0;
			}
			flag=1;
			temp=i;
			while(temp!=0)
			{
				a[temp%10]++;
				temp/=10;
			}
			for( j=2; j<7; j++ )
			{
				temp =j*i;
				while(temp!=0)
				{
					b[temp%10]++;
					temp/=10;
				}
				for( l=0; l<10; l++ )
					if( a[l]!=b[l] )
					{
						flag=0;
						break;
					}
				for( l=0; l<10; l++ )
					b[l]=0;
			}
			if( flag==1)
			{
				System.out.println(i);
				break;
			}
		}
	}
}