package sinoptik.teacher.Pupil.DisplayPupils;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import sinoptik.teacher.R;

public class PupilViewHolder extends RecyclerView.ViewHolder{

    Button push_me_bitch;
    public PupilViewHolder(View itemView) {
        super(itemView);
        push_me_bitch = (Button) itemView.findViewById(R.id.push_pupil);
    }
}
