package edu.fiuba.algo3.vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VistaDeBloquesAlgoritmo extends HBox{

    public VistaDeBloquesAlgoritmo(String unNombre) {
        super(15);

        this.setMaxWidth(215);
        this.setMinSize(215,88);
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(0, 20,0,10));

        this.setBackground(new Background(new BackgroundFill(
                Color.web("a9aaaa"),
                new CornerRadii(15,15,15,15,false),
                null
        )));

        this.setImage();
        Label nombre = new Label(unNombre);

        nombre.setFont(new Font(20));

        getChildren().add( nombre );
    }

    private void setImage(){
        ImageView imagen = new ImageView();

        try {
            FileInputStream input = new FileInputStream("src/main/resources/IconoAlgoritmo.png");
            Image image = new Image(input);
            imagen.setImage(image);

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra Icono");

        }

        this.getChildren().add(imagen);

    }
}
