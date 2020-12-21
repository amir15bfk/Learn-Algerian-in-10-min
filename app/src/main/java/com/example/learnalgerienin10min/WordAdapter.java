package com.example.learnalgerienin10min;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int back_ground_color;

    public WordAdapter(Activity context, ArrayList<Word> words,int color) {
        super(context, 0, words);
        back_ground_color=color;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        Word currentWord = getItem(position);
        /*
        if (currentWord.getImage()!=0){
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }



        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        iconView.setImageResource(currentWord.getImage());}
        else{
            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item_without_imege, parent, false);
            }
        }*/

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()){
        iconView.setImageResource(currentWord.getImage());}
        else {iconView.setVisibility(View.GONE);}
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView engTextView = (TextView) listItemView.findViewById(R.id.inEnglish);
        engTextView.setText(currentWord.getEnWord());

        TextView algTextView = (TextView) listItemView.findViewById(R.id.inAlgerian);

        algTextView.setText(currentWord.getAlgWord());
        LinearLayout linearLayout=(LinearLayout) listItemView.findViewById(R.id.list_linear_layout);
        int color = ContextCompat.getColor(getContext(), back_ground_color);
        linearLayout.setBackgroundColor(color);


        return listItemView;
}
}

