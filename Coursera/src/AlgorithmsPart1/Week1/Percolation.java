
package AlgorithmsPart1.Week1;
import algs4.*;

class Percolation 
{
    public int N;
    public WeightedQuickUnionUF upward;
    public WeightedQuickUnionUF wash;
    public boolean[][] grid;
    public Percolation(int N)
    {
        this.N = N;
	upward = new WeightedQuickUnionUF(N * N + 2);
	wash = new WeightedQuickUnionUF(N * N + 2);
	grid = new boolean[N][N];
    }
    public void open(int i, int j)
    {
        check(i, j);
	if ( checkOpen(i, j) == false)
        {
            grid[i - 1][j - 1] = true;
            unite(i, j, i - 1, j);
            unite(i, j, i + 1, j);
            unite(i, j, i, j - 1);
            unite(i, j, i, j + 1);
            if (i == 1)
            {
                upward.union(0, xy(i, j));
                wash.union(0, xy(i, j));
            } 
            if (i == N)
                upward.union(1, xy(i, j));
        }
    }
    public boolean checkOpen(int i, int j)
    {
        check(i, j);
        return grid[i - 1][j - 1];
    }
    public boolean isFull(int i, int j)
    {
        check(i, j);
	return wash.connected(0, xy(i, j));
    }
    public boolean percolates()
    {
        return upward.connected(0, 1);
    }
    public int xy(int i, int j)
    {
        check(i, j);
	return (i - 1) * N + j + 1;
    }
    public void unite(int i, int j, int m, int n)
    {
        if (m > 0 && n > 0 && m <= N && n <= N && checkOpen(m, n))
        {
            upward.union(xy(i, j), xy(m, n));
            wash.union(xy(i, j), xy(m, n));
	}
    }
    public void check(int i, int j)
    {
        int x = i - 1;
        int y = j - 1;
        if (x < 0 || y < 0 || x >= N || y >= N)
            throw new IllegalArgumentException();
    }
}