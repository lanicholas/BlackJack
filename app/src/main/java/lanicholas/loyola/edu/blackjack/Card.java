package lanicholas.loyola.edu.blackjack;

import android.widget.ImageView;

public class Card {

    private int points;
    private String suit;
    private String value;

    public Card(String suit, String value, int points){
        this.suit = suit;
        this.value = value;
        this.points = points;
    }

    public int getPoints( ){
        return points;
    }

    public void setPoints(int p){
        points = p;
    }

    public String getSuit( ){
        return suit;
    }

    public String getValue( ){
        return value;
    }
}
