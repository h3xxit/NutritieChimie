package com.anticoronabrigade.nutritie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private TextView editTextKilos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(alreadyHaveData()) {
            Intent intent = new Intent(this, HomePageActivity.class);
            startActivity(intent);
            return;
        }

        buttonStart = findViewById(R.id.buttonStart);
        editTextKilos = findViewById(R.id.editTextKilos);

        final Context context = this;

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean saved = savedDataToFile();
                if(saved) {
                    Log.d("SAVED", "DATA SAVED");
                    Intent intent = new Intent(context, HomePageActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean alreadyHaveData() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.APP_FILE), Context.MODE_PRIVATE);
        String kilos = sharedPref.getString(getString(R.string.KILOS), null);
        if(kilos == null)
            return false;
        return true;
    }

    private boolean savedDataToFile() {
        String kilosFromText = String.valueOf(editTextKilos.getText());
        if(kilosFromText.contains(",") || kilosFromText.isEmpty()) {
            Toast.makeText(this, "Forma nu este corecta", Toast.LENGTH_LONG).show();
            return false;
        }

        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.APP_FILE), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.KILOS), kilosFromText);
        editor.apply();

        return true;
    }


}
