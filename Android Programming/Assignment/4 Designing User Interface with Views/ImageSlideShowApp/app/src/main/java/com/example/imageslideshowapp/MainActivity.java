package com.example.imageslideshowapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    int images[] = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
    };

    int index = 0;

    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            imageView.setImageResource(images[index]);

            index++;

            if(index == images.length)
            {
                index = 0;
            }

            handler.postDelayed(this,2000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        imageView.setImageResource(images[0]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.slide)
        {
            handler.post(runnable);
        }

        return true;
    }
}