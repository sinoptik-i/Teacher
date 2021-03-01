package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Triangle_2_angles_in_1_out extends Task {
    @Override
    public String getTask() {
        return Ygl_treyg2in1out(new int[]{0, 0})[0];
    }

    public Triangle_2_angles_in_1_out() {
        description="Углы в треугольнике, 1 внешний";
        answer_description="Запишите результат";
    }

    public String[] Ygl_treyg2in1out(int[] mod) {
        String[] ret = new String[2];
        String names=triangleName();
        char name_S = names.charAt(0),
                name_Q = names.charAt(1),
                name_L = names.charAt(2);


        int S = rnd.nextInt(67) + 14, Q = rnd.nextInt(61) + 90, R = rnd.nextInt(4);
        ret[0] = "Постройте треугольник " + name_S + name_Q + name_L + ". Угол ";
        ret[0] += name_Q + "=?, угол " + name_S + "=" + S + ", внешний угол " + name_L + "=" + Q + ".";
        ret[1] = "" + (180 - (180 - Q + S));
        return ret;
    }
}
