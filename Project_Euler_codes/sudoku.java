package mine;

public class sudoku
{
        int sum=0;
	public int[][] a= new int[9][9] ;
   	public sudoku(int[][] a)
   	{
		for( int i = 0; i < 9; i++ )
			for(int j=0; j < 9; j++ )
				this.a[i]a[j] = a[i][j];

	}
   	public void func( int row, int col ) throws Exception
   	{
		int i, j, num, r, c, flag;
      		if( row > 8 )
      		{
         		sum = ((a[0][0])*100)+((a[0][1])*10)+a[0][2];
           		return;
      		}
      		if( a[row][col] != 0 )
         		next( row, col ) ;
      		else
      		{
			for( num = 1; num < 10; num++ )
	    		{
				flag = 1;
				for( i = 0; i<9; i++ )
				{
					if( a[row][i] == num )
						flag = 0;
					if( a[i][col] == num )
						flag=0;
				}
				r = (row / 3) * 3 ;
      				c = (col / 3) * 3 ;
      				for( i = 0; i < 3; i++ )
         				for( j = 0; j < 3; j++ )
         					if( a[r+i][c+j] == num )
							flag =0;
				if( flag == 1 )
            			{
               				a[row][col] = num ;
               				next( row, col ) ;
            			}
			}
         		a[row][col] = 0 ;
      		}
   	}
   	public void next( int row, int col ) throws Exception
   	{
      		if( col < 8 )
         		func( row, col + 1 ) ;
      		else
         		func( row + 1, 0 ) ;
   	}
}
