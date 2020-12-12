package com.example.learnalgerienin10min;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words=new ArrayList<Word>();
        Collections.addAll(words, new Word []{ new Word("my father","baba"),
                new Word("my mother","yema"),
                new Word( "my son","wlidi"),
                new Word("my daughter","bnti"),
                new Word("my older brother","5oya el kbir"),
                new Word("my younger brother","5oya asrir"),
                new Word("my older sister","5ti el 5bira"),
                new Word("my younger sister","5ti asrira"),
                new Word( "my grandmother","jdati"),
                new Word("my grandfather","jdi")});

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}