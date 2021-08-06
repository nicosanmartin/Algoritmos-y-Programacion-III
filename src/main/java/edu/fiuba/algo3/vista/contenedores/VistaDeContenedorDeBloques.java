package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.controlador.SelectorDeContenedoresEventHandler;
import edu.fiuba.algo3.modelo.Bloques.Bloque;
import edu.fiuba.algo3.modelo.Bloques.BloqueContenedor;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VistaDeContenedorDeBloques extends HBox implements Observer {
    SectorAlgoritmo sectorAlgoritmo;
    BloqueContenedor contenedor;

    public VistaDeContenedorDeBloques(SectorAlgoritmo unSectorAlgoritmo, BloqueContenedor unContenedor){
        super();

        this.sectorAlgoritmo = unSectorAlgoritmo;
        this.contenedor = unContenedor;


        this.contenedor.addObserver(this);

    }

    @Override
    public void update() {
        Bloque ultimoBloque = this.contenedor.obtenerUltimoBloque();

        VistaDeBloque vistaDeBloqueActual = new VistaDeBloque(ultimoBloque);
        vistaDeBloqueActual.setOnMouseClicked(new SelectorDeContenedoresEventHandler(this.sectorAlgoritmo, this.contenedor));

        if (sectorAlgoritmo.obtenerContenedor() == ultimoBloque){
            BloqueContenedor unContenedor = this.sectorAlgoritmo.obtenerContenedor();

            VistaDeContenedorDeBloques nuevaVistaDeContenedor = new VistaDeContenedorDeBloques(this.sectorAlgoritmo, unContenedor);
            vistaDeBloqueActual.setOnMouseClicked(new SelectorDeContenedoresEventHandler(this.sectorAlgoritmo, unContenedor));
            this.setBackgroundAVista(vistaDeBloqueActual, ultimoBloque.obtenerID());

            this.getChildren().add( new VBox(vistaDeBloqueActual, nuevaVistaDeContenedor));

        } else {
            this.getChildren().add( vistaDeBloqueActual);

        }
    }


    private void setBackgroundAVista(VistaDeBloque unaVista, String bloqueID){

        try {
            FileInputStream input = new FileInputStream("src/main/resources/" + bloqueID + "Expandido.png");
            Image image = new Image(input);

            BackgroundImage backgroundImage = new BackgroundImage(image,
                    BackgroundRepeat.REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);

            unaVista.setBackground(new Background(backgroundImage));

        } catch (FileNotFoundException e) {
            System.out.println( this.getClass().getSimpleName() + " no encontro : ");

        }
    }
}
