package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Multiplication_to_power_of_10 extends Task {

    @Override
    public String getTask() {
        return mult10(new int[]{0, 0})[0];
    }

    public Multiplication_to_power_of_10() {
        description="Умножение/деление на 10^n";
        answer_description="Запишите результат, отделяя целую часть от дробной точкой";
    }

    public String[] mult10(int[] n) {
        String[] ret = new String[2];
        double a, b;
        int f;
        f = rnd.nextInt(9990) + 2;
        a = rnd.nextInt(f) + 1;
        f = rnd.nextInt(4) + 1;

        b = Math.pow(10, f);
        a = a / b;
        f = rnd.nextInt(4) + 1;
        b = Math.pow(10.0, f);
        if (n[0] % 2 == 0) {
            ret[0] = a + ":" + b;
            ret[1] = "" + (a / b);
        } else {
            ret[0] = a + "*" + b;
            ret[1] = "" + (a * b);
        }
        return ret;
    }
}
