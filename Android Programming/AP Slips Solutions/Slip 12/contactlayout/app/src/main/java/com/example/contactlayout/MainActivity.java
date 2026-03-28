package com.example.contactlayout;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2;
    TextView name1, phone1, email1;
    TextView name2, phone2, email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Contact 1
        img1 = findViewById(R.id.img1);
        name1 = findViewById(R.id.name1);
        phone1 = findViewById(R.id.phone1);
        email1 = findViewById(R.id.email1);

        // Contact 2
        img2 = findViewById(R.id.img2);
        name2 = findViewById(R.id.name2);
        phone2 = findViewById(R.id.phone2);
        email2 = findViewById(R.id.email2);

        // Set Data for Contact 1
        img1.setImageResource(R.drawable.photo);
        name1.setText("Name: Sanchet Kolekar");
        phone1.setText("Phone: 7066062254");
        email1.setText("Email: sanchet@gmail.com");

        // Set Data for Contact 2
        img2.setImageResource(R.drawable.photo2);
        name2.setText("Name: John Doe");
        phone2.setText("Phone: 9876543210");
        email2.setText("Email: john@example.com");
    }
}