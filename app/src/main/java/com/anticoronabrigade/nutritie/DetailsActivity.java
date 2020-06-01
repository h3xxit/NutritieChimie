package com.anticoronabrigade.nutritie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.anticoronabrigade.nutritie.FoodList.FoodItem;
import com.anticoronabrigade.nutritie.FoodList.FoodList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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

    int eatenCalories = 0;
    int eatenProteins = 0;
    int[] amino = new int[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eatenCalories=0;
        eatenProteins=0;

        for(int i=0; i<20; i++) {
            amino[i]=0;
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailsActivity.this, FoodList.class));
            }
        });

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

        textViewTotalCalories.setText(String.valueOf(total));
        textViewAteCalories.setText(String.valueOf(eatenCalories));
        textViewRemainedCalories.setText(String.valueOf(total-eatenCalories));

        textViewAmino1.setText("Amino1: " + amino[1]);
        textViewAmino2.setText("Amino2: " + amino[2]);
        textViewAmino3.setText("Amino3: " + amino[3]);
        textViewAmino4.setText("Amino4: " + amino[4]);
        textViewAmino5.setText("Amino5: " + amino[5]);
        textViewAmino6.setText("Amino6: " + amino[6]);
        textViewAmino7.setText("Amino7: " + amino[7]);
        textViewAmino8.setText("Amino8: " + amino[8]);
        textViewAmino9.setText("Amino9: " + amino[9]);

        textViewProteins.setText("Proteine: " + eatenProteins + "/" + getTotalProteinsToEat(kilos));
    }



    @Override
    protected void onResume() {
        File myFile = new File(getFilesDir(), "FoodsConsumed");
        try {
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
            String aDataRow = "";
            String aBuffer = "";
            aDataRow = myReader.readLine();
            if(aDataRow == null || "".equals(aDataRow))
                throw new Exception();
            while ((aDataRow = myReader.readLine()) != null) {
                double quantity = Double.parseDouble(aDataRow);
                aDataRow = myReader.readLine();
                int id = Integer.parseInt(aDataRow);
                FoodItem item = FoodDatabase.AllFoodItems.get(id);
                eatenCalories += item.getCalorii()*(quantity/100);
                eatenProteins += item.getProteine()*(quantity/100);
                amino[1] += item.getAmino1()*(quantity/100);
                amino[2] += item.getAmino2()*(quantity/100);
                amino[3] += item.getAmino3()*(quantity/100);
                amino[4] += item.getAmino4()*(quantity/100);
                amino[5] += item.getAmino5()*(quantity/100);
                amino[6] += item.getAmino6()*(quantity/100);
                amino[7] += item.getAmino7()*(quantity/100);
                amino[8] += item.getAmino8()*(quantity/100);
                amino[9] += item.getAmino9()*(quantity/100);
            }
            myReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    private Integer getTotalCaloriesToEat(Double kilos) {
        return (int) (2.2*15*kilos);
    }


    private Integer getTotalProteinsToEat(Double kilos) {
        return (int)(2*kilos);
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

    @Override
    public void onBackPressed() {

    }
}
