import tasks.Task;
import tasks.TaskStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TaskManager {

    private boolean calculateSuccessOfTask(Task task){

        if(task.getRiskProbability().equals("HIGH"))
            return false;

        if(task.getRiskProbability().equals("LOW"))
            return true;


        if((new Random().nextInt(2) + 1)%2 == 0)
            return true;
        return false;

    }

    public void processTask(Task task ){

        System.out.println("PROCESSING NEW TASK ...\t");


        if (calculateSuccessOfTask(task)) {
            task.setStatus(TaskStatus.PROCESSED);
        } else {
            task.setStatus(TaskStatus.FAILED);
        }

        System.out.println(String.format("TaskName: %s with id: %d is %s  ",
                task.getName(), task.getId(),task.getStatus().toString().toLowerCase()));
        System.out.println(String.format("TaskDescription: %s", task.getDescription()));
        System.out.println();
    }

}
