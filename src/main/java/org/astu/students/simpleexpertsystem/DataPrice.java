package org.astu.students.simpleexpertsystem;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class DataPrice {
    private final SimpleStringProperty data = new SimpleStringProperty("");
    private final SimpleFloatProperty price = new SimpleFloatProperty(0.0f);

    public DataPrice(LocalDate date, float price) {
        setData(date.toString());
        setPrice(price);
    }

    public String getData() {
        return data.get();
    }

    public SimpleStringProperty dataProperty() {
        return data;
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public float getPrice() {
        return price.get();
    }

    public SimpleFloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }
}
