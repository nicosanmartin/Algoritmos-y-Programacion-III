package edu.fiuba.algo3.vista.botones;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BotonDePrograma extends Button {

    public BotonDePrograma(String bloqueID, String imgPath){
        super();

        try { setImage(imgPath); }
        catch (FileNotFoundException e) { System.out.println( bloqueID + " no encontro icono: " + imgPath); }

        setMinSize(50, 50);
        setMaxSize(50, 50);
        setPrefSize(50, 50);

        this.setId(bloqueID);
    }

    protected void setImage(String imgPath) throws FileNotFoundException{
        FileInputStream input = new FileInputStream(imgPath);
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        this.setGraphic(imageView);
    }
}
