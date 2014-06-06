
package mine;

import java.io.*;
import java.util.StringTokenizer;

public class p54 
{
    public static int convertCardInNumber(char ch)
    {
        switch(ch)
        {
            case 'T':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
        }
        return (byte)ch-48;
    }
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        int i;
        char ch;
        int count = 0;
        String line;
        StringTokenizer str;
        int[] p1 = new int[5];
        char[] p1_suit = new char[5];
        int[] p2 = new int[5];
        char[] p2_suit = new char[5];
        for( i=0; i<5; i++)
        {
            p1[i]=0;
            p2[i]=0;
            p1_suit[i] = ' ';
            p2_suit[i] = ' ';
        }
        String s;
        BufferedReader bfr=new BufferedReader(new FileReader("poker.txt"));
        PlayPoker playPoker = new PlayPoker();
        while(( line = bfr.readLine()) != null )
        {
            str = new StringTokenizer(line);
            for( i=0; i<10; i++)
            {
               s = str.nextToken();
               if( i < 5 )
               {
                   p1[i] = convertCardInNumber(s.charAt(0));
                   p1_suit[i] = s.charAt(1);
               }
               else
               {
                   p2[i-5] = convertCardInNumber(s.charAt(0));
                   p2_suit[i-5] = s.charAt(1);
               }
            }
            int flag;
            flag = playPoker.result(p1, p2, p1_suit, p2_suit);
            count += flag; 
            if( flag == 1)
                System.out.println(line);
        }
        System.out.println(count);
    }
}