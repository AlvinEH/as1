package com.example.alvin.as1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alvin on 10/2/2016.
 */
public class HabitList {

    protected ArrayList<Habit> habitList;

    public HabitList() {
        habitList = new ArrayList<Habit>();
    }

    public Collection<Habit> getHabits() {
        return habitList;
    }

    public void addHabit(Habit habit) {
         habitList.add(habit);
    }

    public void deleteHabit(Habit habit) {
        habitList.remove(habit);
    }
}
