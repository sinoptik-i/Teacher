package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Сolumn_addition extends Task {
    @Override
    public String getTask() {
        return Sell_Summ(new int[]{0, 0})[0];
    }

    public Сolumn_addition() {
        description="Сложение в столбик";
        answer_description="Запишите результат";
    }

    public String[] Sell_Summ(int[] mod)
    {
        String[] ret = new String[2];
        double summand_1 = rnd.nextInt(9860)+140 / Math.pow(10.0, rnd.nextInt(3)+1);
        double summand_2 = rnd.nextInt( 860)+140 / Math.pow(10.0, rnd.nextInt( 3)+1);
        ret[0] = "Вычьте в столбик: " + summand_1 + "+" + summand_2;
        ret[1] = ""+(summand_1 + summand_2);
        return ret;
    }
}
