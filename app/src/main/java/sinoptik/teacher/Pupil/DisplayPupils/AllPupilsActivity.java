package sinoptik.teacher.Pupil.DisplayPupils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.FirebaseDatabase;


import sinoptik.teacher.DataBaseInteractor.FirebaseInteractor;
import sinoptik.teacher.Pupil.Pupil;
import sinoptik.teacher.R;

public class AllPupilsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_pupils);
        RecyclerView recyclerView = findViewById(R.id.rv_select_pupil);
        FirebaseInteractor firebaseInteractor = new FirebaseInteractor();
        DatabaseReference myRef = firebaseInteractor.getPupilsReference();

        FirebaseRecyclerAdapter<Pupil, PupilViewHolder> adapter;

        adapter = new FirebaseRecyclerAdapter<Pupil, PupilViewHolder>
                (
                        Pupil.class,
                        R.layout.one_pupil_push,
                        PupilViewHolder.class,
                        myRef
                ) {

            @Override
            protected void populateViewHolder(PupilViewHolder pupilViewHolder, final Pupil pupil,final int position) {
                pupilViewHolder.push_me_bitch.setText(pupil.getName() + " " + pupil.getGrade());
                pupilViewHolder.push_me_bitch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatabaseReference itemRef = getRef(position);
                        Log.e("APsA","itemRef.getKey "+itemRef.getKey());

                        Intent intent = new Intent(AllPupilsActivity.this, DisplayOnePupil.class)
                                .putExtra("pupilKey", itemRef.getKey());
                        startActivity(intent);
                      //  String keyPupil=pupil.
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
    }
}