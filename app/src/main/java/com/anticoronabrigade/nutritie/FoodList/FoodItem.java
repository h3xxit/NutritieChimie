package com.anticoronabrigade.nutritie.FoodList;

public class FoodItem {
    private String name;
    private int id;
    private double proteine, calorii, amino1, amino2, amino3, amino4, amino5, amino6, amino7, amino8, amino9;

    public FoodItem(int id, String name, double proteine, double calorii, double amino1, double amino2, double amino3, double amino4, double amino5, double amino6, double amino7, double amino8, double amino9) {
        this.id = id;
        this.name = name;
        this.proteine = proteine;
        this.calorii = calorii;
        this.amino1 = amino1;
        this.amino2 = amino2;
        this.amino3 = amino3;
        this.amino4 = amino4;
        this.amino5 = amino5;
        this.amino6 = amino6;
        this.amino7 = amino7;
        this.amino8 = amino8;
        this.amino9 = amino9;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProteine() {
        return proteine;
    }

    public void setProteine(double proteine) {
        this.proteine = proteine;
    }

    public double getCalorii() {
        return calorii;
    }

    public void setCalorii(double calorii) {
        this.calorii = calorii;
    }

    public double getAmino1() {
        return amino1;
    }

    public void setAmino1(double amino1) {
        this.amino1 = amino1;
    }

    public double getAmino2() {
        return amino2;
    }

    public void setAmino2(double amino2) {
        this.amino2 = amino2;
    }

    public double getAmino3() {
        return amino3;
    }

    public void setAmino3(double amino3) {
        this.amino3 = amino3;
    }

    public double getAmino4() {
        return amino4;
    }

    public void setAmino4(double amino4) {
        this.amino4 = amino4;
    }

    public double getAmino5() {
        return amino5;
    }

    public void setAmino5(double amino5) {
        this.amino5 = amino5;
    }

    public double getAmino6() {
        return amino6;
    }

    public void setAmino6(double amino6) {
        this.amino6 = amino6;
    }

    public double getAmino7() {
        return amino7;
    }

    public void setAmino7(double amino7) {
        this.amino7 = amino7;
    }

    public double getAmino8() {
        return amino8;
    }

    public void setAmino8(double amino8) {
        this.amino8 = amino8;
    }

    public double getAmino9() {
        return amino9;
    }

    public void setAmino9(double amino9) {
        this.amino9 = amino9;
    }
}
