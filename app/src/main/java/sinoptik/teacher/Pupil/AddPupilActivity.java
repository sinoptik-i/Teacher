package sinoptik.teacher.Pupil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import sinoptik.teacher.DataBaseInteractor.FirebaseInteractor;
import sinoptik.teacher.R;
import sinoptik.teacher.ui.login.LoginActivity;

public class AddPupilActivity extends AppCompatActivity {

    FirebaseInteractor firebaseInteractor;// mb need dagger
    private  final String TAG = "AddPupilActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pupil);
        final Button namePupil = findViewById(R.id.button_name_pupil);
        final EditText etName = findViewById(R.id.et_pupil_name);
        final EditText etGrade = findViewById(R.id.et_pupil_grade);

        namePupil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e(TAG, "  loginButton");
                String name = etName.getText().toString();
                String grade = etGrade.getText().toString();
                if (name != "" && grade != "") {
                    boolean existsPupil = false;
                    if (!existsPupil) {
                        firebaseInteractor = new FirebaseInteractor();
                        Integer gradeInt=Integer.parseInt(grade);
                        Log.e(TAG,gradeInt+"");
                        firebaseInteractor.addPupil(new Pupil(name, gradeInt, null));
                        AddPupilActivity.this.finish();
                    }
                }
            }
        });
    }
}