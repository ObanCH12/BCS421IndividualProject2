package com.example.individualproject21;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    EditText birthDate;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String Email = "NAME_KEY";
    public static final String Password = "EMAIL_KEY";
    public static final String FirstName = "FNAME_KEY";
    public static final String LastName = "LNAME_KEY";
    public static final String BirthDate = "BDATE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sharedpreferences = getSharedPreferences(MYPREF,
                Context.MODE_PRIVATE);
    }
    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public void Register(View view) {

        email = (EditText) findViewById(R.id.EmailEdit);
        firstName = (EditText) findViewById(R.id.FirsNameEdit);
        lastName = (EditText) findViewById(R.id.LastNameEdit);
        birthDate = (EditText) findViewById(R.id.BirthDateEdit);
        password = (EditText) findViewById(R.id.PasswordEdit);
        String e = email.getText().toString();
        String p = password.getText().toString();
        String f = firstName.getText().toString();
        String l = lastName.getText().toString();
        String b = birthDate.getText().toString();
        boolean t = isValid(e);
        if(e.isEmpty() || e.length()<0 || p.isEmpty() || p.length()<0 || f.isEmpty() || f.length()<0
                || l.isEmpty() || l.length()<0 || b.isEmpty() || b.length()<0)
        {
            Toast t1=Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_LONG);
            t1.show();
        }
         if (f.length()<2 || f.length()>30) {
            Toast toast = Toast.makeText(Register.this, "Invalid name", Toast.LENGTH_LONG);
            toast.show();
        }
        else if (t == false){
            Toast toast = Toast.makeText(Register.this, "Invalid email", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(Email, e);
            editor.putString(Password, p);
            editor.putString(FirstName, f);
            editor.putString(LastName, l);
            editor.putString(BirthDate, b);
            editor.apply();
             Toast toast = Toast.makeText(Register.this, "Registration Complete", Toast.LENGTH_LONG);
             toast.show();
            Intent Back = new Intent(getBaseContext(), com.example.individualproject21.Login.class);
            startActivity(Back);
        }
    }
}