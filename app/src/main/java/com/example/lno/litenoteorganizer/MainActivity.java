package com.example.lno.litenoteorganizer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

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

    ListView lv;
        private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lvContent);
        lv.setDescendantFocusability(ListView.FOCUS_BLOCK_DESCENDANTS);

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                /*MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                app-defined int constant. The callback method gets the
                result of the request.*/
            }
        } else {
            ArrayList<String> filesinfolder = GetFiles(
                    "/sdcard/Android/MainFolder/1/");
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
    /*public static void main(String[] args)
    {

        InputStream inStream = null;
        OutputStream outStream = null;

        try{

            File afile =new File("C:\\folderA\\Afile.txt");
            File bfile =new File("C:\\folderB\\Afile.txt");

            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){

                outStream.write(buffer, 0, length);

            }

            inStream.close();
            outStream.close();

            //delete the original file
            afile.delete();

            System.out.println("File is copied successful!");

        }catch(IOException e){
            e.printStackTrace();
        }
    }*/
    }
