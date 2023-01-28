package org.astu.students.simpleexpertsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML private LineChart priceChart;
    @FXML private CategoryAxis dataAxis;
    @FXML private NumberAxis priceAxis;
    @FXML private TableView<DataPrice> pricesTable;
    @FXML private TableColumn<DataPrice, String> dataColumn;
    @FXML private TableColumn<DataPrice, Float> priceColumn;
    @FXML private TableView<Item> itemTable;
    @FXML private TableColumn<Item, String> itemColumn;
    @FXML private Label itemName;
    @FXML private Label analysis;
    @FXML private Label average;
    @FXML private Label deviation;
    @FXML private Label sales;
    @FXML private Label reliability;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemTable.getItems().setAll(parseUserList());

        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void onClickItemTable(){
        Item item = itemTable.getSelectionModel().getSelectedItem();
        itemName.setText(item.getName());
        average.setText("" + item.getAverage());
        deviation.setText("" + item.getDeviation());
        analysis.setText("" + (item.isTruePeriod()?"Верный":"Неверный"));
        sales.setText("" + (item.isStable()?"Стабильные":"Нестабильные"));
        reliability.setText("" + item.getReliability());

        pricesTable.getItems().setAll(item.dataPriceList);

        priceChart.getData().clear();

        XYChart.Series series = new XYChart.Series();
        series.setName("Цена на " + item.getName());
        for(DataPrice dataPrice:item.dataPriceList){
            series.getData().add(new XYChart.Data(dataPrice.getData(), dataPrice.getPrice()));
        }

        priceChart.getData().add(series);
    }

    private List<Item> parseUserList(){
        List<Item> list = new ArrayList<>();
        Random r = new Random();
        Item item = new Item("Сосиски");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  80));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  85));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  84));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  83));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  82));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  81));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  80));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  79));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  78));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), 77));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), 76));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), 75));
        list.add(item);
        item = new Item("Сервелат");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  80));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  85));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  84));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  83));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  82));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  81));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  80));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  79));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  78));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), 77));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), 76));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), 200));
        list.add(item);
        item = new Item("Салями");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  20));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  40));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  100));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  1));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  50));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  30));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  70));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  99));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  33));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), 66));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), 43));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), 5));
        list.add(item);
        item = new Item("Суджук");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  20));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  40));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  100));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  1));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  50));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  30));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  70));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  200));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  33));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), 66));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), 43));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), 5));
        list.add(item);
        item = new Item("Зельц");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  20));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  40));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  100));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  0));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  50));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  30));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  70));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  200));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  33));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), 66));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), 43));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), 5));
        list.add(item);
        item = new Item("Шпикачка");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  80));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  85));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  84));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  83));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  82));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  81));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  80));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  0));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  78));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), 77));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), 76));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), 75));
        list.add(item);
        item = new Item("Докторская колбаса");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  80));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  85));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  84));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  83));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  82));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  81));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  80));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  79));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  78));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), 77));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), 0));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), 200));
        list.add(item);
        item = new Item("Купаты");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  20));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  40));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  100));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  0));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  50));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  30));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  70));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  99));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  33));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), 66));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), 43));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), 5));
        list.add(item);
        item = new Item("Сальтисон");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), r.nextInt(100)));
        list.add(item);
        item = new Item("Колбаса");
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,1, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,2, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,3, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,4, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,5, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,6, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,7, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,8, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,9, 1),  r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,10, 1), r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,11, 1), r.nextInt(100)));
        item.dataPriceList.add(new DataPrice(LocalDate.of(2022,12, 1), r.nextInt(100)));
        list.add(item);
        return list;
    }
}