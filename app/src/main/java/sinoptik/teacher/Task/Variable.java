package sinoptik.teacher.Task;

import android.util.Pair;

public class Variable implements PartOfTask{

    public Variable(){
    }

    public Variable(double value, Pair<Double, Double> range, String name) {
        this.value = value;
        this.range = range;
        this.name = name;
    }

    double value;
    Pair<Double,Double> range;
    String name;

    @Override
    public String getString() {
        return value+"";
    }
}
