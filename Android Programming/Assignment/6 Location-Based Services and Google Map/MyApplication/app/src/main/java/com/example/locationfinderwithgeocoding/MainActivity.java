package com.example.locationfinderwithgeocoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button getLocation;
    TextView locationText;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLocation = findViewById(R.id.getLocation);
        locationText = findViewById(R.id.locationText);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

        getLocation.setOnClickListener(v -> {

            try {

                if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                Location location = locationManager.getLastKnownLocation(
                        LocationManager.GPS_PROVIDER);

                if(location != null)
                {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();

                    Geocoder geocoder = new Geocoder(this, Locale.getDefault());

                    List<Address> addresses =
                            geocoder.getFromLocation(latitude, longitude,1);

                    Address address = addresses.get(0);

                    String addressLine = address.getAddressLine(0);
                    String city = address.getLocality();

                    locationText.setText(
                            "Latitude: "+latitude+
                                    "\nLongitude: "+longitude+
                                    "\nAddress: "+addressLine+
                                    "\nCity: "+city);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}