package lanicholas.loyola.edu.blackjack;

import android.widget.HeaderViewListAdapter;
import lanicholas.loyola.edu.blackjack.Stack;

/** A class representing a Blackjack game object
 *
 *  @author Lillian Nicholas
 *  @version 1.0 (10/6/18)
 *  @since version 0.0
 */
public class Game {

    /** The player's hand */
    private Hand player;

    /** The dealer's hand */
    private Hand dealer;

    /** The Stack of cards which cards are dealt from  */
    private Stack gameDeck;

    /** whose turn it is currenlty in the game */
    private String turn;

    /** The number of hits the player or dealer has left on their turn */
    private int numHits;

    /**
     * Creates a new Game object
     */
    public Game(){
        player = new Hand();
        dealer = new Hand();
        gameDeck = new Stack();
        gameDeck.createDeck();
        gameDeck.shuffle();
        turn = "player";
        numHits = 3;
    }

    /** Deal cards to the player and the dealer
     */
    public void dealCards(){
        Card card1 = gameDeck.removeCard();
        Card card2 = gameDeck.removeCard();

        player.addCard(card1);
        player.addCard(card2);


        Card card3 = gameDeck.removeCard();
        Card card4 = gameDeck.removeCard();

        dealer.addCard(card3);
        dealer.addCard(card4);

    }

    /** adds a card to the hand of the person whose turn it is
     */
    public void hit(){
        if(turn.equals("player") && numHits > 0)
        {
            Card card = gameDeck.removeCard();
            player.addCard(card);
            numHits--;
        }
        else if(turn.equals("dealer") && numHits > 0)
        {
            Card card = gameDeck.removeCard();
            dealer.addCard(card);
            numHits--;
        }
    }

    /** Changes whose turn it is and resets numHits
     * @return the name of the person whose turn it is
     */
    public String stand(){
        if(turn.equals("player"))
        {
            turn = "dealer";
            numHits = 3;
        }
        return turn;

    }

    /** Checks a hand to see if its points are greater than 21
     * @param hand the hand that is being checked for bust
     * @return true is the hand has more than 21 points, false otherwise
     */
    public boolean checkBust(Hand hand){
        if(hand.getHandPoints() > 21)
            return true;
        else
            return false;
    }

    /** Checks a hand to see if its points are exactly 21
     * @param hand the hand that is being checked a win
     * @return true is the hand had exactly 21 points, false otherwise
     */
    public boolean checkWin(Hand hand){
        if(hand.getHandPoints() == 21)
            return true;
        else
            return false;
    }

    /** Scores the game after the dealer has taken his turn
     * @return The message to be displayed on the screen to the user
     */
    public String scoreGame(){

        String result;
        if(checkWin(player))
            result = "You win!";
        else if(checkWin(dealer))
            result = "The dealer wins!";
        else if(checkBust(player))
            result = "You went bust! The dealer wins!";
        else if(checkBust(dealer))
            result = "The dealer went bust! You win!";
        else
            result = "It's a tie!";
        return result;
    }

    /** gets the hand of the player
     * @return the hand associated with the player
     */
    public Hand getPlayer(){
        return player;
    }

    /** gets the hand of the dealer
     * @return the hand associated with the dealer
     */
    public Hand getDealer() {
        return dealer;
    }
}
