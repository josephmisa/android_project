package com.example.lno.litenoteorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_camera:
                    Intent intentCamera = new Intent(MainActivity.this, CameraController.class);
                    startActivity(intentCamera);
                case R.id.navigation_image:
                    Intent intentImage = new Intent(MainActivity.this, MainImport.class);
                    startActivity(intentImage);
                case R.id.navigation_file:
                    mTextMessage.setText(R.string.title_file);
                    return true;
                case R.id.navigation_note:
                    mTextMessage.setText(R.string.title_note);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    }
