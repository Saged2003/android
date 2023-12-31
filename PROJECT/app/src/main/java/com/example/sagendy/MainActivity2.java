package com.example.sagendy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        textView1=findViewById(R.id.textView33);
        String name;
        name =getIntent().getStringExtra("aba");
        textView1.setText(name);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String savedTextViewContent = sharedPreferences.getString("textViewContent", "");
        textView1.setText(savedTextViewContent);
    }
}