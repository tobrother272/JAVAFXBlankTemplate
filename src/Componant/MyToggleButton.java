/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componant;

import com.jfoenix.controls.JFXToggleButton;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


/**
 *
 * @author magictool
 */
public class MyToggleButton extends JFXToggleButton {
    private double width;
    private double height;
    private double x;
    private double y;
    private String text;
    private List<String> styleClass;
    private Pane apParent;  
    public MyToggleButton() {
        super();
    }
    public MyToggleButton(String text) {
        setText(text);
    }
    public MyToggleButton( double width, double height, double x, double y, List<String> styleClass,Pane apParent) {
        super();
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        initView(width, height, x, y, styleClass,apParent);
    }
    public MyToggleButton(String unfocusColor, double width, double height, double x, double y, String text, List<String> styleClass,Pane apParent) {
        setText(text);
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.text = text;
        initView(width, height, x, y, styleClass,apParent);
    }
    public void initView( double width, double height, double x, double y, List<String> styleClass,Pane apParent){
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setPrefSize(width, height);
        if (styleClass.size() != 0&&styleClass.get(0).length()!=0) {
            this.getStyleClass().setAll(styleClass);
        }else{
            this.getStyleClass().setAll("tog-primary");
        }
        if(apParent!=null){
            apParent.getChildren().add(this);
        }
    }
}
