package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.controlador.CreadorDeBloquesAlgoritmoEventHandler;
import edu.fiuba.algo3.controlador.MostradorDeVentanaParaGuardarAlgoritmoEventHandler;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import edu.fiuba.algo3.modelo.SectorBloques;
import edu.fiuba.algo3.vista.botones.BotonDePrograma;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Set;

public class SeccionBloquesAlgoritmo extends VBox implements Observer {
    private ScrollPane ventanaDeBloques;
    private SectorAlgoritmo sectorAlgoritmo;
    private SectorBloques sectorBloques;
    private BotonDePrograma botonGuardarBloqueAlgoritmo;

    public SeccionBloquesAlgoritmo(SectorAlgoritmo unSectorAlgoritmo, SectorBloques unSectorBloques){
        super();
        this.setMinWidth(290);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #ec3e3a");

        this.sectorAlgoritmo = unSectorAlgoritmo;
        this.sectorBloques = unSectorBloques;
        this.sectorBloques.addObserver(this);
        this.sectorAlgoritmo.addObserver(this);


        this.ventanaDeBloques = new ScrollPane();
        this.ventanaDeBloques.setStyle("-fx-background-color: transparent");
        this.ventanaDeBloques.setPannable(true);
        this.ventanaDeBloques.setMaxSize(215,565);
        this.ventanaDeBloques.setMinSize(215,565);
        this.ventanaDeBloques.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.ventanaDeBloques.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


        VBox holder = new VBox(ventanaDeBloques);
        holder.setMaxWidth(235);
        holder.setMinHeight(585);
        holder.setAlignment(Pos.CENTER);
        //holder.setStyle("-fx-background-color: #bbbcbc");

        holder.setBackground(new Background(new BackgroundFill(
                Color.web("bbbcbc"),
                new CornerRadii(15,15,0,0,false),
                null
        )));

        this.getChildren().add(holder);

        this.setBotonesDeBloquesAlgoritmo(unSectorBloques);

    }

    @Override
    public void update() {

        this.botonGuardarBloqueAlgoritmo.setDisable( this.sectorAlgoritmo.estaVacio());

        Set<String> nombres = sectorBloques.obtenerListaDeBloques();

        VBox columna = new VBox(16);
        columna.setMinSize(215,565);
        columna.setAlignment(Pos.TOP_CENTER);
        ventanaDeBloques.setContent(columna);

        for(String nombre : nombres){
            VistaDeBloquesAlgoritmo fila = new VistaDeBloquesAlgoritmo(nombre);
            fila.setOnMouseClicked(new CreadorDeBloquesAlgoritmoEventHandler(this.sectorAlgoritmo, this.sectorBloques, nombre));

            columna.getChildren().add(fila);

        }
    }


    private void setBotonesDeBloquesAlgoritmo (SectorBloques unSectorBloques){
        String botonID, rutaDeImagen;


        botonID = "GuardarBloqueAlgoritmo";
        rutaDeImagen = "src/main/resources/IconoGuardarAlgoritmo.png";

        this.botonGuardarBloqueAlgoritmo = new BotonDePrograma(botonID, rutaDeImagen);

        this.botonGuardarBloqueAlgoritmo.setBackground(new Background(new BackgroundFill(
                Color.web("e86060"),
                new CornerRadii(0,0,15,15,false),
                null
        )));

        this.botonGuardarBloqueAlgoritmo.setMinSize(235,80);
        this.botonGuardarBloqueAlgoritmo.setDisable(true);

        this.botonGuardarBloqueAlgoritmo.setOnAction(new MostradorDeVentanaParaGuardarAlgoritmoEventHandler(this.sectorAlgoritmo, unSectorBloques));


        this.getChildren().add(botonGuardarBloqueAlgoritmo);

    }
}
