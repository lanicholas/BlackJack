package lanicholas.loyola.edu.blackjack;

import android.widget.HeaderViewListAdapter;
import lanicholas.loyola.edu.blackjack.Stack;

public class Game {
    private Hand player;
    private Hand dealer;
    private Stack gameDeck;
    private String turn;
    private int numHits;

    public Game(){
        player = new Hand();
        dealer = new Hand();
        gameDeck = new Stack();
        gameDeck.createDeck();
        gameDeck.shuffle();
        turn = "player";
        numHits = 3;
    }

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

    public String stand(){
        if(turn.equals("player"))
        {
            turn = "dealer";
            numHits = 3;
        }
        return turn;

    }

    public boolean checkBust(Hand hand){
        if(hand.getHandPoints() > 21)
            return true;
        else
            return false;
    }

    public boolean checkWin(Hand hand){
        if(hand.getHandPoints() == 21)
            return true;
        else
            return false;
    }

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

    public Hand getPlayer(){
        return player;
    }

    public Hand getDealer() {
        return dealer;
    }
}
