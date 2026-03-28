package com.example.bankmenuapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.withdraw)
        {
            Toast.makeText(this,"Withdraw Selected",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.deposit)
        {
            Toast.makeText(this,"Deposit Selected",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.balance)
        {
            Toast.makeText(this,"Check Balance Selected",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.exit)
        {
            finish();
        }

        return true;
    }
}