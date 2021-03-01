package sinoptik.teacher.Task.DisplayTasks;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

import sinoptik.teacher.Task.Task;
import sinoptik.teacher.Task.TaskWork.TaskFromCodeWorker;

public class Teacher_Pupil_Binder_Task {

    public List<Pair<Task,Boolean>> all_and_selected_Tasks(){
        TaskFromCodeWorker taskFromCodeWorker=new TaskFromCodeWorker();
        List<Pair<Task,Boolean>> aast=new ArrayList<Pair<Task, Boolean>>();

        for (Task t:
                taskFromCodeWorker.getAllTasks()
             ) {
            aast.add(new Pair<Task, Boolean>(t,false));

        }
        return aast;
    }
}
