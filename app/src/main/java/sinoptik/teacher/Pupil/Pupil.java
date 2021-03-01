package sinoptik.teacher.Pupil;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Pupil  {
    String name;
    Integer grade;
   // List<PupTaskGroup> taskGroups;
    PupTaskGroup taskGroup;

    public Pupil(){}

    /*void addTask(int num,int count)
    {
        if(tasks==null){
            tasks=new ArrayList<PupTask>();
        }
        tasks.add(new PupTask(num,count));
    }
*/
    void changeCount(){}

    public Pupil(String name, Integer grade, PupTaskGroup taskGroup) {
        this.name = name;
        this.grade = grade;
        this.taskGroup = taskGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaskGroup(PupTaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }

    public PupTaskGroup getTaskGroup() {
        return taskGroup;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

}
