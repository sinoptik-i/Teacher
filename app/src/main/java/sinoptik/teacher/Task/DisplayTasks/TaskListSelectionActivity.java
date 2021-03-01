package sinoptik.teacher.Task.DisplayTasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

import sinoptik.teacher.DataBaseInteractor.FbOnePupilTracker;
import sinoptik.teacher.DataBaseInteractor.FirebaseInteractor;
import sinoptik.teacher.Pupil.DisplayPupils.TaskGroupsActivity;
import sinoptik.teacher.Pupil.PupTaskGroup;
import sinoptik.teacher.Pupil.Pupil;
import sinoptik.teacher.R;
import sinoptik.teacher.Task.TaskChecker;
import sinoptik.teacher.Task.TaskWork.TaskFromCodeWorker;

public class TaskListSelectionActivity extends AppCompatActivity {

    DatabaseReference onePupilRef;
    TextView pupName;
    private RecyclerView recyclerView;
    private CheckTaskAdapter checkTaskAdapter;
    FbOnePupilTracker tracker;
    String pupilKey;
    Pupil localPupil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list_selection);
        init_comp();
      //  Teacher_Pupil_Binder_Task tpbt = new Teacher_Pupil_Binder_Task();// mb need dagger?
        //checkTaskAdapter.setTpbt(tpbt);
        Log.e("TLSActivity", " " + checkTaskAdapter.getItemCount());

        Button button_select_atls=findViewById(R.id.button_select_atls);

        button_select_atls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskChecker tch=checkTaskAdapter.getTaskCheckers().get(0);
                TaskChecker tch2=checkTaskAdapter.getTaskCheckers().get(2);
                Log.e("TLSA","0) "+tch.getName()+" "+tch.getChecked()
                        +" "+tch.getCount());
                Log.e("TLSA","2) "+tch2.getName()+" "+tch2.getChecked()
                        +" "+tch2.getCount());
                if(pupilKey!=null){
                    PupTaskGroup pupTaskGroup= new PupTaskGroup("TaskGroup",
                            checkTaskAdapter.getTaskCheckers());
                    try {
                        localPupil.setTaskGroup(pupTaskGroup);
//                        FirebaseInteractor.getInstance().changePupil(localPupil,pupilKey);
                      //  FirebaseInteractor.getInstance().removePupil(pupilKey);
                       // FirebaseInteractor.getInstance().addPupil(localPupil);
                        FirebaseInteractor.getInstance().saveOnePupilTasks(pupilKey,pupTaskGroup);
                    }
                    catch (Exception ex){
                        Log.e("LTSA", ex.getMessage());
                    }

                }
           /*     tch=checkTaskAdapter.getTaskCheckers().get(0);
                tch.setCount(33);
            List<TaskChecker> lt4=checkTaskAdapter.getTaskCheckers();
            lt4.set(1,tch);

            checkTaskAdapter.setTaskCheckers(lt4);
                Log.e("TLSA","0) "+tch.getName()+" "+tch.getChecked()
                        +" "+tch.getCount());*/
            }
        });
        download_Tasks();

    }

    void init_comp() {
        recyclerView = findViewById(R.id.rv_select_tasks);
        checkTaskAdapter = new CheckTaskAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(checkTaskAdapter);
        pupName=findViewById(R.id.atls_name_pupil);

        pupilKey = getIntent() == null ? null : getIntent().getStringExtra("pupilKey");
        onePupilRef= FirebaseInteractor.getInstance().getOnePupilReference(pupilKey);
        tracker= new FbOnePupilTracker(onePupilRef);
    }

    void download_Tasks(){
        tracker.trackPupil(new FbOnePupilTracker.Callback() {
            @Override
            public void onPupilReceived(final Pupil pupil) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            pupName.setText(pupil.getName());
                            TaskFromCodeWorker taskFromCodeWorker=new TaskFromCodeWorker();
                            localPupil=pupil;

                            List<TaskChecker> taskCheckers=taskFromCodeWorker.getTaskChecks(pupil);
                            Log.e("stlTLSA","TaskCh : "+pupil);

                            checkTaskAdapter.setTaskCheckers(taskCheckers);
                        } catch (Exception ex) {
                            Log.e("stlTLSA", "ex " + ex.getMessage());
                        }
                    }

                });
            }
        });
    }
}