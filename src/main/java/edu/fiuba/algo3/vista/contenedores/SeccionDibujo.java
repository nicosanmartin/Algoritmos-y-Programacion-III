package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;

public class SeccionDibujo extends StackPane implements Observer {

    SeccionPersonaje seccionPersonaje;
    Canvas seccionCanvas;
    GraphicsContext gc;
    final int pixelRatio;
    Personaje personaje;
    SectorDibujo sectorDibujo;

    public SeccionDibujo(Personaje unPersonaje, SectorDibujo unSectorDibujo){
        super();

        this.setStyle("-fx-background-color: #282828");

        pixelRatio = 32;

        setMinSize(680,510);

        personaje = unPersonaje;
        this.sectorDibujo = unSectorDibujo;
        this.sectorDibujo.addObserver(this);
        seccionPersonaje = new SeccionPersonaje(unPersonaje);

        seccionCanvas = new Canvas(672,480);

        setCanvasImage("src/main/resources/background.png");

        gc = seccionCanvas.getGraphicsContext2D();
        gc.setLineWidth(5);
        gc.setStroke(Color.YELLOW.brighter());
        gc.beginPath();
        gc.moveTo(336, 240);

        getChildren().add(seccionCanvas);
        getChildren().add(seccionPersonaje);

        this.setMargin(seccionPersonaje, new Insets(15,14,15,14));
    }

    private void setCanvasImage (String ImgPath){
        try {
            FileInputStream input = new FileInputStream(ImgPath);
            ImageView imageView = new ImageView(new Image((input)));
            this.getChildren().add(imageView);

        }catch (FileNotFoundException e){
            System.out.println("Archivo background no encontrado");

        }
    }

    @Override
    public void update(){

        gc.clearRect(0, 0, 672, 480);

        HashMap<Posicion, HashSet<Posicion>> trazos = this.sectorDibujo.obtenerTrazos();

        for (Posicion posicionInicial: trazos.keySet())
            for (Posicion posicionFinal : trazos.get(posicionInicial))
                gc.strokeLine(336 + pixelRatio * posicionInicial.obtenerX(), 240 - pixelRatio * posicionInicial.obtenerY(),
                        336 + pixelRatio * posicionFinal.obtenerX(), 240 - pixelRatio * posicionFinal.obtenerY());
    }
}

