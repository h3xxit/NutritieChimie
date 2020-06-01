package com.anticoronabrigade.nutritie.FoodList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.anticoronabrigade.nutritie.MainActivity;
import com.anticoronabrigade.nutritie.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class SelectQuantityDialog extends DialogFragment {
    private AlertDialog globalDialog;
    private FragmentManager frgManager;
    private EditText quantityET;
    private Long time;
    private Context FoodListContext;
    private FoodItem item;

    public SelectQuantityDialog(FragmentManager manager, Context context, FoodItem item){
        this.frgManager=manager;
        this.FoodListContext=context;
        this.item = item;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        try {
            LayoutInflater layoutInflater = getActivity().getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.layout_quantity, null);

            quantityET = view.findViewById(R.id.quantityInput);

            builder.setView(view)
                    .setTitle("Introduceti cantitatea (grame)")
                    .setNegativeButton("Anuleaza", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            globalDialog.dismiss();
                        }
                    })
                    .setPositiveButton("OK", null);

        } catch (NullPointerException e) {
            Toast toast=Toast.makeText(getContext(), "A aparut o problema", Toast.LENGTH_SHORT);
            toast.show();
        }
        globalDialog = builder.create();

        return globalDialog;
    }

    public FragmentManager getFrgManager() {
        return frgManager;
    }

    @Override
    public void onResume() {
        super.onResume();
        Button okButton = globalDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                performOkButtonAction();
            }
        });
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    private void performOkButtonAction() {
        double qt;
        try {
            qt = Double.parseDouble(quantityET.getText().toString());
        } catch (Exception ignored) {
            Toast.makeText(FoodListContext, "Select a non-null quantity", Toast.LENGTH_LONG).show();
            return;
        }
        if(qt == 0)
        {
            Toast.makeText(FoodListContext, "Select a non-null quantity", Toast.LENGTH_LONG).show();
            return;
        }
        writeToFile(item, qt);
        globalDialog.dismiss();
    }

    void writeToFile(FoodItem item, double quantity)
    {
        FileOutputStream fOut = null;
        OutputStreamWriter myOutWriter = null;
        try {
            fOut = new FileOutputStream(new File(FoodListContext.getFilesDir(), "FoodsConsumed"), true);
            myOutWriter = new OutputStreamWriter(fOut);

            myOutWriter.append(quantity + "").append("\n");
            myOutWriter.append(item.getId() + "").append("\n");
            myOutWriter.flush();
            myOutWriter.close();

            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(myOutWriter != null)
                    myOutWriter.close();
                if(fOut != null)
                    fOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(FoodListContext, "Nice " + quantity + ", id " + item.getId(), Toast.LENGTH_LONG).show();
    }
}
