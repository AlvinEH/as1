package com.example.alvin.as1;

import android.text.Editable;

/**
 * Created by alvin on 10/2/2016.
 */
public class Habit {
    protected String habitName;

    public Habit(String habitName) {
        this.habitName = habitName;
    }

    public String getHabitName() {
        return habitName;
    }
}
