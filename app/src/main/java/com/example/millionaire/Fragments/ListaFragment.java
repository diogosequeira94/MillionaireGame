package com.example.millionaire.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.millionaire.Lists.TopicList;
import com.example.millionaire.R;
import com.example.millionaire.RecyclerViews.RecyclerItemClickListener;
import com.example.millionaire.RecyclerViews.RecyclerViewAdapter;
import com.example.millionaire.RecyclerViews.TopicItem;

import java.util.ArrayList;


public class ListaFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        final TopicList topicList = new TopicList();

        final ArrayList<TopicItem> arrayOfpeople = topicList.giveArray();
        recyclerView = view.findViewById(R.id.mrecyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerViewAdapter(arrayOfpeople);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                TopicItem topicItem = topicList.getDisplayPeople().get(position);

                                FragmentTransaction fragmentTransaction5 = getActivity().getSupportFragmentManager().beginTransaction();
                                fragmentTransaction5.addToBackStack(null);
                                Concept item = new Concept();
                                Bundle bundle = new Bundle();
                                bundle.putString("Titulo", topicItem.getName());
                                //  saco.putString("Descricao", exampleItem.getmDescricao());
                                item.setArguments(bundle);
                                fragmentTransaction5.replace(R.id.main_container, item);
                                fragmentTransaction5.commit();


                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );









        return view;
    }

/*
    public void initComponents(){

        peopleList = new PeopleList();
        recyclerView = recyclerView.findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerViewAdapter(peopleList.giveArray());
        recyclerView.setAdapter(adapter);
    }
*/
    //OnCli


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
