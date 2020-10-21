package com.example.millionaire.Fragments;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.millionaire.R;

public class Concept extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_concept, container, false);
        TextView name = v.findViewById(R.id.name);
        String textName = getArguments().getString("Titulo");
        name.setText(textName);
        return v;
    }
}
