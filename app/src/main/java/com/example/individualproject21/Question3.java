package com.example.individualproject21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String Score = "Score_Key";
    private RadioGroup Answers;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        Answers = findViewById(R.id.Answers);
        sharedpreferences = getSharedPreferences(MYPREF,
                Context.MODE_PRIVATE);
        btn = (Button) findViewById(R.id.SubmitBtn);
        btn.setOnClickListener(this::enableAlert);
    }
    public void enableAlert(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Is this your answer");
        alert.setPositiveButton("Yes", (dialogInterface, i) -> {


            int checkedId = Answers.getCheckedRadioButtonId();
            if (checkedId == R.id.Answer1) {
                int s = sharedpreferences.getInt(Score, 0);
                s = s + 10;
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt(Score, s);
                editor.apply();
                Toast toast = Toast.makeText(Question3.this, "Correct Answer", Toast.LENGTH_LONG);
                toast.show();
            } else {
                Toast toast = Toast.makeText(Question3.this, "Wrong Answer", Toast.LENGTH_LONG);
                toast.show();
            }
            Intent Q = new Intent(getBaseContext(), Question4.class);
            startActivity(Q);
        });
        alert.setNegativeButton("No", (v, a) -> {
            Toast.makeText(Question3.this, "Please choose an answer",
                    Toast.LENGTH_LONG).show();
        });
        alert.create().show();
    }
}
