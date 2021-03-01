/*
package sinoptik.teacher.Task.BasicTasks;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import sinoptik.teacher.Task.Task;

public class Pythagorean_theorem extends Task {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String getTask() throws IOException {
        return Pifagor(new int[]{0, 0})[0];
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String[] Pifagor(int[] mod) throws IOException {
        String[] ret = new String[2];
        String[] S33;
        int[] ABC = new int[3];

        List<String> Q = Files.readAllLines(Paths.get("1.txt"));

        int st1 = rnd.nextInt(19)+1;

        S33 = Q.get(st1).split(" ");
        for (int i = 0; i < 3; i++)
            ABC[i] =  Integer.parseInt(S33[i]);
        st1 = rnd.nextInt(4);
        char A = 't', B = A, C = A;
        TreygName( A, B, C);
        ret[0] = "Постройте треугольник " + A + B + C + ". Угол " + A + " - прямой, ";
        switch (st1)
        {
            case 0:
                ret[0] += ""+(A);
                ret[0] += ""+(B) + "=" + ABC[1] + ", " + A + C + "=" + ABC[2] + ". Найдите " + B + C;
                ret[1] = ""+(ABC[0]);
                break;
            case 1:
                ret[0] += ""+(A);
                ret[0] += ""+(B) + "=" + ABC[1] + ", " + B + C + "=" + ABC[0] + ". Найдите " + A + C;
                ret[1] = ""+(ABC[2]);
                break;
            case 2:
                ret[0] += ""+(A);
                ret[0] += ""+(B) + "=" + ABC[2] + ", " + B + C + "=" + ABC[0] + ". Найдите " + A + C;
                ret[1] = ""+(ABC[1]);
                break;
        }
        return ret;
    }
}
*/