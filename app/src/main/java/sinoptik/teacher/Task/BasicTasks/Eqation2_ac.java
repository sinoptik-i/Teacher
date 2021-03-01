package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Eqation2_ac extends Task {
    @Override
    public String getTask() {
        return ac2Yr(new int[]{0, 0})[0];
    }
    public Eqation2_ac(){
        description="Неполные квадратные уравнения ac";
        answer_description="Запишите корни через пробел в порядке возрастания";
        name=description;
    }


    public String[] ac2Yr(int[] mod) {
        int x1 = rnd.nextInt(18) + 2;
        int a = rnd.nextInt(3) + 2;
        String[] ret = new String[2];
        ret[1] = -x1 + " " + x1;
        if (rnd.nextInt(2) == 0)
            ret[0] = a + "x<sup>2</sup>" + "-" + a * x1 * x1;
        else
            ret[0] = a * x1 * x1 + "-" + a + "x<sup>2</sup>";
        ret[0] += "=0";
        return ret;
    }
}
