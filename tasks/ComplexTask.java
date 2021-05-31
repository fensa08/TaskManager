package tasks;

public class ComplexTask extends Task{


    public final static String riskProbability = "MEDIUM";

    public ComplexTask(String name, String description) {
        super(name, description);
    }


    @Override
    public String getRiskProbability(){
        return new String(riskProbability);
    }

}
