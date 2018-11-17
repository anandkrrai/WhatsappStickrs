package com.teamleaf.samplestickerapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.teamleaf.samplestickerapp.Holders.loveViewHolder;
import com.teamleaf.samplestickerapp.MiddleActivity;
import com.teamleaf.samplestickerapp.Modals.loveModal;
import com.teamleaf.samplestickerapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoveFragment extends Fragment {

    Context context;
    RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    String grandparent = "section1";

    public LoveFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child(grandparent);
        databaseReference.keepSynced(true);
        context=getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_love, container, false);
        recyclerView = view.findViewById(R.id.loveFragmentRecyclerView);
        populateRecyclerAdapter();
        return view;
    }

    private void populateRecyclerAdapter() {
        FirebaseRecyclerAdapter<loveModal,loveViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter
                <loveModal, loveViewHolder>
                (loveModal.class,R.layout.stickers_row,loveViewHolder.class,databaseReference) {

            @Override
            protected void populateViewHolder(loveViewHolder viewHolder, loveModal model, int position) {
//                Log.d(TAG, "populateViewHolder: imgsrc "+ model.getImgsrc());
//                Log.d(TAG, "populateViewHolder: parent "+ model.getParent());
                viewHolder.setImage(getContext(),model.getImgsrc());
                viewHolder.setParent(model.getParent());
            }

            @Override
            public void onBindViewHolder(loveViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);

                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(getContext(),MiddleActivity.class);
                        intent.putExtra("grandparent",grandparent);
                        intent.putExtra("parent",viewHolder.getParent());
                        startActivity(intent);
                    }
                });


            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
