package lanicholas.loyola.edu.blackjack;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

/** A class coltrolling the title screen
 *
 *  @author Lillian Nicholas
 *  @version 1.0 (10/6/18)
 *  @since version 0.0
 */
public class TitleActivity extends AppCompatActivity {

    /** Creates and displays the title screen
     * @param savedInstanceState
     * @Override
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        Button play = (Button) findViewById(R.id.playButton);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(game);
            }
        });
    }
}