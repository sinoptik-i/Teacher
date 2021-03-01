package sinoptik.teacher.Task.BasicTasks;

import sinoptik.teacher.Task.Task;

public class Abbreviated_multiplication_formulas extends Task {

    @Override
    public String getTask() {
        return FSY1(new int[]{0, 0})[0];
    }

    public String[] FSY1(int[] mod)    {
        String[] ret = new String[2];
        //(x+b)2+ax(x+c)

        double a = 0, b = 0, c = 0, x = 0;
        while(a==0)
            a = rnd.nextInt()%10;
        while (b == 0)
            b = rnd.nextInt()%10;
        while (c == 0)
            c = rnd.nextInt()%10;
        while (x == 0)
            x = rnd.nextInt()%10;
        ret[0] = "Вычислите (x";
        if (b > 0)
            ret[0] += "+";
        ret[0] += b + ")<sup>2</sup>";
        if (a > 0)
            ret[0]+="+";
        ret[0] += a + "x(x";
        if (c > 0)
            ret[0] += "+";
        ret[0] += c + ") при x =" + x;
        ret[1] = (x + b) * (x + b) + a * x * (x + c)+"";
        return ret;
    }

    public Abbreviated_multiplication_formulas(){
        description="Формулы сокращенного умножения";
        answer_description="Запишите результат";
    }

}
