package com.example.gridapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView grid;

    int images[] = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8, R.drawable.img9,
            R.drawable.img10, R.drawable.img11, R.drawable.img12,
            R.drawable.img13, R.drawable.img14, R.drawable.img15
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.grid);

        grid.setAdapter(new ImageAdapter());

        grid.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this,
                    "Position: " + position,
                    Toast.LENGTH_SHORT).show();
        });
    }

    // Adapter Class
    class ImageAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {

            ImageView img = new ImageView(MainActivity.this);
            img.setImageResource(images[position]);
            img.setLayoutParams(new GridView.LayoutParams(250, 250));
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);

            return img;
        }
    }
}