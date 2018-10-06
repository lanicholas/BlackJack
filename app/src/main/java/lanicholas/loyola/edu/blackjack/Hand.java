package lanicholas.loyola.edu.blackjack;

import java.util.ArrayList;

import lanicholas.loyola.edu.blackjack.Card;

/** A class representing a hand of cards
 *
 *  @author Lillian Nicholas
 *  @version 1.0 (10/6/18)
 *  @since version 0.0
 */
public class Hand {

    /** a list of cards representing a player's hand */
    private ArrayList<Card> cards;

    /** the total number of points in the hand which is the sum of each card's points */
    private int points;

    /** Create a new Hand object
     */
    public Hand(){
        cards = new ArrayList<Card>();
        points = 0;
    }

    /** Adds a card to the hand and sets points. If the card is
     *  an ace its point value is assigned based on the current
     *  point value of the hand
     * @param newCard the card that will be added to the hand
     */
    public void addCard(Card newCard){
        if(newCard.getPoints() == 0)
        {
            if ((points + 11) > 21)
            {
                newCard.setPoints(1);
            }
            else
            {
                newCard.setPoints(11);
            }
        }
        cards.add(newCard);
        setHandPoints();

    }

    /** Gets the number of cards in the hand
     * @return the number of cards in the hand
     */
    public int getNumCards(){
        return cards.size();
    }

    /** Gets the points of a hand
     * @return the number of points in the hand
     */
    public int getHandPoints(){
        return points;
    }

    /** Calculates the number of points in the hand by
     *  adding together the point values of each card
     */
    public void setHandPoints(){

        points = 0;

        for(int i = 0; i < cards.size(); i++)
        {
          points = points + cards.get(i).getPoints();
        }
    }

    /** Gets the ArrayList, cards
     * @return the ArrayList containing the cards in the hand
     */
    public ArrayList<Card> getCards(){
        return cards;
    }
}
