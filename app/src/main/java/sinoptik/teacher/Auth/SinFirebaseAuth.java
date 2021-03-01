package sinoptik.teacher.Auth;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

import sinoptik.teacher.MainActivity;
import sinoptik.teacher.PhoneSaver.PhoneSaver;

public class SinFirebaseAuth {
    FirebaseAuth mAuth;
    private final String TAG = "SinFirebaseAuth";
    FirebaseUser current_user;

    public SinFirebaseAuth() {

        mAuth = FirebaseAuth.getInstance();
    }


    public void createUser(final String email, final String password, final AppCompatActivity activity) {
          mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.e(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            save_login_password(email,password,activity);
                            updateUI(user,activity);
                        } else {
                            Log.e(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null,activity);
                        }
                    }
                });
    }

    public void sign_in(final String email, final String password, final AppCompatActivity activity) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.e(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            save_login_password(email,password,activity);
                            updateUI(user,activity);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null,activity);
                        }
                    }
                });
    }


    void save_login_password(String login, String password,final AppCompatActivity activity){
        PhoneSaver phoneSaver=new PhoneSaver(activity);
        phoneSaver.setLOGIN(login);
        phoneSaver.setPASSWORD(password);
    }



    Boolean is_logged(){
        return current_user!=null;//?false:true;
    }

    private void updateUI(FirebaseUser user, final AppCompatActivity activity) {
        current_user=user;
     //   activity.stopProgressBar
        if (user != null) {
            Log.e(TAG, " user not null "+user.toString()+"");

            Intent intent = new Intent(activity,
                    MainActivity.class);
            activity.startActivity(intent);

        } else {
            Log.e(TAG, " user null");
        }
    }


    private void updateUI(FirebaseUser user) {
        current_user=user;
        if (user != null) {
            Log.e(TAG, " user not null "+user.toString()+"");
        } else {
            Log.e(TAG, " user null");
        }
    }
}
