package com.example.alvin.as1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewHabitCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_habit_creation);

        // Set the default date in the yyyy-mm-dd format for habit date
        EditText current_date_text = (EditText) findViewById( R.id.current_date );
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        current_date_text.setText(sdf.format(new Date() ));
    }

    public void addNewHabit(View v) {
        Toast.makeText(this, "New Habit Added", Toast.LENGTH_SHORT).show();
        HabitListController hlc = new HabitListController();
        EditText textView = (EditText) findViewById(R.id.HabitName);
        hlc.addHabit(new Habit(textView.getText().toString()));
        finish();
    }

    public void cancelHabitCreation(View v) {
        Toast.makeText(this,"New Habit Creation Cancelled", Toast.LENGTH_SHORT).show();
        finish();
    }
}
