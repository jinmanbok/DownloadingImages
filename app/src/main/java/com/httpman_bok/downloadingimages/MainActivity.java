package com.httpman_bok.downloadingimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    ImageView downloadedImg;

    public void downloadImage(View view) {

        //https://upload.wikimedia.org/wikipedia/commons/9/91/AOA_%28South_Korean_girl_group%29_at_Gimpo_Airport%2C_Seoul%2C_in_October_2013.jpg

        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;

        try {

            myImage = task.execute("https://upload.wikimedia.org/wikipedia/commons/9/91/AOA_%28South_Korean_girl_group%29_at_Gimpo_Airport%2C_Seoul%2C_in_October_2013.jpg").get();
            downloadedImg.setImageBitmap(myImage);

            } catch (Exception e) {
            e.printStackTrace();
        }


        Log.i("Interaction", "Button Tapped");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         downloadedImg = (ImageView) findViewById(R.id.imageView);
    }
}

