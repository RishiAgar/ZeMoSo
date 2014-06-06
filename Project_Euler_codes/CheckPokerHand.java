package mine;

import static java.util.Arrays.*;

public class CheckPokerHand 
{
    public boolean checkSameSuit( char[] suit)
    {
        for( int i=0;i<suit.length-1; i++ )
            if(suit[i] != suit[i+1])
                return false;
        return true;
    }
   public boolean royalFlush(int[] p, char[] suit)
   {
       if(checkSameSuit(suit))
       {
           sort(p);
           for( int i=0; i<p.length; i++ )
               if( p[i] != (10+i))
                   return false;
           return true;
       }
       return false;
   }
   public boolean straight(int[] p)
   {
        sort(p);
        int flag=1;
        for( int i=0; i<p.length-1; i++ )
            if( p[i]+1 != p[i+1] )
                flag=0;
        if( flag == 1 )
            return true;
        if( p[p.length-1] == 14 && p[0] == 2 )
        {
            if( p[3] == 13 && p[2] == 12 && p[1] == 11 )
                return true;
            if( p[3] == 13 && p[2] == 12 && p[1] == 3 )
                return true;
            if( p[3] == 13 && p[2] == 4 && p[1] == 3 )
                return true;
            if( p[3] == 5 && p[2] == 4 && p[1] == 3 )
                return true;
        }
        return false;
   }
   public boolean straightFlush(int[] p, char[] suit)
   {
       if(checkSameSuit(suit) && straight(p))
           return true;
       return false;
   }
   public boolean flush( char[] suit)
   {
       if(checkSameSuit(suit))
           return true;
       return false;
   }
   public boolean fourOfKind(int[] p)
   {
       int i, flag=1;
       sort(p);
       for( i=0; i<p.length-2; i++ )
           if( p[i] != p[i+1] )
               flag=0;
       if( flag == 1 )
           return true;
       flag=1;
       for( i=1; i<p.length-1; i++ )
           if( p[i] != p[i+1] )
               flag=0;
       if( flag ==1 )
           return true;
       return false;
   }
   public boolean fullHouse(int[] p)
   {
       sort(p);
       if( p[0] == p[1] && p[2] == p[3] && p[3] == p[4] )
           return true;
       if( p[4] == p[3] && p[2] == p[1] && p[1] == p[0] )
           return true;
       return false;
   }
   public int threeOfKind(int[] p)
   {
       sort(p);
       if( p[0] == p[1] && p[0] == p[2])
           return p[0];
        if( p[2] == p[1] && p[3] == p[2])
           return p[1];
        if( p[2] == p[3] && p[4] == p[2])
           return p[2];
       return 0;
   }
   public int checkPair(int[] p)
   {
       int count=0;
       for( int i=0; i<p.length-1; i++ )
           if( p[i] == p[i+1])
               count++;
       return count;
   }
   public boolean twoPair(int[] p)
   {
       if( checkPair(p) == 2 )
           return true;
       return false;
   }
   public boolean singlePair(int[] p)
   {
       if( checkPair(p) == 1 )
           return true;
       return false;
   }
   public int maximumNumber(int[] p)
   {
       sort(p);
       return p[p.length-1];
   }
}