package sinoptik.teacher.PhoneSaver;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import sinoptik.teacher.BuildConfig;
import sinoptik.teacher.Pupil.Pupil;

public class PhoneSaver {
    private  final String TAG = this.getClass().getName();

    private static String PREFS_NAME = BuildConfig.APPLICATION_ID + ".prefs";
    private static String LOGIN = "LOGIN";
    private static String PASSWORD = "PASSWORD";
    private static String PUPILS = "PUPILS";
    SharedPreferences preferences;

    //----------------------------------------------------------------------------
    public  void setLOGIN(String login) {
        preferences.edit().putString(LOGIN,login).apply();
    }
    public  String getLOGIN() {
        return preferences.getString(LOGIN,"");
    }
    //----------------------------------------------------------------------------
    public void setPASSWORD(String password) {
        preferences.edit().putString(PASSWORD,password).apply();
    }
    public String getPASSWORD() {
        return preferences.getString(PASSWORD,"");
    }
    //----------------------------------------------------------------------------

    public PhoneSaver(Context context) {// context - activity
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }


    public void setPUPILS(List<Pupil> pupils){
        String json = new Gson().toJson(pupils);
        preferences.edit().putString(PUPILS,json).apply();
        Log.e(TAG, "pupils: "+json);
    }
    public List<Pupil> getPUPILS(){
        String json=preferences.getString(PUPILS,"");
        if(json!=""){
            Type itemsListType = new TypeToken<List<Pupil>>() {}.getType();
            return new Gson().fromJson(json,itemsListType);
        }
        else return null;

    }

    //public void saveTask




}
