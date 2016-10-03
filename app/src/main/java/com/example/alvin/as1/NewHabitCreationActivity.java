package com.example.alvin.as1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
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


    public void mainActivity(View v) {
        finish();
    }
}
