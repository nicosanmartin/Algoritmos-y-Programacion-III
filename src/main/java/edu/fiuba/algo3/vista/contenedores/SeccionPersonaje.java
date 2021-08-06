package edu.fiuba.algo3.vista.contenedores;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class SeccionPersonaje extends GridPane implements Observer {
    final int numColumnas;
    final int numFilas;
    Personaje personaje;
    int columnaAnterior;
    int filaAnterior;

    public SeccionPersonaje(Personaje unPersonaje) {
        super();
        personaje = unPersonaje;
        numColumnas = 21;
        numFilas = 15;

        this.personaje.addObserver(this);

        for (int i = 0; i < numColumnas; i++) {
            for (int j = 0; j < numFilas; j++) {
                Pane celda = new Pane();
                celda.setMaxSize(32, 32);
                celda.setMinSize(32, 32);
                this.add(celda, i, j);
            }
        }

        this.columnaAnterior = personaje.obtenerPosicion().obtenerX() + (numColumnas / 2);
        this.filaAnterior = (numFilas / 2) - personaje.obtenerPosicion().obtenerY();

        this.update();
    }

    public void update() {

        int columnaActual = personaje.obtenerPosicion().obtenerX() + (numColumnas / 2);
        int filaActual = (numFilas / 2) - personaje.obtenerPosicion().obtenerY();


        for (Node node : this.getChildren()) {

            if (this.getColumnIndex(node) == columnaAnterior && this.getRowIndex(node) == filaAnterior) {
                ((Pane) node).setBackground(Background.EMPTY);
            }

            if (this.getColumnIndex(node) == columnaActual && this.getRowIndex(node) == filaActual) {

                String rutaPersonaje = this.calcularRutaDeImagen();
                Image imagen = this.crearImagenParaNodo(rutaPersonaje);
                ((Pane) node).setBackground(new Background(new BackgroundImage(imagen, null, null, null, null)));
            }
        }

        columnaAnterior = columnaActual;
        filaAnterior = filaActual;
    }


    public String calcularRutaDeImagen(){

        int personajeColumnaAnterior = this.columnaAnterior - (numColumnas / 2);
        int personajeFilaAnterior = (numFilas / 2) - this.filaAnterior;

        int deltaX = this.personaje.obtenerPosicion().obtenerX() - personajeColumnaAnterior;
        int deltaY = this.personaje.obtenerPosicion().obtenerY() - personajeFilaAnterior;

        if (deltaX > 1 || deltaX < -1 || deltaY > 1 || deltaY < -1){ deltaX = 0; deltaY = 0; }
        if (Math.abs(deltaX) == 1 && Math.abs(deltaY) == 1 ) { deltaX = 0; deltaY = 0; }

        return "Kirby(" + deltaX + "," + deltaY + ").png";

    }

    public Image crearImagenParaNodo(String rutaPersonaje) {
        Image image = null;

        try {
            FileInputStream input = new FileInputStream("src/main/resources/" + rutaPersonaje);
            image = new Image(input);
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo de imagen para el personaje");
        }
        return image;
    }
}
