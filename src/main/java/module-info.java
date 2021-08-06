module edu.fiuba.algo3 {
    requires javafx.controls;
    exports edu.fiuba.algo3;
    // Crear un opens para cada paquete asi los tests acceden a las clases
    opens edu.fiuba.algo3.modelo;
}
