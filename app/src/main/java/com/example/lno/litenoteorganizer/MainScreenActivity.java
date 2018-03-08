package com.example.lno.litenoteorganizer;

import android.Manifest;
import android.app.Activity;
import android.app.ListActivity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph Misa on 3/8/2018.
 */




public class MainScreenActivity extends Activity {
    ListView lv;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        lv = (ListView) findViewById(R.id.lvSubs);

        if (ContextCompat.checkSelfPermission(MainScreenActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainScreenActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(MainScreenActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {
            ArrayList<String> filesinfolder = GetFiles(
                    "/sdcard/Android/MainFolder");
            ArrayAdapter<String> adapter
                    = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    filesinfolder);
            lv.setAdapter(adapter);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ArrayList<String> filesinfolder = GetFiles("/storage/");
                    ArrayAdapter<String> adapter
                            = new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1,
                            filesinfolder);
                    lv.setAdapter(adapter);
                } else {
                }
                return;
            }
        }
    }
    public ArrayList<String> GetFiles(String directorypath) {
        ArrayList<String> Myfiles = new ArrayList<String>();
        File f = new File(directorypath);
        f.mkdirs();
        File[] files = f.listFiles();
        if (files.length == 0) {
            return null;
        } else {
            for (int i = 0; i < files.length; i++)
                Myfiles.add(files[i].getName());
        }
        return Myfiles;
    }
}
