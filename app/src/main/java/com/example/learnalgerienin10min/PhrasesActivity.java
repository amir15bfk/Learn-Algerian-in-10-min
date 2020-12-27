package com.example.learnalgerienin10min;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener  onCompletion =new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words=new ArrayList<Word>();
        Collections.addAll(words, new Word("Where are you going?","win rak rah",R.raw.phrases_1),
                new Word("What is your name?","wasmk",R.raw.phrases_2),
                new Word( "My name is...","wasmni",R.raw.phrases_3),
                new Word("How are you feeling?","kifah rak labas",R.raw.phrases_4),
                new Word("I’m feeling good.","hmdlh",R.raw.phrases_5),
                new Word("Are you coming?","rak jay",R.raw.phrases_6),
                new Word("Yes, I’m coming.","ih,rani jay",R.raw.phrases_7),
                new Word("i'm coming","rani jay",R.raw.phrases_8),
                new Word("Let’s go.","aya rohna",R.raw.phrases_9),
                new Word( "Come here.","arwah hna",R.raw.phrases_10));

        WordAdapterWithoutImage itemsAdapter = new WordAdapterWithoutImage(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Word word = words.get(position);
                Log.v("PhrasesActivity", "Current word: " + word);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.get(position).getSoundID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletion);
            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}