package com.example.individualproject21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String Score = "Score_Key";
    public static final String HiScore = "HiScore_Key";

    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        tv1 = (TextView) findViewById(R.id.quizScore);
        tv2 = (TextView) findViewById(R.id.highScore);
        sharedpreferences = getSharedPreferences(MYPREF,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        int q = sharedpreferences.getInt(Score, 0);
        int h = sharedpreferences.getInt(HiScore, 0);
        if (q>h) {
            editor.putInt(HiScore, q);
            editor.apply();
            h = q;
        }
        tv1.setText(" " + q);
        tv2.setText(" " + h);
    }
}