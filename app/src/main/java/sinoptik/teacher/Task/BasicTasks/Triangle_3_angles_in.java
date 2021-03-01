package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Triangle_3_angles_in extends Task {
    public Triangle_3_angles_in() {
        description="Углы в треугольнике. 3 внутренних";
        answer_description="Запишите результат";
    }

    @Override
    public String getTask() {
        return Ygl_treyg3in(new int[]{0, 0})[0];
    }
    public String[] Ygl_treyg3in(int[] mod)
    {
        String[] ret = new String[2];
        int P = rnd.nextInt(67) + 14, D = rnd.nextInt(71)+20, R = rnd.nextInt(4);
        ret[0] = "Постройте треугольник PDF. Угол ";
        if (R == 0)
            ret[0] += "D=?, P=" + P + ", F=" + D;
        else if (R == 1)
            ret[0] += "P=?, F=" + P + ", D=" + D;
        else
            ret[0] += "F=?, D=" + P + ", P=" + D;
        ret[0] += ".";
        ret[1] = ""+(180 - P - D);
        return ret;
    }
}
