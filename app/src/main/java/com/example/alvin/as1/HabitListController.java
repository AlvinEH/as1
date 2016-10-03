package com.example.alvin.as1;

/**
 * Created by alvin on 10/2/2016.
 */
public class HabitListController {
    private static HabitList habitList = null;
    static public HabitList getHabitList() {
        if (habitList == null) {
            habitList = new HabitList();
        }
        return habitList;
    }
}
