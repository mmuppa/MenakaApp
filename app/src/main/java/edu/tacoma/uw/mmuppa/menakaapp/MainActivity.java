package edu.tacoma.uw.mmuppa.menakaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import edu.tacoma.uw.mmuppa.menakaapp.authenticate.SignInActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView emailTextView = findViewById(R.id.main_email_id);
        SharedPreferences sharedPreferences =
                getSharedPreferences(SignInActivity.SIGN_IN_FILE_PREFS, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(SignInActivity.EMAIL, "Unknown");
        emailTextView.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.about_id) {
            Toast.makeText(this, "This app is a sample", Toast.LENGTH_SHORT)
                    .show();
        } else if (item.getItemId() == R.id.help_id) {
            Toast.makeText(this, "Contact me for help", Toast.LENGTH_SHORT)
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }
}