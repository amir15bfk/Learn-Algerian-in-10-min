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

public class ColorsActivity extends AppCompatActivity {
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
        Collections.addAll(words, new Word("red","7mer",R.drawable.color_red,R.raw.color_red),
                new Word("green","5dar",R.drawable.color_green,R.raw.color_green),
                new Word("brown","boni",R.drawable.color_brown,R.raw.color_brown),
                new Word("gray","gris",R.drawable.color_gray,R.raw.color_gray),
                new Word("black","k7al",R.drawable.color_black,R.raw.color_black),
                new Word("white","byed",R.drawable.color_white,R.raw.color_white),
                new Word("yellow","sfar",R.drawable.color_mustard_yellow,R.raw.color_yellow),
                new Word( "blue","zra9",R.drawable.color_blue,R.raw.color_blue));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, words.get(position).getSoundID());
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