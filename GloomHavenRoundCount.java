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
        String handString, discardString, lostString, lostRoundString;
        int hand = 0; 
        int discard = 0;
        int round = 0;
        int lost = -1;
        handString = JOptionPane.showInputDialog(null, "How many cards are in your hand?");
        hand  = Integer.parseInt(handString);
        discardString = JOptionPane.showInputDialog(null, "How many cards are in your discard pile?");
        discard  = Integer.parseInt(discardString);
        lostString = JOptionPane.showInputDialog(null, "How many lost cards will you play?");
        lost  = Integer.parseInt(lostString);
        int lostRounds[] = new int[15];
        if(lost > 0)
        {
            for(int i=0; i < lost; i++)
            {
                lostRoundString = JOptionPane.showInputDialog(null, "In which round would you like to play lost card number "+ (i+1));
                lostRounds[i] = Integer.parseInt(lostRoundString);
            }
        }      

        int i = 0;
        while( (discard+hand) > 2) //should test if have stamina for any more rounds
        {
            System.out.println("You have " + hand + " cards in the start of round " + round+ " and " + discard + " in discard");            
            if( (lost > 0) && (round == lostRounds[i]))
            {
                System.out.println("You use a lose card in round " + round);
                hand -= 1;
                ++i;
                hand -= 1;
                discard +=1;
            }
            else
            {
                hand -= 2;
                discard +=2;
            }
            if(hand < 2) //shortrest
            {
                System.out.println("You perform a short rest in round " + round + " with a hand size of " + hand + " and a discard of " + discard);                
                discard -= 1;
                hand = hand + discard;
                discard = 0;
            }
            round += 1;
        }
        if(hand==2)
        {
            round+=1;
        }
        JOptionPane.showMessageDialog(null, "You have " + round + " more rounds until you exhaust"); 
    }
}
