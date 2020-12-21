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
        Collections.addAll(words, new Word []{ new Word("red","7mer",R.drawable.color_red),
                new Word("green","5dar",R.drawable.color_green),
                new Word("brown","boni",R.drawable.color_brown),
                new Word("gray","gris",R.drawable.color_gray),
                new Word("black","k7al",R.drawable.color_black),
                new Word("white","byed",R.drawable.color_white),
                new Word("yellow","sfar",R.drawable.color_mustard_yellow),
                new Word( "blue","zra9",R.drawable.color_blue)});

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}