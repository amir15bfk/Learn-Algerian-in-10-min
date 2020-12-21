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
        Collections.addAll(words, new Word []{ new Word("my father","baba",R.drawable.family_father),
                new Word("my mother","yema",R.drawable.family_mother),
                new Word( "my son","wlidi",R.drawable.family_son),
                new Word("my daughter","bnti",R.drawable.family_daughter),
                new Word("my older brother","5oya el kbir",R.drawable.family_older_brother),
                new Word("my younger brother","5oya asrir",R.drawable.family_younger_brother),
                new Word("my older sister","5ti el 5bira",R.drawable.family_older_sister),
                new Word("my younger sister","5ti asrira",R.drawable.family_younger_sister),
                new Word( "my grandmother","jdati",R.drawable.family_grandmother),
                new Word("my grandfather","jdi",R.drawable.family_grandfather)});

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}