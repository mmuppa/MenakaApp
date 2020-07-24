package edu.tacoma.uw.mmuppa.menakaapp.authenticate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import edu.tacoma.uw.mmuppa.menakaapp.MainActivity;
import edu.tacoma.uw.mmuppa.menakaapp.R;

public class SignInActivity extends AppCompatActivity implements LoginFragment.LoginFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.sign_in_fragment_container, new LoginFragment())
                .commit();
    }

    @Override
    public void register() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.sign_in_fragment_container, new RegisterFragment())
               // .addToBackStack(null)
                .commit();
    }

    @Override
    public void login(String email, String pwd) {
        Toast.makeText(this, "Clicked login", Toast.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}