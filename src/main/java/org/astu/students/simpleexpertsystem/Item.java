package org.astu.students.simpleexpertsystem;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

// Товар
public class Item {
    private final SimpleStringProperty name = new SimpleStringProperty(""); // Наименование товара
    public List<DataPrice> dataPriceList = new ArrayList<>(); // Данные о ценах

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

    //Получение среднего значения
    public float getAverage(){
        return (float) dataPriceList.stream().mapToDouble(f->f.getPrice()).average().getAsDouble();

    }

    //Получение средне-квадратичного отклонения
    public float getDeviation(){
        float average = getAverage();
        float sum = 0;
        for(DataPrice dataPrice: dataPriceList){
            sum += Math.pow(dataPrice.getPrice() - average, 2);
        }
        return (float) Math.sqrt(sum/dataPriceList.size()-1);

    }

    // Проверка Условия 1 о стабильности продаж
    public boolean isStable(){
        float average = getAverage();
        float deviation = getDeviation();
        for(DataPrice dataPrice: dataPriceList){
            if(!(dataPrice.getPrice() - average < 2 * deviation)) return false;
        }
        return true;

    }

    // Проверка Условия 2 о периоде прогноза
    public boolean isTrueData(){
        float average = getAverage();
        float deviation = getDeviation();
        return average > 2 * deviation;

    }

    // Проверка Условия 3 о периодичности анализа
    public boolean isTruePeriod(){
        for(DataPrice dataPrice: dataPriceList){
            if(dataPrice.getPrice()<=0) return false;
        }
        return true;

    }

    // Оценка уровня достоверности
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
