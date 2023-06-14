
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
public class TaskList {
    private LinkedList<Task> toDoItems;
    static Scanner sc = new Scanner(System.in);
    public TaskList() {
        this.toDoItems = new LinkedList<>();
    }

    public void removeToDoItem(int place) {
        this.toDoItems.remove(place);
    }

    public void autoPopulate() {
        this.toDoItems.add(0, new Task("Bañar al Perro", 3));
        this.toDoItems.add(1, new Task("Bañar al Gato", 7));
        this.toDoItems.add(2, new Task("Bañar al Caballo", 6, true));
    }
    public void updateItem() {
        // Prints the current task list
        printList();

        // Asks the user which task they want to update
        System.out.println("Which task number should be updated?");

        while (!sc.hasNextInt()) {
            System.out.println("That's not a number! Please enter a task number:");
            sc.next(); // discards the invalid input
        }

        int taskNumber = sc.nextInt();

        // Ensures that the task number is valid
        if (taskNumber < 1 || taskNumber > toDoItems.size()) {
            System.out.println("Invalid task number. No tasks were updated.");
            return;
        }

        // Gets the Task object that needs to be updated
        Task taskToUpdate = toDoItems.get(taskNumber - 1);



        // Updates the value of the Task
        taskToUpdate.setExpirationDate();

        // Lets the user know the task has been updated
        System.out.println("Task updated: ");
        printList();
    }

    public void addToDoItem() {
        System.out.println("What is the name of the new task?");
        sc.nextLine();
        String task = sc.nextLine();

        System.out.print("In How many days should it be completed?");
        int daysToDoIt = sc.nextInt();

        System.out.println("Do you want this task in a specific place?? " +
                "\n (0 = no, 1 = yes) ");
        String input = sc.next();

        while (!input.equals("0") && !input.equals("1")) {
            System.out.println("Invalid input! Please enter either 0 or 1.");
            input = sc.next();
        }

        if (input.equals("0")) {

            this.toDoItems.add(new Task(task, daysToDoIt));
            System.out.println("Task added: \n");
            printList();
        } else{

            System.out.println("Which is its priority. Here is the current task list: \n");
            printList();
            int order = sc.nextInt();
            sc.nextLine();
            this.toDoItems.add(order - 1, new Task(task, daysToDoIt));
            System.out.println("Task added: \n");
            printList();

        }
    }
    private void menuList() {
        System.out.println("What would you like to do? " +
                "\n 1= enter a new value " +
                "\n 2= delete a task" +
                "\n 3= update a task due date" +
                "\n 4= Show current tasks " +
                "\n 5= Autopopulate list"+
                "\n 6= exit");
    }

    private String inputValidator() {
        String input = sc.next();
        while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5")&& !input.equals("6")) {
            System.out.println("Invalid input. Please enter 1, 2, 3, 4, 5 or 6.");
            menuList();
            input = sc.next();
        }
        return input;
    }


    public void menu() {
        menuList();

        String input = inputValidator();

        while (!input.equals("6")) {
            switch(input){
                case "1":
                    this.addToDoItem();
                    menuList();
                    input = inputValidator();
                    break;
                case "2":
                    printList();
                    System.out.println("Which task number should be deleted");
                    int position = sc.nextInt();
                    this.removeToDoItem(position);
                    menuList();
                    input = inputValidator();
                    break;
                case "3":

                    updateItem();
                    menuList();
                    input = inputValidator();
                    break;
                case "4":
                    this.printList();
                    menuList();
                    input = inputValidator();
                    break;
                case "5":
                    autoPopulate();
                    menuList();
                    input = inputValidator();
                    break;
            }
        }
    }

    public void printList() {
        int counter=0;
        for(Object obj:this.toDoItems){
            counter++;
            System.out.println("task " + counter +", " + obj.toString() );
        }
    }
}
