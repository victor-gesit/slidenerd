package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.scorekeeper.R;

public class MainActivity extends AppCompatActivity {
    int goalTeamA = 0,
            yellowCardTeamA = 0,
            redCardTeamA = 0,

            goalTeamB = 0,
            redCardTeamB = 0,
            yellowCardTeamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA() {
        TextView goalView = (TextView) findViewById(R.id.team_a_score);
        TextView yellowCardView = (TextView) findViewById(R.id.team_a_yellow_cards);
        TextView redCardView = (TextView) findViewById(R.id.team_a_red_cards);

        goalView.setText(String.valueOf(goalTeamA));
        yellowCardView.setText(String.valueOf(yellowCardTeamA));
        redCardView.setText(String.valueOf(redCardTeamA));
    }
    /**
     * Goal for team A
     */
    public  void goalForTeamA(View view){
        goalTeamA = goalTeamA + 1;
        displayForTeamA();
    }

    /**
     * Yellow card for Team A
     */
    public void yellowCardForTeamA(View view){
        yellowCardTeamA = yellowCardTeamA + 1;
        displayForTeamA();
    }

    /**
     * Red card for Team A
     */
    public void redCardForTeamA(View view){
        redCardTeamA = redCardTeamA + 1;
        displayForTeamA();
    }
    // Team B


    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB() {
        TextView goalView = (TextView) findViewById(R.id.team_b_score);
        TextView yellowCardView = (TextView) findViewById(R.id.team_b_yellow_cards);
        TextView redCardView = (TextView) findViewById(R.id.team_b_red_cards);

        goalView.setText(String.valueOf(goalTeamB));
        yellowCardView.setText(String.valueOf(yellowCardTeamB));
        redCardView.setText(String.valueOf(redCardTeamB));
    }

    /**
     * Goal for Team B
     */
    public void goalForTeamB(View view){
        goalTeamB = goalTeamB + 1;
        displayForTeamB();
    }

    /**
     * Yellow card for Team B
     */
    public void yellowCardForTeamB(View view){
        yellowCardTeamB = yellowCardTeamB + 1;
        displayForTeamB();
    }

    /**
     * Red card for Team B
     */
    public void redCardForTeamB(View view){
        redCardTeamB = redCardTeamB + 1;
        displayForTeamB();
    }
    public void reset(View view){
        goalTeamA = 0;
        yellowCardTeamA = 0;
        redCardTeamA = 0;
        goalTeamB = 0;
        yellowCardTeamB = 0;
        redCardTeamB = 0;

        displayForTeamA();
        displayForTeamB();
    }
}
