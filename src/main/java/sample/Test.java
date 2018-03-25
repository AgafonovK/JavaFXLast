/*package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;

public class Test extends Application {



    @Override
    public void start(Stage stage) {

        int second;



        //Defining the axes

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Africa", "America")));
        //, "Asia", "Europe", "Oceania")));

        xAxis.setLabel("category");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population (In millions)");
                //Creating the Bar chart
        StackedBarChart<Number, String> stackedBarChart = new StackedBarChart<>(yAxis, xAxis);
        stackedBarChart.setTitle("Historic World Population by Region");

        //Prepare XYChart.Series objects by setting data
        XYChart.Series<Number, String> series1 = new XYChart.Series<>();
        series1.setName("1800");
      //  XYChart.Data<Number,String> dataSeries1 = new XYChart.Data<>(107,"Africa");
        XYChart.Data<Number,String> dataSeries2 = new XYChart.Data<>(200,"America");
        XYChart.Data<Number,String> dataSeries3 = new XYChart.Data<>(150,"America");
     //   series1.getData().add(dataSeries1);
        series1.getData().add(dataSeries2);
        series1.getData().add(dataSeries3);
       // series1.getData().add(new XYChart.Data<>(107, "Africa"));
       // series1.getData().add(new XYChart.Data<>(200,"America"));

        XYChart.Series<Number,String> series2 = new XYChart.Series<>();
        series2.setName("1900");
        //series2.getData().add(new XYChart.Data<>(133,"Africa"));
        XYChart.Data<Number,String > dataSeries4 = new XYChart.Data<>(256, "America");
       // series2.getData().add(new XYChart.Data<>(256,"America"));
        series2.getData().add(dataSeries4);
        final Label caption = new Label("Primer");
        caption.setTextFill(Color.WHITE);
        caption.setStyle("-fx-font: 12 arial;");

        //Setting the data to bar chart
        stackedBarChart.getData().addAll(series1, series2);
       // dataSeries2.getNode().getStyleClass().add("default-color9");
       // dataSeries3.getNode().getStyleClass().add("default-color9");
        dataSeries2.getNode().setStyle("-fx-bar-fill: black");
        dataSeries4.getNode().setStyle("-fx-bar-fill: black");



        for (final XYChart.Data<Number,String> data: series1.getData()) {
           data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
               caption.setTranslateX(e.getSceneX());
               caption.setTranslateY(e.getSceneY());
               caption.setText("YEEEEEEEE");
           });

            data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
               // caption.setDisable(true);
                caption.setText("");
            });
        }

                    /*addEventHandler(MouseEvent.MOUSE_MOVED, e -> {
                caption.setTranslateX(e.getSceneX());
                caption.setTranslateY(e.getSceneY());
                caption.setText("YEEEEEEEE");
            });

        }
*/
/*
        //Creating a Group object
        Group root = new Group(stackedBarChart,caption);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 400);
        //scene.getStylesheets().add("color.css");
        //Setting title to the Stage
        stage.setTitle("stackedBarChart");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}*/