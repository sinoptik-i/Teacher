package sinoptik.teacher.Task.TaskWork;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import sinoptik.teacher.Pupil.PupTask;
import sinoptik.teacher.Pupil.PupTaskGroup;
import sinoptik.teacher.Pupil.Pupil;
import sinoptik.teacher.Task.BasicTasks.Abbreviated_multiplication_formulas;
import sinoptik.teacher.Task.BasicTasks.Eqation2_ac;
import sinoptik.teacher.Task.BasicTasks.Equation2_ab;
import sinoptik.teacher.Task.BasicTasks.Equation2_abc;
import sinoptik.teacher.Task.BasicTasks.Fractions1;
import sinoptik.teacher.Task.BasicTasks.Inequality1;
import sinoptik.teacher.Task.BasicTasks.Long_division;
import sinoptik.teacher.Task.BasicTasks.Long_multiplication;
import sinoptik.teacher.Task.BasicTasks.Multiplication_to_power_of_10;
import sinoptik.teacher.Task.BasicTasks.Triangle_2_angles_in_1_out;
import sinoptik.teacher.Task.BasicTasks.Triangle_3_angles_in;
import sinoptik.teacher.Task.BasicTasks.Triangle_median;
import sinoptik.teacher.Task.BasicTasks.Сolumn_addition;
import sinoptik.teacher.Task.BasicTasks.Сolumn_subtraction;
import sinoptik.teacher.Task.Task;
import sinoptik.teacher.Task.TaskChecker;

public class TaskFromCodeWorker {
    List<Task> allTasks;
  public  TaskFromCodeWorker(){
        allTasks= new ArrayList();
        allTasks.add(new Equation2_ab());
        allTasks.add(new Eqation2_ac());
        allTasks.add(new Equation2_abc());
        allTasks.add(new Abbreviated_multiplication_formulas());
        allTasks.add(new Fractions1());
        allTasks.add(new Inequality1());
        allTasks.add(new Long_division());
        allTasks.add(new Long_multiplication());
        allTasks.add(new Multiplication_to_power_of_10());
        allTasks.add(new Triangle_2_angles_in_1_out());
        allTasks.add(new Triangle_3_angles_in());
        allTasks.add(new Triangle_median());
        allTasks.add(new Сolumn_addition());
        allTasks.add(new Сolumn_subtraction());
        //----------------------

//      allTasks.add(new Equation2_ab());
//      allTasks.add(new Eqation2_ac());
//      allTasks.add(new Equation2_abc());
//      allTasks.add(new Abbreviated_multiplication_formulas());
//      allTasks.add(new Fractions1());
//      allTasks.add(new Inequality1());
//      allTasks.add(new Long_division());
//      allTasks.add(new Long_multiplication());
//      allTasks.add(new Multiplication_to_power_of_10());
//      allTasks.add(new Triangle_2_angles_in_1_out());
//      allTasks.add(new Triangle_3_angles_in());
//      allTasks.add(new Triangle_median());
//      allTasks.add(new Сolumn_addition());
//      allTasks.add(new Сolumn_subtraction());
//      allTasks.add(new Equation2_ab());
//      allTasks.add(new Eqation2_ac());
//      allTasks.add(new Equation2_abc());
//      allTasks.add(new Abbreviated_multiplication_formulas());
//      allTasks.add(new Fractions1());
//      allTasks.add(new Inequality1());
//      allTasks.add(new Long_division());
//      allTasks.add(new Long_multiplication());
//      allTasks.add(new Multiplication_to_power_of_10());
//      allTasks.add(new Triangle_2_angles_in_1_out());
//      allTasks.add(new Triangle_3_angles_in());
//      allTasks.add(new Triangle_median());
//      allTasks.add(new Сolumn_addition());
//      allTasks.add(new Сolumn_subtraction());
    }
    public List<PupTask> getEmptyPupTasks(){
        List<PupTask> tasks= new ArrayList<>();
        for (int i=0;i<allTasks.size();i++){
            tasks.add(new PupTask(i,0));
        }
        return tasks;
    }

    public List<TaskChecker> getTaskChecks(Pupil pupil){
        PupTaskGroup pupTaskGroup=pupil.getTaskGroup();

        Log.e("stlTFCW","pupTG "+pupTaskGroup+"; allTasks "+allTasks);

        if (pupTaskGroup==null) {
//        if (pupTaskGroup.getName()==null) {
         return getEmptyTaskCheckers();
      }
      else {
          return getPupilsTaskCheckers(pupil);
      }
    }

    List<TaskChecker> getEmptyTaskCheckers() {
        List<TaskChecker> taskCheckers = new ArrayList<>();
        for (int i = 0; i < allTasks.size(); i++) {
            taskCheckers.add(new TaskChecker(allTasks.get(i).getDescription(), false, 0));
        }
        return taskCheckers;
    }

    List<TaskChecker> getPupilsTaskCheckers(Pupil pupil) {
        List<TaskChecker> taskCheckers = new ArrayList<>();
        Log.e("stlTFCW"," "+pupil.getTaskGroup().getName());
        for (int i = 0; i < allTasks.size(); i++) {
            try {
                int count = pupil.getTaskGroup().getTasks().get(i);
                taskCheckers.add(new TaskChecker(allTasks.get(i).getDescription(),
                        count != 0, count));
            }
            catch (Exception ex){
               // Log.e("stlTFCW"," "+ i);
            }
        }
        return taskCheckers;
    }




    public List<Task> getAllTasks()
    {
        return allTasks;
    }

}
