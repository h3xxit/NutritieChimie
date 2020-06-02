package com.anticoronabrigade.nutritie;

import com.anticoronabrigade.nutritie.FoodList.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class FoodDatabase {
    public static List<FoodItem> AllFoodItems = new ArrayList<>();
    static {
        /*
        <string name="amino1">Leucina</string>
        <string name="amino2">Isoleucina</string>
        <string name="amino3">Lizina</string>
        <string name="amino4">Metionina</string>
        <string name="amino5">Fenilalanina</string>
        <string name="amino6">Treonina</string>
        <string name="amino7">Triptofanul</string>
        <string name="amino8">Valina</string>
        <string name="amino9">Histidina</string>
         */
        addItem("Banane", 1.09, 89, 0.068, 0.028, 0.05, 0.008, 0.049, 0.028, 0.009, 0.047, 0.077);
        addItem("Capsuni", 0.67, 32, 0.034, 0.016, 0.026, 0.002, 0.019, 0.02, 0.008, 0.019, 0.012);
        addItem("Mere", 0.28, 57, 0.014, 0.006, 0.013, 0.001, 0.007, 0.006, 0.001, 0.013, 0.005);

    }

    static void addItem(String name, double proteine, double calorii, double amino1, double amino2, double amino3, double amino4, double amino5, double amino6, double amino7, double amino8, double amino9)
    {
        AllFoodItems.add(new FoodItem(AllFoodItems.size(), name, proteine, calorii, amino1, amino2, amino3, amino4, amino5, amino6, amino7, amino8, amino9));
    }
}
