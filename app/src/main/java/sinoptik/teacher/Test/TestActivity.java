package sinoptik.teacher.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import sinoptik.teacher.PhoneSaver.PhoneSaver;
import sinoptik.teacher.Pupil.PupTask;
import sinoptik.teacher.Pupil.PupTaskGroup;
import sinoptik.teacher.Pupil.Pupil;
import sinoptik.teacher.R;

public class TestActivity extends AppCompatActivity {

    private  final String TAG = this.getClass().getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

     



    }

    void testPhoneSaver(){
        PhoneSaver ps=new PhoneSaver(TestActivity.this);

        List<PupTask> foo = new ArrayList<PupTask>();
        foo.add(new PupTask(0,3));
        foo.add(new PupTask(1,2));
        foo.add(new PupTask(5,8));

        PupTaskGroup pupTaskGroup= new PupTaskGroup();
        pupTaskGroup.setName("First PupTG");
       // pupTaskGroup.setTasks(foo);

        Pupil pupil=new Pupil();
        pupil.setName("name");
        pupil.setGrade(3);
        pupil.setTaskGroup(pupTaskGroup);

        List<Pupil> pupils=ps.getPUPILS();
        Log.e(TAG, "pupils: "+pupils.toString()+" "+
                pupils.get(2).getTaskGroup().getName());


        /*
        pupils.add(pupil);
        pupils.add(pupil);
        pupils.add(pupil);

        ps.setPUPILS(pupils);
*/

/*
        String json = new Gson().toJson(pupTaskGroup );
        Log.e(TAG, "json "+json);

        PupTaskGroup ptg2=new Gson().fromJson(json,PupTaskGroup.class);
        Log.e(TAG, "need 2: "+ptg2.getTasks().get(1).getCount());
*/
    }
}