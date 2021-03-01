
package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Triangle_median extends Task {
    @Override
    public String getTask() {
        return Treyg_mediana(new int[]{0, 0})[0];
    }

    public Triangle_median() {
        description="Медиана в треугольнике";
        answer_description="Запишите результат";
    }

    public String[] Treyg_mediana(int[] mod)
    {
        String[] ret = new String[2];

        String names=triangleName();
        char name_S = names.charAt(0),
                name_Q = names.charAt(1),
                name_L = names.charAt(2);

        char med = (char)(rnd.nextInt(26)+65);

        ret[0] = "Постройте треугольник " + name_S + name_Q + name_L + ". Проведите медиану " + name_Q + med + ". ";
        int R = rnd.nextInt(5), SL = rnd.nextInt(64)+4 * 2;

        if (R == 1)
        {
            ret[0] += name_S;
            ret[0] += med + "=" + SL / 2 + ". Найдите " + name_S + name_L + ".";
            ret[1] = ""+(SL);
        }
        else if (R == 2)
        {
            ret[0] += name_S;
            ret[0] += name_L + "=" + SL + ". Найдите " + name_S + med + ".";
            ret[1] = ""+(SL / 2);
        }
        else
        {
            ret[0] += name_S;
            ret[0] += name_L + "=" + SL + ". Найдите " + med + name_L + ".";
            ret[1] = ""+(SL / 2);
        }
        return ret;
    }
}
