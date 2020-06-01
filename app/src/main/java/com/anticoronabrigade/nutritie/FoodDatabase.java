package com.anticoronabrigade.nutritie;

import com.anticoronabrigade.nutritie.FoodList.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class FoodDatabase {
    public static List<FoodItem> AllFoodItems = new ArrayList<>();
    static {
        addItem("Mar", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        addItem("Par", 2, 3, 1, 4, 5, 6, 7, 8, 9, 10, 11);
        addItem("Mere", 2, 3, 1, 4, 5, 6, 7, 8, 9, 10, 11);
        addItem("Mere", 2, 3, 1, 4, 5, 6, 7, 8, 9, 10, 11);
    }

    static void addItem(String name, double proteine, double calorii, double amino1, double amino2, double amino3, double amino4, double amino5, double amino6, double amino7, double amino8, double amino9)
    {
        AllFoodItems.add(new FoodItem(AllFoodItems.size(), name, proteine, calorii, amino1, amino2, amino3, amino4, amino5, amino6, amino7, amino8, amino9));
    }
}
