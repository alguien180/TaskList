import java.util.Calendar;
import java.util.Date;

import java.util.Scanner;

public class Task {
    static Date fecha = new Date();
    static Calendar day = Calendar.getInstance();
    static Scanner sc = new Scanner(System.in);
    private String task;
    private boolean isCompleted=false;
    private Date expirationDate;


public Task(String task, int isDueIn){
    this.task = task;
    day.add(Calendar.DAY_OF_MONTH,isDueIn);
    this.expirationDate = day.getTime();
}
    public Task(String task, int isDueIn, boolean isCompleted){
        this.task = task;
        day.add(Calendar.DAY_OF_MONTH,isDueIn);
        this.expirationDate = day.getTime();
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        if (isCompleted == false) {
            return "Task{" +
                    task + '\'' +
                    ", task is in progress" +
                    ", Task is due in " + expirationDate.getDay() +
                    " days" + '}';
        } else {
            return "Task{" +
                    "task='" + task + '\'' +
                    ", task completed" + '}';
        }
    }
}
