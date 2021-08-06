package edu.fiuba.algo3.vista.alertas;

import edu.fiuba.algo3.controlador.GuardardorDeAlgoritmoEventHandler;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import edu.fiuba.algo3.modelo.SectorBloques;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaGuardarAlgoritmoPersonalizado {

    public static void display(String titulo, String mensaje, SectorAlgoritmo sectorAlgoritmo, SectorBloques sectorBloques){

        Stage ventana = new Stage();
        ventana.setResizable(false);
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(250);
        ventana.getIcons().add(new Image(VentanaGuardarAlgoritmoPersonalizado.class.getResourceAsStream("/Kirbyprogram.png")));
        Label label = new Label();
        label.setText(mensaje);

        TextField campoDeTexto = new TextField();
        campoDeTexto.setOnAction(new GuardardorDeAlgoritmoEventHandler(campoDeTexto, sectorAlgoritmo, sectorBloques, ventana));

        Button botonAceptar = new Button("Aceptar");
        botonAceptar.setOnAction(new GuardardorDeAlgoritmoEventHandler(campoDeTexto, sectorAlgoritmo, sectorBloques, ventana));

        Button botonCancelar = new Button("Cancelar");
        botonCancelar.setOnAction(e -> ventana.close());

        HBox layout2 = new HBox(10);
        layout2.getChildren().addAll(botonAceptar, botonCancelar);
        layout2.setAlignment(Pos.CENTER);

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(label, campoDeTexto, layout2);
        layout1.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout1, 325, 125);
        ventana.setScene(scene);
        ventana.showAndWait();
    }
}
