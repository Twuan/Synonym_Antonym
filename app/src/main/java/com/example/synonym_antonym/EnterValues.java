package com.example.synonym_antonym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterValues extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_values);
    }

    public void buttons(View v) {
        if (v.getId() == R.id.submitButton) {
            EditText word1TextField = (EditText)findViewById(R.id.word1);
            EditText word2TextField = (EditText)findViewById(R.id.word2);

            String word1 = word1TextField.getText().toString();
            String word2 = word2TextField.getText().toString();

            WordPair wordPair = new WordPair();
            wordPair.setWord1(word1);
            wordPair.setWord2(word2);

            helper.insert(wordPair);

            Intent i = new Intent(EnterValues.this, MainActivity.class);
            startActivity(i);
        }
    }
}
