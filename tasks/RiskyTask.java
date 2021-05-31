package tasks;

public class RiskyTask  extends  Task{

    public final static String riskProbability = "HIGH";

    public RiskyTask(String name, String description) {
        super(name,description);
    }

    @Override
    public String getRiskProbability(){
        return new String(riskProbability);
    }

}
