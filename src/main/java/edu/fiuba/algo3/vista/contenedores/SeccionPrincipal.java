package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import edu.fiuba.algo3.modelo.SectorBloques;
import edu.fiuba.algo3.modelo.SectorDibujo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

public class SeccionPrincipal extends HBox {

    public SeccionPrincipal(SectorAlgoritmo sectorAlgoritmo, SectorBloques sectorBloques, SectorDibujo sectorDibujo, Personaje personaje){
        super();

        this.setMinSize(1280,720);
        this.setId("ContenedorPrincipal");
        this.setStyle("-fx-background-color: #1e1e1e");
        //this.setAlignment(Pos.CENTER);


        SeccionBloques seccionBloques = new SeccionBloques(sectorAlgoritmo, sectorDibujo, personaje);

        SeccionDibujo seccionDibujo = new SeccionDibujo(personaje, sectorDibujo);
        SeccionAlgoritmo seccionAlgoritmo = new SeccionAlgoritmo(sectorAlgoritmo, personaje);

        VBox SegundaColumna = new VBox(seccionDibujo, seccionAlgoritmo);
        SegundaColumna.setAlignment(Pos.CENTER);
        SegundaColumna.setMinWidth(700);
        SegundaColumna.setMargin(seccionAlgoritmo, new Insets(25,25,25,25));

        SeccionBloquesAlgoritmo seccionBloquesAlgoritmo =  new SeccionBloquesAlgoritmo(sectorAlgoritmo, sectorBloques);


        getChildren().addAll(seccionBloques, SegundaColumna, seccionBloquesAlgoritmo);

    }
}
