package com.example.millionaire.Lists;

import com.example.millionaire.R;
import com.example.millionaire.RecyclerViews.TopicItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TopicList {

    private ArrayList<TopicItem> displayTopics = new ArrayList<>();


    private void populateArray(){

        displayTopics.add(new TopicItem(R.drawable.ic_launcher_foreground,"What is OOP?"));
        displayTopics.add(new TopicItem(R.drawable.ic_launcher_foreground,"What are Threads?"));
        displayTopics.add(new TopicItem(R.drawable.ic_launcher_foreground,"Introduction to Abstract Classes"));
        displayTopics.add(new TopicItem(R.drawable.ic_launcher_foreground,"Polymorphism"));
        displayTopics.add(new TopicItem(R.drawable.ic_launcher_foreground,"Spring Framework"));



        Collections.sort(displayTopics, new Comparator<TopicItem>() {
            @Override
            public int compare(TopicItem topicItem, TopicItem topicItem2) {
                return topicItem.getName().compareTo(topicItem2.getName());
            }
        });


    }

    public ArrayList<TopicItem> giveArray(){

        populateArray();

        return displayTopics;
    }

    public ArrayList<TopicItem> getDisplayPeople() {
        return displayTopics;
    }
}