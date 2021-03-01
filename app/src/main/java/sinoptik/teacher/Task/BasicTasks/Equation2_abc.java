package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.BasicTask;
import sinoptik.teacher.Task.Task;
//import sinoptik.teacher.Task.Task;


public  class Equation2_abc extends Task {

    @Override
    public String getTask() {
        return abc2Yr(new int[]{0, 0})[0];
    }

    public Equation2_abc() {
        description="Полные квадратные уравнения";
        answer_description="Запишите корни через пробел в порядке возрастани";
    }

    public String[] abc2Yr(int[] mod){
        String[] ret = new String[2];
        int x1 = (int) (Math.random()%40)-20,x2;
        while (x1==0){
            x1 = (int) (Math.random()%40)-20;
        }
        x2=x1;
        while (
                //x2==x1 ||
            x2==0 || x1 == x2 * (-1)){
            x2 = (int) (Math.random()%40)-20;
        }

        if (x1 < x2)
            ret[1] = x1 + " " + x2;
        else
            ret[1] = x2 + " " + x1;

        int b = (x2 + x1) * -1;
        int c = x1 * x2;
        ret[0] = "x<sup>2</sup>";
        if (b > 0)
            ret[0] += "+";
        ret[0] += b + "x";
        if (c > 0)
            ret[0] += "+";
        ret[0] += c + "=0";
        return ret;
    }

}
