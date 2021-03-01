package  sinoptik.teacher.ui.login;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import sinoptik.teacher.Auth.SinFirebaseAuth;
import sinoptik.teacher.PhoneSaver.PhoneSaver;
import sinoptik.teacher.R;



public class LoginActivity extends AppCompatActivity{
    private final String TAG = "LoginActivity";

    private PhoneSaver phoneSaver;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SinFirebaseAuth sinFirebaseAuth=new SinFirebaseAuth();
        phoneSaver=new PhoneSaver(LoginActivity.this);

        String login=phoneSaver.getLOGIN();
        String password=phoneSaver.getPASSWORD();

        Log.e(TAG, "  login "+login+"; pass "+password);

        if(login!="" && password!="") {
            sinFirebaseAuth.sign_in(login, password, LoginActivity.this);
        }





       /* loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);
*/
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final Button regButton = findViewById(R.id.register);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
      //  Log.e(TAG, "  <--- try TAG");
        usernameEditText.setText("example_add_pupil@mail.ru");
        passwordEditText.setText("qwerty123");



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "  loginButton");
           //     loadingProgressBar.setVisibility(View.VISIBLE);
                sinFirebaseAuth.sign_in(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString(),
                        LoginActivity.this);

            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //      loadingProgressBar.setVisibility(View.VISIBLE);
                sinFirebaseAuth.createUser(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString(),
                        LoginActivity.this);
            }
        });

    }



  /*  private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }*/
}