package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class graphicsController implements Initializable {


    @FXML
    private Canvas can;

    private GraphicsContext graphicsContext;
    @FXML
    private Button btn;

    private int rectX = 0;
    private int rectY = 0;
    private int rectWidht=0;
    private int rectHight=0;
    private int color = 0;
    public void initialize(URL location, ResourceBundle resources) {
        graphicsContext = can.getGraphicsContext2D();
    }

    private void timer (){

        int i=0;
        while(i!=100){
            i++;

            rectX= rectX+i;
            System.out.println(i +" " + rectX);

            //Thread.sleep(1000);

        }
    }
    @FXML
    private void set (MouseEvent event) {
     //  timer();
        change();
        if(color == 4){
            color=0;
        }
        color++;
        rectWidht=rectWidht+10;
        rectHight=10;
        rectX=rectWidht;

    }


    //TO DO
    private void change (){
        System.out.println("X=" +rectX + " Widh=" +rectWidht +" Heig=" +rectHight + " Color " + color);
        Color color1 = null;
        switch (color){
            case 0:
                color1=Color.BLACK;
                break;
            case 1:
                color1=Color.BLUE;
                break;
            case 2:
                color1=Color.GREEN;
                break;
            case 3:
                color1=Color.RED;
                break;

        }

        graphicsContext.setFill(color1);
        graphicsContext.fillRect(rectX,rectY,rectWidht,rectHight);


    }


}
