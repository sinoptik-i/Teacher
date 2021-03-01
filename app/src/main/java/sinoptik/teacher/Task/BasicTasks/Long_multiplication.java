package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Long_multiplication extends Task {
    @Override
    public String getTask() {
        return Sell_Multiplication(new int[]{0, 0})[0];
    }

    public String[] Sell_Multiplication(int[] mod) {
        String[] ret = new String[2];
        double multiplier_1 = rnd.nextInt(839) + 140 / Math.pow(10.0, rnd.nextInt(3) + 1);
        double multiplier_2 = rnd.nextInt(839) + 140 / Math.pow(10.0, rnd.nextInt(3) + 1);
        ret[0] = "Умножте в столбик: " + multiplier_1 + "*" + multiplier_2;
        ret[1] = multiplier_1 * multiplier_2 + "";
        return ret;
    }

    public Long_multiplication() {
        description="Умножение в столбик";
        answer_description="Запишите результат";
    }
}
