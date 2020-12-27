package com.example.learnalgerienin10min;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        releaseMediaPlayer();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause playback
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    }  else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        mediaPlayer.start();
                    }
                }
            };
    private MediaPlayer.OnCompletionListener  onCompletion =new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words=new ArrayList<Word>();
        Collections.addAll(words, new Word("One","wa7d",R.drawable.one,R.raw.number_one),
                new Word("Two","zoj",R.drawable.two,R.raw.number_two),
                new Word( "Three","tlata",R.drawable.three,R.raw.number_three),
                new Word("Four","rb3a",R.drawable.four,R.raw.number_four),
                new Word("Five","5amsa",R.drawable.five,R.raw.number_five),
                new Word("Six","sta",R.drawable.six,R.raw.number_six),
                new Word("Seven","sb3a",R.drawable.seven,R.raw.number_seven),
                new Word("Eight","tmnya",R.drawable.eight,R.raw.number_eight),
                new Word( "Nine","ts3a",R.drawable.nine,R.raw.number_nine),
                new Word("Ten","3achra",R.drawable.ten,R.raw.number_ten));

        //for (int i= 0;i<10;i++) Log.v("Numbers activity","word[0] is :"+words.get(i));
        /*LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        //TextView [] wordsViews= new TextView[10];
        //ArrayAdapter<String> itemAdapt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,words);
        for (int i = 0;i<words.size();i++){
            TextView wordsViews = new TextView(this);
            wordsViews.setText(words.get(i));
            rootView.addView(wordsViews);

        }*/
        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Word word = words.get(position);
                Log.v("NumbersActivity", "Current word: " + word);
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback

                    mediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(position).getSoundID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(onCompletion);
                }
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}