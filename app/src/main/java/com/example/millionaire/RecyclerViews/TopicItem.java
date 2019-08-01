package com.example.millionaire.RecyclerViews;

import android.widget.ImageView;

public class TopicItem {

    private int icon;
    private String name;


    public TopicItem(int icon, String name) {

        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

}