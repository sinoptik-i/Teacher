package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Fractions1 extends Task {

    @Override
    public String getTask() {
        return drobi(new int[]{0, 0})[0];
    }

    public Fractions1() {
        description="Действия с дробями";
        answer_description="Оставьте поле пустым";
    }

    public String[] drobi(int[] mod) {
        String[] ret = new String[2];
        int f;
        f = rnd.nextInt(14) + 2;
        ret[0] = "a=";
        ret[0] += f;
        f = rnd.nextInt(14) + 2;
        ret[0] += ", b=";
        ret[0] += f;
        f = rnd.nextInt(14) + 2;
        ret[0] += ", c=";
        ret[0] += f;
        f = rnd.nextInt(14) + 2;
        ret[0] += ", d=";
        ret[0] += f;
        ret[0] += ".";
        ret[1] = "";
        return ret;
    }
}
