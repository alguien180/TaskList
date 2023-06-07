import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
public class TaskList {
    private LinkedList<Task> toDoItems;
    public TaskList() {
        this.toDoItems = new LinkedList<>();
    }
    public void removeToDoItem(Task item) {
   //     TaskList.remove(item);
    }

    public void autoPopulate(){
        this.toDoItems.add(0,new Task("Bañar al Perro",3));
        this.toDoItems.add(1,new Task("Bañar al Gato",7));
        this.toDoItems.add(2,new Task("Bañar al Caballo",6, true));
    }/*
    public void addToDoItem(String task, Date expirationDate) {
        ToDoItem newItem = new ToDoItem(task, expirationDate);
        tasksToDo.add(newItem);
    }

        System.out.println("Do you want this task in a specific place?? (0 = no, 1 = yes) "  );
 if (inptu.equals("0") || input.equals("1")) {
        if(input.equals("0")){
            this.list.add(taskToAdd);
            printList();
        }else{
            System.out.println("Which is its priority in the current task list: \n");
            printList();
            int order = Main.sc.nextInt();
            this.list.add(order-1,taskToAdd );
            System.out.println("Task added: \n");
            printList();

        }
    } else {
        System.out.println("Invalid input! Please enter either 0 or 1.");
    }
    public void addTask(String task, int daysTillDue){
        System.out.println("What is the task to be added");
        Task newTask = new Task("Lavar al perro",  );




                }


    */
    public void printList(){
        int counter=0;
        for(Object obj:this.toDoItems){
            counter++;
            System.out.println("task " + counter +", " + obj.toString() );
        }
    }
}
