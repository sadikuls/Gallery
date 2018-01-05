package com.example.bsandroidtest.Activities;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.bsandroidtest.Fragments.GalleryFragment;
import com.example.bsandroidtest.Fragments.ShowImage;
import com.example.bsandroidtest.R;

public class MainActivity extends AppCompatActivity implements GalleryFragment.SendDataToActivity {

    private static final String TAG = "MainActivity";
    FrameLayout firstFramelayout,secondFramelayout;
    ShowImage fragTwo;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);


        GalleryFragment fragOne = new GalleryFragment();
        fragTwo = new ShowImage();

        //fragmentCommunicator = (FragmentCommunicator) fragTwo;

        firstFramelayout = (FrameLayout) findViewById(R.id.firstfragmentContainer);
        secondFramelayout = (FrameLayout) findViewById(R.id.secondfragmentContainer);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        ft.add(R.id.firstfragmentContainer, fragOne);
        ft.add(R.id.secondfragmentContainer, fragTwo);
        ft.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.about:{
                startActivity(new Intent(this,AboutActivity.class));
                //finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void imageLink(String imageLink) {
        //fragmentCommunicator.passData(imageLink);
        fragTwo.onDataPassed(imageLink);
    }


    public interface OnDataPassedListener {
        void onDataPassed(String url);
    }
}

