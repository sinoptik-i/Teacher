package sinoptik.teacher.Pupil;

import java.util.ArrayList;
import java.util.List;

import sinoptik.teacher.Task.Task;
import sinoptik.teacher.Task.TaskChecker;
import sinoptik.teacher.Task.TaskWork.TaskFromCodeWorker;

public class PupTaskGroup {
    private String name;
    private List<Integer> tasks;

    public void setTasks(List<Integer> tasks) {
        this.tasks = tasks;
    }

    public List<Integer> getTasks() {
        return tasks;
    }

//    public PupTaskGroup(String name, List<Integer> tasks) {
//
//        this.name = name;
//        this.tasks = tasks;
//    }

    public PupTaskGroup(String name, List<TaskChecker> taskCheckers) {
        this.name = name;
        tasks = new ArrayList<>();
        for (TaskChecker t : taskCheckers
        ) {
            tasks.add(t.getCount());
        }
    }

    public PupTaskGroup() {

    }
//    List<PupTask> tasks;
//    public PupTaskGroup(){
//        TaskFromCodeWorker taskFromCodeWorker=new TaskFromCodeWorker();
//        tasks=taskFromCodeWorker.getEmptyPupTasks();
//    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

/*
    public void setTasks(List<PupTask> tasks) {
        this.tasks = tasks;
    }
    public List<PupTask> getTasks() {
        return tasks;
    }
*/
}
