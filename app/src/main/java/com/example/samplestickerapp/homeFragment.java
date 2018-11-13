package com.example.samplestickerapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class homeFragment extends Fragment {

    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridview = (GridView) view.findViewById(R.id.gridviewHome);
        gridview.setAdapter(new ImageAdapter(getContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getContext(), "" + position,
                        Toast.LENGTH_SHORT).show();
//                ShareImage();
                Intent intent = new Intent();
                intent.setClass(getContext(), StickerImagesToWhatsapp.class);
                startActivity(intent);

//                  ShareImage();

//
//                Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.sample_0);
//                Intent share = new Intent(Intent.ACTION_SEND);
//                share.setType("image/jpeg");
//                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//                File f = new File(Environment.getExternalStorageDirectory() + File.separator + "temporary_file.jpg");
//                try {
//                    f.createNewFile();
//                    FileOutputStream fo = new FileOutputStream(f);
//                    fo.write(bytes.toByteArray());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                share.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/temporary_file.jpg"));
//                startActivity(Intent.createChooser(share, "Share Image"));


            }
        });

     return view;
    }

    public void ShareImage(){



//        Uri uri = Uri.parse("android.resource://com.example.samplestickerapp/drawable/"+R.drawable.sample_0);
//        Intent shareIntent = new Intent();
//        shareIntent.setAction(Intent.ACTION_SEND);
//        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
//        shareIntent.putExtra(Intent.EXTRA_TEXT, "sharing myapp");
//        shareIntent.setType("image/*");
//        startActivity(Intent.createChooser(shareIntent, "Share from"));


//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.sample_0);
//        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/LatestShare.jpg";
//        OutputStream out = null;
//        File file=new File(path);
//        try {
//            out = new FileOutputStream(file);
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
//            out.flush();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        path=file.getPath();
//        Uri bmpUri = Uri.parse("file://"+path);
//        Intent shareIntent = new Intent();
//        shareIntent = new Intent(android.content.Intent.ACTION_SEND);
//        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
//        shareIntent.setType("image/jpg");
//        startActivity(Intent.createChooser(shareIntent,"Share with"));
    }

}
