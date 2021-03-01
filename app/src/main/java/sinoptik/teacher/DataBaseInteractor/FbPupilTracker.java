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

public class FbPupilTracker {
    private final DatabaseReference ref;

    public FbPupilTracker(DatabaseReference ref) {
        this.ref = ref;
    }

    public interface Callback {
        void onPupilsReceived(List<Pupil> allPupils);
    }

    void trackPupils(final FbPupilTracker.Callback callback) {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Pupil> allPupils = getPupils(dataSnapshot);
                callback.onPupilsReceived(allPupils);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    List<Pupil> getPupils(DataSnapshot dataSnapshot){
       List<Pupil> allPupils=new ArrayList<Pupil>();
        for (DataSnapshot d : dataSnapshot.getChildren()) {
            Pupil pupil=d.getValue(Pupil.class);
            allPupils.add(pupil);
        }
        return allPupils;
    }
}
