package tasks;

public abstract class Task {



    private String name;
    private long id;
    private String description;
    private TaskStatus status;
    private boolean isProcessed;


    public Task(String name, String description){
        this.name = name;
        this.description = description;
        this.id = (long) (Math.random() * 100000);
        this.isProcessed = false;
        this.status = TaskStatus.NOT_PROCESSED;
    }


    public abstract String getRiskProbability();

    public String getName() {
        return new String(this.name);
    }


    public long getId() {
        return this.id;
    }


    public String getDescription() {
        return new String(this.description);
    }


    public TaskStatus getStatus() {
        return status;
    }


    public void setStatus(TaskStatus status) {
        this.status = status;
    }


    @Override
    public String toString(){
        return "TaskName: \"" + this.name + "\"  with id: " + this.id + " " + ((isProcessed)? "has been processed" : " has failed");
    }


}
