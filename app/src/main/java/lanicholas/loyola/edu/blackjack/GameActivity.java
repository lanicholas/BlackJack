package lanicholas.loyola.edu.blackjack;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import static android.graphics.drawable.Icon.createWithResource;


/** A class controlling the game
 *
 *  @author Lillian Nicholas
 *  @version 1.0 (10/6/18)
 *  @since version 0.0
 */
public class GameActivity extends AppCompatActivity {

    /** the game currently being player */
    private Game game;

    /** Starts the game and deals cards to the player and dealer.
     * Displays the cards and the points of the dealer's and player's hands
    * @TargetApi(Build.VERSION_CODES.M)
    * @Override
    */
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Resources res = getResources();

        game = new Game();
        game.dealCards();

        setContentView(R.layout.activity_game);
        Hand player = game.getPlayer();
        Hand dealer = game.getDealer();

        TextView playerPoints = (TextView) findViewById(R.id.playerPointsTextView);
        playerPoints.setText(player.getHandPoints() + "");

        TextView dealerPoints = (TextView) findViewById(R.id.dealerPointsTextView);
        dealerPoints.setText(dealer.getHandPoints() + "");



        ImageView pc1 = (ImageView) findViewById(R.id.playerC1);
        ImageView pc2 = (ImageView) findViewById(R.id.playerC2);
        ArrayList<Card> pCards = player.getCards();
        pc1.setImageResource(findCardImg(pCards.get(0)));
        pc2.setImageResource(findCardImg(pCards.get(1)));


        ImageView dc1 = (ImageView) findViewById(R.id.dealerC1);
        ImageView dc2 = (ImageView) findViewById(R.id.dealerC2);
        ArrayList<Card> dCards = dealer.getCards();
        dc1.setImageResource(findCardImg(dCards.get(0)));
        dc2.setImageResource(findCardImg(dCards.get(1)));


        if(game.checkWin(player) && game.checkWin(dealer))
        {
            TextView winner = (TextView) findViewById(R.id.winnerTextView);
            winner.setText("It's a tie!");
            Button hit = (Button) findViewById(R.id.hitButton);
            hit.setOnClickListener(null);
            Button stand = (Button) findViewById(R.id.standButton);
            stand.setOnClickListener(null);
        }

        if(game.checkWin(player))
        {
            TextView winner = (TextView) findViewById(R.id.winnerTextView);
            winner.setText("You win!");
            Button hit = (Button) findViewById(R.id.hitButton);
            hit.setOnClickListener(null);
            Button stand = (Button) findViewById(R.id.standButton);
            stand.setOnClickListener(null);
        }

        if(game.checkWin(dealer))
        {
            TextView winner = (TextView) findViewById(R.id.winnerTextView);
            winner.setText("The dealer wins!");
            Button hit = (Button) findViewById(R.id.hitButton);
            hit.setOnClickListener(null);
            Button stand = (Button) findViewById(R.id.standButton);
            stand.setOnClickListener(null);
        }


        Button hit = (Button) findViewById(R.id.hitButton);
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.hit();
                Hand player = game.getPlayer();
                ArrayList<Card> pCards = player.getCards();

                if(player.getNumCards() == 3)
                {
                    ImageView pc3 = (ImageView) findViewById(R.id.playerC3);
                    pc3.setImageResource(findCardImg(pCards.get(2)));
                }
                else if(player.getNumCards() == 4)
                {
                    ImageView pc4 = (ImageView) findViewById(R.id.playerC4);
                    pc4.setImageResource(findCardImg(pCards.get(3)));
                }
                else
                {
                    ImageView pc5 = (ImageView) findViewById(R.id.playerC5);
                    pc5.setImageResource(findCardImg(pCards.get(4)));
                }

                if(game.checkBust(player))
                {
                    TextView winner = (TextView) findViewById(R.id.winnerTextView);
                    winner.setText("You went bust! The Dealer wins!");
                    v.setOnClickListener(null);
                    Button stand = (Button) findViewById(R.id.standButton);
                    stand.setOnClickListener(null);
                }

                if(game.checkWin(player))
                {
                    TextView winner = (TextView) findViewById(R.id.winnerTextView);
                    winner.setText("You win!");
                    v.setOnClickListener(null);
                    Button stand = (Button) findViewById(R.id.standButton);
                    stand.setOnClickListener(null);
                }

                TextView playerPoints = (TextView) findViewById(R.id.playerPointsTextView);
                playerPoints.setText(player.getHandPoints() + "");
            }
        });

        Button stand = (Button) findViewById(R.id.standButton);
        stand.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String turn = game.stand();
                if(turn.equals("dealer"))
                {
                    dealersTurn(game.getDealer());
                    Log.w("Check", "out of DealersTurn");
                }
            }
        });

        Button restart = (Button) findViewById(R.id.restartButton);
        restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GameActivity.class); //change it to your main class
                //the following 2 tags are for clearing the backStack and start fresh
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
                startActivity(i);
            }
        });
    }

    /** Determines if the dealer should hit or stand and if he
     * hits, the card added to the hand is displayed
     * @param dealer the hand of the dealer
     */
    public void dealersTurn(Hand dealer)
    {
        int num = 16;
        while(dealer.getHandPoints() <= num )
        {
            game.hit();
            ArrayList<Card> dCards = dealer.getCards();

            if(dealer.getNumCards() == 3)
            {
                ImageView dc3 = (ImageView) findViewById(R.id.dealerC3);
                dc3.setImageResource(findCardImg(dCards.get(2)));
            }
            else if(dealer.getNumCards() == 4)
            {
                ImageView dc4 = (ImageView) findViewById(R.id.dealerC4);
                dc4.setImageResource(findCardImg(dCards.get(3)));
            }
            else
            {
                ImageView dc5 = (ImageView) findViewById(R.id.dealerC5);
                dc5.setImageResource(findCardImg(dCards.get(4)));
            }

            TextView playerPoints = (TextView) findViewById(R.id.dealerPointsTextView);
            playerPoints.setText(dealer.getHandPoints() + "");
            num++;
        }

        String result = game.scoreGame();
        TextView winner = (TextView) findViewById(R.id.winnerTextView);
        winner.setText(result);
        Button hit = (Button) findViewById(R.id.hitButton);
        hit.setOnClickListener(null);
        Button stand = (Button) findViewById(R.id.standButton);
        stand.setOnClickListener(null);
    }

    /** Gets the image associated with the card
     * @param card the card whose image we are finding
     * @return an int that represent the image of the card
     */
    public int findCardImg(Card card)
    {

        if(card.getSuit() == "clubs" && card.getValue() == "ace")
            return R.drawable.ace_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "two")
           return R.drawable.two_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "three")
            return R.drawable.three_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "four")
            return R.drawable.four_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "five")
            return R.drawable.five_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "six")
            return R.drawable.six_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "seven")
            return R.drawable.seven_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "eight")
            return R.drawable.eight_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "nine")
            return R.drawable.nine_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "ten")
            return R.drawable.ten_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "jack")
            return R.drawable.jack_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "queen")
            return R.drawable.queen_of_clubs;
        else if(card.getSuit() == "clubs" && card.getValue() == "king")
            return R.drawable.king_of_clubs;
        else if(card.getSuit() == "diamonds" && card.getValue() == "ace")
            return R.drawable.ace_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "two")
            return R.drawable.two_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "three")
            return R.drawable.three_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "four")
            return R.drawable.four_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "five")
            return R.drawable.five_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "six")
            return R.drawable.six_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "seven")
            return R.drawable.seven_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "eight")
            return R.drawable.eight_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "nine")
            return R.drawable.nine_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "ten")
            return R.drawable.ten_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "jack")
            return R.drawable.jack_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "queen")
            return R.drawable.queen_of_diamonds;
        else if(card.getSuit() == "diamonds" && card.getValue() == "king")
            return R.drawable.king_of_diamonds;
        else if(card.getSuit() == "hearts" && card.getValue() == "ace")
            return R.drawable.ace_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "two")
            return R.drawable.two_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "three")
            return R.drawable.three_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "four")
            return R.drawable.four_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "five")
            return R.drawable.five_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "six")
            return R.drawable.six_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "seven")
            return R.drawable.seven_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "eight")
            return R.drawable.eight_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "nine")
            return R.drawable.nine_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "ten")
            return R.drawable.ten_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "jack")
            return R.drawable.jack_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "queen")
            return R.drawable.queen_of_hearts;
        else if(card.getSuit() == "hearts" && card.getValue() == "king")
            return R.drawable.king_of_hearts;
        else if(card.getSuit() == "spades" && card.getValue() == "ace")
            return R.drawable.ace_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "two")
            return R.drawable.two_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "three")
            return R.drawable.three_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "four")
            return R.drawable.four_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "five")
            return R.drawable.five_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "six")
            return R.drawable.six_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "seven")
            return R.drawable.seven_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "eight")
            return R.drawable.eight_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "nine")
            return R.drawable.nine_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "ten")
            return R.drawable.ten_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "jack")
            return R.drawable.jack_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "queen")
            return R.drawable.queen_of_spades;
        else if(card.getSuit() == "spades" && card.getValue() == "king")
            return R.drawable.king_of_spades;
        else
            return 0;
    }


}
