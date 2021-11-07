package com.example.individualproject21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question4 extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String Score = "Score_Key";
    private RadioGroup Answers;
    private Button btn;
    private CheckBox c1;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        Answers = findViewById(R.id.Answers);
        sharedpreferences = getSharedPreferences(MYPREF,
                Context.MODE_PRIVATE);
        c1 = (CheckBox)findViewById(R.id.checkbox1);
        c2 = (CheckBox)findViewById(R.id.checkbox2);
        c3 = (CheckBox)findViewById(R.id.checkbox3);
        c4 = (CheckBox)findViewById(R.id.checkbox4);
        btn = (Button) findViewById(R.id.SubmitBtn);
        btn.setOnClickListener(this::enableAlert);
    }
    public void enableAlert(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Is this your answer");
        alert.setPositiveButton("Yes", (dialogInterface, i) -> {

            if (c1.isChecked() && c3.isChecked() && !(c2.isChecked()) && !(c4.isChecked())){
                int s = sharedpreferences.getInt(Score, 0);
                s = s + 10;
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt(Score, s);
                editor.apply();
                Toast toast = Toast.makeText(Question4.this, "Correct Answer", Toast.LENGTH_LONG);
                toast.show();
            } else {
                Toast toast = Toast.makeText(Question4.this, "Wrong Answer", Toast.LENGTH_LONG);
                toast.show();
            }
            Intent Q = new Intent(getBaseContext(), Question5.class);
            startActivity(Q);

        });
        alert.setNegativeButton("No", (v, a) -> {
            Toast.makeText(Question4.this, "Please choose an answer",
                    Toast.LENGTH_LONG).show();
        });
        alert.create().show();
    }
}