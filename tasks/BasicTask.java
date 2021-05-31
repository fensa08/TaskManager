package tasks;

import java.util.Random;

public class BasicTask extends Task {

    public final static String riskProbability = "LOW";

    public BasicTask(String name, String description) {
        super(name,description);
    }

    public String getRiskProbability(){
        return new String(riskProbability);
    }



}
