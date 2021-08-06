package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloques.Bloque;
import edu.fiuba.algo3.modelo.Excepciones.SinBloquesADevolverException;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import edu.fiuba.algo3.modelo.SectorBloques;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuardardorDeAlgoritmoEventHandler implements EventHandler{
    SectorAlgoritmo sectorAlgoritmo;
    SectorBloques sectorBloques;
    TextField textfield;
    Stage window;

    public GuardardorDeAlgoritmoEventHandler(TextField textfield, SectorAlgoritmo sectorAlgoritmo, SectorBloques sectorBloques, Stage window){
        this.textfield = textfield;
        this.sectorAlgoritmo = sectorAlgoritmo;
        this.sectorBloques = sectorBloques;
        this.window = window;
    }

    @Override
    public void handle(Event event) {

        try {
            Bloque[] bloques = sectorAlgoritmo.obtenerBloques();
            sectorBloques.guardarBloqueAlgoritmoPersonalizado(textfield.getText(), bloques);
            window.close();
        } catch (SinBloquesADevolverException e) {
            System.out.println("ERROR");
        }
    }
}
