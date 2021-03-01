package sinoptik.teacher.Task.DisplayTasks;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sin.math.teachlibrary.SimpleTextWatcher;
import sinoptik.teacher.Pupil.PupTaskGroup;
import sinoptik.teacher.R;
import sinoptik.teacher.Task.Task;
import sinoptik.teacher.Task.TaskChecker;

public class CheckTaskAdapter extends RecyclerView.Adapter {

    List<TaskChecker> taskCheckers;

    public void setTaskCheckers(List<TaskChecker> taskCheckers) {
        StringBuilder checkedTasks = new StringBuilder();
        for (TaskChecker taskChecker : taskCheckers) {
            if (taskChecker.getChecked())
                checkedTasks.append(taskChecker.getName())
                        .append(";");
        }
        Log.e("EEE", "setTaskCheckers " + checkedTasks);

        this.taskCheckers = taskCheckers;
        notifyDataSetChanged();
    }

    public List<TaskChecker> getTaskCheckers() {
        return taskCheckers;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_task_check_layout, parent, false);
        final ViewHolder holder = new CheckTaskAdapter.ViewHolder(view);

        holder.chbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int position = holder.getAdapterPosition();
                if (checkPosition(position)) {
                    TaskChecker taskChecker = taskCheckers.get(position);
                    taskChecker.setChecked(isChecked);
                }
            }
        });

        holder.etCount.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                int position = holder.getAdapterPosition();
                if (checkPosition(position)) {
                    TaskChecker taskChecker = taskCheckers.get(position);
                    taskChecker.setCount(Integer.parseInt(editable.toString()));
                }
            }
        });

        return holder;
    }

    boolean checkPosition(int position) {
        if (position >= 0 && position < taskCheckers.size())
            return true;
        else
            return false;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CheckTaskAdapter.ViewHolder) holder).bindItem(taskCheckers.get(position));

    }

    @Override
    public int getItemCount() {
        return taskCheckers == null ? 0 : taskCheckers.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox chbSelect;
        private EditText etCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chbSelect = itemView.findViewById(R.id.taskChecked);
            etCount = itemView.findViewById(R.id.countTask);
        }

        void bindItem(final TaskChecker taskChecker) {
            // Log.e("EEE", "bindItem " + taskChecker.getName() + " isChecked - " + taskChecker.getChecked());
            chbSelect.setText(taskChecker.getName());
//            chbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                    taskChecker.setChecked(isChecked);
//                }
//            });
            chbSelect.setChecked(taskChecker.getChecked());

//            etCount.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable editable) {
//                    try {
//                        taskChecker.setCount(Integer.parseInt(editable.toString()));
//                    } catch (NumberFormatException e) {
//                        Log.e("CTA", " " + e.getMessage());
//                    }
//                }
//            });
            etCount.setText(taskChecker.getCount().toString());
        }

    }

}
