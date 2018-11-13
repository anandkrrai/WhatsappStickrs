package com.example.samplestickerapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.example.samplestickerapp.ImageAdapter;
import com.example.samplestickerapp.R;
import com.example.samplestickerapp.StickerImagesToWhatsapp;

public class homeFragment extends Fragment {

    public homeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridview =  view.findViewById(R.id.gridviewHome);
        gridview.setAdapter(new ImageAdapter(getContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getContext(), "" + position,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(getContext(), StickerImagesToWhatsapp.class);
                startActivity(intent);
            }
        });

     return view;
    }
}
