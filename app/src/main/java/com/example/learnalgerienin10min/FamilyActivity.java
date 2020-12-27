package com.example.learnalgerienin10min;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static android.widget.Toast.LENGTH_LONG;

public class FamilyActivity extends AppCompatActivity {
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
        Collections.addAll(words, new Word("my father","baba",R.drawable.family_father,R.raw.family_father),
                new Word("my mother","yema",R.drawable.family_mother,R.raw.family_mother),
                new Word( "my son","wlidi",R.drawable.family_son,R.raw.family_son),
                new Word("my daughter","bnti",R.drawable.family_daughter,R.raw.family_daughter),
                new Word("my older brother","5oya",R.drawable.family_older_brother,R.raw.family_brother),
                new Word("my younger sister","5ti",R.drawable.family_younger_sister,R.raw.family_sister),
                new Word( "my grandmother","jdati",R.drawable.family_grandmother,R.raw.family_grandmother),
                new Word("my grandfather","jdi",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_family);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view,int position, long id){
            releaseMediaPlayer();
            mediaPlayer = MediaPlayer.create(FamilyActivity.this, words.get(position).getSoundID());
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(onCompletion);
        }
        });
        /**
         * Clean up the media player by releasing its resources.
         */

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