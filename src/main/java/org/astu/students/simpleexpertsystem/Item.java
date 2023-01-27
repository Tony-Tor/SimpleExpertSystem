package org.astu.students.simpleexpertsystem;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private final SimpleStringProperty name = new SimpleStringProperty("");
    public List<DataPrice> dataPriceList = new ArrayList<>();

    public Item(String name) {
        setName(name);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public float getAverage(){
        return (float) dataPriceList.stream().mapToDouble(f->f.getPrice()).average().getAsDouble();
    }

    public float getDeviation(){
        float average = getAverage();
        float sum = 0;
        for(DataPrice dataPrice: dataPriceList){
            sum += Math.pow(dataPrice.getPrice() - average, 2);
        }
        return (float) Math.sqrt(sum/dataPriceList.size()-1);
    }

    public boolean isStable(){
        float average = getAverage();
        float deviation = getDeviation();
        for(DataPrice dataPrice: dataPriceList){
            if(!(dataPrice.getPrice() - average < 2 * deviation)) return false;
        }
        return true;
    }

    public boolean isTrueData(){
        float average = getAverage();
        float deviation = getDeviation();
        return average > 2 * deviation;
    }

    public boolean isTruePeriod(){
        for(DataPrice dataPrice: dataPriceList){
            if(dataPrice.getPrice()<=0) return false;
        }
        return true;
    }

    public String getReliability(){
        boolean s = isStable();
        boolean d = isTrueData();
        boolean p = isTruePeriod();

        if(p){
            if(d){
                if (s) {
                    return "Зеленый";
                } else return "Желтый";
            } else {
                if (s) {
                    return "Желтый";
                } else return "Оранжевый";
            }
        } else {
            return "Красный";
        }
    }
}
