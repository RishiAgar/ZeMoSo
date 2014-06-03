
package coursera.week1;

import algs4.*;

class PercolationStats
{
    public double[] thres;
    public PercolationStats(int N, int T)
    {
        if (T <= 0 || N <= 0)
            throw new IllegalArgumentException("N and T should be positive!");
	thres = new double[T];
	for (int i = 0; i < T; i++)
        {
            Percolation percolation = new Percolation(N);
            double openSitesCount = 0d;
            while (!percolation.percolates())
            {
                int x = StdRandom.uniform(1, N + 1);
		int y = StdRandom.uniform(1, N + 1);
		if (!percolation.checkOpen(x, y))
                {
                    percolation.open(x, y);
                    openSitesCount++;
		}
            }
            thres[i] = openSitesCount / (N*N);
        }
    }
    public double mean()
    {
        return StdStats.mean(thres);
    }
    public double stddev_func()
    {
        if (thres.length > 1)
            return StdStats.stddev(thres);
        else
            return Double.NaN;
    }
    public static void main(String[] args)
    {
        int T = Integer.parseInt(args[1]);
	PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), T);
	double mean = stats.mean();
	StdOut.println("mean = " + mean);
	double stddev = stats.stddev_func();
	StdOut.println("stddev = " + stddev);
	double d = (1.96 * stddev) / Math.sqrt(T);
	StdOut.println("95% confidence interval = " + (mean - d) + ", " + (mean + d));
    }
}