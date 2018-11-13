package com.example.samplestickerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.samplestickerapp.Holders.MiddleActivityViewHolder;
import com.example.samplestickerapp.Modals.MiddleActivityModal;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MiddleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    public String grandparent , parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);

        Bundle bundle = getIntent().getExtras();
        grandparent= bundle.getString("grandparent");
        parent= bundle.getString("parent");

        recyclerView = findViewById(R.id.middleActivityRecyclerView);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child(grandparent).child(parent).child("sub");
        databaseReference.keepSynced(true);
        populateRecyclerAdapter1();

    }
    private void populateRecyclerAdapter1() {
        FirebaseRecyclerAdapter<MiddleActivityModal,MiddleActivityViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<MiddleActivityModal, MiddleActivityViewHolder>
                (MiddleActivityModal.class,R.layout.middle_activitystickers_row,MiddleActivityViewHolder.class,databaseReference) {
            @Override
            protected void populateViewHolder(MiddleActivityViewHolder viewHolder, MiddleActivityModal model, int position) {
                viewHolder.setImage(getApplicationContext(),model.getUrl());
                viewHolder.setImgsrc(model.getUrl());

            }

            @Override
            public void onBindViewHolder(MiddleActivityViewHolder viewHolder, int position) {
                super.onBindViewHolder(viewHolder, position);

                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(),StickerImagesToWhatsapp.class);
                        intent.putExtra("imgsrc",viewHolder.getImgsrc());
                        startActivity(intent);
                    }
                });

            }
        };

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
}
