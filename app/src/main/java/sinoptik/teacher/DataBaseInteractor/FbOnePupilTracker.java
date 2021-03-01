package sinoptik.teacher.DataBaseInteractor;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import sinoptik.teacher.Pupil.Pupil;

public class FbOnePupilTracker {
    private final DatabaseReference ref;

    public FbOnePupilTracker(DatabaseReference ref) {
        this.ref = ref;
    }

    public interface Callback {
        void onPupilReceived(Pupil pupil);
    }

   public void trackPupil(final FbOnePupilTracker.Callback callback) {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("FOPT","dataSnapshot "+dataSnapshot);
               Pupil pupil = getPupil(dataSnapshot);
                callback.onPupilReceived(pupil);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    Pupil getPupil(DataSnapshot dataSnapshot){
        //Pupil pupil= new Pupil();
        Pupil pupil=dataSnapshot.getValue(Pupil.class);
        return pupil;
    }
}
