package com.example.learnalgerienin10min;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words=new ArrayList<Word>();
        Collections.addAll(words, new Word []{ new Word("red","7mer"),
                new Word("green","5dar"),
                new Word( "Three","tlata"),
                new Word("brown","boni"),
                new Word("gray","gris"),
                new Word("blak","k7al"),
                new Word("white","byed"),
                new Word("yellow","sfar"),
                new Word( "blue","zra9")});

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}