package sinoptik.teacher.Task;

import android.util.Log;

public class TaskChecker {
    String name;
    Boolean checked;
    Integer count;

    public TaskChecker(String name, Boolean checked, Integer count) {
        this.name = name;
        this.checked = checked;
        this.count = count;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setChecked(Boolean checked) {
      //  Log.e("EEE", name + "isChecked - " + checked);
        this.checked = checked;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Boolean getChecked() {
        return checked;
    }

    public Integer getCount() {
        return count;
    }


}
