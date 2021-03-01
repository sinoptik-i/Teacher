package sinoptik.teacher.Pupil.DisplayPupils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sinoptik.teacher.Pupil.Pupil;
import sinoptik.teacher.R;
import sinoptik.teacher.Task.DisplayTasks.TaskListSelectionActivity;
import sinoptik.teacher.ui.login.LoginActivity;

public class TaskGroupsActivity extends AppCompatActivity {

    TextView tv_taskgroup_name;
    Button button_add_taskgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_groups);

        tv_taskgroup_name=findViewById(R.id.tv_taskgroup_name);
        Pupil pupil= new Pupil("Fedor",8,null);
        if(pupil.getTaskGroup()!=null){
            tv_taskgroup_name.setText(pupil.getTaskGroup().getName());
        }

        button_add_taskgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskGroupsActivity.this,
                        TaskListSelectionActivity.class);
                startActivity(intent);
                //send pupil?
            }
        });
    }
}