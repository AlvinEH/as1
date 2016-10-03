
//					GNU GENERAL PUBLIC LICENSE
//					Version 3, 29 June 2007
//
//		Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
//		Everyone is permitted to copy and distribute verbatim copies
//		of this license document, but changing it is not allowed.
//
//		{HabitTracker}  Copyright (C) {2016}  {Alvin Huang}
//		This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
//		This is free software, and you are welcome to redistribute it
//		under certain conditions; type `show c' for details.

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
import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    protected ListView oldHabitsList;
    protected EditText bodyText;

    protected ArrayList<Habit> habitList = new ArrayList<Habit>();

    private ArrayAdapter<Habit> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oldHabitsList = (ListView) findViewById(R.id.HabitsView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Habit>(this,
                R.layout.new_habit_creation, habitList);
        oldHabitsList.setAdapter(adapter);
    }

    protected void onResume() {
        super.onResume();
        loadFromFile();
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();

            habitList = gson.fromJson(in,listType);

        } catch (FileNotFoundException e) {
			/* Create a brand new tweet list if we can't find the file. */
            habitList = new ArrayList<Habit>();
        }
    }


    public void NewHabit(View v) {
        Toast.makeText(this,"Adding New Habit", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, NewHabitCreationActivity.class);
        startActivity(intent);

    }

    public void habitDetails(View v) {
        Intent intent = new Intent(MainActivity.this, HabitDetailsActivity.class);
        startActivity(intent);
    }
}
