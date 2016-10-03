package com.example.alvin.as1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private ListView oldHabitsList;
    protected EditText bodyText;

    private ArrayList<Habit> habitList = new ArrayList<Habit>();

    private ArrayAdapter<Habit> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bodyText = (EditText) findViewById(R.id.HabitName);
        oldHabitsList = (ListView) findViewById(R.id.HabitsView);

//        Button saveButton = (Button) findViewById(R.id.save_button_new_habit);
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                setResult(RESULT_OK);
//                String text = bodyText.getText().toString();
//                bodyText.setText("");
//
//                Habit newHabit = new Habit(text);
//
//                habitList.add(newHabit);
//                adapter.notifyDataSetChanged();
//
//                saveInFile();
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Habit>(this,
                R.layout.new_habit_creation, habitList);
        oldHabitsList.setAdapter(adapter);
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

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(habitList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
			/* Rethrow. */
            throw new RuntimeException(e);
        } catch (IOException e) {
			/* Rethrow. */
            throw new RuntimeException(e);
        }
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
