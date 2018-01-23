package com.example.android.mysmarttenniscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreGameA = 0;
    int scoreGameB = 0;
    int gameScoreB = 0;
    int gameScoreA = 0;
    int setScoreA = 0;
    int setScoreB = 0;
    int tbScoreA = 0;
    int tbScoreB = 0;
    String advDisplay = "AD";
    String messageS = "SERVE";
    String messageTb = "TIE BREAK";
    String messageD = "DEUCE";
    String messageEndWin = "WIN!";
    String messageEndLoose = ":-(";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    /**
     * Switch the RadioButtons to select type of game - Regural or Grand Slam
     */

    public void switch_game(View v) {
        RadioButton rb3 = (RadioButton) findViewById(R.id.radio_regular);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radio_slam);

        //is the current radio button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch (v.getId()) {

            case R.id.radio_regular:
                if (checked)
                    rb4.setChecked(false);
                break;

            case R.id.radio_slam:
                if (checked)
                    rb3.setChecked(false);
                break;
        }
    }

    /**
     * Switch the RadioButtons to select wchich player is serving
     */

    public void switch_serve(View v) {
        //require to import the RadioButton class
        RadioButton rb1 = (RadioButton) findViewById(R.id.radio_serve_A);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radio_serve_B);

        //is the current radio button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch (v.getId()) {

            case R.id.radio_serve_A:
                if (checked)
                    rb2.setChecked(false);
                break;

            case R.id.radio_serve_B:
                if (checked)
                    rb1.setChecked(false);
                break;
        }
    }

    /**
     * Set 15 point for player A
     */

    public void Set15A(View v) {
        final EditText player_1 = (EditText) findViewById(R.id.name_of_player_1);
        player_1.setEnabled(false);
        final EditText player_2 = (EditText) findViewById(R.id.name_of_player_2);
        player_2.setEnabled(false);

        scoreGameA = 15;
        displayForTeamA(scoreGameA);
        displayServeA(messageS);
        displayServeB(messageS);
    }

    /**
     * Set 30 points for player A
     */

    public void Set30A(View v) {
        scoreGameA = 30;
        displayForTeamA(scoreGameA);
        displayServeA(messageS);
        displayServeB(messageS);
    }

    /**
     * Set 40 point for player A / Set DUCE message when score is 40/40
     */

    public void Set40A(View v) {
        scoreGameA = 40;
        displayForTeamA(scoreGameA);
        if (scoreGameA == scoreGameB) {
            displayDeuceA(messageD);
            displayDeuceB(messageD);
        }
    }

    /**
     * Set Advntage status for player A / Describe conditions for Advantage status
     */

    public void SetAdvA(View v) {
        TextView adA = (TextView) findViewById(R.id.team_b_score);
        String advantage = adA.getText().toString();

        if (scoreGameA == 40) {
            if (scoreGameA == scoreGameB) {
                if (!advantage.equals("AD")) {
                    displayAdv(advDisplay);
                    displayServeA(messageS);
                    displayServeB(messageS);

                } else {
                    Toast.makeText(MainActivity.this, "Must be DUCE first", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Must be DUCE first", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Must be DUCE first", Toast.LENGTH_SHORT).show();
        }
    }


    //TEAM B Score//

    /**
     * Set 15 point for player B
     */

    public void Set15B(View v) {
        final EditText player_1 = (EditText) findViewById(R.id.name_of_player_1);
        player_1.setEnabled(false);
        final EditText player_2 = (EditText) findViewById(R.id.name_of_player_2);
        player_2.setEnabled(false);

        scoreGameB = 15;
        displayForTeamB(scoreGameB);
        displayServeA(messageS);
        displayServeB(messageS);
    }

    /**
     * Set 30 point for player B
     */

    public void Set30B(View v) {
        scoreGameB = 30;
        displayForTeamB(scoreGameB);
        displayServeA(messageS);
        displayServeB(messageS);
    }

    /**
     * Set 40 point for player B
     */

    public void Set40B(View v) {
        scoreGameB = 40;
        displayForTeamB(scoreGameB);
        if (scoreGameA == scoreGameB) {
            displayDeuceA(messageD);
            displayDeuceB(messageD);
        }
    }

    /**
     * Set Advntage status for player A / Describe conditions for Advantage status
     */

    public void SetAdvB(View v) {
        TextView adB = (TextView) findViewById(R.id.team_a_score);
        String advantageB = adB.getText().toString();

        if (scoreGameA == 40) {
            if (scoreGameA == scoreGameB) {
                if (!advantageB.equals("AD")) {
                    displayAdvB(advDisplay);
                    displayServeA(messageS);
                    displayServeB(messageS);

                } else {
                    Toast.makeText(MainActivity.this, "Must be DUCE first", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Must be DUCE first", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Must be DUCE first", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set GAME point for player A / Describe conditions for end the GAME
     */


    public void winGameA(View v) {
        TextView adA = (TextView) findViewById(R.id.team_a_score);
        String advantageA = adA.getText().toString();


        if (gameScoreA <= 6) {
            if (scoreGameA != scoreGameB) {
                if (scoreGameA == 40) {
                    gameScoreA = gameScoreA + 1;
                    displayGemTeamA(gameScoreA);
                    scoreGameA = 0;
                    scoreGameB = 0;
                    displayForTeamA(scoreGameA);
                    displayForTeamB(scoreGameB);
                } else {
                    Toast.makeText(MainActivity.this, "Score is to LOW", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Score shouldn't be EQUAL", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Game points are TO HIGH", Toast.LENGTH_SHORT).show();
        }

        if (advantageA.equals("AD")) {
            if (gameScoreA <= 6) {
                gameScoreA = gameScoreA + 1;
                displayGemTeamA(gameScoreA);
                scoreGameA = 0;
                scoreGameB = 0;
                displayForTeamA(scoreGameA);
                displayForTeamB(scoreGameB);
            } else {
                Toast.makeText(MainActivity.this, "Game points are TO HIGH", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Set GAME point for player B / Describe conditions for end the GAME
     */

    public void winGameB(View v) {
        TextView adB = (TextView) findViewById(R.id.team_b_score);
        String advantageB = adB.getText().toString();


        if (gameScoreB <= 6) {
            if (scoreGameA != scoreGameB) {
                if (scoreGameB == 40) {
                    gameScoreB = gameScoreB + 1;
                    displayGemTeamB(gameScoreB);
                    scoreGameA = 0;
                    scoreGameB = 0;
                    displayForTeamA(scoreGameA);
                    displayForTeamB(scoreGameB);
                } else {
                    Toast.makeText(MainActivity.this, "Score is to LOW", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Score shouldn't be EQUAL", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Game points are TO HIGH", Toast.LENGTH_SHORT).show();
        }

        if (advantageB.equals("AD")) {
            if (gameScoreB <= 6) {
                gameScoreA = gameScoreA + 1;
                displayGemTeamB(gameScoreB);
                scoreGameA = 0;
                scoreGameB = 0;
                displayForTeamA(scoreGameA);
                displayForTeamB(scoreGameB);
            } else {
                Toast.makeText(MainActivity.this, "Game points are TO HIGH", Toast.LENGTH_SHORT).show();
            }
        }
    }


    /**
     * Set SET point for player A / Describe conditions for end the SET / Check what type of game user choose
     */

    public void winSet(View v) {
        if (gameScoreA >= 6) {
            setScoreA = setScoreA + 1;
            displaySetTeamA(setScoreA);
            scoreGameA = 0;
            displayForTeamA(scoreGameA);
            gameScoreA = 0;
            displayGemTeamA(gameScoreA);
            tbScoreA = 0;
            scoreGameB = 0;
            displayForTeamB(scoreGameB);
            gameScoreB = 0;
            displayGemTeamB(gameScoreB);
            tbScoreB = 0;
            displayServeA(messageS);
            displayServeB(messageS);
        } else {
            Toast.makeText(MainActivity.this, "Score is TO LOW", Toast.LENGTH_SHORT).show();
        }


//require to import the RadioButton class
        RadioButton rb_RG = (RadioButton) findViewById(R.id.radio_regular);
        RadioButton rb_GS = (RadioButton) findViewById(R.id.radio_slam);

        //is the current radio button now checked?

        if (rb_RG.isChecked()) {
            if (setScoreA == 2) {
                displayMessageEndLostB(messageEndLoose);
                displayMessageEndWinA(messageEndWin);
                Button btnB = (Button) findViewById(R.id.WinSetButtonB);
                btnB.setEnabled(false);
                Button btnA = (Button) findViewById(R.id.WinSetButtonA);
                btnA.setEnabled(false);

            }
        }


        if (rb_GS.isChecked()) {
            if (setScoreA == 3) {
                displayMessageEndLostB(messageEndLoose);
                displayMessageEndWinA(messageEndWin);
                Button btnB = (Button) findViewById(R.id.WinSetButtonB);
                btnB.setEnabled(false);
                Button btnA = (Button) findViewById(R.id.WinSetButtonA);
                btnA.setEnabled(false);

            }
        }
    }

    /**
     * Set SET point for player B / Describe conditions for end the SET / Check what type of game user choose
     */

    public void winSetB(View view) {
        if (gameScoreB >= 6) {
            setScoreB = setScoreB + 1;
            displaySetTeamB(setScoreB);
            scoreGameA = 0;
            displayForTeamA(scoreGameA);
            gameScoreA = 0;
            displayGemTeamA(gameScoreA);
            tbScoreA = 0;
            scoreGameB = 0;
            displayForTeamB(scoreGameB);
            gameScoreB = 0;
            displayGemTeamB(gameScoreB);
            tbScoreB = 0;
            displayServeA(messageS);
            displayServeB(messageS);
        } else {
            Toast.makeText(MainActivity.this, "Score is TO LOW", Toast.LENGTH_SHORT).show();
        }


//require to import the RadioButton class
        RadioButton rb_RG = (RadioButton) findViewById(R.id.radio_regular);
        RadioButton rb_GS = (RadioButton) findViewById(R.id.radio_slam);

        //is the current radio button now checked?

        if (rb_RG.isChecked()) {
            if (setScoreB == 2) {
                displayMessageEndWinA(messageEndLoose);
                displayMessageEndLostB(messageEndWin);
                Button btnB = (Button) findViewById(R.id.WinSetButtonB);
                btnB.setEnabled(false);
                Button btnA = (Button) findViewById(R.id.WinSetButtonA);
                btnA.setEnabled(false);

            }
        }


        if (rb_GS.isChecked()) {
            if (setScoreB == 3) {
                displayMessageEndWinA(messageEndLoose);
                displayMessageEndLostB(messageEndWin);
                Button btnB = (Button) findViewById(R.id.WinSetButtonB);
                btnB.setEnabled(false);
                Button btnA = (Button) findViewById(R.id.WinSetButtonA);
                btnA.setEnabled(false);

            }
        }
    }


    /**
     * Set TIE BREAK point for player A / Describe conditions for TIE BREAK / Change TIE BREAK message
     */

    public void TBpointA(View view) {
        if (gameScoreA >=6) {
            if (gameScoreA == gameScoreB) {
                tbScoreA = tbScoreA + 1;
                displayForTeamA(tbScoreA);
                displayMessageTbA(messageTb);
                displayMessageTbB(messageTb);
            } else {
                Toast.makeText(MainActivity.this, "GAME SCORE must be EQUAL", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Game  SCORE must be at least 6", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set TIE BREAK point for player B / Describe conditions for TIE BREAK / Change TIE BREAK message
     */

    public void TBpointB(View view) {
        if (gameScoreB >=6) {
            if (gameScoreB == gameScoreA) {
                tbScoreB = tbScoreB + 1;
                displayForTeamB(tbScoreB);
                displayMessageTbA(messageTb);
                displayMessageTbB(messageTb);
            } else {
                Toast.makeText(MainActivity.this, "GAME SCORE must be EQUAL", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Game  SCORE must be at least 6", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Resets all values and status to 0
     */

    public void reset(View v) {
        scoreGameA = 0;
        displayForTeamA(scoreGameA);
        gameScoreA = 0;
        displayGemTeamA(gameScoreA);
        setScoreA = 0;
        displaySetTeamA(setScoreA);
        tbScoreA = 0;
        scoreGameB = 0;
        displayForTeamB(scoreGameB);
        gameScoreB = 0;
        displayGemTeamB(gameScoreB);
        setScoreB = 0;
        displaySetTeamB(setScoreB);
        tbScoreB = 0;
        Button btnB = (Button) findViewById(R.id.WinSetButtonB);
        btnB.setEnabled(true);
        Button btnA = (Button) findViewById(R.id.WinSetButtonA);
        btnA.setEnabled(true);
        final EditText player_1 = (EditText) findViewById(R.id.name_of_player_1);
        player_1.setEnabled(true);
        final EditText player_2 = (EditText) findViewById(R.id.name_of_player_2);
        player_2.setEnabled(true);
        displayServeA(messageS);
        displayServeB(messageS);

    }

    /**
     * Display methods for all views
     */

    public void displayMessageEndWinA(String WinA) {
        TextView setWinA = (TextView) findViewById(R.id.team_a_score);
        setWinA.setText(WinA);
    }

    public void displayMessageEndLostB(String end_B) {
        TextView endViewB = (TextView) findViewById(R.id.team_b_score);
        endViewB.setText(end_B);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayDeuceA(String DEUCE) {
        TextView adView = (TextView) findViewById(R.id.message_A);
        adView.setText(DEUCE);
    }

    public void displayDeuceB(String DEUCE) {
        TextView adView = (TextView) findViewById(R.id.message_B);
        adView.setText(DEUCE);
    }

    public void displayAdv(String advantage) {
        TextView adView = (TextView) findViewById(R.id.team_a_score);
        adView.setText(advantage);
    }

    public void displayMessageTbA(String messageTieBreak) {
        TextView adView = (TextView) findViewById(R.id.message_A);
        adView.setText(messageTieBreak);
    }

    public void displayServeA(String messageSerwe) {
        TextView adView = (TextView) findViewById(R.id.message_A);
        adView.setText(messageSerwe);
    }

    public void displayServeB(String messageSerwe) {
        TextView adView = (TextView) findViewById(R.id.message_B);
        adView.setText(messageSerwe);
    }

    public void displayMessageTbB(String messageTieBreak) {
        TextView adView = (TextView) findViewById(R.id.message_B);
        adView.setText(messageTieBreak);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayAdvB(String advantage) {
        TextView adView = (TextView) findViewById(R.id.team_b_score);
        adView.setText(advantage);
    }

    public void displayGemTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.gem_score_display_A);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGemTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.gem_score_display_B);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySetTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_score_display_A);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySetTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_score_display_B);
        scoreView.setText(String.valueOf(score));
    }
}





