
package AlgorithmsPart1.Week2;

import algs4.*;

public class Subset
{
    public static void main(String[] args)
    {
        int i, n;
        if( args.length < 1)
        {
            StdOut.println("Wrong input!");
            System.exit(0);
        }
        n = Integer.parseInt(args[0]);
        RandomizedQueue<String> str = new RandomizedQueue<String>();
        while ( StdIn.isEmpty() != false )
            str.enqueue( StdIn.readString() );
        for ( i=0; i<n; i++)
            StdOut.println(str.dequeue());
    }
}