package com.example.custom_contact_layout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayList<HashMap<String,String>> list = new ArrayList<>();

        HashMap<String,String> c1 = new HashMap<>();
        c1.put("name","Sanchet");
        c1.put("phone","7066062254");
        c1.put("email","sanchetkolekar.07@gmail.com");
        list.add(c1);

        HashMap<String,String> c2 = new HashMap<>();
        c2.put("name","Vaishnavi");
        c2.put("phone","9876543211");
        c2.put("email","Vaishnavi@gmail.com");
        list.add(c2);

        String from[] = {"name","phone","email"};
        int to[] = {R.id.name,R.id.phone,R.id.email};

        SimpleAdapter adapter = new SimpleAdapter(this,list,
                R.layout.contact_layout,from,to);

        listView.setAdapter(adapter);
    }
}