package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Bloques.Bloque;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class VistaDeBloque extends Pane {

    public VistaDeBloque( Bloque unBloque) {
        super();


        String imgPath = "src/main/resources/" + unBloque.obtenerID() + ".png";

        try {
            setImage(imgPath);

        } catch (FileNotFoundException e) {
            System.out.println(this.getClass().getSimpleName() + " no encontro : " + imgPath);

        }
    }

    private void setImage(String imgPath) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(imgPath);
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        getChildren().add(imageView);
        setMinHeight(image.getHeight());
        setMaxHeight(image.getHeight());
    }
}
