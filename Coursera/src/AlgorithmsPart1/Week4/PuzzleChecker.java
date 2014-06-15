
package AlgorithmsPart1.Week4;

import algs4.*;

public class PuzzleChecker
{
    public static void main(String[] args)
    {
        if( args.length < 1)
        {
            StdOut.println("Wrong input!");
            System.exit(0);
        }
        for (String file : args)
        {
            int i, j, N;
            In in = new In(file);
            N = in.readInt();
            int[][] tiles = new int[N][N];
            for ( i = 0; i < N; i++)
                for ( j = 0; j < N; j++)
                    tiles[i][j] = in.readInt();
            Board initial = new Board(tiles);
            Solver solver = new Solver(initial);
            System.out.println( file + ": " + solver.moves());
        }
    }
}