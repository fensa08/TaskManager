import ArrayListImplementation.ArrayListStack;
import tasks.BasicTask;
import tasks.ComplexTask;
import tasks.RiskyTask;
import tasks.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MainAppArrayList {


    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));




    public static ArrayListStack<Task> readTasks() throws IOException {

        ArrayListStack<Task> stackDS = new ArrayListStack<>();

        while(true){

            System.out.println("ENTER TASK NAME");
            String name = reader.readLine().trim();

            System.out.println("ENTER TASK DESCRIPTION");
            String description = reader.readLine().trim();

            System.out.println("ENTER THE RISK STATUS OF THE TASK:\n 1 - HIGH \t 2 - MEDIUM\t 3 - LOW");
            String choice = reader.readLine().trim();

            if(choice.isBlank() || name.isBlank() || description.isBlank() || (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))){
                System.out.println("WRONG INPUT - TRY AGAIN!");

                System.out.println("DO YOU WANT TO CONTINUE ?");
                System.out.println("1 - YES\t 2 - NO");

                if(reader.readLine().equals("2"))
                    break;

                continue;
            }

            if(choice.equals("1")){
                RiskyTask task = new RiskyTask(name,description);
                stackDS.push(task);
            }
            else if(choice.equals("2")){
                ComplexTask task = new ComplexTask(name,description);
                stackDS.push(task);
            }
            else{
                BasicTask task = new BasicTask(name,description);
                stackDS.push(task);
            }

            System.out.println("TASK ADDED!\n");
            System.out.println("DO YOU WANT TO CONTINUE ADDING TASKS?");
            System.out.println("1 - YES\t 2 - NO");

            if(reader.readLine().equals("2"))
                break;

        }
        return stackDS;

    }

    public static ArrayListStack<Task> generateFiveRandomTasks() throws IOException {
        ArrayListStack<Task> stackDS = new ArrayListStack<>();

        for(int i = 1; i <= 5; i++){

            Task task;
            String name = "RandomTask-" + i;
            String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
            int n = new Random().nextInt(3) + 1;
            if(n == 1){
                task = new RiskyTask(name,description);
                stackDS.push(task);
                continue;
            }
            if(n == 2){
                task = new ComplexTask(name, description);
                stackDS.push(task);
                continue;
            }
            if(n == 3){
                task = new BasicTask(name, description);
                stackDS.push(task);
                continue;
            }

        }
        return stackDS;
    }



    public static void main(String[] args) {


        // 1. Initialize Stack
        ArrayListStack<Task> stack = new ArrayListStack<>();


        // 2. Read tasks
        System.out.println(BLUE + "TASK PROCESSING APPLICATION DEVELOPED BY  STEFAN APOSTOLOVSKI\n ============== THIS IS ARRAY LIST IMPLEMENTATION ==============" + RESET);
        System.out.println("\n\n\n");

        // 3. Initialize TaskManager
        TaskManager taskManager = new TaskManager();


        // 4. Main Logic
        try {

            while (true) {
                System.out.println(String.format("CHOOSE YOUR PREFERRED OPTION: \n 1 - ADD TASKS  \t 2 - ADD 5 RANDOM TASKS \t 3 - EXIT  "));
                String input = reader.readLine().trim();
                if (!input.equals("1") && !input.equals("2") && !input.equals("3")){
                    System.out.println("WRONG INPUT! CHOOSE ONE OF 1, 2 OR 3");
                    continue;
                }
                else if (input.equals("1")) {
                    stack = readTasks();

                } else if (input.equals("2")) {
                     stack = generateFiveRandomTasks();
                } else {
                    System.out.println("FAREWELL!");
                    break;
                }

                System.out.println();
                while(!stack.isEmpty())
                    taskManager.processTask(stack.pop());

                System.out.println("\nTASK MANAGER HAS FINISHED HIS TASKS! DO YOU WISH TO CONTINUE?");
            }


        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


    }
}
