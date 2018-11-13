package com.example.samplestickerapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.samplestickerapp.Holders.loveViewHolder;
import com.example.samplestickerapp.Modals.loveModal;
import com.example.samplestickerapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoveFragment extends Fragment {

    public String TAG ="Love fragment";
    Context context;
    RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;


    public LoveFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("section1");
        databaseReference.keepSynced(true);
        context=getContext();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_love, container, false);
        recyclerView = view.findViewById(R.id.loveFragmentRecyclerView);
        populateRecyclerAdapter();
        return view;
    }


    private void populateRecyclerAdapter() {
        FirebaseRecyclerAdapter<loveModal,loveViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<loveModal, loveViewHolder>
                (loveModal.class,R.layout.stickers_row,loveViewHolder.class,databaseReference) {
            @Override
            protected void populateViewHolder(loveViewHolder viewHolder, loveModal model, int position) {
                viewHolder.setImage(getContext(),model.getUrl());
            }
            @Override
            public void onBindViewHolder(loveViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }


}
