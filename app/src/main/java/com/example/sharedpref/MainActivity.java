package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText emailEditText;
    private SharedPreferences sharedPreferences;

    public static String appPreference = "mypref";

    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);

        sharedPreferences = getSharedPreferences(appPreference, 0);
        readFromPref(null);


    }

    public void saveToPref(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name, nameEditText.getText().toString());
        editor.putString(Email, emailEditText.getText().toString());
        editor.commit();

    }

    public void readFromPref(View view) {
        if(sharedPreferences.contains(Name)){
            nameEditText.setText(sharedPreferences.getString(Name, ""));
        }
        if(sharedPreferences.contains(Email)){
            emailEditText.setText(sharedPreferences.getString(Email, ""));
        }
    }

    public void clearData(View view) {
        nameEditText.getText().clear();
        emailEditText.getText().clear();
    }
}
