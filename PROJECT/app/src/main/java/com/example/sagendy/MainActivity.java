package com.example.sagendy;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
        private TextView errorTextView;
        Button printButton,history;
        int i = 0;

    private void printError() {
        String errorMessage = "Error" + i + "\n" ;
        System.out.println(errorMessage);
        errorTextView.setText(errorMessage + errorTextView.getText().toString());
        i++;
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String textViewContent = errorTextView.getText().toString();
        editor.putString("textViewContent", textViewContent);
        editor.apply();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorTextView = findViewById(R.id.sagendy);
        printButton = findViewById(R.id.buttonerror);
        history=findViewById(R.id.button2);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                String y=errorTextView.getText().toString();
                intent.putExtra("aba",y);
                startActivity(intent);
            }
        });
        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printError();
            }
        });
    }
}