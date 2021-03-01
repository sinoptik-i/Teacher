package sinoptik.teacher.DataBaseInteractor;

import java.util.List;

import sinoptik.teacher.Task.MutableTask;

public interface DataBaseIneractor {

    //public Task getTask(Integer numOfTask);

    public List<MutableTask> getAllTasks();

    public void addTask(MutableTask task);




}
