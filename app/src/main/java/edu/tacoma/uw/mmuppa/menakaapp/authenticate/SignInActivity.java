package edu.tacoma.uw.mmuppa.menakaapp.authenticate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import edu.tacoma.uw.mmuppa.menakaapp.MainActivity;
import edu.tacoma.uw.mmuppa.menakaapp.R;

public class SignInActivity extends AppCompatActivity
        implements LoginFragment.LoginFragmentListener,
        RegisterFragment.RegisterFragmentListener {

    private boolean mLoginMode;
    private String mEmail;
    private boolean mRemember;
    public final static String SIGN_IN_FILE_PREFS = "edu.uw.tacoma.menakaapp.sign_in_file_prefs";
    public final static String EMAIL = "email";
    public final static String REMEMBER = "remember";
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mSharedPreferences = getSharedPreferences(SIGN_IN_FILE_PREFS, Context.MODE_PRIVATE);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.sign_in_fragment_container, new LoginFragment())
                .commit();
    }

    @Override
    public void launchRegisterFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.sign_in_fragment_container, new RegisterFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void login(String email, String pwd, boolean shouldRemember) {
        mLoginMode = true;
        mEmail = email;
        mRemember = shouldRemember;
        // TODO - Create the json object for passing with the login url
        // Execute Async Task with login url
        new AuthenticateAsyncTask().execute("");
        // TODO - The following code should happen in the onPostExecute
        // once the login is authenticated

    }

    @Override
    public void register(String email, String pwd) {
        // TODO - Create the json object for passing with the register url
        // Execute Async Task with register url
        // TODO - The following code should happen in the onPostExecute
        // once the login is authenticated
        new AuthenticateAsyncTask().execute("");
    }

    private class AuthenticateAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // TODO - Check for success
            if (mLoginMode) {
                // If login mode, show login message
                // If failed, show the messages
                // If successful, here's where the shared preferences
                // must be update to remember the user
                // Navigate to the next activity
                if (mRemember) {
                    mSharedPreferences.edit()
                            .putString(EMAIL, mEmail)
                            .putBoolean(REMEMBER, mRemember)
                            .commit();
                } else {
                    mSharedPreferences.edit()
                            .clear()
                            .commit();
                }
                Intent intent = new Intent(getApplicationContext()
                        , MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                // else register messages
                // Next navigation to launch Loginfragment
                getSupportFragmentManager().popBackStackImmediate();
            }
        }
    }
}