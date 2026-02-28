package com.example.fragmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    String[] items = {"Sanchet", "Rahul", "Amit", "Priya"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ListView listView = new ListView(getActivity());

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_list_item_1,
                        items);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("name", items[position]);
            startActivity(intent);

        });

        return listView;
    }
}