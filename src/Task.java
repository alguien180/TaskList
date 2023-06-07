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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        if (isCompleted == false) {
            return
                    task + '\'' +
                            ", is in progress" +
                            ", due in " + expirationDate.getDay() +
                            " days" + '}';
        } else {
            return  "task '" + task + '\'' +
                    ", task completed" + '}';
        }
    }
}
