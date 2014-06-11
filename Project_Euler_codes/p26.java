
package mine;

public class p26 
{
    public static void main( String args[] )
    {
        int k, temp, d=0, max =0;
        int[][] a = new int[2][1001];
        for( int i=11; i<1000; i++ )
        {
            if( i%2 == 0 || i%5 == 0 )
                continue;
            else
            {
                for( int j=0; j<1001; j++ )
                {
                    a[0][j]=0;
                    a[1][j]=0;
                }
                k=0;
                int c=0;
                if( i<100)
                    temp = 100;
                else
                    temp = 1000;
                while( true )
                {
                    k++;
                    if( temp < i )
                    {
                        temp *= 10;
                        continue;
                    }
                    temp = temp % i;
                    if( a[0][temp] == 1)
                        break;
                    a[0][temp] = 1;
                    a[1][temp] = k;
                    temp *= 10;
                }
                if( max  < k )
                {
                    max = k;
                    d = i;
                }
            }
        }
        System.out.println(d);
    }
}
