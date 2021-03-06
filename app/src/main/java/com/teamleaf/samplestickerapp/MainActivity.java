package com.teamleaf.samplestickerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.teamleaf.samplestickerapp.Fragments.LoveFragment;
import com.teamleaf.samplestickerapp.Util.Utils;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_INVITE = 1;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(new LoveFragment());
                    return true;

                case R.id.navigation_packs:
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), EntryActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.navigation_share:
                    Toast.makeText(getApplicationContext(),"share",Toast.LENGTH_LONG).show();
                    shareApp();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new LoveFragment());

        Utils.getDatabase();

    }

    public void shareApp(){
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Whatsapp Stickers");
            String sAux = "\nLet me recommend you this application\n\n";
//            sAux = sAux + "https://play.google.com/store/apps/details?id=the.package.id \n\n";
            sAux = sAux + "https://drive.google.com/file/d/1TPtlFS90W8ZpohHq2SZRndMk1JPVJdvc/view \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }

//        Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
//                .setMessage(getString(R.string.invitation_message))
//                .setCallToActionText(getString(R.string.invitation_cta))
//                .build();
//        startActivityForResult(intent, REQUEST_INVITE);
    }

    private void loadFragment(android.support.v4.app.Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
