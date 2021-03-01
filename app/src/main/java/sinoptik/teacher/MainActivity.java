package sinoptik.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import sinoptik.teacher.DataBaseInteractor.FirebaseInteractor;
import sinoptik.teacher.Pupil.AddPupilActivity;
import sinoptik.teacher.Pupil.DisplayPupils.AllPupilsActivity;
import sinoptik.teacher.Pupil.Pupil;
import sinoptik.teacher.Task.BasicTasks.Equation2_ab;
import sinoptik.teacher.Task.BasicTasks.Equation2_abc;
import sinoptik.teacher.Task.Task;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String em="Example_email@mail.ru";
    String passw="123456";
    private  final String TAG = "MainActivity";
//    Button buttonAddTask;

    FirebaseInteractor firebaseInteractor;// mb need dagger
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate");
        init();

    }
    void init(){
        findViewById(R.id.button_add_task_am).setOnClickListener(this);
        findViewById(R.id.button_add_pupil).setOnClickListener(this);
        findViewById(R.id.button_all_pupils).setOnClickListener(this);
        firebaseInteractor=new FirebaseInteractor();
    }

    @Override
    public void onClick(View view) {
        Log.e(TAG,view.getId()+" "+R.id.button_add_task_am);

        switch (view.getId()) {

            case R.id.button_add_task_am:
                Pupil pupil= new Pupil("Fedor",8,null);

             //   tryToAddTasks();
                break;
            case R.id.button_add_pupil:
                Intent intent1 = new Intent(this, AddPupilActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_all_pupils:
                Intent intent2 = new Intent(this, AllPupilsActivity.class);
                startActivity(intent2);
                break;


        }

    }

    void tryToAddTasks(){

//        Task t1=new Equation2_abc();
//        Task t2=new Equation2_ab();
//        firebaseInteractor.addTask(t1);
//        firebaseInteractor.addTask(t2);
//        Log.e(TAG, " tryToAddTasks");
    }

}