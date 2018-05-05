package com.example.synonym_antonym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FindSynonymAntonym extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_synonym_antonym);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String word1 = intent.getStringExtra("word1");
        String word2 = intent.getStringExtra("word2");

        // Capture the layout's TextView and set the string as its text
        TextView textView1 = findViewById(R.id.word1);
        textView1.setText(word1);

        TextView textView2 = findViewById(R.id.word2);
        textView2.setText(word2);


    }



}
