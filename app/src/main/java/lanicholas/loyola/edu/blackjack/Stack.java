package lanicholas.loyola.edu.blackjack;

import java.util.ArrayList;
import java.util.Random;

/** A class representing a stack of cards used in a game
 *
 *  @author Lillian Nicholas
 *  @version 1.0 (10/6/18)
 *  @since version 0.0
 */
public class Stack {

    /** A list of cards representing a stack of cards */
    private ArrayList<Card> cards;

    /** The number of card decks in the stack (either 1 or 2) */
    private int numDecks;

    /** Creates a new Stack object
     */
    public Stack()
    {
        cards = new ArrayList<Card>();
        Random r = new Random();
        numDecks = (r.nextInt(2)) + 1;
    }

    /** Creates a deck of cards and adds it to the stack numDecks times
     */
    public void createDeck( )
    {
        for(int i = numDecks; i > 0; i--)
        {
            Card cA = new Card("clubs", "ace", 0);
            Card c2 = new Card("clubs", "two",2);
            Card c3 = new Card("clubs", "three", 3);
            Card c4 = new Card("clubs", "four", 4);
            Card c5 = new Card("clubs", "five", 5);
            Card c6 = new Card("clubs", "six", 6);
            Card c7 = new Card("clubs", "seven", 7);
            Card c8 = new Card("clubs", "eight", 8);
            Card c9 = new Card("clubs", "nine", 9);
            Card c10 = new Card("clubs", "ten", 10);
            Card cJ = new Card("clubs", "jack", 10);
            Card cQ = new Card("clubs", "queen", 10);
            Card cK = new Card("clubs", "king", 10);
            cards.add(cA);
            cards.add(c2);
            cards.add(c3);
            cards.add(c4);
            cards.add(c5);
            cards.add(c6);
            cards.add(c7);
            cards.add(c8);
            cards.add(c9);
            cards.add(c10);
            cards.add(cJ);
            cards.add(cQ);
            cards.add(cK);


            Card dA = new Card("diamonds", "ace", 0);
            Card d2 = new Card("diamonds", "two",2);
            Card d3 = new Card("diamonds", "three", 3);
            Card d4 = new Card("diamonds", "four", 4);
            Card d5 = new Card("diamonds", "five", 5);
            Card d6 = new Card("diamonds", "six", 6);
            Card d7 = new Card("diamonds", "seven", 7);
            Card d8 = new Card("diamonds", "eight", 8);
            Card d9 = new Card("diamonds", "nine", 9);
            Card d10 = new Card("diamonds", "ten", 10);
            Card dJ = new Card("diamonds", "jack", 10);
            Card dQ = new Card("diamonds", "queen", 10);
            Card dK = new Card("diamonds", "king", 10);
            cards.add(dA);
            cards.add(d2);
            cards.add(d3);
            cards.add(d4);
            cards.add(d5);
            cards.add(d6);
            cards.add(d7);
            cards.add(d8);
            cards.add(d9);
            cards.add(d10);
            cards.add(dJ);
            cards.add(dQ);
            cards.add(dK);

            Card hA = new Card("hearts", "ace", 0);
            Card h2 = new Card("hearts", "two",2);
            Card h3 = new Card("hearts", "three", 3);
            Card h4 = new Card("hearts", "four", 4);
            Card h5 = new Card("hearts", "five", 5);
            Card h6 = new Card("hearts", "six", 6);
            Card h7 = new Card("hearts", "seven", 7);
            Card h8 = new Card("hearts", "eight", 8);
            Card h9 = new Card("hearts", "nine", 9);
            Card h10 = new Card("hearts", "ten", 10);
            Card hJ = new Card("hearts", "jack", 10);
            Card hQ = new Card("hearts", "queen", 10);
            Card hK = new Card("hearts", "king", 10);
            cards.add(hA);
            cards.add(h2);
            cards.add(h3);
            cards.add(h4);
            cards.add(h5);
            cards.add(h6);
            cards.add(h7);
            cards.add(h8);
            cards.add(h9);
            cards.add(h10);
            cards.add(hJ);
            cards.add(hQ);
            cards.add(hK);

            Card sA = new Card("spades", "ace", 0);
            Card s2 = new Card("spades", "two",2);
            Card s3 = new Card("spades", "three", 3);
            Card s4 = new Card("spades", "four", 4);
            Card s5 = new Card("spades", "five", 5);
            Card s6 = new Card("spades", "six", 6);
            Card s7 = new Card("spades", "seven", 7);
            Card s8 = new Card("spades", "eight", 8);
            Card s9 = new Card("spades", "nine", 9);
            Card s10 = new Card("spades", "ten", 10);
            Card sJ = new Card("spades", "jack", 10);
            Card sQ = new Card("spades", "queen", 10);
            Card sK = new Card("spades", "king", 10);
            cards.add(sA);
            cards.add(s2);
            cards.add(s3);
            cards.add(s4);
            cards.add(s5);
            cards.add(s6);
            cards.add(s7);
            cards.add(s8);
            cards.add(s9);
            cards.add(s10);
            cards.add(sJ);
            cards.add(sQ);
            cards.add(sK);
        }
    }

    /** Removes a card from the top of the stack
     * @return the top card on the stack that was removed
     */
    public Card removeCard(){
        Card topCard = cards.get(cards.size() - 1);
        cards.remove((cards.size()) - 1);
        return topCard;
    }

    /** Shuffles the cards in the stack by randomly rearranging them
     */
    public void shuffle(){

        for(int i = 0; i < 51; i++)
        {
            Random r = new Random();
            int indexToSwap = r.nextInt(51);

            Card tmp1 = cards.get(i);
            Card tmp2 = cards.get(indexToSwap);

            cards.set(indexToSwap, tmp1);
            cards.set( i, tmp2);
        }
    }

}
