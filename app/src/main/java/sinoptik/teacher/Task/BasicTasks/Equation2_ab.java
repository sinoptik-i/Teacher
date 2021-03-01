package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Equation2_ab extends Task {
    @Override
    public String getTask() {
        return ab2Yr(new int[]{0, 0})[0];
    }

    public Equation2_ab() {
        description="Неполные квадратные уравнения ab";
        answer_description="Запишите корни через пробел в порядке возрастани";
    }


    public String[] ab2Yr(int[] mod) {
        int x1 = 0, a = 0;
        while (x1 == 0)
            x1 = (int) (Math.random() % 40) - 20;
        while (a == 0 || a == 1)
            a = (int) (Math.random() % 40) - 20;

        String[] ret = new String[2];

        if (x1 > 0)
            ret[1] = 0 + " " + x1;
        else
            ret[1] = x1 + " " + 0;

        if (a < 0)
            if ((int) (Math.random()%2) == 1) {
                ret[0] = a + "x<sup>2</sup>";
                if (x1 < 0)
                    ret[0] += -1 * a * x1 + "x";
                else
                    ret[0] += "+" + -1 * a * x1 + "x";
            }
        else
                ret[0] = -1 * a * x1 + "x" + a + "x<sup>2</sup>";
        else if ((int) (Math.random()%2) == 1) {
            ret[0] = a + "x<sup>2</sup>";
            if (x1 < 0)
                ret[0] += "+" + -1 * a * x1 + "x";
            else
                ret[0] += -1 * a * x1 + "x";
        }
        else
            ret[0] = -1 * a * x1 + "x" + "+" + a + "x<sup>2</sup>";
        ret[0] += "=0";
        return ret;
    }

}
