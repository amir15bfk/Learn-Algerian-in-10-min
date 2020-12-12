package com.example.learnalgerienin10min;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words=new ArrayList<Word>();
        Collections.addAll(words, new Word []{ new Word("One","wa7d"),
                new Word("Two","zoj"),
                new Word( "Three","tlata"),
                new Word("Four","rb3a"),
                new Word("Five","5amsa"),
                new Word("Six","sta"),
                new Word("Seven","sb3a"),
                new Word("Eight","tmnya"),
                new Word( "Nine","ts3a"),
                new Word("Ten","3achra")});

        //for (int i= 0;i<10;i++) Log.v("Numbers activity","word[0] is :"+words.get(i));
        /*LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        //TextView [] wordsViews= new TextView[10];
        //ArrayAdapter<String> itemAdapt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,words);
        for (int i = 0;i<words.size();i++){
            TextView wordsViews = new TextView(this);
            wordsViews.setText(words.get(i));
            rootView.addView(wordsViews);

        }*/
        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}