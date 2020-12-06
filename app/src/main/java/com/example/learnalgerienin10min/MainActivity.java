package com.example.learnalgerienin10min;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        TextView TVColors = (TextView)findViewById(R.id.colors);
        // Register the onClick listener with the implementation above
        TVColors.setOnClickListener(ColorsListener);
        TextView TVFamily = (TextView)findViewById(R.id.family);
        // Register the onClick listener with the implementation above
        TVFamily.setOnClickListener(FamilyListener);
        TextView TVNumbers = (TextView)findViewById(R.id.numbers);
        // Register the onClick listener with the implementation above
        TVNumbers.setOnClickListener(NumberListener);
        TextView TVPhrases = (TextView)findViewById(R.id.phrases);
        // Register the onClick listener with the implementation above
        TVPhrases.setOnClickListener(PhrasesListener);


    }




    private OnClickListener NumberListener = new OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            Toast.makeText(v.getContext(),"open the list of numbers",Toast.LENGTH_SHORT).show();
            Intent i =new Intent(MainActivity.this , NumbersActivity.class);
            startActivity(i);
        }
    };
    private OnClickListener ColorsListener = new OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            Toast.makeText(v.getContext(),"open the list of colors",Toast.LENGTH_SHORT).show();
            Intent i =new Intent(MainActivity.this,ColorsActivity.class);
            startActivity(i);
        }
    };
    private OnClickListener PhrasesListener = new OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            Toast.makeText(v.getContext(),"open the list of Phrases",Toast.LENGTH_SHORT).show();
            Intent i =new Intent(MainActivity.this,PhrasesActivity.class);
            startActivity(i);
        }
    };
    private OnClickListener FamilyListener = new OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            Toast.makeText(v.getContext(),"open the list of family",Toast.LENGTH_SHORT).show();
            Intent i =new Intent(MainActivity.this,FamilyActivity.class);
            startActivity(i);
        }
    };

}