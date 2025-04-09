package com.example.storingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText enterAgeEditText;
    TextView yourAgeTextView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterAgeEditText = findViewById(R.id.enterAgeEditText);
        yourAgeTextView = findViewById(R.id.yourAgeTextView);
        sharedPreferences = this.getSharedPreferences("com.example.storingdata", Context.MODE_PRIVATE);
        int storedAge = sharedPreferences.getInt("storedAge",0);
        if (storedAge == 0){
            yourAgeTextView.setText("Your Age: ");
        }
        else {
            yourAgeTextView.setText("Your Age: " + storedAge);
        }
    }

    public void saveEnteredAge(View view) {
        if (!enterAgeEditText.getText().toString().isEmpty()){
            int userAge = Integer.parseInt(enterAgeEditText.getText().toString());
            yourAgeTextView.setText("Your age: " + userAge);

            sharedPreferences.edit().putInt("storedAge",userAge).apply();
        }
    }

    public void deleteStoredAge(View view){
        int storedData = sharedPreferences.getInt("storedAge",0);
        if (storedData != 0){
            sharedPreferences.edit().remove("storedAge").apply();
            yourAgeTextView.setText("Your age: ");
        }
    }
}