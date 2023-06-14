import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class Task {

    static Scanner sc = new Scanner(System.in);
    private String task;
    private boolean isCompleted=false;
    private LocalDate  expirationDate;


        public Task(String task, int isDueIn){
            this.task = task;
            this.expirationDate = LocalDate.now().plusDays(isDueIn);
        }

        public Task(String task, int isDueIn, boolean isCompleted){
            this.task = task;
            this.expirationDate = LocalDate.now().plusDays(isDueIn);
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate() {

        System.out.println("In how many days should the new task be accomplished?");

        while (!sc.hasNextInt()) {
            System.out.println("That's not a number! Please enter a number of days:");
            sc.next(); // discards the invalid input
        }
        int newDueDate = sc.nextInt();
        this.expirationDate = LocalDate.now().plusDays(newDueDate);
    }

    @Override
    public String toString() {
        int daysLeft = (int) ChronoUnit.DAYS.between(LocalDate.now(), this.expirationDate);
        if (isCompleted == false) {
            return
                    task + '\'' +
                            ", is in progress" +
                            ", due in " + daysLeft +
                            " days" + '}';
        } else {
            return  "task '" + task + '\'' +
                    ", task completed" + '}';
        }
    }
}
