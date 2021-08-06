package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import edu.fiuba.algo3.modelo.SectorBloques;
import edu.fiuba.algo3.modelo.SectorDibujo;
import edu.fiuba.algo3.vista.contenedores.SeccionPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

/**
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        SectorDibujo sectorDibujo = new SectorDibujo();
        SectorBloques sectorBloques = new SectorBloques();
        SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();
        Lapiz lapiz = new Lapiz(sectorDibujo);
        Personaje personaje = new Personaje(lapiz);

        stage.setTitle("AlgoBlocks");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/Kirbyicon.png")));
        stage.setResizable(false);
        SeccionPrincipal contenedorPrincipal = new SeccionPrincipal(sectorAlgoritmo, sectorBloques, sectorDibujo, personaje);
        Scene scene = new Scene(contenedorPrincipal,1280, 720);
        scene.getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("estilos.css")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}