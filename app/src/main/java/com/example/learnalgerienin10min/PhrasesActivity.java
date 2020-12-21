package com.example.learnalgerienin10min;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words=new ArrayList<Word>();
        Collections.addAll(words, new Word []{ new Word("Where are you going?","win rak rah"),
                new Word("What is your name?","wasmk"),
                new Word( "My name is...","wasmni"),
                new Word("How are you feeling?","kifah rak labas"),
                new Word("I’m feeling good.","hmdlh"),
                new Word("Are you coming?","rak jay"),
                new Word("Yes, I’m coming.","ih,rani jay"),
                new Word("i'm coming","rani jay"),
                new Word("Let’s go.","aya rohna"),
                new Word( "Come here.","arwah hna")});

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}