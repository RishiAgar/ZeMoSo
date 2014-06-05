package mine;

import java.io.*;

public class p96
{
    public static void main(String args[]) throws Exception
    {
        sudoku obj=null;
        int sum=0;
        int[][] a = new int[9][9];
        String line;
        int i=0, j=0, k=0;
        BufferedReader bfr=new BufferedReader(new FileReader("p96.txt"));
	while(( line = bfr.readLine()) != null )
	{
            if( line.charAt(0)== 'G' )
            {
                i=-1;
                if( k == 1)
                {
                    obj = new sudoku(a);
                    obj.func(0, 0);
                    sum += obj.sum ;
                }
                k=1;
                continue;
            }
            else
            {
                i++;
                for( j=0; j<9; j++ )
                   a[i][j] = (int)line.charAt(j)- 48;
                continue;
            }
        }
        System.out.println(sum);
    }
}
