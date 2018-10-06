package lanicholas.loyola.edu.blackjack;

import java.util.ArrayList;

import lanicholas.loyola.edu.blackjack.Card;

public class Hand {

    private ArrayList<Card> cards;
    private int points;

    public Hand(){
        cards = new ArrayList<Card>();
        points = 0;
    }

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

    public int getNumCards(){
        return cards.size();
    }

    public int getHandPoints(){
        return points;
    }

    public void setHandPoints(){

        points = 0;

        for(int i = 0; i < cards.size(); i++)
        {
          points = points + cards.get(i).getPoints();
        }
    }

    public ArrayList<Card> getCards(){
        return cards;
    }
}
