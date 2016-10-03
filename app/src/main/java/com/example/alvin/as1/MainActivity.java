package com.example.alvin.as1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void NewHabit(View v) {
        Intent intent = new Intent(MainActivity.this, NewHabitCreationActivity.class);
        startActivity(intent);
    }

    public void habitDetails(View v) {
        Intent intent = new Intent(MainActivity.this, HabitDetailsActivity.class);
        startActivity(intent);
    }
}
