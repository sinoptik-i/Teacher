package sinoptik.teacher.DataBaseInteractor;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import sinoptik.teacher.Pupil.PupTaskGroup;
import sinoptik.teacher.Pupil.Pupil;
import sinoptik.teacher.Task.MutableTask;
import sinoptik.teacher.Task.Task;

public class FirebaseInteractor{//} implements DataBaseIneractor{//singleton?

    private  final String TAG = "FirebaseInteractor";


    FirebaseDatabase database;
    DatabaseReference myRef;
    String keyTeacher;

    public FirebaseInteractor() {
        database = FirebaseDatabase.getInstance();
        keyTeacher= FirebaseAuth.getInstance().getUid();
    }
    public DatabaseReference getPupilsReference(){
        return database.getReference("pupils/"+keyTeacher+"/pupils");
    }

    public DatabaseReference getOnePupilReference(String pupilKey){
        return database.getReference("pupils/"+keyTeacher+"/pupils/"+pupilKey);
    }

    public List<Task> getAllTasks() {
        return null;
    }

    public List<Pupil> getPupils(){
        myRef = database.getReference("pupils/"+keyTeacher+"/pupils");
        FbPupilTracker tracker=new FbPupilTracker(myRef);
        tracker.trackPupils(new FbPupilTracker.Callback() {
            @Override
            public void onPupilsReceived(List<Pupil> allPupils) {
            }
        });
        return null;
    }

    public void saveOnePupilTasks(String pupilkey, PupTaskGroup pupTaskGroup){
//        myRef = database.getReference("pupils/"+
//                keyTeacher+"/pupils/"+pupilkey);//+"/");
        myRef=getPupilsReference();
        myRef.child(pupilkey).child("taskGroup").setValue(pupTaskGroup);
    }


    public void addPupil(Pupil pupil){
        myRef = database.getReference("pupils/"+keyTeacher+"/pupils");
        myRef.push().setValue(pupil);
    }

    public void changePupil(Pupil pupil,String pupilKey){
        DatabaseReference pupsref=getPupilsReference();
        pupsref.child(pupilKey).setValue(pupil);
    }
    public void removePupil(String pupilKey){
        DatabaseReference pupref=getOnePupilReference(pupilKey);
        pupref.removeValue();
    }

    public void addTask(Task task) {
        myRef = database.getReference("teachers/"+keyTeacher+"/tasks");
        myRef.push().setValue(task);
    }


    private static FirebaseInteractor instance;
    public static FirebaseInteractor getInstance() {
        if (instance == null) {
            instance = new FirebaseInteractor();

        }
        return instance;
    }

}
