package sinoptik.teacher.Task;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public abstract class Task {
    protected String name;
    protected Random rnd;

    public Task() {
        rnd = new Random();
    }

    //protected List<PartOfTask> partOfTaskList;
    protected String description;// не здесь
    protected String answer_description;

    public abstract String getTask();// throws IOException;// нужно ли этот метод выделить в отдельный класс?

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getAnswer_description() {
        return answer_description;
    }

    char randZnak(int n) {
        char c;
        int f = rnd.nextInt(n);
        if (f == 0) c = '+';
        else if (f == 1) c = '-';
        else if (f == 2) c = '*';
        else c = '/';
        return c;
    }

    protected char randChar(String arr) {
        int f = rnd.nextInt(arr.length());
        return (char) arr.charAt(f);
    }

    protected char Smen_Znak(char Z) {
        if (Z == '>')
            return '<';
        else
            return '>';
    }

    protected String triangleName() {
        char A, B,  C;
        A = (char) (rnd.nextInt(26)+65);
        B = A;
        C = A;
        while (A == B || B == C || A == C) {
            B =(char)(rnd.nextInt(26)+65);
            C = (char)(rnd.nextInt(26)+65);
        }
        return A+B+C+"";
    }

    void sokr(double ch, double zn) {
        double min = ch;
        if (ch > zn)
            min = zn;
        for (int i = (int) min; i > 1; i--) {
            if (ch % i == 0 && zn % i == 0) {
                ch /= i;
                zn /= i;
            }
        }
    }


}
