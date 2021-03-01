package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Inequality1 extends Task {

    @Override
    public String getTask() {
        return nerav_lin(new int[]{0, 0})[0];
    }

    public Inequality1() {
        description="Линейные неравенства";
        answer_description="Запишите результат в формате x<a или x>a";
    }

    public String[] nerav_lin(int[] mod) {
        String[] ret = new String[2];

        int a = 0, b = 0, c = 0, d = 0;
        while (a == 0 || a == 1 || a == -1)
            a = rnd.nextInt()%55;
        while (b == 0 || b == 1 || b == -1)
            b = rnd.nextInt()%10;
        while (c == 0 || c == 1 || c == -1)
            c = rnd.nextInt()%11+1;
        while (d == 0 || d == 1 || d == -1 || d == b)
            d = rnd.nextInt()%10;
        char Znak = randChar("<>");
        ret[0] = (b + d) + "x";
        if (c > 0)
            ret[0] += "+";

        ret[0] += c;
        ret[0] += Znak;
        ret[0] += (a * b + c);

        if (d > 0)
            ret[0] += "+";
        ret[0] += d + "x";

        if ((b + d) - d < 0)
            Znak = Smen_Znak(Znak);

        ret[1] = "x" + Znak + a;

        //ret[0] += " " + ret[1];
        return ret;
    }
}
