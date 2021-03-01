package sinoptik.teacher.Pupil;

public class PupTask {
    int num;
    int count;

    public PupTask(int num, int count) {
        this.num = num;
        this.count = count;
    }
    public PupTask(){}
    public void setNum(int num) {
        this.num = num;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public int getCount() {
        return count;
    }
}
