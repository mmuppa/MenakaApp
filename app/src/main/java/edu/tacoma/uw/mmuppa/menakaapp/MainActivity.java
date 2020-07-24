package edu.tacoma.uw.mmuppa.menakaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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