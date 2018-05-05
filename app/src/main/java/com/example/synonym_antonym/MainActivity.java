package com.example.synonym_antonym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    DatabaseHelper helper = new DatabaseHelper(this);

    public void buttons(View v) {
        if (v.getId() == R.id.enterValuesButton) {
            Intent i = new Intent(MainActivity.this, EnterValues.class);
            startActivity(i);
        }
        if (v.getId() == R.id.synonymAntonymButton) {
            EditText editText = (EditText) findViewById(R.id.wordToFind);
            String word1 = editText.getText().toString();
            String word2 = helper.searchWords(word1);

            if (word2.equals("not found")) {
                Toast temp = Toast.makeText(this, "Word not found", Toast.LENGTH_SHORT);
                temp.show();
            }
            else {
                Intent j = new Intent(MainActivity.this, FindSynonymAntonym.class);
                j.putExtra("word1", word1);
                j.putExtra("word2", word2);
                startActivity(j);
            }
        }
    }
}
