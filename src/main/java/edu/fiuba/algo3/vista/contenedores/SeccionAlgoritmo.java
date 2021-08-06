package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import edu.fiuba.algo3.modelo.SectorDibujo;
import edu.fiuba.algo3.vista.botones.BotonDePrograma;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SeccionAlgoritmo extends HBox implements Observer {
    private SectorAlgoritmo sectorAlgoritmo;
    private ScrollPane ventana;


    public SeccionAlgoritmo(SectorAlgoritmo unSectorAlgoritmo, Personaje unPersonaje){
        super(15);

        this.setAlignment(Pos.CENTER);
        this.setMinSize(650,160);
        this.setPadding(new Insets(14,14,14,14));
        //this.setStyle("-fx-background-color: #282828");
        this.setBackground(new Background(new BackgroundFill(
                Color.web("282828"),
                new CornerRadii(80,80,80,80,false),
                null
        )));

        this.sectorAlgoritmo = unSectorAlgoritmo;
        this.sectorAlgoritmo.addObserver(this);

        setBotonDeEjecucion(unPersonaje);

        setVentana();

        setBotonesDeLimpieza();
    }

    @Override
    public void update() {

        if ( this.sectorAlgoritmo.estaVacio() ) setVentanaContent();

    }



    private void setBotonesDeLimpieza(){
        String botonID, rutaDeImagen;


        botonID = "BotonLimpiarSectorAlgoritmo";
        rutaDeImagen = "src/main/resources/IconoLimpiarAlgoritmo.png";

        BotonDePrograma botonLimpiarSectorAlgoritmo = new BotonDePrograma(botonID, rutaDeImagen);
        botonLimpiarSectorAlgoritmo.setStyle("-fx-background-color: transparent");
        botonLimpiarSectorAlgoritmo.setPickOnBounds(false);
        botonLimpiarSectorAlgoritmo.setMinSize(44,44);
        botonLimpiarSectorAlgoritmo.setMaxSize(44,44);

        botonLimpiarSectorAlgoritmo.setOnAction( new LimpiadorDeSectorAlgoritmoDeBloques( this.sectorAlgoritmo ) );


        this.getChildren().add(botonLimpiarSectorAlgoritmo);

    }

    private void setVentana(){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPannable(true);
        scrollPane.setMinSize(494,132);
        scrollPane.setMaxSize(494,132);
        scrollPane.setStyle("-fx-background-color: #3e3e3e");
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        this.ventana = scrollPane;

        setVentanaContent();


        this.getChildren().add(scrollPane);

    }

    private void setVentanaContent(){
        Pane panel = new Pane();

        try {
            FileInputStream input = new FileInputStream("src/main/resources/target.png");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            panel.getChildren().add(imageView);

        } catch (FileNotFoundException e) {
            System.out.println(" no encontro : tagert.png");

        }

        panel.setOnMouseClicked(new SelectorDeContenedoresEventHandler(sectorAlgoritmo, sectorAlgoritmo.obtenerContenedor()));

        VistaDeContenedorDeBloques VistaDeSectorAlgoritmo = new VistaDeContenedorDeBloques(this.sectorAlgoritmo, this.sectorAlgoritmo.obtenerContenedor());

        HBox holder = new HBox(panel, VistaDeSectorAlgoritmo);

        this.ventana.setContent(holder);

    }

    private void setBotonDeEjecucion(Personaje unPersonaje){
        String botonID, rutaDeImagen;


        botonID = "BotonEjecutarSectorAlgoritmo";
        rutaDeImagen = "src/main/resources/IconoEjecutarAlgoritmo.png";

        BotonDePrograma botonEjecutarSectorAlgoritmo = new BotonDePrograma(botonID, rutaDeImagen);

        botonEjecutarSectorAlgoritmo.setOnAction( new EjecutadorDeSectorAlgoritmoEventHandler(this.sectorAlgoritmo, unPersonaje) );
        botonEjecutarSectorAlgoritmo.setMinSize(44,44);
        botonEjecutarSectorAlgoritmo.setMaxSize(44,44);
        botonEjecutarSectorAlgoritmo.setStyle("-fx-background-color: transparent");
        botonEjecutarSectorAlgoritmo.setPickOnBounds(false);


        this.getChildren().add(botonEjecutarSectorAlgoritmo);

    }
}
