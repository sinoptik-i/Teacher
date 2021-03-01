package sinoptik.teacher.Pupil.DisplayPupils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import sinoptik.teacher.DataBaseInteractor.FbOnePupilTracker;
import sinoptik.teacher.DataBaseInteractor.FirebaseInteractor;
import sinoptik.teacher.Pupil.Pupil;
import sinoptik.teacher.R;
import sinoptik.teacher.Task.DisplayTasks.TaskListSelectionActivity;

public class DisplayOnePupil extends AppCompatActivity implements View.OnClickListener {


    DatabaseReference onePupilRef;
    TextView pupName;
    FbOnePupilTracker tracker;
    String pupilKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_one_pupil);

        init();
        trackOnePupil();

    }

    void trackOnePupil(){
        tracker.trackPupil(new FbOnePupilTracker.Callback() {
            @Override
            public void onPupilReceived(final Pupil pupil) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.e("DOP","onePupilRef " +onePupilRef);
                            pupName.setText(pupil.getName());
                        } catch (Exception ex) {
                            Log.e("DOP", "ex " + ex.getMessage());
                        }
                    }

                });
            }
        });
    }

    void init(){
        pupName=findViewById(R.id.one_pupil_name);
        findViewById(R.id.button_change_pupil).setOnClickListener(this);
        findViewById(R.id.button_task_groups).setOnClickListener(this);
        findViewById(R.id.button_results).setOnClickListener(this);
        findViewById(R.id.button_tests).setOnClickListener(this);

        pupilKey = getIntent() == null ? null : getIntent().getStringExtra("pupilKey");
        Log.e("DOP"," "+pupilKey);
        onePupilRef= FirebaseInteractor.getInstance().getOnePupilReference(pupilKey);
        tracker= new FbOnePupilTracker(onePupilRef);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_task_groups:
                Intent intent= new Intent(this, TaskListSelectionActivity.class)
                        .putExtra("pupilKey",pupilKey);
                startActivity(intent);

            break;
        }

    }
}

