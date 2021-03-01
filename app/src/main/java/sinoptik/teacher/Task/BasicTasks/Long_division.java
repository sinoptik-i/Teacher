package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Long_division extends Task {
    @Override
    public String getTask() {
        return Sell_Segmentation2(new int[]{0, 0})[0];
    }
    public String[] Sell_Segmentation2(int[] mod)
    {
        String[] ret = new String[2];
        double multiplier_1 = rnd.nextInt(89)+10;
        double add_null = 1000;
        multiplier_1 *= add_null;
        multiplier_1 += rnd.nextInt(89)+10;
        multiplier_1 /= Math.pow(10.0, rnd.nextInt( 3)+1);

        double multiplier_2 = rnd.nextInt(9)+2 / Math.pow(10.0, rnd.nextInt( 3));

        ret[0] = "Разделите в столбик: " + (multiplier_1 * multiplier_2) + "/" + multiplier_2;
        ret[1] = (multiplier_1 * multiplier_2) + "/" + multiplier_2+"";
        return ret;
    }

    public Long_division() {
        description="Деление в столбик";
        answer_description="Запишите результат";
    }
}
