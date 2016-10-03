package com.example.alvin.as1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HabitDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habit_details);
    }

    public void mainActivity(View v) {
        finish();
    }
}
