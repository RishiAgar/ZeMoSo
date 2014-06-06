
package mine;

import static java.util.Arrays.sort;

public class PlayPoker 
{
    CheckPokerHand check;
    public int result(int player1[], int player2[], char player1_suit[], char player2_suit[])
    {
        check = new CheckPokerHand();
        if( check.royalFlush(player1, player1_suit))
            return 1;
        if( check.royalFlush(player2, player2_suit))
            return 0;
        
        if( check.straightFlush(player1, player1_suit) && check.straightFlush(player2, player2_suit))
        {
            if( check.maximumNumber(player1) > check.maximumNumber(player2))
                return 1;
            else
                return 0;
        }
        else if( check.straightFlush(player1, player1_suit))
            return 1;
        else if( check.straightFlush(player2, player2_suit))
            return 0;
        
        if( check.fourOfKind(player1) && check.fourOfKind(player2))
        {
            if( check.maximumNumber(player1) > check.maximumNumber(player2))
                return 1;
            else
                return 0;
        }
        else if( check.fourOfKind(player1))
            return 1;
        else if( check.fourOfKind(player2))
            return 0;
        
        if( check.fullHouse(player1) && check.fullHouse(player2))
        {
            if( check.threeOfKind(player1) > check.threeOfKind(player2))
                return 1;
            if( check.threeOfKind(player1) < check.threeOfKind(player2))
                return 0;
            for( int i=player1.length-1; i>=0; i-- )
            {
                if( player1[i] == check.threeOfKind(player1))
                    player1[i] = 0;
                if( player2[i] == check.threeOfKind(player2))
                    player2[i] = 0;
            }
            sort(player1);
            sort(player2);
            if( player1[4] > player2[4])
                return 1;
            if( player1[4] < player2[4])
                return 0;
        }
        if( check.fullHouse(player1))
            return 1;
        if( check.fullHouse(player2))
            return 0;
        
        if( check.flush(player1_suit) && check.flush(player2_suit))
        {
            sort(player1);
            sort(player2);
            for( int i=player1.length-1; i>=0; i-- )
            {
                if( player1[i] == player2[i])
                    continue;
                else if( player1[i] > player2[i])
                    return 1;
                else
                    return 0;
            }
        }
        if( check.flush(player1_suit))
            return 1;
        if( check.flush(player2_suit))
            return 0;
        
        if( check.straight(player1) && check.straight(player2))
        {
            if( check.maximumNumber(player1) > check.maximumNumber(player2))
                return 1;
            else
                return 0;
        }
        if( check.straight(player1))
            return 1;
        if( check.straight(player2))
            return 0;
        
        if( check.threeOfKind(player1) != 0 && check.threeOfKind(player2) != 0 )
        {
            if( check.threeOfKind(player1) > check.threeOfKind(player2))
                return 1;
            else if( check.threeOfKind(player1) < check.threeOfKind(player2))
                return 0;
            else
            {
                for( int i=player1.length-1; i>=0; i-- )
                {
                    if( player1[i] == check.threeOfKind(player1))
                        player1[i] = 0;
                    if( player2[i] == check.threeOfKind(player2))
                        player2[i] = 0;
                }
                sort(player1);
                sort(player2);
                for( int i=player1.length-1; i>=0; i-- )
                {
                    if( player1[i] == player2[i])
                        continue;
                    else if( player1[i] > player2[i])
                        return 1;
                    else
                        return 0;
                }
            }
        }
        if( check.threeOfKind(player1) != 0)
            return 1;
        if( check.threeOfKind(player2) != 0)
            return 0;
        
        
        if( check.twoPair(player2) && check.twoPair(player1))
        {
            int[] flag1 = new int[2];
            int[] flag2 = new int[2];
            int k1=0, k2=0;
            for( int i=0; i<player1.length; i++ )
            {
                if( player1[i] == player1[i+1])
                    flag1[k1++] = player1[i];
                if( player2[i] == player2[i+1])
                    flag2[k2++] = player2[i];
            }
            if( Math.max( flag1[0], flag1[1]) > Math.max( flag2[0], flag2[1]) )
                return 1;
            if( Math.max( flag1[0], flag1[1]) < Math.max( flag2[0], flag2[1]) )
                return 0;
            if( Math.min( flag1[0], flag1[1]) > Math.min( flag2[0], flag2[1]) )
                return 1;
            if( Math.min( flag1[0], flag1[1]) < Math.min( flag2[0], flag2[1]) )
                return 0;
            for( int i=player1.length-1; i>=0; i-- )
                {
                    if( player1[i] == flag1[0] || player1[i] == flag1[1] )
                        player1[i] = 0;
                    if( player2[i] == flag2[0] || player2[i] == flag2[1] )
                        player2[i] = 0;
                }
                sort(player1);
                sort(player2);
                for( int i=player1.length-1; i>=0; i-- )
                {
                    if( player1[i] == player2[i])
                        continue;
                    else if( player1[i] > player2[i])
                        return 1;
                    else
                        return 0;
                }
        }
        if( check.twoPair(player1))
            return 1;
        if( check.twoPair(player2))
            return 0;
        
        
        if( check.singlePair(player2) && check.singlePair(player1))
        {
            sort(player1);
            sort(player2);
            int flag1=-1, flag2=-1;
            for( int i=0; i<player1.length-1; i++ )
            {
                if( player1[i] == player1[i+1])
                    flag1 = player1[i];
                if( player2[i] == player2[i+1])
                    flag2 = player2[i];
                
            }
            if( flag1 > flag2 )
                return 1;
            else if( flag2 > flag1 )
                return 0;
            else
            {
                for( int i=player1.length-1; i>=0; i-- )
                {
                    if( player1[i] == flag1)
                        player1[i] = 0;
                    if( player2[i] == flag2)
                        player2[i] = 0;
                }
                sort(player1);
                sort(player2);
                for( int i=player1.length-1; i>=0; i-- )
                {
                    if( player1[i] == player2[i])
                        continue;
                    else if( player1[i] > player2[i])
                        return 1;
                    else
                        return 0;
                }
            }
        }
        if( check.singlePair(player1))
            return 1;
        if( check.singlePair(player2))
            return 0;
        
        if( check.maximumNumber(player1) > check.maximumNumber(player2))
            return 1;
        else if(check.maximumNumber(player1) < check.maximumNumber(player2))
            return 0;
        sort(player1);
        sort(player2);
        for( int i=player1.length-2; i>=0; i-- )
            {
                if( player1[i] == player2[i])
                    continue;
                else if( player1[i] > player2[i])
                    return 1;
                else
                    return 0;
            }
        return 0;
    }
}
