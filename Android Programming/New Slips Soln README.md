# 📱 Android Programming Slips

> Complete solution set for Android Programming practical slips (Slip 01 – Slip 20)

---

## 📋 Index

| Slip | Q1 (10 Marks) | Q2 (20 Marks) |
|------|--------------|--------------|
| [Slip 01](#slip-01) | Activity Life Cycle Demo | DatePicker & DatePickerDialog |
| [Slip 02](#slip-02) | Factorial in Second Activity | Satellite View using Google Maps |
| [Slip 03](#slip-03) | Change College Name Color & Font | Factorial with Alert Dialog |
| [Slip 04](#slip-04) | Arithmetic Operations (ConstraintLayout) | Notification on Button Click |
| [Slip 05](#slip-05) | Power & Average to Next Activity | Custom Alert Dialog with Friends |
| [Slip 06](#slip-06) | Send "Hello!" via Intent | ListView with Toast on Click |
| [Slip 07](#slip-07) | Radio Button Demo | Phone Call via Implicit Intent |
| [Slip 08](#slip-08) | Login Screen (TableLayout) | Send Email with Attachment |
| [Slip 09](#slip-09) | Validate Two Numbers > 10 | SQLite Company CRUD |
| [Slip 10](#slip-10) | Switch & Toggle Button Demo | ArrayAdapter with Fruits List |
| [Slip 11](#slip-11) | Change Font Size, Color & Family | Student Form to Second Activity |
| [Slip 12](#slip-12) | Send "Hi" via Intent | Date & Time Picker |
| [Slip 13](#slip-13) | Vertical ScrollView with 10 Buttons | Teacher-Student DB (Many-to-Many) |
| [Slip 14](#slip-14) | Activity Lifecycle with Log | Send Email |
| [Slip 15](#slip-15) | Add Border to Layout | Login Screen (Email/Password) |
| [Slip 16](#slip-16) | Student Details Form to TableLayout | TimePicker Demo |
| [Slip 17](#slip-17) | Phone Call via Intent | Factorial & Sum of Digits (Context Menu) + Spinner |
| [Slip 18](#slip-18) | Alert Dialog Demo | Power & Average via Context Menu |
| [Slip 19](#slip-19) | Bulb ON/OFF with Toggle Button | Membership Form (TableLayout) |
| [Slip 20](#slip-20) | Change Image on Button Click | ArrayAdapter with Country List |

---

---

## Slip 01

### Q1. Create a Simple Application which shows the Life Cycle of Activity. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <TextView
        android:id="@+id/tvStatus"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Activity Lifecycle Demo"
        android:textSize="18sp" />

    <Button
        android:id="@+id/btnNextActivity"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Next Activity"
        android:layout_marginTop="16dp" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvStatus;
    String TAG = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);
        Button btn = findViewById(R.id.btnNextActivity);

        tvStatus.setText("onCreate()");
        Log.d(TAG, "onCreate()");

        btn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvStatus.setText("onStart()");
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvStatus.setText("onResume()");
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        tvStatus.setText("onPause()");
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tvStatus.setText("onRestart()");
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
```

#### ➕ `SecondActivity.java` & `activity_second.xml`

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Second Activity"
    android:textSize="18sp"/>
```

#### 📄 `AndroidManifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

### Q2. Create an Android Application that demonstrate DatePicker and DatePickerDialog. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="Date Picker"
        android:textSize="40sp" />

    <Button
        android:id="@+id/btn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="Select Date" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.slips;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(
                        MainActivity.this,
                        (view, y, m, d) -> {
                            tv.setText(d + "/" + (m + 1) + "/" + y);
                        },
                        year, month, day
                );

                dpd.show();
            }
        });
    }
}
```

---

---

## Slip 02

### Q1. Create a Simple Application, which reads a positive number from the user and display its factorial value in another activity. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <EditText
        android:id="@+id/etNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter number"
        android:inputType="number" />

    <Button
        android:id="@+id/btnCalculate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calculate"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.factorialapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> {
            int num = Integer.parseInt(etNumber.getText().toString());

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("number", num);
            startActivity(intent);
        });
    }
}
```

#### ➕ `SecondActivity.java`

```java
package com.example.factorialapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult = findViewById(R.id.tvResult);

        int num = getIntent().getIntExtra("number", 0);

        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }

        tvResult.setText("Factorial = " + fact);
    }
}
```

#### 📱 `activity_second.xml`

```xml
<TextView
    android:id="@+id/tvResult"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:textSize="18sp"/>
```

#### 📄 `AndroidManifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

### Q2. Create an Android Application to display satellite view of current location using Google Map. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<fragment xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/map"
    android:name="com.google.android.gms.maps.SupportMapFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

#### ⚙️ `MainActivity.java`

```java
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment smf = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);

        smf.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Set Satellite View
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Fixed Location (Pune)
        LatLng pune = new LatLng(18.5204, 73.8567);

        map.addMarker(new MarkerOptions().position(pune).title("Pune"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pune, 15));
    }
}
```

#### 📄 `AndroidManifest.xml` (addition)

```xml
<uses-permission android:name="android.permission.INTERNET"/>

<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_API_KEY"/>
```

---

---

## Slip 03

### Q1. Create an Android Application that will change color of the College Name on click of Push Button and change the font size, font style of text view using xml. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <TextView
        android:id="@+id/tvCollege"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="MIT ACSC Pune"
        android:textSize="20sp"
        android:textStyle="normal" />

    <Button
        android:id="@+id/btnChange"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Change"
        android:layout_marginTop="16dp" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvCollege);
        btn = findViewById(R.id.btnChange);

        btn.setOnClickListener(v -> {
            tv.setTextColor(Color.RED);
            tv.setTextSize(30);
            tv.setTypeface(null, Typeface.BOLD_ITALIC);
        });
    }
}
```

---

### Q2. Create an Android Application to find the factorial of a number and Display the Result on Alert Box. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <EditText
        android:id="@+id/etNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter number"
        android:inputType="number" />

    <Button
        android:id="@+id/btnFactorial"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Find Factorial"
        android:layout_marginTop="16dp" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.factorialalert;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnFactorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnFactorial = findViewById(R.id.btnFactorial);

        btnFactorial.setOnClickListener(v -> {

            int num = Integer.parseInt(etNumber.getText().toString());

            long fact = 1;
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }

            // Alert Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Factorial Result");
            builder.setMessage("Factorial = " + fact);
            builder.setPositiveButton("OK", null);
            builder.show();
        });
    }
}
```

---

---

## Slip 04

### Q1. Create a Simple Application, that performs Arithmetic Operations. (Use constraint layout) [10 Marks]

#### 📱 `activity_main.xml` (ConstraintLayout)

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:id="@+id/et1"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter first number"
        android:inputType="number"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_margin="16dp"/>

    <EditText
        android:id="@+id/et2"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter second number"
        android:inputType="number"
        app:layout_constraintTop_toBottomOf="@id/et1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_margin="16dp"/>

    <Button
        android:id="@+id/btnAdd"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Add"
        app:layout_constraintTop_toBottomOf="@id/et2"
        app:layout_constraintStart_toStartOf="parent"
        android:layout_margin="16dp"/>

    <Button
        android:id="@+id/btnSub"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Sub"
        app:layout_constraintTop_toBottomOf="@id/et2"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_margin="16dp"/>

    <Button
        android:id="@+id/btnMul"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Mul"
        app:layout_constraintTop_toBottomOf="@id/btnAdd"
        app:layout_constraintStart_toStartOf="parent"
        android:layout_margin="16dp"/>

    <Button
        android:id="@+id/btnDiv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Div"
        app:layout_constraintTop_toBottomOf="@id/btnSub"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_margin="16dp"/>

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Result"
        android:textSize="18sp"
        app:layout_constraintTop_toBottomOf="@id/btnMul"
        app:layout_constraintStart_toStartOf="parent"
        android:layout_margin="16dp"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.arithmeticapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button add, sub, mul, div;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        add = findViewById(R.id.btnAdd);
        sub = findViewById(R.id.btnSub);
        mul = findViewById(R.id.btnMul);
        div = findViewById(R.id.btnDiv);
        tv = findViewById(R.id.tvResult);

        add.setOnClickListener(v -> {
            int a = Integer.parseInt(et1.getText().toString());
            int b = Integer.parseInt(et2.getText().toString());
            tv.setText("Result: " + (a + b));
        });

        sub.setOnClickListener(v -> {
            int a = Integer.parseInt(et1.getText().toString());
            int b = Integer.parseInt(et2.getText().toString());
            tv.setText("Result: " + (a - b));
        });

        mul.setOnClickListener(v -> {
            int a = Integer.parseInt(et1.getText().toString());
            int b = Integer.parseInt(et2.getText().toString());
            tv.setText("Result: " + (a * b));
        });

        div.setOnClickListener(v -> {
            int a = Integer.parseInt(et1.getText().toString());
            int b = Integer.parseInt(et2.getText().toString());
            tv.setText("Result: " + (a / b));
        });
    }
}
```

---

### Q2. Create an Android Application that sends the Notification on click of the button and displays the notification message on the second activity. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <Button
        android:id="@+id/btnNotify"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Notification" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    String CHANNEL_ID = "my_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnNotify);

        createNotificationChannel();

        btn.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("msg", "Hello from Notification!");

            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this, 0, intent, PendingIntent.FLAG_IMMUTABLE
            );

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setContentTitle("My Notification")
                    .setContentText("Click to open")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat manager = NotificationManagerCompat.from(this);
            manager.notify(1, builder.build());
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "My Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}
```

#### 📱 `activity_second.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tvMessage"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp" />

</LinearLayout>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.tvMessage);

        String msg = getIntent().getStringExtra("msg");
        tv.setText(msg);
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

---

## Slip 05

### Q1. Create an Android Application to accept two numbers and find power and Average. Display the result on the next activity on Button click. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <EditText
        android:id="@+id/et1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter first number"
        android:inputType="number"/>

    <EditText
        android:id="@+id/et2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter second number"
        android:inputType="number"
        android:layout_marginTop="10dp"/>

    <Button
        android:id="@+id/btnResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calculate"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.poweravg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btn = findViewById(R.id.btnResult);

        btn.setOnClickListener(v -> {

            int a = Integer.parseInt(et1.getText().toString());
            int b = Integer.parseInt(et2.getText().toString());

            double power = Math.pow(a, b);
            double avg = (a + b) / 2.0;

            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("power", power);
            i.putExtra("avg", avg);
            startActivity(i);
        });
    }
}
```

#### 📱 `activity_second.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"/>

</LinearLayout>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.poweravg;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.tvResult);

        double power = getIntent().getDoubleExtra("power", 0);
        double avg = getIntent().getDoubleExtra("avg", 0);

        tv.setText("Power = " + power + "\nAverage = " + avg);
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

### Q2. Create an Android application that creates a custom Alert Dialog containing Friends Name and onClick of Friend Name Button greet accordingly. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <Button
        android:id="@+id/btnShow"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Show Friends" />

</LinearLayout>
```

#### 📱 `dialog_layout.xml` (Custom Dialog UI)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp">

    <Button
        android:id="@+id/btnFriend1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Rahul" />

    <Button
        android:id="@+id/btnFriend2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Amit"
        android:layout_marginTop="8dp"/>

    <Button
        android:id="@+id/btnFriend3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Sneha"
        android:layout_marginTop="8dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(v -> {

            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.dialog_layout, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setView(dialogView);

            AlertDialog dialog = builder.create();
            dialog.show();

            Button f1 = dialogView.findViewById(R.id.btnFriend1);
            Button f2 = dialogView.findViewById(R.id.btnFriend2);
            Button f3 = dialogView.findViewById(R.id.btnFriend3);

            f1.setOnClickListener(v1 -> {
                Toast.makeText(this, "Hello Rahul!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            f2.setOnClickListener(v1 -> {
                Toast.makeText(this, "Hello Amit!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            f3.setOnClickListener(v1 -> {
                Toast.makeText(this, "Hello Sneha!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
        });
    }
}
```

---

---

## Slip 06

### Q1. Create a Simple Application Which Send "Hello!" message from one activity to another with help of Button (Use Intent). [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <Button
        android:id="@+id/btnSend"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Hello" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.hellointent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnSend);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("msg", "Hello!");
            startActivity(i);
        });
    }
}
```

#### 📱 `activity_second.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tvMessage"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"/>

</LinearLayout>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.hellointent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.tvMessage);

        String msg = getIntent().getStringExtra("msg");
        tv.setText(msg);
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

### Q2. Create an Android Application that Demonstrates ListView and Onclick of List Display the Toast. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] items = {"Apple", "Banana", "Mango", "Orange", "Grapes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selected = items[position];
            Toast.makeText(this, "Selected: " + selected, Toast.LENGTH_SHORT).show();
        });
    }
}
```

---

---

## Slip 07

### Q1. Create an Android Application that Demonstrate Radio Button. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <RadioGroup
        android:id="@+id/radioGroup"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <RadioButton
            android:id="@+id/rb1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Option 1"/>

        <RadioButton
            android:id="@+id/rb2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Option 2"/>

        <RadioButton
            android:id="@+id/rb3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Option 3"/>
    </RadioGroup>

    <Button
        android:id="@+id/btnShow"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Show Selected"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.radiodemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.btnShow);

        btn.setOnClickListener(v -> {
            int selectedId = rg.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton rb = findViewById(selectedId);
                Toast.makeText(this, "Selected: " + rb.getText(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No option selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

---

### Q2. Create an Android application to demonstrate phone call using Implicit Intent. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <EditText
        android:id="@+id/etNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter phone number"
        android:inputType="phone"/>

    <Button
        android:id="@+id/btnCall"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Call"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(v -> {
            String number = etNumber.getText().toString();

            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + number));

            startActivity(i);
        });
    }
}
```

---

---

## Slip 08

### Q1. Create an Android App with Login Screen. On successful login, gives message go to next Activity (Without Using Database & use Table Layout). [10 Marks]

#### 📱 `activity_main.xml` (TableLayout)

```xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:stretchColumns="1"
    android:padding="16dp">

    <TableRow>
        <TextView
            android:text="Username:" />
        <EditText
            android:id="@+id/etUser"
            android:hint="Enter Username" />
    </TableRow>

    <TableRow>
        <TextView
            android:text="Password:" />
        <EditText
            android:id="@+id/etPass"
            android:hint="Enter Password"
            android:inputType="textPassword" />
    </TableRow>

    <TableRow>
        <Button
            android:id="@+id/btnLogin"
            android:layout_span="2"
            android:text="Login" />
    </TableRow>

</TableLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {

            String user = etUser.getText().toString();
            String pass = etPass.getText().toString();

            if (user.equals("admin") && pass.equals("1234")) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

#### 📱 `activity_second.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Welcome to Next Activity"
        android:textSize="18sp"/>
</LinearLayout>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

### Q2. Create application to send email with attachment. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <Button
        android:id="@+id/btnEmail"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Email" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.emailapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmail = findViewById(R.id.btnEmail);

        btnEmail.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"test@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello! This is email body.");

            // Attachment (example file URI)
            Uri fileUri = Uri.parse("file:///sdcard/sample.txt");
            intent.putExtra(Intent.EXTRA_STREAM, fileUri);

            startActivity(Intent.createChooser(intent, "Send Email"));
        });
    }
}
```

---

---

## Slip 09

### Q1. Write an Android application to accept two numbers from the user, and display them, but reject input if both numbers are greater than 10 and asks for two new numbers. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <EditText
        android:id="@+id/et1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter first number"
        android:inputType="number"/>

    <EditText
        android:id="@+id/et2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter second number"
        android:inputType="number"
        android:layout_marginTop="10dp"/>

    <Button
        android:id="@+id/btnCheck"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Submit"
        android:layout_marginTop="16dp"/>

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.validationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btn = findViewById(R.id.btnCheck);
        tv = findViewById(R.id.tvResult);

        btn.setOnClickListener(v -> {

            int a = Integer.parseInt(et1.getText().toString());
            int b = Integer.parseInt(et2.getText().toString());

            if (a > 10 && b > 10) {
                Toast.makeText(this, "Both numbers > 10. Enter new values.", Toast.LENGTH_SHORT).show();
                et1.setText("");
                et2.setText("");
            } else {
                tv.setText("Numbers are: " + a + " , " + b);
            }
        });
    }
}
```

---

### Q2. Create table Company (id, name, address, phno). Create Application for Performing Insert and Show All operations. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText android:id="@+id/etId" android:hint="ID"/>
    <EditText android:id="@+id/etName" android:hint="Name"/>
    <EditText android:id="@+id/etAddress" android:hint="Address"/>
    <EditText android:id="@+id/etPhone" android:hint="Phone"/>

    <Button
        android:id="@+id/btnInsert"
        android:text="Insert"/>

    <Button
        android:id="@+id/btnShow"
        android:text="Show All"
        android:layout_marginTop="10dp"/>

    <TextView
        android:id="@+id/tvResult"
        android:textSize="16sp"
        android:layout_marginTop="10dp"/>
</LinearLayout>
```

#### ⚙️ `DBHelper.java`

```java
package com.example.companyapp;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "CompanyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Company(id INTEGER PRIMARY KEY, name TEXT, address TEXT, phno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void insertData(int id, String name, String address, String phno) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Company VALUES(?, ?, ?, ?)",
                new Object[]{id, name, address, phno});
    }

    public String getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Company", null);

        StringBuilder data = new StringBuilder();

        while (c.moveToNext()) {
            data.append("ID: ").append(c.getInt(0))
                .append("\nName: ").append(c.getString(1))
                .append("\nAddress: ").append(c.getString(2))
                .append("\nPhone: ").append(c.getString(3))
                .append("\n\n");
        }
        return data.toString();
    }
}
```

#### ⚙️ `MainActivity.java`

```java
package com.example.companyapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etId, etName, etAddress, etPhone;
    Button btnInsert, btnShow;
    TextView tv;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        tv = findViewById(R.id.tvResult);

        db = new DBHelper(this);

        btnInsert.setOnClickListener(v -> {
            db.insertData(
                    Integer.parseInt(etId.getText().toString()),
                    etName.getText().toString(),
                    etAddress.getText().toString(),
                    etPhone.getText().toString()
            );
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
        });

        btnShow.setOnClickListener(v -> {
            String data = db.getData();
            tv.setText(data);
        });
    }
}
```

---

---

## Slip 10

### Q1. Create an Android Application that Demonstrate Switch and Toggle Button. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <Switch
        android:id="@+id/switch1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Switch"/>

    <ToggleButton
        android:id="@+id/toggle1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textOn="ON"
        android:textOff="OFF"
        android:layout_marginTop="16dp"/>

    <Button
        android:id="@+id/btnCheck"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Check Status"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.switchtoggle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Switch sw;
    ToggleButton tb;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = findViewById(R.id.switch1);
        tb = findViewById(R.id.toggle1);
        btn = findViewById(R.id.btnCheck);

        btn.setOnClickListener(v -> {

            String msg = "";

            if (sw.isChecked())
                msg += "Switch ON\n";
            else
                msg += "Switch OFF\n";

            if (tb.isChecked())
                msg += "Toggle ON";
            else
                msg += "Toggle OFF";

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });
    }
}
```

---

### Q2. Demonstrate Array Adapter using List View to display list of fruits. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.fruitlist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] fruits = {"Apple", "Banana", "Mango", "Orange", "Grapes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                fruits
        );

        listView.setAdapter(adapter);
    }
}
```

---

---

## Slip 11

### Q1. Create android application to change Font Size, Color and Font Family of String. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <TextView
        android:id="@+id/tvText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello Android"
        android:textSize="18sp"
        android:textColor="#000000" />

    <Button
        android:id="@+id/btnChange"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Change Style"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.fontapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvText);
        btn = findViewById(R.id.btnChange);

        btn.setOnClickListener(v -> {
            tv.setTextSize(30);
            tv.setTextColor(Color.BLUE);
            tv.setTypeface(Typeface.SERIF);
        });
    }
}
```

---

### Q2. Create First Activity to accept Student information and display all information on Second Activity when user clicks Submit button. [20 Marks]

#### 📱 `activity_main.xml` (Input Form)

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText android:id="@+id/etFName" android:hint="First Name"/>
    <EditText android:id="@+id/etMName" android:hint="Middle Name"/>
    <EditText android:id="@+id/etLName" android:hint="Last Name"/>
    <EditText android:id="@+id/etDOB" android:hint="Date of Birth"/>
    <EditText android:id="@+id/etAddress" android:hint="Address"/>
    <EditText android:id="@+id/etEmail" android:hint="Email ID"/>

    <Button
        android:id="@+id/btnSubmit"
        android:text="Submit"
        android:layout_marginTop="16dp"/>

</LinearLayout>
</ScrollView>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText f, m, l, dob, addr, email;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f = findViewById(R.id.etFName);
        m = findViewById(R.id.etMName);
        l = findViewById(R.id.etLName);
        dob = findViewById(R.id.etDOB);
        addr = findViewById(R.id.etAddress);
        email = findViewById(R.id.etEmail);
        btn = findViewById(R.id.btnSubmit);

        btn.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this, SecondActivity.class);

            i.putExtra("fname", f.getText().toString());
            i.putExtra("mname", m.getText().toString());
            i.putExtra("lname", l.getText().toString());
            i.putExtra("dob", dob.getText().toString());
            i.putExtra("addr", addr.getText().toString());
            i.putExtra("email", email.getText().toString());

            startActivity(i);
        });
    }
}
```

#### 📱 `activity_second.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tvResult"
        android:textSize="16sp"/>

</LinearLayout>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.tvResult);

        String data =
                "First Name: " + getIntent().getStringExtra("fname") +
                "\nMiddle Name: " + getIntent().getStringExtra("mname") +
                "\nLast Name: " + getIntent().getStringExtra("lname") +
                "\nDOB: " + getIntent().getStringExtra("dob") +
                "\nAddress: " + getIntent().getStringExtra("addr") +
                "\nEmail: " + getIntent().getStringExtra("email");

        tv.setText(data);
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

---

## Slip 12

### Q1. Create a Simple Application Which Send "Hi" message from one activity to another with help of Button (Use Intent). [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <Button
        android:id="@+id/btnSend"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Hi" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.hiintent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnSend);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("msg", "Hi");
            startActivity(i);
        });
    }
}
```

#### 📱 `activity_second.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center">

    <TextView
        android:id="@+id/tvMessage"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"/>
</LinearLayout>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.hiintent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.tvMessage);

        String msg = getIntent().getStringExtra("msg");
        tv.setText(msg);
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

### Q2. Create an application to demonstrate date and time picker. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <Button
        android:id="@+id/btnDate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Select Date"/>

    <Button
        android:id="@+id/btnTime"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Select Time"
        android:layout_marginTop="10dp"/>

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:layout_marginTop="20dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.*;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDate, btnTime;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        tv = findViewById(R.id.tvResult);

        // Date Picker
        btnDate.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            DatePickerDialog dp = new DatePickerDialog(
                    this,
                    (view, y, m, d) -> {
                        tv.setText("Date: " + d + "/" + (m + 1) + "/" + y);
                    },
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            );
            dp.show();
        });

        // Time Picker
        btnTime.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            TimePickerDialog tp = new TimePickerDialog(
                    this,
                    (view, h, m) -> {
                        tv.setText("Time: " + h + ":" + m);
                    },
                    c.get(Calendar.HOUR_OF_DAY),
                    c.get(Calendar.MINUTE),
                    true
            );
            tp.show();
        });
    }
}
```

---

---

## Slip 13

### Q1. Create following Vertical Scroll View Creation in Android (Button 1 to Button 10). [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 1"/>
        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 2"/>
        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 3"/>
        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 4"/>
        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 5"/>
        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 6"/>
        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 7"/>
        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 8"/>
        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 9"/>
        <Button android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Button 10"/>

    </LinearLayout>
</ScrollView>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.scrollviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

---

### Q2. Write an application to accept a teacher name from user and display the names of students along with subjects to whom they are teaching. (Many-to-Many relationship) [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/etTeacher"
        android:hint="Enter Teacher Name"/>

    <Button
        android:id="@+id/btnShow"
        android:text="Show Students"
        android:layout_marginTop="10dp"/>

    <TextView
        android:id="@+id/tvResult"
        android:layout_marginTop="10dp"
        android:textSize="16sp"/>
</LinearLayout>
```

#### ⚙️ `DBHelper.java`

```java
package com.example.teacherapp;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "SchoolDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Student(sno INTEGER, s_name TEXT, s_class TEXT, s_addr TEXT)");
        db.execSQL("CREATE TABLE Teacher(tno INTEGER, t_name TEXT, qualification TEXT, experience TEXT)");
        db.execSQL("CREATE TABLE Teach(sno INTEGER, tno INTEGER, subject TEXT)");

        // Sample Data
        db.execSQL("INSERT INTO Student VALUES(1,'Sanchet','TY','Pune')");
        db.execSQL("INSERT INTO Teacher VALUES(1,'Donvo Ferrera','MSc','5')");
        db.execSQL("INSERT INTO Teach VALUES(1,1,'Math')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public String getData(String teacherName) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query =
                "SELECT s.s_name, t.subject FROM Student s, Teacher tr, Teach t " +
                "WHERE s.sno = t.sno AND tr.tno = t.tno AND tr.t_name = ?";

        Cursor c = db.rawQuery(query, new String[]{teacherName});

        StringBuilder data = new StringBuilder();

        while (c.moveToNext()) {
            data.append("Student: ").append(c.getString(0))
                .append("\nSubject: ").append(c.getString(1))
                .append("\n\n");
        }

        return data.toString();
    }
}
```

#### ⚙️ `MainActivity.java`

```java
package com.example.teacherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etTeacher;
    Button btn;
    TextView tv;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTeacher = findViewById(R.id.etTeacher);
        btn = findViewById(R.id.btnShow);
        tv = findViewById(R.id.tvResult);

        db = new DBHelper(this);

        btn.setOnClickListener(v -> {
            String name = etTeacher.getText().toString();
            String result = db.getData(name);
            tv.setText(result);
        });
    }
}
```

---

---

## Slip 14

### Q1. Create a Simple Application which shows Life Cycle of Activity {Use log}. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Activity Lifecycle Demo"
        android:textSize="18sp"/>
</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String TAG = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
```

---

### Q2. Create an Android application to send email. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <Button
        android:id="@+id/btnEmail"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Email" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.emailapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmail = findViewById(R.id.btnEmail);

        btnEmail.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"test@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello! This is email body.");

            Uri fileUri = Uri.parse("file:///sdcard/sample.txt");
            intent.putExtra(Intent.EXTRA_STREAM, fileUri);

            startActivity(Intent.createChooser(intent, "Send Email"));
        });
    }
}
```

---

---

## Slip 15

### Q1. Design following - add a border to an Android Layout. [10 Marks]

#### 🧩 `res/drawable/border.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">

    <!-- Background color -->
    <solid android:color="#FFFFFF"/>

    <!-- Border -->
    <stroke
        android:width="2dp"
        android:color="#000000"/>

    <!-- Optional rounded corners -->
    <corners android:radius="8dp"/>

</shape>
```

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:background="@drawable/border">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Border Example"
        android:textSize="18sp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.borderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

---

### Q2. Create a simple Android application with a Login Screen. Accept Email ID and Password. On successful login, display a message and navigate to the next activity. (Do not use database for validation). [20 Marks]

#### 📱 `activity_main.xml` (Login Screen)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <EditText
        android:id="@+id/etEmail"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Email"
        android:inputType="textEmailAddress"/>

    <EditText
        android:id="@+id/etPassword"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Password"
        android:inputType="textPassword"
        android:layout_marginTop="10dp"/>

    <Button
        android:id="@+id/btnLogin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Login"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {

            String email = etEmail.getText().toString();
            String pass = etPassword.getText().toString();

            // Hardcoded validation
            if (email.equals("admin@gmail.com") && pass.equals("1234")) {

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SecondActivity.class));

            } else {
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

#### 📱 `activity_second.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Welcome!"
        android:textSize="20sp"/>
</LinearLayout>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

---

## Slip 16

### Q1. Create an Android App, it reads the Students Details and display all information in another activity in table format on click of Submit button. [10 Marks]

#### 📱 `activity_main.xml` (Input Form)

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText android:id="@+id/etName" android:hint="Name"/>
    <EditText android:id="@+id/etSurname" android:hint="Surname"/>
    <EditText android:id="@+id/etClass" android:hint="Class"/>
    <EditText android:id="@+id/etMarks" android:hint="Marks"/>

    <!-- Gender -->
    <RadioGroup android:id="@+id/rgGender">
        <RadioButton android:id="@+id/rbMale" android:text="Male"/>
        <RadioButton android:id="@+id/rbFemale" android:text="Female"/>
    </RadioGroup>

    <!-- Hobbies -->
    <CheckBox android:id="@+id/cbSports" android:text="Sports"/>
    <CheckBox android:id="@+id/cbMusic" android:text="Music"/>

    <Button
        android:id="@+id/btnSubmit"
        android:text="Submit"
        android:layout_marginTop="10dp"/>

</LinearLayout>
</ScrollView>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.etName);
        EditText surname = findViewById(R.id.etSurname);
        EditText cls = findViewById(R.id.etClass);
        EditText marks = findViewById(R.id.etMarks);

        RadioGroup rg = findViewById(R.id.rgGender);
        CheckBox sports = findViewById(R.id.cbSports);
        CheckBox music = findViewById(R.id.cbMusic);

        Button btn = findViewById(R.id.btnSubmit);

        btn.setOnClickListener(v -> {

            int id = rg.getCheckedRadioButtonId();
            RadioButton rb = findViewById(id);
            String gender = rb.getText().toString();

            String hobbies = "";
            if (sports.isChecked()) hobbies += "Sports ";
            if (music.isChecked()) hobbies += "Music";

            Intent i = new Intent(MainActivity.this, SecondActivity.class);

            i.putExtra("name", name.getText().toString());
            i.putExtra("surname", surname.getText().toString());
            i.putExtra("class", cls.getText().toString());
            i.putExtra("marks", marks.getText().toString());
            i.putExtra("gender", gender);
            i.putExtra("hobbies", hobbies);

            startActivity(i);
        });
    }
}
```

#### 📱 `activity_second.xml` (Table Layout)

```xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <TableRow>
        <TextView android:text="Name:"/>
        <TextView android:id="@+id/tvName"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Surname:"/>
        <TextView android:id="@+id/tvSurname"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Class:"/>
        <TextView android:id="@+id/tvClass"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Gender:"/>
        <TextView android:id="@+id/tvGender"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Hobbies:"/>
        <TextView android:id="@+id/tvHobbies"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Marks:"/>
        <TextView android:id="@+id/tvMarks"/>
    </TableRow>

</TableLayout>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ((TextView)findViewById(R.id.tvName)).setText(getIntent().getStringExtra("name"));
        ((TextView)findViewById(R.id.tvSurname)).setText(getIntent().getStringExtra("surname"));
        ((TextView)findViewById(R.id.tvClass)).setText(getIntent().getStringExtra("class"));
        ((TextView)findViewById(R.id.tvMarks)).setText(getIntent().getStringExtra("marks"));
        ((TextView)findViewById(R.id.tvGender)).setText(getIntent().getStringExtra("gender"));
        ((TextView)findViewById(R.id.tvHobbies)).setText(getIntent().getStringExtra("hobbies"));
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

### Q2. Create an Android Application that Demonstrate TimePicker and display Selected Time on TextView. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <Button
        android:id="@+id/btnTime"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Select Time"/>

    <TextView
        android:id="@+id/tvTime"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:layout_marginTop="20dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.timepickerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.*;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnTime);
        tv = findViewById(R.id.tvTime);

        btn.setOnClickListener(v -> {

            Calendar c = Calendar.getInstance();

            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog tp = new TimePickerDialog(
                    MainActivity.this,
                    (view, h, m) -> {
                        tv.setText("Selected Time: " + h + ":" + m);
                    },
                    hour,
                    minute,
                    true
            );

            tp.show();
        });
    }
}
```

---

---

## Slip 17

### Q1. Write an android code to make phone call using Intent. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <EditText
        android:id="@+id/etNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter phone number"
        android:inputType="phone"/>

    <Button
        android:id="@+id/btnCall"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Call"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(v -> {
            String number = etNumber.getText().toString();

            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + number));

            startActivity(i);
        });
    }
}
```

---

### Q2. Construct an Android Application to accept a number and calculate Factorial and Sum of Digits of a given number using Context Menu. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <EditText
        android:id="@+id/etNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter number"
        android:inputType="number"/>

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:layout_marginTop="20dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.contextmenuapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.etNumber);
        tv = findViewById(R.id.tvResult);

        // Register context menu
        registerForContextMenu(et);
    }

    // Create Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select Operation");
        menu.add(0, 1, 0, "Factorial");
        menu.add(0, 2, 0, "Sum of Digits");
    }

    // Handle Menu Click
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int num = Integer.parseInt(et.getText().toString());

        switch (item.getItemId()) {

            case 1:
                long fact = 1;
                for (int i = 1; i <= num; i++) {
                    fact *= i;
                }
                tv.setText("Factorial = " + fact);
                return true;

            case 2:
                int sum = 0;
                int temp = num;
                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }
                tv.setText("Sum of Digits = " + sum);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
```

---

### Q3. Create an android application that demonstrate Spinner. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <Spinner
        android:id="@+id/spinner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.spinnerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    String[] items = {"Apple", "Banana", "Mango", "Orange"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                items
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = items[position];
                Toast.makeText(MainActivity.this, "Selected: " + selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}
```

---

---

## Slip 18

### Q1. Create an Android Application that Demonstrate Alert Dialog Box. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <Button
        android:id="@+id/btnAlert"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Show Alert" />

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.alertdialogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnAlert);

        btn.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Alert")
                   .setMessage("Do you want to continue?")

                   .setPositiveButton("Yes", (dialog, which) -> {
                       Toast.makeText(this, "You clicked Yes", Toast.LENGTH_SHORT).show();
                   })

                   .setNegativeButton("No", (dialog, which) -> {
                       Toast.makeText(this, "You clicked No", Toast.LENGTH_SHORT).show();
                   });

            builder.show();
        });
    }
}
```

---

### Q2. Create an Android Application to accept two numbers and find power and Average. Display the result on the next activity using Context Menu. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <EditText
        android:id="@+id/et1"
        android:hint="Enter first number"
        android:inputType="number"/>

    <EditText
        android:id="@+id/et2"
        android:hint="Enter second number"
        android:inputType="number"
        android:layout_marginTop="10dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.contextcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        // Register context menu
        registerForContextMenu(et1);
    }

    // Create menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select Operation");
        menu.add(0, 1, 0, "Power");
        menu.add(0, 2, 0, "Average");
    }

    // Handle click
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int a = Integer.parseInt(et1.getText().toString());
        int b = Integer.parseInt(et2.getText().toString());

        double result = 0;

        if (item.getItemId() == 1) {
            result = Math.pow(a, b);
        } else if (item.getItemId() == 2) {
            result = (a + b) / 2.0;
        }

        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("result", result);
        startActivity(i);

        return true;
    }
}
```

#### 📱 `activity_second.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center">

    <TextView
        android:id="@+id/tvResult"
        android:textSize="20sp"/>
</LinearLayout>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.contextcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.tvResult);

        double res = getIntent().getDoubleExtra("result", 0);
        tv.setText("Result = " + res);
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

---

## Slip 19

### Q1. Create an Android Application that on/off the bulb using Toggle Button. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/imgBulb"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:src="@drawable/bulb_off"/>

    <ToggleButton
        android:id="@+id/toggleBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textOn="ON"
        android:textOff="OFF"
        android:layout_marginTop="20dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.bulbapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgBulb);
        tb = findViewById(R.id.toggleBtn);

        tb.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                img.setImageResource(R.drawable.bulb_on);
            } else {
                img.setImageResource(R.drawable.bulb_off);
            }
        });
    }
}
```

> 📁 Add `bulb_on.png` and `bulb_off.png` to `res/drawable/`

---

### Q2. Design the Membership Form using Table Layout and display entered details on the next activity. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:stretchColumns="1"
    android:padding="16dp">

    <TableRow>
        <TextView android:text="Full Name"/>
        <EditText android:id="@+id/etName"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Gender"/>
        <RadioGroup android:id="@+id/rgGender">
            <RadioButton android:id="@+id/rbMale" android:text="Male"/>
            <RadioButton android:id="@+id/rbFemale" android:text="Female"/>
        </RadioGroup>
    </TableRow>

    <TableRow>
        <TextView android:text="Current Weight"/>
        <EditText android:id="@+id/etCWeight"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Height"/>
        <EditText android:id="@+id/etHeight"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Goal Weight"/>
        <EditText android:id="@+id/etGWeight"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Age"/>
        <EditText android:id="@+id/etAge"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Phone"/>
        <EditText android:id="@+id/etPhone"/>
    </TableRow>

    <TableRow>
        <TextView android:text="Address"/>
        <EditText android:id="@+id/etAddress"/>
    </TableRow>

    <TableRow>
        <CheckBox
            android:id="@+id/cbTerms"
            android:text="Accept Terms"/>
    </TableRow>

    <TableRow>
        <Button
            android:id="@+id/btnSubmit"
            android:text="Submit"/>
    </TableRow>

</TableLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.membershipapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.etName);
        EditText cw = findViewById(R.id.etCWeight);
        EditText height = findViewById(R.id.etHeight);
        EditText gw = findViewById(R.id.etGWeight);
        EditText age = findViewById(R.id.etAge);
        EditText phone = findViewById(R.id.etPhone);
        EditText addr = findViewById(R.id.etAddress);

        RadioGroup rg = findViewById(R.id.rgGender);
        CheckBox cb = findViewById(R.id.cbTerms);

        Button btn = findViewById(R.id.btnSubmit);

        btn.setOnClickListener(v -> {

            int id = rg.getCheckedRadioButtonId();
            RadioButton rb = findViewById(id);
            String gender = rb.getText().toString();

            String terms = cb.isChecked() ? "Accepted" : "Not Accepted";

            Intent i = new Intent(MainActivity.this, SecondActivity.class);

            i.putExtra("name", name.getText().toString());
            i.putExtra("gender", gender);
            i.putExtra("cw", cw.getText().toString());
            i.putExtra("height", height.getText().toString());
            i.putExtra("gw", gw.getText().toString());
            i.putExtra("age", age.getText().toString());
            i.putExtra("phone", phone.getText().toString());
            i.putExtra("addr", addr.getText().toString());
            i.putExtra("terms", terms);

            startActivity(i);
        });
    }
}
```

#### 📱 `activity_second.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="16dp"
    android:orientation="vertical">

    <TextView android:id="@+id/tvResult" android:textSize="16sp"/>

</LinearLayout>
</ScrollView>
```

#### ⚙️ `SecondActivity.java`

```java
package com.example.membershipapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.tvResult);

        String data =
                "Name: " + getIntent().getStringExtra("name") +
                "\nGender: " + getIntent().getStringExtra("gender") +
                "\nCurrent Weight: " + getIntent().getStringExtra("cw") +
                "\nHeight: " + getIntent().getStringExtra("height") +
                "\nGoal Weight: " + getIntent().getStringExtra("gw") +
                "\nAge: " + getIntent().getStringExtra("age") +
                "\nPhone: " + getIntent().getStringExtra("phone") +
                "\nAddress: " + getIntent().getStringExtra("addr") +
                "\nTerms: " + getIntent().getStringExtra("terms");

        tv.setText(data);
    }
}
```

#### 📄 `Manifest.xml` (addition)

```xml
<activity android:name=".SecondActivity"/>
```

---

---

## Slip 20

### Q1. Create Android Program to Change the Image on the Screen. [10 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:src="@drawable/img1"/>

    <Button
        android:id="@+id/btnChange"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Change Image"
        android:layout_marginTop="20dp"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.imagechange;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button btn;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);
        btn = findViewById(R.id.btnChange);

        btn.setOnClickListener(v -> {

            if (!flag) {
                img.setImageResource(R.drawable.img2);
                flag = true;
            } else {
                img.setImageResource(R.drawable.img1);
                flag = false;
            }
        });
    }
}
```

> 📁 Add `img1.png` and `img2.png` to `res/drawable/`

---

### Q2. Demonstrate Array Adapter using List View to display list of Country. [20 Marks]

#### 📱 `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</LinearLayout>
```

#### ⚙️ `MainActivity.java`

```java
package com.example.countrylist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] countries = {
            "India", "USA", "UK", "Canada", "Australia"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );

        listView.setAdapter(adapter);
    }
}
```

---

*End of Android Programming Slips (01–20)*
