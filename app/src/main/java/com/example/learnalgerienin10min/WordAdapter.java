package com.example.learnalgerienin10min;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();


    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView engTextView = (TextView) listItemView.findViewById(R.id.inEnglish);
        engTextView.setText(currentWord.getEnWord());
        TextView algTextView = (TextView) listItemView.findViewById(R.id.inAlgerian);

        algTextView.setText(currentWord.getAlgWord());

        /*
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        iconView.setImageResource(currentWord.getImageResourceId());*/

        return listItemView;
}
}

