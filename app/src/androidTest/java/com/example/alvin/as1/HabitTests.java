package com.example.alvin.as1;
import junit.framework.TestCase;
import java.util.Collection;

/**
 * Created by alvin on 10/2/2016.
 */
public class HabitTests extends TestCase {


    public void testHabitName() {
        String habitName = "Write one test a day";
        Habit habit = new Habit(habitName);
        assertTrue("habitName inside habit is equal to habitName", habitName.equals(habit.getHabitName()));
    }

    public void testEmptyHabitList() {
        HabitList habitList = new HabitList();
        Collection<Habit> habits = habitList.getHabits();
        assertTrue("No habits", habits.size() == 0);
    }
    public void testAddHabit() {
        HabitList habitList = new HabitList();
        String habitName = "Random Habit";
        Habit habit = new Habit(habitName);
        habitList.addHabit(habit);
        Collection<Habit> habits = habitList.getHabits();
        assertTrue("One habit is inside the list", habits.size() == 1);
        assertTrue("habit is contained inside the list", habits.contains(habit));
    }
    public void testDeleteHabit() {
        HabitList habitList = new HabitList();
        String habitName = "Random Habit";
        Habit habit = new Habit(habitName);
        habitList.addHabit(habit);
        Collection<Habit> habits = habitList.getHabits();
        assertTrue("habit is contained in the list", habits.contains(habit));
        habitList.deleteHabit(habit);
        habits = habitList.getHabits();
        assertFalse("No matching habit inside the list", habits.contains(habit));
    }


}
