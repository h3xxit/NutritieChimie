package com.anticoronabrigade.nutritie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    private TextView textViewTotalCalories;
    private TextView textViewAteCalories;
    private TextView textViewRemainedCalories;
    private TextView textViewMinus;
    private TextView textViewEqual;
    private TextView textViewAmino1;
    private TextView textViewAmino2;
    private TextView textViewAmino3;
    private TextView textViewAmino4;
    private TextView textViewAmino5;
    private TextView textViewAmino6;
    private TextView textViewAmino7;
    private TextView textViewAmino8;
    private TextView textViewAmino9;
    private TextView textViewProteins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Double kilos = getData();
        if(kilos == -1.0) {
            deleteDataFromFile();
            Toast.makeText(this, "Ceva nu a functionat cum ne asteptam. Te rugam sa iti reintroduci greuatea!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, HomePageActivity.class);
            startActivity(intent);
        }

        textViewTotalCalories = findViewById(R.id.textViewTotalCalories);
        textViewAteCalories = findViewById(R.id.textViewAteCalories);
        textViewRemainedCalories = findViewById(R.id.textViewRemainedCalories);
        textViewAmino1 = findViewById(R.id.textViewAmino1);
        textViewAmino2 = findViewById(R.id.textViewAmino2);
        textViewAmino3 = findViewById(R.id.textViewAmino3);
        textViewAmino4 = findViewById(R.id.textViewAmino4);
        textViewAmino5 = findViewById(R.id.textViewAmino5);
        textViewAmino6 = findViewById(R.id.textViewAmino6);
        textViewAmino7 = findViewById(R.id.textViewAmino7);
        textViewAmino8 = findViewById(R.id.textViewAmino8);
        textViewAmino9 = findViewById(R.id.textViewAmino9);
        textViewProteins = findViewById(R.id.textViewProteins);

        Integer total = getTotalCaloriesToEat(kilos);
        Integer eaten = getTotalAteCalories();

        textViewTotalCalories.setText(String.valueOf(total));
        textViewAteCalories.setText(String.valueOf(eaten));
        textViewRemainedCalories.setText(String.valueOf(total-eaten));

        textViewAmino1.setText("Amino1: " + getAmino(1));
        textViewAmino2.setText("Amino2: " + getAmino(2));
        textViewAmino3.setText("Amino3: " + getAmino(3));
        textViewAmino4.setText("Amino4: " + getAmino(4));
        textViewAmino5.setText("Amino5: " + getAmino(5));
        textViewAmino6.setText("Amino6: " + getAmino(6));
        textViewAmino7.setText("Amino7: " + getAmino(7));
        textViewAmino8.setText("Amino8: " + getAmino(8));
        textViewAmino9.setText("Amino9: " + getAmino(9));

        textViewProteins.setText("Proteine: " + getTotalProteins());
    }

    private Integer getTotalCaloriesToEat(Double kilos) {
        return (int) (2.2*15*kilos);
    }

    private Integer getTotalAteCalories() {
        return 0;
    }

    private Integer getAmino(Integer id) {
        return 0;
    }

    private Integer getTotalProteins() {
        return 0;
    }

    private Double getData() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.APP_FILE), Context.MODE_PRIVATE);
        String kilos = sharedPref.getString(getString(R.string.KILOS), null);
        if(kilos == null)
            return -1.0;
        return Double.valueOf(kilos);
    }

    private void deleteDataFromFile() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.APP_FILE), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.remove(getString(R.string.KILOS));
        editor.apply();
    }

}
