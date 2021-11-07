package com.example.individualproject21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameExplanation1 extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String HiScore = "HiScore_Key";
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_explanation1);
        sharedpreferences = getSharedPreferences(MYPREF,
                Context.MODE_PRIVATE);
        txt = (TextView) findViewById(R.id.HIScore);
        int s = sharedpreferences.getInt(HiScore, 0);
        txt.setText(" "+s);

    }

    public void StartGame(View view) {
        Intent S = new Intent(getBaseContext(),Question1.class);
        startActivity(S);
    }
}