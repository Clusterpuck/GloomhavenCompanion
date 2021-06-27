/************************************************
*   Author: Nicholas Wright 12880155            *
*   Purpose:                                    *
*   Date Written:                               *
*   Edited By:       Date Editted:              *
************************************************/
import java.util.*;
import javax.swing.*;

public class GloomHavenRoundCount
{
    public static void main(String[] args)
    {
        String handString, discardString, lostRoundString;
        int round = 0;
        int hand = 0;
        int discard = 0;
        int lost = 0;

        handString = JOptionPane.showInputDialog(null, "How many cards are in your hand?");
        hand  = Integer.parseInt(handString);
        discardString = JOptionPane.showInputDialog(null, "How many cards are in your discard pile?");
        discard  = Integer.parseInt(discardString);
        lost = Integer.parseInt( JOptionPane.showInputDialog(null, "How many lost cards will you play?") );
        int lostRounds[] = new int[lost];
        if(lost > 0)
        {
            for(int i=0; i < lost; i++)
            {
                lostRoundString = JOptionPane.showInputDialog(null, "In which round would you like to play lost card number "+ (i+1));
                lostRounds[i] = Integer.parseInt(lostRoundString);
            }
        }      
        
        round = roundCount(hand, discard, lostRounds);

        JOptionPane.showMessageDialog(null, "You have " + round + " more rounds until you exhaust"); 
    }

    
    /******************************************************************************
     * Purpose: Performs a round count using amount in hand, discards and number  *
     *          of losts card played and on which rounds.                         *
     *                                                                            *  
    ******************************************************************************/
    public static int roundCount( int pHand, int pDiscard, int[] pLostRounds )
    {
        int round = 0;
        int lost = pLostRounds.length;
        int lostCount = 0;

        while( ( pDiscard + pHand ) > 2) //should test if have stamina for any more rounds
        {
            System.out.println("You have " + pHand + " cards in the start of round " + round + " and " + pDiscard + " in discard");            
            if( (lost > lostCount) && (round == pLostRounds[lostCount]))
                //first checks if any more predetermined lost rounds left
                //then determines if current round is a planned lost round
            {
                System.out.println("You lose card in round " + round);
                pHand -= 2;
                ++pDiscard;
                ++lostCount;
            }
            else
            {
                pHand -= 2;
                pDiscard +=2;
            }
            if( pHand < 2 ) //shortrest
            {
                System.out.println("You perform a short rest in round " + round + " with a hand size of " + pHand + " and a discard of " + pDiscard);                
                pDiscard -= 1;
                pHand = pHand + pDiscard;
                pDiscard = 0;
            }
            round += 1;
        }
        //tests for final special condition where no cards in discard but two in hand, giving one final round.
        if(pHand==2)
        {
            round+=1;
        }
        return round;
    }
}
