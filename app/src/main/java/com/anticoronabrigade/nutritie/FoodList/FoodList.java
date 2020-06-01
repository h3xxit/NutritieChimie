package com.anticoronabrigade.nutritie.FoodList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.anticoronabrigade.nutritie.FoodDatabase;
import com.anticoronabrigade.nutritie.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FoodList extends AppCompatActivity implements RecyclerViewAdapter.OnNoteListener{

    private List<FoodItem> FoodItems;
    Spinner spinner;
    List<Comparator<FoodItem>> comparList;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        Toolbar toolbar = findViewById(R.id.toolbar_history);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        //recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        createComparators();
        initSpinner();
        addToList();

        adapter = new RecyclerViewAdapter(FoodItems, this);
        recyclerView.setAdapter(adapter);

    }

    void initSpinner(){
        spinner = findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Collections.sort(FoodItems, comparList.get(i));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void createComparators() {
        comparList = new ArrayList<>();
        comparList.add( new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return a.getName().compareTo(b.getName());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getProteine() - b.getProteine());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getCalorii() - b.getCalorii());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getAmino1() - b.getAmino1());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getAmino2() - b.getAmino2());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getAmino3() - b.getAmino3());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getAmino4() - b.getAmino4());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getAmino5() - b.getAmino5());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getAmino6() - b.getAmino6());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getAmino7() - b.getAmino7());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getAmino8() - b.getAmino8());
            }
        });
        comparList.add(new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem a, FoodItem b) {
                return (int)(a.getAmino9() - b.getAmino9());
            }
        });
    }

    void addToList() {
        FoodItems = new ArrayList<>();
        FoodItems.addAll(FoodDatabase.AllFoodItems);

        Collections.sort(FoodItems, comparList.get(0));
    }

    @Override
    public void onNoteClick(int position) {
        //TODO: Dialog pt adaugare la home
        SelectQuantityDialog selectQuantityDialog = new SelectQuantityDialog(getSupportFragmentManager(), this, FoodItems.get(position));
        selectQuantityDialog.show(selectQuantityDialog.getFrgManager(), "SelectQT");
        selectQuantityDialog.setCancelable(false);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
